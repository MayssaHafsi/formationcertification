package com.projet.formationCertification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.projet.formationCertification.dao.FormationNonCertifiantRepesetory;
import com.projet.formationCertification.entities.FormationNonCertifiant;
@RestController
@CrossOrigin
public class FormationNonCertifianteController {
	@Autowired
	FormationNonCertifiantRepesetory frm ;
	@GetMapping(value="/formationsNC")
	public List<FormationNonCertifiant> getAll()
	{
		return frm.findAll() ; 
	}
	@RequestMapping(value="/addFormationNC" , method=RequestMethod.POST)	
	public FormationNonCertifiant save(@RequestBody FormationNonCertifiant f)
	{
	//f.getDomaine().getFormations().add(f) ;

		return frm.save(f) ; 

	}
	@RequestMapping(value="/chercherFormation/{id}" , method=RequestMethod.GET)
	public FormationNonCertifiant findDomaine(@PathVariable Long id )
	{
		return  frm.find(id); 
	}
	
	
	
	

}
