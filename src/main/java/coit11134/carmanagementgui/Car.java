/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coit11134.carmanagementgui;

/**
 *
 * @author lil
 */
public class Car {

    private int carID;
    private String brand;
    private String model;
    private int year;
    private double price;
    private String category;

    public Car(int carID, String brand, String model, int year, double price, String category) {
        this.carID = carID;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.category = category;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        //return "\ncarID = " + carID + ", brand = " + brand + ", model = " + model + ", year = " + year + ", price = " + price + ", category = " + category + "\n";
        return (getCarID() + "," + getBrand() + "," + getModel() + "," + getYear() + "," + getPrice() + "," + getCategory());
    }

}
