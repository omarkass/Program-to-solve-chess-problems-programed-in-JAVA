package domini;

import java.io.IOException;
import java.util.*;

public class DriverGestioProblemes
{
    private static Scanner teclat = new Scanner(System.in);
    private static GestioProblemes gp;


    public DriverGestioProblemes(){
    }

    public static void menu(){
        System.out.println("\n0) Sortir \n1) Llegir Problema \n2) Llistar Problemes \n3) Crear Problema \n4) Eliminar Problema \n5) Modificar Problema \n");
    }

    public static void main (String args[]) throws IOException {
        System.out.println("Driver GestioProblemes");
        System.out.println("Escull quin metode vols comprovar: ");
        menu();
        int opcio = teclat.nextInt();
        while(opcio != 0){
        	gp = new GestioProblemes();
        	if(opcio == 1){
        		System.out.println("Sisplau Entra el nom del problema:");
            	String id = teclat.next();
            	id = gp.llegirProblema(id);
            	System.out.println(id);
            }
            else if(opcio == 2){
                gp.llistarProblemes();
            }
            else if(opcio == 3){
                gp.crearProblema();
            }
            else if(opcio == 4) {
            	gp.eliminarProblema();
            }
            else if(opcio == 5){
                gp.modificarProblema();
            }
            menu();
            opcio = teclat.nextInt();
        }

        System.out.println("Finalització del Driver GestioProblemes");
    }
}
