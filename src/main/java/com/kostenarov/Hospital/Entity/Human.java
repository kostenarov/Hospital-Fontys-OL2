package com.kostenarov.Hospital.Entity;

import lombok.Getter;
import lombok.Setter;

public abstract class Human {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String surname;
    @Getter
    @Setter
    private short age;

    public Human(String name, String surname, short age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Human() {
    }
}
