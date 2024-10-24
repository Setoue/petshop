package com.shigeru.petshop.entities.enums;

public enum TypeAnimal {

    CAT(1),
    DOG(2);

    private final int code;

    private TypeAnimal(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static TypeAnimal valueOf(int code){
        for(TypeAnimal animal : TypeAnimal.values()){
            if(animal.getCode() == code){
                return animal;
            }
        }
        throw new IllegalArgumentException("Invalid TypeAnimal code");
    }

}
