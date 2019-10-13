package br.com.cidenation.MeuProjeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MeuProjetoApplication {

	public static void main(String[] args) {

		SpringApplication.run(MeuProjetoApplication.class, args);

		DataBase names = new DataBase();

		names.addName("Lucas");
		names.addName("Franklin");
		names.addName("Silva");
		//names.printNames('L');
		names.removeFromList("K");
		names.printAll();

	}

}
