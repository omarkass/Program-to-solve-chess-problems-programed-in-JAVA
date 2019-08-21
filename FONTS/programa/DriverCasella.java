package programa;
import java.util.*;

import peces.*;

public class DriverCasella
{
	private static Scanner teclat = new Scanner(System.in);
	private static Casella c;

    public DriverCasella(){
    }

    public static void menu(){
        System.out.print("\n0) Sortit \n1) Constructora per defecte \n2) Constructora amb valors Fila i Columna \n3) Consultora fila \n4) Consultora columna \n5) Consultora ocupat");
        System.out.println("\n7) Set fila \n8) Set columna  \n9) Set peça");
    }

    public static void testConstructorDefecte(){
        c = new Casella();
        System.out.println("Creacio d'una casella per defecte amb valors de fila "+ c.getFila() + " i de columna " + c.getColumna());
    }

    public static void testConstructorValors(){
        c = new Casella();
        int fila;
        do{
            System.out.println("Quin valor de fila voleu?");
            fila = teclat.nextInt();
        }
        while(fila >= 8 || fila < 0);

        int columna;
        do{
            System.out.println("Quin valor de columna voleu?");
            columna = teclat.nextInt();
        }
        while(columna >= 8 || columna<0);

        c.creacioCasella(fila, columna);
        System.out.println("Creacio d'una casella per defecte amb valors de fila "+ c.getFila() + " i de columna " + c.getColumna());
    }

    public static void testgetFila(){
        System.out.println("La fila és: " + c.getFila());
    }

    public static void testgetColumna(){
        System.out.println("La columna és: " + c.getColumna());
    }

    public static void testgetOcupat(){
        System.out.println("L'estat d'ocupació és: " + c.getOcupat());
    }



    public static void testsetFila(){
        int f;
        do{
            System.out.println("Quin valor de fila voleu?");
            f = teclat.nextInt();
        }
        while(f >= 8 || f<0);
        c.setFila(f);
        System.out.println("La nova fila és: " + c.getFila());
    }

    public static void testsetColumna(){
        int cl;
        do{
            System.out.println("Quin valor de columna voleu?");
            cl = teclat.nextInt();
        }
        while(cl >= 8 || cl<0);
        c.setColumna(cl);
        System.out.println("La nova columna és: " + c.getColumna());
    }

    public static void testsetPeca(){

     int i = 0 ;
     int j = 0 ;
        Peça p = new Torre(new Coordinada(i,j),Casella.getNegre() ) ;
        c.setPeça('t' ,p);
        System.out.println("La nova peça es: " + c.getPeça().getPeçaChar() + " " + c.getPeça().getPeçaPos().getFila() + ","
        		+ c.getPeça().getPeçaPos().getColumna());
        
    }

    public static void testposicioCorrecta(){
        System.out.println("Quina posició voleu comprovar?");
        System.out.println("Fila: ");
        int f = teclat.nextInt();
        System.out.println("Columna: ");
        int cl = teclat.nextInt();

        System.out.println("La posicio es: " + c.posicioCorrecta(f,cl));
    }

    public static void main (String args[]){
        System.out.println("Driver Casella");
        System.out.println("Eligueix quin métode vols comprovar: ");
        menu();
        int opcio = teclat.nextInt();
        while(opcio != 0){
            if(opcio == 1){
                testConstructorDefecte();
            }
            else if(opcio == 2){
                testConstructorValors();
            }
            else if(opcio == 3){
                testgetFila();
            }
            else if(opcio == 4){
                testgetColumna();
            }
            else if(opcio == 5){
                testgetOcupat();
            }
            else if(opcio == 7){
                testsetFila();
            }
            else if(opcio == 8){
                testsetColumna();
            }
            else if(opcio == 9){
                testsetPeca();
            }
            else if(opcio == 10){
                testposicioCorrecta();
            }

            menu();
            opcio = teclat.nextInt();
        }

        System.out.println("Finalització del Driver Casella");
    }
}
