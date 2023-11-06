/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogragrupo1;

import javax.swing.JOptionPane;

public class Menu {
    public void showMenu(){
        Config config = new Config();
        
        JOptionPane.showMessageDialog(null, 
                "\nMenú " + config.getCompanyName() +
                "\n1) Crear usuario" +
                "\n2) Crear vehículo" +
                "\n3) Actualizar vehículo" +
                "\n4) Ver vehículos" +
                "\n5) Crear cliente" +
                "\n6) Ver clientes" +
                "\n7) Consultar reportes" +
                "\n0) Salir");
    }
}
