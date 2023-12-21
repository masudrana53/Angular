package com.masudrana.SpringBoot55.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int roll;
    private String name;
    @Column(unique = true, nullable=false, name = "email")
    private String email;
    private String gender;
    private Date date;
    private String subject;
    private String hobby;

}
