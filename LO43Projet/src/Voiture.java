public class Voiture {
	private String m_nom;
	private float m_autonomieMax;
	private float m_autonomie;
	private float m_vMax;
	private float m_conso;
	private float m_tauxRemplissage; // s/L combien de temps il faut pour remplir un litre (ou équivalent pour moteur éléctrique)
	
	/********* Constructeurs **********/
	/* Par défault*/
	public Voiture()
	{
		m_nom = "";
		m_autonomieMax = 0;
		m_autonomie = 0;
		m_vMax =0;
		m_conso = 0;
		m_tauxRemplissage = 0;
	}
	
	/*par valeurs*/
	public Voiture (String a, float b, float c, float d, float e, float f)
	{
		m_nom = a;
		m_autonomieMax = b;
		m_autonomie = c;
		m_vMax = d;
		m_conso = e;
		m_tauxRemplissage = f;
	}
	
	/*par recopie*/
	public Voiture(Voiture v)
	{
		m_nom = v.m_nom;
		m_autonomieMax = v.m_autonomieMax;
		m_autonomie = v.m_autonomie;
		m_vMax = v.m_vMax;
		m_conso = v.m_conso;
		m_tauxRemplissage = v.m_tauxRemplissage;
	
	}
	
	
	/************* Accesseurs **************/
	public String getNom() {
		return m_nom;
	}

	public float getAutonomieMax() {
		return m_autonomieMax;
	}

	public float getAutonomie() {
		return m_autonomie;
	}

	public float getVMax() {
		return m_vMax;
	}

	public float getConso() {
		return m_conso;
	}

	public float gettauxRemplissaged() {
		return m_tauxRemplissage;
	}

	
	/*************** Mutateurs ***************/
	public void setNom(String nom) {
		m_nom = nom;
	}

	public void setAutonomieMax(float autonomieMax) {
		m_autonomieMax = autonomieMax;
	}

	public void setAutonomie(float autonomie) {
		m_autonomie = autonomie;
	}

	public void setVMax(float vMax) {
		m_vMax = vMax;
	}

	public void setConso(float conso) {
		m_conso = conso;
	}

	public void settauxRemplissage(float tauxRemplissage) {
		m_tauxRemplissage = tauxRemplissage;
	}
	
	
/** méthode arret stand**/
	public void arretStand()
	{
		
	}
	
/** méthode parcourirTour **/
	public void parcourirTour()
	{
		
	}
	
/** méthode remplirReservoir **/
	public void remplirReservoir ()
	{
		
	}
	
/** méthode remplirPartiellementReservoir **/
	public void remplirPartiellementReservoir(float f)
	{
		
	}
	
/** methode consomation par tour **/
	public void conso (Circuit c)
	{
		
	}

	public void rechargePartielleBatterie()
	{
	
	}
}
