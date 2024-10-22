package com.shigeru.petshop.entities.enums;

public enum TypeBreed {

    CAT(1),
    DOG(2);

    private final int code;

    private TypeBreed(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static TypeBreed valueOf(int code){
        for(TypeBreed breed : TypeBreed.values()){
            if(breed.getCode() == code){
                return breed;
            }
        }
        throw new IllegalArgumentException("Invalid TypeBreed code");
    }

}
