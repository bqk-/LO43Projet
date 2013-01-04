import java.io.*;


public class Circuit implements Cloneable
{
	private String m_nom; 
	private int m_vMax;
	private int m_longueur;
	private int m_posStand;
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
	public Circuit(String nom, int vMax, int longueur, int posStand, int nbTours)
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
	
	public Circuit(String nomFichier)
	{
		String fichier="Circuits/"+nomFichier+".cir";
		try{
			InputStream ips = new FileInputStream(fichier); 
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			
			m_nom = br.readLine();
			m_longueur = Integer.parseInt(br.readLine());
			m_posStand = Integer.parseInt(br.readLine());
			m_vMax = Integer.parseInt(br.readLine());
			m_nbTours = Integer.parseInt(br.readLine());

			br.close();
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	/************* Accesseurs **************/
	public String getNom() {
		return m_nom;
	}

	public int getVMax() {
		return m_vMax;
	}

	public int getLongueur() {
		return m_longueur;
	}

	public int getPosStand() {
		return m_posStand;
	}

	public int getNbTours() {
		return m_nbTours;
	}

	/************* Mutateurs ***************/
	public void setNom(String nom) {
		m_nom = nom;
	}

	public void setVMax(int vMax) {
		m_vMax = vMax;
	}

	public void setLongueur(int longueur) {
		m_longueur = longueur;
	}

	public void setPosStand(int posStand) {
		m_posStand = posStand;
	}

	public void setNbTours(int nbTours) {
		m_nbTours = nbTours;
	}
	
	public void setGlobal(String nom, int vMax, int longueur, int posStand, int nbTours)
	{
		m_nom = nom;
	    m_vMax = vMax;
	    m_longueur = longueur;
	    m_posStand = posStand;
	    m_nbTours = nbTours;
	}
	
	/*********** gestion de Fichiers ***********/

	public void enregistrerCircuitF()
	{
		//Chemin relatif ou on enregistre le fichier
		String fichier="Circuits/"+m_nom+".txt";
		
		try {
			FileWriter fw = new FileWriter (fichier);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter fichierSortie = new PrintWriter (bw); 
				//On écrit les variables, une par ligne
				fichierSortie.println (m_nom+"\n"+m_longueur+"\n"+m_posStand+"\n"+m_vMax+"\n"+m_nbTours); 
			fichierSortie.close(); 
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
	}

}