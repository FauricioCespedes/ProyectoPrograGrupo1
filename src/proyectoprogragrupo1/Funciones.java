/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogragrupo1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author fauri
 */
public class Funciones {

    public Funciones() {
    }
    
    public boolean clientExist(String identificacion){
        try (BufferedReader br = new BufferedReader(new FileReader("./clients.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] client = linea.split(", ");
                if (client[2].equals(identificacion)){
                    return true;
                }
            }
            
            return false;
            
        } catch (IOException e) {
            return false;
        }
    }
    
    public boolean vehicleExist(String id){
        try (BufferedReader br = new BufferedReader(new FileReader("./vehicles.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] vehicle = linea.split(", ");
                if (vehicle[0].equals(id)){
                    return true;
                }
            }
            
            return false;
            
        } catch (IOException e) {
            return false;
        }
    }
}
