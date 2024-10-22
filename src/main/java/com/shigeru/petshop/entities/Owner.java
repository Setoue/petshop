package com.shigeru.petshop.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_owner")
public class Owner implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    //Entidade endereço vinculado ao dono
    private String address;

    public Owner(){}

    public Owner(Long id, String name, String phoneNumber, String email, String address){
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        //Entidade endereço vinculado ao dono
        this.address = address;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Owner owner)) return false;

        return getId().equals(owner.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
