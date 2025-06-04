package com.kostenarov.Hospital.Repository;

import com.kostenarov.Hospital.Entity.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BedRepository extends JpaRepository<Bed, Long> {
    void deleteById(Long id);
    List<Bed> findAll();
    Optional<Bed> findById(Long id);
    boolean existsById(Long id);
}
