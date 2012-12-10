
public class Circuit {
	private String m_nom; 
	private float m_vMax;
	private float m_longueur;
	private float m_posStand;
	private int m_nbTours;
	
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
}