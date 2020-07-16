package com.projet.formationCertification.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Niveau {
	@Id
	@GeneratedValue
private Long id ; 
private String nom ; 

@OneToMany(mappedBy = "niveau")

@JsonBackReference(value="niveau")
private Collection<Certification> certifications;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "id_theme")
private Theme themeNiveau ;





public Niveau() {
	super();
	// TODO Auto-generated constructor stub
}


public Theme getThemeNiveau() {
	return themeNiveau;
}


public void setThemeNiveau(Theme themeNiveau) {
	this.themeNiveau = themeNiveau;
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

public Collection<Certification> getCertifications() {
	return certifications;
}

public void setCertifications(Collection<Certification> certifications) {
	this.certifications = certifications;
}


}
