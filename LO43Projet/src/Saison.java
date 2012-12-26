import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Saison
{
	private String m_nom;
	private int m_nbCircuits;
	private ArrayList<Circuit> m_listeCircuits;
	
	/************* Constructeurs **************/
	/** Constructeur par défaut **/
	public Saison()
	{
	    m_nom = "";
	    m_nbCircuits = 0;
	    ArrayList<Circuit> m_listeCircuits = new ArrayList<Circuit>();
	} 
	
	/** Constructeur par valeurs **/
	public Saison(String nom, int nbCircuits, ArrayList<Circuit> listeCircuits)
	{     
	    m_nom = nom;
	    m_nbCircuits = nbCircuits;
	    m_listeCircuits = listeCircuits;
	}
	
		
	/** Contructeur par recopie **/
	public Saison(Saison s)
	{   
	    m_nom = s.m_nom;
	    m_nbCircuits = s.m_nbCircuits;
	    ArrayList<Circuit> m_listeCircuits = new ArrayList<Circuit>(s.m_nbCircuits);
	    int i;
	    for(i=0;i<m_nbCircuits;i++)
	    {
	    	m_listeCircuits=(ArrayList<Circuit>) s.m_listeCircuits.clone();
	    }

	}
			
	/************* Accesseurs **************/
	public String getNom()
	{  
	    return m_nom;
	}
			

	public int getNbCircuits() {
		return m_nbCircuits;
	}

	public ArrayList<Circuit> getListeCircuits() {
		return m_listeCircuits;
	}

	/*************** Mutateurs ***************/
	public void setNom(String nom)
	{  
	    m_nom=nom;
	}

	public void setNbCircuits(int nbCircuits) {
		m_nbCircuits = nbCircuits;
	}

	public void setListeCircuits(ArrayList<Circuit> listeCircuits) {
		m_listeCircuits = listeCircuits;
	}
	
	/*************** Fonctions ***************/
	public void ajoutCircuit(Circuit c)
	{
		m_listeCircuits.add(c);
		m_nbCircuits++;
	}
	
	public void removeListeCircuits(int indice)
	{
		if(indice >= 0 && indice < m_nbCircuits)
		{
			m_listeCircuits.remove(indice);
			m_nbCircuits--;
		}
	}
	
	/*********** gestion de Fichiers ***********/
	/*On suppose que les fichiers écrit respectent la syntaxe établie :
	  -dans un dossier du même nom que la classe
	  -nom_de_l'objet.txt
	  -les variables sont entrées une par ligne, dans l'ordre définit plus haut lors de la création
	 */
	
	public void lireSaisonF(String nomFichier)
	{
		int i;
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
			m_nbCircuits=Integer.parseInt(ligne);
			
			//on peut donc avec certitude ré-inserer les circuits uns par uns
			m_listeCircuits = new ArrayList<Circuit>(m_nbCircuits);
			for(i=0;i<m_nbCircuits;i++)
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
				fichierSortie.println (m_nom+"\n"+m_nbCircuits); 
				for(i=0;i<m_nbCircuits;i++)
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