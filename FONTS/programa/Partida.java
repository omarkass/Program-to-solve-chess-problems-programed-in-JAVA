package programa;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import peces.Peça;

/**
 * Aquesta Classe es la classe que presenta la partida
 * @author omar
 * 
 */
public class Partida {

	private static Tauler tau ;

	/**
	 * @param s el fen del taule
	 * aquest metode cambia el tauler de la partida
	 */
	public static void modificar_taule (String s) {
		Tauler t = new Tauler();
		t.creacioTauler();
		t.emplenarTauler(s.toCharArray());
		tau = t ;
	}

	/**
	 * @return el tauler de la partida 
	 */
	public static Tauler GetTauler () {
		return tau ;
	}

	/**
	 * comprova si el fen que esta be o no
	 * @param  el fen que es vol provar
	 * @return returna si el fen es acceptable un true i sino false 
	 */
	public static boolean ComprovarFen (String fen){
		String[] partida;
		partida = fen.split("/");
		int nreisb=0;
		int nreinesb=0;
		int nalfilsb=0;
		int npeonsb=0;
		int ntorresb=0;
		int ncavallsb=0;


		int nreisn=0;
		int nreinesn=0;
		int nalfilsn=0;
		int npeonsn=0;
		int ntorresn=0;
		int ncavallsn=0;


		if (partida.length < 8) {System.out.println("Format del FEN incorrecte: Files menors de 8. Torna a entrar el FEN");return false;}
		else if (partida.length > 8) {System.out.println("Format del FEN incorrecte Files Majors a 8. Torna a entrar el FEN");return false;}

		String[] lastsplit;
		lastsplit = partida[7].split(" ");
		if (lastsplit.length!=6) {
			System.out.println("Format Incorrecte. Torna a entrar el FEN");
			return false;
		}

		int countdigit=0;
		int countlletra=0;
		boolean numbef = false;

		for (int i=0; i<partida.length-1; ++i) {
			countdigit=0;
			countlletra=0;
			numbef=false;
			for (int j=0; j<partida[i].length(); ++j) {
					if (Character.isDigit(partida[i].charAt(j)) && !numbef) { //retorna true si es digit
						countdigit+=Character.getNumericValue(partida[i].charAt(j));
						numbef=true;
					}
					else if (partida[i].charAt(j)=='B') {
						nalfilsb++;
						countlletra++;
						numbef=false;
					}
					else if (partida[i].charAt(j)=='R') {
						ntorresb++;
						countlletra++;
						numbef=false;
					}
					else if (partida[i].charAt(j)=='N') {
						ncavallsb++;
						countlletra++;
						numbef=false;
					}
					else if (partida[i].charAt(j)=='K') {
						nreisb++;
						countlletra++;
						numbef=false;
					}
					else if (partida[i].charAt(j)=='P') {
						npeonsb++;
						countlletra++;
						numbef=false;
					}
					else if (partida[i].charAt(j)=='Q') {
						nreinesb++;
						countlletra++;
						numbef=false;
					}
					else if (partida[i].charAt(j)=='b') {
						nalfilsn++;
						countlletra++;
						numbef=false;
					}
					else if (partida[i].charAt(j)=='r') {
						ntorresn++;
						countlletra++;
						numbef=false;
					}
					else if (partida[i].charAt(j)=='n') {
						ncavallsn++;
						countlletra++;
						numbef=false;
					}
					else if (partida[i].charAt(j)=='k') {
						nreisn++;
						countlletra++;
						numbef=false;
					}
					else if (partida[i].charAt(j)=='p') {
						npeonsn++;
						countlletra++;
						numbef=false;
					}
					else if (partida[i].charAt(j)=='q') {
						nreinesn++;
						countlletra++;
						numbef=false;
					}
					else {System.out.println("Format Incorrecte. Torna a entrar el FEN");return false;}
				}
				if (countlletra+countdigit!=8) {System.out.println("Error en la fila " + (i+1) + ". S'ha entrat un nombre incorrecte de caselles. Torna a entrar el FEN");return false;}
			}

			numbef=false;



			for (int i=0; i<lastsplit.length; ++i) {
				countdigit=0;
				countlletra=0;
				numbef=false;
				for (int j=0; j<lastsplit[i].length(); ++j) {
					if (i==0) {
						if (Character.isDigit(lastsplit[i].charAt(j)) && !numbef) { //retorna true si es digit
							countdigit+=Character.getNumericValue(lastsplit[i].charAt(j));
							numbef=true;
						}
						else if (lastsplit[i].charAt(j)=='B') {
							nalfilsb++;
							countlletra++;
							numbef=false;
						}
						else if (lastsplit[i].charAt(j)=='R') {
							ntorresb++;
							countlletra++;
							numbef=false;
						}
						else if (lastsplit[i].charAt(j)=='N') {
							ncavallsb++;
							countlletra++;
							numbef=false;
						}
						else if (lastsplit[i].charAt(j)=='K') {
							nreisb++;
							countlletra++;
							numbef=false;
						}
						else if (lastsplit[i].charAt(j)=='P') {
							npeonsb++;
							countlletra++;
							numbef=false;
						}
						else if (lastsplit[i].charAt(j)=='Q') {
							nreinesb++;
							countlletra++;
							numbef=false;
						}
						else if (lastsplit[i].charAt(j)=='b') {
							nalfilsn++;
							countlletra++;
							numbef=false;
						}
						else if (lastsplit[i].charAt(j)=='r') {
							ntorresn++;
							countlletra++;
							numbef=false;
						}
						else if (lastsplit[i].charAt(j)=='n') {
							ncavallsn++;
							countlletra++;
							numbef=false;
						}
						else if (lastsplit[i].charAt(j)=='k') {
							nreisn++;
							countlletra++;
							numbef=false;
						}
						else if (lastsplit[i].charAt(j)=='p') {
							npeonsn++;
							countlletra++;
							numbef=false;
						}
						else if (lastsplit[i].charAt(j)=='q') {
							nreinesn++;
							countlletra++;
							numbef=false;
						}
						else {System.out.println("Format Incorrecte. Torna a entrar el FEN");return false;}
					}
					else if (i==1) {
						if (lastsplit[i].charAt(j)!='w' && lastsplit[i].charAt(j)!='b' ||  lastsplit[i].length()!=1) {System.out.println("Format Incorrecte: Color al que l'hi toca moure incorrecte. Torna a entrar el FEN");return false;}
					}
					else if (i==2) {
						if (lastsplit[i].charAt(j)!='-' ||  lastsplit[i].length()!=1) {System.out.println("Format Incorrecte. Torna a entrar el FEN");return false;}
					}
					else if (i==3) {
						if (lastsplit[i].charAt(j)!='-' ||  lastsplit[i].length()!=1) {System.out.println("Format Incorrecte. Torna a entrar el FEN");return false;}
					}
					else if (i==4) {
						if (lastsplit[i].charAt(j)!='0' ||  lastsplit[i].length()!=1) {System.out.println("Format Incorrecte. Torna a entrar el FEN");return false;}
					}
					else if (i==5) {
						if (lastsplit[i].charAt(j)!='1' ||  lastsplit[i].length()!=1) {System.out.println("Format Incorrecte. Torna a entrar el FEN");return false;}
					}

				}
				if (i==0 && countlletra+countdigit!=8) {System.out.println("Error en la fila " + (i+1) + ". S'ha entrat un nombre incorrecte de caselles. Torna a entrar el FEN");return false;}
			}

			if (nreisb>1) {System.out.println("Blanques no poden jugar amb més d'un rei. Torna a entrar el FEN");return false;}
			else if (nreisb<1) {System.out.println("Blanques no poden jugar amb menys d'un rei. Torna a entrar el FEN");return false;}

			if (nreisn>1) {System.out.println("Negres no poden jugar amb més d'un rei. Torna a entrar el FEN");return false;}
			else if (nreisn<1) {System.out.println("Negres no poden jugar amb menys d'un rei. Torna a entrar el FEN");return false;}

			if (nreinesb>1) {System.out.println("Blanques no poden jugar amb més d'una reina. Torna a entrar el FEN");return false;}
			else if (nreinesb<0) {System.out.println("Blanques nombre de reines format incorrecte. Torna a entrar el FEN");return false;} //Aquest cas no existeix

			if (nreinesn>1) {System.out.println("Negres no poden jugar amb més d'una reina. Torna a entrar el FEN");return false;}
			else if (nreinesn<0) {System.out.println("Negres nombre de reines format incorrecte. Torna a entrar el FEN");return false;} //Aquest cas no existeix

			if (nalfilsb>2) {System.out.println("Blanques no poden jugar amb més de dos alfils. Torna a entrar el FEN");return false;}
			else if (nalfilsb<0) {System.out.println("Blanques nombre d'alfils format incorrecte. Torna a entrar el FEN");return false;} //Aquest cas no existeix

			if (nalfilsn>2) {System.out.println("Negres no poden jugar amb més de dos alfils. Torna a entrar el FEN");return false;}
			else if (nalfilsn<0) {System.out.println("Negres nombre d'alfils format incorrecte. Torna a entrar el FEN");return false;} //Aquest cas no existeix

			if (npeonsb>8) {System.out.println("Blanques no poden jugar amb més de vuit peons. Torna a entrar el FEN");return false;}
			else if (npeonsb<0) {System.out.println("Blanques nombre de peons format incorrecte. Torna a entrar el FEN");return false;} //Aquest cas no existeix

			if (npeonsn>8) {System.out.println("Negres no poden jugar amb més de vuit peons. Torna a entrar el FEN");return false;}
			else if (npeonsn<0) {System.out.println("Negres nombre de peons format incorrecte. Torna a entrar el FEN");return false;} //Aquest cas no existeix

			if (ntorresb>2) {System.out.println("Blanques no poden jugar amb més de dues torres. Torna a entrar el FEN");return false;}
			else if (ntorresb<0) {System.out.println("Blanques nombre de torres format incorrecte. Torna a entrar el FEN");return false;} //Aquest cas no existeix

			if (ntorresn>2) {System.out.println("Negres no poden jugar amb més de dues torres. Torna a entrar el FEN");return false;}
			else if (ntorresn<0) {System.out.println("Negres nombre de torres format incorrecte. Torna a entrar el FEN");return false;} //Aquest cas no existeix

			if (ncavallsb>2) {System.out.println("Blanques no poden jugar amb més de dos cavalls. Torna a entrar el FEN");return false;}
			else if (ncavallsb<0) {System.out.println("Blanques nombre de cavalls format incorrecte. Torna a entrar el FEN");return false;} //Aquest cas no existeix

			if (ncavallsn>2) {System.out.println("Negres no poden jugar amb més de dos cavalls. Torna a entrar el FEN");return false;}
			else if (ncavallsn<0) {System.out.println("Negres nombre de cavalls format incorrecte. Torna a entrar el FEN");return false;} //Aquest cas no existeix

			return true;
	}

