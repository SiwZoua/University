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

import com.sesame.UniversityProject.Entities.Departement;
import com.sesame.UniversityProject.Entities.Enseignant;
import com.sesame.UniversityProject.Repositories.EnseignantRepository;

@RestController
public class EnseignantController {

	@Autowired 
	EnseignantRepository er;
	
	@GetMapping("enseignant")
	public List <Enseignant> getAllEnseignants()
	{
		return er.findAll();
	}
	
	@GetMapping("enseignant/{id}")
	public Enseignant getEnseignant(@PathVariable int id)
	{
		return er.findByIdE(id);
	}
	
	@PostMapping("enseignant")
	public void addEnseignant(@RequestBody Enseignant enseignant)
	{
		er.save(enseignant);
	}
	
	@PutMapping("enseignant/{idE}")
	public Enseignant updateEnseignant(@RequestBody Enseignant enseignant,@PathVariable int idE)
	{
		Enseignant E = er.findByIdE(idE);
		E.setNomE(enseignant.getNomE());
		E.setAdresseE(enseignant.getAdresseE());
		E.setDiplomeE(enseignant.getDiplomeE());
		E.setDepartement(enseignant.getDepartement());
		return er.save(E);
	}
	
	@DeleteMapping("enseignant/{id}")
	public void deleteEnseignant(@PathVariable int id)
	{
		er.deleteById(id);
	}
	
	@DeleteMapping("enseignant")
	public void deleteAllEnseignant()
	{
		er.deleteAll();
	}
}
