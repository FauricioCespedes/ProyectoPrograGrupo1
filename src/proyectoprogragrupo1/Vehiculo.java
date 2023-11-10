/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogragrupo1;

/**
 *
 * @author anchi
 */
public class Vehiculo {
    public enum type{
    SUV,
    Sedan,
    Hatchback
    }
    public enum status{
    Disponible,
    Reservado,
    Vendido
    }
    
    private String color;
    private int year;
    private int engine;
    private String brand;
    private String model;
    private int miles;
    private String type;
    private String status;
    private String traction;
    private int passenger;
    private String customer = null;
    private String seller = null;

    public Vehiculo(String color, int year, int engine, String brand, String model, int miles, String type, String status, String traction, int passenger) {
        this.color = color;
        this.year = year;
        this.engine = engine;
        this.brand = brand;
        this.model = model;
        this.miles = miles;
        this.type = type;
        this.status = status;
        this.traction = traction;
        this.passenger = passenger;
    }

    public Vehiculo() {
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public int getEngine() {
        return engine;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getMiles() {
        return miles;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public String getTraction() {
        return traction;
    }

    public int getPassenger() {
        return passenger;
    }

    public String getCustomer() {
        return customer;
    }

    public String getSeller() {
        return seller;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setEngine(int engine) {
        this.engine = engine;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTraction(String traction) {
        this.traction = traction;
    }

    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
    
}
