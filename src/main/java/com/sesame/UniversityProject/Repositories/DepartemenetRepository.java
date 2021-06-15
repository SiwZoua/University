package com.sesame.UniversityProject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sesame.UniversityProject.Entities.Departement;
@Repository
public interface DepartemenetRepository extends JpaRepository<Departement, Integer> {

	Departement findByIdD(int id);
	
}
