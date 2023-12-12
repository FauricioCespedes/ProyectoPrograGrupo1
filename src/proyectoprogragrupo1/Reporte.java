/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogragrupo1;

import javax.swing.JOptionPane;

/**
 *
 * @author fauri
 */
public class Reporte {
    public static void menu(){
        int choose = 0;
        
        do{
            choose = Integer.parseInt(JOptionPane.showInputDialog(null, 
            "\n1) Cantidad total de autos vendidos, reservados y disponibles" +
            "\n2) Cantidad de clientes registrados, clientes que compraron un vehículo, clientes que reservaron un vehículo." +
            "\n3) Top 3 de clientes que más compraron vehículos" +
            "\n4) Cantidad de vehículos vendidos por vendedor" +
            "\n5) Cantidad de vehículos reservados por vendedor" +                   
            "\n6) Salir"));
        }while(choose < 1 || choose > 6);
        
        switch (choose){
            case 1:
                int totalSold = Vehiculo.countVehicles()[0];
                int totalReserved = Vehiculo.countVehicles()[1];
                int totalAvialable = Vehiculo.countVehicles()[2];
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
        }
    }
}
