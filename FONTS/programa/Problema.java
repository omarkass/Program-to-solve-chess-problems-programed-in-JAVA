package programa;
public class Problema {
    //Atributs
	private String nom; //nom problema
	private int N; //nombre de tirades
	private String FENini; //Estat partida.
	private int dificultat; //Dificultat problema


    //Constructores:
    public Problema() {
        dificultat = 0;
        nom = "ZZZ";
        N = 0;
        FENini = "ZZZ";
    }
    public Problema(String nom, int N, String FENini, int dificultat){
        this.nom = nom;
        this.N = N;
        this.FENini = FENini;
        this.dificultat = dificultat; //calcularDificultat();
    }

    //Consultores:
    public int getDif(){	//Retorna Dificultat
        return dificultat;
    }
    public int getN(){	//Retorna jugades max
        return N;
    }
    public String getNom(){	//Retorna nom problema
        return nom;
    }
    public String getFENini(){	//Retorna FENini
        return FENini;
    }

    //Modificadors:
    public void setdif(int dificultat){	//Modifica Dificultat
        this.dificultat = dificultat;
    }
    public void setN(int N){	//Modifica jugades max
        this.N = N;
    }
    public void setnom(String nom){	//Modifica nom problema
        this.nom = nom;
    }
    public void setFEN(String FENini){	//Modifica FENini
        this.FENini = FENini;
    }


    //Altres funcions:
    public int calcularDificultat(){
        return 0;
    }
}