	/**
	 * calcular l'algorithme en cas que la maquina esta atacan i el jugador esta defensant 
	 * @param mate es el nombre de mate
	 * @param tauler es el tauler sobre qual vol juga
	 * @param defens quin color defensa
	 * @return true si la maquina ataqui i guanya
	 */
	public static boolean calcular_algorithme_atac (int mate , Tauler tauler , final Color defens  ) {
		boolean ret = false ;
		for (int i = 0 ; i < (mate*2)-1 ; i++) {
			List <Moviment> sol = new ArrayList<Moviment> () ;
			if (i % 2 == 0) {
				  System.out.println() ;
					System.out.println("Torn del jugador maquina: ") ;
				ret = calcular_algorithme ( mate - i/2 , 0 ,  tauler , true ,defens , sol , new int[2]  ) ;
				if (!ret) return false ;
				tauler = sol.get(sol.size() - 1).getTauler() ;
			  tauler.imprimirTauler();
			  System.out.println() ;

			}
			else {
				  Scanner teclat = new Scanner(System.in);
					System.out.println("Torn del jugador huma: ") ;
					int y;
					int x;
			        do{
			        	if (tauler.ReiMort(defens)) return true ;
						System.out.println("Introduir la fila de la peça a moure (0,7)") ;
						y = teclat.nextInt() ;
					  System.out.println("Introduir la columna de la peça a moure (0,7)") ;
					  x = teclat.nextInt();
			          if(tauler.getTauler()[y][x].getPeça() == null || tauler.getTauler()[y][x].getPeça().getPeçaCol() != defens || tauler.getTauler()[y][x].getPeça().calcularMovimentsLegals(tauler).size() == 0) System.out.println("Peça incorrecta. Introdueix una opció vàlida.");
			        }
			        while(tauler.getTauler()[y][x].getPeça() == null || tauler.getTauler()[y][x].getPeça().getPeçaCol() != defens || tauler.getTauler()[y][x].getPeça().calcularMovimentsLegals(tauler).size() == 0);
				Peça p1 = tauler.getTauler()[y][x].getPeça() ;
				 List<Moviment>move =  p1.calcularMovimentsLegals(tauler) ;
				 int n = 0;
			       for (Moviment m : move){
			  		System.out.printf("Moviment " + n + ": (%d ,%d)\n" ,m.getDestinacio().getFila() ,m.getDestinacio().getColumna());
			       ++n;
			       }
			       System.out.println("Quin moviment voleu (contant desde 0)");
			       y = teclat.nextInt();
			       Coordinada nextPos = move.get(y).getDestinacio() ;
			       tauler.move(p1, nextPos);
				   System.out.println() ;
			       tauler.imprimirTauler();

			}
		}

		return ret ;
	}



