package peces;
import java.util.ArrayList;
import java.util.List;

import programa.*;

public class Rei extends Peça{

	public Rei(Coordinada peçaPos, Color peçaCol) {
		super(peçaPos, peçaCol,'k');
	}

	public Rei() {
		 peçaPos = new Coordinada();
		 peçaCol = Color.BLANC;
		 }

	private final static int[][] POSICIONS_CANDIDATES = { {0,-1}, {-1,0}, {1,0} , {0,1}, {-1,-1}, {1,1}, {1,-1}, {-1,1}};

	@Override
	public List<Moviment> calcularMoviments(Tauler tauler) {
		final List<Moviment> movimentsLegals = new ArrayList<>();

		for(final int[] candidataActual: POSICIONS_CANDIDATES) {
			int x = this.peçaPos.getColumna() + candidataActual[0] ;
			int y = this.peçaPos.getFila() + candidataActual[1] ;
			 Coordinada pos = new Coordinada(y,x);
            if(Tauler.casellaValida(pos)){
    				if(tauler.PotMoure(this,pos) != 0) {
    					movimentsLegals.add(new Moviment(tauler, this, pos));
    				}
    			}
            }

		return movimentsLegals;
	}
}
