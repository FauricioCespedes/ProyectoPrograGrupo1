/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogragrupo1;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author fauri
 */
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
        setPassword(JOptionPane.showInputDialog("Ingrese la contraseña: "));
    }
    
    public boolean saveUser(){   
        String userPath = "./usuarios.txt";
        
        try(FileWriter userFile = new FileWriter(userPath)){
            userFile.write(this.toString());
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar usuario: " + e.getMessage());
            return false;
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

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString(){
        return "\n" + name + ", " +
                surname1 + ", " +
                surname2 + ", " +
                identification + ", " +
                mail + ", " +
                phone + ", " +
                password;
    }
}
