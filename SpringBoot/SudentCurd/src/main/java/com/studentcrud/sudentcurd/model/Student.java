/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentcrud.sudentcurd.model;

/**
 *
 * @author user
 */
public class Student {
    
    private int id;
    private String name;
    private String gender;
    private String department;
    private String marks;

    public Student() {
    }

    public Student(int id, String name, String gender, String department, String marks) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", department=" + department + ", marks=" + marks + '}';
    }
    
    

}
