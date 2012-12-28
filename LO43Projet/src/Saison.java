import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Saison
{
	private String m_nom;
	public ArrayList<Circuit> m_listeCircuits= new ArrayList<Circuit>();
	
	/************* Constructeurs **************/
	/** Constructeur par défaut **/
	public Saison()
	{
	} 
	
	/** Constructeur par valeurs **/
	public Saison(String nom, ArrayList<Circuit> listeCircuits)
	{     
	    m_nom = nom;
	    m_listeCircuits = listeCircuits;
	}
	
		
	/** Contructeur par recopie **/
	public Saison(Saison s)
	{   
	    m_nom = s.m_nom;
	    m_listeCircuits.ensureCapacity(s.m_listeCircuits.size());
	    m_listeCircuits=(ArrayList<Circuit>) s.m_listeCircuits.clone();

	}
			
	/************* Accesseurs **************/
	public String getNom()
	{  
	    return m_nom;
	}

	public ArrayList<Circuit> getListeCircuits() {
		return m_listeCircuits;
	}

	/*************** Mutateurs ***************/
	public void setNom(String nom)
	{  
	    m_nom=nom;
	}

	public void setListeCircuits(ArrayList<Circuit> listeCircuits) {
		m_listeCircuits = listeCircuits;
	}
	
	/*************** Fonctions ***************/
	public void ajoutCircuit(Circuit c)
	{
		m_listeCircuits.add(c);
	}
	
	public void removeListeCircuits(int indice)
	{
		if(indice >= 0 && indice < m_listeCircuits.size())
		{
			m_listeCircuits.remove(indice);
		}
		else
			System.out.println("Erreur, mauvais indice");
	}
	
	/*********** gestion de Fichiers ***********/
	/*On suppose que les fichiers écrit respectent la syntaxe établie :
	  -dans un dossier du même nom que la classe
	  -nom_de_l'objet.txt
	  -les variables sont entrées une par ligne, dans l'ordre définit plus haut lors de la création
	 */
	
	public void lireSaisonF(String nomFichier)
	{
		int i,taille;
		//le chemin relatif ou se trouve le fichier
		String fichier="Saisons/"+nomFichier+".txt";
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			//On récupère le nom du circuit, qu'on connait déjà
			ligne=br.readLine();
			m_nom=ligne;
			//on récupère et reformate le nombre de circuits associés à la saison
			ligne=br.readLine();
			taille=Integer.parseInt(ligne);
			
			//on peut donc avec certitude ré-inserer les circuits uns par uns
			m_listeCircuits = new ArrayList<Circuit>();
			m_listeCircuits.ensureCapacity(taille);
			for(i=0;i<m_listeCircuits.size();i++)
			{
				ligne=br.readLine();
				
				Circuit circuitTmp = new Circuit();
				circuitTmp.lireCircuitF(ligne);
				m_listeCircuits.set(i, circuitTmp);
			}
			

			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void enregistrerSaisonSF()
	{
		//Chemin relatif ou on enregistre le fichier saison
		String fichier="Saisons/"+m_nom+".txt";
		int i;
		
		try {
			FileWriter fw = new FileWriter (fichier);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter fichierSortie = new PrintWriter (bw); 
				fichierSortie.println (m_nom+"\n"+m_listeCircuits.size()); 
				for(i=0;i<m_listeCircuits.size();i++)
				{
					//on ajoute les noms des circuits dans le fichier de saison
					fichierSortie.println (m_listeCircuits.get(i).getNom());
					//ensuite on enregistre les circuits indépendament
					m_listeCircuits.get(i).enregistrerCircuitF();
				}
			fichierSortie.close(); 
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
		
		

	}
}