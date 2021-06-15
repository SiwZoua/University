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

import com.sesame.UniversityProject.Entities.Salle;
import com.sesame.UniversityProject.Entities.Universite;
import com.sesame.UniversityProject.Repositories.GroupeRepository;
import com.sesame.UniversityProject.Repositories.UniversiteRepository;

@Controller
@RequestMapping("universite")
public class UniversiteControllerWeb {

	private final UniversiteRepository ur;

	@Autowired
	public UniversiteControllerWeb(UniversiteRepository ur) {
		super();
		this.ur = ur;
	}

	@GetMapping("list")
	public String ShowUniversite(Model model) {
		model.addAttribute("universites", ur.findAll());
		return "Universite/listUniversite";
	}
	
	@GetMapping("add")
	public String showAddUniversiteeForm() {
		return "Universite/addUniversite";
	}

	@PostMapping("add")
	public String addUniversite(@Valid Universite universite) {
		ur.save(universite);
		return "redirect:list";
	}
	@GetMapping("update/{id}")
	public String FormupdateUniversite(@PathVariable("id") int id, Model model) {
		Universite unv = ur.findByIdU(id);
		model.addAttribute("universites", unv);
		return "Universite/updateUniversite";
	}
	
	@PostMapping("update/{id}")
	public String updatUniversite(@PathVariable("id") int id, @Valid Universite universite, Model model)
	{
		Universite unv = ur.findByIdU(id);
		unv.setNomU(universite.getNomU());
		unv.setAdresseU(universite.getAdresseU());
		model.addAttribute("universites", ur.findAll());
		ur.save(unv);
		return"Universite/listUniversite";
	}
	
	@GetMapping("delete/{id}")
	public String deleteSalle(@PathVariable("id") int id, Model model) {
		Universite universite = ur.findByIdU(id);
		ur.delete(universite);
		model.addAttribute("universites", ur.findAll());
		return "Universite/listUniversite";
	}
	
	

}
