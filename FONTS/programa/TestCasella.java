package programa;

import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import peces.Peça;
import peces.Torre;

public class TestCasella {

	@Test
	public void testGetfile() {
		Casella c = new Casella() ;
		c.creacioCasella(3, 4);
		int fila = c.getFila() ;
		assertEquals(3,fila) ;
	}
	@Test
	public void testGetcolumna() {
		Casella c = new Casella() ;
		c.creacioCasella(3, 4);
		int columna = c.getColumna() ;
		assertEquals(4,columna) ;
	}
	@Test
	public void testgetOcupat() {
		Casella c = new Casella() ;
		c.creacioCasella(3, 4);
		boolean ocup = c.getOcupat() ;
		assertEquals(false,ocup) ;
	}
	@Test
	public void testgetPeça() {
		Casella c = new Casella() ;
		c.creacioCasella(3, 4);
		Peça p1 = c.getPeça() ;
		assertEquals(null,p1) ;
		}
	@Test
	public void testsetFila() {
		Casella c = new Casella() ;
		c.creacioCasella(3, 4);
		c.setFila(5) ;
		assertEquals(5,c.getFila()) ;
		}
	@Test
	public void testsetColumna() {
		Casella c = new Casella() ;
		c.creacioCasella(3, 4);
		c.setColumna(6) ;
		assertEquals(6,c.getColumna()) ;
		}
	@Test
	public void testsetPeça() {
		Casella c = new Casella() ;
		c.creacioCasella(3, 4);
		Peça p = new Torre() ;
		c.setPeça('p', p);
		assertEquals(p,c.getPeça()) ;
		}
	@Test
	public void testposicioCorrecta() {
		Casella c = new Casella() ;
		c.creacioCasella(3, 4);
		assertEquals(false,c.posicioCorrecta(1,-1)) ;
		}
	
	@Test
	public void testeliminarPeça() {
		Casella c = new Casella() ;
		c.creacioCasella(3, 4);
		c.setPeça('c',  new Torre()) ;
		c.eliminarPeça();
		assertEquals(null,c.getPeça()) ;
		assertEquals(false,c.getOcupat()) ;
		}
	@Test
	public void testgetBlanc() {
		assertEquals(Color.BLANC,Casella.getBlanc()) ;
		}
	@Test
	public void testgetNegre() {
		assertEquals(Color.NEGRE,Casella.getNegre()) ;
		}
	@Test
	public void testcopy() {
		Casella c = new Casella() ;
		c.creacioCasella(3, 4);
		Casella c1 = new Casella();
		c1.copy(c); 
		assertEquals(c.getFila(),c1.getFila()) ;
		assertEquals(c.getColumna(),c1.getColumna()) ;
		assertEquals(c.getOcupat(),c1.getOcupat()) ;
		}
	

}
