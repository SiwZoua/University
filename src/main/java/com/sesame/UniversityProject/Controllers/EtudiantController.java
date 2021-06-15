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

import com.sesame.UniversityProject.Entities.Etudiant;
import com.sesame.UniversityProject.Repositories.EtudiantRepository;

@RestController
public class EtudiantController {

	@Autowired
	EtudiantRepository er;
	
	@GetMapping("/etudiant")
	public List<Etudiant> getAllEtudiants() {

		return er.findAll();
	}
	
	@GetMapping("/etudiant/{id}")
	public Etudiant getEtudiant(@PathVariable int id)
	{
		return er.findByIdE(id);
	}
	
	@PostMapping("/etudiant")
	public Etudiant createEtudiant(@RequestBody Etudiant e) {

		return er.save(e);
	}
	
	@PutMapping("etudiant/{idE}")
	public Etudiant updateEtudiant(@RequestBody Etudiant etudiant,@PathVariable int idE) {
		Etudiant E = er.findByIdE(idE);
		E.setNomE(etudiant.getNomE());
		E.setAdresseE(etudiant.getAdresseE());
		E.setNoteE(etudiant.getNoteE());
		E.setDateE(etudiant.getDateE());
		E.setGroupe(etudiant.getGroupe());
		
		return er.save(E);
	}
	
	@DeleteMapping("/etudiant/{id}")
	public void deleteEtudiant(@PathVariable int id)
	{
		er.deleteById(id);
	}
	
	@DeleteMapping("/etudiant")
	public void deleteAllEtudiants()
	{
		er.deleteAll();
	}
	
	@GetMapping("etudiant/id/note")
	public float getNoteE(@PathVariable int id)
	{
		return er.findnoteE(id);
	}
	
	

	@DeleteMapping("/etudiants/{id}")
	public void Delete(@PathVariable int id) {

		er.deleteById(id);
	}
	
	

}
