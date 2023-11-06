/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogragrupo1;

/**
 *
 * @author fauri
 */
public class Usuario {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String identificacion;
    private String correo;
    private String telefono;
    private String contra;
    
    public Usuario(String nombre, String apellido1, String apellido2, String identificacion, String correo, String telefono, String contra){
        setNombre(nombre);
        setApellido1(apellido1);
        setApellido2(apellido2);
        setIdentificacion(identificacion);
        setCorreo(correo);
        setTelefono(telefono);
        setContra(contra);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
}
