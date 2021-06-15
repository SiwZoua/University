package com.sesame.UniversityProject.Controllers;
/*
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesame.UniversityProject.Entities.Cours;
import com.sesame.UniversityProject.Repositories.CoursRepository;

@RestController
@RequestMapping("/cours")
*/
public class CoursController {

	/*
	@Autowired
	CoursRepository cr;

	@GetMapping("/listcours")
	public List<Cours> getAllCourses() {
		return cr.findAll();
	}

	@GetMapping("/listcours/{id}")
	public Cours getCourse(@PathVariable int id) {

		return cr.findByIdC(id);
	}

	@PostMapping("/addcours")
	public void createCourse(@RequestBody Cours cour) {

		cr.save(cour);
	}

	@PutMapping("/updatecours/{id}")
	public Cours updateCourse(@RequestBody Cours cours, @PathVariable int idP) {
		Cours C = cr.findByIdC(idP);
		C.setLibelleC(cours.getLibelleC());
		return cr.save(C);
	}

	@DeleteMapping("/deletecours/{id}")
	public void deleteCourse(@PathVariable int id) {

		cr.deleteById(id);
	}

	@DeleteMapping("/deletecours")
	public void deleteAllCourses() {

		cr.deleteAll();
	}
*/
}
