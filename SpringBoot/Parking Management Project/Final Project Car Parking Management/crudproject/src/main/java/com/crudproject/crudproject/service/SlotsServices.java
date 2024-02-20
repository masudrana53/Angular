package com.crudproject.crudproject.service;

import com.crudproject.crudproject.model.Slots;
import com.crudproject.crudproject.repository.SlotsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SlotsServices {

    private final SlotsRepository slotsRepository;

    public SlotsServices(SlotsRepository slotsRepository) {
        this.slotsRepository = slotsRepository;
    }

    public List<Slots> getAllSlots() {
        return slotsRepository.findAll();
    }

    public Optional<Slots> getSlotById(int id) {
        return slotsRepository.findById(id);
    }

    public Slots saveSlot(Slots slot) {
        return slotsRepository.save(slot);
    }

    public void deleteSlot(int id) {
        slotsRepository.deleteById(id);
    }


    public boolean isSlotActive(List<Integer> bookingSelectSlot, int index) {
        return bookingSelectSlot.contains(index);
    }

}
