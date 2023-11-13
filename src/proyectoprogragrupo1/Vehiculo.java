 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogragrupo1;

import javax.swing.JOptionPane;

/**
 *
 * @author anchi
 */
public class Vehiculo {
    Vehiculo vehicle[] = new Vehiculo [15];    
    int numVehicle = 0;

    
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
    
    public String color;
    private int engine;
    private String brand;
    private int model;
    private int miles;
    private String type;
    private String status;
    private int doors;
    private int weight;
    private String transmission;
    private int passenger;
    private String customer = null;
    private String seller = null;

    public Vehiculo(String color, int engine, String brand, int model, int miles, String type, String status, int doors, int weight, String transmission, int passenger) {
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

    public String getType() {
        return type;
    }

    public String getStatus() {
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

    public void setType(String type) {
        this.type = type;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
    
     @Override
    public String toString() {
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

    
    public void addVehicle () {
    boolean bandera = false;

    for (int i=0; i<vehicle.length; i++){
        if(numVehicle == vehicle.length){
            break;
        }

        if (vehicle[i] == null){
            vehicle[i] = new Vehiculo();
            
            String carBrand = JOptionPane.showInputDialog(null, "Marca: ");
            vehicle[i].setBrand(carBrand);
            
            int carModel = Integer.parseInt(JOptionPane.showInputDialog("Modelo: "));
            vehicle[i].setModel(carModel);            

            int carEngine = Integer.parseInt(JOptionPane.showInputDialog("Motor: "));
            vehicle[i].setEngine(carEngine);  
            
            int carMiles = Integer.parseInt(JOptionPane.showInputDialog("Kilometraje: "));
            vehicle[i].setMiles(carMiles);
            
            String carTransmission = JOptionPane.showInputDialog(null, "Transmisión (Automática/Manual): ");
            vehicle[i].setTransmission(carTransmission);
            
            String carColor = JOptionPane.showInputDialog(null, "Color: ");
            vehicle[i].setColor(carColor);

            int carDoors = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de puertas: "));
            vehicle[i].setDoors(carDoors);
            
            int carPassenger = Integer.parseInt(JOptionPane.showInputDialog("Capacidad de pasajeros: "));
            vehicle[i].setPassenger(carPassenger);
 
            int carWeight = Integer.parseInt(JOptionPane.showInputDialog("Peso del auto: "));
            vehicle[i].setWeight(carWeight);
            
            String carType = JOptionPane.showInputDialog(null, "Tipo (SUV, Sedan o Hatchback): ");
            vehicle[i].setType(carType);
       

            bandera = true;
            break;
        }
    }

    if (bandera){
        JOptionPane.showMessageDialog(null, "Vehiculo registrado");
    }
    else {
        JOptionPane.showMessageDialog(null, "Ya no se cuenta con espacio disponible para registra un nuevo vehiculo");
        }
    
    }
    
    public void showInformation(){
        for (int i=0; i<vehicle.length; i++){
            if (vehicle[i]!= null){
                JOptionPane.showMessageDialog(null,"╔═══════════════════════════════════════╗\n"+
                                                               "                INFORMACION DEL VEHICULO         \n"+
                                                                     vehicle[i].toString()+"\n"+
                                                               "╚═══════════════════════════════════════╝");
                
                
            }
        }
    }
}
    