	/**
	 * calcular l'algorithme en cas que la maquina esta atacan i el jugador esta defensant 
	 * @param mate es el nombre de mate
	 * @param tauler es el tauler sobre qual vol juga
	 * @param defens quin color defensa
	 * @return true si la el jugador  ataqui i no pugui guanya 
	 */
	public static boolean calcular_algorithme_defens (int mate , Tauler tauler , final Color defens  ) {
		boolean ret = false ;
		for (int i = 0 ; i < (mate*2)-1 ; i++) {
;
			List <Moviment> sol = new ArrayList<Moviment> () ;
			if (i % 2 != 0) {
				  System.out.println("Torn del jugador maquina: ") ;
				  System.out.println();
			ret = calcular_algorithme ( mate - i/2 , 0 ,  tauler , false ,defens , sol , new int[2]  ) ;
			  tauler = sol.get(sol.size() - 1).getTauler() ;

			  tauler.imprimirTauler();
			}
			else {
				  Scanner teclat = new Scanner(System.in);
					System.out.println("Torn del jugador humà: ") ;
					int x;
					int y;
					boolean moves = true ;
					do{
						moves = true ;
						System.out.println("Introduir la fila de la peça a moure (0,7)") ;
						y = teclat.nextInt() ;
					  System.out.println("Introduir la columna de la peça a moure (0,7)") ;
					  x = teclat.nextInt();
			          if(tauler.getTauler()[y][x].getPeça() == null || tauler.getTauler()[y][x].getPeça().getPeçaCol() == defens) System.out.println("Peça incorrecta. Introdueix una opció vàlida.");
			          else if ( tauler.getTauler()[y][x].getPeça().calcularMovimentsLegals(tauler).size() == 0  )  {
			        	  System.out.println("Peça incorrecta. Introdueix una opció vàlida.");
			        	  moves = false ;
			          }
			        }
			        while(tauler.getTauler()[y][x].getPeça() == null || tauler.getTauler()[y][x].getPeça().getPeçaCol() == defens || moves == false);

				Peça p1 = tauler.getTauler()[y][x].getPeça() ;
				 List<Moviment>move =  p1.calcularMovimentsLegals(tauler) ;
				 int n = 0;
			       for (Moviment m : move) {

			  		System.out.printf("Moviment "+ n +": (%d ,%d)\n" ,m.getDestinacio().getFila() ,m.getDestinacio().getColumna());
			  		++n;
			       }
			       System.out.println("Quin moviment voleu? (contant desde 0)");
			       y = teclat.nextInt();
			       Coordinada nextPos = move.get(y).getDestinacio() ;
			       tauler.move(p1, nextPos);
			       tauler.imprimirTauler();

			   //    teclat.close();
			}
		}
		ret = tauler.ReiMort(defens);
		return ret ;
	}


