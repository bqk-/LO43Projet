
public class Voiture {
	private String m_nom;
	private float m_autonomieMax;
	private float m_autonomie;
	private float m_vMax;
	private float m_conso;  //L/50m
	private float m_tauxRemplissage; // s/L combien de temps il faut pour remplir un litre (ou équivalent pour moteur éléctrique)
	private Temps m_tempsArretStand; // Combien de temps la voiture c'est arrété au stand
	
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
		m_tempsArretStand = new Temps();
	}
	
	/*par valeurs*/
	public Voiture (String a, float b, float c, float d, float e, float f, Temps g)
	{
		m_nom = a;
		m_autonomieMax = b;
		m_autonomie = c;
		m_vMax = d;
		m_conso = e;
		m_tauxRemplissage = f;
		m_tempsArretStand = g;
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
		m_tempsArretStand=v.m_tempsArretStand;
	
	
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

	public float getTauxRemplissage() {
		return m_tauxRemplissage;
	}

	public Temps getTempsArretStand()
	{
		return m_tempsArretStand;
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

	public void setTauxRemplissage(float tauxRemplissage) {
		m_tauxRemplissage = tauxRemplissage;
	}
	
	public void setTempsArretStand(Temps tps)
	{
		m_tempsArretStand=tps;
	}
	
	
/** méthode arret stand**/
	public Temps arretStand()
	{
		Temps tpsTotal = new Temps();
		
	}
	
/** méthode parcourirCircuit (renvoie le tempss qu'a mis la voiture pour parcours le circuit **/
	public Temps parcourirCircuit(Circuit c)
	{
		m_autonomie = m_autonomieMax;
		boolean prevoirArretStand = false;
		Temps tempsArretStand = new Temps();
		Temps tempsTour = new Temps();
		Temps tempsTotal = new Temps();
		
		for(int i=0 ; i < c.getNbTours() ; i++)		//fait les tours
		{
			
			for(float f=0; f < c.getLongueur(); f+=50)		//pendant un tour calcule l autonomie tout les 50 m
			{
				f += 50;
				m_autonomie -= m_conso;
				//j ai besoin de connaître l'unité de la longueur du tour pour le test en dessous
				if(m_autonomie <= (c.getLongueur()*m_conso)) //si l'autonomie de la voiture n est pas suffisante pour faire un tour on programme un arret au stand
				{
					prevoirArretStand = true;
				}
				
				//si on doit s arreter au stand ...
				if((prevoirArretStand == true) && (f==c.getPosStand()))
				{
					tempsArretStand = this.arretStand();
					prevoirArretStand = false;
					
				}
			}
			//temps pour un tour
			tempsTour.calculTempsTour(this, c);

			//itération du temps total
			tempsTotal.setTps(tempsTotal.getTps()+tempsTour.getTps());
		
		}
		
		return tempsTotal;
	}
	
/** méthode remplirReservoir **/
	public void remplirReservoir (int pourcentage)
	{
		m_autonomie = (m_autonomieMax * pourcentage) / 100;
	}
	
/** méthode remplirPartiellementReservoir pas besoin **/
	/*public void remplirPartiellementReservoir(float f)
	{
		
	}*/
	
/** methode consomation par tour **/
	/*public void conso (Circuit c)
	{
		
	}*/
	//Même chose que remplir reservoir
	/*public void rechargePartielleBatterie()
	{
	
	}*/
}
