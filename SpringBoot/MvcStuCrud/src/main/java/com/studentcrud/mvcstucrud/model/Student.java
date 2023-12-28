
package com.studentcrud.mvcstucrud.model;


public class Student {
    
    private int id;
    private String roll;
    private String name;
    private String department;
    private String marks;

    public Student() {
    }

    public Student(int id, String roll, String name, String department, String marks) {
        this.id = id;
        this.roll = roll;
        this.name = name;
        this.department = department;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Student{" + "id=" + id + ", roll=" + roll + ", name=" + name + ", department=" + department + ", marks=" + marks + '}';
    }
    
    
}
