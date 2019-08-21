package domini;

import java.io.IOException;
import java.util.*;

import programa.Jugador;

public class DriverGestioJugadors
{
    private static Scanner teclat = new Scanner(System.in);
    private static GestioJugadors gj;


    public DriverGestioJugadors(){
    }

    public static void menu(){
        System.out.println("\n0) Sortir \n1) Crear Jugador \n2) Eliminar Jugador \n3) Modificar Jugador \n4) LListar Jugadors");
    }

    public static void main (String args[]) throws IOException {
        System.out.println("Driver GestioJugadors");
        System.out.println("Escull quin metode vols comprovar: ");
        menu();
        int opcio = teclat.nextInt();
        while(opcio != 0){
        	gj = new GestioJugadors();
        	if(opcio == 1){
        		Jugador j = new Jugador();
        		gj.crearJugador(j);
            }
            else if(opcio == 2){
                gj.eliminarJugador();
            }
            else if(opcio == 3){
                gj.modificarJugador();
            }
            else if(opcio == 4){
                gj.llistarJugadors();
            }
            menu();
            opcio = teclat.nextInt();
        }

        System.out.println("Finalització del Driver GestioProblemes");
    }
}
