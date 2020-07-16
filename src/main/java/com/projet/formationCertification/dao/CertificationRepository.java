package com.projet.formationCertification.dao;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.formationCertification.entities.Certification;



public interface CertificationRepository extends JpaRepository<Certification, Long> {
	@Query("SELECT v FROM Certification v")
	Page<Certification> findAllPage(Pageable p );
	
	@Query("SELECT u FROM Certification u WHERE u.id = :status")
	Certification find(
	  @Param("status") Long id);
	
	@Query("SELECT u FROM Certification u WHERE u.domaineCertification.id = :status")
	List<Certification> findCertificationDomaine(
	  @Param("status") Long id);

	
	@Query("SELECT u FROM Certification u WHERE u.niveau.id = :status")
	List<Certification> findCertificationNiveau(
	  @Param("status") Long id);
	
	@Query("SELECT u FROM Certification u WHERE u.dateLimiteInscription > CURRENT_DATE AND u.nbrPlaceReserve < u.capacite  ")
	Page<Certification> findConditionCertification(Pageable p)	;
	
	
	
@Query("SELECT u FROM Certification u WHERE u.niveau.themeNiveau.id = :status")
	List<Certification> findThemeCertification(
	  @Param("status") Long id);

	  @Query("SELECT u FROM Certification u WHERE u.demandeur.id = :status")
	List<Certification> findDemandeurCertification(
	  @Param("status") Long id);

	  @Query("SELECT u FROM Certification u WHERE u.formateur.id = :status")
	List<Certification> findFormateurCertification(
	  @Param("status") Long id);

	  @Query("SELECT u FROM Certification u WHERE u.user.id = :status")
	List<Certification> findUserCertification(
	  @Param("status") Long id);



@Query("SELECT u FROM Certification u WHERE u.domaineCertification.nom like :status")
Page<Certification> findDomaineC(
	  @Param("status") String mc,Pageable p );


@Query("SELECT u FROM Certification u WHERE u.niveau.themeNiveau.nom like :status")
Page<Certification> findThemeC(
	  @Param("status") String mc,Pageable p );



@Query("SELECT u FROM Certification u WHERE u.dateCertification = :status")
Page<Certification> findDateC(
	  @Param("status") java.util.Date mc,Pageable p );



@Query("SELECT u FROM Certification u WHERE u.dateCertification = :status AND u.dateLimiteInscription > CURRENT_DATE AND u.nbrPlaceReserve < u.capacite")
Page<Certification> findDateCC(
	  @Param("status") java.util.Date mc,Pageable p );




@Query("SELECT u FROM Certification u WHERE u.domaineCertification.nom like :status AND u.dateLimiteInscription > CURRENT_DATE AND u.nbrPlaceReserve < u.capacite ")
Page<Certification> findDomaineCC(
	  @Param("status") String mc,Pageable p );


@Query("SELECT u FROM Certification u WHERE u.niveau.themeNiveau.nom like :status AND u.dateLimiteInscription > CURRENT_DATE AND u.nbrPlaceReserve < u.capacite ")
Page<Certification> findThemeCC(
	  @Param("status") String mc,Pageable p );




}



