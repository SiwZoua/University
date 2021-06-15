package com.sesame.UniversityProject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sesame.UniversityProject.Entities.Universite;

public interface UniversiteRepository extends JpaRepository<Universite, Integer> {

	Universite findByIdU(int id);
}
