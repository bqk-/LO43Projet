import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Voiture {
	private String m_nom;
	private float m_autonomieMax;
	private float m_autonomie;	//distance avant de tomber en panne
	private float m_vMax; //en km/h
	private float m_conso;  //=distanceCalcul
	private float m_tauxRemplissage; //s/m combien de temps il faut pour remplir pour un metre
	private Temps m_tempsArretStand; // Combien de temps la voiture c'est arrété au stand. Dans le cas de la voiture hybride je n'utilse que celle du moteur therm
	private float m_tempsSec;
	private float m_distanceCalcul; //Distance de calcul de la conso. Dans le cas de la voiture hybride je n'utilse que celle du moteur therm
	private float m_distanceActuelle; //position de la voiture en mêtre
	
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
		m_tempsSec=0;
		m_distanceCalcul = 0;
		m_distanceActuelle=0;
	}
	public Voiture(String fileName, String ext)
	{
		String fichier="Voitures/"+fileName+"."+ext;
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			ligne=br.readLine();
			m_nom=ligne;
			//on récupère le reste du bordel
			ligne=br.readLine();
			m_autonomieMax=Float.parseFloat(ligne);
			ligne=br.readLine();
			m_autonomie=Float.parseFloat(ligne);
			ligne=br.readLine();
			m_vMax=Float.parseFloat(ligne);
			ligne=br.readLine();
			m_conso=Float.parseFloat(ligne);
			ligne=br.readLine();
			m_tauxRemplissage=Float.parseFloat(ligne);
			ligne=br.readLine();
			m_tempsArretStand=new Temps(Float.parseFloat(ligne));
			ligne=br.readLine();
			m_tempsSec=Float.parseFloat(ligne);
			ligne=br.readLine();
			m_distanceCalcul=Float.parseFloat(ligne);
			ligne=br.readLine();
			m_distanceActuelle=Float.parseFloat(ligne);
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	/*par valeurs*/
	public Voiture (String a, float b, float c, float d, float e, float f, Temps g, float h, float i, float j)
	{
		m_nom = this.filtreNom(a);
		m_autonomieMax = b;
		m_autonomie = c;
		m_vMax = d;
		m_conso = h;
		m_tauxRemplissage = f;
		m_tempsArretStand = g;
		m_tempsSec=h;
		m_distanceCalcul = i;
		m_distanceActuelle = j;
	}
	
	/*par recopie*/
	public Voiture(Voiture v)
	{
		m_nom = v.m_nom;
		m_autonomieMax = v.m_autonomieMax;
		m_autonomie = v.m_autonomie;
		m_vMax = v.m_vMax;
		m_conso = v.m_distanceCalcul;
		m_tauxRemplissage = v.m_tauxRemplissage;
		m_tempsArretStand=v.m_tempsArretStand;
		m_tempsSec=v.m_tempsSec;
		m_distanceCalcul = v.m_distanceCalcul;
		m_distanceActuelle = v.m_distanceActuelle;
	
	
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
	
	public float getTempsSec()
	{
		return m_tempsSec;
	}

	public float getDistanceCalcul() {
		return m_distanceCalcul;
	}


	public float getDistanceActuelle() {
		return m_distanceActuelle;
	}



	/*************** Mutateurs ***************/
	public void setNom(String nom) {
		m_nom = this.filtreNom(nom);
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
		m_tempsSec=tps.getTps();
	}
	public void setTempsSec(float tps)
	{
		m_tempsSec=tps;
		m_tempsArretStand=new Temps(m_tempsSec);
	}
	public void setDistanceCalcul(float distanceCalcul) {
		this.m_distanceCalcul = distanceCalcul;
	}
	
	public void setDistanceActuelle(float m_distanceActuelle) {
		this.m_distanceActuelle = m_distanceActuelle;
	}

	public String filtreNom(String nom)
	{
		// remplacer tout sauf les lettres et les chiffres par rien
		return nom.replaceAll("\\W","");
	}
	
/** méthode arret stand**/ //J ai triché car je ne prend pas en compte l autonomie qui restait dans le réservoir
	public Temps arretStand(Circuit c)
	{
		Temps tpsTotal = new Temps();
		if((c.getLongueur()*c.getNbTours()-m_distanceActuelle) > m_autonomieMax) // Distance restante avant la fin de la course
		{
			this.remplirReservoir(100);
			tpsTotal.setTps((int)(m_autonomie*m_tauxRemplissage));
		}
		else
		{
			this.remplirReservoir((100*(c.getLongueur()*c.getNbTours()-m_distanceActuelle))/m_autonomieMax);
			tpsTotal.setTps((int)(m_autonomie*m_tauxRemplissage));
		}
		
		tpsTotal.setTps(tpsTotal.getTps());
		return tpsTotal;
	}
	
/** méthode parcourirCircuit (renvoie le temps qu'a mis la voiture pour parcours le circuit **/
	public Temps parcourirCircuit(Circuit c)
	{
		m_distanceActuelle =0;
		m_autonomie = m_autonomieMax;
		boolean prevoirArretStand = false;
		Temps tempsTour = new Temps();
		Temps tempsTotal = new Temps();
		
		for(int i=1 ; i <= c.getNbTours() ; i++)		//fait les tours
		{

			for(float f=0; f < c.getLongueur(); f+=m_distanceCalcul)		//pendant un tour calcule l autonomie tout les 50 m
			{

				if(m_autonomie <= (c.getLongueur()) && (i != c.getNbTours())) //si l'autonomie de la voiture n est pas suffisante pour faire un tour on programme un arret au stand et si ce n'est pas le dernier tour
				{
					prevoirArretStand = true;
				}
				
				//si on doit s arreter au stand ...
				if((prevoirArretStand == true) && (Math.abs(c.getPosStand()-f)<= m_distanceCalcul))
				{
					float f1 = f;
					f = c.getPosStand();//je crois que c'est inutile
					m_distanceActuelle += (c.getPosStand()-f1);

					m_tempsArretStand = this.arretStand(c);
					
					prevoirArretStand = false;
					f = f1 + m_distanceCalcul; 
					m_distanceActuelle += (f-c.getPosStand());

				}
				
				m_autonomie -= m_conso;
				m_distanceActuelle += m_distanceCalcul;
			}

			//temps pour un tour
			tempsTour.calculTempsTour(this, c);
	
			tempsTotal.setTps(tempsTotal.getTps()+tempsTour.getTps());
			
			m_tempsArretStand.setTps(0);
		
		}
		
		return tempsTotal;
	}
	
/** méthode remplirReservoir **/
	public void remplirReservoir (float pourcentage)
	{
		m_autonomie = (m_autonomieMax * pourcentage) / 100;
	}
	
	public void enregistrerVoitureF(String ext)
	{
		//Chemin relatif ou on enregistre le fichier
		String fichier="Voitures/"+m_nom+"."+ext;
		
		try {
			FileWriter fw = new FileWriter (fichier);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter fichierSortie = new PrintWriter (bw); 
				//On écrit les variables, une par ligne
				fichierSortie.println (m_nom+"\n"+m_autonomieMax+"\n"+m_autonomie+"\n"+m_vMax+"\n"+m_conso+"\n"+m_tauxRemplissage+"\n"+m_tempsArretStand+"\n"+m_tempsSec+"\n"+m_distanceCalcul+"\n"+m_distanceActuelle+"\n"); 
			fichierSortie.close(); 
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	
}
	
	