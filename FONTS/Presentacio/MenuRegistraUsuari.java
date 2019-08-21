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


public class MenuRegistraUsuari {


	public MenuRegistraUsuari() {
		FinestraRU m = new FinestraRU();
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setVisible(true);
		
		
	}
}



class FinestraRU extends JFrame{
	private static final long serialVersionUID = 1L;
	private MRU mru; 

	public FinestraRU(){


		
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

		mru = new MRU(this);
		add(mru);
		
	}
	
}



class MRU extends JPanel{
	
	JFrame f = new JFrame();
	JTextField textfield;
	private static final long serialVersionUID = 1L;


	private class ListenerBoto1 implements ActionListener{ //Boto Iniciar Sessio
	    public void actionPerformed(ActionEvent e) {
	    	GestioJugadors gj = new GestioJugadors();

	    	String nom = textfield.getText();
	    	gj.crearJugadorInterficie(nom, f);
	    	
           }
	   	}
	private class ListenerBoto2 implements ActionListener{ //Enrere
	    public void actionPerformed(ActionEvent e) {
			Finestraprincipal m = new Finestraprincipal();
			m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			m.setVisible(true);
	        f.dispose();
	    }
	}

	public MRU(JFrame f) {
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
	    
		
	    JLabel j1 = new JLabel("--Registrar Usuari--");

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
	    
        JButton b1 = new JButton("Registrar Usuari");
        
        int ampleboto = (int) (getWidth()/3.5);
        int alturaboto = (int) (getHeight()/15);
        b1.setSize(ampleboto, alturaboto);
        
        int posxboto1 = (int) ((getWidth()/2)-(ampleboto/2));
        int posyboto1 = (int) 13*(getHeight()/30);
        
        b1.setLocation(posxboto1, posyboto1);
        	
        b1.addActionListener(new ListenerBoto1());
        
        add(b1);        

        
        //Boto2
        
        JButton b2 = new JButton("Enrere");
        
        b2.setSize(ampleboto, alturaboto);
        
        int posxboto2 = (int) ((getWidth()/2)-(ampleboto/2));
        int posyboto2 = (int) 16*(getHeight()/30);
        
        b2.setLocation(posxboto2, posyboto2);
        
        b2.addActionListener(new ListenerBoto2());
        
        add(b2);
        

	    //Usuari
	    
	    JLabel j2 = new JLabel("Nom d'usuari");

	    Font f2 = new Font("TimesRoman",Font.PLAIN,20); 
	    j2.setFont(f2);
	    
	    j2.setForeground(Color.BLUE);

	    int amplelabel2 = (int) j2.getPreferredSize().getWidth();
	    int alturalabel2 = (int) j2.getPreferredSize().getHeight();
	    
	    int posxstringNU = posxboto1;           
	    int posystringNU = (int) 11*(getHeight()/30);                        
	    
	    j2.setBounds(posxstringNU,posystringNU,amplelabel2,alturalabel2);

	    
	    add(j2);
	    
	    
	    //User Input
	    textfield= new JTextField();

	    int ampletf = (int) ampleboto - amplelabel2 - 10;
	    int alturatf = (int) textfield.getPreferredSize().getHeight();
	    
	    int posxtf = posxstringNU + amplelabel2 + 10;           
	    int posytf = (int) (11.33*(getHeight()/30));    
	    
	    textfield.setBounds(posxtf, posytf, ampletf, alturatf);
        
	    add(textfield);
        
	}
	
}