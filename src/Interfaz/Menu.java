/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author baske
 */
public class Menu {
    private static final Scanner teclado = new Scanner(System.in);

    
    public static int Introduccion() {
        int usuario = 0;
        System.out.format("""
                          ¿Que deseas hacer?
                          1-Añadir cuenta familiar
                          2-Eliminar cuenta familiar
                          3-Listar cuentas
                          
                          0-Salir
                          """);
        do {
            try {
                usuario = teclado.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Introduce un valor numerico");
            } finally{
                limpiarBuffer();
            }
        } while (usuario < 0 || usuario > 3);

        return usuario;
    }
    public static int eleccionListar() {
        int usuario = 0;
        boolean correcto = false;
        do {
            try {
                System.out.println("Que deseas listar:\n1-Salario [Menor a Mayor]\n2-Salario [Mayor a Menor]\n3-Integrantes [Menor a Mayor]\n4-Integrantes [Mayor a Menor]\n\n0-Salir");
                usuario = teclado.nextInt();
                correcto = true;
            } catch (InputMismatchException e) {
                System.out.println("El dato solo debe ser un numero");
                limpiarBuffer();
            }
        } while (!correcto);
        return usuario;
    }
    
    public static void limpiarBuffer(){
        teclado.nextLine();
    }

}
