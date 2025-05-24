package com.kostenarov.Hospital.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Data
public class BloodGroup {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    public BloodGroup(String name) {
        this.name = name;
    }

    public BloodGroup() {
    }
}