		public static boolean calcular_algorithme (int mate , int n ,final Tauler tauler , boolean atacador ,final Color defens ,List<Moviment> solucionG, int [] stastatistiques) {
		if (n == mate) {
			if( tauler.ReiMort(defens)) {
				stastatistiques[0] = 1 ;
				return true ;
			}
			else stastatistiques[1] = 1 ;
			return false ;
		}


		else if (atacador ) {

			boolean mate_segur = false ;
			List<Peça> l = new ArrayList<Peça>() ;
			if (defens == Color.BLANC) l = tauler.getPecesNegres() ;
			else l = tauler.getPecesBlanques() ;
			  Rellotge r = new Rellotge() ;
		        r.iniRellotgeJug1();
			for (Peça p : l) {
				List<Moviment> moves = p.calcularMovimentsLegals( new Tauler(tauler)) ;
				for (Moviment m : moves) {
					Tauler taulersecundari = new Tauler(tauler) ;

					 Peça p1 = taulersecundari.getCasella(p.getPeçaPos()).getPeça() ;
					taulersecundari.move(p1, m.getDestinacio());


					int [] stastatistiquesP = new int [2] ;
					List<Moviment>solucioP = new ArrayList<Moviment>() ;
					if (calcular_algorithme (mate , n + 1 , new Tauler(taulersecundari) , false , defens ,solucioP ,stastatistiquesP)) {
					mate_segur = true ;
					solucionG.removeAll(solucionG) ;
					for ( Moviment m1 : solucioP)
						solucionG.add(m1) ;
					solucionG.add(new Moviment (taulersecundari, p1, m.getDestinacio()) ) ;
					}
					stastatistiques[0] += stastatistiquesP[0] ;
					stastatistiques[1] += stastatistiquesP[1] ;
					r.canviTorn(1);
					 if (r.getRellotgeJ1() > 50) return mate_segur;
			}
				}
			return 	mate_segur ;
		}



		else if (!atacador) {
			Tauler t = null ;
			Rellotge r = new Rellotge() ;
	        r.iniRellotgeJug1();
			List<Peça> l = new ArrayList<Peça>() ;
			if (defens == Color.NEGRE) l = tauler.getPecesNegres() ;
			else l = tauler.getPecesBlanques() ;
			for (Peça p : l) {
				List<Moviment> moves = p.calcularMovimentsLegals(tauler) ;
				for (Moviment m : moves) {
					Tauler taulersecundari = new Tauler(tauler) ;
					 Peça p1 = taulersecundari.getCasella(p.getPeçaPos()).getPeça() ;
					taulersecundari.move(p1, m.getDestinacio());

					List<Moviment> solucioP = new ArrayList<Moviment> () ;
					int [] stastatistiquesP = new int [2] ;
					if (!calcular_algorithme (mate , n  , new Tauler(taulersecundari) , true ,defens  ,solucioP ,stastatistiquesP)) {
						solucionG.add(new Moviment (taulersecundari, p1, m.getDestinacio()) ) ;
						return false;
					}
					else {
						if (t == null) {
							stastatistiques = stastatistiquesP ;
							t = solucioP.get(0).getTauler() ;
							solucionG.removeAll(solucionG) ;
							for ( Moviment m1 : solucioP)
								solucionG.add(m1) ;
							solucionG.add(new Moviment (taulersecundari, p1, m.getDestinacio()) ) ;
						}
					else if (stastatistiques[1]/(stastatistiques[0]+1) >  stastatistiquesP[1]/(stastatistiquesP[0]+1)) {
						Tauler t2 = solucioP.get(solucioP.size()-1).getTauler() ;
						stastatistiques = stastatistiquesP ;
						t = t2 ;
							solucionG.removeAll(solucionG) ;
								for ( Moviment m1 : solucioP)
									solucionG.add(m1) ;
								solucionG.add(new Moviment (taulersecundari, p1, m.getDestinacio()) ) ;

					}
					}
				}
				r.canviTorn(1);
				 if (r.getRellotgeJ1() > 50)
					 {
					 return false;
					 }

			}
			return true ;
		}
		return false ;
	}

