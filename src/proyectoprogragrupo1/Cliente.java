/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogragrupo1;


import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author juanp
 */
public class Cliente {
    private String nombre;
    private String apellidos;
    private String identificacion;
    private String correo;
    private String numeroTelefonico;

    public Cliente() {
        setNombre(JOptionPane.showInputDialog("Ingrese el nombre del cliente: "));
        setApellidos(JOptionPane.showInputDialog("Ingrese los apellidos del cliente: "));
        
        
        boolean isValidIdentification = false;
        do {
            isValidIdentification = this.setIdentificacion(JOptionPane.showInputDialog("Ingrese la cédula del cliente: "));
        }while(!isValidIdentification);
        
        setCorreo(JOptionPane.showInputDialog("Ingrese el correo del cliente: "));
        setNumeroTelefonico(JOptionPane.showInputDialog("Ingrese el número telefónico del cliente: "));
    }
    
    static void saveClient(Cliente client){   
        try (FileWriter fw = new FileWriter("./clients.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {

            out.print(client);

            JOptionPane.showMessageDialog(null, "Clientes guardados correctamente");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar clientes");
        }
    }
    
    static void showClients(){
        String clients = "--------- Clientes ---------\n";
        
        try (BufferedReader br = new BufferedReader(new FileReader("./clients.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                clients += linea + "\n";
            }
            
            JOptionPane.showMessageDialog(null, clients);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public boolean setIdentificacion(String identificacion) {
        try (BufferedReader br = new BufferedReader(new FileReader("./clients.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] client = linea.split(", ");
                if (client[2].equals(identificacion)){
                    JOptionPane.showMessageDialog(null, "La cédula que ingresó ya existe, utilice otra");
                    return false;
                }
            }
            this.identificacion = identificacion;
            return true;
            
        } catch (IOException e) {
            return false;
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }
    
        @Override
    public String toString(){
        return  this.nombre + ", " +
                this.apellidos + ", " +
                this.identificacion + ", " +
                this.correo + ", " +
                this.numeroTelefonico + "\n";
    }
}
