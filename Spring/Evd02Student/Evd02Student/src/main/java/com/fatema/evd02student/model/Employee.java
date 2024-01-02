/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatema.evd02student.model;

import java.sql.Date;



/**
 *
 * @author user
 */
public class Employee {
    
    
    private int id;
    private String ename;
    private String department;
    private int  salary;
//    private Date  dob;
    private String gender;

    public Employee() {
    }

    public Employee(int id, String ename, String department, int salary, String gender) {
        this.id = id;
        this.ename = ename;
        this.department = department;
        this.salary = salary;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
   
}
