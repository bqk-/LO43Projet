import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

class Ecurie {
	private String m_nom;
	private Voiture m_vTherm;
	private Voiture m_vElec;
	private Voiture_hybride m_vHybride;
	
	/************* Constructeurs **************/
	/** Constructeur par défaut **/
	public Ecurie() {
		m_nom = "";
		m_vTherm = new Voiture();
		m_vElec = new Voiture();
		m_vHybride = new Voiture_hybride();
	}
	public Ecurie(String fileName) {
		String fichier="Ecuries/"+fileName+".ecu";
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			//On récupère le nom du circuit
			ligne=br.readLine();
			m_nom=ligne;
			//on récupère les tutures de l'ecurie
			ligne=br.readLine();
			m_vTherm=new Voiture(ligne);
			// ainsi de suite ...
			ligne=br.readLine();
			m_vElec=new Voiture(ligne);
			ligne=br.readLine();
			m_vHybride=new Voiture_hybride(ligne);
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	/** Constructeur par valeurs **/
	public Ecurie(String nom, Voiture vTherm, Voiture vElec, Voiture_hybride vHybride) {
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
		m_nom=this.filtreNom(nom);
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
	/*On suppose que les fichiers écrit respectent la syntaxe établie :
	  -dans un dossier du même nom que la classe
	  -nom_de_l'objet.txt
	  -les variables sont entrées une par ligne, dans l'ordre définit plus haut
	 */
	
		
	public void enregistrerEcurieF()
	{
		//Chemin relatif ou on enregistre le fichier
		String fichier="Ecuries/"+m_nom+".ecu";
		
		try {
			FileWriter fw = new FileWriter (fichier);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter fichierSortie = new PrintWriter (bw); 
				//On écrit les variables, une par ligne
			fichierSortie.println (m_nom+"\n"+m_vTherm.getNom()+"\n"+m_vElec.getNom()+"\n"+m_vHybride.getNom()); 
			fichierSortie.close(); 
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	public String filtreNom(String nom)
	{
		// remplacer tout sauf les lettres et les chiffres par rien
		return nom.replaceAll("\\W","");
	}
	public void deleteFile()
	{
		String fichier="Ecuries/"+m_nom+".ecu";
		try {
			File fw = new File (fichier);
			fw.delete();
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
}