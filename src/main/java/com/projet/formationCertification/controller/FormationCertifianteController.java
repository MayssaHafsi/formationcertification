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

import com.projet.formationCertification.dao.FormationCertifiantRepository;
import com.projet.formationCertification.entities.FormationCertifiant;

@CrossOrigin
@RestController
public class FormationCertifianteController {
	@Autowired
	FormationCertifiantRepository frm ;
	@GetMapping(value="/formationsC")
	public List<FormationCertifiant> getAll()
	{
		return frm.findAll() ; 
	}
	@RequestMapping(value="/addFormationC" , method=RequestMethod.POST)	
	public FormationCertifiant save(@RequestBody FormationCertifiant f)
	{
		f.setType("FC");

		return frm.save(f) ; 
	}
	
	
	@DeleteMapping(value="/deleteFormationC/{id}")
	public boolean delete(@PathVariable Long id)
	{
		FormationCertifiant d =frm.find(id);
		if (d!=null)
		{
	frm.delete(d);
	return true ;
	}
		else {
			return false ; 
		}
	}
	
	
	@PutMapping(value="/updateFormationC/{id}")
	public FormationCertifiant update(@PathVariable Long id , @RequestBody FormationCertifiant c)
	{
	
	c.setId(id);
	return  frm.save(c) ;
		
	}
}
