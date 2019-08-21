package programa;
import java.util.List;
import java.util.Scanner;

import peces.Peça;

public class Drivermoviment {
	private static Scanner teclat = new Scanner(System.in);
	private static Moviment moviment;
	private static Tauler tauler;
	private static Peça p;

	public static void testConstructoraValors() {
		System.out.println("Creacio d'un moviment amb el següent tauler:");
		tauler = new Tauler();
		tauler.creacioTauler();
		tauler.emplenarTaulerInici();
		tauler.imprimirTauler();
		System.out.println("La peça de la posició 6,0 i la destinació 5,0");
		p = tauler.getTauler()[6][0].getPeça();
		Coordinada c = new Coordinada(5,0);
		moviment = new Moviment(tauler, p, c);
		System.out.println("Moviment creat amb destinació: " + moviment.getDestinacio().getFila() + "," + moviment.getDestinacio().getColumna());

	}
	
    public static void testGetDestinacio() {
		tauler = new Tauler();
		tauler.creacioTauler();
		tauler.emplenarTaulerInici();
		p = tauler.getTauler()[6][0].getPeça();
		Coordinada c = new Coordinada(5,0);
		moviment = new Moviment(tauler, p, c);
		System.out.println("Moviment amb destinació: " + moviment.getDestinacio().getFila() + "," + moviment.getDestinacio().getColumna());

    }
    
    public static void testGetTauler() {
		tauler = new Tauler();
		tauler.creacioTauler();
		tauler.emplenarTaulerInici();
		p = tauler.getTauler()[6][0].getPeça();
		Coordinada c = new Coordinada(5,0);
		moviment = new Moviment(tauler, p, c);
		System.out.println("Moviment amb tauler:");
		moviment.getTauler().imprimirTauler();
    }
    
    public static void testGetPeçaMoguda() {
		tauler = new Tauler();
		tauler.creacioTauler();
		tauler.emplenarTaulerInici();
		p = tauler.getTauler()[6][0].getPeça();
		Coordinada c = new Coordinada(5,0);
		moviment = new Moviment(tauler, p, c);
    	System.out.println("Moviment amb peça moguda: " + moviment.getPeçaMoguda().getPeçaChar() + " " + moviment.getPeçaMoguda().getPeçaPos().getFila() + "," + moviment.getPeçaMoguda().getPeçaPos().getColumna());
    }
    
    public static void testSetDestinacio() {
		tauler = new Tauler();
		tauler.creacioTauler();
		tauler.emplenarTaulerInici();
		p = tauler.getTauler()[6][0].getPeça();
		Coordinada c = new Coordinada(5,0);
		moviment = new Moviment(tauler, p, c);
        int fila, columna;
    	do{
            System.out.println("Quin valor de fila voleu per la destinació (0,7)?");
            fila = teclat.nextInt();
        }
        while(fila >= 8 || fila<0);
        do{
            System.out.println("Quin valor de columna voleu per la destinació (0,7)?");
            columna = teclat.nextInt();
        }
        while(columna >= 8 || columna<0);
        moviment.setDestinacio(fila, columna);
		System.out.println("Moviment modificat amb destinació: " + moviment.getDestinacio().getFila() + "," + moviment.getDestinacio().getColumna());

    }
    
    public static void testSetPeçaMoguda() {
		tauler = new Tauler();
		tauler.creacioTauler();
		tauler.emplenarTaulerInici();
		p = tauler.getTauler()[6][0].getPeça();
		Coordinada c = new Coordinada(5,0);
		moviment = new Moviment(tauler, p, c);
    	int fila, columna;
    	do{
            System.out.println("En quin valor de fila es troba la peça a moure (0,7)?");
            fila = teclat.nextInt();
            System.out.println("En quin valor de columna es troba la peça a moure (0,7)?");
            columna = teclat.nextInt();
            if(tauler.getTauler()[fila][columna].getPeça() == null)System.out.println("Valor incorrecte. Introdueix una opció vàlida.");
        }
        while(tauler.getTauler()[fila][columna].getPeça() == null);
        p = tauler.getTauler()[fila][columna].getPeça();
        moviment.setPeçaMoguda(p);
    	System.out.println("Moviment modificat amb peça moguda: " + moviment.getPeçaMoguda().getPeçaChar() + " " + moviment.getPeçaMoguda().getPeçaPos().getFila() + "," + moviment.getPeçaMoguda().getPeçaPos().getColumna());
    }
    
