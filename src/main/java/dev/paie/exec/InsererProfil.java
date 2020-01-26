package dev.paie.exec;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityExistsException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import dev.paie.entite.Cotisation;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.AvantageRepository;
import dev.paie.repository.CotisationRepository;
import dev.paie.repository.ProfilRepository;

@Controller
public class InsererProfil implements Runnable{
	private static Logger LOG = LoggerFactory.getLogger(InsererProfil.class);
	private ProfilRepository profilRepository;
	private CotisationRepository cotisationRepository;
	private AvantageRepository avantageRepository;
	
	/**
	 * @param profilRepository
	 */
	public InsererProfil(ProfilRepository profilRepository, CotisationRepository cotisationRepository, AvantageRepository avantageRepository) {
		super();
		this.profilRepository = profilRepository;
		this.cotisationRepository = cotisationRepository;
		this.avantageRepository = avantageRepository;
	}

	@Override
	public void run() {
		try {
			ProfilRemuneration profil = new ProfilRemuneration();
		profil.setCode("Non-cadre");
		List<Cotisation> cotisations = cotisationRepository.findAllById(Arrays.asList(1, 2));
		profil.setCotisations(cotisations);
		/*List<Avantage> avantages = avantageRepository.findAll();
		profil.setAvantages(avantages);*/
		this.profilRepository.save(profil);
		} catch (EntityExistsException e) {
			LOG.error("No entity found");
		}
	}

}
