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
		m_nom = "";
		m_listeCircuits = null;
	}
	
	/** Constructeur par valeurs **/
	public Saison(String nom, ArrayList<Circuit> listeCircuits)
	{     
	    m_nom = nom;
	    m_listeCircuits = listeCircuits;
	}
	
	public Saison(String filename)
	{   
		
		String fichier="Saisons/"+filename+".sai";
		try{
			int i;
			
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			m_nom=br.readLine();

			m_listeCircuits = new ArrayList<Circuit>();
			m_listeCircuits.ensureCapacity(Integer.parseInt(br.readLine()));
			
			for(i=0;i<m_listeCircuits.size();i++)
			{
				m_listeCircuits.set(i, new Circuit(br.readLine()));
			}
			
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}

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
	public void enregistrerSaisonF()
	{
		String fichier="Saisons/"+m_nom+".txt";
	
		try {
			int i;
			FileWriter fw = new FileWriter (fichier);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter fichierSortie = new PrintWriter (bw);
			
			fichierSortie.println (m_nom+"\n"+m_listeCircuits.size()); 
			
			for(i=0;i<m_listeCircuits.size();i++)
			{
				fichierSortie.println (m_listeCircuits.get(i).getNom());
				m_listeCircuits.get(i).enregistrerCircuitF();
			}
			
			fichierSortie.close(); 
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
}