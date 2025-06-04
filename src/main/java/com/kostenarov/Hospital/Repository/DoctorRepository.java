package com.kostenarov.Hospital.Repository;

import com.kostenarov.Hospital.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    void deleteById(Long id);
    Doctor findByName(String name);
    Optional<Doctor> findById(Long id);
    boolean existsByName(String name);
    List<Doctor> findAllBySpecialization(String specialization);
}
