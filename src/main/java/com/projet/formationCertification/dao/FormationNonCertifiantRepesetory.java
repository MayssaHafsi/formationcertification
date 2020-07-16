package com.projet.formationCertification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.formationCertification.entities.Domaine;
import com.projet.formationCertification.entities.Formation;
import com.projet.formationCertification.entities.FormationNonCertifiant;

public interface FormationNonCertifiantRepesetory extends JpaRepository<FormationNonCertifiant,Long > {
	@Query("SELECT u FROM Formation u WHERE u.id = :status")
	FormationNonCertifiant find(
	  @Param("status") Long id);
}
