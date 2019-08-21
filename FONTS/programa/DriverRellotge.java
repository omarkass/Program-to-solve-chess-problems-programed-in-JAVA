package programa;

import java.util.*;
public class DriverRellotge
{
	private static Scanner teclat = new Scanner(System.in);
	private static Rellotge r;

    public DriverRellotge(){

    }

    public static void menu(){
        System.out.print("\n0) Sortit \n1) Constructora per defecte \n2) Imprimir rellotge jugador 1\n");
    }

    public static void testConstructorDefecte(){
        r = new Rellotge();
        System.out.println("Creacio de dos rellotges.");
        r.iniRellotgeJug1();
        r.iniRellotgeJug2();
    }

    public static void imprimirRellotgeJ1(){
        r.canviTorn(1);
        r.imprimirRellotgeJ1();
    }

    public static void main (String args[]){
        System.out.println("Driver Rellotge");
        System.out.println("Eligueix quin métode vols comprovar: ");
        menu();
        int opcio = teclat.nextInt();
        while(opcio != 0){
            if(opcio == 1){
                testConstructorDefecte();
            }
            else if(opcio == 2){
                imprimirRellotgeJ1();
            }
            menu();
            opcio = teclat.nextInt();
        }

        System.out.println("Finalització del Driver Casella");
    }
}
