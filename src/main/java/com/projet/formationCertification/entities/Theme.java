package com.projet.formationCertification.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Theme {
	@Id
	@GeneratedValue
	private Long id ; 

private String nom ; 
@OneToMany(mappedBy = "theme")
@JsonBackReference(value="theme")
private Collection<Formation> formations ;

@OneToMany(mappedBy = "themeNiveau")
@JsonBackReference(value="themeNiveau")
private Collection<Niveau> niveaus ;

public Collection<Formation> getFormations() {
	return formations;
}
public void setFormations(Collection<Formation> formations) {
	this.formations = formations;
}
public Collection<Niveau> getNiveaus() {
	return niveaus;
}
public void setNiveaus(Collection<Niveau> niveaus) {
	this.niveaus = niveaus;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public Theme() {
	super();
	// TODO Auto-generated constructor stub
}


}
