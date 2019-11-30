package br.com.codenation.aplication.controller.implementation;
import br.com.codenation.aplication.service.implementation.AplicationService;

public class AplicationController {

    AplicationService app = new AplicationService();

    public boolean createUser(Long id, String name, String document, int age, String login, String password, Long compId){
        return app.createUser(id, name, document, age, login, password, compId);
    }

    public boolean createCompany(Long id, String name, String document, int vagas) {
        return app.createCompany(id, name, document, vagas);
    }

    public void find(Long id, String name, String document, int age){
        app.find(id, name, document, age);
    }

}
