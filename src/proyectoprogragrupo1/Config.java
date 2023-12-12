/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogragrupo1;

import javax.swing.JOptionPane;

public class Config {
    static String companyName = "AzzaCar";
    static String phoneNumber = "8888-8888";
    static String address = "Cartago, Cartago, Occidental";
    
    static String masterUsername = "master";
    static String masterPassword = "1234";
    
    static String nombreVendedor = "";
    
    public void showCompanyData (){
        JOptionPane.showMessageDialog(null,
                "\nNombre de la empresa: " + companyName +
                "\nTelefono de empresa: " + phoneNumber +
                "\nDirección de empresa: " + address);
    }

    public static String getCompanyName() {
        return companyName;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static String getAddress() {
        return address;
    }
    
}
