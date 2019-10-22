package br.com.codenation.aplication.entity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Empresa extends Pessoa {

    private int vagas;
    private List<Usuario> users = new ArrayList<>();

    public int getVagas(){
        return vagas;
    }

    public void setVagas(int vaga){
        vagas = vaga;
    }

    public void addUser(Usuario usr){
        users.add(usr);
    }

    public List<Usuario> getUsers(){
        return users;
    }

    public int countList(){
        return users.size();
    }


}
