package dev.paie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import dev.paie.exec.InsererGrade;
import dev.paie.exec.InsererProfil;
import dev.paie.exec.ListerCotisations;

@SpringBootApplication
public class PaieAppApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(PaieAppApplication.class, args);
			
		Runnable exec = context.getBean(InsererProfil.class);
		exec.run();
	}

}
