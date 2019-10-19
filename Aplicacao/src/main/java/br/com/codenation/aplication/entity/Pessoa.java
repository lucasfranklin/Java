package br.com.codenation.aplication.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pessoa {

    private Long id;
    private String nome;
    private String Documento;
    private int idade;

    public Long getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public String getDocumento(){
        return Documento;
    }

    public int getIdade(){
        return idade;
    }

    public void setId(Long newId){
        id = newId;
    }

    public void setNome(String name){
        nome = name;
    }

    public void setDocumento(String document){
        Documento = document;
    }

    public void setIdade(int age){
        idade = age;
    }
}
