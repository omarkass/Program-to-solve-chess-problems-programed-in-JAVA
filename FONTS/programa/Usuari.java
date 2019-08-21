package programa;
public class Usuari {
	//Atributs
	private String nom;
	
	//Constructores:
		public Usuari() { //crea Usuari amb nom = "ZZZ"
			nom = "ZZZ";
	    }
		
		//Consultores:
		public String getnom(){	//Retorna el nom de l'usuari
			return nom;		
		}
		
		//Modificadores
		public void setnom(String nom){ //Canvia nom a l'usuari  	      
		   this.nom = nom;
		}
}