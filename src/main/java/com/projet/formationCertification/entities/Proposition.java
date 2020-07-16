package com.projet.formationCertification.entities;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity

public class Proposition {
	@Id
	@GeneratedValue
private Long id ; 
private Date dateProposition ; 
private String description ;
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "cin")

private Demandeur demandeur ;

public Proposition() {
	super();
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Date getDateProposition() {
	return dateProposition;
}
public void setDateProposition(Date dateProposition) {
	this.dateProposition = dateProposition;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Demandeur getDemandeur() {
	return demandeur;
}
public void setDemandeur(Demandeur demandeur) {
	this.demandeur = demandeur;
} 

}
