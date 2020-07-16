package com.projet.formationCertification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.formationCertification.dao.FormationFormateurRepository;
import com.projet.formationCertification.dao.FormationRepository;
import com.projet.formationCertification.entities.Domaine;
import com.projet.formationCertification.entities.Formateur;
import com.projet.formationCertification.entities.Formation;
import com.projet.formationCertification.entities.FormationFormateur;
import com.projet.formationCertification.entities.FormationNonCertifiant;

@RestController
@CrossOrigin
public class FormationFormateurController {
	@Autowired
	FormationFormateurRepository frm ; 
	@Autowired
	FormationRepository fr ;
	@GetMapping(value="/formationsFormateurs")
	public List<FormationFormateur> getAll()
	{
		return frm.findAll() ; 
	}
	@GetMapping(value="/findalls/{id}")
	public List<FormationFormateur> getAlls(@PathVariable Long id)
	{
		return frm.findFormateur(id) ; 
	}
	@RequestMapping(value="/addFormationFormateur" , method=RequestMethod.POST)	
	public FormationFormateur save(@RequestBody FormationFormateur f )
	{

		return frm.save(f) ; 
	}
	
	@GetMapping(value="/pagerFormationFormateur/{id}")
	public Page<FormationFormateur> findAllDomaines(@PathVariable Long id ,  @RequestParam(name="page",defaultValue="0") int p , 
			@RequestParam(name="size",defaultValue="3") int size)

	{
		return  frm.findAllPage( id, new PageRequest(p,size)) ;
				
	}
	@RequestMapping(value="/chercherFormationFormateur/{id}" , method=RequestMethod.GET)
	public FormationFormateur find(@PathVariable Long id )
	{
		return  frm.find(id); 
	}
	
	@PutMapping(value="/updateFormationFormateur/{id}")
	public FormationFormateur update(@PathVariable Long id, @RequestBody FormationFormateur c)
	{

	c.setId(id);
	return  frm.save(c) ;
		
	}
	@DeleteMapping(value="/deleteFormationFormateur/{id}")
	public boolean delete(@PathVariable Long id)
	{
		FormationFormateur d = frm.find(id);
	
	frm.delete(d);
	return true ;
	
		
	}
	
	
}
