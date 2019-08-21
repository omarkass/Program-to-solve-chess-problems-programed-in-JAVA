package programa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import domini.GestioProblemes;

public class DriverPartida {
	private static Scanner teclat = new Scanner(System.in);
    
    public static  void testModificarTauler(){
		
        System.out.println("Modifiquem el tauler amb el següent fen: "
        		+ "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1");
        String fen = "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1";
        Partida.modificar_taule(fen);
        System.out.println("\nTauler modificat:");
        Partida.GetTauler().imprimirTauler();
    } 
    
    public static  void testGetTauler(){
        String fen = "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1";
        Partida.modificar_taule(fen);
		System.out.println("Partida amb tauler:");
		Partida.GetTauler().imprimirTauler();
    } 
    
    public static  void testComprovarFen(){
        System.out.println("Comprovem si el següent fen es correcte: "
        		+ "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1");
        String fen = "1N1b4/6nr/R5n1/2Ppg2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1";
        if(Partida.ComprovarFen(fen)) System.out.println("El fen es correcte");
        else System.out.println("El fen no es correcte");
    } 
    
    public static  void testAlgoritmeAtac(){
    	Tauler tauler = new Tauler();
    	tauler.creacioTauler();
		String s ="1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B";
	    tauler.emplenarTauler(s.toCharArray());
    	System.out.println("Tauler inicial: ");
	    tauler.imprimirTauler();
        if (Partida.calcular_algorithme_atac(2, tauler, Color.NEGRE)) {
        	System.out.println("Escac i mat!");
        }
        else System.out.println("No s'ha pogut resoldre");
    } 
    
    public static  void testAlgoritmeAtacAvancat(){
    	Tauler tauler = new Tauler();
    	tauler.creacioTauler();
		String s ="1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B";
	    tauler.emplenarTauler(s.toCharArray());
    	System.out.println("Tauler inicial: ");
	    tauler.imprimirTauler();
        if (Partida.calcular_algorithme_atac_advacat(2, tauler, Color.NEGRE)) {
        	System.out.println("Escac i mat!");
        }
       // else System.out.println("No s'ha pogut resoldre");
    } 
    
    public static  void testAlgoritmeDefensaAvancat(){
       	Tauler tauler = new Tauler();
    	tauler.creacioTauler();
		String s ="1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B";
	    tauler.emplenarTauler(s.toCharArray());
    	System.out.println("Tauler inicial: ");
	    tauler.imprimirTauler();
    	if(Partida. calcular_algorithme_defens_avancat(2, tauler, Color.NEGRE)) System.out.println("Escac i mat!");
    	else System.out.println("No s'ha pogut resoldre"); 
    } 
    
    
    public static  void testAlgoritmeDefensa(){
       	Tauler tauler = new Tauler();
    	tauler.creacioTauler();
		String s ="1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B";
	    tauler.emplenarTauler(s.toCharArray());
    	System.out.println("Tauler inicial: ");
	    tauler.imprimirTauler();
    	if(Partida.calcular_algorithme_defens(2, tauler, Color.NEGRE)) System.out.println("Escac i mat!");
    	else System.out.println("No s'ha pogut resoldre"); 
    } 
    
    public static  void testAlgoritme(){
    	Tauler tauler = new Tauler();
    	tauler.creacioTauler();
		String s ="1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B";
	    tauler.emplenarTauler(s.toCharArray());
    	System.out.println("Tauler inicial: ");
	    tauler.imprimirTauler();
    	System.out.println();

	    List <Moviment> moves = new ArrayList<Moviment> () ;
	    if (Partida.calcular_algorithme(2, 0, tauler, true, Color.NEGRE, moves, new int [2])) {
            String color;
            color = "blanques";
            Collections.reverse(moves);
        	for (Moviment m : moves) {
            	m.getTauler().imprimirTauler();
            	char peça = m.getPeçaMoguda().getPeçaChar();
            	Coordinada d = m.getDestinacio();
            	String destinacio = d.coordenadatolletranum(d);
            	System.out.println( "Les " + color + " mouen " + peça + " a " + destinacio);
            	System.out.println();
            	if (color == "blanques") color = "negres";
            	else color = "blanques";
            }
        	System.out.println("Escac i mat!");
        }
        else System.out.println("No s'ha pogut resoldre");
    } 
    
    
    public static  void testAlgoritmeAvancat(){
    	Tauler tauler = new Tauler();
    	tauler.creacioTauler();
		String s ="r1b2k1r/ppppq3/5N1p/4P2Q/4PP2/1B6/PP5P/n2K2R1";
	    tauler.emplenarTauler(s.toCharArray());
    	System.out.println("Tauler inicial: ");
	    tauler.imprimirTauler();
    	System.out.println();

	    List <Moviment> moves = new ArrayList<Moviment> () ;
	    if (Partida.calcular_algorithme_avancat(2, 0, tauler, true, Color.NEGRE, moves, new int [2])) {
            String color;
            color = "blanques";
            Collections.reverse(moves);
        	for (Moviment m : moves) {
            	m.getTauler().imprimirTauler();
            	char peça = m.getPeçaMoguda().getPeçaChar();
            	Coordinada d = m.getDestinacio();
            	String destinacio = d.coordenadatolletranum(d);
            	System.out.println( "Les " + color + " mouen " + peça + " a " + destinacio);
            	System.out.println();
            	if (color == "blanques") color = "negres";
            	else color = "blanques";
            }
        	System.out.println("Escac i mat!");
        }
        else System.out.println("No s'ha pogut resoldre");
    } 
    
    
    public static  void testSeleccionarTauler(){
		Tauler tauler = new Tauler();
		tauler.creacioTauler();
		tauler.emplenarTaulerInici();
		Tauler tauler2 = new Tauler();
		tauler2.creacioTauler();
        String fen = "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1";
		tauler2.emplenarTauler(fen.toCharArray());
		System.out.println("Seleccionem el tauler: ");
		Partida.seleciona_tauler(tauler, tauler2).imprimirTauler();
    } 
	
