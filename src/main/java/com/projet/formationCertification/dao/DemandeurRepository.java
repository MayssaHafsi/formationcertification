package com.projet.formationCertification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.formationCertification.entities.Demandeur;
import com.projet.formationCertification.entities.Domaine;

public interface DemandeurRepository extends JpaRepository<Demandeur, String> {
	@Query("SELECT u FROM Demandeur u WHERE u.cin = :status")
	Demandeur find(
	  @Param("status") String cin);
	
	@Query("SELECT u FROM Demandeur u WHERE u.cin = :status")
	Demandeur findParCin(
	  @Param("status")String cin);

}
