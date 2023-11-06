/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogragrupo1;

import java.util.Scanner;

/**
 *
 * @author juanp
 */
public class RegistroClientes {
    public static void registroClientes() {
        Scanner scanner = new Scanner(System.in);
        Cliente[] clientes = new Cliente[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Ingrese el nombre del cliente " + (i + 1) + ": ");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese los apellidos del cliente " + (i + 1) + ": ");
            String apellidos = scanner.nextLine();

            System.out.println("Ingrese la identificación del cliente " + (i + 1) + ": ");
            String identificacion = scanner.nextLine();

            System.out.println("Ingrese el correo del cliente " + (i + 1) + ": ");
            String correo = scanner.nextLine();

            System.out.println("Ingrese el número telefónico del cliente " + (i + 1) + ": ");
            String numeroTelefonico = scanner.nextLine();

            clientes[i] = new Cliente(nombre, apellidos, identificacion, correo, numeroTelefonico);
        }

        System.out.println("Los clientes registrados son: ");
        for (int i = 0; i < 5; i++) {
            Cliente cliente = clientes[i];
            System.out.println("Cliente " + (i + 1) + ": Nombre: " + cliente.nombre + " " + cliente.apellidos +
                    ", Identificación: " + cliente.identificacion + ", Correo: " + cliente.correo +
                    ", Número telefónico: " + cliente.numeroTelefonico);
        }
    }
    
    
}
