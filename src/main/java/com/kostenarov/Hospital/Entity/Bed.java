package com.kostenarov.Hospital.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Bed {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(optional = true)
    @Getter
    @Setter
    private Patient patient;

    public void assignPatient(Patient patient) {
        this.patient = patient;
    }

    public void removePatient() {
        this.patient = null;
    }

}