    public static void menu(){
        System.out.println("\n0) Sortir \n1) Modificar Tauler \n"
        		+ "2) Get Tauler \n3) Comprovar FEN \n4) Calcular algoritme atac \n"
        		+ "5) Calcular algoritme defensa\n6) Calcular algoritme \n7) Seleccionar tauler \n8) Calcular algoritme avancat"
        		+ " \n9) Calcular algoritme defensa avancat  \n10) Calcular algoritme atac avancat\n");
    }
    
    public static void main (String args[]){
        System.out.println("Driver Partida");
        System.out.println("Elegeix quin mètode vols comprovar: ");
        menu();

        int opcio = teclat.nextInt();
        while(opcio != 0){
            if(opcio == 1){
            	testModificarTauler();
            }
            else if(opcio == 2){
            	testGetTauler();
            }
            else if(opcio == 3){
            	testComprovarFen();
            }
            else if(opcio == 4){
            	testAlgoritmeAtac();
            }
            else if(opcio == 5) {
            	testAlgoritmeDefensa();
            }
            else if(opcio == 6) {
            	testAlgoritme();
            }
            else if(opcio == 7) {
            	testSeleccionarTauler();
            }
            else if(opcio == 8) {
            	testAlgoritmeAvancat();
            }
            else if(opcio == 9) {
            	testAlgoritmeDefensaAvancat();
            }
            else if(opcio == 10) {
            	testAlgoritmeAtacAvancat();
            }
            menu();
            opcio = teclat.nextInt();
        }

        System.out.println("Finalització del Driver Partida");
    }
    /////////////////////////////////////
    
    public  static int [] comparar_algorithmes () {
  	  GestioProblemes gP = new GestioProblemes();
  	  int m1 = 0 ;
  	  int m2 = 0 ;
        Problema p = new Problema();
        String nomProblema;
    	if(gP.existeixFitxer()) {
    		System.out.println("\nEscriu el nombre de problemes al que voleu comparar els dos algorithmes");
    	 	int n = teclat.nextInt();
    	 	while (n > gP.contar_problemes() ) {
    	 		System.out.println("\n nombre de problemes es menor que el nombre que has enterat torna a escriure el nombre");
    	 		n = teclat.nextInt();
    	 	}
    	 	for (int i = 0 ; i < n ; i ++) {
    		gP.llistarProblemes();
        	System.out.println("\nEscriu el nom del problema al que voleu jugar");
        	boolean exist;
       
            do{
                nomProblema = teclat.next();
                exist = gP.existeixProblema(nomProblema);
                if(!exist)System.out.println("Nom incorrecte. Introdueix una opció vàlida.");
                else p = gP.carregarProblema(nomProblema);
            }
            while(!exist);
            Rellotge rellotge;
            rellotge = new Rellotge();
            rellotge.iniRellotgeJug1();
            rellotge.iniRellotgeJug2();
            Tauler tauler;
            tauler = new Tauler();
            tauler.creacioTauler();
            tauler.emplenarTauler(p.getFENini().toCharArray());
            String fen = p.getFENini();
            String[] fenSplit = fen.split(" ");
            Color colorDef;

            if (fenSplit[1].equals("w")) colorDef = Color.NEGRE;
            else colorDef = Color.BLANC;
        	System.out.println("Tauler inicial: ");
        	int[] s = new int [2];
            tauler.imprimirTauler();
            List <Moviment> moves = new ArrayList<Moviment> () ;
            System.out.println("Comença la partida amb el problema: " + nomProblema + " entre el Jugador: M1 i el M1: ");
            if (Partida.calcular_algorithme(p.getN(), 0, tauler, true, colorDef, moves, s)) { 
            m1++;
            System.out.print("m1 have win\n");
            }
            if(Partida.calcular_algorithme_avancat(p.getN(), 0, tauler, true, colorDef, moves, s)) {
                m2++ ;
                System.out.print("m2 have win\n");
            }
       
  }
    	
    	}
    	int m [] = new int[2] ;
  	m[0] = m1 ;
    	m[1] = m2 ;
    	return m ;

    	}
    
}
