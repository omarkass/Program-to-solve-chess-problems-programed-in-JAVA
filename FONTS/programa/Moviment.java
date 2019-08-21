package programa;
import peces.*;

import java.util.ArrayList;
import java.util.List;

public final class Moviment {

	private Tauler tauler;
	private Coordinada destinacio;
	private Peça peçaMoguda;

    public Moviment(final Tauler tauler, final Peça peçaMoguda, final Coordinada destinacio){
        this.tauler = new Tauler (tauler);
        this.destinacio = destinacio;
        Casella c = this.tauler.getCasella(peçaMoguda.getPeçaPos());
        this.peçaMoguda = c.getPeça() ;
	}
    
    
    public Moviment(final Tauler tauler){
        this.tauler = new Tauler (tauler);
        this.destinacio = null ;
        Casella c = null ;
        this.peçaMoguda =null ;
	}
	
    public Coordinada getDestinacio() {
		return this.destinacio;
	}
	
    public Tauler getTauler() {
		return this.tauler;
	}
	
    public Peça getPeçaMoguda() {
		return this.peçaMoguda;
	}
	
    public void setDestinacio(int fila, int columna){
		destinacio.setColumna(columna);
		destinacio.setFila(fila);
	}
	
    public void setPeçaMoguda(Peça p) {
		peçaMoguda = p;
	}
    
    public void setTauler(Tauler t) {
    	tauler = t;
    }

    public Peça TrobarElRei (List<Peça> l) {
    	for (int i = 0 ; i < l.size() ; i++) {
			if ( l.get(i).getPeçaChar() == 'k' ) {
				return l.get(i) ;
			}
    	}
    	return null ;
    }

	public  boolean MoveCauseJaque () {
		if (destinacio != null)
		tauler.move(peçaMoguda,destinacio);
		Color colorpeca = this.peçaMoguda.getPeçaCol() ;
		Peça rei = new Rei() ;
		List<Peça> enemics = new ArrayList <Peça>() ;

		if (colorpeca == Color.BLANC) {
		rei = TrobarElRei(tauler.getPecesBlanques()) ;
			enemics = tauler.getPecesNegres() ;
			}
		else {
			rei = TrobarElRei(tauler.getPecesNegres()) ;
			enemics = tauler.getPecesBlanques();
		}

		Coordinada posrei = rei.getPeçaPos() ;
		for( Peça penemics : enemics ) {
			List<Moviment>moves = penemics.calcularMoviments(tauler) ;
			for (Moviment m : moves ) {
				if (m.getDestinacio().getColumna()==posrei.getColumna() && m.getDestinacio().getFila()==posrei.getFila())
					{
					if ( penemics.getPeçaChar() !='p' || m.getDestinacio().getColumna()!= penemics.getPeçaPos().getColumna() )
					return true ;

					}
			}
		}
		return false ;
	}

}
