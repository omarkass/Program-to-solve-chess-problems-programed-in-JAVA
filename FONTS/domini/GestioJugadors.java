package domini;
import java.io.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import programa.*;

public class GestioJugadors
{
    private static Scanner teclat = new Scanner(System.in);
    private static String PATH = "./jugadors.txt" ;
	private static String AUXPATH = "./jugadorsaux.txt" ;
	private static String exceptionFile = "No es troba el fitxer: " + PATH;

    public GestioJugadors(){
    }

     public boolean existeixFitxer(){
    	 File f = new File(PATH);
         try {
             Scanner sc = new Scanner(f);
             if(!sc.hasNextLine()) {
            	 System.out.println("No hi ha cap usuari a la BD");
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

     public boolean existeixJugador(String n){
     	if(existeixfitxer(PATH)) {

             File f = new File(PATH);
             try {
                 Scanner sc = new Scanner(f);

                 boolean found = false ;
                 String line="";
                 while (sc.hasNextLine()  && !found) {
                     line = sc.nextLine();
                     if (line.equals(n)) {
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
     public void llistarJugadors(){

         File f = new File(PATH);
         try {
             Scanner sc = new Scanner(f);
             // sc.nextLine() ;
             String line = "";
             System.out.println("Usuaris disponibles: ");
             while (sc.hasNextLine()) {
                 line = sc.nextLine() ;
                 System.out.println(line);
                 }
             sc.close();
         } catch (FileNotFoundException e) {
             System.out.println(exceptionFile);
         }
     }
 public void llistarJugadorsInterficie(JFrame frame){

    	 String l = "";
         File f = new File(PATH);
         try {
             Scanner sc = new Scanner(f);
             // sc.nextLine() ;
             String line = "";
             while (sc.hasNextLine()) {
                 line = sc.nextLine() ;
            	 l = l + "\n" + line;
                 }
             sc.close();
             JOptionPane jop = new JOptionPane();
             jop.showMessageDialog(frame,
	  	  	 		    l,
	  	  	 		    "Usuaris BD:",
	  	  	 		    JOptionPane.PLAIN_MESSAGE);  

         } catch (FileNotFoundException e) {
             System.out.println(exceptionFile);
         }
     }
     
     
     public void crearJugador(Jugador j){

         boolean exist = false;
         String nom;
         do{

             System.out.println("Quin nom voleu per al jugador?");
             nom = teclat.next();
             exist = existeixJugador(nom);
             if(exist) System.out.println("Aquest nom ja es troba utilitzat");
         }while(exist);

         j = new Jugador(nom);

         System.out.println("Voleu guardar aquest jugador a la base de dades?");
         System.out.println("0: Si 1: No");
         int x = teclat.nextInt();

         if(x == 0){
             afegirJugador(j);
         }
     }


     public void crearJugadorInterficie(String nomJ, JFrame f){

         boolean exist = false;
         String nom;
         JOptionPane jop = new JOptionPane();
	 		

             nom = nomJ;
             exist = existeixJugador(nom);
             if(exist) {
            	jop.showMessageDialog(f,
       	  	 		    "Aquest jugador ja existeix!",
       	  	 		    "Error!",
       	  	 		    JOptionPane.ERROR_MESSAGE);  
            	              
            	 return;
         	 }

         Jugador j = new Jugador(nom);
             afegirJugador(j);
    	 		jop.showMessageDialog(f,
       	  	 		    "Jugador Creat Correctament!",
       	  	 		    "Satisfactori!",
       	  	 		    JOptionPane.INFORMATION_MESSAGE); 
}
     

     public void afegirJugador(Jugador j){
         try{
              File f = new File(PATH);
              BufferedWriter bw;

              if(f.exists()){
                  bw = new BufferedWriter(new FileWriter(f,true));
                  bw.write(j.getNom());
                  bw.newLine();
                  bw.close();
              }
              else{
                  bw = new BufferedWriter(new FileWriter(f));
                  bw.write(j.getNom());
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


     public void eliminarJugador() throws IOException {
         System.out.println("Quin es el nom del Jugador a donar de baixa?");
         String nom = teclat.next();
         boolean exist = existeixJugador(nom);
         if(exist == false) System.out.println("Aquest Jugador no existeix");
         else{
             esborrarjugador(nom);
         }
     }
     public void eliminarJugadorInterficie(String nomJ, JFrame f) throws IOException {
    	 JOptionPane jop = new JOptionPane();
     	   
    	 String nom = nomJ;
         boolean exist = existeixJugador(nom);
         if(exist == false) {
        	 jop.showMessageDialog(f,
 	  	 		    "Aquest jugador no existeix!",
 	  	 		    "Error!",
 	  	 		    JOptionPane.ERROR_MESSAGE);
        	 return;
         }
         else{
             esborrarjugador(nom);
             jop.showMessageDialog(f,
  	  	 		    "Jugador esborrat correctament!",
  	  	 		    "Satisfactori!",
  	  	 		    JOptionPane.INFORMATION_MESSAGE);
         	  
         }
     }
          public void modificarJugador() throws IOException {

          System.out.println("Quin Jugador vols modificar?");

          String nomJugador = teclat.next();



          boolean exist = existeixJugador(nomJugador);
          if(exist == false){
              System.out.println("El jugador no es troba a la base de dades");
          }
          else{
              System.out.println("Introdueix el nou alias pel jugador " + nomJugador);
               
              String alias = teclat.next();
              exist = existeixJugador(alias);
              while(exist) {
            	 System.out.println("Ja existeix una instancia a la base de dades amb el nom" + alias + "\n Entra un altre nom" ); 
            	 alias = teclat.next();
            	 exist = existeixJugador(alias);
              }
              System.out.println("Nom entrat");
              Jugador j = new Jugador(alias);

              System.out.println("Voleu modificar-lo a la base de dades?");
              System.out.println("0: Si 1: No");
              int ent = teclat.nextInt();
              if (ent==0) {

             	 esborrarjugador(nomJugador);
             	 afegirJugador(j);

              }

          }

     }



          public void modificarJugadorInterficie(String nomJ, String nounomJ, JFrame f) throws IOException {

        	  JOptionPane jop = new JOptionPane();
     	 		
          String nomJugador = nomJ;



          boolean exist = existeixJugador(nomJugador);
          if(exist == false){

         	 jop.showMessageDialog(f,
    	  	 		    "El Jugador no es troba a la base de dades!",
    	  	 		    "Error!",
    	  	 		    JOptionPane.ERROR_MESSAGE);  
         	 			return;
          }
          else{
               
              String alias = nounomJ;
              exist = existeixJugador(alias);
              if(exist) {
            	 System.out.println("Ja existeix una instancia a la base de dades amb el nom" + alias + "\n Entra un altre nom" ); 
            
            	 jop.showMessageDialog(f,
     	  	 		    "Ja existeix una instancia a la base de dades amb el nom " + alias,
     	  	 		    "Error!",
     	  	 		    JOptionPane.ERROR_MESSAGE);  
            	 		return;
              }
              Jugador j = new Jugador(alias);

              	 esborrarjugador(nomJugador);
              	 afegirJugador(j);
             	 jop.showMessageDialog(f,
     	  	 		    "Jugador Modificat Correctament",
     	  	 		    "Satisfactori!",
     	  	 		    JOptionPane.ERROR_MESSAGE);  
              }

          }

     

          
          
 public static void esborrarjugador(String nomp) throws IOException {

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

 }
