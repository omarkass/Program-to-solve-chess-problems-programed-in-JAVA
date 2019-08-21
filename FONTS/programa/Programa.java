package programa;
import java.io.IOException;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import domini.*;
import peces.Peça;

public class Programa
{
	private static Scanner teclat = new Scanner(System.in);
    public static Jugador iniciUsuari(){
        System.out.println("--Inici d'usuari--");
        System.out.println("0) Continuar sense registrar-se");
        System.out.println("1) Registrar-se com a usuari");
        System.out.println("2) Iniciar sessió");
        GestioJugadors gestioJugadors = new GestioJugadors();
        Jugador j = new Jugador();
        int opcio = 0;
        do{
            opcio = teclat.nextInt();
            if(opcio < 0 || opcio >= 3) System.out.println("Valor incorrecte. Introdueix una opció vàlida.");
        }
        while(opcio < 0 || opcio >= 3);

        if(opcio == 0){
            System.out.println("Jugador temporal creat amb nom: " + j.getNom());
            return j;
        }
        else if(opcio == 1){
        	gestioJugadors.crearJugador(j);
            System.out.println("Jugador creat");
            gestioJugadors.llistarJugadors();
            System.out.println("Amb quin nom d'usuari voleu iniciar sessió?");
            String nom;
            do{
                nom = teclat.next();
                if(!gestioJugadors.existeixJugador(nom)) System.out.println("Aquest usuari no existeix. Introdueix una opció vàlida.");
                else j = new Jugador(nom);
            }
            while(!gestioJugadors.existeixJugador(nom));
            System.out.println("Sessió iniciada amb el jugador amb nom: " + j.getNom());
            return j;
        }

        else {
            gestioJugadors.llistarJugadors();
            System.out.println("Amb quin nom d'usuari voleu iniciar sessió?");
            String nom;
            do{
                nom = teclat.next();
                if(!gestioJugadors.existeixJugador(nom)) System.out.println("Aquest usuari no existeix. Introdueix una opció vàlida.");
                else j = new Jugador(nom);
            }
            while(!gestioJugadors.existeixJugador(nom));
            System.out.println("Sessió iniciada amb el jugador amb nom: " + j.getNom());
            return j;
        }

    }

    public static int menu(){
    
        System.out.println("\n0) Sortir");
        System.out.println("1) Gestionar Problemes");
        System.out.println("2) Gestionar Usuaris");
        System.out.println("3) Jugar");
        System.out.println("4) Gestionar Ranking");
        System.out.println("5) Comparar algoritmes M1, M2 en N fens");

        int opcio = 0;
        do{
            opcio = teclat.nextInt();
            if(opcio < 0 || opcio > 5) System.out.println("Valor incorrecte. Introdueix una opció vàlida.");
        }
        while(opcio < 0 || opcio > 5);

        System.out.println("Has elegit accedir a l'opció: " + opcio);
        return opcio;
    }

    public static void gestioProblemes() throws IOException{
        System.out.println("\n--Gestió de problemes--");
        System.out.println("0) Crear problema");
        System.out.println("1) Modificar problema");
        System.out.println("2) Eliminar problema");
        System.out.println("3) Llistar problemes");

        int opcio = 0;
        do{
            opcio = teclat.nextInt();
            if(opcio < 0 || opcio > 3) System.out.println("Valor incorrecte. Introdueix una opció vàlida.");
        }
        while(opcio < 0 || opcio > 3);

        GestioProblemes gP = new GestioProblemes();
        if(opcio == 0){
            gP.crearProblema();
        }
        else if(opcio == 1){
        	if(gP.existeixFitxer()) {
	            gP.llistarProblemes();
	            gP.modificarProblema();
	            }
        }
        else if(opcio == 2){
        	if(gP.existeixFitxer()) {
	            gP.llistarProblemes();
	            gP.eliminarProblema();
        	}
        }
        else if(opcio == 3){
        	if(gP.existeixFitxer()) {
            gP.llistarProblemes();
            }
        }
    }

