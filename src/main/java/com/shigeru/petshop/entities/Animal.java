package com.shigeru.petshop.entities;

import com.shigeru.petshop.entities.enums.TypeBreed;
import jakarta.persistence.*;

import java.beans.ConstructorProperties;
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
    private Integer typeBreed;

    // relacionamento com o dono

    public Animal(){}

    public Animal(Long id, String name, int age, TypeBreed typeBreed){
        this.id = id;
        this.name = name;
        this.age = age;
        setTypeBreed(typeBreed);
        //relacionameno com dono
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

    public TypeBreed getTypeBreed() {
        return TypeBreed.valueOf(typeBreed);
    }

    public void setTypeBreed(TypeBreed typeBreed) {
        if(typeBreed != null){
            this.typeBreed = typeBreed.getCode();
        }
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
