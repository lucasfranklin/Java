package br.com.codenation.aplication.entity;

import javax.persistence.*;

@Entity(name = "address")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "zipCode", nullable = false, length = 14)
    private String zipCode;

    @Column(name = "street", nullable = false, length = 255)
    private  String street;

    @Column(name = "number")
    private int number;

    @Column(name = "district", nullable = false, length = 255)
    private String district;

    @Column(name = "city")
    private String city;

    @Column(name = "country", nullable = false, length = 255)
    private String country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
