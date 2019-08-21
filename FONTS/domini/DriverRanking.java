package domini;
import java.util.Scanner;

public class DriverRanking
{
    private static Scanner teclat = new Scanner(System.in);
    private static Ranking r;

    public DriverRanking(){
    }

    public static void menu(){
        System.out.println("\n0) Sortir \n1) Constructora per defecte \n2) Constructora amb valors \n"
        		+ "3) Set Nom \n4) Get Nom \n5) Afegir posicio \n6) Esborrar posicio \n"
        		+ "7) Consultar temps \n8) Guardar Ranking \n9) Carregar Ranking"
        		+ "\n10) Ordenar Ranking \n11) Imprimir Ranking");
    }

    public static void testConstructorDefecte(){
        r = new Ranking();
        System.out.println("Creació d'un ranking per defecte amb nom: " + r.getNomProblema());
    }

    public static void testConstructoraValors(){
        String problema;
        System.out.println("Quin nom voleu per al problema?");
        problema = teclat.next();

    	r = new Ranking(problema);
        System.out.println("Creació d'un ranking amb nom: " + r.getNomProblema());
    }
    public static void testSetNom() {
        String problema;
        System.out.println("Quin nom voleu per al problema?");
        problema = teclat.next();
        r.setNomProblema(problema);
        problema = r.getNomProblema();
        System.out.println("El nou nom del problema és: " + problema);
    }
    public static void testGetNom() {
        String problema;
        problema = r.getNomProblema();
        System.out.println("El nom del problema és: " + problema);
    }
    public static void testafegirPosicio(){
        String nom;
        System.out.println("Quin nom d'usuari voleu?");
        nom = teclat.next();

        float temps;
        do{
            System.out.println("Quin temps voleu?");
            temps = teclat.nextFloat();
        }
        while(temps <= 0.0);
        r.afegirPosicio(nom, temps);
        System.out.println("Posició afegida al ranking del problema: " + r.getNomProblema()
        + "\nUsuari: " + nom + " Temps: " + temps);
    }

    public static void testesborrarPosicio(){
        String nom;
        System.out.println("Quin nom voleu esborrar?");
        nom = teclat.next();

        r.esborrarPosicio(nom);

    }
    public static void testConsultarTemps() {
        String nom;
        Float temps;
        System.out.println("Per a quin usuari voleu consultar el temps?");
        nom = teclat.next();
        temps = r.consultarTemps(nom);
        if (temps!=0) System.out.println("Temps per a l'usuari: " + nom + " temps: " + temps + " en el problema: " + r.getNomProblema());
    }
    public static void testGuardarRanking() {
        r.guardarRanking();
        System.out.println("Ranking guardat a la base de dades");

    }
    public static void testCargarRanking() {
        r.cargarRanking();
        System.out.println("Ranking carregat de la base de dades");

    }
    public static void testOrdenarRanking() {
    	r.ordenarRanking();
        System.out.println("Ranking ordenat");

    }
    public static void testImprimirRanking() {
        r.imprimirRanking();
    }
    public static void main (String args[]){
        System.out.println("Driver Ranking");
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
                testSetNom();
            }
            else if(opcio == 4){
                testGetNom();
            }
            else if(opcio == 5) {
            	testafegirPosicio();
            }
            else if(opcio == 6) {
            	testesborrarPosicio();
            }
            else if(opcio == 7) {
            	testConsultarTemps();
            }
            else if(opcio == 8) {
            	testGuardarRanking();
            }
            else if(opcio == 9) {
            	testCargarRanking();
            }
            else if(opcio == 10) {
            	testOrdenarRanking();
            }
            else if(opcio == 11) {
            	testImprimirRanking();
            }
            menu();
            opcio = teclat.nextInt();
        }

        System.out.println("Finalització del Driver Ranking");
    }
}