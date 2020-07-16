package com.projet.formationCertification.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Formateur {
	@Id
	
private String cin ; 
private String nom  ; 
private String prenom ; 
private String email ; 
private String numeroTelephone ; 
private String etat ;
@JsonBackReference(value="formateur")
@OneToMany(mappedBy="formateur")
private Collection<FormationFormateur> formationformateur ; 

public String getEtat() {
	return etat;
}
public void setEtat(String etat) {
	this.etat = etat;
}
/*
@ManyToMany(mappedBy = "formateurs")
private Collection<Formation> formations ;
*/
public Formateur() {
	super();
}

public Collection<FormationFormateur> getFormationformateur() {
	return formationformateur;
}
public void setFormationformateur(Collection<FormationFormateur> formationformateur) {
	this.formationformateur = formationformateur;
}
public String getCin() {
	return cin;
}
public void setCin(String cin) {
	this.cin = cin;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getNumeroTelephone() {
	return numeroTelephone;
}
public void setNumeroTelephone(String numeroTelephone) {
	this.numeroTelephone = numeroTelephone;
}
/*
public Collection<Formation> getFormations() {
	return formations;
}
public void setFormations(Collection<Formation> formations) {
	this.formations = formations;
	
} 
*/
}
