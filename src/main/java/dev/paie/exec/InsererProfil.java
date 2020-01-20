package dev.paie.exec;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Controller;

import dev.paie.entite.Avantage;
import dev.paie.entite.Cotisation;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.AvantageRepository;
import dev.paie.repository.CotisationRepository;
import dev.paie.repository.ProfilRepository;

@Controller
public class InsererProfil implements Runnable{
	
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
		ProfilRemuneration profil = new ProfilRemuneration();
		profil.setCode("Cadre");
		List<Cotisation> cotisations = cotisationRepository.findAll();
		profil.setCotisations(cotisations);
		/*List<Avantage> avantages = avantageRepository.findAll();
		profil.setAvantages(avantages);*/
		this.profilRepository.save(profil);
		
	}

}
