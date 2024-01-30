package com.employee.rest_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int did;

    @Column(nullable = false)
    private String dname;

    @Column(unique = true, nullable = false)
    private String demail;

    @Column()
    private String daddress;
}
