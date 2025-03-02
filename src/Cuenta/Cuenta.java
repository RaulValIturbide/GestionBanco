package Cuenta;

import Interfaz.Menu;
import java.util.Scanner;


/**
 * Esta cuenta será la cuenta básica de un banco, en ella habrá un nombre,un
 * dni,y un numero de cuenta
 *
 * @author baske
 */
public abstract class Cuenta{

    private static final Scanner teclado = new Scanner(System.in);
    private String nombre; //Un nombre de usuario que no podrá contener numeros ya que se trata de un nombre de persona
    private String dni; //Un dni que seguirá el formato de los dni eso es XXXXXXXX-X y que seguirá las reglas del dni
    private String numCuenta; //Un numero de cuenta que tendrá un formato de numeros XXX-XXX-XXX

    public Cuenta() {
        this.nombre = aplicarNombre();
        this.numCuenta = aplicarNumCuenta();
        this.dni = aplicarDni();  
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    /**
     * Este metodo sirve para comprobar que el nombre solo se puedan pasar
     * letras y nada de numeros o caracteres especiales
     * 
     * @return devolverá el nombre ya checkeado
     */
    private String aplicarNombre() {
        String expReg = "^[A-Z]{1}[a-z]{1,}$";
        String nombreTemp;
        boolean correcto = false;
        do {
            System.out.println("Dame tu nombre formato(Ana,Luis,Sara...):");
            System.out.print(">>");
            nombreTemp = teclado.nextLine();
            if (nombreTemp.matches(expReg)) {
                correcto = true;
            }

        } while (!correcto);

        return nombreTemp;
    }

    /**
     * Este metodo pretende que el numCuenta cumple con las expReg exigidas
     *
     * @return devuelve el numero de cuenta ya checkeada y correcta
     */
    private String aplicarNumCuenta() {
        String regExpr = "^\\d{3}-\\d{3}-\\d{3}$";
        String numTemp;
        boolean correcto = false;
        do {
            System.out.println("Dame el nombre de tu cuenta :");
            System.out.print(">>");
            numTemp = teclado.nextLine();
            if (numTemp.matches(regExpr)) {
                correcto = true;
            }else{
                System.out.println("NºCuenta erroneo, por favor escribalo de nuevo formato: XXX-XXX-XXX");}
        } while (!correcto);

        return numTemp;
    }

    private String aplicarDni() {
        boolean correcto = false;
        boolean formulaCheck = false;
        String dniTemp = null;
        String posicionLetras = "TRWAGMYFPDXBNJZSQVHLCKE";
        do {
            while (!correcto) {
                String expReg = "^\\d{8}-[A-Z]$";
                System.out.println("Escriba su DNI:");
                System.out.print(">>");
                dniTemp = teclado.nextLine();

                if (dniTemp.matches(expReg)) {
                    correcto = true;
                } else {
                    System.out.println("Dni erroneo, por favor escribalo de nuevo formato: XXXXXXXX-X");
                }
            }

            String primeraParte = dniTemp.substring(0, 8); //Se trataría de todos los digitos de un dni
            String segundaParte = dniTemp.substring(9); //la letra del dni que siempre deberia estar en la posicion 10 ya que se verifica que el formato sea XXXXXXXX-X
            int numeroDni = Integer.parseInt(primeraParte);
            int usuarioLetra = numeroDni % 23; //La posicion que ocupa la legitima letra de un dni en la formula de letras

            if (segundaParte.equals(String.valueOf(posicionLetras.charAt(usuarioLetra)))) {
                formulaCheck = true;
            } else {
                System.out.println("Letra no coincide, revise su DNI e intentelo de nuevo");
                correcto = false;
            }
        } while (!formulaCheck);

        return dniTemp;

    }     
   
    abstract String mostrarDatos();
   
}
