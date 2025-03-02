package Cuenta;
import java.util.InputMismatchException;
import java.util.Scanner;
import Excepciones.*;
import Interfaz.Menu;
import java.util.Comparator;
/**
 *En esta cuenta se añadirá un atributo llamado "salario" que será el dinero que se suma a la cuenta mensualmente 
 * @author baske
 */
public class CuentaFamiliar extends Cuenta implements Comparable<CuentaFamiliar> {
    private static final Scanner teclado = new Scanner(System.in);
    private double salario;
    private final int integrantes; //Los integrantes de la familia
    
    
    public CuentaFamiliar() throws MayorCeroException{
        salario = salarioMensual();
        integrantes = cantidadFamiliar();
    }

    public double getSalario() {
        return salario;
    }

    public int getIntegrantes() {
        return integrantes;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public int cantidadFamiliar() throws MayorCeroException {
        int usuario = 0;
        boolean correcto = false;

        do {
            try {
                System.out.println("Cuantos integran la familia?");
                System.out.print(">>");
                usuario = teclado.nextInt();
                if (usuario > 0) {
                    correcto = true;
                } else {
                    throw new MayorCeroException("El numero de integrantes debe ser de minimo 1 persona");
                }
            } catch (InputMismatchException e) {
                System.out.println("Solo se admiten datos numericos");
            } catch (MayorCeroException ex) {
                System.out.println("Error: " + ex.getMessage() + " presione enter e intentelo de nuevo");
                Menu.limpiarBuffer();
            } 
        } while (!correcto);

        return usuario;
    }
    /**
     * Un metodo que pide al usuario cuanto dinero mensual va a depositar en la cuenta
     * @return
     * @throws MayorCeroException 
     */
    private int salarioMensual() throws MayorCeroException {
        boolean correcto = false;
        int dinero = 0;

        do {
            System.out.println("Cuanto dinero mensual vas a ingresar en la cuenta familiar?");
            System.out.print(">>");
            try {
                dinero = teclado.nextInt();
                if (dinero < 0) {
                    throw new MayorCeroException("No puede ser un numero negativo");
                }
                correcto = true;
            } catch (InputMismatchException e) {
                System.out.println("Introduzca solo valores numericos e intentelo de nuevo");
                teclado.nextLine();
            } catch (MayorCeroException ex) {
                System.out.println("Solo numeros positivos por favor");
            }

        } while (!correcto);
        return dinero;
    }
    
    
    
    @Override
    public String mostrarDatos(){
        return "Nombre: " + super.getNombre() + "\nDNI: " + super.getDni() + "\nNumCuenta: " + super.getNumCuenta() + "\nSalario: " + salario + "\nIntegrantes: " +integrantes;
    }

    /**
     * Este metodo heredado de Comparable establece como orden natural (menor a mayor) el salario de cada cuenta
     * @param o la cuenta con la que se comparará
     * @return 1,0,-1 en orden: mayor que, igual, menor que
     */
    @Override
    public int compareTo(CuentaFamiliar o) {
        if(this.salario > o.salario){
            return 1;
        }else if(this.salario == o.salario){
            return 0;
        }else{
            return -1;
        }
    }
    
    
    public static Comparator<CuentaFamiliar> salarioMayorMenor = new Comparator<>() {

        @Override
        public int compare(CuentaFamiliar c1, CuentaFamiliar c2) {

            if (c1.salario > c2.salario) {
                return -1;
            } else if (c1.salario == c2.salario) {
                return 0;
            } else {
                return -1;
            }
        }

    };
    
    
    
    
    
    
    public static Comparator<CuentaFamiliar> integrantesMayorMenor = new Comparator<>() {

        @Override
        public int compare(CuentaFamiliar c1, CuentaFamiliar c2) {
            if (c1.integrantes > c2.integrantes) {
                return -1;
            } else if (c1.integrantes == c2.integrantes) {
                return 0;
            } else {
                return -1;
            }
        }
    };
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static Comparator<CuentaFamiliar> compararIntegranteMenorMayor = new Comparator<CuentaFamiliar>(){
        @Override
        public int compare(CuentaFamiliar cuenta1, CuentaFamiliar cuenta2) {
            if (cuenta1.integrantes > cuenta2.integrantes) {
                return 1;
            } else if (cuenta1.integrantes == cuenta2.integrantes) {
                return 0;
            } else {
                return -1;
            }

        }
    
    };



    
}
