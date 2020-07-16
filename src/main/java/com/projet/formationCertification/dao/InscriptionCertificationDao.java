package com.projet.formationCertification.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.formationCertification.entities.InscriptionCertification;
import com.projet.formationCertification.entities.InscriptionFormation;

public interface InscriptionCertificationDao extends JpaRepository<InscriptionCertification, Long>{

	@Query("SELECT u FROM InscriptionCertification u WHERE u.id = :status")
	InscriptionCertification find(
	  @Param("status") Long id);
	
	
	
	
	@Query("SELECT v FROM InscriptionCertification v WHERE v.etat='EN ATTENTE' ")
	Page<InscriptionCertification> findAllPage(Pageable p );
	
	

	@Query("SELECT v FROM InscriptionCertification v WHERE v.etat='CONFIRME' ")
	Page<InscriptionCertification> findAllPageConfirmee(Pageable p );
	
	@Query("SELECT v FROM InscriptionCertification v WHERE v.etat='REFUSE' ")
	Page<InscriptionCertification> findAllPageRefusee(Pageable p );
	
	@Query("SELECT u FROM InscriptionCertification u WHERE u.certification.id = :status and u.etat='CONFIRME'")
	List<InscriptionCertification> findParCertificatiolList(
	  @Param("status") Long id);
	
}
