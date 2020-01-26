package dev.paie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {
	@Override
	Optional<Entreprise> findById(Integer id);
}
