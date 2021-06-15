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
import com.sesame.UniversityProject.Repositories.DepartemenetRepository;

@RestController
public class DepartementController {

	@Autowired
	DepartemenetRepository dr;

	@GetMapping("departement")
	public List<Departement> getAllDepartments() {
		return dr.findAll();
	}
	
	@GetMapping("departement/{id}")
	public Departement getDepartment(@PathVariable int id)
	{
		return dr.findByIdD(id);
	}
	
	@PostMapping("departement")
	public void addDepartment(@RequestBody Departement departement)
	{
		dr.save(departement);
	}
	
	@PutMapping("/departement/{idD}")
	public Departement updateDepartment(@RequestBody Departement departement,@PathVariable int idD)
	{
		Departement D = dr.findByIdD(idD);
		D.setNomD(departement.getNomD());
		D.setUniversite(departement.getUniversite());
		return dr.save(D);
	}
	
	@DeleteMapping("/departement/{id}")
	public void deleteDepartment(@PathVariable int id)
	{
		dr.deleteById(id);
	}
	
	@DeleteMapping("/departement")
	public void deleteAllDepartments()
	{
		dr.deleteAll();
	}
}
