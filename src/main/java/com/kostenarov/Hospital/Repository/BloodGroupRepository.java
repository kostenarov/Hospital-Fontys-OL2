package com.kostenarov.Hospital.Repository;

import com.kostenarov.Hospital.Entity.BloodGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BloodGroupRepository extends JpaRepository<BloodGroup, Long> {
    void deleteById(Long id);
    void addBloodGroup(BloodGroup bloodGroup);
    List<BloodGroup> findAll();
    Optional<BloodGroup> findById(Long id);
}
