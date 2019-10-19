package br.com.codenation.aplication.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Usuario extends Pessoa  {

    private String login;
    private String senha;
    private String documentoEmpresa;

    public String getLogin(){
        return login;
    }

    public void setLogin(String LoginName){
        login = LoginName;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String password){
        senha = password;
    }

    public String getdocumentoEmpresa(){
        return documentoEmpresa;
    }

    public void setdocumentoEmpresa(String compDoc){
        documentoEmpresa = compDoc;
    }

}
