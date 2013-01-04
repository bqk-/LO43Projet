import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Voiture_hybride {
	private String m_nom;
	private Voiture m_motTherm;
	private Voiture m_motElec;
	private int m_motActuel; //0=thermique, 1=electrique
	
	
	/************* Constructeurs **************/
	/** Constructeur par défaut **/
	public Voiture_hybride()
	{
		m_nom = "";
		m_motTherm = new Voiture();
		m_motElec = new Voiture();
		m_motActuel = 0;
	}
	
	public Voiture_hybride(String nomFichier)
	{
		String fichier="Voitures/"+nomFichier+".vhy";
		m_motTherm = new Voiture();
		m_motElec = new Voiture();
		
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			
			m_nom = br.readLine();
			m_motTherm.setVMax(Float.parseFloat(br.readLine()));
			m_motTherm.setTempsPlein(Integer.parseInt(br.readLine()));
			m_motTherm.setCapaciteReservoir(Float.parseFloat(br.readLine()));
			m_motTherm.setConsoVMax(Float.parseFloat(br.readLine()));
			m_motElec.setVMax(Float.parseFloat(br.readLine()));
			m_motElec.setTempsPlein(Integer.parseInt(br.readLine()));
			m_motElec.setCapaciteReservoir(Float.parseFloat(br.readLine()));
			m_motElec.setConsoVMax(Float.parseFloat(br.readLine()));
				
			br.close();
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	/** Constructeur par valeurs **/
	public Voiture_hybride(String nom, Voiture vTherm, Voiture vElec)
	{
		m_nom = nom;
		m_motTherm = vTherm;
		m_motElec = vElec;
		m_motActuel = 0;
	}
	
	/** Contructeur par recopie **/
	public Voiture_hybride(Voiture_hybride v)
	{
		m_nom = v.m_nom;
		m_motTherm = v.m_motTherm;
		m_motElec = v.m_motElec;
		m_motActuel = 0;
	}
	
	/************* Accesseurs **************/
	public String getNom()
	{
		return m_nom;
	}
	
	public Voiture getMotTherm()
	{
		return m_motTherm;
	}
	
	public Voiture getMotElec()
	{
		return m_motElec;
	}
	public int getMotActuel()
	{
		return m_motActuel;
	}
	public float getTempsCourse()
	{
		return m_motTherm.getTempsCourse()+m_motElec.getTempsCourse();
	}
	
	/*************** Mutateurs ***************/
	public void setNom(String nom)
	{
		m_nom = nom;
	}
	
	public void setMotTherm(Voiture motTherm)
	{
		m_motTherm = motTherm;
	}
	
	public void setMotElec(Voiture motElec)
	{
		m_motElec = motElec;
	}
	
	public void setMotActuel(int i)
	{
		m_motActuel = i;
	}
	
	
	/*************** Méthodes *****************/
	public void switcherMoteur()
	{
		if (m_motActuel == 0)
		{
			m_motActuel = 1;
		}
		else
		{
			m_motActuel = 0;
		}
	}

	public void simulerCourse(Circuit c)
	{
		Voiture motUtilise = m_motElec;
		Voiture motArrete = m_motTherm;
		preparationCourse(c, m_motTherm);
		preparationCourse(c, m_motElec);
		m_motActuel = 1;
		
		for (int tour = 1; tour <= c.getNbTours(); tour++)
		{
			if (motUtilise.autonomieRestante() < c.getLongueur()+c.getPosStand())
			{
				if (!(tour == c.getNbTours() && motUtilise.autonomieRestante() > c.getLongueur()))
				{
					if (motArrete.autonomieRestante() > c.getLongueur()+c.getPosStand())
					{
						switcherMoteur();
						Voiture tmp = motUtilise;
						motUtilise = motArrete;
						motArrete = tmp;
					}
					else
					{
						arretStand(c, tour-1);
					}
				}
			}
			
			parcourirTour(motUtilise, c);
		}
	}

	public void remplirReservoir(Voiture v, float pourcentage)
	{
		if (pourcentage + (v.getReservoirActuel()/v.getCapaciteReservoir()) == 1)
		{
			v.setReservoirActuel((float) (Math.ceil(pourcentage*v.getCapaciteReservoir())));
		}
		else
		{
			v.setReservoirActuel((float) (v.getReservoirActuel()+Math.ceil(pourcentage*v.getCapaciteReservoir())));
		}
		v.setTempsCourse((float) (v.getTempsCourse()+Math.ceil(pourcentage*v.getTempsPlein())));		
	}
	
	public void arretStand(Circuit c, int tour)
	{
		float autonomieNecessaire = (c.getNbTours()-tour)*c.getLongueur();
		float autonomiePleinTherm = (m_motTherm.getCapaciteReservoir()/m_motTherm.getConsoCircuit())*100000;
		float autonomiePleinElec = (m_motElec.getCapaciteReservoir()/m_motElec.getConsoCircuit())*100000;
		float autonomiePlein = (float) (autonomiePleinTherm+autonomiePleinElec);
		float tauxRestantReservoirTherm = m_motTherm.getReservoirActuel()/m_motTherm.getCapaciteReservoir();
		float tauxRestantReservoirElec = m_motElec.getReservoirActuel()/m_motElec.getCapaciteReservoir(); 

		m_motActuel = 1;
		if (autonomieNecessaire < autonomiePlein)
		{	
			float tauxARemplirRapide;
			float tauxARemplirLent;
			float autonomiePleinRapide = autonomiePleinElec;
			float autonomiePleinLent = autonomiePleinTherm;
			float tauxRestantReservoirRapide = tauxRestantReservoirElec;
			Voiture moteurRapide = m_motElec;
			Voiture moteurLent = m_motTherm;
			
			if (m_motTherm.getVMax() >= m_motElec.getVMax())
			{
				moteurRapide = m_motTherm;
				moteurLent = m_motElec;
				autonomiePleinRapide = autonomiePleinTherm;
				autonomiePleinLent = autonomiePleinElec;
				tauxRestantReservoirRapide = tauxRestantReservoirTherm;
			}
			
			tauxARemplirRapide = (float) ((autonomieNecessaire-moteurRapide.autonomieRestante())/autonomiePleinRapide);
			if (autonomiePleinRapide < autonomieNecessaire)
			{
				tauxARemplirRapide = 1-tauxRestantReservoirRapide;
				autonomieNecessaire -= autonomiePleinRapide;
				
				tauxARemplirLent = (autonomieNecessaire-moteurLent.autonomieRestante())/autonomiePleinLent;
				remplirReservoir(moteurLent, tauxARemplirLent);
			}
			remplirReservoir(moteurRapide, tauxARemplirRapide);
		}
		else
		{
			float tauxARemplirTherm;
			float tauxARemplirElec;
			
			tauxARemplirTherm = 1-tauxRestantReservoirTherm;
			remplirReservoir(m_motTherm, tauxARemplirTherm);
			tauxARemplirElec = 1-tauxRestantReservoirElec;
			remplirReservoir(m_motElec, tauxARemplirElec);
		}
	}

	public void preparationCourse(Circuit c, Voiture v)
	{
		v.setReservoirActuel(v.getCapaciteReservoir());
		v.setTempsCourse(0);
		
		if (c.getVMax() < v.getVMax())
		{
			v.setMinVitesses((float) (c.getVMax()/3.6));
			v.setConsoCircuit((float)(c.getVMax()/v.getVMax())*v.getConsoVMax());
		}
		else
		{
			v.setConsoCircuit(v.getConsoVMax());
			v.setMinVitesses((float) (v.getVMax()/3.6));
		}
	}
	
	public void parcourirTour(Voiture v, Circuit c)
	{
		v.setReservoirActuel(v.getReservoirActuel()-(v.getConsoCircuit()*c.getLongueur()/100000));
		v.setTempsCourse(v.getTempsCourse()+(c.getLongueur()/v.getMinVitesses()));
		
		if (m_motActuel == 0)
		{
			m_motElec.setReservoirActuel((float) Math.min(m_motElec.getReservoirActuel(),m_motElec.getReservoirActuel()+0.2*(v.getConsoCircuit()*c.getLongueur()/100000)));
		}
	}
	
	public String afficherTemps(float temps)
	{
		int heures = (int) (temps/3600);
		int minutes = (int) (temps/60)%60;
		int secondes = (int) (temps % 60);
		String m ,s;
		if(minutes<10)
			m=new String("0"+minutes);
		else
			m=String.valueOf(minutes);
		if(secondes<10)
			s=new String("0"+secondes);
		else
			s=String.valueOf(secondes);

		
		return new String(heures + ":" + m + ":" + s);
	}

}