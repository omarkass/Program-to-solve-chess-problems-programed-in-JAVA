package programa;
import java.util.Scanner;

public class DriverCoordinada
{
	private static Scanner teclat = new Scanner(System.in);
	private static Coordinada c;
	private static int fila = 0;
	private static int columna = 0;


	public DriverCoordinada(){
    }

    public static void menu(){
        System.out.println("\n0) Sortir \n1) Constructora per defecte \n2) Constructora amb valors \n"
        		+ "3) Get Fila \n4) Get Columna \n5) Set Fila \n6) Set Columna");
    }

    public static void testConstructorDefecte(){
        c = new Coordinada();
        System.out.println("Creació d'una coordinada per defecte amb fila: " + c.getFila() + " i columna: " + c.getColumna());
    }

    public static void testConstructoraValors(){
        do{
            System.out.println("Quin valor de fila voleu?");
            fila = teclat.nextInt();
        }
        while(fila >= 8 || fila<0);

        int columna;
        do{
            System.out.println("Quin valor de columna voleu?");
            columna = teclat.nextInt();
        }
        while(columna >= 8 || columna<0);
        c = new Coordinada(fila, columna);
        System.out.println("Creació d'una coordinada amb fila: " + c.getFila() + " i columna: " + c.getColumna());

    }
    public static void testSetFila() {
        do{
            System.out.println("Quin valor de fila voleu?");
            fila = teclat.nextInt();
        }
        while(fila >= 8 || fila<0);
        c.setFila(fila);
        fila = c.getFila();
        System.out.println("El valor de la fila és: " + fila);
    }
    public static void testSetColumna() {
        do{
            System.out.println("Quin valor de columna voleu?");
            columna = teclat.nextInt();
        }
        while(columna >= 8 || columna<0);
        c.setColumna(columna);
        columna = c.getColumna();
        System.out.println("El valor de la columna és: " + columna);
    }
    public static void testGetFila() {
        fila = c.getFila();
        System.out.println("El valor de la fila és: " + fila);
    }
    public static void testGetColumna() {
        columna = c.getColumna();
        System.out.println("El valor de la columna és: " + columna);
    }


    public static void main (String args[]){
        System.out.println("Driver Coordinada");
        System.out.println("Elegeix quin mètode vols comprovar: ");
        menu();

        int opcio = teclat.nextInt();
        while(opcio != 0){
            if(opcio == 1){
                testConstructorDefecte();
            }
            else if(opcio == 2){
                testConstructoraValors();
            }
            else if(opcio == 3){
                testGetFila();
            }
            else if(opcio == 4){
                testGetColumna();
            }
            else if(opcio == 5) {
            	testSetFila();
            }
            else if(opcio == 6) {
            	testSetColumna();
            }
            menu();
            opcio = teclat.nextInt();
        }

        System.out.println("Finalització del Driver Coordinada");
    }
}
