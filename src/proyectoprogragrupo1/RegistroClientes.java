/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogragrupo1;

import javax.swing.JOptionPane;

/**
 *
 * @author juanp
 */
public class RegistroClientes {
    public static void registroClientes() {
        Cliente[] clientes = new Cliente[5];
 
        for (int i = 0; i < 5; i++) {
            String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente " + (i + 1) + ": ");
            String apellidos = JOptionPane.showInputDialog(null, "Ingrese los apellidos del cliente " + (i + 1) + ": ");
            String identificacion = JOptionPane.showInputDialog(null, "Ingrese la identificación del cliente " + (i + 1) + ": ");
            String correo = JOptionPane.showInputDialog(null, "Ingrese el correo del cliente " + (i + 1) + ": ");
            String numeroTelefonico = JOptionPane.showInputDialog(null, "Ingrese el número telefónico del cliente " + (i + 1) + ": ");
 
            clientes[i] = new Cliente();
            clientes[i].setNombre(nombre);
            clientes[i].setApellidos(apellidos);
            clientes[i].setIdentificacion(identificacion);
            clientes[i].setCorreo(correo);
            clientes[i].setNumeroTelefonico(numeroTelefonico);
        }
 
        String mensaje = "Los clientes registrados son:\n";
        for (int i = 0; i < 5; i++) {
            Cliente cliente = clientes[i];
            mensaje.append("Cliente ").append(i + 1).append(": Nombre: ").append(cliente.getNombre()).append(" ")
                    .append(cliente.getApellidos()).append(", Identificación: ").append(cliente.getIdentificacion())
                    .append(", Correo: ").append(cliente.getCorreo()).append(", Número telefónico: ")
                    .append(cliente.getNumeroTelefonico()).append("\n");
        }
 
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
 
 
    }