 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogragrupo1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
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
        
    private String id;
    private String color;
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
        
        boolean isValidId = false;
        do {
            isValidId = vehicle.setId(JOptionPane.showInputDialog("Ingrese el id del vehículo: "));
        }while(!isValidId);

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
    
    public void updateVehicle(){
        int option = 0;
        
        do{
            option = Integer.parseInt(JOptionPane.showInputDialog("1. Deseo Reservar Vehículo\n2. Deseo Comprar Vehículo\n3. Deseo Actualizar Vehículo"));
        }while(option < 1 || option > 3);
        
        if (option == 1){
            String idClient = JOptionPane.showInputDialog("Ingrese el id del cliente para la reserva: ");
            Funciones funciones = new Funciones();
            boolean clientExists = funciones.clientExist(idClient);
            
            if(!clientExists){
                JOptionPane.showMessageDialog(null, "Ese cliente no existe.");
                return;
            }
            
            String idVehicle = JOptionPane.showInputDialog("Ingrese el id del vehículo para la reserva: ");
            boolean vehicleExists = funciones.vehicleExist(idVehicle);
            
            if(!vehicleExists){
                JOptionPane.showMessageDialog(null, "Ese vehículo no existe.");
                return;
            }
            
            Vehiculo vehicle = new Vehiculo();
            vehicle = vehicle.getVehicleById(idVehicle);
            
            if (vehicle == null){
                return;
            }
            
            vehicle.setCustomer(idClient);
            vehicle.setSeller(Config.nombreVendedor);
            vehicle.setStatus(Status.Reservado);
            
            option = 0;
            do{
                option = Integer.parseInt(JOptionPane.showInputDialog("¿Está seguro que desea reservarlo?\n1. Sí\n2. No"));
            }while(option < 1 || option > 2);
            
            if (option == 2){
                JOptionPane.showMessageDialog(null, "Reserva cancelada exitosamente.");
                vehicle.setCustomer(null);
                vehicle.setSeller(null);
                vehicle.setStatus(Status.Disponible);
                return;
            }
            
            Vehiculo.updateVehicleTxt(vehicle);
        }
        else if (option == 2){
            String idClient = JOptionPane.showInputDialog("Ingrese el id del cliente para la compra: ");
            Funciones funciones = new Funciones();
            boolean clientExists = funciones.clientExist(idClient);
            
            if(!clientExists){
                JOptionPane.showMessageDialog(null, "Ese cliente no existe.");
                return;
            }
            
            String idVehicle = JOptionPane.showInputDialog("Ingrese el id del vehículo para la compra: ");
            boolean vehicleExists = funciones.vehicleExist(idVehicle);
            
            if(!vehicleExists){
                JOptionPane.showMessageDialog(null, "Ese vehículo no existe.");
                return;
            }
            
            Vehiculo vehicle = new Vehiculo();
            vehicle = vehicle.getVehicleById(idVehicle);
            
            if (vehicle == null){
                return;
            }
            
            vehicle.setCustomer(idClient);
            vehicle.setSeller(Config.nombreVendedor);
            vehicle.setStatus(Status.Vendido);
            
            option = 0;
            do{
                option = Integer.parseInt(JOptionPane.showInputDialog("¿Está seguro que desea comprarlo?\n1. Sí\n2. No"));
            }while(option < 1 || option > 2);
            
            if (option == 2){
                JOptionPane.showMessageDialog(null, "Compra cancelada exitosamente.");
                vehicle.setCustomer(null);
                vehicle.setSeller(null);
                vehicle.setStatus(Status.Disponible);
                return;
            }
            
            Vehiculo.updateVehicleTxt(vehicle);
        }
        else{
            Funciones funciones = new Funciones();
            
            String idVehicle = JOptionPane.showInputDialog("Ingrese el id del vehículo para la modificarlo: ");
            boolean vehicleExists = funciones.vehicleExist(idVehicle);
            
            if(!vehicleExists){
                JOptionPane.showMessageDialog(null, "Ese vehículo no existe.");
                return;
            }
            
            Vehiculo vehicle = new Vehiculo();
            
            vehicle.setId2(idVehicle);
            
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
            
            option = 0;
            do{
                option = Integer.parseInt(JOptionPane.showInputDialog("¿Está seguro que desea modificarlo?\n1. Sí\n2. No"));
            }while(option < 1 || option > 2);
            
            if (option == 2){
                JOptionPane.showMessageDialog(null, "Cancelado exitosamente.");
                vehicle.setCustomer(null);
                vehicle.setSeller(null);
                vehicle.setStatus(Status.Disponible);
                return;
            }
            
            Vehiculo.updateVehicleTxt(vehicle);
        }
    }
    
    private static void updateVehicleTxt(Vehiculo newVehicle){
        String fileText = "";
        
        try (BufferedReader br = new BufferedReader(new FileReader("./vehicles.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] vehicle = linea.split(", ");
                
                if(vehicle[0].equals(newVehicle.getId())){
                    linea = newVehicle.toString();
                    linea = linea.substring(0, linea.length() - 2);
                }
                
                fileText += linea + "\n";
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo");
        }
        
        try (FileWriter fw = new FileWriter("./vehicles.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {

            out.print(fileText);

            JOptionPane.showMessageDialog(null, "Cambios realizados correctamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar vehículo");
        }
    }
    
    public Vehiculo getVehicleById(String id){
        Vehiculo vehicle = new Vehiculo();
        
        try (BufferedReader br = new BufferedReader(new FileReader("./vehicles.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] stringVehicle = linea.split(", ");
                
                if(stringVehicle != null){
                    vehicle.setId2(stringVehicle[0]);
                    vehicle.setBrand(stringVehicle[1]);
                    vehicle.setModel(Integer.parseInt(stringVehicle[2]));
                    vehicle.setEngine(Integer.parseInt(stringVehicle[3]));
                    vehicle.setMiles(Integer.parseInt(stringVehicle[4]));
                    vehicle.setColor(stringVehicle[5]); 
                    vehicle.setTransmission(stringVehicle[6]);
                    vehicle.setWeight(Integer.parseInt(stringVehicle[8]));
                    vehicle.setPassenger(Integer.parseInt(stringVehicle[9]));
                    vehicle.setDoors(Integer.parseInt(stringVehicle[10]));

                    
                    if("SUV".equals(stringVehicle[7])){
                        vehicle.setType(Type.SUV);
                    }
                    else if("Sedan".equals(stringVehicle[7])){
                        vehicle.setType(Type.Sedan);
                    }
                    else if("Hatchback".equals(stringVehicle[7])){
                        vehicle.setType(Type.Hatchback);
                    }
                    
                    if(!"Disponible".equals(stringVehicle[11])){
                        JOptionPane.showMessageDialog(null, "El vehículo no está disponible.");
                        return null;
                    }
                    vehicle.setStatus(Status.Disponible);
                    
                    return vehicle;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo");
        }
        
        return null;
    }
    
    public void showInformation(){
        String vehicles = "--------- Vehículos ---------\n";
        
        try (BufferedReader br = new BufferedReader(new FileReader("./vehicles.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                vehicles += linea + "\n";
            }
            
            JOptionPane.showMessageDialog(null, vehicles);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo");
        }
    }
    
    public String getId() {
        return id;
    }
    
    public boolean setId(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader("./vehicles.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] vehicle = linea.split(", ");
                if (vehicle[0].equals(id)){
                    JOptionPane.showMessageDialog(null, "El vehículo ya fue registrado.");
                    return false;
                }
            }
            this.id = id;
            return true;
            
        } catch (IOException e) {
            return false;
        }
    }
    
    public void setId2(String id) {
        this.id = id;
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
        return  this.id + ", " +
                this.brand + ", " +
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
    
    //Para los reportes
    public static int[] countVehicles(){
        int[] vehicleCounters = new int[3];
        int totalSold = 0;
        int totalReserved = 0;
        int totalAvialable = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader("./vehicles.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] vehicle = linea.split(", ");
                
                if ("Vendido".equals(vehicle[11])){
                    totalSold++;
                }
                else if ("Reservado".equals(vehicle[11])){
                    totalReserved++;
                }
                else if ("Disponible".equals(vehicle[11])){
                    totalAvialable++;
                }
            }
            vehicleCounters[0] = totalSold;
            vehicleCounters[1] = totalReserved;
            vehicleCounters[2] = totalAvialable;
            
        } catch (IOException e) {
            return vehicleCounters;
        }
        
        return vehicleCounters;
    }
}