package com.sesame.UniversityProject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sesame.UniversityProject.Entities.Seance;

public interface SeanceRepository extends JpaRepository<Seance, Integer> {

	Seance findByIdS(int id);
}