    public static void gestioUsuaris() throws IOException{
        System.out.println("\n--Gestió d'usuaris--");
        System.out.println("0) Crear usuari");
        System.out.println("1) Modificar usuari");
        System.out.println("2) Eliminar usuari");
        System.out.println("3) Llistar usuaris");

        int opcio = 0;
        do{
            opcio = teclat.nextInt();
            if(opcio < 0 || opcio > 3) System.out.println("Valor incorrecte. Introdueix una opció vàlida.");
        }
        while(opcio < 0 || opcio > 3);

        GestioJugadors gJ = new GestioJugadors();
        Jugador j = new Jugador();
        if(opcio == 0){
            gJ.crearJugador(j);
        }
        else if(opcio == 1){
        	if(gJ.existeixFitxer()) {
	            gJ.llistarJugadors();
	            gJ.modificarJugador();
        	}
        }
        else if(opcio == 2){
        	if(gJ.existeixFitxer()) {
        		gJ.llistarJugadors();
        		gJ.eliminarJugador();
        		}
        }
        else if(opcio == 3){
        	if(gJ.existeixFitxer()) {
        		gJ.llistarJugadors();
        	}
        }
    }

    public static void gestioJoc(Jugador j){

    	System.out.println("\n--Jugar--");
        GestioProblemes gP = new GestioProblemes();
        Problema p = new Problema();
        String nomProblema;
    	if(gP.existeixFitxer()) {
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
        	System.out.println("Amb quin tipus de jugadors voleu jugar?");
            System.out.println("0) H1 i H2");
            System.out.println("1) H i M1");
            System.out.println("2) M1 i M1");
            System.out.println("3) M1 i H");
            System.out.println("4) H i M2");
            System.out.println("5) M2 i M1");
            System.out.println("6) M2 i H");


            int opcio = 0;
            do{
                opcio = teclat.nextInt();
                if(opcio < 0 || opcio > 6) System.out.println("Valor incorrecte. Introdueix una opció vàlida.");
            }
            while(opcio < 0 || opcio > 6);
            Ranking ranking = new Ranking(nomProblema);
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

            tauler.imprimirTauler();
            List <Moviment> moves = new ArrayList<Moviment> () ;
            if(opcio == 0){
	        	Jugador j2 = new Jugador();
	        	System.out.println("Iniciar sessió per al jugador H2");
	        	j2 = iniciUsuari();
	        	System.out.println("Comença la partida amb el problema: " + nomProblema + " entre el Jugador: " +
	            j.getNom() + " i el Jugador: " + j2.getNom());
	        	int mat = p.getN();
			    tauler.imprimirTauler();
	        	for(int n = 0; n < mat; ++n) {
		        	System.out.println("Moviment del Jugador: " + j.getNom()) ;
		        	int x;
		        	int y;
		        	boolean mov = true ;
					do{
					mov = true ;
					  System.out.println("Introduir la fila de la peça a moure (0,7)") ;
				      y = teclat.nextInt() ;
					  System.out.println("Introduir la columna de la peça a moure (0,7)") ;
					  x = teclat.nextInt();
			          if(tauler.getTauler()[y][x].getPeça() == null || tauler.getTauler()[y][x].getPeça().getPeçaCol() == colorDef) System.out.println("Peça incorrecta. Introdueix una opció vàlida.");
			          else if ( tauler.getTauler()[y][x].getPeça().calcularMovimentsLegals(tauler).size() == 0  )  {
			        	  System.out.println("Peça incorrecta. Introdueix una opció vàlida.");
			        	  mov = false ;
			          }
			        }
			        while(tauler.getTauler()[y][x].getPeça() == null || tauler.getTauler()[y][x].getPeça().getPeçaCol() == colorDef || mov == false);
					Peça p1 = tauler.getTauler()[y][x].getPeça() ;
					List<Moviment>move = new ArrayList<Moviment> () ;
					move = p1.calcularMoviments(tauler) ;
					int num = 0;
			        for (Moviment m : move) {
				  	   System.out.printf("Moviment " + num + ": (%d ,%d)\n" ,m.getDestinacio().getFila() ,m.getDestinacio().getColumna());
				       ++num;
			        }
			        System.out.println("Quin moviment voleu (contant desde 0)");
			        y = teclat.nextInt();
			        Coordinada nextPos = move.get(y).getDestinacio() ;
			        tauler.move(p1, nextPos);
			        tauler.imprimirTauler();
			        if (n < mat-1) {
			        	System.out.println("Moviment del Jugador: " + j2.getNom()) ;
						int x2;
						int y2;
			        	do{
							System.out.println("Introduir la fila de la peça a moure (0,7)") ;
							y2 = teclat.nextInt() ;
						  System.out.println("Introduir la columna de la peça a moure (0,7)") ;
						  x2 = teclat.nextInt();
				          if(tauler.getTauler()[y2][x2].getPeça() == null || tauler.getTauler()[y2][x2].getPeça().getPeçaCol() != colorDef) System.out.println("Peça incorrecta. Introdueix una opció vàlida.");
				        }
				        while(tauler.getTauler()[y2][x2].getPeça() == null || tauler.getTauler()[y2][x2].getPeça().getPeçaCol() != colorDef);

						Peça p2 = tauler.getTauler()[y2][x2].getPeça() ;
						List<Moviment>move2 =  new ArrayList<Moviment> () ;
						move2 = p2.calcularMoviments(tauler) ;
						int num2 = 0;
				        for (Moviment m : move2) {
					  	   System.out.printf("Moviment " + num2 + ": (%d ,%d)\n" ,m.getDestinacio().getFila() ,m.getDestinacio().getColumna());
					       ++num2;
				        }
				        System.out.println("Quin moviment voleu (contant desde 0)");
				        y = teclat.nextInt();
				        Coordinada nextPos2 = move2.get(y).getDestinacio() ;
				        tauler.move(p2, nextPos2);
				        tauler.imprimirTauler();
			            }
			    }

    			if(tauler.ReiMort(Color.NEGRE))System.out.println("Escac i mat") ;
    			else System.out.println("No s'ha pogut resoldre") ;
	        }
            else if(opcio == 1){
            	System.out.println("Comença la partida amb el problema: " + nomProblema + " entre el Jugador: " +
            j.getNom() + " i el Jugador: M1");
            	System.out.println();

            	if(Partida.calcular_algorithme_defens(p.getN(), tauler, colorDef)) System.out.println("Escac i mat!");
            	else System.out.println("No s'ha pogut resoldre");            
            }
            else if(opcio == 2){
            	System.out.println("Comença la partida amb el problema: " + nomProblema + " entre el Jugador: M1 i el Jugador: M1");
            	System.out.println();
            	int[] s = new int [2];
                s[0] = 0;
                s[1] = 0;
            	if (Partida.calcular_algorithme(p.getN(), 0, tauler, true, colorDef, moves, s)) {
                    String color;
                    if (colorDef == Color.BLANC) color = "negres";
                    else color = "blanques";
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
			        rellotge.canviTorn(1);
			        rellotge.imprimirRellotgeJ1();
			        ranking.afegirPosicio("M1", rellotge.getRellotgeJ1());
                }
                else System.out.println("No s'ha pogut resoldre");
            }
            else if(opcio == 3) {
            	System.out.println("Comença la partida amb el problema: " + nomProblema + " entre el Jugador: M1 i el Jugador: " + j.getNom());
                if (Partida.calcular_algorithme_atac(p.getN(), tauler, colorDef)) {
                	System.out.println("Escac i mat!");
                }
            }
                else if(opcio == 4) {
                	System.out.println("Comença la partida amb el problema: " + nomProblema + " entre el Jugador: " +
                            j.getNom() + " i el Jugador: M1");
                            	System.out.println();

                            	if(Partida.calcular_algorithme_defens_avancat(p.getN(), tauler, colorDef)) System.out.println("Escac i mat!");
                            	else System.out.println("No s'ha pogut resoldre");      
                }
                else if(opcio == 5) {
                	System.out.println("Comença la partida amb el problema: " + nomProblema + " entre el Jugador: M1 i el Jugador: M2");
                	System.out.println();
                	int[] s = new int [2];
                    s[0] = 0;
                    s[1] = 0;
                	if (Partida.calcular_algorithme_avancat(p.getN(), 0, tauler, true, colorDef, moves, s)) {
                        String color;
                        if (colorDef == Color.BLANC) color = "negres";
                        else color = "blanques";
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
    			        rellotge.canviTorn(1);
    			        rellotge.imprimirRellotgeJ1();
    			        ranking.afegirPosicio("M1", rellotge.getRellotgeJ1());
                    }
                    else System.out.println("No s'ha pogut resoldre");
                }
                else if(opcio == 6) {
                 	System.out.println("Comença la partida amb el problema: " + nomProblema + " entre el Jugador: M2 i el Jugador: " + j.getNom());
                    if (Partida.calcular_algorithme_atac_advacat(p.getN(), tauler, colorDef)) {
                    	System.out.println("Escac i mat!");
                }
                else System.out.println("No s'ha pogut resoldre");
            }
        }
    }

    
    public  static void comparar_algorithmes () {
    	  GestioProblemes gP = new GestioProblemes();
    	  int m1 = 0 ;
    	  int m2 = 0 ;
          Problema p = new Problema();
          String nomProblema;
      	if(gP.existeixFitxer()) {
      		System.out.println("\nEscriu el nombre de problemes al que voleu comparar els dos algorithmes:");
      	 	int n = teclat.nextInt();
      	 	while (n > gP.contar_problemes() ) {
      	 		System.out.println("\n nombre de problemes es menor que el nombre que has enterat torna a escriure el nombre");
      	 		n = teclat.nextInt();
      	 	}
      	 	gP.llistarProblemes();
      	  List<String> noms = new ArrayList<String>() ;
      	gP.llistarProblemes();
      	 	for (int i = 0 ; i < n ; i ++) {
          	System.out.println("\nEscriu el nom del problema al que voleu jugar");
          	boolean exist;
              do{
                  nomProblema = teclat.next();
                  exist = gP.existeixProblema(nomProblema);
                  if(!exist)System.out.println("Nom incorrecte. Introdueix una opció vàlida.");
                  else noms.add(nomProblema) ;
              }
              while(!exist);
      	 	}
      	 long temps [] = new long [n*2] ;
      	 int count = 0 ;
      	 	for (int i = 0 ; i < n ; i ++) {
      	 	p = gP.carregarProblema(noms.get(i));
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
              Rellotge r = new Rellotge () ;
              r.iniRellotgeJug1();
              if (Partida.calcular_algorithme(p.getN(), 0, tauler, true, colorDef, moves, s)) 
              m1++;
              r.canviTorn(1);
              temps[count] = r.getT1() ;
              System.out.println(" el problema: " + noms.get(i) + " utilitzant M1 ha tardat: " +  temps[count]);
              count++ ;
              r.iniRellotgeJug2();
              if(Partida.calcular_algorithme_avancat(p.getN(), 0, tauler, true, colorDef, moves, s)) 
             m2++ ;
              r.canviTorn(0);
              temps[count] = r.getT2() ;
             System.out.println(" el problema: " + noms.get(i) + " utilitzant M2 ha tardat: " +  temps[count]);
             count++ ; 
    }
     
      	 	
      	 	
      	}
      	 System.out.println("M1 ha resolt " + m1 + " problemes");
      	 System.out.println("M2  ha resolt " + m2 + " problemes");
   
      	}
      public void comparar_algorithmes_interficie(JFrame j, int n, JLabel jj) {  

      GestioProblemes gP = new GestioProblemes();
  	  int m1 = 0 ;
  	  int m2 = 0 ;

        Problema p = new Problema();
        JOptionPane jop = new JOptionPane();
		ArrayList<String> noms = new ArrayList<String>();

        if(gP.existeixFitxer()) {
        	
        	
	    	for (int i=1; i<Integer.valueOf(n)+1; ++i) {
	    		
	    		String code = JOptionPane.showInputDialog(
	    		        j, 
	    		        "Entra el nom del problema " + i, 
	    		        "Entrada Problema", 
	    		        JOptionPane.PLAIN_MESSAGE);
	    		
	    		if (code == null) {
	    			jop.showMessageDialog(j, "Entrada Cancelada", "Interrupcio",  JOptionPane.WARNING_MESSAGE );
                	return;
	    		} else {
		    		boolean exist = gP.existeixProblema(code);
		    		
	                if(!exist) {
	                	jop.showMessageDialog(j, "El problema no existeix, torna a entrar el problema " + i, "Error", JOptionPane.WARNING_MESSAGE );
	                	i--;
	                }else {
	                	noms.add(code);
	        	    	

	                }
	    		}
	    		
	    	}
	        
	    	ArrayList<String> pm1 = new ArrayList<String>();

	    	ArrayList<String> pm2 = new ArrayList<String>();
	        
	    	String resultat = "";
	    	long temps [] = new long [n*2] ;
	    	int count = 0 ;
    	 	for (int i = 0 ; i < n ; i ++) {
    	 	p = gP.carregarProblema(noms.get(i));
            Tauler tauler;
            tauler = new Tauler();
            tauler.creacioTauler();
            tauler.emplenarTauler(p.getFENini().toCharArray());
            String fen = p.getFENini();
            String[] fenSplit = fen.split(" ");
            Color colorDef;
            if (fenSplit[1].equals("w")) colorDef = Color.NEGRE;
            else colorDef = Color.BLANC;
        	//System.out.println("Tauler inicial: ");
        	int[] s = new int [2];
            tauler.imprimirTauler();
            List <Moviment> moves = new ArrayList<Moviment> () ;
            
            Rellotge r = new Rellotge () ;
            r.iniRellotgeJug1();
            if (Partida.calcular_algorithme(p.getN(), 0, tauler, true, colorDef, moves, s)) { 
            m1++;
            pm1.add(p.getNom());
            }            
            
            r.canviTorn(1);
            temps[count] = r.getT1() ;
            count++ ;
            
            r.iniRellotgeJug2();
            if(Partida.calcular_algorithme_avancat(p.getN(), 0, tauler, true, colorDef, moves, s)) { 
            m2++ ;
            pm2.add(p.getNom());
            }
            r.canviTorn(0);
            temps[count] = r.getT2() ;
            count++;
            
  }			
    	 	
    	 	resultat = "L'algoritme M1 ha pogut resoldre " + m1 + " problemes \n";
    	 	resultat = resultat + "(";
    	 	
    	 	int r=-2;
    	 	for (int i=0; i<pm1.size(); ++i) {
    	 		resultat = resultat + pm1.get(i) + ": ";
    	 		resultat = resultat + temps[r+2];
    	 		resultat = resultat + "; ";
    	 		r=r+2;
    	 	}
    	 	
    	 	resultat = resultat + ")\nL'algoritme M2 ha pogut resoldre " + m2 + " problemes \n";
    	 	resultat = resultat + "(";
    	 	int c=-1;
    	 	for (int i=0; i<pm2.size(); ++i) {
    	 		resultat = resultat + pm2.get(i) + ": ";
    	 		resultat = resultat + temps[c+2];
    	 		resultat = resultat + "; ";
    	 		c=c+2;
    	 	}
    	 	resultat = resultat + ")";
    	 	jop.showMessageDialog(j, resultat, "Resultats", JOptionPane.INFORMATION_MESSAGE);
    	 	jj.setVisible(false);
    	}
    	int m [] = new int[2] ;
    	m[0] = m1 ;
    	m[1] = m2 ;
  

    	}
  
    
    
