package com.kostenarov.Hospital.Repository;

import com.kostenarov.Hospital.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    void deleteById(Long id);
    List<Room> findAll();
    Optional<Room> findById(Long id);
    boolean existsById(Long id);
}
