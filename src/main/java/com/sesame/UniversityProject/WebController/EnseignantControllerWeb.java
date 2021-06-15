package com.sesame.UniversityProject.WebController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sesame.UniversityProject.Entities.Departement;
import com.sesame.UniversityProject.Entities.Enseignant;
import com.sesame.UniversityProject.Entities.Universite;
import com.sesame.UniversityProject.Repositories.DepartemenetRepository;
import com.sesame.UniversityProject.Repositories.EnseignantRepository;

@Controller
@RequestMapping("enseignant")
public class EnseignantControllerWeb {

	private final EnseignantRepository er;
	private final DepartemenetRepository dr;
	
	@Autowired
	public EnseignantControllerWeb(EnseignantRepository er, DepartemenetRepository dr) {
		super();
		this.er = er;
		this.dr = dr;
	}
		@GetMapping("list")
		public String showEnseignant(Model model)
		{
			model.addAttribute("enseignants", er.findAll());
			return "Enseignant/listEnseignant";
		}
		
		@GetMapping("add")
		public String showAddForm(Enseignant enseignant,Model model)
		{
			model.addAttribute("departements", dr.findAll());
			return "Enseignant/addEnseignant";
		}
		
		@PostMapping("add")
		public String addEnseignant(@Valid Enseignant enseignant,BindingResult result,
				@RequestParam(name = "departementId", required = false) int id)
		{
			Departement departement = dr.findByIdD(id);
			enseignant.setDepartement(departement);
			er.save(enseignant);
			return "redirect:list";
		}
		
		@GetMapping("update/{id}")
		public String showUpdateForm(@PathVariable("id") int id, Model model)
		{
			Enseignant enseignant = er.findByIdE(id);
			
			model.addAttribute("enseignants", enseignant);
			model.addAttribute("departements", dr.findAll());
			model.addAttribute("idDepartement", enseignant.getDepartement().getIdD());
			
			return "Enseignant/updateEnseignant";
		}
	
		@PostMapping("update/{id}")
		public String updateEnseignant(@PathVariable("id") int id, @Valid Enseignant enseignant,
				Model model, @RequestParam(name = "departementId", required = false) int p) {
			
			Departement departement = dr.findByIdD(p);
			Enseignant ens = er.findByIdE(id);
			
			ens.setDepartement(departement);
			ens.setNomE(enseignant.getNomE());
			ens.setDiplomeE(enseignant.getDiplomeE());
			ens.setAdresseE(enseignant.getAdresseE());
			
			er.save(ens);
			model.addAttribute("enseignants", er.findAll());
			return "Enseignant/listEnseignant";

		}
		
		@GetMapping("delete/{id}")
		public String deleteEnseignant(@PathVariable("id") int id, Model model) {
			Enseignant enseignant = er.findByIdE(id);
		er.delete(enseignant);
			model.addAttribute("enseignants", er.findAll());
			return "Enseignant/listEnseignant";
		}
	
	
	
	
}
