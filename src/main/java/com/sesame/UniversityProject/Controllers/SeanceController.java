package com.sesame.UniversityProject.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sesame.UniversityProject.Entities.Seance;
import com.sesame.UniversityProject.Repositories.SeanceRepository;

@RestController
public class SeanceController {

	@Autowired 
	SeanceRepository sr;
	
	@GetMapping("seance")
	public List<Seance> getAllSeances()
	{
		return sr.findAll();
	}
	
	@GetMapping("seance/{id}")
	public Seance getSeance(@PathVariable int id)
	{
		return sr.findByIdS(id);
	}
	
	@PostMapping("seance")
	public void createSeance(@RequestBody Seance s)
	{
		sr.save(s);
	}
	
	@PutMapping("seance/{idS}")
	public void updateSeance(@RequestBody Seance seance,@PathVariable int idS)
	{
		Seance S = sr.findByIdS(idS);
		S.setSalle(seance.getSalle());
		S.setCours(seance.getCours());
		S.setDateS(seance.getDateS());
		S.setEnseignant(seance.getEnseignant());
		S.setGroupe(seance.getGroupe());
		sr.save(S);
	}
}
