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

import com.sesame.UniversityProject.Entities.Cours;
import com.sesame.UniversityProject.Entities.Departement;
import com.sesame.UniversityProject.Entities.Enseignant;
import com.sesame.UniversityProject.Entities.Groupe;
import com.sesame.UniversityProject.Entities.Salle;
import com.sesame.UniversityProject.Entities.Seance;
import com.sesame.UniversityProject.Entities.Universite;
import com.sesame.UniversityProject.Repositories.*;

@Controller
@RequestMapping("seance")
public class SeanceControllerWeb {
	
	private final SeanceRepository sr;
	private final CoursRepository cr;
	private final EnseignantRepository er;
	private final SalleRepository salr;
	private final GroupeRepository gr;
	
	
	@Autowired
	public SeanceControllerWeb(SeanceRepository sr, CoursRepository cr, EnseignantRepository er, SalleRepository salr,
			GroupeRepository gr) {
		super();
		this.sr = sr;
		this.cr = cr;
		this.er = er;
		this.salr = salr;
		this.gr = gr;
	}
	
	@GetMapping("list")
	public String showListSeances(Model model)
	{
		model.addAttribute("seances", sr.findAll());
		return "Seance/listSeance";
	}
	
	
	@GetMapping("add")
	public String showAddSeancetForm(Seance seance, Model model) {
		model.addAttribute("enseignants", er.findAll());
		model.addAttribute("salles", salr.findAll());
		model.addAttribute("cours", cr.findAll());
		model.addAttribute("groupes",gr.findAll());
		return "Seance/xs";
	}

	@PostMapping("add")
	public String addSeance(@Valid Seance seance, BindingResult result,
			@RequestParam(name = "groupeId", required = false) int idG,
			@RequestParam(name = "salleId", required = false) int idS,
			@RequestParam(name = "enseignantId", required = false) int idE,
			@RequestParam(name = "coursId", required = false) int idC,
			Model model) {
		Groupe groupe = gr.findByIdG(idG);
		Salle salle = salr.findByIdS(idS);
		Enseignant enseignant = er.findByIdE(idE);
		Cours cours = cr.findByIdC(idC);
		seance.setGroupe(groupe);
		seance.setCours(cours);
		seance.setEnseignant(enseignant);
		seance.setSalle(salle);
		model.addAttribute("seances", sr.findAll());
		sr.save(seance);
		return "Seance/listSeance";

	}
	
	@GetMapping("update/{id}")
	public String Seance(@PathVariable("id") int id, Model model) {
		
		Seance seance = sr.findByIdS(id);
		
		model.addAttribute("seances", seance);
		model.addAttribute("groupes", gr.findAll());
		model.addAttribute("enseignants", er.findAll());
		model.addAttribute("salles", salr.findAll());
		model.addAttribute("cours", cr.findAll());
		
		model.addAttribute("idGroupe", seance.getGroupe().getIdG());
		model.addAttribute("idEnseignant", seance.getEnseignant().getIdE());
		model.addAttribute("idSalle", seance.getSalle().getIdS());
		model.addAttribute("idCours", seance.getCours().getIdC());
		
		return "Seance/updateSeance";
	}
	
	@PostMapping("update/{id}")
	public String updateSeance(@PathVariable("id") int id, @Valid Seance seance, BindingResult result,
			Model model, 
			@RequestParam(name = "groupeId", required = false) int idG,
			@RequestParam(name = "salleId", required = false) int idS,
			@RequestParam(name = "enseignantId", required = false) int idE,
			@RequestParam(name = "coursId", required = false) int idC
		) {
		
		Groupe groupe = gr.findByIdG(idG);
		Salle salle = salr.findByIdS(idS);
		Enseignant enseignant = er.findByIdE(idE);
		Cours cours = cr.findByIdC(idC);
		
		
		Seance sc = sr.findByIdS(id);
		
		sc.setDateS(seance.getDateS());
		sc.setCours(cours);
		sc.setEnseignant(enseignant);
		sc.setGroupe(groupe);
		sc.setSalle(salle);
		
		
		sr.save(sc);
		model.addAttribute("seances", sr.findAll());
		return "Seance/listSeance";

	}
	
	@GetMapping("delete/{id}")
	public String deleteSeance(@PathVariable("id") int id, Model model) {
		Seance seance = sr.findByIdS(id);
		sr.delete(seance);
		model.addAttribute("seances", sr.findAll());
		return "Seance/listSeance";
	}
	
}
