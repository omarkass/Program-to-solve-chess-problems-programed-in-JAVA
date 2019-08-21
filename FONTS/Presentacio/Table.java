package Presentacio;

import javax.imageio.ImageIO;
import javax.swing.*;

import peces.Peça;
import programa.Casella;
import programa.Coordinada;
import programa.Moviment;
import programa.Partida;
import programa.Tauler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.*;

public class Table {
	
	private List <Moviment> desti ;
	private JFrame frameJoc;
	private TaulerPanel taulerPanel;
	private static Tauler tauler;
	private Casella casellaInici;
	private Casella casellaDesti;
	private Peça peçaMoguda;
	private int n  = 0;
	private boolean algorithem = false ;
	private boolean algorithme_avancat = false ;
	private static boolean torn_maquina = false ;
	private boolean atacador ;
	private static char defens ;
	private static int mate ;
	private static Tauler tauler_fen ;
	private static List <Moviment> moviments ;
	private static boolean primer = false ;
	private static char color ;
	private static int mate_t ;
	private static boolean home = false;
	private static Dimension MIDA_EXTERIOR_FRAME = new Dimension(1000,700);
	private static Dimension MIDA_TAULER_PANEL = new Dimension(400,350);
	private static Dimension MIDA_CASELLA_PANEL = new Dimension(10,10);
	
	private static String pathIcones = "FONTS/Presentacio/icones/";

	private Color colorCasellesBlanques = Color.decode("#ffce9e");
	private Color colorCasellesNegres = Color.decode("#d18b47");


	
	
	
	public Table( char color , int mate ,  String s , boolean algorithme_avancat , char color_maqunia , boolean maquines , boolean home) {
		this.frameJoc = new JFrame("PROP - Escacs");
		this.frameJoc.setLayout(new BorderLayout());
		torn_maquina = false ;
		JMenuBar tableBarraEines = crearBarraEines();
		this.frameJoc.setJMenuBar(tableBarraEines);
		 tauler = new Tauler();
	   	tauler.creacioTauler();
	   	algorithem = maquines ;
	   	if (home== false && maquines == false && mate == 2) 
	   		n = -1 ;
		if (home== false && maquines == false && mate == 3) 
	   		n = -1 ;
		if (home== true &&  mate ==2) 
	   		n = -1 ;
		if (home== true &&  mate ==3) 
	   		n = -1 ;
	   	this.home = home ;
	   	tauler.emplenarTauler(s.toCharArray());
        this.color = color_maqunia;
        this.algorithme_avancat = algorithme_avancat ;
		torn_maquina = false ;
		this.mate = mate_t= mate ;
		this.defens = color ;
		primer = false ;
      		Toolkit pantalla=Toolkit.getDefaultToolkit();
      		Dimension screensize = pantalla.getScreenSize();

      		int altura = screensize.height;
      		int ample = screensize.width;
      		
      		int locationx = (int) (ample-1000)/2;
      		int locationy = (int) (altura-700)/2;
      		this.frameJoc.setLocation(locationx,locationy);
      		
      		//No permetem resize
      		this.frameJoc.setResizable(false);
      		
        
        this.frameJoc.setSize(MIDA_EXTERIOR_FRAME);
		this.taulerPanel = new TaulerPanel();
		this.frameJoc.add(this.taulerPanel, BorderLayout.CENTER);
		this.frameJoc.setVisible(true);
		
	}
	public  void calcular_algorithme_defens (  ) {
		
		
		this.frameJoc.setTitle("la maquina m1 esta calculant la solucion") ;
		boolean ret = false ;
		if (mate > 1) {
			List <Moviment> sol = new ArrayList<Moviment> () ;
			 mate -- ;
				  if (defens == 'b')
			ret = Partida.calcular_algorithme ( mate  , 0 ,  tauler , false ,Tauler.blanc() , sol , new int[2]  ) ;
				  else
					  ret = Partida.calcular_algorithme ( mate  , 0 ,  tauler , false ,Tauler.negre() , sol , new int[2]  ) ;
			  tauler = sol.get(sol.size() - 1).getTauler() ;
			 
			  tauler.imprimirTauler();
			  torn_maquina = false ;
			primer = false ;
			 this.frameJoc.setTitle("La solucio s'ha calculat es el teu torn") ;
		
	}
		
		}
	
