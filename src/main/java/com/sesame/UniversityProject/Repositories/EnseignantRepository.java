package com.sesame.UniversityProject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sesame.UniversityProject.Entities.Enseignant;
@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Integer> {

	Enseignant findByIdE(int id);
}
