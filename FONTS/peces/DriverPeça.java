package peces;
import java.util.Collection;
import java.util.Scanner;

import programa.*;

public class DriverPeça {

	private static Scanner teclat = new Scanner(System.in);
	private static Peça peça;

    public DriverPeça(){
    }

    public static void menu(){
        System.out.println("\n0) Sortir \n1) Constructora per defecte \n2) Constructora amb Valors \n"
        		+ "3) Possibles Moviments \n4) Set Color de la peça \n5) Get Color de la Peça\n"
        		+ "6) Get Posició de la peça\n7) Set Posició de la peça amb 2 int\n"
        		+ "8) Set Posició de la peça amb una coordinada\n");
    }


    public static void testConstructorDefecte(){
        peça = new Peo();
        System.out.println("Creacio d'una peça tipus peo per amb valors de fila: "+ peça.getPeçaPos().getFila() +
        		", columna: " + peça.getPeçaPos().getColumna() + " i de color " + peça.getPeçaCol());
    }

    public static void testConstructorValors(){
        Color peçaCol = Color.BLANC;
        int fila = 0;
        int columna = 0;
        String color;
        System.out.println("Creacio d'una peça");
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

        peça = new Peo(peçaPos, peçaCol);
        System.out.println("Creacio d'un peça per defecte amb valors de fila "+ peça.getPeçaPos().getFila() + ", de columna " + peça.getPeçaPos().getColumna()+ " i color " + peça.getPeçaCol());
    }

    public static void testCalcularMovimentsLegals() {

        Tauler tauler = new Tauler();
        tauler.creacioTauler();
        Collection<Moviment> llistaMoviments;
        System.out.println("Calcul dels possibles moviments d'una peça");
    	System.out.println("En el següent tauler");
    	String s = "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B";
        tauler.emplenarTauler(s.toCharArray());
        tauler.imprimirTauler();
        int x;
    	int y;
		do{
		  System.out.println("Introduir la fila de la peça a moure (0,7)") ;
	      y = teclat.nextInt() ;
		  System.out.println("Introduir la columna de la peça a moure (0,7)") ;
		  x = teclat.nextInt();
          if(tauler.getTauler()[y][x].getPeça() == null) System.out.println("Peça incorrecta. Introdueix una opció vàlida.");
        }
        while(tauler.getTauler()[y][x].getPeça() == null);
		Peça p = tauler.getTauler()[y][x].getPeça() ;
		 System.out.println("Veiem els moviments possibles");
		 llistaMoviments = p.calcularMovimentsLegals(tauler) ;
        int n = 0;
    	for (Moviment moviment : llistaMoviments) {
    		++n;
        	System.out.println("Moviment " + n + ": Fila " + moviment.getDestinacio().getFila() + " - Columna " + moviment.getDestinacio().getColumna() );
        }
    }

	public static void testGetPeçaCol() {
    	Tauler tauler = new Tauler();
        tauler.creacioTauler();
        System.out.println("Color de la peça de la posició 5,4");
    	System.out.println("En el següent tauler");
    	String s = "rnbqkbnr/ppp1pppp/8/1B6/7R/4p3/3PK3/4Q3 w KQkq -";
        tauler.emplenarTauler(s.toCharArray());
        tauler.imprimirTauler();
    	Casella c [][] = tauler.getTauler() ;
		Peça p ;
		p= c[5][4].getPeça() ;
		 System.out.println("La peça es de color:");
		 Color color = Color.BLANC;
		 color = p.getPeçaCol();
		 System.out.println(color);
	}
	public static void testGetPeçaPos() {
    	Tauler tauler = new Tauler();
        tauler.creacioTauler();
        System.out.println("Posició de la peça 5,4");
    	System.out.println("En el següent tauler");
    	String s = "rnbqkbnr/ppp1pppp/8/1B6/7R/4p3/3PK3/4Q3 w KQkq -";
        tauler.emplenarTauler(s.toCharArray());
        tauler.imprimirTauler();
    	Casella c [][] = tauler.getTauler() ;
		Peça p ;
		p= c[5][4].getPeça() ;
		 System.out.println("La peça es a la posició:");
		 Coordinada coord = p.getPeçaPos();
		 System.out.println(coord.getFila()+" "+coord.getColumna());
		 }

	public static void testSetPeçaPos(){
    	Tauler tauler = new Tauler();
        tauler.creacioTauler();
        System.out.println("Set posició de la peça 5,4");
    	System.out.println("En el següent tauler");
    	String s = "rnbqkbnr/ppp1pppp/8/1B6/7R/4p3/3PK3/4Q3 w KQkq -";
        tauler.emplenarTauler(s.toCharArray());
        tauler.imprimirTauler();
    	Casella c [][] = tauler.getTauler() ;
		Peça p ;
		p= c[5][4].getPeça() ;
		int fila = 0;
        int columna = 0;
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
        p.setPeçaPos(fila, columna);
		 System.out.println("La peça es a la posició:");
		 Coordinada coord = p.getPeçaPos();
		 System.out.println(coord.getFila()+" "+coord.getColumna());
	}

	public static void testSetPeçaPosCoord() {
    	Tauler tauler = new Tauler();
        tauler.creacioTauler();
        System.out.println("Set posició de la peça amb coordinada 5,4 ");
    	System.out.println("En el següent tauler");
    	String s = "rnbqkbnr/ppp1pppp/8/1B6/7R/4p3/3PK3/4Q3 w KQkq -";
        tauler.emplenarTauler(s.toCharArray());
        tauler.imprimirTauler();
    	Casella c [][] = tauler.getTauler() ;
		Peça p = c[5][4].getPeça() ;
		int fila = 0;
        int columna = 0;
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
        p.setPeçaPos(peçaPos);
		 System.out.println("La peça es a la posició:");
		 Coordinada coord = p.getPeçaPos();
		 System.out.println(coord.getFila()+" "+coord.getColumna());
	}

	private static void testSetPeçaCol() {
    	Tauler tauler = new Tauler();
        tauler.creacioTauler();
        System.out.println("Set color de la peça 5,4");
    	System.out.println("En el següent tauler");
    	String s = "rnbqkbnr/ppp1pppp/8/1B6/7R/4p3/3PK3/4Q3 w KQkq -";
        tauler.emplenarTauler(s.toCharArray());
        tauler.imprimirTauler();
    	Casella c [][] = tauler.getTauler() ;
		Peça p = c[5][4].getPeça() ;
		Color peçaCol = Color.BLANC;
        String color;
		do {
        System.out.println("De quin color voleu que sigui la peça (blanc o negre)?");
        color = teclat.next();
        }
        while(!color.toLowerCase().equals("negre") && !color.toLowerCase().equals("blanc"));
        peçaCol = Color.valueOf(color.toUpperCase());
        p.setPeçaCol(peçaCol);
		 System.out.println("La peça es de color:");
		 System.out.println(p.getPeçaCol());
	}

    public static void main (String args[]){
        System.out.println("Driver peça");
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
            else if(opcio == 4){
            	testSetPeçaCol();
            }
            else if(opcio == 5){
            	testGetPeçaCol();
            }
            else if(opcio == 6){
                testGetPeçaPos();
            }
            else if(opcio == 7){
            	testSetPeçaPos();
            }
            else if(opcio == 8){
            	testSetPeçaPosCoord();
            }

            menu();
            opcio = teclat.nextInt();
        }

        System.out.println("Finalització del Driver peça");
    }
}