    public static void testSetTauler() {
		tauler = new Tauler();
		tauler.creacioTauler();
		tauler.emplenarTaulerInici();
		p = tauler.getTauler()[6][0].getPeça();
		Coordinada c = new Coordinada(5,0);
		moviment = new Moviment(tauler, p, c);
        System.out.println("Tauler inicial:");
		moviment.getTauler().imprimirTauler();
        System.out.println("Modifiquem el tauler amb el següent fen: "
        		+ "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1");
        Tauler tauler2;
        tauler2 = new Tauler();
        tauler2.creacioTauler();
        String fen = "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1";
        tauler2.emplenarTauler(fen.toCharArray());
        moviment.setTauler(tauler2);
        System.out.println("\nTauler modificat:");
		moviment.getTauler().imprimirTauler();
    }
    
    public static void testTrobarElRei() {
		tauler = new Tauler();
		tauler.creacioTauler();
		tauler.emplenarTaulerInici();
		p = tauler.getTauler()[6][0].getPeça();
		Coordinada c = new Coordinada(5,0);
		moviment = new Moviment(tauler, p, c);
		Peça rei = moviment.TrobarElRei(moviment.getTauler().getPecesNegres());
        System.out.println("Posició del rei negre en el següent tauler: ");
        moviment.getTauler().imprimirTauler();
        System.out.println("Posició: " + rei.getPeçaPos().getFila() + "," + rei.getPeçaPos().getColumna());
    }
    
	  public static void testMoveCauseJaque(){
	        String s = "1N1b4/6nr/R5N1/2Ppk2r/K2p2qR/8/2N1PQ2/B6b";
			tauler = new Tauler();
			tauler.creacioTauler();
	        tauler.emplenarTauler(s.toCharArray());
	        tauler.imprimirTauler();
	       	int fila, columna;
	    	do{
	            System.out.println("En quin valor de fila es troba la peça a moure (0,7)?");
	            fila = teclat.nextInt();
	            System.out.println("En quin valor de columna es troba la peça a moure (0,7)?");
	            columna = teclat.nextInt();
	            if(tauler.getTauler()[fila][columna].getPeça() == null)System.out.println("Valor incorrecte. Introdueix una opció vàlida.");
	        }
	        while(tauler.getTauler()[fila][columna].getPeça() == null);
	      Peça p1 = tauler.getTauler()[fila][columna].getPeça() ;
	      System.out.println(p1.getPeçaChar()) ;
	      List<Moviment>move =  p1.calcularMovimentsLegals(tauler) ;
	      int n = 0;
	       for (int i = 0 ; i < move.size() ; i++) {
		  		System.out.printf("Moviment " + n + ": (%d ,%d)\n" ,move.get(i).getDestinacio().getFila() ,move.get(i).getDestinacio().getColumna());
		  		++n;
	       }
	       System.out.println("Quin moviment voleu?");
	       int y;
	       y = teclat.nextInt();
	       move.get(y).getDestinacio() ;
	       if(move.get(y).MoveCauseJaque())System.out.println("El moviment causa escac");
	       else System.out.println("El moviment no causa escac");
	    }

	    

	    public static void menu(){
	        System.out.println("\n0) Sortir \n1) Constructora amb valors \n2) Get Destinació \n3) Get Tauler \n4) Get Peça Moguda \n5) Set Destinació"
	        		+ "\n6) Set Peça Moguda \n7) Set Tauler \n8) Trobar el Rei \n9) Moviment causa escac");
	    }

	    
	    public static void main (String args[]){
	        System.out.println("Driver Moviment");
	        System.out.println("Elegeix quin mètode vols comprovar: ");
	        menu();

	        int opcio = teclat.nextInt();
	        while(opcio != 0){
	            if(opcio == 1){
	            	testConstructoraValors();
	            }
	            else if(opcio == 2){
	            	testGetDestinacio();
	            }
	            else if(opcio == 3){
	            	testGetTauler();
	            }
	            else if(opcio == 4){
	            	testGetPeçaMoguda();
	            }
	            else if(opcio == 5) {
	            	testSetDestinacio();
	            }
	            else if(opcio == 6) {
	            	testSetPeçaMoguda();
	            }
	            else if(opcio == 7) {
	            	testSetTauler();
	            }
	            else if(opcio == 8) {
	            	testTrobarElRei();
	            }
	            else if(opcio == 9) {
	            	testMoveCauseJaque();
	            }
	            menu();
	            opcio = teclat.nextInt();
	        }

	        System.out.println("Finalització del Driver Moviment");
	    }


}
