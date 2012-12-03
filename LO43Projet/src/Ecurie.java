class Ecurie {
	public Ecurie() {
		m_nom = "";
		m_vTherm = new Voiture();
		m_vElec = new Voiture();
		m_vHybride = new Voiture_hybride();
	}
	
	public Ecurie(String nom, Voiture vTherm, Voiture vElec, Voiture_hybride vHybride) {
		m_nom = nom;
		m_vTherm = vTherm;
		m_vElec = vElec;
		m_vHybride = vHybride;
	}
	
	/************* Accesseurs **************/
	public String getNom()
	{
		return m_nom;
	}
	public Voiture getVTherm() 
	{
		return m_vTherm;
	}

	public Voiture getVElec()
	{
		return m_vElec;
	}
	
	public Voiture_hybride getVHybride()
	{
		return m_vHybride;
	}
	
	/************* Mutateurs ***************/
	public void setNom(String nom)
	{
		m_nom = nom;
	}
	public void setVTherm(Voiture v) 
	{
		m_vTherm = v;
	}

	public void setVElec(Voiture v)
	{
		m_vElec = v;
	}
		
	public void setVHybride(Voiture_hybride v)
	{
		m_vHybride = v;
	}
	
		
	private String m_nom;
	private Voiture m_vTherm;
	private Voiture m_vElec;
	private Voiture_hybride m_vHybride;
}