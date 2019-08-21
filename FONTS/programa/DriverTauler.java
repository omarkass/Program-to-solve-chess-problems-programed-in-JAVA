package programa;
import java.util.*;

import peces.Peça;
/**
 * Write a description of class DriverTauler here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DriverTauler
{
    static Scanner teclat = new Scanner(System.in);
    static Tauler tauler;

    public DriverTauler(){}

    public static void menu(){
        System.out.print("\n0) Sortit \n1) Constructora \n2) Consultora casella \n3) Emplenar tauler inici \n4) Emplenar tauler amb FEN \n5) Get FEN \n");
    }

    public static  void testConstructor(){
        tauler = new Tauler();
        tauler.creacioTauler();
	System.out.println("Creació d'un tauler de 8x8 caselles.");
    }

    public static void testgetCasella(){
        int f;
        do{
            System.out.println("Quin valor de fila voleu comprovar?");
            f = teclat.nextInt();
        }
        while(f >= 8);

        int c;
        do{
            System.out.println("Quin valor de columna voleu comprovar?");
            c = teclat.nextInt();
        }
        while(c >= 8);

        Casella aux = tauler.getCasella(f,c);
        System.out.println("Retorn de Casella amb fila " + f + " i casella " + c);
        
        Peça p;
        if (aux.getOcupat()) {
        p = aux.getPeça(); 
        System.out.println(p.getPeçaChar());
        System.out.println(p.getPeçaCol());
        }
        else System.out.println("No hi ha peça a la casella seleccionada");
    }

    public static void testemplenarTaulerInici(){
        tauler.emplenarTaulerInici();
        tauler.imprimirTauler();
    }

    public static void testemplenarTauler(){
    	testConstructor() ;
    	String fen;
    	do {
    		System.out.println("Entra el FEN");
    		fen = teclat.next()+' '+teclat.next()+' '+teclat.next()+' '+teclat.next()+' '+teclat.next()+' '+teclat.next();
    	}while (!Partida.ComprovarFen(fen));

        tauler.emplenarTauler(fen.toCharArray());
        tauler.imprimirTauler();

    }

    public static void testmove(){
    	testConstructor() ;
        String s = "1N1b4/6nr/R5n1/2Ppk2r/K2pr1qR/4R3/2N1PQ2/B6B";
        tauler.emplenarTauler(s.toCharArray());
        tauler.imprimirTauler();
        System.out.println("Quin valor de columna voleu comprovar?");
        int x = teclat.nextInt();
        System.out.println("Quin valor de fila voleu comprovar?");
         int y = teclat.nextInt();
     //  System.out.print(tauler.getTauler()[0][1].getPiece().peçaPos.fila) ;
      Peça p1 = tauler.getTauler()[y][x].getPeça() ;
      System.out.println(p1.getPeçaChar()) ;
      System.out.println(p1.getPeçaPos().getColumna()) ;
      System.out.println(p1.getPeçaPos().getFila()) ;
      List<Moviment>move =  p1.calcularMovimentsLegals(tauler) ;
       for (int i = 0 ; i < move.size() ; i++)
  		System.out.printf("movment (%d ,%d)\n" ,move.get(i).getDestinacio().getFila() ,move.get(i).getDestinacio().getColumna());
       System.out.println("quin moviment voleu");
       y = teclat.nextInt();
       Coordinada nextPos = move.get(y).getDestinacio() ;
       tauler.move(p1, nextPos);
       tauler.imprimirTauler();  
    }

    public static void main (String args[]){
        System.out.println("Driver Tauler");
        System.out.println("Eligueix quin métode vols comprovar: ");
        menu();

        int opcio = teclat.nextInt();
        while(opcio != 0){
            if(opcio == 1){
                testConstructor();
            }
            else if(opcio == 2){
                testgetCasella();
            }
            else if(opcio == 3){
                testemplenarTaulerInici();
            }
            else if(opcio == 4){
                testemplenarTauler();
            }
            else if(opcio == 5){
                testgettauler();
            }
            else{
                System.out.println("Número incorrecte");
            }

            menu();
            opcio = teclat.nextInt();
        }

        System.out.println("Finalització del Driver Tauler");
    }
    static public void testReiMort () {
    	testConstructor() ;
        String s = "1N1b4/7r/R5n1/2PpkQ1r/K2p2qR/8/2N1PQ2/B6B";
        tauler.emplenarTauler(s.toCharArray());
        tauler.imprimirTauler();
        System.out.println("vols comprovar el estat del jugador blanc o negre");
        System.out.println("posa b o n");
        char c = teclat.next().charAt(0); 
        switch (c) {
        case 'b' :
        	System.out.println( tauler.ReiMort(Color.BLANC));
        	break;
        case 'n' :
        	System.out.println( tauler.ReiMort(Color.NEGRE));
        	break;
        default :
        	throw new ArithmeticException("nomes es pot escriure b o n");
        }
    }
    static public void testgettauler() {
    	testConstructor() ;
    	testemplenarTauler() ;
    	String s = tauler.get_fen() ;
    	System.out.print("El fen del tauler es : \n");
    	System.out.print(s);
    	
    }
}
