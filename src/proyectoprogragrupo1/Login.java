/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogragrupo1;

import javax.swing.JOptionPane;

public class Login {
    public void startLogin(){
        String username = JOptionPane.showInputDialog(null, 
                "Ingrese su nombre de usuario: ");
        String password = JOptionPane.showInputDialog(null, 
                "Ingrese su contraseña: ");
        
        
    }
    
    private boolean userExists (String username, String password) {
        
        
        return true;
    }
}
