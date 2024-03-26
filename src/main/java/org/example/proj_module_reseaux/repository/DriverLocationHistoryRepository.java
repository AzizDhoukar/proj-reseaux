package org.example.proj_module_reseaux.repository;

import org.example.proj_module_reseaux.model.DriverLocationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverLocationHistoryRepository extends JpaRepository<DriverLocationHistory, Long> {

}