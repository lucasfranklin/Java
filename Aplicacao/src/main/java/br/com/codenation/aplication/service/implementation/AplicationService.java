package br.com.codenation.aplication.service;
import br.com.codenation.aplication.entity.Empresa;
import br.com.codenation.aplication.entity.Usuario;
import com.oracle.tools.packager.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.com.codenation.aplication.Exceptions.CodenationException;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

public class AplicationService {

    Logger LOG = LoggerFactory.getLogger(AplicationService.class);

    private List<Usuario> users = new ArrayList<>();
    private List<Empresa> empresas = new ArrayList<>();

    public boolean createUser(Long id, String name, String document, int age, String login, String password, Long compId ) throws CodenationException{

        //empresas.stream().filter(comp -> comp.getId().equals(compId))

        if(checkUser(id, name, document, age, login, password, compId)) {
            Usuario user = new Usuario();
            user.setId(id);
            user.setDocumento(document);
            user.setIdade(age);
            user.setNome(name);
            user.setLogin(login);
            user.setSenha(password);

            users.add(user);

            empresas.stream().filter(emp ->
                    emp.getId().equals(compId) && emp.countList() < emp.getVagas()).findFirst().orElse(null).addUser(user);
            /*for (Empresa empresa:
             empresas) {
            if(empresa.getId() == compId ){
                empresa.addUser(user);
                return true;
            }*/

            System.out.println(user.getNome());

        }
        return true;
    }

    public boolean createCompany(Long id, String name, String document, int vagas){

        if(checkCompany(name, document)) {
            Empresa company = new Empresa();
            company.setId(id);
            company.setNome(name);
            company.setDocumento(document);
            company.setVagas(vagas);

            empresas.add(company);

            System.out.println(company.getNome());
        }
        return true;
    }

    public void find(Long id, String name, String document, int age){
        empresas.forEach(item->{
            if(id == (item.getId())){
                item.getUsers().forEach(item2->{
                    if(name == item2.getNome() && document == item2.getDocumento() && age == item2.getIdade()){
                        System.out.println("Usuario: " + item2.getNome() + " - Empresa: " + item.getNome());
                    }}
                );
            }
        });
    }

    public boolean checkCompany(String name, String document){
        if(empresas.stream().filter(comp -> comp.getNome().equals(name)).findFirst().isPresent()){
            LOG.info("ERRO - JA EXISTE EMPRESA COM ESSE NOME!");
            throw new CodenationException("JA EXISTE EMPRESA COM ESSE NOME.");
        }
        else if(empresas.stream().filter(comp -> comp.getDocumento().equals(document)).findFirst().isPresent()){
            LOG.info("ERRO - JA EXISTE EMPRESA COM ESSE DOCUMENTO!");
            throw new CodenationException("JA EXISTE EMPRESA COM ESSE DOCUMENTO.");
        }

        return true;
    }

    public boolean checkUser(Long id, String name, String document, int age, String login, String password, Long compId ){
        if(id == null || name.isEmpty() || document.isEmpty() || age < 0 || login.isEmpty() || password.isEmpty()){
            LOG.info("ERRO - TODOS OS CAMPOS SAO OBRIGATORIOS E PRECISAM SER VALIDOS!{}", name.isEmpty());
            throw new CodenationException("Campos Obrigatorios.");
        }

        else if(users.stream().filter(usr -> usr.getNome().equals(login)).findFirst().isPresent()){

            LOG.info("ERRO - JA EXISTE USUARIO COM ESSE NOME!");
            throw new CodenationException("Usuario ja existente.");
        }

        else if(users.stream().filter(usr -> usr.getDocumento().equals(document)).findFirst().isPresent()){
            LOG.info("ERRO - JA EXISTE USUARIO COM ESSE DOCUMENTO!");
            throw new CodenationException("JA EXISTE USUARIO COM ESSE DOCUMENTO.");
        }

        else if(users.stream().filter(usr -> usr.getNome().equals(name)).findFirst().isPresent()){
            LOG.info("ERRO - JA EXISTE USUARIO COM ESSE NOME!");
            throw new CodenationException("JA EXISTE USUARIO COM ESSE NOME.");
        }

        return true;
    }
}
