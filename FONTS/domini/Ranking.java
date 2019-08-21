package domini;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * Classe programa conté el ranking
 * @author albert
 *
 */
public class Ranking
{

	private Map<String, Float> ranking = new HashMap<String, Float>();
	private  String nomProblema = "ProblemaPerDefecte";
/**
 * 	Constructora per defecte
 */
    public Ranking() {
    	File tempFile = new File("./" + nomProblema + ".ser");
    	boolean exists = tempFile.exists();
    	if(exists) cargarRanking();
    	else guardarRanking();
    }
    /**
     * 	Constructora amb nom
     * @param nomProblema
     */
	public Ranking(String nomProblema)
    {
        this.nomProblema = nomProblema;
    	File tempFile = new File("./" + nomProblema + ".ser");
    	boolean exists = tempFile.exists();
    	if(exists) cargarRanking();
    	else guardarRanking();
    }
	/**
	 * Setter per modificar el nomProblema
	 * @param nomProblema
	 */
	public void setNomProblema(String nomProblema) {
		this.nomProblema = nomProblema;
    	guardarRanking();
	}
	/**
	 * Getter per aconseguir nomProblema
	 * @return
	 */
	public String getNomProblema() {
		return nomProblema;
	}
	/**
	 * Metode per afegir una posició al ranking
	 * @param nom
	 * @param temps
	 */
	public void afegirPosicio(String nom, float temps) {
		if (!getRanking().containsKey(nom)) getRanking().put(nom, temps);
		else if (temps<getRanking().get(nom)) getRanking().put(nom, temps);
		guardarRanking();
	}
	public void esborrarPosicio(String nom) {
		if (getRanking().containsKey(nom)) {
			getRanking().remove(nom);
			System.out.println("L'usuari: " + nom + " ha estat esborrat");
		}
		else System.out.println("L'usuari no existeix en aquest ranking");

		guardarRanking();
	}
	/**
	 * Metode per consultar el temps d'una posicio concreta del ranking
	 * @param nom
	 * @return
	 */
	public float consultarTemps(String nom) {
		try {
			return getRanking().get(nom);
			}
		catch (NullPointerException e) {
			System.out.println("L'usuari no existeix en aquest ranking");
		}
		return 0;
	}
	public void ordenarRanking() {
        List<Map.Entry<String, Float>> nouRanking = new LinkedList<>(getRanking().entrySet());
        Collections.sort(nouRanking, (Map.Entry<String, Float> map1, Map.Entry<String, Float> map2) -> (map1.getValue()).compareTo(map2.getValue()));
        Map<String, Float> rankingOrdenat= new LinkedHashMap<>();
        nouRanking.forEach((entry) -> {
            rankingOrdenat.put(entry.getKey(), entry.getValue());
        });
        setRanking(rankingOrdenat);
	}
	public void imprimirRanking() {
		ordenarRanking();
		int n = 0;
        System.out.println("Ranking del problema: " + nomProblema);
        if(getRanking().isEmpty()) System.out.println("No existeixen posicions per a aquest problema");
		for (String nom: getRanking().keySet()){
			++n;
            String key = nom.toString();
            String value = getRanking().get(nom).toString();
            System.out.println("Posició " + n + ": " + key + " " + value);
            }
		
	}
	
	public void imprimirRankingInterficie(JFrame f) {
		ordenarRanking();
		int n = 0;
		List<String> listOfString = new ArrayList<String>();
        if(getRanking().isEmpty()) System.out.println("No existeixen posicions per a aquest problema");
		for (String nom: getRanking().keySet()){
			++n;
            String key = nom.toString();
            String value = getRanking().get(nom).toString();
            listOfString.add("Posició " + n + ": " + key + " " + value);
            
            }
		JOptionPane jop = new JOptionPane();
	 		jop.showMessageDialog(f,
	  	 		    listOfString,
	  	 		    "Ranking",
	  	 		    JOptionPane.INFORMATION_MESSAGE);  
	}
	
	
	public void guardarRanking() {
		 try
         {
                FileOutputStream fos =
                new FileOutputStream("./" + nomProblema + ".ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(getRanking());
                oos.close();
                fos.close();
         }catch(IOException ioe)
          {
                ioe.printStackTrace();
          }
	}
	@SuppressWarnings("unchecked")
	public void cargarRanking() {
		setRanking(null);
	      try
	      {
	         FileInputStream fis = new FileInputStream("./" + nomProblema + ".ser");
	         ObjectInputStream ois = new ObjectInputStream(fis);
	         setRanking((Map<String, Float>) ois.readObject());
	         ois.close();
	         fis.close();
	      }catch(IOException ioe)
	      {
		         System.out.println("El ranking d'aquest problema no existeix");
	         return;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Class not found");
	         c.printStackTrace();
	         return;
	      }
	}
	public Set<String> llistarRankings() throws IOException {
		String dir = "./";
		Set<String> fileList = new HashSet<>();
	    try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
	        for (Path path : stream) {
	            if (!Files.isDirectory(path) && path.getFileName().toString().endsWith(".ser")) {
	            	String newFile = path.getFileName().toString();
	            	fileList.add(newFile.substring(7, newFile.indexOf(".ser")));
	            }
	        }
	    }
	    for(String file: fileList ) {
            //file = file.substring(7, file.indexOf(".ser"));
            System.out.println(file);
	    }
	    return fileList;
	}
	public Map<String, Float> getRanking() {
		return ranking;
	}
	public void setRanking(Map<String, Float> ranking) {
		this.ranking = ranking;
	}
}