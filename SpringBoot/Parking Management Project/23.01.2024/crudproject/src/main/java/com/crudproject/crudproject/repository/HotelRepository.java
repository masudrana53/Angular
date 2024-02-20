package com.crudproject.crudproject.repository;

import com.crudproject.crudproject.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository <Hotel, Integer> {

}