		public static List<Moviment> Get_Move_Atacs (Tauler tauler , Color defens) {
			 List<Peça> atacadors = new ArrayList<Peça>() ;
			 List<Peça> defensadors = new ArrayList<Peça>() ;
			 List<Moviment> atacs = new ArrayList<Moviment>() ;
			if (defens == Color.BLANC) {
				atacadors = tauler.getPecesNegres() ;
				defensadors = tauler.getPecesBlanques() ;
			}
			else {
				atacadors = tauler.getPecesBlanques() ;
				defensadors = tauler.getPecesNegres() ;
			}
		Moviment move = new Moviment(tauler) ;
		Peça r = move.TrobarElRei(defensadors) ;
		Coordinada ReiPos = r.getPeçaPos() ;
		for (Peça p : atacadors) {
			List<Moviment> moves = p.calcularMovimentsLegals(tauler) ;
			for (Moviment m : moves) {
				Tauler taulersecundari = new Tauler(tauler) ;
				 Peça p1 = taulersecundari.getCasella(p.getPeçaPos()).getPeça() ;
				taulersecundari.move(p1, m.getDestinacio());
				Moviment m1 = new Moviment(taulersecundari,r,null) ;
				
				if (m1.MoveCauseJaque()) {
					m.setPeçaMoguda(p);
					atacs.add(m) ;
				}
			}
		}
		return atacs ;
		}
		public static boolean calcular_algorithme_avancat (int mate , int n ,final Tauler tauler , boolean atacador ,final Color defens ,List<Moviment> solucionG, int [] stastatistiques) {
			if (n == mate) {
				if( tauler.ReiMort(defens)) {
					stastatistiques[0] = 1 ;
					return true ;
				}
				else stastatistiques[1] = 1 ;
				return false ;
			}
			else if (atacador ) {
				boolean mate_segur = false ;
				List<Peça> l = new ArrayList<Peça>() ;
				if (defens == Color.BLANC) l = tauler.getPecesNegres() ;
				else l = tauler.getPecesBlanques() ;
				  Rellotge r = new Rellotge() ;
			        r.iniRellotgeJug1();
					List<Moviment> moves = Get_Move_Atacs ( tauler ,  defens) ;
					for (Moviment m : moves) {
						Tauler taulersecundari = new Tauler(tauler) ;
						 Peça p1 = taulersecundari.getCasella(m.getPeçaMoguda().getPeçaPos()).getPeça() ;
						taulersecundari.move(p1, m.getDestinacio());
						int [] stastatistiquesP = new int [2] ;
						List<Moviment>solucioP = new ArrayList<Moviment>() ;
						if (calcular_algorithme_avancat (mate , n + 1 , new Tauler(taulersecundari) , false , defens ,solucioP ,stastatistiquesP)) {
						mate_segur = true ;
						solucionG.removeAll(solucionG) ;
						for ( Moviment m1 : solucioP)
							solucionG.add(m1) ;
						solucionG.add(new Moviment (taulersecundari, p1, m.getDestinacio()) ) ;
						}
						stastatistiques[0] += stastatistiquesP[0] ;
						stastatistiques[1] += stastatistiquesP[1] ;
						r.canviTorn(1);
						 if (r.getRellotgeJ1() > 30) return mate_segur;
					}
				return 	mate_segur ;
			}



			else if (!atacador) {
				Tauler t = null ;
				Rellotge r = new Rellotge() ;
		        r.iniRellotgeJug1();
				List<Peça> l = new ArrayList<Peça>() ;
				if (defens == Color.NEGRE) l = tauler.getPecesNegres() ;
				else l = tauler.getPecesBlanques() ;
				for (Peça p : l) {
					List<Moviment> moves = p.calcularMovimentsLegals(tauler) ;
					for (Moviment m : moves) {

						Tauler taulersecundari = new Tauler(tauler) ;
						 Peça p1 = taulersecundari.getCasella(p.getPeçaPos()).getPeça() ;
						taulersecundari.move(p1, m.getDestinacio());

						List<Moviment> solucioP = new ArrayList<Moviment> () ;
						int [] stastatistiquesP = new int [2] ;
						if (!calcular_algorithme_avancat (mate , n  , new Tauler(taulersecundari) , true ,defens  ,solucioP ,stastatistiquesP)) {
							solucionG.add(new Moviment (taulersecundari, p1, m.getDestinacio()) ) ;
							return false;
						}
						else {
							if (t == null) {
								stastatistiques = stastatistiquesP ;
								t = solucioP.get(0).getTauler() ;
								solucionG.removeAll(solucionG) ;
								for ( Moviment m1 : solucioP)
									solucionG.add(m1) ;
								solucionG.add(new Moviment (taulersecundari, p1, m.getDestinacio()) ) ;
							}
						else if (stastatistiques[1]/(stastatistiques[0]+1) >  stastatistiquesP[1]/(stastatistiquesP[0]+1)) {
							Tauler t2 = solucioP.get(solucioP.size()-1).getTauler() ;
							stastatistiques = stastatistiquesP ;
							t = t2 ;
								solucionG.removeAll(solucionG) ;
									for ( Moviment m1 : solucioP)
										solucionG.add(m1) ;
									solucionG.add(new Moviment (taulersecundari, p1, m.getDestinacio()) ) ;

						}
						}
					}
					r.canviTorn(1);
					 if (r.getRellotgeJ1() > 30) return false;

				}
				return true ;
			}
			return false ;
		}
	
