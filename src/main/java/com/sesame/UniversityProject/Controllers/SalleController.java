package com.sesame.UniversityProject.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sesame.UniversityProject.Repositories.SalleRepository;

import com.sesame.UniversityProject.Entities.Salle;


@RestController
public class SalleController {

	@Autowired
	SalleRepository sr;

	@GetMapping("/salle")
	public List<Salle> getAllSalles() {
		return sr.findAll();
	}
	
	
	@GetMapping("/salle/{id}")
	public Salle getSalle(@PathVariable int id) {
		return sr.findByIdS(id);
	}
	
	@PostMapping("/salle")
	public void createSalle(@RequestBody Salle salle)
	{
		sr.save(salle);
	}
	
	@PutMapping("/salle/{idS}")
	public Salle updateSalle(@RequestBody Salle salle,@PathVariable int idS)
	{
		Salle S = sr.findByIdS(idS);
		S.setNomS(salle.getNomS());
		S.setCapaciteS(salle.getCapaciteS());
		return sr.save(S);
	}
	
	@DeleteMapping("/salle/{id}")
	public void deleteSalle(@PathVariable int id)
	{
		 sr.deleteById(id);
	}
	
	@DeleteMapping("salle")
	public void deleteAllSalles()
	{
		sr.deleteAll();
	}
	
	@GetMapping("/salle/{nom}/capacite")
	public int getCapaciteBynomS (@PathVariable String nom)
	{
		return sr.findCapacite(nom);
	}
	
	@GetMapping("/salle/{capacite}/nom")
	public String getNameByCapacite(@PathVariable int capacite)
	{
		return sr.findName(capacite);
	}

}
