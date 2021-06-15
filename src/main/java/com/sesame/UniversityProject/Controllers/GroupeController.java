package com.sesame.UniversityProject.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesame.UniversityProject.Entities.Groupe;
import com.sesame.UniversityProject.Repositories.GroupeRepository;

@RestController
public class GroupeController {

	@Autowired
	GroupeRepository gr;
	
	@GetMapping("/groupe")
	public List<Groupe> getAllgroupes() {

		return gr.findAll();
	}
	
	@GetMapping("/groupe/{id}")
	public Groupe getgroupe(@PathVariable int id) {

		return gr.findByIdG(id);
	}
	
	
	@PostMapping("/groupe")
	public void createGroupe(@RequestBody Groupe g) {

		gr.save(g);
	}
	
	@PutMapping("/groupe/{idG}")
	public Groupe updateGroupe(@RequestBody Groupe groupe,@PathVariable int idG)
	{
		Groupe G = gr.findByIdG(idG);
		G.setNomG(groupe.getNomG());
		return gr.save(G);
	}
	
	@DeleteMapping("/groupe/{id}")
	public void deleteGroupe(@PathVariable int id)
	{
		gr.deleteById(id);
	}
	
	@DeleteMapping("/groupe")
	public void deleteAllGroupes()
	{
		gr.deleteAll();
	}
	
	@GetMapping("/groupe/{id}/nomG")
	public String getGroupeNameByid(@PathVariable int id) {

		return gr.findnomG(id);
	}
}
