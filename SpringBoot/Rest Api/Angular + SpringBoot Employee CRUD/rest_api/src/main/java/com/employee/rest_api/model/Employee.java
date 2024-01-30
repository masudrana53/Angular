package com.employee.rest_api.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employees")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private String email;
    private String department;
    private String gender;
}
