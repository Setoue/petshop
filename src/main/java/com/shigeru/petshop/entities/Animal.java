package com.shigeru.petshop.entities;

import com.shigeru.petshop.entities.enums.TypeBreed;
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
    private TypeBreed typeBreed;

    // relacionamento com o dono

    public Animal(){};

    public Animal(Long id, String name, int age, TypeBreed typeBreed){
        this.id = id;
        this.name = name;
        this.age = age;
        setTypeAnimal(typeBreed);
        //relacionameno com dono
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public TypeBreed getTypeAnimal() {
        return typeBreed;
    }

    public void setTypeAnimal(TypeBreed typeBreed) {
        this.typeBreed = typeBreed;
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
