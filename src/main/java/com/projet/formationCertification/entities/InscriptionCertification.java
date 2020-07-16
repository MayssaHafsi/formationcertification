package com.projet.formationCertification.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class InscriptionCertification {

	@Id
	@GeneratedValue
private Long id ;
private String etat ;
@Temporal(TemporalType.DATE)
private Date dateInscription ; 
//@JsonBackReference
	 @ManyToOne(fetch = FetchType.EAGER )
private Certification certification ; 
	//@JsonBackReference
		 @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
private Demandeur demandeurCertification ;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getEtat() {
			return etat;
		}
		public void setEtat(String etat) {
			this.etat = etat;
		}
		public Date getDateInscription() {
			return dateInscription;
		}
		public void setDateInscription(Date dateInscription) {
			this.dateInscription = dateInscription;
		}
		public Certification getCertification() {
			return certification;
		}
		public void setCertification(Certification certification) {
			this.certification = certification;
		}
	
		public Demandeur getDemandeurCertification() {
			return demandeurCertification;
		}
		public void setDemandeurCertification(Demandeur demandeurCertification) {
			this.demandeurCertification = demandeurCertification;
		}
		public InscriptionCertification() {
			super();
			// TODO Auto-generated constructor stub
		}
		 
		 
}
