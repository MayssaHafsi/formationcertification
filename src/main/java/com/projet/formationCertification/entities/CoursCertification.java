package com.projet.formationCertification.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class CoursCertification {
	
	  @Id
	  @GeneratedValue
	    @Column(name = "id")

	    private Long id;
	  
	    @Column(name = "name")

	  private String name;
	    
	    @Column(name = "mimetype")
	  private String mimetype;

	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "id_certification")
	    private Certification certificationCours ;
	 
	  @Lob
	    @Column(name="pic")
	    private byte[] pic;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	public Certification getCertificationCours() {
		return certificationCours;
	}

	public void setCertificationCours(Certification certificationCours) {
		this.certificationCours = certificationCours;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public CoursCertification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CoursCertification( String name, String mimetype, byte[] pic) {
		super();
	
		this.name = name;
		this.mimetype = mimetype;
		
		this.pic = pic;
	}


}
