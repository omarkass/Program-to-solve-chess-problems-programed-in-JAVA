package programa;

public class Jugador {
    //Atributs
	private String nom;

    //Constructores:
    public Jugador() { //crea Usuari amb nom = "ZZZ"
            nom = "Anonim";
    }

    public Jugador(String nom){
        this.nom = nom;
    }

    //Consultores:
    public String getNom(){ //Retorna el nom de l'usuari
            return nom;
    }

        //Modificadores
    public void setNom(String nom){ //Canvia nom a l'usuari
           this.nom = nom;
    }
}