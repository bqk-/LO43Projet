public class Temps {

	private float m_tps; //en secondes ; il s agit d'un float car des calculs renvoient float
	
	/**Constructeurs**/
	/*par défault*/
	public Temps() {
		m_tps=0;
	}
	
	/*par valeur*/
	public Temps(float tps) {
	
		m_tps=tps;
	}
	
	/* par recopie*/
	public Temps (Temps tps) {
		m_tps = tps.m_tps;
	}
	
	/** Accesseur**/
	public float getTps() {
		return m_tps;
	}
	
	/**Mutateur**/
	public void setTps (float tps) {
		m_tps=tps;
	}
	
	/**méthode toString **/
	public String toString() {
		float tps = m_tps;
		float heures;
		float minutes;
		float secondes;
		String str ="";
		
		secondes = tps % 60;
		tps /= 60;
		minutes = tps % 60;
		heures = tps / 60;
		
		str = heures + " h : " + minutes + " min : " + secondes + " s";
		return str;
		
	}
	
	/**méthode calculTempsTour (probleme (ou pas en fait): l'instance Temps est crée dans la méthode **/
	public void calculTempsTour (Voiture v, Circuit c) {
		
		//Temps tpsTour = new Temps();
		
		this.setTps(Math.min(v.getVMax(), c.getVMax()) * c.getLongueur());
		this.m_tps += v.getTempsArretStand().getTps();
		
		//return tpsTour;
		
	}
	
}
