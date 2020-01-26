package dev.paie.exec;

import javax.persistence.EntityExistsException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradRepository;
import dev.paie.repository.ProfilRepository;
import dev.paie.repository.RemunerationRepository;
@Controller
public class InsererRemuneration implements Runnable {
	private static Logger LOG = LoggerFactory.getLogger(InsererRemuneration.class);

	private RemunerationRepository remunerationRepository;
	private GradRepository gradRepository;
	private EntrepriseRepository entrepriseRepository;
	private ProfilRepository profilRepository;
	

	/**
	 * @param remunerationRepository
	 * @param gradRepository
	 * @param entrepriseRepository
	 * @param profilRepository
	 */
	public InsererRemuneration(RemunerationRepository remunerationRepository, GradRepository gradRepository,
			EntrepriseRepository entrepriseRepository, ProfilRepository profilRepository) {
		super();
		this.remunerationRepository = remunerationRepository;
		this.gradRepository = gradRepository;
		this.entrepriseRepository = entrepriseRepository;
		this.profilRepository = profilRepository;
	}


	@Override
	public void run() {
		try{
			RemunerationEmploye remuneration = new RemunerationEmploye();
			Entreprise entreprise = this.entrepriseRepository.findById(1)
					.orElseThrow(() -> new RuntimeException("No Enreprise found."));
			remuneration.setEntreprise(entreprise);
		
			Grade grade = this.gradRepository.findById(2).orElseThrow(() -> new RuntimeException("No Grad found."));
			remuneration.setGrade(grade);
		
			remuneration.setMatricule("12345");
		
			ProfilRemuneration profil = this.profilRepository.findById(1).orElseThrow(() -> new RuntimeException("No Profil found."));
			remuneration.setProfilRemuneration(profil);
		
			this.remunerationRepository.save(remuneration);
		} catch (EntityExistsException e) {
			LOG.error("No entity found");
		}
	}

}
