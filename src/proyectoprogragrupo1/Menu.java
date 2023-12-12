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
        Cliente cliente = new Cliente();
        
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
                      //llamar a login usuarios
                      fVehic.updateVehicle();
                      break;
                  case 4:
                      fVehic.showInformation();
                      break;
                  case 5:
                     Cliente.saveClient(client);
                     break;
                  case 6:
                     Cliente.showClients();
                     break;
                  case 7:
                    
                    int totalSold = Vehiculo.countSoldVehicles();
                    int totalReserved = Vehiculo.countReservedVehicles();
                    int totalAvialable = Vehiculo.countAvailableVehicles();
                    int choose = Integer.parseInt(JOptionPane.showInputDialog(null, 
                    "\n1) Cantidad total de autos venditos, reservados y disponibles" +
                    "\n2) Cantidad de clientes registrados, clientes que compraron un vehículo, clientes que reservaron un vehículo." +
                    "\n3) Top 3 de clientes que más compraron vehículos" +
                    "\n4) Cantidad de vehículos vendidos por vendedor" +
                    "\n5) Cantidad de vehículos reservados por vendedor" +                   
                    "\n6) Salir"));
                    switch (choose){
                        case 1:
                            JOptionPane.showMessageDialog(null,
                            "Cantidad total de autos vendidos: " + totalSold
                          + "\nCantidad total de autos reservados: " + totalReserved
                          + "\nCantidad total de autos disponibles: " + totalAvialable);
                          break;
                        case 2:
                            // JOptionPane.showMessageDialog(null,
                            //        "\nCantidad total de clientes que reservaron " + countReservedCustomers
                            //      + "\nCantidad total de clientes que compraron" + countSoldCustomers );
                            

                          break;
                        case 3:

                          break;
                        case 4:

                          break;
                        case 5:

                         break;
                        case 6:

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
}

