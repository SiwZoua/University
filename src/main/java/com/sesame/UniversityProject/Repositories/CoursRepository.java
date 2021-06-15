package com.sesame.UniversityProject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sesame.UniversityProject.Entities.*;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Integer> {

	Cours findByIdC(int id);
}
