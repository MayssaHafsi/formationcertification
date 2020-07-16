package com.projet.formationCertification.entities;

import java.util.Collection;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
/*
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_FORMATION",discriminatorType=DiscriminatorType.STRING , length=2)
*/
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public  class Formation  {
@Id
@GeneratedValue
private Long id ; 



private String nom ; 
@Temporal(TemporalType.DATE)

private Date datedebut ; 
@Temporal(TemporalType.DATE)

private Date datefin ; 
private String description ; 
private int capacite ; 
 

private int nbrPlaceReserve ;
private float prix;


@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "id_formateur")
private Formateur formateur;
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "id_user")
private User user;

@Temporal(TemporalType.DATE)

private Date dateLimiteInscription ; 
/*
@OneToMany(mappedBy="formation")
private  Collection<SeanceFormation> seances ; 
*/
/*@ManyToMany
@JoinTable(
    name = "formation_formateur", 
    joinColumns = {@JoinColumn(name = "id_formation") }, 
    inverseJoinColumns = { @JoinColumn(name = "id_formateur") }
)
*/

@JsonBackReference(value="formation")
@OneToMany(mappedBy="formation")
private Collection<FormationFormateur> formationformateur ; 


@JsonBackReference(value="formationNC")
@OneToMany(mappedBy="formationNC")
private Collection<InscriptionFormation> inscriptionsFormation ; 


@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "id_domaine")

//@JsonIgnoreProperties(value = "formations",allowSetters = true)
private Domaine domaine ;
private String type ;
private String cat;
private String niveau ;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "id_theme")

//@JsonIgnoreProperties(value = "formations",allowSetters = true)
private Theme theme;


@OneToMany(mappedBy = "formationCours")
//@JsonIgnoreProperties(value = "domaine", allowGetters = true, allowSetters = true)
@JsonBackReference(value="formationCours")
private Collection<Cours> cours ;


public Collection<Cours> getCours() {
	return cours;
}
public void setCours(Collection<Cours> cours) {
	this.cours = cours;
}


public Theme getTheme() {
	return theme;
}
public void setTheme(Theme theme) {
	this.theme = theme;
}

public Collection<FormationFormateur> getFormationformateur() {
	return formationformateur;
}

public void setFormationformateur(Collection<FormationFormateur> formationformateur) {
	this.formationformateur = formationformateur;
}

public String getNiveau() {
	return niveau;
}

public void setNiveau(String niveau) {
	this.niveau = niveau;
}
public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Formateur getFormateur() {
	return formateur;
}
public void setFormateur(Formateur formateur) {
	this.formateur = formateur;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public Date getDatedebut() {
	return datedebut;
}
public void setDatedebut(Date datedebut) {
	this.datedebut = datedebut;
}
public Date getDatefin() {
	return datefin;
}
public void setDatefin(Date datefin) {
	this.datefin = datefin;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getCat() {
	return cat;
}
public void setCat(String cat) {
	this.cat = cat;
}
public int getCapacite() {
	return capacite;
}
public void setCapacité(int capacité) {
	this.capacite = capacité;
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
/*public Collection<SeanceFormation> getSeances() {
	return seances;
}
public void setSeances(Collection<SeanceFormation> seances) {
	this.seances = seances;
}*/
/*public Collection<Formateur> getFormateurs() {
	return formateurs;
}
public void setFormateurs(Collection<Formateur> formateurs) {
	this.formateurs = formateurs;
}
*/

public Domaine getDomaine() {
	return domaine;
}

public void setDomaine(Domaine domaine) {
	this.domaine = domaine;
}

public float  getPrix() {
	return prix;
}

public void setPrix(float prix) {
	this.prix = prix;
}

public Formation() {
	super();
}

}
