package dev.paie.exec;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;

import dev.paie.entite.Grade;
import dev.paie.repository.GradRepository;
@Controller
public class InsererGrade implements Runnable{
	private GradRepository gradRepository;
	
	/**
	 * @param gradRepository
	 */
	public InsererGrade(GradRepository gradRepository) {
		super();
		this.gradRepository = gradRepository;
	}

	@Override
	public void run() {
		Grade grade = new Grade();
		grade.setCode("GRAD_A");
		grade.setNbHeuresBase(new BigDecimal("152"));
		grade.setTauxBase(new BigDecimal("21"));

		this.gradRepository.save(grade);
	}

}
