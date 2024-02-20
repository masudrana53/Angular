package com.crudproject.crudproject.repository;

import com.crudproject.crudproject.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
