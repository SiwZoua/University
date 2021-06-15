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
import com.sesame.UniversityProject.Entities.Universite;

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

public class Departement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idD;
	private String nomD;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "universite_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)

	private Universite universite;

	public Universite getUniversite() {
		return universite;
	}

	public void setProvider(Universite universite) {
		this.universite = universite;
	}

	public int getIdD() {
		return idD;
	}

	public void setIdD(int idD) {
		this.idD = idD;
	}

	public String getNomD() {
		return nomD;
	}

	public void setNomD(String nomD) {
		this.nomD = nomD;
	}

	public void setUniversite(Universite universite) {
		this.universite = universite;
	}
}
