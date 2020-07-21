package com.projet.formationCertification.dao;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.formationCertification.entities.Domaine;
import com.projet.formationCertification.entities.SeanceFormation;
import com.projet.formationCertification.entities.Theme;

public interface ThemeRepository extends JpaRepository<Theme, Long> {

	
	
	@Query("SELECT v FROM Theme v")
	Page<Theme> findAllPage(Pageable p );
	
	@Query("SELECT v FROM Theme v WHERE v.id= :status")
	Theme findId(  @Param("status") Long id);

	@Query("SELECT v FROM Theme v WHERE v.domaine.id = :status")
	List<Theme> findTheme( @Param("status") Long id);
	 



}
