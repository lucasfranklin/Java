package br.com.codenation.aplication;

import br.com.codenation.aplication.controller.AplicationController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {


	AplicationController appControl = new AplicationController();

	public static void main(String[] args) {

		Application newApp = new Application();

		SpringApplication.run(Application.class, args);

		newApp.newCompany(1L, "Codenation", "31472046000137", 3);
		newApp.newCompany(2L, "Avanade", "1234567890", 40);
		newApp.newCompany(3L, "Inter", "0987654321", 100);

		newApp.newUser(1L, "Thiago", "123456789", 31, "oathiago", "codenation", 1L);
		newApp.newUser(2L, "Lucas", "987654321", 31, "lucas", "codenation", 1L);
		newApp.newUser(3L, "Franklin", "12349876", 31, "franklin", "codenation", 2L);

		newApp.find();

	}

	public void newUser(Long id, String name, String document, int age, String login, String password, Long compId){
		Boolean status = appControl.createUser(id, name, document, age, login, password, compId);
		System.out.println(status);
	}

	public void newCompany(Long id, String name, String document, int vagas){
		Boolean status = appControl.createCompany(id, name, document, vagas);
		System.out.println(status);
	}

	public void find(){
		appControl.find(1L, "Thiago", "123456789", 31);
	}

}
