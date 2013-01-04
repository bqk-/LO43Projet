import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Voiture {
	private String m_nom;
	private float m_capaciteReservoir;
	private float m_vMax;
	private float m_consoVMax;
	private int m_tempsPlein;
	
	private float m_reservoirActuel;
	private float m_tempsCourse;
	private float m_consoCircuit;
	private float m_minVitesses;
	
	/** Constructeurs **/
	public Voiture()
	{
		m_nom = "";
		m_capaciteReservoir = 0;
		m_vMax = 0;
		m_consoVMax = 0;
		m_tempsPlein = 0;
	
		m_reservoirActuel = 0;
		m_tempsCourse = 0;
		m_consoCircuit = 0;
		m_minVitesses = 0;
	}
	
	public Voiture(String nom, float capaciteReservoir, int vMax, float consoVMax, int tempsPlein)
	{
		m_nom = nom;
		m_capaciteReservoir = capaciteReservoir;
		m_vMax = vMax;
		m_consoVMax = consoVMax;
		m_tempsPlein = tempsPlein;
		
		m_reservoirActuel = 0;
		m_tempsCourse = 0;
		m_consoCircuit = 0;
		m_minVitesses = 0;
	}
	
	public Voiture(String nomFichier)
	{
		String fichier="Voitures/"+nomFichier+".voi";
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			
			m_nom = br.readLine();
			m_vMax = Float.parseFloat(br.readLine());
			m_tempsPlein = Integer.parseInt(br.readLine());
			m_capaciteReservoir = Float.parseFloat(br.readLine());
			m_consoVMax = Float.parseFloat(br.readLine());
				
			br.close();
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		
		m_reservoirActuel = 0;
		m_tempsCourse = 0;
		m_consoCircuit = 0;
		m_minVitesses = 0;
	}

	/** Accesseurs **/
	public String getNom() {
		return m_nom;
	}

	public float getCapaciteReservoir() {
		return m_capaciteReservoir;
	}

	public float getReservoirActuel() {
		return m_reservoirActuel;
	}

	public float getConsoVMax() {
		return m_consoVMax;
	}

	public int getTempsPlein() {
		return m_tempsPlein;
	}

	public float getTempsCourse() {
		return m_tempsCourse;
	}
	
	public float getVMax() {
		return m_vMax;
	}

	public float getConsoCircuit() {
		return m_consoCircuit;
	}
	
	public float getMinVitesses() {
		return m_minVitesses;
	}

	/** Mutateurs **/
	public void setNom(String nom) {
		m_nom = nom;
	}

	public void setCapaciteReservoir(float capaciteReservoir) {
		m_capaciteReservoir = capaciteReservoir;
	}

	public void setReservoirActuel(float reservoirActuel) {
		m_reservoirActuel = reservoirActuel;
	}

	public void setConsoVMax(float consoVMax) {
		m_consoVMax = consoVMax;
	}

	public void setTempsPlein(int tempsPlein) {
		m_tempsPlein = tempsPlein;
	}

	public void setTempsCourse(float tempsCourse) {
		m_tempsCourse = tempsCourse;
	}
	
	public void setVMax(float vMax) {
		m_vMax = vMax;
	}

	public void setMinVitesses(float minVitesses) {
		m_minVitesses = minVitesses;
	}
	
	public void setConsoCircuit(float consoCircuit) {
		m_consoCircuit = consoCircuit;
	}
	


	/** Méthodes **/	
	public void simulerCourse(Circuit c)
	{
		preparationCourse(c);
		
		for (int tour = 1; tour <= c.getNbTours(); tour++)
		{
			if (autonomieRestante() > c.getPosStand() && autonomieRestante() < c.getLongueur()+c.getPosStand())
			{
				if (!(tour == c.getNbTours() && autonomieRestante() < c.getLongueur()))
				{					
					arretStand(c, tour-1);
				}
			}
			
			parcourirTour(c);
		}
	}

	public void arretStand(Circuit c, int tour)
	{
		float autonomieNecessaire = (c.getNbTours()-tour)*c.getLongueur();
		float autonomiePlein = (m_capaciteReservoir/m_consoCircuit)*100000;
		float tauxRestantReservoir = m_reservoirActuel/m_capaciteReservoir;
		float tauxARemplir;
		
		if (autonomieNecessaire < autonomiePlein)
		{	
			tauxARemplir = (autonomieNecessaire-autonomieRestante())/autonomiePlein;
			m_reservoirActuel += Math.ceil(tauxARemplir*m_capaciteReservoir);
			m_tempsCourse += Math.ceil(tauxARemplir*m_tempsPlein);
		}
		else
		{
			tauxARemplir = 1-tauxRestantReservoir;
			m_reservoirActuel += tauxARemplir*m_capaciteReservoir;
			m_tempsCourse += tauxARemplir*m_tempsPlein;
		}
	}

	public void preparationCourse(Circuit c)
	{
		m_reservoirActuel = m_capaciteReservoir;
		m_tempsCourse = 0;
		
		if (c.getVMax() < m_vMax)
		{
			m_minVitesses = (float) (c.getVMax()/3.6);
			m_consoCircuit = (float)(c.getVMax()/m_vMax)*m_consoVMax;
		}
		else
		{
			m_consoCircuit = m_consoVMax;
			m_minVitesses = (float) (m_vMax/3.6);
		}
	}
	
	public float autonomieRestante()
	{
		return m_reservoirActuel/m_consoCircuit*100000;
	}
	
	public void parcourirTour(Circuit c)
	{
		m_reservoirActuel -= m_consoCircuit*c.getLongueur()/100000;
		m_tempsCourse += c.getLongueur()/m_minVitesses;
	}
	
	public String afficherTemps(float temps)
	{
		int heures = (int) (temps/3600);
		int minutes = (int) (temps/60)%60;
		int secondes = (int) (temps % 60);
		return new String(heures + ":" + minutes + ":" + secondes);
	}

}
	
	