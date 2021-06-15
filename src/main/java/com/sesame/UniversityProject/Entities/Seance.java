package com.sesame.UniversityProject.Entities;

import java.util.Date;

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
import com.sesame.UniversityProject.Entities.Cours;
import com.sesame.UniversityProject.Entities.Groupe;
import com.sesame.UniversityProject.Entities.Enseignant;
import com.sesame.UniversityProject.Entities.Salle;

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

public class Seance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idS;
	private Date dateS;
	
	/*Enseignant*/
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "enseignant_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	
	private Enseignant enseignant;

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	
	/*Salle*/
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "salle_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	
	private Salle salle;

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	
	/*Cours*/
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cours_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	
	private Cours cours;

	public Cours getCours() {
		return cours;
	}

	public void setCourse(Cours cours) {
		this.cours = cours;
	}
	
	/*Groupe*/
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "groupe_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	
	private Groupe groupe;

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public int getIdS() {
		return idS;
	}

	public void setIdS(int idS) {
		this.idS = idS;
	}

	public Date getDateS() {
		return dateS;
	}

	public void setDateS(Date dateS) {
		this.dateS = dateS;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}
}
