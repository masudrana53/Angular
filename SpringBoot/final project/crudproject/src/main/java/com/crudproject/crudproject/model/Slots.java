package com.crudproject.crudproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "slots")
public class Slots {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String slots;
    private String status;

    @ManyToOne
    @JoinColumn
    private Parking parkingtoslot;

    

}
