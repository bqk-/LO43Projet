import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Voiture_hybride {
	private String m_nom;
	private Voiture m_motTherm;
	private Voiture m_motElec;
	private Voiture m_motActuel;
	/*Les éléments comme la distance de Calcul de la conso, la distance déjà parcouru et le 
	 * temps d arret au stand sont stocké dans motTherm
	 */
	
	
	/************* Constructeurs **************/
	/** Constructeur par défaut **/
	public Voiture_hybride()
	{
		m_nom = "";
		m_motTherm = new Voiture();
		m_motElec = new Voiture();
		m_motActuel = m_motTherm;
	}
	public Voiture_hybride(String fileName)
	{
		String fichier="Voitures/"+fileName+".vty";
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			ligne=br.readLine();
			m_nom=ligne;
			//on récupère le reste du bordel
			ligne=br.readLine();
			m_motTherm=new Voiture(ligne);
			ligne=br.readLine();
			m_motElec=new Voiture(ligne);
			ligne=br.readLine();
			m_motActuel=new Voiture(ligne);
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
		m_motActuel = m_motTherm;
	}
	
	/** Contructeur par recopie **/
	public Voiture_hybride(Voiture_hybride v)
	{
		m_nom = v.m_nom;
		m_motTherm = v.m_motTherm;
		m_motElec = v.m_motElec;
		m_motActuel = m_motTherm;
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
	
	/*************** Mutateurs ***************/
	public void setNom(String nom)
	{
		m_nom = nom;
	}
	
	public void setMotTherm(Voiture v)
	{
		m_motTherm = v;
	}
	
	public void setMotElec(Voiture v)
	{
		m_motElec = v;
	}
	
	public void setMotActuel(Voiture v)
	{
		m_motTherm = v;
	}
	
	
	/*************** Méthodes *****************/
	public void switcherMoteur()
	{
		if (m_motActuel == m_motTherm)
		{
			m_motActuel = m_motElec;
		}
		else
		{
			m_motActuel = m_motTherm;
		}
	}

		
	/**méthode arretstand hybride**/
	public Temps arretStandHyb(Circuit c)
	{
		Temps tpsTotal = new Temps();
		
		
		if(((c.getLongueur()*c.getNbTours())-m_motTherm.getDistanceActuelle()) > (m_motTherm.getAutonomieMax()+m_motElec.getAutonomieMax())) // si Distance restante avant la fin de la course est plus petit que l'autonomie max de la voiture hyb
		{
			//on remplis à fond
			m_motTherm.remplirReservoir(100);
			m_motElec.remplirReservoir(100);
			tpsTotal.setTps((int)((m_motTherm.getAutonomie()*m_motTherm.getTauxRemplissage())+(m_motElec.getAutonomie()*m_motElec.getTauxRemplissage())));
			
			
		}
		else
		{
			if((c.getLongueur()*c.getNbTours()-m_motTherm.getDistanceActuelle()) < m_motTherm.getAutonomie())//si le moteur thermique suffit à finir la course
			{
				
				m_motTherm.remplirReservoir((100*(c.getLongueur()*c.getNbTours()-m_motTherm.getDistanceActuelle()))/m_motTherm.getAutonomieMax());
				tpsTotal.setTps((int)((m_motTherm.getAutonomie()*m_motTherm.getTauxRemplissage())));
				

			}
			else //si le moteur thermique ne suffit pas à finir la course
			{
				/*on remplit à fond le moteur therm et relativement le moteur elec*/
				m_motTherm.remplirReservoir(100);
				
				m_motElec.remplirReservoir((100*((c.getLongueur()*c.getNbTours()-m_motTherm.getDistanceActuelle())-m_motTherm.getAutonomieMax()))/m_motElec.getAutonomieMax());
				tpsTotal.setTps((int)((m_motTherm.getAutonomie()*m_motTherm.getTauxRemplissage())+(m_motElec.getAutonomie()*m_motElec.getTauxRemplissage())));
				
			}
			
		}
		
		if (m_motActuel == m_motElec)
		{
			m_motActuel = m_motTherm;
		}
		
		tpsTotal.setTps(tpsTotal.getTps());
		return tpsTotal;
	}
	
	
	/** méthode parcourirCircuitHyb (renvoie le temps qu'a mis la voiture pour parcours le circuit **/
	public Temps parcourirCircuitHyb(Circuit c)
	{
		m_motTherm.setAutonomie( m_motTherm.getAutonomieMax());
		m_motElec.setAutonomie( m_motElec.getAutonomieMax());
		m_motTherm.setDistanceActuelle(0);
		
		boolean prevoirArretStand = false;
		float distanceTherm;	//distance parcouru sur un tour avec le mot therm (nécessairre pour le calcul du temps tour)
		float distanceElec;		//idem pour moteur elec
		Temps tempsTour = new Temps();
		Temps tempsTotal = new Temps();
		
		for(int i=1 ; i <= c.getNbTours() ; i++)		//fait les tours
		{
			distanceTherm = 0;
			distanceElec = 0;
			
			
			for(float f=0; f < c.getLongueur(); f+=m_motTherm.getDistanceCalcul())		//pendant un tour calcule l autonomie tout les distancecalcul m
			{
				
				if(m_motActuel.getAutonomie() <= (c.getLongueur())) //si l'autonomie du moteur n est pas suffisante pour faire un tour
				{
					this.switcherMoteur();
					if(m_motActuel.getAutonomie() <= (c.getLongueur()) && (i != c.getNbTours())) //si il faut s'arreter au stand et si ce n'est pas le dernier tour
					{
						prevoirArretStand = true;
					}
					this.switcherMoteur();
				}
				
				if(m_motActuel.getAutonomie() == 0) //change de moteur si panne sêche
				{
					this.switcherMoteur();
				}
				
				
				if(m_motActuel==m_motTherm) //triche : j ai la flemme de prendre en compte la distance parcouru quand on va au stand
				{
					distanceTherm += m_motTherm.getDistanceCalcul();
				}
				else
				{
					distanceElec += m_motTherm.getDistanceCalcul();
				}
				
				
				if((prevoirArretStand == true) && (Math.abs(c.getPosStand()-f)<= m_motTherm.getDistanceCalcul())) //si on a prévu un arret au stand et on est proche des stands
				{
					float f1 = f;
					f = c.getPosStand();//je sais plus si c'est vraiment utile
					
					m_motTherm.setDistanceActuelle(m_motTherm.getDistanceActuelle()+(c.getPosStand()-f1));
					
					
					m_motTherm.setTempsArretStand( this.arretStandHyb(c));
					
					
					prevoirArretStand = false;
					f = f1 + m_motTherm.getDistanceCalcul(); 
					
					m_motTherm.setDistanceActuelle( m_motTherm.getDistanceActuelle()+ (f-c.getPosStand()));
					
					
				}
				
				//on décrémente l autonomie
				m_motActuel.setAutonomie(m_motActuel.getAutonomie()-m_motActuel.getConso());
				//on note la distance actuelle
				m_motTherm.setDistanceActuelle(m_motTherm.getDistanceActuelle() + m_motTherm.getDistanceCalcul());
				
			}
			
			
			//temps pour un tour
			tempsTour.calculTempsTourHyb(this, c, distanceTherm, distanceElec);
			
			//temps total de la course jusqu'à ce point
			tempsTotal.setTps(tempsTotal.getTps()+tempsTour.getTps());
			
			
			Temps tpstmp= new Temps(0);
			m_motTherm.setTempsArretStand(tpstmp);
		

		}
		
		return tempsTotal;
	}

}