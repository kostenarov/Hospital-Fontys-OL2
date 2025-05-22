package com.kostenarov.Hospital.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Audited
public class Patient extends Human{
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "blood_group_id")
    private BloodGroup bloodGroup;

    public Patient(String name, String surname, short age, BloodGroup bloodGroup) {
        super(name, surname, age);
        this.bloodGroup = bloodGroup;
    }

    public Patient() {

    }
}
