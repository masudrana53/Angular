package com.crudproject.crudproject.repository;

import com.crudproject.crudproject.model.Slots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotsRepository extends JpaRepository<Slots, Integer> {
}
