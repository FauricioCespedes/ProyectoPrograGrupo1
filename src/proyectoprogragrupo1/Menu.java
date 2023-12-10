/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogragrupo1;

import javax.swing.JOptionPane;

public class Menu {
    public static void show(){
        Config config = new Config();
        Vehiculo fVehic = new Vehiculo();
        
        boolean exit = false;
        int option;
        while(!exit){
            //Se pide una opcion al cliente sobre las funciones del menú
            option= Integer.parseInt(JOptionPane.showInputDialog(null,
                    "\nMenú " + config.getCompanyName() +
                    "\n1) Crear usuario" +
                    "\n2) Crear vehículo" +
                    "\n3) Actualizar vehículo" +
                    "\n4) Ver vehículos" +
                    "\n5) Crear cliente" +
                    "\n6) Ver clientes" +
                    "\n7) Consultar reportes" +
                    "\n0) Salir"));
            
            switch(option){
                  case 1:
                      Usuario user = new Usuario();
                      Usuario.saveUser(user);
                      break;
                  case 2:
                      fVehic.addVehicle(); 
                      break;
                  case 3:

                      break;
                  case 4:
                      fVehic.showInformation();

                      break;
                  case 5:
                     Cliente client = new Cliente();
                     Cliente.saveClient(client);
                     break;
                  case 6:
                     Cliente.showClients();
                     break;
                  case 7:

                     break;
                  case 0:
                      exit = true;
                      break;

                  default:
                      JOptionPane.showMessageDialog(null,"Opción invalida");
            }   
        }
    }
}
