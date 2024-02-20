package com.crudproject.crudproject.repository;

import com.crudproject.crudproject.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Integer> {
}
