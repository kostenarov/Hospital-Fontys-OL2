package com.kostenarov.Hospital.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Data
public class BloodGroup {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    @Getter
    @Setter
    private String type;

    public BloodGroup(String name) {
        this.type = name;
    }

    public BloodGroup() {
    }

    public String getType() {
        return type != null ? type : "No blood group assigned";
    }
}
