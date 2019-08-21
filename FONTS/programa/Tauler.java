package programa;
import java.util.ArrayList;
import java.util.List;

import peces.*;


public class Tauler {
	//Atributs:
	private static int FILES = 8 ;
	private static int COLUMNES = 8;

	private Casella tauler[][] = new Casella[FILES][COLUMNES];
    private List<Peça> pecesNegres = new ArrayList<Peça>();
    private List<Peça> pecesBlanques = new ArrayList<Peça>();
	//Constructora:
    
    public Tauler () {    	
    }

	public void creacioTauler(){
	      //CREACIO DEL TAULER:
	      for(int i = 0; i < 8; i++){
	    	  for(int j = 0; j < 8; j++){
	    		  Casella c = new Casella();
	    		  c.creacioCasella(i,j);

	    		  tauler[i][j] = c;
	    	  }
	      }
	 }
	

	public Tauler(Tauler t) {
		this.creacioTauler() ;
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++) {
			this.tauler[i][j].copy(t.tauler[i][j]) ;
			Peça p = null ;
			if(t.getTauler()[i][j].getPeça() != null) {
			char ch = t.getTauler()[i][j].getPeça().getPeçaChar();
			switch (ch) {
		case 'r' :
			if (t.getTauler()[i][j].getPeça().getPeçaCol() == Color.NEGRE) {
			p = new Torre(new Coordinada(i,j),Color.NEGRE ) ;
            pecesNegres.add(p);
            this.getTauler()[i][j].setPeça(ch, p);
			}
			else {
			p = new Torre(new Coordinada(i,j),Color.BLANC ) ;
            pecesBlanques.add(p);
            this.getTauler()[i][j].setPeça(ch, p);
			}
			break ;
		case 'k' :
			if (t.getTauler()[i][j].getPeça().getPeçaCol() == Color.BLANC) {
			p = new Rei(new Coordinada(i,j),Color.BLANC ) ;
            pecesBlanques.add(p);
            this.getTauler()[i][j].setPeça(ch, p);
			}
			else {
			p = new Rei(new Coordinada(i,j),Color.NEGRE) ;
            pecesNegres.add(p);
            this.getTauler()[i][j].setPeça(ch, p);
			}
			break ;
		case 'q':
			if (t.getTauler()[i][j].getPeça().getPeçaCol() == Color.NEGRE) {
			p = new Reina(new Coordinada(i,j),Color.NEGRE ) ;
            pecesNegres.add(p);
            this.getTauler()[i][j].setPeça(ch, p);
			}
			else {
			p = new Reina(new Coordinada(i,j),Color.BLANC ) ;
            pecesBlanques.add(p);
            this.getTauler()[i][j].setPeça(ch, p);
			}
			break ;
		case  'n':
			if (t.getTauler()[i][j].getPeça().getPeçaCol() == Color.NEGRE) {
			p = new Cavall(new Coordinada(i,j),Color.NEGRE ) ;
            pecesNegres.add(p);
            this.getTauler()[i][j].setPeça(ch, p);
			}
			else {
			p = new Cavall(new Coordinada(i,j),Color.BLANC ) ;
            pecesBlanques.add(p);
            this.getTauler()[i][j].setPeça(ch, p);
			}
			break;
		case 'p' :
			if (t.getTauler()[i][j].getPeça().getPeçaCol() == Color.NEGRE) {
			p = new Peo(new Coordinada(i,j),Color.NEGRE ) ;
            pecesNegres.add(p);
            this.getTauler()[i][j].setPeça(ch, p);
			}
			else {
			p = new Peo(new Coordinada(i,j),Color.BLANC) ;
            pecesBlanques.add(p);
            this.getTauler()[i][j].setPeça(ch, p);
			}
			break ;
		case  'b':
			if (t.getTauler()[i][j].getPeça().getPeçaCol() == Color.NEGRE) {
			p = new Alfil(new Coordinada(i,j),Color.NEGRE ) ;
            pecesNegres.add(p);
            this.getTauler()[i][j].setPeça(ch, p);
			}
			else {
			p = new Alfil(new Coordinada(i,j),Color.BLANC ) ;
            pecesBlanques.add(p);
            this.getTauler()[i][j].setPeça(ch, p);
			}
			break ;
	}
			}	
			}
			}
	}
	
	public Casella[][] getTauler (){
		return tauler ;
	}
	//Altres metodes:
	public Casella getCasella(int numFila, int numColumna){
	      return tauler[numFila][numColumna];
	 }


	public void emplenarTaulerInici(){
	 	int coordX = 0;
		int coordY = 0;

		//BLANQUES:
		Peça p = new Torre(new Coordinada(coordX,coordY),Color.NEGRE ) ;
		tauler[coordX][coordY].setPeça('r',p); ++coordY;
		p = new Cavall(new Coordinada(coordX,coordY),Color.NEGRE ) ;
		tauler[coordX][coordY].setPeça('n' , p); ++coordY;
		p = new Alfil(new Coordinada(coordX,coordY),Color.NEGRE ) ;
		tauler[coordX][coordY].setPeça('b',p); ++coordY;
		p = new Reina(new Coordinada(coordX,coordY),Color.NEGRE ) ;
		tauler[coordX][coordY].setPeça('q',p); ++coordY;
		p = new Rei(new Coordinada(coordX,coordY),Color.NEGRE ) ;
		tauler[coordX][coordY].setPeça('k',p); ++coordY;
		p = new Alfil(new Coordinada(coordX,coordY),Color.NEGRE ) ;
		tauler[coordX][coordY].setPeça('b',p); ++coordY;
		p = new Cavall(new Coordinada(coordX,coordY),Color.NEGRE ) ;
		tauler[coordX][coordY].setPeça('n',p); ++coordY;
		p = new Torre(new Coordinada(coordX,coordY),Color.NEGRE ) ;
		tauler[coordX][coordY].setPeça('r',p); coordY = 0;
        ++coordX;
		while(coordY < 8){
			p = new Peo(new Coordinada(coordX,coordY),Color.NEGRE ) ;
			tauler[coordX][coordY].setPeça('p',p);
			++coordY;
		}

		//NEGRES:
		coordX = 6;
		coordY = 0;
		while(coordY < 8){
			p = new Peo(new Coordinada(coordX,coordY),Color.BLANC ) ;
			tauler[coordX][coordY].setPeça('P',p);
            ++coordY;
		}
		coordX = 7;
		coordY = 0;

		p = new Torre(new Coordinada(coordX,coordY),Color.BLANC );
		tauler[coordX][coordY].setPeça('R',p); ++coordY;
		p = new Cavall(new Coordinada(coordX,coordY),Color.BLANC );
		tauler[coordX][coordY].setPeça('N',p); ++coordY;
		p = new Alfil(new Coordinada(coordX,coordY),Color.BLANC );
		tauler[coordX][coordY].setPeça('B',p); ++coordY;
		p = new Reina(new Coordinada(coordX,coordY),Color.BLANC );
		tauler[coordX][coordY].setPeça('Q',p); ++coordY;
		p = new Rei(new Coordinada(coordX,coordY),Color.BLANC );
		tauler[coordX][coordY].setPeça('K',p); ++coordY;
		p = new Alfil(new Coordinada(coordX,coordY),Color.BLANC );
		tauler[coordX][coordY].setPeça('B',p); ++coordY;
		p = new Cavall(new Coordinada(coordX,coordY),Color.BLANC );
		tauler[coordX][coordY].setPeça('N',p); ++coordY;
		p = new Torre(new Coordinada(coordX,coordY),Color.BLANC );
		tauler[coordX][coordY].setPeça('R',p);
	}
 public List<Peça> getPecesBlanques(){
	 return pecesBlanques ;
 }
 public List<Peça> getPecesNegres(){
	 return pecesNegres ;
 }
 
	public String get_fen () {
		StringBuilder sb = new StringBuilder(); 
		for(int i = 0; i < 8; i++){
		int aux = 0 ;
			for(int j = 0; j < 8; j++){
				Peça p	= tauler[i][j].getPeça() ;
				if (p == null) aux++ ;
				else {
					if (aux > 0) sb.append(aux) ;
					aux = 0 ;
				char letra = p.getPeçaChar() ; 
				if (p.getPeçaCol() == Color.BLANC) letra = Character.toUpperCase(p.getPeçaChar()) ;
				sb.append(letra) ;
			}}
			if (aux > 0) sb.append(aux) ;
			sb.append('/') ;
		}
			return sb.toString() ;
	}
	
 
	public void emplenarTauler(char[] fen){
		char[][] aux = convertirFEN(fen);
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){

				Peça p = null ;
				if(aux[i][j] != '0') {
				switch (aux[i][j]) {
				case 'r' :
					p = new Torre(new Coordinada(i,j),Color.NEGRE ) ;
                    pecesNegres.add(p);
                    tauler[i][j].setPeça(aux[i][j],p);
                    break ;
				case  'R':
					p = new Torre(new Coordinada(i,j),Color.BLANC ) ;
                    pecesBlanques.add(p);
                    tauler[i][j].setPeça(aux[i][j],p);
					break ;
				case 'K' :
					p = new Rei(new Coordinada(i,j),Color.BLANC ) ;
                    pecesBlanques.add(p);
                    tauler[i][j].setPeça(aux[i][j],p);
					break ;
				case 'k':
					p = new Rei(new Coordinada(i,j),Color.NEGRE) ;
                    pecesNegres.add(p);
                    tauler[i][j].setPeça(aux[i][j],p);
					break ;
				case 'q':
					p = new Reina(new Coordinada(i,j),Color.NEGRE ) ;
                    pecesNegres.add(p);
                    tauler[i][j].setPeça(aux[i][j],p);
					break ;
				case 'Q' :
					p = new Reina(new Coordinada(i,j),Color.BLANC ) ;
                    pecesBlanques.add(p); tauler[i][j].setPeça(aux[i][j],p);
                    tauler[i][j].setPeça(aux[i][j],p);
					break ;
				case  'n':
					p = new Cavall(new Coordinada(i,j),Color.NEGRE ) ;
                    pecesNegres.add(p);
                    tauler[i][j].setPeça(aux[i][j],p);
					break ;
				case 'N' :
					p = new Cavall(new Coordinada(i,j),Color.BLANC ) ;
                    pecesBlanques.add(p);
                    tauler[i][j].setPeça(aux[i][j],p);
					break ;
				case 'p' :
					p = new Peo(new Coordinada(i,j),Color.NEGRE ) ;
                    pecesNegres.add(p);
                    tauler[i][j].setPeça(aux[i][j],p);
					break ;
				case'P':
					p = new Peo(new Coordinada(i,j),Color.BLANC) ;
                    pecesBlanques.add(p);
                    tauler[i][j].setPeça(aux[i][j],p);
					break ;
				case  'b':
					p = new Alfil(new Coordinada(i,j),Color.NEGRE ) ;
                    pecesNegres.add(p);
                    tauler[i][j].setPeça(aux[i][j],p);
					break ;
				case 'B' :
					p = new Alfil(new Coordinada(i,j),Color.BLANC ) ;
                    pecesBlanques.add(p);
                    tauler[i][j].setPeça(aux[i][j],p);
					break ;
				}
				
			}
		}
		}}

