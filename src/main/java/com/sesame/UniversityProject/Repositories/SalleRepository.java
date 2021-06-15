package com.sesame.UniversityProject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sesame.UniversityProject.Entities.Salle;
@Repository
public interface SalleRepository extends JpaRepository<Salle, Integer> {

	@Query("select capaciteS from Salle where nomS=?1")
	int findCapacite(String nom);
	Salle findByIdS(int id);
	
	@Query("select nomS from Salle where capaciteS = ?1")
	String findName(int capacite);
}
