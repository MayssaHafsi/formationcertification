package com.projet.formationCertification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.projet.formationCertification.dao.CertificationRepository;
import com.projet.formationCertification.dao.CoursCertificationRepository;
import com.projet.formationCertification.entities.CoursCertification;

@RestController
@CrossOrigin
public class CoursCertificationController {
	  @Autowired
	  CoursCertificationRepository fileRepository;
	 
	  @Autowired
	CertificationRepository ic ;
	    /*
	     * MultipartFile Upload
	     */
	    @PostMapping("/api/file/uploadCoursCertification/{id}")
	    public String uploadMultipartFile(@RequestParam("file") MultipartFile file,@PathVariable Long id) {
	      try {
	 CoursCertification filemode=new CoursCertification(); 
	filemode.setCertificationCours(ic.find(id));
	 filemode.setMimetype(file.getContentType());
	 filemode.setName(file.getOriginalFilename());
	 filemode.setPic(file.getBytes());
	        // save file to PostgreSQL
	     //   Cours filemode = new Cours(file.getOriginalFilename(), file.getContentType(), file.getBytes());
	        fileRepository.save(filemode);
	        return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
	    } catch (  Exception e) {
	      return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
	    }    
	    }
	    
	    @DeleteMapping(value="/api/file/deleteCoursCertification/{id}")
	    public boolean delete(@PathVariable Long id)
	    {
	    	CoursCertification d = fileRepository.find(id);
	    	if (d!=null)
	    	{
	    fileRepository.delete(d);
	    return true ;
	    }
	    	else {
	    		return false ; 
	    	}
	    }
}
