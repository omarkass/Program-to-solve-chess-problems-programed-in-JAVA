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


public class EsborraPosRanking {


	public EsborraPosRanking() {
		FinestraEPR m = new FinestraEPR();
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setVisible(true);
		
		
	}
}

class FinestraEPR extends JFrame{
	private static final long serialVersionUID = 1L;
	private EPR epr; 

	public FinestraEPR(){
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

		epr = new EPR(this);
		add(epr);
		
	}
	
}



class EPR extends JPanel{
	
	JFrame f = new JFrame();
	JTextField textfield1;
	JTextField textfield2;
	JTextField textfield3;
	JTextField textfield4;
	
	private static final long serialVersionUID = 1L;


	private class ListenerBoto1 implements ActionListener{ //Boto Iniciar Sessio
	    public void actionPerformed(ActionEvent e) {
/*	    	GestioJugadors gestioJugadors = new GestioJugadors();
	    	Jugador j = new Jugador();
	    	gestioJugadors.crearJugador(j);
            System.out.println("Jugador creat");
            gestioJugadors.llistarJugadors();
            System.out.println("Amb quin nom d'usuari voleu iniciar sessió?");
            String nom;
            do{
                nom = teclat.next();
                if(!gestioJugadors.existeixJugador(nom)) System.out.println("Aquest usuari no existeix. Introdueix una opció vàlida.");
                else j = new Jugador(nom);
            }
            while(!gestioJugadors.existeixJugador(nom));
            System.out.println("Sessió iniciada amb el jugador amb nom: " + j.getNom());
            return j;
	   */
	            }
	          
	    }
	private class ListenerBoto2 implements ActionListener{ //Enrere
	    public void actionPerformed(ActionEvent e) {
	    	MenuGestionaRanking m = new MenuGestionaRanking();
	        f.dispose();
	    }
	}

	public EPR(JFrame f) {
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
	    
		
	    JLabel j1 = new JLabel("--Esborrar Posicio--");

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
	    
        JButton b1 = new JButton("Esborrar");
        
        int ampleboto = (int) (getWidth()/3.5);
        int alturaboto = (int) (getHeight()/15);
        b1.setSize(ampleboto, alturaboto);
        
        int posxboto1 = (int) ((getWidth()/2)-(ampleboto/2));
        int posyboto1 = (int) 16*(getHeight()/30);
        
        b1.setLocation(posxboto1, posyboto1);
        	
        b1.addActionListener(new ListenerBoto1());
        
        add(b1);        

        
        //Boto2
        
        JButton b2 = new JButton("Enrere");
        
        b2.setSize(ampleboto, alturaboto);
        
        int posxboto2 = (int) ((getWidth()/2)-(ampleboto/2));
        int posyboto2 = (int) 19*(getHeight()/30);
        
        b2.setLocation(posxboto2, posyboto2);
        
        b2.addActionListener(new ListenerBoto2());
        
        add(b2);
        
	    JLabel j2 = new JLabel("Nom Ranking");

	    Font f2 = new Font("TimesRoman",Font.PLAIN,20); 
	    j2.setFont(f2);
	    
	    j2.setForeground(Color.BLUE);

	    int amplelabel2 = (int) j2.getPreferredSize().getWidth();
	    int alturalabel2 = (int) j2.getPreferredSize().getHeight();
	    
	    int posxstringNP = posxboto1;           
	    int posystringNP = (int) 10*(getHeight()/30);                        
	    
	    j2.setBounds(posxstringNP,posystringNP,amplelabel2,alturalabel2);

	    
	    add(j2);
	    
	    
	    //User Input
	    textfield1 = new JTextField();

	    int ampletf1 = (int) ampleboto - amplelabel2 - 10;
	    int alturatf1 = (int) textfield1.getPreferredSize().getHeight();
	    
	    int posxtf1 = posxstringNP + amplelabel2 + 10;           
	    int posytf1 = (int) (10.33*(getHeight()/30));    
	    
	    textfield1.setBounds(posxtf1, posytf1, ampletf1, alturatf1);
        
	    add(textfield1);

	
    
	    
	    JLabel j3 = new JLabel("Posicio");

	    Font f3 = new Font("TimesRoman",Font.PLAIN,20); 
	    j3.setFont(f3);
	    
	    j3.setForeground(Color.BLUE);

	    int amplelabel3 = (int) j3.getPreferredSize().getWidth();
	    int alturalabel3 = (int) j3.getPreferredSize().getHeight();
	    
	    int posxstringNNU = posxboto1;           
	    int posystringNNU = (int) 12*(getHeight()/30);                        
	    
	    j3.setBounds(posxstringNNU,posystringNNU,amplelabel3,alturalabel3);

	    
	    add(j3);
	    
	    
	    //User Input
	    textfield2 = new JTextField();

	    int ampletf2 = (int) ampleboto - amplelabel3 - 10;
	    int alturatf2 = (int) textfield2.getPreferredSize().getHeight();
	    
	    int posxtf2 = posxstringNNU + amplelabel3 + 10;           
	    int posytf2 = (int) (12.33*(getHeight()/30));    
	    
	    textfield2.setBounds(posxtf2, posytf2, ampletf2, alturatf2);
        
	    add(textfield2);

	


}
	
}