 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogragrupo1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author anchi
 */
public class Vehiculo {
    Vehiculo vehicle[] = new Vehiculo [15];
    int numVehicle = 0;

    
    public enum Type{
    SUV,
    Sedan,
    Hatchback
    }
    
    public enum Status{
    Disponible,
    Reservado,
    Vendido
    }
        
    public String color;
    private int engine;
    private String brand;
    private int model;
    private int miles;
    private int doors;
    private int weight;
    private String transmission;
    private int passenger;
    private Status status;
    private Type type;
    private String customer = null;
    private String seller = null;

    public Vehiculo(String color, int engine, String brand, int model, int miles, int doors, int weight, String transmission, int passenger) {
        this.color = color;
        this.engine = engine;
        this.brand = brand;
        this.model = model;
        this.miles = miles;
        this.type = type;
        this.status = status;
        this.doors = doors;
        this.weight = weight;
        this.transmission = transmission;
        this.passenger = passenger;
        
    }

    public Vehiculo() {
    }
    
    public void addVehicle () {
        Vehiculo vehicle = new Vehiculo();

        String carBrand = JOptionPane.showInputDialog(null, "Marca: ");
        while (carBrand.isEmpty()){
            carBrand = JOptionPane.showInputDialog(null, "Marca: ");
        }
        vehicle.setBrand(carBrand);

        int carModel = Integer.parseInt(JOptionPane.showInputDialog("Modelo: "));
        vehicle.setModel(carModel);            

        int carEngine = Integer.parseInt(JOptionPane.showInputDialog("Motor: "));
        vehicle.setEngine(carEngine);  

        int carMiles = Integer.parseInt(JOptionPane.showInputDialog("Kilometraje: "));
        vehicle.setMiles(carMiles);

        String carTransmission = JOptionPane.showInputDialog(null, "Transmisión (Automática/Manual): ");
        vehicle.setTransmission(carTransmission);

        String carColor = JOptionPane.showInputDialog(null, "Color: ");
        while (carColor.isEmpty()){
            carColor = JOptionPane.showInputDialog(null, "Color: ");
        }
        vehicle.setColor(carColor);

        int carDoors = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de puertas: "));
        vehicle.setDoors(carDoors);

        int carPassenger = Integer.parseInt(JOptionPane.showInputDialog("Capacidad de pasajeros: "));
        vehicle.setPassenger(carPassenger);

        int carWeight = Integer.parseInt(JOptionPane.showInputDialog("Peso del auto: "));
        vehicle.setWeight(carWeight); 

        int carType = Integer.parseInt(JOptionPane.showInputDialog("Disponibilidad: \n1.SUV "
                                                                      + "\n2.Sedan \n3.Hatchback "));
        switch(carType){
            case 1:
                vehicle.setType(Type.SUV);
                break;
            case 2:
                vehicle.setType(Type.Sedan);
                break;
            case 3:
                vehicle.setType(Type.Hatchback);
                break;
        }    

        vehicle.setStatus(Status.Disponible);
        
        //Almacenamiento del vehículo en el txt
        try (FileWriter fw = new FileWriter("./vehicles.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {

            out.print(vehicle);

            JOptionPane.showMessageDialog(null, "Vehiculo registrado correctamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar vehículo");
        }
    }
    
    public void showInformation(){
        int statusOption;
        statusOption= Integer.parseInt(JOptionPane.showInputDialog(null, "1.Disponibles \n2.Reservados "
                + "\n3.Vendidos \nIngrese la opcion que desea consultar"));
        
        switch (statusOption){
            case 1:
               for (int i=0; i<vehicle.length; i++){
                    if (vehicle[i]!= null && vehicle[i].getStatus().equals(Status.Disponible)){
                        JOptionPane.showMessageDialog(null,"╔═══════════════════════════════════════╗\n"+
                                                                        "                INFORMACION DEL VEHICULO         \n"+
                                                                                 vehicle[i].info()+"\n"+
                                                                        "╚═══════════════════════════════════════╝");              
                    }
               }
               break;
            case 2:
               for (int i=0; i<vehicle.length; i++){
                    if (vehicle[i]!= null && vehicle[i].getStatus().equals(Status.Reservado)){
                        JOptionPane.showMessageDialog(null,"╔═══════════════════════════════════════╗\n"+
                                                                        "                INFORMACION DEL VEHICULO         \n"+
                                                                                 vehicle[i].info()+"\n"+
                                                                        "╚═══════════════════════════════════════╝");              
                    }
               }
               break;
            case 3:
               for (int i=0; i<vehicle.length; i++){
                    if (vehicle[i]!= null && vehicle[i].getStatus().equals(Status.Vendido)){
                        JOptionPane.showMessageDialog(null,"╔═══════════════════════════════════════╗\n"+
                                                                        "                INFORMACION DEL VEHICULO         \n"+
                                                                                 vehicle[i].info()+"\n"+
                                                                        "╚═══════════════════════════════════════╝");              
                    }
               }
               break;
       }
    }
    
    public String getColor() {
        return color;
    }
    public int getEngine() {
        return engine;
    }
    public String getBrand() {
        return brand;
    }
    public int getModel() {
        return model;
    }
    public int getMiles() {
        return miles;
    }
    public Type getType() {
        return type;
    }
    public Status getStatus() {
        return status;
    }
    public int getDoors() {
        return doors;
    }
    public int getWeight() {
        return weight;
    }
    public String getTransmission() {
        return transmission;
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
    public void setEngine(int engine) {
        this.engine = engine;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setModel(int model) {
        this.model = model;
    }
    public void setMiles(int miles) {
        this.miles = miles;
    }
    public void setDoors(int doors) {
        this.doors = doors;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    } 
    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }
    public void setStatus(Status status) {
            this.status = status;
        }
    public void setType(Type type) {
            this.type = type;
        }  
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    public void setSeller(String seller) {
        this.seller = seller;
    }
    
    public String info() {
        return  "Marca= "+ brand +
                "\nModelo= " + model +
                "\nMotor= " + engine +
                "\nKilometraje= " + miles +
                "\nColor= "+ color +
                "\nTransmisión= " + transmission+
                "\nTipo= " + type +
                "\nPeso= " + weight +
                "\nCapacidad de pasajeros= " + passenger +
                "\nCantidad de puertas= " + doors +
                "\nEstado= " + status +
                "\nCliente= " + customer +
                "\nVendedor= " + seller;
    }
    
    @Override
    public String toString(){
        return  this.brand + ", " +
                this.model + ", " +
                this.engine + ", " +
                this.miles + ", " +
                this.color + ", " +
                this.transmission + ", " +
                this.type + ", " +
                this.weight + ", " +
                this.passenger + ", " +
                this.doors + ", " +
                this.status + ", " +
                this.customer + ", " +
                this.seller + "\n";
    }
}