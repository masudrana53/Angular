
package com.mycompany.mvcempcrudtest.model;

import java.sql.Date;


public class Employee {
    
    private int id;
    private String name;
    private String price;
    private String quantity;
    private String brand;

    public Employee() {
    }

    public Employee(int id, String name, String price, String quantity, String brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", brand=" + brand + '}';
    }
    

    

    
}
