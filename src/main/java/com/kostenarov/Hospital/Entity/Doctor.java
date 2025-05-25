package com.kostenarov.Hospital.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Doctor extends Human{
    @Id
    @GeneratedValue
    private Long id;

    @Getter
    @Setter
    private String Specialization = "General Practitioner";

    @ManyToMany(mappedBy = "doctors")
    @Getter
    private Set<Patient> patients = new HashSet<Patient>();

    public Doctor() {
    }

    public Doctor(String name, String surname, short age, String specialization) {
        super(name, surname, age);
        this.Specialization = specialization;
    }

    public void addPatient(Patient patient) {
        if (patient != null && !patients.contains(patient)) {
            patients.add(patient);
            patient.addDoctor(this);
        }
    }

    public void removePatient(Patient patient) {
        if (patient != null && patients.contains(patient)) {
            patients.remove(patient);
            patient.removeDoctor(this);
        }
    }

    public void setSpecialization(String specialization) {
        if (specialization != null && !specialization.isEmpty()) {
            this.Specialization = specialization;
        }
    }

}
