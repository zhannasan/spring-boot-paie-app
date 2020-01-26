package dev.paie.exec;

import java.math.BigDecimal;

import javax.persistence.EntityExistsException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.BulletinRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationRepository;

@Controller
public class InsererBulletin implements Runnable {
	private static Logger LOG = LoggerFactory.getLogger(InsererBulletin.class);

	private BulletinRepository bulletinRepository;
	private RemunerationRepository remunerationRepository;
	private PeriodeRepository periodeRepository;

	/**
	 * @param bulletinRepository
	 * @param remunerationRepository
	 * @param periodeRepository
	 */
	public InsererBulletin(BulletinRepository bulletinRepository, RemunerationRepository remunerationRepository,
			PeriodeRepository periodeRepository) {
		super();
		this.bulletinRepository = bulletinRepository;
		this.remunerationRepository = remunerationRepository;
		this.periodeRepository = periodeRepository;
	}

	@Override
	public void run() {
		try {
			RemunerationEmploye remunerationEmploye = this.remunerationRepository.findById(1)
					.orElseThrow(() -> new RuntimeException("No RemunerationEmploye found."));
			Periode periode = this.periodeRepository.findById(10)
					.orElseThrow(() -> new RuntimeException("No Periode found."));

			BigDecimal primeExceptionnelle = new BigDecimal("500");
			BulletinSalaire bs = new BulletinSalaire();
			bs.setPeriode(periode);
			bs.setPrimeExceptionnelle(primeExceptionnelle);
			bs.setRemunerationEmploye(remunerationEmploye);
			this.bulletinRepository.save(bs);
		} catch (EntityExistsException e) {
			LOG.error("No entity found" + e.getMessage());
		}
	}

}
