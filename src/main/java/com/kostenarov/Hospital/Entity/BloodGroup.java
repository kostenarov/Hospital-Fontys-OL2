package com.kostenarov.Hospital.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Data
public class BloodGroup {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public BloodGroup(String name) {
        this.name = name;
    }

    public BloodGroup() {
    }
}