		public static boolean calcular_algorithme_defens_avancat (int mate , Tauler tauler , final Color defens  ) {
			boolean ret = false ;
			for (int i = 0 ; i < (mate*2)-1 ; i++) {
	;
				List <Moviment> sol = new ArrayList<Moviment> () ;
				if (i % 2 != 0) {
					  System.out.println("Torn del jugador maquina: ") ;
					  System.out.println();
				ret = calcular_algorithme_avancat ( mate - i/2 , 0 ,  tauler , false ,defens , sol , new int[2]  ) ;
				  tauler = sol.get(sol.size() - 1).getTauler() ;
				  tauler.imprimirTauler();
				}
				else {
					  Scanner teclat = new Scanner(System.in);
						System.out.println("Torn del jugador humà: ") ;
						int x;
						int y;
						boolean moves = true ;
						do{
							 moves = true ;
							System.out.println("Introduir la fila de la peça a moure (0,7)") ;
							y = teclat.nextInt() ;
						  System.out.println("Introduir la columna de la peça a moure (0,7)") ;
						  x = teclat.nextInt();
				          if(tauler.getTauler()[y][x].getPeça() == null || tauler.getTauler()[y][x].getPeça().getPeçaCol() == defens ) System.out.println("Peça incorrecta. Introdueix una opció vàlida.");
				          else if ( tauler.getTauler()[y][x].getPeça().calcularMovimentsLegals(tauler).size() == 0  )  {
				        	  System.out.println("Peça incorrecta. Introdueix una opció vàlida.");
				        	  moves = false ;
				          }
				        }
				        while(tauler.getTauler()[y][x].getPeça() == null || tauler.getTauler()[y][x].getPeça().getPeçaCol() == defens || moves== false);

					Peça p1 = tauler.getTauler()[y][x].getPeça() ;
					 List<Moviment>move =  p1.calcularMovimentsLegals(tauler) ;
					 int n = 0;
				       for (Moviment m : move) {

				  		System.out.printf("Moviment "+ n +": (%d ,%d)\n" ,m.getDestinacio().getFila() ,m.getDestinacio().getColumna());
				  		++n;
				       }
				       System.out.println("Quin moviment voleu? (contant desde 0)");
				       y = teclat.nextInt();
				       Coordinada nextPos = move.get(y).getDestinacio() ;
				       tauler.move(p1, nextPos);
				       tauler.imprimirTauler();
				}
			}
			ret = tauler.ReiMort(defens);
			return ret ;
		}
		public static boolean calcular_algorithme_atac_advacat (int mate , Tauler tauler , final Color defens  ) {
			boolean ret = false ;
			for (int i = 0 ; i < (mate*2)-1 ; i++) {
				List <Moviment> sol = new ArrayList<Moviment> () ;
				if (i % 2 == 0) {
					  System.out.println() ;
						System.out.println("Torn del jugador maquina: ") ;
					ret = calcular_algorithme_avancat ( mate - i/2 , 0 ,  tauler , true ,defens , sol , new int[2]  ) ;
					if (!ret) {
						System.out.println("ERROR: Aquest fen el algorithme avancat no ho pot resoldre ") ;
						return false ;
					}
					tauler = sol.get(sol.size() - 1).getTauler() ;
				  tauler.imprimirTauler();
				  System.out.println() ;

				}
				else {
					  Scanner teclat = new Scanner(System.in);
						System.out.println("Torn del jugador huma: ") ;
						int y;
						int x;
						boolean moves = true ;
				        do{
				        	moves = true ;
				        	if (tauler.ReiMort(defens)) return true ;
							System.out.println("Introduir la fila de la peça a moure (0,7)") ;
							y = teclat.nextInt() ;
						  System.out.println("Introduir la columna de la peça a moure (0,7)") ;
						  x = teclat.nextInt();
				          if(tauler.getTauler()[y][x].getPeça() == null || tauler.getTauler()[y][x].getPeça().getPeçaCol() != defens || tauler.getTauler()[y][x].getPeça().calcularMovimentsLegals(tauler).size() == 0) System.out.println("Peça incorrecta. Introdueix una opció vàlida.");
				        
				        }
				        while(tauler.getTauler()[y][x].getPeça() == null || tauler.getTauler()[y][x].getPeça().getPeçaCol() != defens || tauler.getTauler()[y][x].getPeça().calcularMovimentsLegals(tauler).size() == 0);
					Peça p1 = tauler.getTauler()[y][x].getPeça() ;
					 List<Moviment>move =  p1.calcularMovimentsLegals(tauler) ;
					 int n = 0;
				       for (Moviment m : move){
				  		System.out.printf("Moviment " + n + ": (%d ,%d)\n" ,m.getDestinacio().getFila() ,m.getDestinacio().getColumna());
				       ++n;
				       }
				       System.out.println("Quin moviment voleu (contant desde 0)");
				       y = teclat.nextInt();
				       Coordinada nextPos = move.get(y).getDestinacio() ;
				       tauler.move(p1, nextPos);
					   System.out.println() ;
				       tauler.imprimirTauler();

				}
			}

			return ret ;
		}
		
	public static Tauler seleciona_tauler (Tauler t1 , Tauler t2) {

		return t2 ;
	}

}

