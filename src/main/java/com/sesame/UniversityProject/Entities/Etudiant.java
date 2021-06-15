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
import com.sesame.UniversityProject.Entities.Groupe;

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

public class Etudiant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idE;
	private String nomE;
	private String adresseE;
	private float noteE;
	private Date dateE;
	
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

	public float getNoteE() {
		return noteE;
	}

	public void setNoteE(float noteE) {
		this.noteE = noteE;
	}

	public Date getDateE() {
		return dateE;
	}

	public void setDateE(Date dateE) {
		this.dateE = dateE;
	}
	
}
