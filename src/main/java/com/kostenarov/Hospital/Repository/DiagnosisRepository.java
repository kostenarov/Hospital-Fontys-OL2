package com.kostenarov.Hospital.Repository;

import com.kostenarov.Hospital.Entity.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {
    void deleteById(Long id);
    Diagnosis findByName(String name);
    Optional<Diagnosis> findById(Long id);
    boolean existsByName(String name);
}
