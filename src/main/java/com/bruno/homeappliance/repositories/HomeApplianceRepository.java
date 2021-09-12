package com.bruno.homeappliance.repositories;

import com.bruno.homeappliance.entities.HomeAppliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface HomeApplianceRepository extends JpaRepository<HomeAppliance, String> {

    @Transactional(readOnly = true)
    Optional<HomeAppliance> findByNameIgnoreCase(String name);
}
