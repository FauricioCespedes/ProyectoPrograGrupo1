/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoprogragrupo1;

import javax.swing.JOptionPane;

public class ProyectoPrograGrupo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu();
        
    }
     public static void menu(){
         //Inicio del ciclo para Inicio de sesión
         boolean Access = false;
            while (!Access)
                {
                    String User=JOptionPane.showInputDialog("Usuario ");
                    if (User.equals(Config.masterUsername))
                    {
                            String password=JOptionPane.showInputDialog("Digite su contraseña");
                            if (password.equals(Config.masterPassword))
                            {
                                JOptionPane.showMessageDialog(null,"Bienvenido al sistema ");
                                Access = true;
                                break;
                            }
                            else
                            {
                                    JOptionPane.showMessageDialog(null,"**** Contraseña Incorrecta ****"
                                            + "\n       Intente de nuevo");
                            }
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(null,"****Usuario Incorrecto****"
                                + "\n       Intente de nuevo");
                    }
                }
            //Inicio del ciclo del Menú
            boolean exit = false;
            int option;
            while(!exit)
            {
                //Se pide una opcion al cliente sobre las funciones del menú
                option= Integer.parseInt(JOptionPane.showInputDialog(null,
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
                        
                          break;
                      case 3:
                        
                          break;
                      case 4:
                        
                          break;
                      case 5:
                        
                         break;
                      case 6:
                        
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

