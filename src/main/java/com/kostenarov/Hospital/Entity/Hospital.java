package com.kostenarov.Hospital.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Hospital {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private Set<Room> rooms;

    public void addRoom(Room room) {
        if (rooms != null) {
            rooms.add(room);
        }
    }

    public void removeRoom(Room room) {
        if (rooms != null && rooms.contains(room)) {
            room.removeAllBeds();
            rooms.remove(room);
        }
    }
}
