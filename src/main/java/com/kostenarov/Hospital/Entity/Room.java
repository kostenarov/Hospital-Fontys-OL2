package com.kostenarov.Hospital.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
public class Room {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    @Getter
    @Setter
    private Set<Bed> beds;

    public void addBed(Bed bed) {
        if (beds != null) {
            beds.add(bed);
        }
    }

    public void removeBed(Bed bed) {
        if (beds != null) {
            beds.remove(bed);
        }
    }

    public void removeAllBeds() {
        if (beds != null) {
            for (Bed bed : beds) {
                bed.removePatient();
            }
            beds.clear();
        }
    }
}