	public  void calcular_algorithme_defens_avancat (  ) {
		
		 this.frameJoc.setTitle("la maquina m2 esta calculant la solucio") ;
		boolean ret = false ;
		if (mate > 1) {
			List <Moviment> sol = new ArrayList<Moviment> () ;
			 mate --  ;
				  if (defens == 'b')
			ret = Partida.calcular_algorithme_avancat ( mate  , 0 ,  tauler , false ,Tauler.blanc() , sol , new int[2]  ) ;
				  else
					  ret = Partida.calcular_algorithme ( mate  , 0 ,  tauler , false ,Tauler.negre() , sol , new int[2]  ) ;
			  tauler = sol.get(sol.size() - 1).getTauler() ;
			 
			  tauler.imprimirTauler();
			  torn_maquina = false ;
			primer = false ;
			this.frameJoc.setTitle("La solucio s'ha calculat es el teu torn") ;
//		ret = tauler.ReiMort(defens);
		
	}
	
		}
	
	
	public Table(List <Moviment> m) {
		this.frameJoc = new JFrame("PROP - Escacs");
		this.frameJoc.setLayout(new BorderLayout());
		JMenuBar tableBarraEines = crearBarraEines();
		this.frameJoc.setJMenuBar(tableBarraEines);
		this.tauler = new Tauler();
        tauler.creacioTauler();
       // tauler.emplenarTaulerInici();
        String s = "1N1b4/6nr/R5n1/2Ppk2r/K2pr1qR/4R3/2N1PQ2/B6B";
       tauler.emplenarTauler(s.toCharArray());
		
  
      		Toolkit pantalla=Toolkit.getDefaultToolkit();
      		Dimension screensize = pantalla.getScreenSize();

      		int altura = screensize.height;
      		int ample = screensize.width;
      		
      		int locationx = (int) (ample-1000)/2;
      		int locationy = (int) (altura-700)/2;
      		this.frameJoc.setLocation(locationx,locationy);
      		
      		//No permetem resize
      		this.frameJoc.setResizable(false);
      		
        
        this.frameJoc.setSize(MIDA_EXTERIOR_FRAME);
		this.taulerPanel = new TaulerPanel();
		this.frameJoc.add(this.taulerPanel, BorderLayout.CENTER);
		this.frameJoc.setVisible(true);
	}
	
	
	
	
	
	
	


	public List <Moviment> algorithme( ) {
		List <Moviment> sol = new ArrayList<Moviment> () ;
		boolean b ;
		if (algorithme_avancat == false) {
		  if (defens == 'b')	{
			  this.frameJoc.setTitle("la maquina m1 esta calculant el algorithme") ;
	b = Partida.calcular_algorithme ( mate  , 0 ,  tauler , true ,Tauler.blanc() , sol , new int[2]  ) ;
	this.frameJoc.setTitle("la maquina m1 ha calculat el algorithme pots clica per veure les solucion") ;
		  }else {
			  this.frameJoc.setTitle("la maquina m1 esta calculant el algorithme") ;
		b =   Partida.calcular_algorithme ( mate  , 0 ,  tauler , true ,Tauler.negre() , sol , new int[2]  ) ;
		this.frameJoc.setTitle("la maquina m1 ha calculat el algorithme pots clica per veure les solucion") ;
		}
		}
		else {
			 if (defens == 'b')	{	
				 this.frameJoc.setTitle("la maquina m2 esta calculant el algorithme") ;
					b = Partida.calcular_algorithme_avancat ( mate  , 0 ,  tauler , true ,Tauler.blanc() , sol , new int[2]  ) ;
					this.frameJoc.setTitle("la maquina m2 ha calculat el algorithme pots clica per veure les solucion") ;
			 } else {
				 this.frameJoc.setTitle("la maquina m2 esta calculant el algorithme") ;
					b =   Partida.calcular_algorithme_avancat  ( mate  , 0 ,  tauler , true ,Tauler.negre() , sol , new int[2]  ) ;
					this.frameJoc.setTitle("la maquina m2 ha calculat el algorithme pots clica per veure les solucion") ;
			 }}
	    return sol ;
		}
	
