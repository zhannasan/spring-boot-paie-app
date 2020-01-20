package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.paie.entite.Grade;
@Repository
public interface GradRepository extends JpaRepository<Grade, Integer>{
	
}
