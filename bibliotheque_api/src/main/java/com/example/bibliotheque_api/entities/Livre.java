package com.example.bibliotheque_api.entities;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
public class Livre {
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitre() {
		return Titre;
	}
	public void setTitre(String titre) {
		Titre = titre;
	}
	public String getMaison_D_Edition() {
		return Maison_D_Edition;
	}
	public void setMaison_D_Edition(String maison_D_Edition) {
		Maison_D_Edition = maison_D_Edition;
	}
	public Date getDateDeSortie() {
		return DateDeSortie;
	}
	public void setDateDeSortie(Date dateDeSortie) {
		DateDeSortie = dateDeSortie;
	}
	public String getAuteur() {
		return Auteur;
	}
	public void setAuteur(String auteur) {
		Auteur = auteur;
	}
	public int getNombreDePage() {
		return NombreDePage;
	}
	public void setNombreDePage(int nombreDePage) {
		NombreDePage = nombreDePage;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public Date getDateDeLaDerniereConsultation() {
		return DateDeLaDerniereConsultation;
	}
	public void setDateDeLaDerniereConsultation(Date dateDeLaDerniereConsultation) {
		DateDeLaDerniereConsultation = dateDeLaDerniereConsultation;
	}
	public boolean isDisponible() {
		return Disponible;
	}
	public void setDisponible(boolean disponible) {
		Disponible = disponible;
	}
	@Id
	@GeneratedValue
	@Column(unique=true, nullable=false)
	 private long id;
	@Column(length=50,nullable=false)
	@OrderBy("Titre ASC")
	 private  String Titre;
	@Column(length=100,nullable=false,updatable=false)
	 private String Maison_D_Edition;
	@Column(nullable=false)
	 private  Date DateDeSortie;
	@Column(length=50,nullable=false)
	 private  String Auteur;
	@Column(nullable=false)
	 private  int NombreDePage;
	@Column(unique=true, nullable=false,updatable=false)
	 private int ISBN;
	 private Date DateDeLaDerniereConsultation;
	 private  boolean Disponible=true;
}
	 
	
