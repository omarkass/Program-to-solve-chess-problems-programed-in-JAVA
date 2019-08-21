package peces;
import java.util.Collection;
import java.util.Scanner;

import programa.*;

public class DriverTorre {

	private static Scanner teclat = new Scanner(System.in);
	private static Torre torre;

    public DriverTorre(){
    }

    public static void menu(){
        System.out.println("\n0) Sortir \n1) Constructora per defecte \n2) Constructora amb Valors \n3) Possibles Moviments \n");
    }


    public static void testConstructorDefecte(){
        torre = new Torre();
        System.out.println("Creacio d'una peça torre per defecte amb valors de fila: "+ torre.getPeçaPos().getFila() +
        		", columna: " + torre.getPeçaPos().getColumna() + " i de color " + torre.getPeçaCol());
    }

    public static void testConstructorValors(){
        Color peçaCol = Color.BLANC;
        int fila = 0;
        int columna = 0;
        String color;
        System.out.println("Creacio d'una peça torre");
        do{
            System.out.println("En quina fila voleu que estigui la peça (0 a 7)?");
            fila = teclat.nextInt();
        }
        while(fila < 0 || fila >= 8);
        do{
            System.out.println("En quina columna voleu que estigui la peça(0 a 7)?");
            columna = teclat.nextInt();
        }
        while(columna < 0 || columna >= 8);
        Coordinada peçaPos = new Coordinada(fila,columna);
        do {
        System.out.println("De quin color voleu que sigui la peça (blanc o negre)?");
        color = teclat.next();
        }
        while(!color.toLowerCase().equals("negre") && !color.toLowerCase().equals("blanc"));
        peçaCol = Color.valueOf(color.toUpperCase());

        torre = new Torre(peçaPos, peçaCol);
        System.out.println("Creacio d'un torre per defecte amb valors de fila "+ torre.getPeçaPos().getFila() + ", de columna " + torre.getPeçaPos().getColumna()+ " i color " + torre.getPeçaCol());
    }

    public static void testCalcularMovimentsLegals() {

        Tauler tauler = new Tauler();
        tauler.creacioTauler();
        Collection<Moviment> llistaMoviments;
        System.out.println("Calcul dels possibles moviments d'una peça torre");
    	System.out.println("En el següent tauler");
    	String s = "rnbqkbnr/ppp1pppp/3p4/1B1PR3/P2PP3/8/1P1PKP1P/4Q3";
        tauler.emplenarTauler(s.toCharArray());
        tauler.imprimirTauler();
    	Casella c [][] = tauler.getTauler() ;
		Peça p ;
		p= c[3][4].getPeça() ;
		 System.out.println("Veiem els moviments per al torre blanc");
		 llistaMoviments = p.calcularMovimentsLegals(tauler) ;
        int n = 0;
    	for (Moviment moviment : llistaMoviments) {
    		++n;
        	System.out.println("Moviment " + n + " Fila: " + moviment.getDestinacio().getColumna() + " - Columna: " + moviment.getDestinacio().getFila() );
        }


    }

    public static void main (String args[]){
        System.out.println("Driver torre");
        System.out.println("Elegeix quin métode vols comprovar: ");
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
            	testCalcularMovimentsLegals();
            }

            menu();
            opcio = teclat.nextInt();
        }

        System.out.println("Finalització del Driver torre");
    }
}
