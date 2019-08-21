package domini;
import java.io.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import programa.*;

public class GestioProblemes
{
	private static String PATH = "./problemes.txt" ;
	private static String AUXPATH = "./problemesaux.txt" ;
	private static String exceptionFile = "No es troba el fitxer: " + PATH;
    private static Scanner teclat = new Scanner(System.in);

    /**
     * Constructor for objects of class GestioProblemes
     */
    public GestioProblemes()
    {
    }

    public boolean existeixFitxer(){
   	 File f = new File(PATH);
        try {
            Scanner sc = new Scanner(f);
            if(!sc.hasNextLine()) {
           	 System.out.println("No hi ha cap problema a la BD");
                sc.close();
           	 return false;
            }
            else {
                sc.close();
           	 return true;
            }
        } catch (FileNotFoundException e) {
            System.out.println(exceptionFile);
        }
		return false;
    }
    public String llegirProblema(String id){

       try {
        	File f = new File(PATH);
            Scanner sc = new Scanner(f);
            // sc.nextLine() ;
            String line = "";
            while (sc.hasNextLine()) {
                line = sc.nextLine() ;
                Scanner st = new Scanner(line) ;
                String s = "" ;
                char c1='0';
                while(c1 != ',') {
                    c1 = st.findInLine(".").charAt(0);
                    if (c1 != ',') s = s + c1 ;
                }
                st.close();
                if (s.equals(id) ) {
                	sc.close();
                    return line;
                    //System.out.print(line);
                }
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println(PATH);
        }
        return "No s'ha trobat el problema";
    }

    public void llistarProblemes(){

        File f = new File(PATH);
        try {
            Scanner sc = new Scanner(f);
            // sc.nextLine() ;
            String line = "";
            if(!sc.hasNextLine()) System.out.println("No hi ha cap problema a la BD");
            else System.out.println("Problemes disponibles: ");

            while (sc.hasNextLine()) {
                line = sc.nextLine() ;
                Scanner st = new Scanner(line) ;
                String s = "" ;
                char c1 = '0' ;
                while(c1 != ',') {
                    c1 = st.findInLine(".").charAt(0);
                    if (c1 != ',') s = s + c1 ;
                }
                st.close();
                System.out.println(line);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(exceptionFile);
        }
    }
	  public String llegirProblemaInterficie(String id){

        try {
         	File f = new File(PATH);
             Scanner sc = new Scanner(f);
             // sc.nextLine() ;
             String line = "";
             while (sc.hasNextLine()) {
                 line = sc.nextLine() ;
                 Scanner st = new Scanner(line) ;
                 String s = "" ;
                 char c1='0';
                 while(c1 != ',') {
                     c1 = st.findInLine(".").charAt(0);
                     if (c1 != ',') s = s + c1 ;
                 }
                 st.close();
                 if (s.equals(id) ) {
                 	sc.close();
                     return line;
                     //System.out.print(line);
                 }
             }
             sc.close();

         } catch (FileNotFoundException e) {
             System.out.println(PATH);
         }
         return "No s'ha trobat el problema";
     }
	public void llistarProblemesInterficie(JFrame frame){

        File f = new File(PATH);
        try {
            Scanner sc = new Scanner(f);
            // sc.nextLine() ;
            String line = "";
           
            while (sc.hasNextLine()) {
                line = line + sc.nextLine() + "\n" ;
            }
            sc.close();
            JOptionPane jop = new JOptionPane();
            jop.showMessageDialog(frame,
 	  	 		    line,
 	  	 		    "Problemes",
 	  	 		    JOptionPane.INFORMATION_MESSAGE);  
            
        } catch (FileNotFoundException e) {
            System.out.println(exceptionFile);
        }
    }


    public Problema stringtoProblemas(String line){

        Problema p = new Problema();
        String[] parts = line.split(",");

        p.setnom(parts[0]);
        p.setFEN(parts[1]);
        int n = Integer.parseInt(parts[2]);
        p.setN(n);
        int d = Integer.parseInt(parts[3]);
        p.setdif(d);
        return p;
    }

    public boolean existeixProblema(String n){
    	if(existeixfitxer(PATH)) {

            File f = new File(PATH);
            try {
                Scanner sc = new Scanner(f);

                boolean found = false ;
                String[] lineSplit;
                String line="";
                while (sc.hasNextLine()  && !found) {
                    line = sc.nextLine();
                    lineSplit = line.split(",");
                    if (lineSplit[0].equals(n)) {
                    sc.close();
                    return true;
                    }
                }


                sc.close();
                }
            	catch (FileNotFoundException e) {
                System.out.println(exceptionFile);
            }

    }
    	return false;
  }
    
    
    
    public int contar_problemes() {
  	  int c = 0 ; 
  	  File f = new File(PATH);
        try {
            Scanner sc = new Scanner(f);
            // sc.nextLine() ;
            String line = "";
            if(!sc.hasNextLine()) System.out.println("No hi ha cap problema a la BD");
            while (sc.hasNextLine()) {
          	  	c++ ;
                line = sc.nextLine() ;
                Scanner st = new Scanner(line) ;
                String s = "" ;
                char c1 = '0' ;
                while(c1 != ',') {
                    c1 = st.findInLine(".").charAt(0);
                    if (c1 != ',') s = s + c1 ;
                }
                st.close();
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(exceptionFile);
        }
        return c ;
    }

 public void crearProblema(){

        boolean exist = false;
        String nom;
        do{

            System.out.println("Quin es el nom del problema?");
            nom = teclat.next();
            exist = existeixProblema(nom);
            if(exist) System.out.println("Aquest nom ja es troba utilitzat");
        }while(exist);

        System.out.println("Quin es el FEN del problema?");
        String fen = teclat.next() + ' ' + teclat.next() + ' ' + teclat.next() + ' ' + teclat.next() + ' ' + teclat.next() + ' ' + teclat.next();


        while (!Partida.ComprovarFen(fen)) {
            System.out.println("FEN Incorrecte. Quin es el FEN del problema?");

       	 fen = teclat.next() + ' ' + teclat.next() + ' ' + teclat.next() + ' ' + teclat.next() + ' ' + teclat.next() + ' ' + teclat.next();
        }
         System.out.println("FEN correcte");
         
         System.out.println("Quin es el nombre de torns per arribar al mat?");
         int n = teclat.nextInt();
        
         Tauler tauler = new Tauler();
         tauler.creacioTauler();
         tauler.emplenarTauler(fen.toCharArray());
         
         String atacant[] = fen.split(" ");
       
         Color colordefensor;

         if (atacant[1].equals("w")) colordefensor= Color.NEGRE;
         else colordefensor=Color.BLANC;
         
     	int[] s = new int [2];
        s[0] = 0;
        s[1] = 0;
		 List <Moviment> moves = new ArrayList<Moviment> () ;
		 
         if (!Partida.calcular_algorithme(n, 0, tauler, true, colordefensor, moves, s)) {
        	 System.out.println("El problema no te solucio");
         }
         else {		
	        System.out.println("Quina es la dificultat del problema?");
	        int dif = teclat.nextInt();
	
	        Problema p = new Problema(nom, n, fen, dif);
	
	        System.out.println("Voleu guardar aquest problema en la base de dades?");
	        System.out.println("0: Si 1: No");
	        int x = teclat.nextInt();
	
	        if(x == 0){
	            afegirProblema(p);
	        }
        }
    }
 public void crearProblemaInterficie(String nomp, String fenp, String mat, String dificultat, JFrame f){

     boolean exist = false;
     String nom;

         nom = nomp;
         exist = existeixProblema(nom);
         if (exist) {
         	JOptionPane jop = new JOptionPane();
         	jop.showMessageDialog(f,
         		    "Aquest nom ja es troba utilitzat",
         		    "Problema Ja Existeix",
         		    JOptionPane.ERROR_MESSAGE);
         	return;
         }
         


     
     String fen = fenp;


     
     if (!Partida.ComprovarFen(fen)) {
    	 	JOptionPane jop = new JOptionPane();
    	 	jop.showMessageDialog(f,
    	 		    "FEN Incorrecte",
    	 		    "El Format FEN és Incorrecte",
    	 		    JOptionPane.ERROR_MESSAGE); 
    	 	return;
     }
      
      
      int n = Integer.valueOf(mat);
     
      Tauler tauler = new Tauler();
      tauler.creacioTauler();
      tauler.emplenarTauler(fen.toCharArray());
      
      String atacant[] = fen.split(" ");
    
      Color colordefensor;

      if (atacant[1].equals("w")) colordefensor= Color.NEGRE;
      else colordefensor=Color.BLANC;
      
  	int[] s = new int [2];
     s[0] = 0;
     s[1] = 0;
		 List <Moviment> moves = new ArrayList<Moviment> () ;
		 
      if (!Partida.calcular_algorithme(n, 0, tauler, true, colordefensor, moves, s)) {
    	  JOptionPane jop = new JOptionPane();
  	 		jop.showMessageDialog(f,
  	 		    "Sense Solucio",
  	 		    "El Problema no te solucio",
  	 		    JOptionPane.ERROR_MESSAGE);       
  	 		}
      else {		
    	  	int dif = Integer.valueOf(dificultat);
	
	        Problema p = new Problema(nom, n, fen, dif);	
	        
	            afegirProblema(p);
	            JOptionPane jop = new JOptionPane();
	  	 		jop.showMessageDialog(f,
	  	  	 		    "Problema Afegit Correctament!",
	  	  	 		    "Afegit!",
	  	  	 		    JOptionPane.INFORMATION_MESSAGE);  
      }
 }


    public void afegirProblema(Problema p){
        try{
             File f = new File(PATH);
             BufferedWriter bw;

             if(f.exists()){
                 bw = new BufferedWriter(new FileWriter(f,true));
                 bw.write(p.getNom() + "," + p.getFENini() + "," + p.getN() + "," + p.getDif());
                 bw.newLine();
                 bw.close();
             }
             else{
                 bw = new BufferedWriter(new FileWriter(f));
                 bw.write(p.getNom() + "," + p.getFENini() + "," + p.getN() + "," + p.getDif());
                 bw.newLine();
                 bw.close();
             }
        } catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public boolean existeixfitxer(String pathfile) {
    	File inFile = new File(pathfile);

    	if (!inFile.isFile()) {
    		return false;
    	}

    	return true;


    }

    public void eliminarProblema() throws IOException {
        System.out.println("Quin es el nom del problema que voleu eliminar?");
        String nom = teclat.next();
        boolean exist = existeixProblema(nom);
        if(exist == false) System.out.println("Aquest nom no existeix");
        else{
            //Eliminar problema
            esborrarproblema(nom);
        }
    }
    
    
    public void eliminarProblemaInterficie(String nomp, JFrame f) throws IOException {
        String nom = nomp;
        boolean exist = existeixProblema(nom);
        JOptionPane jop = new JOptionPane();
        if(exist == false) {
        	
  	 		jop.showMessageDialog(f,
  	  	 		    "Aquest problema no existeix!",
  	  	 		    "Error!",
  	  	 		    JOptionPane.ERROR_MESSAGE);  
        }
        else{
            //Eliminar problema
            esborrarproblema(nom);
            jop.showMessageDialog(f,
  	  	 		    "Problema Eliminat Correctament!",
  	  	 		    "Satisfactori!",
  	  	 		    JOptionPane.INFORMATION_MESSAGE);  
        }
    }

    public void modificarProblema() throws IOException {

         System.out.println("Quin problema vols modificar?");

         String nomProblema = teclat.next();



         boolean exist = existeixProblema(nomProblema);
         if(exist == false){
             System.out.println(nomProblema + " no existeix a la base de dades");
         }
         else{
             System.out.println("Que voleu modificar del problema?");
             System.out.println("1) NOM");
             System.out.println("2) FEN");
             System.out.println("3) N");
             System.out.println("4) DIFICULTAT");

             int num = teclat.nextInt();

             String nom_p = llegirProblema(nomProblema);
             Problema p = stringtoProblemas(nom_p);

             if (num == 1) {
            	 System.out.println("Quin es el nou nom?");
            	 String nounom = teclat.next();
            	 exist = existeixProblema(nounom);
                 while(exist){
                     System.out.println("Ja existeix una instancia a la base de dades amb el nom" + nounom + "\n Entra un altre nom");            	 
                     nounom = teclat.next();
                	 exist = existeixProblema(nounom);
                     
                 }
                 System.out.println("Nom canviat correctament");
                     
                     p.setnom(nounom);
             }
             else if(num == 2){
                 System.out.println("Quin es el nou FEN?");
                 String FEN = teclat.next() + ' ' + teclat.next() + ' ' + teclat.next() + ' ' + teclat.next() + ' ' + teclat.next() + ' ' + teclat.next();


                 while (!Partida.ComprovarFen(FEN)) {
                	 FEN = teclat.next() + ' ' + teclat.next() + ' ' + teclat.next() + ' ' + teclat.next() + ' ' + teclat.next() + ' ' + teclat.next();
                 }
                 System.out.println("FEN Correcte");
                 
                 
                 Tauler tauler = new Tauler();
                 tauler.creacioTauler();
                 tauler.emplenarTauler(FEN.toCharArray());
                 
                 String atacant[] = FEN.split(" ");
               
                 Color colordefensor;

                 if (atacant[1].equals("w")) colordefensor= Color.NEGRE;
                 else colordefensor=Color.BLANC;
                 
             	int[] s = new int [2];
                s[0] = 0;
                s[1] = 0;
        		 List <Moviment> moves = new ArrayList<Moviment> () ;
        		 
                 if (!Partida.calcular_algorithme(p.getN(), 0, tauler, true, colordefensor, moves, s)) {
                	 System.out.println("El problema no te solucio. No es modifica el FEN");
                 }
                 else {		
                 
                 p.setFEN(FEN);
                 }
             }
             else if(num == 3){
                 System.out.println("Quin es el nou N?");
                 int n = teclat.nextInt();
                 p.setN(n);
                 System.out.println("N canviada correctament");

             }
             else if(num == 4) {
                 System.out.println("Quina es la nova dificultat?");
                 int n = teclat.nextInt();
                 p.setdif(n);
                 System.out.println("Dificultat Canviada correctament");
             }

             System.out.println("Voleu modificar-lo a la base de dades?");
             System.out.println("0: Si 1: No");
             int ent = teclat.nextInt();
             if (ent==0) {

            	 esborrarproblema(nomProblema);
            	 afegirProblema(p);

             }

         }

    }
    
    
    
    
    public void canviarnomProblemaInterficie(String nomProbl, String nounomproblema, JFrame f) throws IOException {

    	JOptionPane jop = new JOptionPane();
    	
        String nomProblema = nomProbl;
        
        boolean exist = existeixProblema(nomProblema);
        if(exist == false){

        	jop.showMessageDialog(f,
  	  	 		    "El Problema que voleu modificar no existeix",
  	  	 		    "No Existeix",
  	  	 		    JOptionPane.ERROR_MESSAGE);  
        	return;
	
        }
                
            String nom_p = llegirProblema(nomProblema);
            Problema p = stringtoProblemas(nom_p);

             String nounom = nounomproblema;
           	 exist = existeixProblema(nounom);
                if(exist){
                	jop.showMessageDialog(f,
          	  	 		    "Ja existeix una instancia a la base de dades amb el nom " + nounom,
          	  	 		    "Error!",
          	  	 		    JOptionPane.ERROR_MESSAGE);
                	
                	return;
                }

                    p.setnom(nounom);
                    esborrarproblema(nomProblema);
               	 	afegirProblema(p);


                	jop.showMessageDialog(f,
          	  	 		    "Nom canviat correctament!",
          	  	 		    "Exit!",
          	  	 		    JOptionPane.INFORMATION_MESSAGE);  
    }

    
    public void canviarFENProblemaInterficie(String nomProbl, String nouFEN, JFrame f) throws IOException {

    	JOptionPane jop = new JOptionPane();


            String nomProblema = nomProbl;



            boolean exist = existeixProblema(nomProblema);
            if(exist == false){

            	jop.showMessageDialog(f,
      	  	 		    "El Problema que voleu modificar no existeix",
      	  	 		    "No Existeix",
      	  	 		    JOptionPane.ERROR_MESSAGE);  
            	return;

            }
            else{

                String nom_p = llegirProblema(nomProblema);
                Problema p = stringtoProblemas(nom_p);

                    String FEN = nouFEN;

                    if (!Partida.ComprovarFen(FEN)) {
                    	
                         	jop.showMessageDialog(f,
                  	  	 		    "El Format del FEN és Incorrecte",
                  	  	 		    "ERROR!",
                  	  	 		    JOptionPane.ERROR_MESSAGE);  
                        	return;

                    }
                    
                    Tauler tauler = new Tauler();
                    tauler.creacioTauler();
                    tauler.emplenarTauler(FEN.toCharArray());
                    
                    String atacant[] = FEN.split(" ");
                  
                    Color colordefensor;

                    if (atacant[1].equals("w")) colordefensor= Color.NEGRE;
                    else colordefensor=Color.BLANC;
                    
                	int[] s = new int [2];
                   s[0] = 0;
                   s[1] = 0;
           		 List <Moviment> moves = new ArrayList<Moviment> () ;
           		 
                    if (!Partida.calcular_algorithme(p.getN(), 0, tauler, true, colordefensor, moves, s)) {

                    	jop.showMessageDialog(f,
              	  	 		    "El problema no te solucio. No es modifica el FEN",
              	  	 		    "Error!",
              	  	 		    JOptionPane.ERROR_MESSAGE);  
                    	return;
                    }
                    else {		
                    
                    p.setFEN(FEN);
                    }
                 
                 esborrarproblema(nomProblema);
               	 afegirProblema(p);

                }
            		jop.showMessageDialog(f,
  	  	 		    "FEN Modificat Correctament!",
  	  	 		    "Satisfactori",
  	  	 		    JOptionPane.INFORMATION_MESSAGE);  

 }

    public void canviarMatProblemaInterficie(String nomProbl, String nouMatparam, JFrame f) throws IOException {

    	JOptionPane jop = new JOptionPane();


            String nomProblema = nomProbl;



            boolean exist = existeixProblema(nomProblema);
            if(exist == false){

            	jop.showMessageDialog(f,
      	  	 		    "El Problema que voleu modificar no existeix",
      	  	 		    "No Existeix",
      	  	 		    JOptionPane.ERROR_MESSAGE);  
            	return;

            }
            else{

                String nom_p = llegirProblema(nomProblema);
                Problema p = stringtoProblemas(nom_p);

                String  FEN = p.getFENini();
                int noumat = Integer.valueOf(nouMatparam);
                
                    Tauler tauler = new Tauler();
                    tauler.creacioTauler();
                    tauler.emplenarTauler(FEN.toCharArray());
                    
                    String atacant[] = FEN.split(" ");
                  
                    Color colordefensor;

                    if (atacant[1].equals("w")) colordefensor= Color.NEGRE;
                    else colordefensor=Color.BLANC;
                    
                	int[] s = new int [2];
                   s[0] = 0;
                   s[1] = 0;
           		 List <Moviment> moves = new ArrayList<Moviment> () ;
           		 
                    if (!Partida.calcular_algorithme(noumat, 0, tauler, true, colordefensor, moves, s)) {

                    	jop.showMessageDialog(f,
              	  	 		    "El problema no te solucio. No es modifica el Mat",
              	  	 		    "Error!",
              	  	 		    JOptionPane.ERROR_MESSAGE);  
                    	return;
                    }
                    else {		
                    
                    p.setN(noumat);
                    }
                 
                 esborrarproblema(nomProblema);
               	 afegirProblema(p);

                }
            		jop.showMessageDialog(f,
  	  	 		    "Mat Modificat Correctament!",
  	  	 		    "Satisfactori",
  	  	 		    JOptionPane.INFORMATION_MESSAGE);  

 }
        	

    public void canviarDifProblemaInterficie(String nomProbl, String novadificultat, JFrame f) throws IOException {

    	JOptionPane jop = new JOptionPane();


            String nomProblema = nomProbl;



            boolean exist = existeixProblema(nomProblema);
            if(exist == false){

            	jop.showMessageDialog(f,
      	  	 		    "El Problema que voleu modificar no existeix",
      	  	 		    "No Existeix",
      	  	 		    JOptionPane.ERROR_MESSAGE);  
            	return;

            }
            else{

                String nom_p = llegirProblema(nomProblema);
                Problema p = stringtoProblemas(nom_p);
                
                int nouDif = Integer.valueOf(novadificultat);
                p.setdif(nouDif);
           
                 
                 esborrarproblema(nomProblema);
               	 afegirProblema(p);

                
            		jop.showMessageDialog(f,
  	  	 		    "Dificultat Modificada Correctament!",
  	  	 		    "Satisfactori",
  	  	 		    JOptionPane.INFORMATION_MESSAGE);  

            	}
    }



  public static void esborrarproblema(String nomp) throws IOException {

	  try {
	  		File inputFile = new File(PATH);
            File tempFile = new File(AUXPATH);

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            String[] nomplinia;
            while((currentLine = reader.readLine()) != null) {
                if(null!=currentLine){
                	nomplinia = currentLine.split(",");
                	if (!nomplinia[0].equals(nomp)) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                	}
                }
            }
            reader.close();
            writer.close();


            boolean deleted = inputFile.delete();

            if (deleted) {
            	boolean successful = tempFile.renameTo(inputFile);
            	if (successful) {
            		System.out.println("Base de Dades Actualitzada \n");
            	}
            	else System.out.println("Base de Dades Perduda \n");
            }
            else {
            	boolean successful = tempFile.renameTo(inputFile);
            	if (successful) {
            		System.out.println("Base de Dades Actualitzada \n");
            	}
            	else System.out.println("No s'ha pogut actualitzar la Base de Dades \n");
            }
	  } catch (FileNotFoundException e) {
		  System.out.println("No es troba la ruta :" + PATH) ;

	 } catch (IOException e1) {
		 System.out.println(e1);
	 }

}

  public Problema carregarProblema(String nom) {
  	Problema p = new Problema();
  	if(existeixfitxer(PATH)) {

          File f = new File(PATH);
          try {
              Scanner sc = new Scanner(f);
              boolean found = false ;
              String[] lineSplit;
              String line="";
              while (sc.hasNextLine()  && !found) {
                  line = sc.nextLine();
                  lineSplit = line.split(",");
                  if (lineSplit[0].equals(nom)) {
                  	p.setnom(lineSplit[0]);
                  	p.setN(Integer.parseInt(lineSplit[2]));
                  	p.setFEN(lineSplit[1]);
                  	p.setdif(Integer.parseInt(lineSplit[3]));
                  }
              }
          sc.close();
          }
      	catch (FileNotFoundException e) {
          System.out.println(exceptionFile);
      	}
  	}
  	return p;
  }

}
