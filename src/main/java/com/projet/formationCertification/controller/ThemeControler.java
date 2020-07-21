package com.projet.formationCertification.controller;

import java.util.Collection;
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

import com.projet.formationCertification.dao.FormationRepository;
import com.projet.formationCertification.dao.NiveauRepository;
import com.projet.formationCertification.dao.ThemeRepository;
import com.projet.formationCertification.entities.Domaine;
import com.projet.formationCertification.entities.Formateur;
import com.projet.formationCertification.entities.Theme;

@CrossOrigin
@RestController
public class ThemeControler {
@Autowired
ThemeRepository tr ; 
@Autowired
NiveauRepository nr;

@Autowired
FormationRepository fr ;
@GetMapping(value="/themes")
public Collection<Theme> findAllTheme()
{
	return tr.findAll() ; 
}

@GetMapping(value="/pagerTheme")
public Page<Theme> findAllTheme(@RequestParam(name="page",defaultValue="0") int p , 
		@RequestParam(name="size",defaultValue="3") int size)

{
	return  tr.findAllPage( new PageRequest(p,size)) ;
			
}

@RequestMapping(value="/addTheme" , method=RequestMethod.POST)
public Theme add(@RequestBody Theme d)
{
	return tr.save(d);
}
@RequestMapping(value="/chercherTheme/{id}" , method=RequestMethod.GET)
public Theme findTheme(@PathVariable Long id )
{
	return  tr.findId(id); 
}

@PutMapping(value="/updateTheme/{id}")
public Theme update(@PathVariable Long id , @RequestBody Theme c)
{


c.setId(id);
return  tr.save(c) ;
	
}
@DeleteMapping(value="/deleteTheme/{id}")
public boolean delete(@PathVariable Long id)
{
	Theme d = tr.findId(id);
	
	if (d!=null && nr.findThemeNiveau(d.getId()).size()==0 && fr.findFormationTheme(d.getId()).size()==0)
	{
tr.delete(d);
return true ;
}
else {

		return false ; 
	}
}




}
