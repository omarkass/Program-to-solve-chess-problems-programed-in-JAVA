package peces;

import java.util.ArrayList;
import java.util.List;

import programa.*;

public class Peo extends  Peça {

	public Peo(Coordinada peçaPos, Color peçaCol) {
		super(peçaPos, peçaCol,'p');
	}

	public Peo() {
		 peçaPos = new Coordinada();
		 peçaCol = Color.BLANC;
		 }
	@Override
	public List<Moviment> calcularMoviments(final Tauler tauler) {
		Coordinada pos ;
		final List<Moviment> legalMoves = new ArrayList<>();
		int mouY = 1 ;
		if (this.peçaCol == Color.BLANC) mouY = mouY * -1 ;
			int x = this.peçaPos.getColumna() ;
			int y = this.peçaPos.getFila() + mouY ;
			pos = new Coordinada(y,x);
			if (Tauler.casellaValida(pos) ) {
				if(!tauler.getCasella(pos).getOcupat()) {
					legalMoves.add(new Moviment(tauler, this, pos));
					x = this.peçaPos.getColumna()  ;
					 y = this.peçaPos.getFila() + 2 ;
					 pos = new Coordinada(y,x);
					 if (Tauler.casellaValida(pos) ) {
					if (this.peçaCol == Color.NEGRE && this.getPeçaPos().getFila() == 1 && !tauler.getCasella(pos).getOcupat() )
						legalMoves.add(new Moviment(tauler, this, pos)) ;
					 }
					x = this.peçaPos.getColumna()  ;
					y = this.peçaPos.getFila() - 2 ;
					pos = new Coordinada(y,x);
					if (Tauler.casellaValida(pos) ) {
					if (this.peçaCol == Color.BLANC && this.getPeçaPos().getFila() == 6 && !tauler.getCasella(pos).getOcupat()  )
							legalMoves.add(new Moviment(tauler, this, pos)) ;
					}
				}
			}
			 x = this.peçaPos.getColumna() + 1 ;
			 y = this.peçaPos.getFila() + mouY ;
			 pos = new Coordinada(y,x);
			if (Tauler.casellaValida(pos) ) {
				if (tauler.PotMoure(this,pos) == 2)
					legalMoves.add(new Moviment(tauler, this, pos));
			}
			 x = this.peçaPos.getColumna() - 1 ;
			 y = this.peçaPos.getFila() + mouY ;
			 pos = new Coordinada(y,x);
			if (Tauler.casellaValida(pos) ) {
				if (tauler.PotMoure(this,pos) == 2 )
					legalMoves.add(new Moviment(tauler, this, pos)) ;
			}

		return legalMoves;
	}
}
