public class Voiture_hybride {
	
	public Voiture_hybride()
	{
		m_nom = "";
		m_motTherm = new Voiture();
		m_motElec = new Voiture();
		m_motActuel = m_motTherm;
	}
	
	public Voiture_hybride(String nom, Voiture vTherm, Voiture vElec)
	{
		m_nom = nom;
		m_motTherm = vTherm;
		m_motElec = vElec;
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
	
	public void rechargeBatterie()
	{
		if (m_motActuel == m_motTherm)
		{
			m_motTherm.rechargePartielleBatterie();
		}
	}
		
	private String m_nom;
	private Voiture m_motTherm;
	private Voiture m_motElec;
	private Voiture m_motActuel;
}
