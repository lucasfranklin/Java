package br.com.codenation.aplication.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter

@Entity(name = "user")
public class Usuario   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "document", nullable = false, length = 255)
    private String document;

    @Column(name = "age")
    private int age;

    @Column(name = "login", nullable = false, length = 255)
    private String login;

    @Column(name = "password", nullable = false, length = 15)
    private String password;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Empresa company;

    @Column(name = "salary")
    private BigDecimal salary;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public String getDocumento() {
        return document;
    }

    public void setDocumento(String documento) {
        this.document = documento;
    }

    public int getIdade() {
        return age;
    }

    public void setIdade(int idade) {
        this.age = idade;
    }

    public BigDecimal getSalario() {
        return salary;
    }

    public void setSalario(BigDecimal salario) {
        this.salary = salario;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String LoginName){
        login = LoginName;
    }

    public String getSenha(){
        return password;
    }

    public void setSenha(String password){
        password = password;
    }


}
