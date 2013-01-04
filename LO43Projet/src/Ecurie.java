import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class Ecurie {
	private String m_nom;
	private Voiture m_vTherm;
	private Voiture m_vElec;
	private Voiture_hybride m_vHybride;
	
	/************* Constructeurs **************/
	/** Constructeur par défaut **/
	public Ecurie()
	{
		m_nom = "";
		m_vTherm = new Voiture();
		m_vElec = new Voiture();
		m_vHybride = new Voiture_hybride();
	}
	
	/** Constructeur par lecture de fichier **/
	public Ecurie(String nomFichier)
	{
		String fichier="Ecuries/"+nomFichier+".ecu";
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);

			m_nom=br.readLine();
			m_vTherm=new Voiture(br.readLine());
			m_vElec=new Voiture(br.readLine());
			m_vHybride=new Voiture_hybride(br.readLine());
			
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	/** Constructeur par valeurs **/
	public Ecurie(String nom, Voiture vTherm, Voiture vElec, Voiture_hybride vHybride)
	{
		m_nom = nom;
		m_vTherm = vTherm;
		m_vElec = vElec;
		m_vHybride = vHybride;
	}
	
	/** Contructeur par recopie **/
	public Ecurie(Ecurie e)
	{
		m_nom = e.m_nom;
		m_vTherm = e.m_vTherm;
		m_vElec = e.m_vElec;
		m_vHybride = e.m_vHybride;
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
	
	/*********** gestion de Fichiers ***********/		
	public void enregistrerEcurieF()
	{
		String fichier="Ecuries/"+m_nom+".ecu";
		
		try {
			FileWriter fw = new FileWriter (fichier);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter fichierSortie = new PrintWriter (bw); 

			fichierSortie.println (m_nom+"\n"+m_vTherm.getNom()+"\n"+m_vElec.getNom()+"\n"+m_vHybride.getNom()); 
			
			fichierSortie.close(); 
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
}