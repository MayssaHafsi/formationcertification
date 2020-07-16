package com.projet.formationCertification.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.formationCertification.entities.CoursCertification;

public interface CoursCertificationRepository extends JpaRepository<CoursCertification, Long> {

	@Query("SELECT u FROM CoursCertification u WHERE u.id = :status")
	CoursCertification find(
	  @Param("status") Long id);
	
	
	@Query("SELECT u FROM CoursCertification u WHERE u.certificationCours.id = :status")
	List<CoursCertification> findCours(
	  @Param("status") Long id);
}
