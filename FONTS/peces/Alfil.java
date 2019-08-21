package peces;
import java.util.ArrayList;
import java.util.List;

import programa.*;

public final class Alfil extends Peça{

	private final static int[][] POSICIONS_CANDIDATES = { {-1,-1} , {1,1} , {-1,1} , {1,-1}};

	public Alfil() {
		 peçaPos = new Coordinada();
		 peçaCol = Color.BLANC;
	}
	public Alfil(final Coordinada peçaPos, final Color peçaCol) {
		super(peçaPos, peçaCol,'b');
	}

	@Override
	public List<Moviment> calcularMoviments(Tauler tauler) {
		final List<Moviment> movimentsLegals = new ArrayList<>();
		for(final int[] currentCandidate: POSICIONS_CANDIDATES) {
			int x = this.peçaPos.getColumna() + currentCandidate[0] ;
			int y = this.peçaPos.getFila() + currentCandidate[1] ;
			  Coordinada pos = new Coordinada(y,x);
			boolean potseguir = true ;
			while ( Tauler.casellaValida(pos) &&  potseguir ) {
				if (tauler.PotMoure(this,pos) != 0  )
					movimentsLegals.add(new Moviment(tauler, this, pos));
				else potseguir = false ;
				if (tauler.PotMoure(this,pos) == 2 ) potseguir = false ;
					 x =x + currentCandidate[0] ;
					 y = y + currentCandidate[1] ;
					pos = new Coordinada(y,x);
			}
			}
		return movimentsLegals;
	}
}
