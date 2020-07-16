package com.projet.formationCertification.controller;

import java.util.Collection;


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

import com.projet.formationCertification.dao.FormateurRepository;
import com.projet.formationCertification.entities.Formateur;
import com.projet.formationCertification.entities.User;
import com.projet.formationCertification.dao.UserRepository;
@RestController
@CrossOrigin
public class UserController  {

	@Autowired
	UserRepository fr ; 
	@GetMapping(value="/users")
	public Collection<User> findAll()
	{
		return fr.findAll() ; 
	}

	@RequestMapping(value="/addUser" , method=RequestMethod.POST)
	public User saveUser(@RequestBody User f) throws Exception
	{
	
		return	fr.save(f) ;
	}
}