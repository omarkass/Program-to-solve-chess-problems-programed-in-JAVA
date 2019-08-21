package programa;

import java.util.*;

public class DriverProblema
{
	private static Scanner teclat = new Scanner(System.in);
	private static Problema p;

    public DriverProblema(){
    }

    public static void menu(){
        System.out.println("\n0) Sortir \n1) Constructora per defecte \n2) Constructora amb valors Nom, N, FEN inicial i dificultat \n3) Consultora Nom \n4) Consultora N \n5) Consultora FEN inicial \n6) Consultora Dificultat");
        System.out.println("7) Set dificultat\n8) Set nom\n9) Set FEN inicial\n10) Set N\n");
    }

    public static void testConstructorDefecte(){
        p = new Problema();
        System.out.println("Creacio d'un problema per defecte amb nom = " + p.getNom() + ", dificultat = " + p.getDif() + ", FEN inicial = " + p.getFENini() + " i N = " + p.getN() + "\n");
    }

    public static void testConstructorValors(){
        System.out.println("Amb quantes jugades s'ha de resoldre (N)?");
        int N = teclat.nextInt();
    	System.out.println("Quin nom voleu?");
        String nom = teclat.next();
        System.out.println("Quina dificultat se l'hi assigna al problema?");
        int dif = teclat.nextInt();
        System.out.println("Quin es l'estat inicial de la partida (FEN)?");
        String FENini = teclat.next();


        p = new Problema(nom, N, FENini, dif);
        System.out.println("Creacio d'un problema amb valors nom= "+ p.getNom() + "; N=" + p.getN() + "; FENini=" + p.getFENini() + "; Dificultat=" + p.getDif() + "\n");
    }

    public static void testgetNom(){
        System.out.println("El nom és: " + p.getNom());
    }

    public static void testgetN(){
        System.out.println("El temps és: " + p.getN());
    }

    public static void testgetFENini(){
        System.out.println("El temps és: " + p.getFENini());
    }

    public static void testgetDif(){
        System.out.println("El temps és: " + p.getDif());
    }


    public static void testsetNom(){
    	System.out.println("Quin nom voleu?");
    	p = new Problema();
    	String nom = teclat.next();
    	p.setnom(nom);
    	System.out.println("Nom: " + p.getNom() + "\n");
    }

    public static void testsetN(){
        System.out.println("Amb quantes jugades s'ha de resoldre (N)?");
    	p = new Problema();
    	int N = teclat.nextInt();
    	p.setN(N);
    	System.out.println("N: " + p.getN() + "\n");
    }

    public static void testsetFENini(){
        System.out.println("Quin es l'estat inicial de la partida (FEN)?");
    	p = new Problema();
    	String FENini = teclat.next();
    	p.setFEN(FENini);
    	System.out.println("FEN inicial: " + p.getFENini() + "\n");
    }

    public static void testsetDif(){
    	p = new Problema();
        System.out.println("Quina dificultat se l'hi assigna al problema?");

    	int dif = teclat.nextInt();
    	p.setdif(dif);
    	System.out.println("Dificultat: " + p.getDif() + "\n");
    }

    public static void main (String args[]){
        System.out.println("Driver Problema");
        System.out.println("Escull quin metode vols comprovar: ");
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
                testgetNom();
            }
            else if(opcio == 4){
            	testgetN();
            }
            else if(opcio == 5){
                testgetFENini();
            }
            else if(opcio == 6){
                testgetDif();
            }
            else if(opcio == 7){
                testsetNom();
            }
            else if(opcio == 8){
                testsetN();
            }
            else if(opcio == 9){
                testsetFENini();
            }
            else if(opcio == 10){
                testsetDif();
            }
            menu();
            opcio = teclat.nextInt();
        }

        System.out.println("Finalització del Driver Problema");
    }
}
