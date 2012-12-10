import java.util.ArrayList;


public class Saison {
	private String m_nom;
	private int m_nbCircuits;
	private ArrayList<Circuit> m_listeCircuits;
	
	/************* Constructeurs **************/
	/** Constructeur par défaut **/
	public Saison()
	{
	    m_nom = "";
	    m_nbCircuits = 0;
	    m_listeCircuits = new ArrayList<Circuit>();
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
	    m_listeCircuits = new ArrayList<Circuit>(s.m_nbCircuits);
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
}