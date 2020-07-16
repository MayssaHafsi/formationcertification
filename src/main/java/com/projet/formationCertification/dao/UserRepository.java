package com.projet.formationCertification.dao;
import org.springframework.data.jpa.repository.JpaRepository;




import com.projet.formationCertification.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {}