	private JMenuBar crearBarraEines() {
		JMenuBar tableBarraEines = new JMenuBar();
		tableBarraEines.add(crearMenuArxiu());
		return tableBarraEines;
	}

	private JMenu crearMenuArxiu() {
		JMenu menuArxiu = new JMenu("Arxiu");
		JMenuItem itemExemple = new JMenuItem("Item de prova");
		itemExemple.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Item de prova funciona!");
			}
		});
		menuArxiu.add(itemExemple);
		
		JMenuItem itemSortir = new JMenuItem("Sortir");
		itemSortir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuArxiu.add(itemSortir);
		return menuArxiu;
	}
	
	private class TaulerPanel extends JPanel {
		CasellaPanel casellesTauler[][];
		
		TaulerPanel(){
			super(new GridLayout(8,8));
			this.casellesTauler = new CasellaPanel[8][8] ;
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; ++j) {
					CasellaPanel casellesPanel = new CasellaPanel(this, i, j);
					this.casellesTauler[i][j] = casellesPanel ;
					add(casellesPanel);
				}
			}
			setPreferredSize(MIDA_TAULER_PANEL);
			validate();
		}
		
		public void drawTauler(Tauler tauler) {
			removeAll();
			for(CasellaPanel [] casellaPanelA : casellesTauler ) 
				for(CasellaPanel casellaPanel : casellaPanelA ) 
			{
				casellaPanel.drawCasella(tauler);
				add(casellaPanel);
			}
			validate();
			repaint();
		}
	}
	
	private class CasellaPanel extends JPanel {
		
		private int fila;
		private int columna;
	
		
		CasellaPanel(TaulerPanel taulerPanel, int fila, int columna) {
			super(new GridBagLayout());
			this.fila = fila;
			this.columna = columna;
			setPreferredSize(MIDA_CASELLA_PANEL);
			assignTileColor();
			assignarIconaPeça(tauler);
			
			addMouseListener(new MouseListener(){
				@Override
				public void mouseClicked(MouseEvent e) {
					 if (algorithem == true && primer == false) {
						 moviments = algorithme ();
						 if (moviments.size() < 1) {
							 JOptionPane jop = new JOptionPane();
					        	jop.showMessageDialog(frameJoc,
					  	  	 		    "no sha pegut resoldre el fen",
					  	  	 		    "Chess Solver",
					  	  	 		    JOptionPane.INFORMATION_MESSAGE);
					        	MenuGestionariJugar mgij = new MenuGestionariJugar();
								frameJoc.dispose();
						 }
						 primer = true ;
						 tauler = moviments.get(moviments.size() - 1).getTauler() ;
						 tauler.imprimirTauler();
						 moviments.remove(moviments.size() - 1) ;
					 }
					 else if (algorithem == true && primer == true ) {
						 tauler = moviments.get(moviments.size() - 1).getTauler() ;
						 moviments.remove(moviments.size() - 1) ;
					 }
					 else {
						 primer = false ;
					 boolean color_permet = false ;
					 if (tauler.getCasella(fila, columna).getPeça() != null) {
						if (color == 'n' && tauler.getCasella(fila, columna).getPeça().getPeçaCol()== Tauler.negre() ) color_permet = true ;
						else if(color == 'b' && tauler.getCasella(fila, columna).getPeça().getPeçaCol()== Tauler.blanc() ) color_permet = true ;
						
					 }
					boolean comer = false ;
					if (torn_maquina == false ) {
					 if(SwingUtilities.isLeftMouseButton(e)) {
						 if (tauler.getCasella(fila, columna).getPeça() != null && peçaMoguda!= null  )
							 if (tauler.getCasella(fila, columna).getPeça().getPeçaCol() != peçaMoguda.getPeçaCol() )
								 comer = true ;
						 
						 if(tauler.getCasella(fila, columna).getPeça() == null  || comer) {
							 for (Moviment m : desti) {
								 if (m.getDestinacio().getColumna() == columna && m.getDestinacio().getFila() == fila) {
									 tauler.move(peçaMoguda, new Coordinada(fila, columna));
								 torn_maquina = true ;
								 primer = true ;
								 if (home) {
										if (color == 'b') color = 'n' ;
										else color = 'b'		;
										torn_maquina = false ;
										primer = false ;
										n++ ;
									}
								 }
									SwingUtilities.invokeLater(new Runnable() {

										@Override
										public void run() {
											taulerPanel.drawTauler(tauler);
											if (tauler_fen == null ) {
												tauler_fen = tauler; ;
												n++ ;
											}
										
											
										}
									});
								
							 }
								casellaInici = null;
								casellaDesti = null;
								peçaMoguda = null ;
								desti = new ArrayList() ;
							}
						 else if (color_permet) {
							casellaDesti = tauler.getCasella(fila, columna);
							peçaMoguda = casellaDesti.getPeça() ;
							desti = peçaMoguda.calcularMovimentsLegals(tauler) ;
							
							casellaInici = tauler.getCasella(fila, columna) ;
							casellaDesti = null;
						}}}}
						SwingUtilities.invokeLater(new Runnable() {

							@Override
							public void run() {
								taulerPanel.drawTauler(tauler);
								if (tauler_fen == null ) {
									tauler_fen = tauler; ;
									n++ ;
								}
								if (tauler_fen != tauler )
								{
									tauler_fen = tauler;
									n++ ;
									System.out.println(n) ;
									System.out.println(mate_t) ;
								}
								if (n  == mate_t + mate_t - 1 ) {
									boolean ret ;
								if (defens == 'b')	ret = tauler.ReiMort(Tauler.blanc()) ;
								else	ret = tauler.ReiMort(Tauler.negre()) ;
								String avis ;
								if (algorithem) {
								if (ret) avis = "El fen s'ha pegut resoldre" ;
								else avis = "El fen no s'ha pegut resoldre" ;
								}
								else 
								{
									if (ret) avis = "Molt be has pegut resoldre el fen" ;
									else avis = "No has pegut resoldre el fen" ;
								}
								avis += " clica ok i torna al menu gestio juga" ;
							JOptionPane jop = new JOptionPane();
					        	jop.showMessageDialog(frameJoc,
					  	  	 		    avis,
					  	  	 		    "Chess Solver",
					  	  	 		    JOptionPane.INFORMATION_MESSAGE);
					        	
								MenuGestionariJugar mgij = new MenuGestionariJugar();
								frameJoc.dispose();
								}
							
								
							}
						});
					
				
					if (primer == true && home == false && algorithem == false) {
						if (algorithme_avancat)calcular_algorithme_defens_avancat() ;
						else calcular_algorithme_defens() ;
						n++ ;
					}
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			
			validate();
		}
		
		public void drawCasella(Tauler tauler) {
			
			
			assignTileColor();
			assignarIconaPeça(tauler);
			validate();
			repaint();
		}
		private void assignarIconaPeça(Tauler tauler) {
			this.removeAll();
			if(tauler.getCasella(this.fila, this.columna).getOcupat()) {
				try {
					BufferedImage imatge = 
							ImageIO.read(new File(pathIcones  + tauler.getCasella(this.fila, this.columna).getPeça().getPeçaCol().toString().substring(0, 1) +
							tauler.getCasella(this.fila, this.columna).getPeça().getPeçaChar() + ".png"));
					add(new JLabel(new ImageIcon(imatge)));
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		private void assignTileColor() {
			if ((this.columna % 2 == 1 && this.fila % 2 == 1)
                    //) {
                    || (this.columna % 2 == 0 && this.fila % 2 == 0)) {
                setBackground(colorCasellesBlanques);
            } else {
                setBackground(colorCasellesNegres);
            }
		}
	
		private void assignTileColorblau() {
			
                setBackground(Color.blue);
		}	
		
	}
}
