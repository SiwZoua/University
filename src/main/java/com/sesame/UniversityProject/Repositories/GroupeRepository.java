package com.sesame.UniversityProject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sesame.UniversityProject.Entities.Groupe;
@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Integer> {

	@Query("select nomG from Groupe where idG = ?1")
	String findnomG(int id);
	Groupe findByIdG(int id);
}
