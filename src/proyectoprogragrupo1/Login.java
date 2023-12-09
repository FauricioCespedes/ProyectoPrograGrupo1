/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogragrupo1;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Login {
    public static void start(){
        Login login = new Login();
        boolean Access = false;
        while (!Access){
            String user=JOptionPane.showInputDialog("Usuario o correo electrónico:");
            String password=JOptionPane.showInputDialog("Digite su contraseña");
        
            boolean userExists = login.validateCredentials(user, password);
            
            if (userExists || (user.equals(Config.masterUsername) && password.equals(Config.masterPassword))){
                JOptionPane.showMessageDialog(null,"Bienvenido al sistema ");
                Access = true;
            }
            else{
                JOptionPane.showMessageDialog(null,"****Usuario o Contraseña Incorrecto****"
                        + "\n       Intente de nuevo");
            }
        }
    }
    
    private boolean validateCredentials(String user, String password){
        try (BufferedReader br = new BufferedReader(new FileReader("./usuarios.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] usuario = linea.split(", ");
                
                if(usuario != null){
                    if (usuario[4].equals(user) && usuario[6].equals(password)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        
        return false;
    }
}
