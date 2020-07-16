package com.projet.formationCertification.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/*
@Entity
@DiscriminatorValue("FNC")
*/
@Entity
public class FormationNonCertifiant extends Formation {
	
	public FormationNonCertifiant() {
		super();
		// TODO Auto-generated constructor stub
	}




}
