package com.sesame.UniversityProject.WebController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.*;

import com.sesame.UniversityProject.Entities.Cours;
import com.sesame.UniversityProject.Repositories.CoursRepository;

@Controller
@RequestMapping("/cours/")
public class CoursControllerWeb {
	private final CoursRepository cr;

	@Autowired
	public CoursControllerWeb(CoursRepository cr) {
		super();
		this.cr = cr;
	}

	@GetMapping("list")
	public String listcours(Model model) {
		model.addAttribute("cours",cr.findAll());
		return "Cours/listCours";
	}

	@GetMapping("add")
	public String showAddCoursForm(Cours cours) {
		return "Cours/addCours";
	}

	@PostMapping("add")
	public String addProvider(@Valid Cours cours, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "Cours/addCours";
		}
		cr.save(cours);
		model.addAttribute("cours",cr.findAll());
		return "Cours/listCours";
	}

	@GetMapping("delete/{id}")
	public String deleteCours(@PathVariable("id") int id, Model model) {
		Cours cours = cr.findByIdC(id);
		cr.delete(cours);
		model.addAttribute("cours", cr.findAll());
		return "Cours/listCours";
	}

	@GetMapping("update/{id}")
	public String showCoursFormToUpdate(@PathVariable("id") int id, Model model) 
	{
	  Cours cours = cr.findByIdC(id);
	  model.addAttribute("cours", cours); 
	  return "Cours/updateCours"; 
	  }
	

	@PostMapping("update/{id}")
	public String updateCours(@PathVariable("id") int id, @Valid Cours cours, BindingResult result,Model model) {
		
		if (result.hasErrors()) {
			cours.setIdC(id);
			return "cours/updateCours";
		}
		
		Cours c = cr.findByIdC(id);
		c.setLibelleC(cours.getLibelleC());
		cr.save(c);
		model.addAttribute("cours", cr.findAll());
		return "Cours/listCours";
	}

}

