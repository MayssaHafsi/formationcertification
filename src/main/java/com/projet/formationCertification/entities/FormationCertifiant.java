package com.projet.formationCertification.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



/*@Entity
@DiscriminatorValue("FC")*/
@Entity
public class FormationCertifiant extends Formation {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_certificationFormation")

	private Certification certificationFormation ;

	public Certification getCertificationFormation() {
		return certificationFormation;
	}

	public void setCertificationFormation(Certification certificationFormation) {
		this.certificationFormation = certificationFormation;
	}

	public FormationCertifiant() {
		super();
		// TODO Auto-generated constructor stub
	}

}
