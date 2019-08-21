package programa;

import peces.Peça;

public class Casella {
	//Atributs:
	private int fila;
	private int columna;
	private boolean ocupat;
	private Peça peça;

	//Constructores:
	public Casella() {
       fila = 0;
       columna = 0;
       ocupat = false;
       peça = null;
    }

	public void creacioCasella(int f, int c){
	      fila = f;
	      columna = c;
	      ocupat = false;
	      peça = null;
	 }

	//Consultores:
	public int getFila(){
		return fila;
	}

	public int getColumna(){
		return columna;
	}

	public boolean getOcupat(){
		return ocupat;
	}


	public Peça getPeça(){
		return peça;

	}

	public void setFila(int f){
		fila = f;
	}

	public void setColumna(int c){
		columna = c;
	}

    public void setPeça(char nompeça ,Peça p ){
		ocupat = true;
		peça = p ;
	}


	//Altres metodes:
	public boolean posicioCorrecta(int f, int c){
		if(f >= 0 && f < 8 && c >= 0 && c < 8) return true;
		else return false;
	}

	public void eliminarPeça () {
		ocupat = false;
		peça = null ;
	}

	public static Color getBlanc() {
		return Color.BLANC ;
	}

	public static Color getNegre() {
		return Color.NEGRE ;
	}
	public void copy (Casella c) {
		this.columna = c.getColumna() ;
		this.fila = c.getFila() ;
		this.ocupat = c.getOcupat() ;
	}
}
