package com.sesame.UniversityProject.Entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sesame.UniversityProject.Entities.Departement;

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

public class Enseignant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idE;
	private String nomE;
	private String adresseE;
	private String diplomeE;
	
	/*Departement*/
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "departement_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	
	private Departement departement;

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public int getIdE() {
		return idE;
	}

	public void setIdE(int idE) {
		this.idE = idE;
	}

	public String getNomE() {
		return nomE;
	}

	public void setNomE(String nomE) {
		this.nomE = nomE;
	}

	public String getAdresseE() {
		return adresseE;
	}

	public void setAdresseE(String adresseE) {
		this.adresseE = adresseE;
	}

	public String getDiplomeE() {
		return diplomeE;
	}

	public void setDiplomeE(String diplomeE) {
		this.diplomeE = diplomeE;
	}
	
}
