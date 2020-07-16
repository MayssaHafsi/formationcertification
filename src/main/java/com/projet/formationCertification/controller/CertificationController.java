package com.projet.formationCertification.controller;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.projet.formationCertification.dao.CertificationRepository;
import com.projet.formationCertification.entities.Certification;


@RestController
@CrossOrigin
public class CertificationController {

	@Autowired
	CertificationRepository cr ;
	@GetMapping(value="/certifs")
	public Collection<Certification> findAllCertifications()
	{
		return cr.findAll() ; 
	}
	
	
	
	
	@GetMapping(value="/pagerChercherCertificationTheme")
	public Page<Certification> chercherTheme(@RequestParam(name="mct",defaultValue="") String mc , @RequestParam(name="page",defaultValue="0") int p , 
			@RequestParam(name="size",defaultValue="3") int size)

	{
		return  cr.findThemeC("%"+mc+"%", new PageRequest(p,size)) ;
				
	}

	@GetMapping(value="/pagerChercherCertificationDomaine")
	public Page<Certification> chercherDomaine(@RequestParam(name="mcd",defaultValue="") String mc , @RequestParam(name="page",defaultValue="0") int p , 
			@RequestParam(name="size",defaultValue="3") int size)

	{
		return  cr.findDomaineC("%"+mc+"%", new PageRequest(p,size)) ;
				
	}
	
	
	
	
	
	
	
	@GetMapping(value="/pagerChercherCertificationThemeC")
	public Page<Certification> chercherThemeC(@RequestParam(name="mct",defaultValue="") String mc , @RequestParam(name="page",defaultValue="0") int p , 
			@RequestParam(name="size",defaultValue="3") int size)

	{
		return  cr.findThemeCC("%"+mc+"%", new PageRequest(p,size)) ;
				
	}

	@GetMapping(value="/pagerChercherCertificationDomaineC")
	public Page<Certification> chercherDomaineC(@RequestParam(name="mcd",defaultValue="") String mc , @RequestParam(name="page",defaultValue="0") int p , 
			@RequestParam(name="size",defaultValue="3") int size)

	{
		return  cr.findDomaineCC("%"+mc+"%", new PageRequest(p,size)) ;
				
	}
	
	
	
	
	

	@GetMapping(value="/pagerChercherCertificationDate")
	public Page<Certification> chercherDateCert(@RequestParam(name="mcdc",defaultValue="") @DateTimeFormat(pattern = "yyyy-MM-dd") Date mc , @RequestParam(name="page",defaultValue="0") int p , 
			@RequestParam(name="size",defaultValue="3") int size)

	{
		return  cr.findDateC(mc, new PageRequest(p,size)) ;
				
	}
	

	
	@GetMapping(value="/pagerChercherCertificationDateC")
	public Page<Certification> chercherDateCertC(@RequestParam(name="mcdc",defaultValue="") @DateTimeFormat(pattern = "yyyy-MM-dd") Date mc , @RequestParam(name="page",defaultValue="0") int p , 
			@RequestParam(name="size",defaultValue="3") int size)

	{
		return  cr.findDateCC(mc, new PageRequest(p,size)) ;
				
	}
	
	
	
	
	
	
	
	@GetMapping(value="/pagerCertification")
	public Page<Certification> findAllDomaines(@RequestParam(name="page",defaultValue="0") int p , 
			@RequestParam(name="size",defaultValue="3") int size)

	{
		return  cr.findAllPage( new PageRequest(p,size)) ;
				
	}
	
	@RequestMapping(value="/chercherCertification/{id}" , method=RequestMethod.GET)
	public Certification findCertification(@PathVariable Long id )
	{
		return  cr.find(id); 
	}
	@RequestMapping(value="/addCertification" , method=RequestMethod.POST)
	public Certification add(@RequestBody Certification d)
	{
		return cr.save(d);
	}
	
	@PutMapping(value="/updateCertification/{id}")
	public Certification update(@PathVariable Long id , @RequestBody Certification c)
	{
	
	c.setId(id);
	return  cr.save(c) ;
		
	}
	
	@GetMapping(value="/CertificationCon")
	public Page<Certification> getAllCe(@RequestParam(name="page",defaultValue="0") int p , 
			@RequestParam(name="size",defaultValue="6") int size)
	{
		return cr.findConditionCertification(new PageRequest(p, size)) ; 
	}
	
	
	@DeleteMapping(value="/deleteCertification/{id}")
	public boolean delete(@PathVariable Long id)
	{
		Certification d = cr.find(id);
		if (d!=null )
		{
	cr.delete(d);
	return true ;
	}
		else {
			return false ; 
		}
	}
	

	@RequestMapping(value="/chercherThemeCert" , method=RequestMethod.GET)
	public List<Certification> findThemeCert(@RequestParam(name="id",defaultValue="")  Long id )
	{
		return  cr.findThemeCertification(id); 
	}

	@RequestMapping(value="/chercherDemandeurCert" , method=RequestMethod.GET)
	public List<Certification> findDemandeurCert(@RequestParam(name="id",defaultValue="")  Long id )
	{
		return  cr.findDemandeurCertification(id); 
	}

	@RequestMapping(value="/chercherFormateurCert" , method=RequestMethod.GET)
	public List<Certification> findFormateurCert(@RequestParam(name="id",defaultValue="")  Long id )
	{
		return  cr.findFormateurCertification(id); 
	}

	@RequestMapping(value="/chercherUserCert" , method=RequestMethod.GET)
	public List<Certification> findUserCert(@RequestParam(name="id",defaultValue="")  Long id )
	{
		return  cr.findUserCertification(id); 
	}

}
