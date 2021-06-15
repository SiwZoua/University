package com.sesame.UniversityProject.Repositories;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.sesame.UniversityProject.Entities.Etudiant;
import com.sesame.UniversityProject.Entities.Groupe;

import org.springframework.data.rest.core.annotation.RestResource;
@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

	@Query("select noteE from Etudiant where idE = ?1")
	float findnoteE(int id);
	
	Etudiant findByIdE(int id);
	
	@RestResource(path="/Q1")
	@Query("select e from Etudiant e order by noteE DESC ")
	List<Etudiant> FindByNote();
	
	/*@RestResource(path="/Q2")
	List<Etudiant> findByNomEContainingAndNomEContaining(@PathParam("x") String x ,@PathParam("y") String y);*/
	
	@RestResource(path="/Q3/{x}/{y}")
	List<Etudiant> findByNomEContainingAndNomEContaining(@PathVariable("x") String x ,@PathVariable("y") String y);
	
	@RestResource(path="/Q3")
	@Query("select e.groupe from Etudiant e where e.dateE = (Select Min(e.dateE) from Etudiant e)")
	List<Groupe> FindByDateMin();
	@RestResource(path="/Q4")
	@Query("select avg(e.noteE) from Etudiant e")
	float find_moy();
}
