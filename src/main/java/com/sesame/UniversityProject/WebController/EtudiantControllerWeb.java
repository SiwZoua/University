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
import com.sesame.UniversityProject.Entities.Etudiant;
import com.sesame.UniversityProject.Entities.Groupe;
import com.sesame.UniversityProject.Repositories.DepartemenetRepository;
import com.sesame.UniversityProject.Repositories.EnseignantRepository;
import com.sesame.UniversityProject.Repositories.EtudiantRepository;
import com.sesame.UniversityProject.Repositories.GroupeRepository;

@Controller
@RequestMapping("etudiant")
public class EtudiantControllerWeb {

	private final EtudiantRepository er;
	private final GroupeRepository gr;

	@Autowired
	public EtudiantControllerWeb(EtudiantRepository er, GroupeRepository gr) {
		super();
		this.er = er;
		this.gr = gr;
	}

	@GetMapping("list")
	public String showlistEtudiant(Model model) {
		model.addAttribute("etudiants", er.findAll());
		return "Etudiant/listEtudiant";
	}

	@GetMapping("add")
	public String showAddForm(Etudiant etudiant, Model model) {
		model.addAttribute("groupes", gr.findAll());
		return "Etudiant/addEtudiant";
	}

	@PostMapping("add")
	public String addEtudiant(@Valid Etudiant etudiant, BindingResult result,
			@RequestParam(name = "groupeId", required = false) int id) {
		Groupe groupe = gr.findByIdG(id);
		etudiant.setGroupe(groupe);
		er.save(etudiant);
		return "redirect:list";
	}

	@GetMapping("update/{id}")
	public String showupdateForm(@PathVariable("id") int id, Model model) {

		Etudiant etudiant = er.findByIdE(id);

		model.addAttribute("etudiants", etudiant);
		model.addAttribute("groupes", gr.findAll());
		model.addAttribute("idGroupe", etudiant.getGroupe().getIdG());

		return "Etudiant/updateEtudiant";
	}

	@PostMapping("update/{id}")
	public String updateEtudiant(@PathVariable("id") int id, @Valid Etudiant etudiant, BindingResult result,
			Model model, @RequestParam(name = "groupeId", required = false) int p) {

		Groupe groupe = gr.findByIdG(p);
		Etudiant Et = er.findByIdE(id);

		Et.setGroupe(groupe);
		Et.setNomE(etudiant.getNomE());
		Et.setNoteE(etudiant.getNoteE());
		Et.setAdresseE(etudiant.getAdresseE());
		Et.setDateE(etudiant.getDateE());

		er.save(Et);
		model.addAttribute("etudiants", er.findAll());
		return "Etudiant/listEtudiant";
	}

	@GetMapping("delete/{id}")
	public String deleteEtudiant(@PathVariable("id") int id, Model model) {
		Etudiant etudiant = er.findByIdE(id);
		er.delete(etudiant);
		model.addAttribute("etudiants", er.findAll());
		return "Etudiant/listEtudiant";
	}

}
