public class Voiture {
	private String m_nom;
	private float m_autonomieMax;
	private float m_autonomie;
	private float m_vMax;
	private float m_conso;
	private float m_tpsArretStand;
	
	
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

	public float getTpsArretStand() {
		return m_tpsArretStand;
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

	public void setTpsArretStand(float tpsArretStand) {
		m_tpsArretStand = tpsArretStand;
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
