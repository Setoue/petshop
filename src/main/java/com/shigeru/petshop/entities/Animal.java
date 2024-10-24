package com.shigeru.petshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shigeru.petshop.entities.enums.TypeAnimal;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_animal")
public class Animal implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private Integer typeAnimal;
    private String breed;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner ownerAnimal;

    public Animal(){}

    public Animal(Long id, String name, int age, TypeAnimal typeAnimal, String breed){
        this.id = id;
        this.name = name;
        this.age = age;
        setTypeAnimal(typeAnimal);
        this.breed = breed;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public TypeAnimal getTypeAnimal() {
        return TypeAnimal.valueOf(typeAnimal);
    }

    public void setTypeAnimal(TypeAnimal typeAnimal) {
        if(typeAnimal != null){
            this.typeAnimal = typeAnimal.getCode();
        }
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @JsonIgnore
    public Owner getOwner() {
        return ownerAnimal;
    }

    public void setOwner(Owner ownerAnimal) {
        this.ownerAnimal = ownerAnimal;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal animal)) return false;

        return getId().equals(animal.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
