/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogragrupo1;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Usuario {
    private String name;
    private String surname1;
    private String surname2;
    private String identification;
    private String mail;
    private String phone;
    private String password;
    
    public Usuario(){
        setName(JOptionPane.showInputDialog("Ingrese el nombre: "));
        setSurname1(JOptionPane.showInputDialog("Ingrese el primer apellido: "));
        setSurname2(JOptionPane.showInputDialog("Ingrese el segundo apellido: "));
        setIdentification(JOptionPane.showInputDialog("Ingrese la identificación: "));
        setMail(JOptionPane.showInputDialog("Ingrese el correo: "));
        setPhone(JOptionPane.showInputDialog("Ingrese el telefono: "));
        
        boolean isValidPassword = false;
        do {
            isValidPassword = setPassword(JOptionPane.showInputDialog("Ingrese la contraseña: "));
        }while(!isValidPassword);
    }
    
    static void saveUser(Usuario user){   
        try (FileWriter fw = new FileWriter("./usuarios.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {

            out.print(user);

            JOptionPane.showMessageDialog(null, "Usuarios guardados correctamente");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar usuarios");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname1() {
        return surname1;
    }

    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    public String getSurname2() {
        return surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password) {
        if (password.length() < 8){
            JOptionPane.showMessageDialog(null, "La contrasena debe ser de minimo 8 caracteres.");
            return false;
        }
        
        int i = 0, j = 1;
        while(j<password.length()){
            if (password.charAt(i) == password.charAt(j)){
                JOptionPane.showMessageDialog(null, "La contrasena no cuenta con el formato valido.");
                return false;
            }
            
            i++;
            j++;
        }
        
        this.password = password;
        return true;
    }
    
    @Override
    public String toString(){
        return  this.name + ", " +
                this.surname1 + ", " +
                this.surname2 + ", " +
                this.identification + ", " +
                this.mail + ", " +
                this.phone + ", " +
                this.password + "\n";
    }
}
