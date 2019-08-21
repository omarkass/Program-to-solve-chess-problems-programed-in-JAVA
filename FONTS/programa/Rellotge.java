package programa;

import java.util.Date;
public class Rellotge {

    //Atributs:
	private Date j1;
	private Date j2;
	private Date actual;
	private long sumaTemps1;
	private long sumaTemps2;

    //Constructora:
    public Rellotge() {
        sumaTemps1 = 0;
        sumaTemps2 = 0;
    }

    public void iniRellotgeJug1(){
        j1 = new Date();
    }

    public void iniRellotgeJug2(){
        j2 = new Date();
    }
    public long getT1 () {
    	return sumaTemps1 ;
    }
    
    public long getT2 () {
    	return sumaTemps2 ;
    }
    
    
    public void SumR1 (long T1) {
    	sumaTemps1 += T1 ;
    }
    public void SumR2 (long T2) {
    	sumaTemps2 += T2 ;
    }

    //Altres Funcions:
    public long restarTemps(Date antic, Date nou){
         long diff = nou.getTime() - antic.getTime();
         return diff;
    }

    public void canviTorn(int nouJug){
        if(nouJug==0){
            //Torn del jugador 1
            actual = new Date();
            sumaTemps2 += restarTemps(j2, actual);
            j2 = actual;
        }
        else if(nouJug==1){
            //Torn del jugador 2
            actual = new Date();
            sumaTemps1 += restarTemps(j1, actual);
            j1 = actual;
        }
        else System.out.println("Valor incorrecte");
    }

    public void imprimirRellotgeJ1(){
        long diffSeg = sumaTemps1 / 1000 % 60;
        System.out.println("Temps total en segons: " + diffSeg);
    }
    public float getRellotgeJ1(){
        long diffSeg = sumaTemps1 / 1000 % 60;
        return diffSeg;
		}
    
    public void imprimirRellotgeJ2(){
        long diffSeg = sumaTemps2 / 1000 % 60;
        System.out.println("Temps total en segons: " + diffSeg);
    }
}