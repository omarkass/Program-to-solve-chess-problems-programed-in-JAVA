package programa;
import java.util.Scanner;

public class DriverJugador {
	
    private static Scanner teclat = new Scanner(System.in);
    private static Jugador jp = new Jugador();
    
    public DriverJugador(){
    }
    
    public static void menu(){
        System.out.println("\n0) Sortir \n1) Constructora per defecte \n2) Constructora amb Valors \n3) Get nom \n4) Set Nom\n");
    }
        
    public static void main (String args[]){       
        System.out.println("Driver Jugador");
        System.out.println("Elegeix quin mètode vols comprovar: ");
        menu();
        int opcio = teclat.nextInt();        
        while(opcio != 0){
            if(opcio == 1){
            	Jugador j = new Jugador();
            	System.out.println("Jugador creat amb valors per defecte (nom = Anonim)");
            }
            else if(opcio == 2){
            	System.out.println("Quin nom vols per al jugador?");
            	String nom = teclat.next();
                Jugador j = new Jugador(nom);
                jp = j;
                System.out.println("Jugador creat amb valors d'entrada");
            }
            else if(opcio == 3){
            	System.out.println("El nom del jugador es:");
            	System.out.println(jp.getNom());
            }
            else if(opcio == 4){
            	System.out.println("Elegeix el nou nom del Jugador");
            	String nounom = teclat.next();
            	jp.setNom(nounom);
            	System.out.println("Nom del jugador canviat");
            }
            
            menu();
            opcio = teclat.nextInt();
        }
        
        System.out.println("Finalització del Driver Jugador");
    }
}
