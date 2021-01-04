package com.befty.enums;

public enum Gender {

    MALE("Male"),FEMALE("Female");

    private final String value;

    private Gender (String value){
        this.value = value;
    }

    private String getValue(){
        return value;
    }
}
