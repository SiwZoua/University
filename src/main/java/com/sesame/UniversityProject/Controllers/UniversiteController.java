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

import com.sesame.UniversityProject.Entities.Universite;
import com.sesame.UniversityProject.Repositories.UniversiteRepository;

@RestController
public class UniversiteController {

	@Autowired
	UniversiteRepository ur;
	
	@GetMapping("universite")
	public List<Universite> getAllUniversities()
	{
		return ur.findAll();
	}
	
	@GetMapping("universite/{id}")
	public Universite getUniversity(@PathVariable int id)
	{
		return ur.findByIdU(id);
	}
	
	@PostMapping("universite")
	public void createUniversity(@RequestBody Universite u)
	{
		ur.save(u);
	}
	
	@PutMapping("universite/{idU}")
	public void updateUniversity(@RequestBody Universite universite,@PathVariable int idU)
	{
		Universite U = ur.findByIdU(idU);
		U.setNomU(universite.getNomU());
		U.setAdresseU(universite.getAdresseU());
		ur.save(U);
	}
	
	@DeleteMapping("universite/{id}")
	public void deleteUniversity(@PathVariable int id)
	{
		ur.deleteById(id);
	}
	
	@DeleteMapping("universite")
	public void deleteAllUniversities()
	{
		ur.deleteAll();
	}
	
}
