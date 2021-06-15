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

import com.sesame.UniversityProject.Entities.Groupe;
import com.sesame.UniversityProject.Entities.Salle;
import com.sesame.UniversityProject.Repositories.SalleRepository;

@Controller
@RequestMapping("salle")
public class SalleControllerWeb {
	private final SalleRepository sr;

	@Autowired
	public SalleControllerWeb(SalleRepository sr) {
		super();
		this.sr = sr;
	}
	
	@GetMapping("list")
	public String showSalle(Model model)
	{
		model.addAttribute("salles",sr.findAll());
		return "Salle/listSalle";
	}
	
	@GetMapping("add")
	public String showAddSalleeForm(Salle salle) {
		return "Salle/addSalle";
	}

	@PostMapping("add")
	public String addSalle(@Valid Salle salle, BindingResult result, Model model) {
		sr.save(salle);
		return "redirect:list";
	}
	
	@GetMapping("update/{id}")
	public String FormupdateSalle(@PathVariable("id") int id, Model model) {
		Salle sl = sr.findByIdS(id);
		model.addAttribute("salles", sl);
		return "Salle/updateSalle";
	}
	
	@PostMapping("update/{id}")
	public String updatSalle(@PathVariable("id") int id, @Valid Salle salle, Model model)
	{
		Salle sl = sr.findByIdS(id);
		sl.setNomS(salle.getNomS());
		sl.setCapaciteS(salle.getCapaciteS());
		model.addAttribute("salles", sr.findAll());
		sr.save(sl);
		return"Salle/listSalle";
	}
	
	@GetMapping("delete/{id}")
	public String deleteSalle(@PathVariable("id") int id, Model model) {
		Salle salle = sr.findByIdS(id);
		sr.delete(salle);
		model.addAttribute("salles", sr.findAll());
		return "Salle/listSalle";
	}
	
	
}
