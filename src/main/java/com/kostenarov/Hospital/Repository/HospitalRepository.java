package com.kostenarov.Hospital.Repository;

import com.kostenarov.Hospital.Entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    void deleteById(Long id);
    List<Hospital> findAll();
    Optional<Hospital> findById(Long id);
    boolean existsById(Long id);
}
