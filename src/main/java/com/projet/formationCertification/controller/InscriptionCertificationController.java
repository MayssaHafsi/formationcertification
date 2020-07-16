package com.projet.formationCertification.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.formationCertification.dao.InscriptionCertificationDao;
import com.projet.formationCertification.entities.Certification;
import com.projet.formationCertification.entities.Demandeur;
import com.projet.formationCertification.entities.FormationCertifiant;
import com.projet.formationCertification.entities.FormationNonCertifiant;
import com.projet.formationCertification.entities.InscriptionCertification;
import com.projet.formationCertification.entities.InscriptionFormation;

@RestController
@CrossOrigin
public class InscriptionCertificationController {
@Autowired
InscriptionCertificationDao icd ; 

@GetMapping(value="/inscCerts")
public Collection<InscriptionCertification> findAllDemandeur()
{
	return icd.findAll() ; 
}
@RequestMapping(value="/addInscri" , method=RequestMethod.POST)
public InscriptionCertification add(@RequestBody InscriptionCertification ins)
{ins.setDemandeurCertification(ins.getDemandeurCertification());

	return icd.save(ins);
}

@GetMapping(value="/pagerInscriptionC")
public Page<InscriptionCertification> findAllInscriptionFormation(@RequestParam(name="page",defaultValue="0") int p , 
		@RequestParam(name="size",defaultValue="3") int size)

{
	return  icd.findAllPage( new PageRequest(p,size)) ;
			
}

@PutMapping(value="/updateInscCertification/{id}")
public InscriptionCertification update(@PathVariable Long id , @RequestBody InscriptionCertification c)
{

c.setId(id);
return  icd.save(c) ;
	
}


@GetMapping(value="/pagerInscriptionCC")
public Page<InscriptionCertification> findAllInscriptionFormationC(@RequestParam(name="page",defaultValue="0") int p , 
		@RequestParam(name="size",defaultValue="3") int size)

{
	return  icd.findAllPageConfirmee( new PageRequest(p,size)) ;
			
}
@GetMapping(value="/pagerInscriptionCR")
public Page<InscriptionCertification> findAllInscriptionFormationR(@RequestParam(name="page",defaultValue="0") int p , 
		@RequestParam(name="size",defaultValue="3") int size)

{
	return  icd.findAllPageRefusee( new PageRequest(p,size)) ;
			
}


@RequestMapping(value="/findParCertificationConfirme/{id}" , method=RequestMethod.GET)
public List<InscriptionCertification> findParFormations(@PathVariable Long id )
{
	return  icd.findParCertificatiolList(id); 
}


}
