package com.projetpfe.project.Entities;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity

public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private Long id;

    private String name;

    private String email;

    private String address;

    private String taxRegistrationNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE )
    private List<User> listClient; //if Client

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTaxRegistrationNumber() {
        return taxRegistrationNumber;
    }

    public void setTaxRegistrationNumber(String taxRegistrationNumber) {
        this.taxRegistrationNumber = taxRegistrationNumber;
    }

    public List<User> getListClient() {
        return listClient;
    }

    public void setListClient(List<User> listClient) {
        this.listClient = listClient;
    }

    public Company() {
    }
}
