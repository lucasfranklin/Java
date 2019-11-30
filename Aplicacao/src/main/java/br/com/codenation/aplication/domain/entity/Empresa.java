package br.com.codenation.aplication.entity;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

@Entity(name = "company")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    @NotNull
    private String name;

    @Column(name = "document")
    private String document;

    @Column(name = "vacancies")
    private int vacancies;

    @Column(name = "site")
    private String site;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Usuario> userList;


    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Usuario> users = new ArrayList<>();

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

    public String getSite() { return site; }

    public void setSite(String site) { this.site = site; }

    public int getVagas(){
        return vacancies;
    }

    public void setVagas(int vaga){
        vacancies = vaga;
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
