package Cuenta;
import Excepciones.MayorCeroException;
import java.util.ArrayList;
import Interfaz.Menu;
import java.util.Scanner;
public class GestionCuentas {
    Scanner teclado = new Scanner(System.in);
    ArrayList<Cuenta> listaCuentas = new ArrayList<>();
    ArrayList<CuentaFamiliar> listaCuentasFamiliar = new ArrayList<>();
    
    public void addCuentaFamiliar() throws MayorCeroException {

        listaCuentasFamiliar.add(new CuentaFamiliar());
    }
    
    public void rmvCuentaFamiliar() {
        boolean encontrado = false;
        int contador = 0;
        String usuario;
        do {
            System.out.println("Numero de cuenta que deseas borrar:");
            System.out.print(">>");
            usuario = teclado.nextLine();
            if (listaCuentas.isEmpty()) {
                System.out.println("La lista esta vacia");
                usuario ="N";
            } else {
                while (!encontrado && contador < listaCuentas.size()) {
                    if (listaCuentas.get(contador).getNumCuenta().equals(usuario)) {
                        listaCuentas.remove(contador);
                        listaCuentasFamiliar.remove(contador);
                        encontrado = true;
                    } else {
                        contador++;
                    }
                }
                if (!encontrado) {
                    System.out.println("No se ha encontrado esa cuenta");
                    System.out.println("Deseas seguir? (Y/N)");
                    System.out.print(">>");
                    usuario = teclado.nextLine();

                } else {
                    System.out.println("Cuenta eliminada con exito");
                }
            }
        } while (!usuario.equals("N"));

    }
    public ArrayList<CuentaFamiliar> getLista(){ 
        return listaCuentasFamiliar;
    }
    
    public void listar() {
        for (int i = 0; i < listaCuentasFamiliar.size(); i++) {
            System.out.println(listaCuentasFamiliar.get(i).mostrarDatos());
        }
    }
    

}
