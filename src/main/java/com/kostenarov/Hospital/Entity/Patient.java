package com.kostenarov.Hospital.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.hibernate.envers.Audited;
import com.kostenarov.Hospital.Entity.BloodGroup;
import com.kostenarov.Hospital.Entity.Diagnosis;
import com.kostenarov.Hospital.Entity.Doctor;


import java.util.HashSet;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Patient extends Human{
    @Id
    @GeneratedValue
    private Long id;

    @Getter
    private boolean isSmoker = false;

    @ManyToOne
    @Getter
    @JoinColumn(name = "blood_group_id")
    private BloodGroup bloodGroup;

    @ManyToMany
    @Getter
    private HashSet<Doctor> doctors = new HashSet<Doctor>();

    @OneToMany
    @Getter
    @JoinColumn(name = "diagnosis_id")
    private HashSet<Diagnosis> diagnoses = new HashSet<Diagnosis>();

    public Patient(String name, String surname, short age, BloodGroup bloodGroup, boolean isSmoker, HashSet<Doctor> doctors, HashSet<Diagnosis> diagnoses) {
        super(name, surname, age);
        this.bloodGroup = bloodGroup;
        this.isSmoker = isSmoker;
        this.doctors = doctors;
        this.diagnoses = diagnoses;
    }

    public Patient() {

    }

    public void addDoctor(Doctor doctor) {
        if (doctor != null && !doctors.contains(doctor)) {
            doctors.add(doctor);
            doctor.addPatient(this);
        }
    }

    public void removeDoctor(Doctor doctor) {
        if (doctor != null && doctors.contains(doctor)) {
            doctors.remove(doctor);
            doctor.removePatient(this);
        }
    }

    public void addDiagnosis(Diagnosis diagnosis) {
        if (diagnosis != null && !diagnoses.contains(diagnosis)) {
            diagnoses.add(diagnosis);
        }
    }

    public void removeDiagnosis(Diagnosis diagnosis) {
        if (diagnosis != null && diagnoses.contains(diagnosis)) {
            diagnoses.remove(diagnosis);
        }
    }
}
