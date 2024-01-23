package com.crudproject.crudproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "booking")

public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "parking_id")
    private Parking parking;

    private String parkingName;
    private String carNumber;
    private int selectSlot;
    private LocalDate fromDate;
    private LocalDate toDate;
    private LocalTime fromTime;
    private LocalTime toTime;


//    @FutureOrPresent(message = "From Date must be present or in the future")
//    private LocalDate fromDate;
//
//    @Future(message = "To Date must be in the future")
//    private LocalDate toDate;

}
