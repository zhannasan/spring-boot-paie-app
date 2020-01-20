package dev.paie.exec;

import java.util.List;

import org.springframework.stereotype.Controller;

import dev.paie.entite.Cotisation;
import dev.paie.repository.CotisationRepository;
@Controller
public class ListerCotisations implements Runnable{
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
		for(Cotisation c : cotisations){
			System.out.println(c.toString());
		}
	}

}
