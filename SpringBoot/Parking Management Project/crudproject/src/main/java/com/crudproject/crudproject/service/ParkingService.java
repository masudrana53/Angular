package com.crudproject.crudproject.service;

import com.crudproject.crudproject.model.Parking;
import com.crudproject.crudproject.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;

    @Autowired
    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    public List<Parking> getAllParkings() {
        return parkingRepository.findAll();
    }

    public Optional<Parking> getParkingById(int id) {
        return parkingRepository.findById(id);
    }

    public Parking saveParking(Parking parking) {
        return parkingRepository.save(parking);
    }

    public void deleteParking(int id) {
        parkingRepository.deleteById(id);
    }
}
