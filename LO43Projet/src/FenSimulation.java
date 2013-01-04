import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FenSimulation extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private PanelDessin panZoneDessin;
	private JTextField nomEcurie;
	private JTextField nomSaison;
	private JTextField nomCircuit;
	private JTextField v1;
	private JTextField v2;
	private JTextField v3;
	private JSeparator sepVert;
	private JSeparator sep1;
	private JSeparator sep2;
	private JSeparator sep3;
	private JSeparator sep4;
	private JLabel lblEcurie;
	private JLabel lblSaison;
	private JLabel lblCircuit;
	private JLabel lblVoitures;
	private JLabel lblThermique;
	private JLabel lblElectrique;
	private JLabel lblHybride;
	private JLabel lblTemps;
	private JButton btnSimulerCircuit;
	private JButton btnCircuitSuivant;
	private JButton btnRetourMenu;
	private JLabel lblTempsThermique;
	private JLabel lblTempsElectrique;
	private JLabel lblTempsHybride;
	
	private int numeroCircuit = 0;
	private String[] m_listeCircuits;
	
	public FenSimulation() {
		setResizable(false);
		setSize(451,410);
		setLocationRelativeTo(null);
		setTitle("Simulation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		nomEcurie = new JTextField();
		nomEcurie.setEditable(false);
		nomEcurie.setBounds(324, 19, 89, 23);
		getContentPane().add(nomEcurie);
		nomEcurie.setColumns(10);
		
		nomSaison = new JTextField();
		nomSaison.setEditable(false);
		nomSaison.setColumns(10);
		nomSaison.setBounds(325, 89, 89, 23);
		getContentPane().add(nomSaison);
		
		nomCircuit = new JTextField();
		nomCircuit.setEditable(false);
		nomCircuit.setColumns(10);
		nomCircuit.setBounds(325, 156, 89, 23);
		getContentPane().add(nomCircuit);
		
		v1 = new JTextField();
		v1.setEditable(false);
		v1.setColumns(10);
		v1.setBounds(324, 233, 89, 23);
		getContentPane().add(v1);
		
		v2 = new JTextField();
		v2.setEditable(false);
		v2.setColumns(10);
		v2.setBounds(324, 264, 89, 23);
		getContentPane().add(v2);
		
		v3 = new JTextField();
		v3.setEditable(false);
		v3.setColumns(10);
		v3.setBounds(324, 293, 89, 23);
		getContentPane().add(v3);
		
		sepVert = new JSeparator();
		sepVert.setOrientation(SwingConstants.VERTICAL);
		sepVert.setBounds(302, 0, 12, 340);
		getContentPane().add(sepVert);
		
		sep1 = new JSeparator();
		sep1.setBounds(303, 53, 131, 2);
		getContentPane().add(sep1);
		
		sep2 = new JSeparator();
		sep2.setBounds(303, 123, 131, 2);
		getContentPane().add(sep2);
		
		sep3 = new JSeparator();
		sep3.setBounds(303, 200, 131, 2);
		getContentPane().add(sep3);
	
		sep4 = new JSeparator();
		sep4.setBounds(0, 200, 299, 2);
		getContentPane().add(sep4);
		
		lblEcurie = new JLabel("Ecurie");
		lblEcurie.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEcurie.setBounds(314, 0, 89, 19);
		getContentPane().add(lblEcurie);
		
	    lblSaison = new JLabel("Saison");
		lblSaison.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSaison.setBounds(314, 66, 89, 19);
		getContentPane().add(lblSaison);

		lblCircuit = new JLabel("Circuit");
		lblCircuit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCircuit.setBounds(314, 133, 89, 19);
		getContentPane().add(lblCircuit);

		lblVoitures = new JLabel("Voitures");
		lblVoitures.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVoitures.setBounds(311, 210, 89, 19);
		getContentPane().add(lblVoitures);
		
	    lblThermique = new JLabel("Voiture 1");
		lblThermique.setBounds(10, 240, 80, 28);
		getContentPane().add(lblThermique);
		
		lblElectrique = new JLabel("Voiture 1");
		lblElectrique.setBounds(10, 270, 80, 28);
		getContentPane().add(lblElectrique);
		
		lblHybride = new JLabel("Voiture 1");
		lblHybride.setBounds(10, 299, 80, 28);
		getContentPane().add(lblHybride);
		
		lblTemps = new JLabel("Temps");
		lblTemps.setBounds(105, 213, 109, 23);
		getContentPane().add(lblTemps);
				
		chargerDonnees();
		
		panZoneDessin = new PanelDessin();
		panZoneDessin.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panZoneDessin.setBounds(0, 0, 298, 200);
		getContentPane().add(panZoneDessin);
		
		btnCircuitSuivant = new JButton("Circuit suivant");
		btnCircuitSuivant.setVisible(false);
		btnCircuitSuivant.setBounds(292, 346, 144, 28);
		btnCircuitSuivant.addActionListener(new GestionBoutons());
		getContentPane().add(btnCircuitSuivant);

		
		btnSimulerCircuit = new JButton("Simuler circuit");
		btnSimulerCircuit.setBounds(139, 346, 144, 28);
		btnSimulerCircuit.addActionListener(new GestionBoutons());
		getContentPane().add(btnSimulerCircuit);
		
		btnRetourMenu = new JButton("Retour au menu");
		btnRetourMenu.setVisible(false);
		btnRetourMenu.setBounds(292, 346, 144, 28);
		btnRetourMenu.addActionListener(new GestionBoutons());
		getContentPane().add(btnRetourMenu);
		
		
		lblTempsThermique = new JLabel("");
		lblTempsThermique.setBounds(100, 247, 71, 14);
		getContentPane().add(lblTempsThermique);
		
		lblTempsElectrique = new JLabel("");
		lblTempsElectrique.setBounds(100, 277, 71, 14);
		getContentPane().add(lblTempsElectrique);
		
		lblTempsHybride = new JLabel("");
		lblTempsHybride.setBounds(100, 306, 71, 14);
		getContentPane().add(lblTempsHybride);
		

		setVisible(true);
	}

	public void chargerDonnees()
	{
		File fichier = new File("Donnees/Simulation.txt");
		
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			
			nomEcurie.setText(br.readLine());
			String tmp = br.readLine();
			v1.setText(tmp);
			lblThermique.setText(tmp);
			tmp = br.readLine();
			v2.setText(tmp);
			lblElectrique.setText(tmp);
			tmp = br.readLine();
			v3.setText(tmp);
			lblHybride.setText(tmp);
			nomSaison.setText(br.readLine());
			m_listeCircuits = new String[Integer.parseInt(br.readLine())];
			for (int i = 0; i < m_listeCircuits.length; i++)
			{
				m_listeCircuits[i] = br.readLine();
			}
			
			nomCircuit.setText(m_listeCircuits[0]);
	
			br.close(); 
		}
		catch (Exception exc){
			System.out.println(exc.toString());
		}
	}
	
	
	class PanelDessin extends JPanel {
		private static final long serialVersionUID = 1L;
		private int m_nbrePoints = 0;
		private int[] m_x;
		private int[] m_y;
		public JLabel lblCircuitNonDessine;
		
	    public PanelDessin() {
	        super();
	        setOpaque(false); // we don't paint all our bits
	        setLayout(null);
	        setBorder(BorderFactory.createLineBorder(Color.black));
	        
	        lblCircuitNonDessine = new JLabel("");
			lblCircuitNonDessine.setHorizontalAlignment(SwingConstants.CENTER);
			lblCircuitNonDessine.setBounds(0, 0, 298, 200);
			lblCircuitNonDessine.setVisible(false);
			getContentPane().add(lblCircuitNonDessine);
			
	        chargerDessin();
	    }
	    
	    public void chargerDessin()
	    {
		    File fichier = new File("Dessins\\"+nomCircuit.getText()+".tra");
			
			if (fichier.exists())
			{
				lblCircuitNonDessine.setVisible(false);
				lblCircuitNonDessine.setText("");
				try{
					InputStream ips=new FileInputStream(fichier); 
					InputStreamReader ipsr=new InputStreamReader(ips);
					BufferedReader br=new BufferedReader(ipsr);
					
					m_nbrePoints = Integer.parseInt(br.readLine());
					m_x = new int[m_nbrePoints];
					m_y = new int [m_nbrePoints];
					for (int i = 0; i < m_nbrePoints; i++)
					{
						m_x[i] = Integer.parseInt(br.readLine());
						m_y[i] = Integer.parseInt(br.readLine());
					}
			
					br.close(); 
				}
				catch (Exception exc) {
					System.out.println(exc.toString());
				}
		    }
			else
			{
				lblCircuitNonDessine.setVisible(true);
				lblCircuitNonDessine.setText("Le circuit n'a pas été dessiné !");
			}
	    }
	
	    protected void paintComponent(final Graphics g) {
	        super.paintComponent(g);
	        if (m_nbrePoints != 0)
	        {
	        	g.drawPolygon(m_x, m_y, m_nbrePoints);
	        }
	    }
	}
	
	class GestionBoutons implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnSimulerCircuit)
			{
				btnSimulerCircuit.setEnabled(false);
				Circuit circuitActuel = new Circuit(nomCircuit.getText());
				Voiture thermique = new Voiture(v1.getText());
				Voiture electrique = new Voiture(v2.getText());
				Voiture_hybride hybride = new Voiture_hybride(v3.getText());
				
				numeroCircuit++;
				
				thermique.simulerCourse(circuitActuel);
				lblTempsThermique.setText(thermique.afficherTemps(thermique.getTempsCourse()));
				electrique.simulerCourse(circuitActuel);
				lblTempsElectrique.setText(electrique.afficherTemps(electrique.getTempsCourse()));
				hybride.simulerCourse(circuitActuel);
				lblTempsHybride.setText(hybride.afficherTemps(hybride.getTempsCourse()));
				
				if (numeroCircuit < m_listeCircuits.length)
				{
					btnCircuitSuivant.setVisible(true);
				}
				else
				{
					btnRetourMenu.setVisible(true);
				}
			}
			else if (e.getSource() == btnCircuitSuivant)
			{
				btnCircuitSuivant.setVisible(false);
				btnSimulerCircuit.setEnabled(true);
				
				nomCircuit.setText(m_listeCircuits[numeroCircuit]);
				lblTempsThermique.setText("");
				lblTempsElectrique.setText("");
				lblTempsHybride.setText("");
				
				panZoneDessin.lblCircuitNonDessine.setVisible(false);
				panZoneDessin.setVisible(false);
				getContentPane().remove(panZoneDessin);
				panZoneDessin = new PanelDessin();
				panZoneDessin.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				panZoneDessin.setBounds(0, 0, 298, 200);
				getContentPane().add(panZoneDessin);
			}
			else if (e.getSource() == btnRetourMenu)
			{
				setVisible(false);
				dispose();
				new FenPrincipale();
			}
		}
	}
}
