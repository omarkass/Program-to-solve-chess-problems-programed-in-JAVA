package peces;
import java.util.List;

import programa.*;

import java.util.ArrayList;

public class Cavall extends Peça{

	private final static int[][] POSICIONS_CANDIDATES = { {-1,-2}, {-2,-1}, {-2,1}, {-1,2}, {1,2}, {2,1}, {2,-1}, {1,-2} };

	public Cavall(Coordinada peçaPos, final Color peçaCol) {
		super(peçaPos, peçaCol,'n');
	}

	public Cavall() {
		 peçaPos = new Coordinada();
		 peçaCol = Color.BLANC;
	}

	@Override
	public List<Moviment> calcularMoviments(Tauler tauler) {
		final List<Moviment> movimentsLegals = new ArrayList<>();

		for(final int[] candidataActual: POSICIONS_CANDIDATES) {
			int x = this.peçaPos.getColumna() + candidataActual[0] ;
			int y = this.peçaPos.getFila() + candidataActual[1] ;
			 Coordinada pos = new Coordinada(y,x);
            if(Tauler.casellaValida(pos) ){
    				if(tauler.PotMoure(this,pos) != 0) {
    					movimentsLegals.add(new Moviment(tauler, this, pos));
    				}
    			}
            }

		return movimentsLegals;
	}
}
