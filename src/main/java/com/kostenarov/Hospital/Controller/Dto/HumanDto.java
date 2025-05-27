package com.kostenarov.Hospital.Controller.Dto;

import lombok.Data;
import lombok.Getter;

@Data
public abstract class HumanDto {
    @Getter
    protected String name;
    @Getter
    protected String surname;
    @Getter
    protected short age;

    public HumanDto(String name, String surname, short age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public HumanDto() {
    }

    public String getFullName() {
        return name + " " + surname;
    }

    public String getFullNameWithAge() {
        return name + " " + surname + ", age: " + age;
    }
}
