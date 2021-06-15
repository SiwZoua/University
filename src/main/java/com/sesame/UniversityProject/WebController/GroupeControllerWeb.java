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

import com.sesame.UniversityProject.Entities.Cours;
import com.sesame.UniversityProject.Entities.Etudiant;
import com.sesame.UniversityProject.Entities.Groupe;
import com.sesame.UniversityProject.Repositories.GroupeRepository;

@Controller
@RequestMapping("groupe")
public class GroupeControllerWeb {

	private final GroupeRepository gr;

	@Autowired
	public GroupeControllerWeb(GroupeRepository gr) {
		super();
		this.gr = gr;
	}

	@GetMapping("list")
	public String ShowGroups(Model model) {
		model.addAttribute("groupes", gr.findAll());
		return "Groupe/listGroupe";
	}

	@GetMapping("add")
	public String showAddGroupeForm(Groupe groupe) {
		return "Groupe/addGroupe";
	}

	@PostMapping("add")
	public String addGroupe(@Valid Groupe groupe) {
		gr.save(groupe);
		return "redirect:list";
	}

	@GetMapping("update/{id}")
	public String FormupdateGroupe(@PathVariable("id") int id, Model model) {
		Groupe grp = gr.findByIdG(id);
		model.addAttribute("groupes", grp);
		return "Groupe/updateGroupe";
	}
	
	@PostMapping("update/{id}")
	public String updateGroupe(@PathVariable("id") int id, @Valid Groupe groupe, Model model)
	{
		Groupe grp = gr.findByIdG(id);
		grp.setNomG(groupe.getNomG());
		model.addAttribute("groupes", gr.findAll());
		gr.save(grp);
		return"Groupe/listGroupe";
	}
	
	@GetMapping("delete/{id}")
	public String deleteGroupe(@PathVariable("id") int id, Model model) {
		Groupe groupe = gr.findByIdG(id);
		gr.delete(groupe);
		model.addAttribute("groupes", gr.findAll());
		return "Groupe/listGroupe";
	}

}
