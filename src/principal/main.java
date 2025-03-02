package principal;

import Cuenta.*;
import Excepciones.MayorCeroException;
import Interfaz.Menu;
import java.util.Collections;
/**
 *
 * @author baske
 */
public class main {

    /**
     * @param args the command line arguments
     * @throws Excepciones.MayorCeroException
     */
    public static void main(String[] args) throws MayorCeroException {
        GestionCuentas gs = new GestionCuentas();
        int usuario;

        do {
            usuario = Menu.Introduccion();
            
            switch (usuario) {
                case 1:
                    gs.addCuentaFamiliar();
                    break;
                case 2:
                    gs.rmvCuentaFamiliar();
                    break;
                case 3:
                    int listar = Menu.eleccionListar();
                        switch(listar){
                            case 1:
                                Collections.sort(gs.getLista());
                                gs.listar();
                                break;
                            case 2:
                                Collections.sort(gs.getLista(),CuentaFamiliar.salarioMayorMenor);
                                gs.listar();
                                break;
                            case 3:
                                Collections.sort(gs.getLista(),CuentaFamiliar.compararIntegranteMenorMayor);
                                gs.listar();
                                break;
                            case 4:
                                Collections.sort(gs.getLista(),CuentaFamiliar.integrantesMayorMenor);
                                gs.listar();
                                break;
                            case 0:
                                break;
                        }
                    break;
                    
                

            }

        } while (usuario != 0);

    }
}
