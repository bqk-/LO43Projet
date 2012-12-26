import java.io.*;


public class Circuit implements Cloneable
{
	private String m_nom; 
	private float m_vMax;
	private float m_longueur;
	private float m_posStand;
	private int m_nbTours;
	int var;
	
	/************* Constructeurs **************/
	/** Constructeur par défaut **/
	public Circuit()
	{
	    m_nom = "";
	    m_vMax = 0;
	    m_longueur = 0;
	    m_posStand = 0;
	    m_nbTours = 0;
	} 
	
	/** Constructeur par valeurs **/
	public Circuit(String nom, float vMax, float longueur, float posStand, int nbTours)
	{
		m_nom = nom;
	    m_vMax = vMax;
	    m_longueur = longueur;
	    m_posStand = posStand;
	    m_nbTours = nbTours;
	}
	/** Contructeur par recopie **/
	public Circuit(Circuit v)
	{
		m_nom = v.m_nom;
	    m_vMax = v.m_vMax;
	    m_longueur = v.m_longueur;
	    m_posStand = v.m_posStand;
	    m_nbTours = v.m_nbTours;
	}
	
	/************* Accesseurs **************/
	public String getNom() {
		return m_nom;
	}

	public float getVMax() {
		return m_vMax;
	}

	public float getLongueur() {
		return m_longueur;
	}

	public float getPosStand() {
		return m_posStand;
	}

	public int getNbTours() {
		return m_nbTours;
	}

	/************* Mutateurs ***************/
	public void setNom(String nom) {
		m_nom = nom;
	}

	public void setVMax(float vMax) {
		m_vMax = vMax;
	}

	public void setLongueur(float longueur) {
		m_longueur = longueur;
	}

	public void setPosStand(float posStand) {
		m_posStand = posStand;
	}

	public void setNbTours(int nbTours) {
		m_nbTours = nbTours;
	}
	
	public void setGlobal(String nom, float vMax, float longueur, float posStand, int nbTours)
	{
		m_nom = nom;
	    m_vMax = vMax;
	    m_longueur = longueur;
	    m_posStand = posStand;
	    m_nbTours = nbTours;
	}
	
	/*********** gestion de Fichiers ***********/
	/*On suppose que les fichiers écrit respectent la syntaxe établie :
	  -dans un dossier du même nom que la classe
	  -nom_de_l'objet.txt
	  -les variables sont entrées une par ligne, dans l'ordre définit plus haut
	 */
	
	public void lireCircuitF(String nomFichier)
	{
		//le chemin relatif ou se trouve le fichier
		String fichier="Circuits/"+nomFichier+".txt";
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			//On récupère le nom du circuit
			ligne=br.readLine();
			m_nom=ligne;
			//on récupère et reformate sa vitesse maximale
			ligne=br.readLine();
			m_vMax=Float.parseFloat(ligne);
			// ainsi de suite ...
			ligne=br.readLine();
			m_longueur=Float.parseFloat(ligne);
			ligne=br.readLine();
			m_posStand=Float.parseFloat(ligne);
			ligne=br.readLine();
			m_nbTours=Integer.parseInt(ligne);
			

			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void enregistrerCircuitF()
	{
		//Chemin relatif ou on enregistre le fichier
		String fichier="Circuits/"+m_nom+".txt";
		
		try {
			FileWriter fw = new FileWriter (fichier);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter fichierSortie = new PrintWriter (bw); 
				//On écrit les variables, une par ligne
				fichierSortie.println (m_nom+"\n"+m_vMax+"\n"+m_longueur+"\n"+m_posStand+"\n"+m_nbTours); 
			fichierSortie.close(); 
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	/*********** Méthodes ***********/
	public Circuit clone()
	{
		
	    Circuit circuit= new Circuit();
	    
	    try
	    {
	      	circuit = (Circuit) super.clone();
	    }
	    catch(CloneNotSupportedException cnse)
	    {
	      	cnse.printStackTrace(System.err);
	    }

	    return circuit;
	}
	
	public String filtreNom(String nom)
	{
		// remplacer tout sauf les lettres et les chiffres par rien
		return nom.replaceAll("\\W","");
	}
	
	public Float filtreLongueur(Float variable)
	{
		if(variable <0)
			variable=-1*variable;
		return variable;
	}
}