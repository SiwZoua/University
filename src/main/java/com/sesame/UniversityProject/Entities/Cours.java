package com.sesame.UniversityProject.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Cours {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idC;
	private String libelleC;
	
	public int getIdC() {
		return idC;
	}
	public void setIdC(int idC) {
		this.idC = idC;
	}
	public String getLibelleC() {
		return libelleC;
	}
	public void setLibelleC(String libelleC) {
		this.libelleC = libelleC;
	}
}
