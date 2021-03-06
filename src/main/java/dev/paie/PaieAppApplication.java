package dev.paie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import dev.paie.exec.InsererBulletin;

@SpringBootApplication
public class PaieAppApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(PaieAppApplication.class, args);
			
		Runnable exec = context.getBean(InsererBulletin.class);
		exec.run();
	}

}
