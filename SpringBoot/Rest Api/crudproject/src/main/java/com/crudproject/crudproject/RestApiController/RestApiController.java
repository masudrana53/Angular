package com.crudproject.crudproject.RestApiController;
import com.crudproject.crudproject.model.Hotel;
import com.crudproject.crudproject.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")

public class RestApiController {

    @Autowired
    HotelRepository hotelRepository;

    @GetMapping("/hotel")
    public List<Hotel> allHotel(){
        return hotelRepository.findAll();
    }

    @PostMapping("/hotel")
    public Hotel saveHotel(@RequestBody Hotel hotel){
        return hotelRepository.save(hotel);
    }

    @DeleteMapping("/hotel/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        boolean exist=hotelRepository.existsById(id);
        if(exist){
            hotelRepository.deleteById(id);
            return new ResponseEntity<>("Hotel is deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Hotel is not exist", HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/hotel/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody Hotel hotel){
        boolean exist=hotelRepository.existsById(id);

        if(exist){
            Hotel hotel1=hotelRepository.findById(id).get();
            hotel1.setName(hotel.getName());
            hotel1.setId(id);
            hotelRepository.save(hotel);
            return  new ResponseEntity<>("Hotel is Updated", HttpStatus.OK);
        }
        return  new ResponseEntity<>("Hotel is not Exist", HttpStatus.BAD_REQUEST);
    }
}
