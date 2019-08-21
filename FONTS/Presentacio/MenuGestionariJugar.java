package Presentacio;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domini.GestioJugadors;
import programa.Jugador;


public class MenuGestionariJugar {


	public MenuGestionariJugar() {
		FinestraGIJ m = new FinestraGIJ();
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setVisible(true);
		
		
	}
}



class FinestraGIJ extends JFrame{
	private static final long serialVersionUID = 1L;
	private GIJ gij; 

	public FinestraGIJ(){


		
		//Size del marc segons la pantalla
		Toolkit pantalla=Toolkit.getDefaultToolkit();
		Dimension screensize = pantalla.getScreenSize();

		int altura = screensize.height;
		int ample = screensize.width;
		int redimaltura = (int) (altura/1.166); //1.166
		int redimample = (int) (ample/1.333);	//1.333
		setSize(redimample,redimaltura);
		
		//Establir Mida Minima
		 setMinimumSize(new Dimension(500, 500));
		
		//Location del marc segons la pantalla i el size
		
		int locationx = (int) (ample-getWidth())/2;
		int locationy = (int) (altura-getHeight())/2;
		setLocation(locationx,locationy);
		
		//No permetem resize
		setResizable(false);
		
		//titol de la finestra
		setTitle("Chess Solver");

		//Icona Marc
		Image icona=pantalla.getImage("./FONTS/Presentacio/horse.gif");
		setIconImage(icona);
		//Lamina

		gij = new GIJ(this);
		add(gij);
		
	}
	
}



class GIJ extends JPanel{
	
	JFrame f = new JFrame();
	JTextField textfield;
	private static final long serialVersionUID = 1L;


	private class ListenerBoto1 implements ActionListener{ //GestionarProblemes
	    public void actionPerformed(ActionEvent e) {
	    	MenuGestionaProblemes mgp = new MenuGestionaProblemes();
	    	f.dispose();
	    	}
	          
	    }
	private class ListenerBoto2 implements ActionListener{ //GestionarUsuaris
	    public void actionPerformed(ActionEvent e) {
	    	MenuGestionaUsuaris mgu = new MenuGestionaUsuaris();
	    	f.dispose();
	    }
	}
	
	private class ListenerBoto3 implements ActionListener{ //GestionarRanking
	    public void actionPerformed(ActionEvent e) {

	    	MenuJugar j = new MenuJugar();

	    	f.dispose();
	    	
	    }
	}
	
	private class ListenerBoto4 implements ActionListener{ //GestionarRanking
	    public void actionPerformed(ActionEvent e) {
	    	MenuGestionaRanking mgr = new MenuGestionaRanking();
	    	f.dispose();
	    }
	}
	private class ListenerBoto5 implements ActionListener{ //
	    public void actionPerformed(ActionEvent e) {
			Finestraprincipal m = new Finestraprincipal();
	        f.dispose();
	    }
	}
	private class ListenerBoto6 implements ActionListener{ //
	    public void actionPerformed(ActionEvent e) {
			ComparaAlgoritmes m = new ComparaAlgoritmes();
	        f.dispose();
	    }
	}
		
	
	public GIJ(JFrame f) {
		this.f = f;
	}
	
	public void paintComponent(Graphics g) {
		
		
		super.paintComponent(g);
		
		this.setLayout(null);
		ImageIcon backImage;
		backImage = new ImageIcon("./FONTS/Presentacio/chessboard.jpg");
		
		
		BufferedImage image = new BufferedImage(getWidth(),getHeight(), BufferedImage.TYPE_INT_RGB);
	    Graphics2D g2d = (Graphics2D) image.createGraphics();
	    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
	    g2d.drawImage(backImage.getImage(), 0, 0,getWidth(),getHeight(), null);
	    
	    g.drawImage(image, 0, 0, null);
	    
	    
		int posrectx0 = (int) (0.1*getWidth());
		int posrectxn = (int) ((0.9*getWidth()) - posrectx0);
		int posrecty0 = (int) (0.1*getHeight());
		int posrectyn = (int) ((0.9*getHeight()) - posrecty0);

		g.drawRect(posrectx0, posrecty0, posrectxn, posrectyn);
		
		//Menu!
	    
		
	    JLabel j1 = new JLabel("--Menu Gestionar i Jugar--");

	    Font f = new Font("TimesRoman",Font.BOLD,25); 
	    j1.setFont(f);
	    
	    j1.setForeground(Color.RED);

	    int amplelabel = (int) j1.getPreferredSize().getWidth();
	    int alturalabel = (int) j1.getPreferredSize().getHeight();
	    
	    int posxstringIS = (int) ((getWidth()/2)-(amplelabel/2));             
	    int posystringIS = (int) 6*(getHeight()/30);                        
	    
	    j1.setBounds(posxstringIS,posystringIS,amplelabel,alturalabel);

	    
	    add(j1);
	    

	    
	    
	    //Creacio Botons
	    //Boto1
	    
        JButton b1 = new JButton("Gestionar Problemes");
        
        int ampleboto = (int) (getWidth()/3.5);
        int alturaboto = (int) (getHeight()/15);
        b1.setSize(ampleboto, alturaboto);
        
        int posxboto1 = (int) ((getWidth()/2)-(ampleboto/2));
        int posyboto1 = (int) 10*(getHeight()/30);
        
        b1.setLocation(posxboto1, posyboto1);
        	
        b1.addActionListener(new ListenerBoto1());
        
        add(b1);        

        
        //Boto2
        
        JButton b2 = new JButton("Gestionar Usuaris");
        
        b2.setSize(ampleboto, alturaboto);
        
        int posxboto2 = (int) ((getWidth()/2)-(ampleboto/2));
        int posyboto2 = (int) 13*(getHeight()/30);
        
        b2.setLocation(posxboto2, posyboto2);
        
        b2.addActionListener(new ListenerBoto2());
        
        add(b2);
        
        //Boto3
        
        JButton b3 = new JButton("Jugar");
        
        b3.setSize(ampleboto, alturaboto);
        
        int posxboto3 = (int) ((getWidth()/2)-(ampleboto/2));
        int posyboto3 = (int) 16*(getHeight()/30);
        
        b3.setLocation(posxboto3, posyboto3);
        
        b3.addActionListener(new ListenerBoto3());
        
        add(b3);
                
        //Boto4
        
        JButton b4 = new JButton("Gestionar Ranking");
        
        b4.setSize(ampleboto, alturaboto);
        
        int posxboto4 = (int) ((getWidth()/2)-(ampleboto/2));
        int posyboto4 = (int) 19*(getHeight()/30);
        
        b4.setLocation(posxboto4, posyboto4);
        
        b4.addActionListener(new ListenerBoto4());
        
        add(b4);
        
        //Boto5
        
        JButton b5 = new JButton("Enrere");
        
        b5.setSize(ampleboto, alturaboto);
        
        int posxboto5 = (int) ((getWidth()/2)-(ampleboto/2));
        int posyboto5 = (int) 25*(getHeight()/30);
        
        b5.setLocation(posxboto5, posyboto5);
        
        b5.addActionListener(new ListenerBoto5());
        
        add(b5);
        
        //Boto5
        
        JButton b6 = new JButton("Comparar Algoritmes");
        
        b6.setSize(ampleboto, alturaboto);
        
        int posxboto6 = (int) ((getWidth()/2)-(ampleboto/2));
        int posyboto6 = (int) 22*(getHeight()/30);
        
        b6.setLocation(posxboto6, posyboto6);
        
        b6.addActionListener(new ListenerBoto6());
        
        add(b6);
        
        
	}
	
}