public void move (Peça p , Coordinada noupos) {
	Peça p1 = tauler[noupos.getFila()][noupos.getColumna()].getPeça() ;
	Coordinada pospeca = p.getPeçaPos() ;
	this.tauler[noupos.getFila()][noupos.getColumna()].setPeça(tauler[p.getPeçaPos().getFila()][p.getPeçaPos().getColumna()].getPeça().getPeçaChar(), p);
	if (p1 != null ) {
		if (p.getPeçaCol() == Color.BLANC) 
			pecesNegres.remove(p1) ;
		
		else 
			pecesBlanques.remove(p1) ;
	
	}
	tauler[pospeca.getFila()][pospeca.getColumna()].eliminarPeça() ;
		p.setPeçaPos(noupos);

	}


	
	public void imprimirTauler(){
		String representacio = "";
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				
			if(tauler[i][j].getPeça() == null) representacio = "-";
			
			else {
				char val = tauler[i][j].getPeça().getPeçaChar();
				if (tauler[i][j].getPeça().getPeçaCol() == Color.BLANC)
					val = Character.toUpperCase(val) ;
				if(tauler[i][j].getPeça() == null) representacio = "-";
				else if(val == 'P') representacio = "\u2659";
				else if(val == 'R') representacio = "\u2656";
				else if(val == 'B') representacio = "\u2657";
				else if(val == 'N')
					representacio = "\u2658";
				else if(val == 'K')   representacio = "\u2654";
				else if(val == 'Q') representacio = "\u2655";
				else if(val == 'p') representacio = "\u265f";
				else if(val == 'r') representacio = "\u265c";
				else if(val == 'b') representacio = "\u265d";
				else if(val == 'n') representacio = "\u265e";
				else if(val == 'k') representacio = "\u265a";
				else if(val == 'q')  representacio = "\u265b";
			}
				System.out.print(representacio);
			}
			System.out.println();
		}
	}

	public static char[][] convertirFEN (char[] fen){
		int count = 0 ;
		char[][] t = new char[8][8];

		for (int i = 0 ; i < 8 ; i++ ) {
			char [] aux = new char[] {'0','0','0','0','0','0','0','0'} ;
			for (int j = 0 ; j < 8 ; j++) {
				if (fen[count] > '0' && fen[count] < '9' ) {
					j += fen[count] -'0'-1 ;
				}
				else if (fen[count] == '/') {
					j -= 1;
				}
				else aux[j] = fen[count];
				count ++ ;
			}
			t[i] = aux;
		}
		return t;
	}

	static public Color blanc() {
		return Color.BLANC ;
	}
	
	static public Color negre() {
		return Color.NEGRE ;
	}
	
	public  Casella getCasella(Coordinada p) {
		return tauler [p.getFila()] [p.getColumna()] ;
	}

	public int PotMoure (Peça P ,Coordinada NouPos ) {
		boolean ocp = tauler[NouPos.getFila()][NouPos.getColumna()].getOcupat() ;
		if (!ocp) return 1 ;
		else if (P.getPeçaCol() != tauler[NouPos.getFila()][NouPos.getColumna()].getPeça().getPeçaCol()  )return 2 ;
		return 0 ;
	}

    public static boolean casellaValida(Coordinada posicioDestiCandidata) {
        return posicioDestiCandidata.getFila() >= 0 && posicioDestiCandidata.getFila() < FILES && posicioDestiCandidata.getColumna() >= 0 && posicioDestiCandidata.getColumna() < COLUMNES;
    }
    public boolean ReiMort(Color defensador) {
    	List <Peça> l = new ArrayList<Peça> () ;
    	if (defensador == Color.BLANC) l = this.pecesBlanques ;
    	else l = this.pecesNegres ;
    	for (Peça p : l) {
    		if (p.calcularMovimentsLegals(this).size()>0 ) return false ;
    	}
    	return true ;
    }

}
