package programa;

public class Coordinada {

	private int fila;
	private int columna;


   public Coordinada() {
	   fila = 0;
	   columna = 0;
   }
  public Coordinada(int fila, int columna) {
	  this.fila = fila;
	  this.columna = columna;
	  }

	public int getFila(){
		return fila;
	}

	public int getColumna(){
		return columna;
	}

	public void setFila(int f){
		fila = f;
	}
	public void setColumna(int c){
		columna = c;
	}
	public String coordenadatolletranum(Coordinada pospeca){ //Coordenada a lletra i numero del tauler
		String[] Columna= new String[] { "a", "b", "c", "d", "e", "f", "g", "h" };
		String[] Fila = new String[] { "8", "7", "6", "5", "4", "3", "2", "1" };
		int f = pospeca.getFila();
		int c = pospeca.getColumna();
		String ret = Columna[c].toString() + Fila[f].toString();
	    return ret;
	 }

	public static Coordinada lletranumtocoordenada(String lletranum){ //lletra i numero del tauler a coordenada
		String Fila = new String ("abcdefgh");
		int[] Columna = new int[] { 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		char lletra = lletranum.charAt(0);
		char num = lletranum.charAt(1);
		Coordinada nova = new Coordinada();
		int index=Character.getNumericValue(num);

		nova.setFila(Fila.indexOf(lletra));
		nova.setColumna(Columna[index]);

		return nova;
	 }
}
