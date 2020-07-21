package com.projet.formationCertification.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;


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

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "id_domaine")
private Domaine domaine ;

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

public Domaine getDomaine() {
	return domaine;
}


public void setDomaine(Domaine domaine) {
	this.domaine = domaine;
}
public Theme() {
	super();
	// TODO Auto-generated constructor stub
}
}
