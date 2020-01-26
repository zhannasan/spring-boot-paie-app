package dev.paie.exec;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import dev.paie.entite.Cotisation;
import dev.paie.repository.CotisationRepository;
@Controller
public class ListerCotisations implements Runnable{
	private static Logger LOG = LoggerFactory.getLogger(ListerCotisations.class);
	
	private CotisationRepository cotisationRepository;
	
	/**
	 * @param cotisationRepository
	 */
	public ListerCotisations(CotisationRepository cotisationRepository) {
		super();
		this.cotisationRepository = cotisationRepository;
	}

	@Override
	public void run() {
		List<Cotisation> cotisations = cotisationRepository.findAll();
		for (Cotisation c : cotisations) {
			LOG.info("code={}, libelle={}, imposable={}, TauxPatronal={}, TauxSalarial={} ", c.getCode(),
					c.getLibelle(), c.getImposable(), c.getTauxPatronal(), c.getTauxSalarial());
		}
	}

}