    public static void gestioRanking() throws IOException{
        System.out.println("--Ranking--");
        System.out.println("0) Consultar Ranking");
        System.out.println("1) Esborrar posició");
        Ranking r = new Ranking();
        int opcio = 0;
        do{
            opcio = teclat.nextInt();

            if(opcio < 0 || opcio >= 2) System.out.println("Valor incorrecte. Introdueix una opció vàlida.");
        }
        while(opcio < 0 || opcio >= 2);

        if(opcio == 0) {
        	System.out.println("Rankings disponibles: ");
        	Set<String> fileList = new HashSet<>();
        	fileList = r.llistarRankings();
        	System.out.println("De quin problema voleu consultar el ranking");
            String nom;
            do{
               nom = teclat.next();
               if(!fileList.contains(nom)) System.out.println("Aquest ranking no existeix. Introdueix una opció vàlida.");
               else r = new Ranking(nom);
            }
            while(!fileList.contains(nom));
            r.imprimirRanking();
        }
        else {
        	System.out.println("Rankings disponibles: ");
        	Set<String> fileList = new HashSet<>();
        	fileList = r.llistarRankings();
        	System.out.println("De quin problema voleu eliminar una posició del ranking");
            String nom;
            do{
               nom = teclat.next();
               if(!fileList.contains(nom)) System.out.println("Aquest ranking no existeix. Introdueix una opció vàlida.");
               else r = new Ranking(nom);
            }
            while(!fileList.contains(nom));
            if(r.getRanking().isEmpty()) System.out.println("No existeixen posicions per a aquest problema");
            else {
            	r.imprimirRanking();
            	System.out.println("Quin usuari voleu esborrar?");
            	nom = teclat.next();
            	r.esborrarPosicio(nom);
        	}
        }
    }

    public static void main(String args[]) throws IOException{
        System.out.println("Entorn de resolució de Problemes d'Escacs\n");

        Jugador j1 = iniciUsuari();

        int opcio = menu();
        while(opcio != 0) {
	        if(opcio == 1){
	            gestioProblemes();
	        }
	        else if(opcio == 2){
	            gestioUsuaris();
	        }
	        else if(opcio == 3){
	            gestioJoc(j1);
	        }
	        else if(opcio == 4){
	            gestioRanking();
	        }
	        else if (opcio == 5) {
	        	comparar_algorithmes();
	        }
	        else{
	            System.out.println("Error");
	        }
	        opcio = 0;

            opcio = menu();
        }
        System.out.println("Finalització del programa!");
    }
}
