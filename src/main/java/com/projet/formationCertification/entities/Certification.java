package com.projet.formationCertification.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Certification {
	@Id
	@GeneratedValue
private Long id ;
private String titre ; 
@Temporal(TemporalType.DATE)
private Date dateCertification ;
private String timeCertification ; 
private String lieu ; 
private String description ; 
private String salleExamen ; 
private int capacite ; 
private int nbrPlaceReserve ; 
@Temporal(TemporalType.DATE)
private Date dateLimiteInscription ;
@JsonBackReference(value="certification")
@OneToMany(mappedBy="certification")
private Collection<InscriptionCertification> inscriptionCertifications ; 

public Collection<InscriptionCertification> getInscriptionCertifications() {
	return inscriptionCertifications;
}




public void setInscriptionCertifications(Collection<InscriptionCertification> inscriptionCertifications) {
	this.inscriptionCertifications = inscriptionCertifications;
}




@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "id_domaine")

private Domaine domaineCertification ;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "id_niveau")
private Niveau niveau ;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "id_user")
private User user ;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "id_demandeur")
private Demandeur demandeur ;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "id_formateur")
private Formateur formateur ;






@OneToMany(mappedBy = "certificationFormation")

@JsonBackReference(value="certificationFormation")
private Collection<FormationCertifiant> formationCS ;

@OneToMany(mappedBy = "certificationCours")
//@JsonIgnoreProperties(value = "domaine", allowGetters = true, allowSetters = true)
@JsonBackReference(value="certificationCours")
private Collection<CoursCertification> cours ;



public Collection<CoursCertification> getCours() {
	return cours;
}




public void setCours(Collection<CoursCertification> cours) {
	this.cours = cours;
}




public Collection<FormationCertifiant> getFormationCS() {
	return formationCS;
}




public void setFormationNCS(Collection<FormationCertifiant> formationCS) {
	this.formationCS = formationCS;
}




public Long getId() {
	return id;
}




public void setId(Long id) {
	this.id = id;
}




public String getTitre() {
	return titre;
}




public void setTitre(String titre) {
	this.titre = titre;
}




public Date getDateCertification() {
	return dateCertification;
}




public void setDateCertification(Date dateCertification) {
	this.dateCertification = dateCertification;
}




public String getTimeCertification() {
	return timeCertification;
}




public void setTimeCertification(String timeCertification) {
	this.timeCertification = timeCertification;
}




public String getSalleExamen() {
	return salleExamen;
}




public void setSalleExamen(String salleExamen) {
	this.salleExamen = salleExamen;
}




public String getLieu() {
	return lieu;
}




public void setLieu(String lieu) {
	this.lieu = lieu;
}




public String getDescription() {
	return description;
}




public void setDescription(String description) {
	this.description = description;
}




public int getCapacite() {
	return capacite;
}




public void setCapacite(int capacite) {
	this.capacite = capacite;
}




public int getNbrPlaceReserve() {
	return nbrPlaceReserve;
}




public void setNbrPlaceReserve(int nbrPlaceReserve) {
	this.nbrPlaceReserve = nbrPlaceReserve;
}




public Date getDateLimiteInscription() {
	return dateLimiteInscription;
}




public void setDateLimiteInscription(Date dateLimiteInscription) {
	this.dateLimiteInscription = dateLimiteInscription;
}




public Domaine getDomaineCertification() {
	return domaineCertification;
}




public void setDomaineCertification(Domaine domaineCertification) {
	this.domaineCertification = domaineCertification;
}

public Demandeur getDemandeur() {
	return demandeur;
}




public void setDemandeur(Demandeur demandeur) {
	this.demandeur = demandeur;
}

public User getUser() {
	return user;
}




public void setUser(User user) {
	this.user = user;
}

public Formateur getFormateur() {
	return formateur;
}


public void setFormateur(Formateur formateur) {
	this.formateur = formateur;
}




public Niveau getNiveau() {
	return niveau;
}




public void setNiveau(Niveau niveau) {
	this.niveau = niveau;
}




public Certification() {
	super();
	// TODO Auto-generated constructor stub
} 

}
