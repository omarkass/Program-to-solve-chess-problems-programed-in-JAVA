package peces;

import java.util.List;

import programa.*;

public abstract class Peça {
	  Coordinada peçaPos;
	  Color peçaCol;
	  char Pchar ;

	public Peça() {
	  }

	public Peça(Coordinada peçaPos, Color peçaCol , char Pchar){
		this.peçaCol = peçaCol;
		this.peçaPos = peçaPos;
		this.Pchar = Pchar ;
	}

	public abstract List<Moviment> calcularMoviments(final Tauler tauler);

	public Color getPeçaCol() {
		return this.peçaCol ;
	}
	public char getPeçaChar () {
		return this.Pchar ;
	}

	public Coordinada getPeçaPos() {
		return this.peçaPos ;
	}

	public void setPeçaPos(int fila, int columna){
		peçaPos.setColumna(columna);
		peçaPos.setFila(fila);
	}

	public void setPeçaPos(Coordinada peçaPos) {
		 this.peçaPos = peçaPos ;
	}
	public void setPeçaCol(Color peçaCol) {
		 this.peçaCol = peçaCol ;
	}

	public List<Moviment> calcularMovimentsLegals(final Tauler tauler) {
		List<Moviment> moves = this.calcularMoviments(tauler);
		  for (int i = 0 ; i < moves.size() ; i++) {
			if (moves.get(i).MoveCauseJaque()) {
				moves.remove(i) ;
				i-- ;
			}
			}

		return moves ;
	}
}
