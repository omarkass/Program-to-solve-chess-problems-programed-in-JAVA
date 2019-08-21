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
import domini.GestioProblemes;
import programa.Jugador;


public class CrearProblema {


	public CrearProblema() {
		FinestraCP m = new FinestraCP();
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setVisible(true);
		
		
	}
}

class FinestraCP extends JFrame{
	private static final long serialVersionUID = 1L;
	private CP cp; 

	public FinestraCP(){
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

		cp = new CP(this);
		add(cp);
		
	}
	
}



class CP extends JPanel{
	
	JFrame f = new JFrame();
	JTextField textfield1;
	JTextField textfield2;
	JTextField textfield3;
	JTextField textfield4;
	
	private static final long serialVersionUID = 1L;


	private class ListenerBoto1 implements ActionListener{ //Boto Iniciar Sessio
	    public void actionPerformed(ActionEvent e) {
	    	GestioProblemes gp = new GestioProblemes();
	    	String nom = textfield1.getText();
	    	String FEN = textfield2.getText();
	    	String mat = textfield3.getText();
	    	String dif = textfield4.getText();
	    	gp.crearProblemaInterficie(nom, FEN, mat, dif, f);
	    }
	          
	}
	private class ListenerBoto2 implements ActionListener{ //Enrere
	    public void actionPerformed(ActionEvent e) {
	    	MenuGestionaProblemes m = new MenuGestionaProblemes();
	        f.dispose();
	    }
	}
private class ListenerBoto3 implements ActionListener{ //Enrere
    public void actionPerformed(ActionEvent e) {
		MenuGestionariJugar m = new MenuGestionariJugar();
        f.dispose();
    }
}
	public CP(JFrame f) {
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
	    
		
	    JLabel j1 = new JLabel("--Crear Problema--");

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
	    
        JButton b1 = new JButton("Afegir");
        
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
        

        //Problema
	    
	    JLabel j2 = new JLabel("Nom del Problema");

	    Font f2 = new Font("TimesRoman",Font.PLAIN,20); 
	    j2.setFont(f2);
	    
	    j2.setForeground(Color.BLUE);

	    int amplelabel2 = (int) j2.getPreferredSize().getWidth();
	    int alturalabel2 = (int) j2.getPreferredSize().getHeight();
	    
	    int posxstringNP = posxboto1;           
	    int posystringNP = (int) 8*(getHeight()/30);                        
	    
	    j2.setBounds(posxstringNP,posystringNP,amplelabel2,alturalabel2);

	    
	    add(j2);
	    
	    
	    //User Input
	    textfield1 = new JTextField();

	    int ampletf1 = (int) ampleboto - amplelabel2 - 10;
	    int alturatf1 = (int) textfield1.getPreferredSize().getHeight();
	    
	    int posxtf1 = posxstringNP + amplelabel2 + 10;           
	    int posytf1 = (int) (8.33*(getHeight()/30));    
	    
	    textfield1.setBounds(posxtf1, posytf1, ampletf1, alturatf1);
        
	    add(textfield1);

	
	    //FEN Problema
	    
	    JLabel j3 = new JLabel("FEN del Problema");

	    Font f3 = new Font("TimesRoman",Font.PLAIN,20); 
	    j3.setFont(f3);
	    
	    j3.setForeground(Color.BLUE);

	    int amplelabel3 = (int) j3.getPreferredSize().getWidth();
	    int alturalabel3 = (int) j3.getPreferredSize().getHeight();
	    
	    int posxstringFEN = posxboto1;           
	    int posystringFEN = (int) 10*(getHeight()/30);                        
	    
	    j3.setBounds(posxstringFEN,posystringFEN,amplelabel3,alturalabel3);

	    
	    add(j3);
	    
	    
	    //User Input
	    textfield2 = new JTextField();

	    int ampletf2 = (int) ampleboto - amplelabel3 - 10;
	    int alturatf2 = (int) textfield2.getPreferredSize().getHeight();
	    
	    int posxtf2 = posxstringFEN + amplelabel3 + 10;           
	    int posytf2 = (int) (10.33*(getHeight()/30));    
	    
	    textfield2.setBounds(posxtf2, posytf2, ampletf2, alturatf2);
        
	    add(textfield2);
	    
	    
	    //Nom Problema
	    
	    JLabel j4 = new JLabel("Torns Mat");

	    Font f4 = new Font("TimesRoman",Font.PLAIN,20); 
	    j4.setFont(f4);
	    
	    j4.setForeground(Color.BLUE);

	    int amplelabel4 = (int) j4.getPreferredSize().getWidth();
	    int alturalabel4 = (int) j4.getPreferredSize().getHeight();
	    
	    int posxstringJ4 = posxboto1;           
	    int posystringJ4 = (int) 12*(getHeight()/30);                        
	    
	    j4.setBounds(posxstringJ4,posystringJ4,amplelabel4,alturalabel4);

	    
	    add(j4);
	    
	    
	    //User Input
	    textfield3 = new JTextField();

	    int ampletf3 = (int) ampleboto - amplelabel4 - 10;
	    int alturatf3 = (int) textfield3.getPreferredSize().getHeight();
	    
	    int posxtf3 = posxstringJ4 + amplelabel4 + 10;           
	    int posytf3 = (int) (12.33*(getHeight()/30));    
	    
	    textfield3.setBounds(posxtf3, posytf3, ampletf3, alturatf3);
        
	    add(textfield3);

	    
	    //Problema
	    
	    JLabel j5 = new JLabel("Dificultat");

	    Font f5 = new Font("TimesRoman",Font.PLAIN,20); 
	    j5.setFont(f5);
	    
	    j5.setForeground(Color.BLUE);

	    int amplelabel5 = (int) j5.getPreferredSize().getWidth();
	    int alturalabel5 = (int) j5.getPreferredSize().getHeight();
	    
	    int posxstringJ5 = posxboto1;           
	    int posystringJ5 = (int) 14*(getHeight()/30);                        
	    
	    j5.setBounds(posxstringJ5,posystringJ5,amplelabel5,alturalabel5);

	    
	    add(j5);
	    
	    
	    //User Input
	    textfield4= new JTextField();

	    int ampletf4 = (int) ampleboto - amplelabel5 - 10;
	    int alturatf4 = (int) textfield4.getPreferredSize().getHeight();
	    
	    int posxtf4 = posxstringJ5 + amplelabel5 + 10;           
	    int posytf4 = (int) (14.33*(getHeight()/30));    
	    
	    textfield4.setBounds(posxtf4, posytf4, ampletf4, alturatf4);
        
	    add(textfield4);

}
	
}