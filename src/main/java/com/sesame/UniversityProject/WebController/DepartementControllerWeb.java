package com.sesame.UniversityProject.WebController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.*;

import com.sesame.UniversityProject.Entities.Cours;
import com.sesame.UniversityProject.Entities.Departement;
import com.sesame.UniversityProject.Entities.Universite;
import com.sesame.UniversityProject.Repositories.DepartemenetRepository;
import com.sesame.UniversityProject.Repositories.UniversiteRepository;

@Controller
@RequestMapping("/departement/")
public class DepartementControllerWeb {
	private final DepartemenetRepository dr;
	private final UniversiteRepository ur;

	@Autowired
	public DepartementControllerWeb(DepartemenetRepository dr, UniversiteRepository ur) {
		super();
		this.dr = dr;
		this.ur = ur;
	}

	@GetMapping("list")
	public String listDepartement(Model model) {
		model.addAttribute("departements", dr.findAll());
		return "Departement/listDepartement";
	}

	@GetMapping("add")
	public String showAddDepartementForm(Departement Departement, Model model) {
		model.addAttribute("universites", ur.findAll());
		return "Departement/addDepartement";
	}

	@PostMapping("add")
	public String addDepartement(@Valid Departement departement, BindingResult result,
			@RequestParam(name = "universiteId", required = false) int id) {
		Universite universite = ur.findByIdU(id);
		departement.setUniversite(universite);
		dr.save(departement);
		return "redirect:list";

	}

	@GetMapping("update/{id}")
	public String showDepartementFormToUpdate(@PathVariable("id") int id, Model model) {
		
		Departement departement = dr.findByIdD(id);
		
		model.addAttribute("departements", departement);
		model.addAttribute("universites", ur.findAll());
		model.addAttribute("idUniversite", departement.getUniversite().getIdU());
		
		return "Departement/updateDepartement";
	}

	@PostMapping("update/{id}")
	public String updateDepartement(@PathVariable("id") int id, @Valid Departement departement, BindingResult result,
			Model model, @RequestParam(name = "universiteId", required = false) int p) {
		
		Universite universite = ur.findByIdU(p);
		Departement dept = dr.findByIdD(id);
		
		dept.setUniversite(universite);
		dept.setNomD(departement.getNomD());
		
		dr.save(dept);
		model.addAttribute("departements", dr.findAll());
		return "Departement/listDepartement";

	}

	@GetMapping("delete/{id}")
	public String deleteDepartement(@PathVariable("id") int id, Model model) {
		Departement departement = dr.findByIdD(id);
		dr.delete(departement);
		model.addAttribute("departements", dr.findAll());
		return "Departement/listDepartement";
	}

}
