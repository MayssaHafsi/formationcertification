package com.projet.formationCertification.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projet.formationCertification.dao.CoursCertificationRepository;
import com.projet.formationCertification.dao.CoursRepository;
import com.projet.formationCertification.entities.Cours;
import com.projet.formationCertification.entities.CoursCertification;

@RestController
@CrossOrigin
public class DownloadCoursCertificationController {
	@Autowired
	  CoursCertificationRepository fileRepository;
	 
	  /*
	   * List All Files
	   */


	  @GetMapping("/api/file/allCertification")
	  public List<CoursCertification> getListFiles() {
	    return fileRepository.findAll();
	  }
	  
	  @RequestMapping(value="/api/file/tousCertification/{id}" , method=RequestMethod.GET)
	  public List<CoursCertification> findDomaine(@PathVariable Long id )
	  {
	  	return  fileRepository.findCours(id); 
	  }


	  
	    /*
	     * Download Files
	     */
	  @GetMapping("/api/fileCertification/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
	    Optional<CoursCertification> fileOptional = fileRepository.findById(id);
	    
	    if(fileOptional.isPresent()) {
	      CoursCertification file = fileOptional.get();
	      return ResponseEntity.ok()
	          .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
	          .body(file.getPic());  
	    }
	    
	    return ResponseEntity.status(404).body(null);
	  }
}
