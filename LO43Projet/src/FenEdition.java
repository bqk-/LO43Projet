import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FenEdition extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
/** Panneaux **/
	private JTabbedPane panOnglets;
	private JPanel panSaison;
	private JPanel panCircuit;
	private JPanel panEcurie;
	private JPanel panVoiture;
	
/** Panneau Saison **/
	private JTextField txtNomSaison;
	private JLabel lblNomSaison;
	private JLabel lblStatusNomSaison;
	private JLabel lblSaison;
	private JLabel lblCircuitsDispo;
	private JLabel lblCircuitsSelec;
	private JComboBox<String> boxSaison;
	private JList<String> lstCircuitsDispo;
	private JList<String> lstCircuitsSelec;
	private JSeparator sepHautSaison;
	private JSeparator sepMilieuSaison;
	private JSeparator sepBasSaison;
	private JButton btnSupprimerSaison;
	private JButton btnAjouterCircuit;
	private JButton btnEnleverCircuit;
	private JButton btnMAJSaison;
	private JButton btnReinitialiserSaison;

/** Panneau Circuit **/
	private JTextField txtNomCircuit;
	private JLabel lblNomCircuit;
	private JLabel lblStatusNomCirc;
	private JLabel lblLongueurCircuit;
	private JLabel lblCircuit;
	private JLabel lblPositionStands;
	private JLabel lblVitesseMax;
	private JLabel lblNbreTours;
	private JComboBox<String> boxCircuit;
	private JSpinner spinNbreTours;
	private JSpinner spinLongueurCircuit;
	private JSpinner spinPositionStands;
	private JSpinner spinVitesseMax;
	private JSeparator sepHautCircuit;
	private JSeparator sepBasCircuit;
	private JButton btnSupprimerCircuit;
	private JButton btnMAJCircuit;
	private JButton btnReinitialiserCircuit;
	
/** Panneau Ecurie **/
	private JTextField txtNomEcurie;
	private JLabel lblNomEcurie;
	private JLabel lblStatusNomEcurie;
	private JLabel lblVoitTherm;
	private JLabel lblVoitElec;
	private JLabel lblVoitHybr;
	private JLabel lblEcurie;
	private JComboBox<String> boxVoitTherm;
	private JComboBox<String> boxVoitElec;
	private JComboBox<String> boxVoitHybr;
	private JComboBox<String> boxEcurie;
	private JSeparator sepBasEcurie;
	private JSeparator sepHautEcurie;
	private JButton btnSupprimerEcurie;
	private JButton btnReinitialiserEcurie;
	private JButton btnMAJEcurie;

/** Panneau Voiture **/
	private JTextField txtNomVoiture;
	private JLabel lblVoiture;
	private JLabel lblNomVoiture;
	private JLabel lblStatusNomVoiture;
	private JLabel lblVMax;
	private JLabel lblTempsArret;
	private JLabel lblAutonomie;
	private JLabel lblConso;
	private JLabel lblType;
	private JSpinner spinVMax;
	private JSpinner spinTempsArret;
	private JSpinner spinAutonomie;
	private JSpinner spinConso;
	private JRadioButton radioVoitTherm;
	private JRadioButton radioVoitElec;
	private AbstractButton radioVoitHybr;
	private JComboBox<String> boxVoiture;
	private JSeparator sepHautVoiture;
	private JSeparator sepBasVoiture;
	private JButton btnReinitialiserVoiture;
	private JButton btnSupprimerVoiture;
	private JButton btnMAJVoiture;


	public FenEdition() {
		setTitle("Mode Edition");
		setSize(435, 395);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
/** Panneaux **/
		panOnglets = new JTabbedPane(JTabbedPane.TOP);
		panOnglets.setBounds(0, 0, 429, 367);
		getContentPane().add(panOnglets);
		
		panSaison = new JPanel();
		panSaison.setLayout(null);
		
		panCircuit = new JPanel();
		panCircuit.setLayout(null);
		
		panEcurie = new JPanel();
		panEcurie.setLayout(null);
		
		panVoiture = new JPanel();
		panVoiture.setLayout(null);
				
		panOnglets.addTab("Saison", null, panSaison, null);
		panOnglets.addTab("Circuit", null, panCircuit, null);
		panOnglets.addTab("Ecurie", null, panEcurie, null);
		panOnglets.addTab("Voiture", null, panVoiture, null);
		
/** Panneau Saison **/
	/** TextBox **/
		txtNomSaison = new JTextField();
		txtNomSaison.setColumns(10);
		txtNomSaison.setBounds(147, 56, 140, 20);
		panSaison.add(txtNomSaison);
		
	/** Label **/
		lblNomSaison = new JLabel("Nom de la saison :");
		lblNomSaison.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomSaison.setBounds(36, 58, 103, 16);
		panSaison.add(lblNomSaison);
				
		lblStatusNomSaison = new JLabel("");
		lblStatusNomSaison.setFont(new Font("Dialog", Font.ITALIC, 12));
		lblStatusNomSaison.setBounds(304, 58, 115, 16);
		panSaison.add(lblStatusNomSaison);
		
		lblSaison = new JLabel("Saison :");
		lblSaison.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSaison.setBounds(16, 14, 123, 14);
		panSaison.add(lblSaison);
		
		lblCircuitsDispo = new JLabel("Circuits disponibles :");
		lblCircuitsDispo.setBounds(15, 87, 133, 17);
		panSaison.add(lblCircuitsDispo);
		
		lblCircuitsSelec = new JLabel("Circuits s\u00E9lectionn\u00E9s :");
		lblCircuitsSelec.setBounds(231, 88, 133, 17);
		panSaison.add(lblCircuitsSelec);
		
	/** ComboBox **/
		boxSaison = new JComboBox<String>();
		boxSaison.setModel(new DefaultComboBoxModel<String>(new String[] {"Choisir une saison", "Nouvelle saison"}));
		boxSaison.addActionListener(new GestionMenus());
		boxSaison.setBounds(147, 11, 162, 20);		

		panSaison.add(boxSaison);
		
	/** Separator **/
		sepHautSaison = new JSeparator();
		sepHautSaison.setBounds(0, 41, 429, 5);
		panSaison.add(sepHautSaison);
		
		sepMilieuSaison = new JSeparator();
		sepMilieuSaison.setOrientation(SwingConstants.VERTICAL);
		sepMilieuSaison.setBounds(208, 88, 8, 192);
		panSaison.add(sepMilieuSaison);
		
		sepBasSaison = new JSeparator();
		sepBasSaison.setBounds(0, 279, 424, 16);
		panSaison.add(sepBasSaison);
		
	/** List **/
		lstCircuitsDispo = new JList<String>();
		lstCircuitsDispo.setBounds(15, 106, 188, 133);
		panSaison.add(lstCircuitsDispo);
		
		lstCircuitsSelec = new JList<String>();
		lstCircuitsSelec.setBounds(215, 106, 188, 133);
		panSaison.add(lstCircuitsSelec);
		
	/** Button **/
		btnSupprimerSaison = new JButton("Supprimer");
		btnSupprimerSaison.setBounds(321, 8, 98, 26);
		btnSupprimerSaison.addActionListener(new GestionBoutons());
		panSaison.add(btnSupprimerSaison);
		
		btnAjouterCircuit = new JButton("=>");
		btnAjouterCircuit.setBounds(105, 248, 98, 26);
		btnAjouterCircuit.addActionListener(new GestionBoutons());
		panSaison.add(btnAjouterCircuit);
		
		btnEnleverCircuit = new JButton("<=");
		btnEnleverCircuit.setBounds(225, 248, 98, 26);
		btnEnleverCircuit.addActionListener(new GestionBoutons());
		panSaison.add(btnEnleverCircuit);
		
		btnMAJSaison = new JButton("Mettre \u00E0 jour");
		btnMAJSaison.setBounds(304, 300, 108, 26);
		btnMAJSaison.addActionListener(new GestionBoutons());
		panSaison.add(btnMAJSaison);		
		
		btnReinitialiserSaison = new JButton("R\u00E9initialiser");
		btnReinitialiserSaison.setBounds(12, 300, 108, 26);
		btnReinitialiserSaison.addActionListener(new GestionBoutons());
		panSaison.add(btnReinitialiserSaison);
	
/** Panneau Circuit **/
	/** TextBox **/
		txtNomCircuit = new JTextField();
		txtNomCircuit.setColumns(10);
		txtNomCircuit.setBounds(164, 54, 140, 20);
		panCircuit.add(txtNomCircuit);
		
	/** Label **/
		lblCircuit = new JLabel("Circuit :");
		lblCircuit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCircuit.setBounds(16, 13, 123, 14);
		panCircuit.add(lblCircuit);
		
		lblNomCircuit = new JLabel("Nom du circuit :");
		lblNomCircuit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomCircuit.setBounds(43, 56, 115, 16);
		panCircuit.add(lblNomCircuit);
		
		lblStatusNomCirc = new JLabel("");
		lblStatusNomCirc.setBounds(304, 56, 115, 16);
		panCircuit.add(lblStatusNomCirc);
		
		lblLongueurCircuit = new JLabel("Longueur (m) :");
		lblLongueurCircuit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLongueurCircuit.setBounds(53, 84, 105, 16);
		panCircuit.add(lblLongueurCircuit);
		
		lblPositionStands = new JLabel("Position des stands (m) :");
		lblPositionStands.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPositionStands.setBounds(-2, 112, 160, 16);
		panCircuit.add(lblPositionStands);
		
		lblVitesseMax = new JLabel("Vitesse maximale (km/h) :");
		lblVitesseMax.setFont(UIManager.getFont("Label.font"));
		lblVitesseMax.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVitesseMax.setBounds(0, 140, 158, 16);
		panCircuit.add(lblVitesseMax);
		
		lblNbreTours = new JLabel("Nombre de tours :");
		lblNbreTours.setFont(UIManager.getFont("Label.font"));
		lblNbreTours.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNbreTours.setBounds(53, 170, 105, 16);
		panCircuit.add(lblNbreTours);
		
	/** Spinner **/
		spinLongueurCircuit = new JSpinner();
		spinLongueurCircuit.setModel(new SpinnerNumberModel(new Integer(1000), new Integer(1), null, new Integer(100)));
		spinLongueurCircuit.setBounds(164, 82, 72, 20);
		spinLongueurCircuit.addChangeListener(new GestionSpinner());
		panCircuit.add(spinLongueurCircuit);
		
		spinPositionStands = new JSpinner();
		spinPositionStands.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), new Integer((int) spinLongueurCircuit.getValue()), new Integer(10)));
		spinPositionStands.setBounds(164, 110, 72, 20);
		panCircuit.add(spinPositionStands);
		
		spinVitesseMax = new JSpinner();
		spinVitesseMax.setModel(new SpinnerNumberModel(new Integer(100), new Integer(1), null, new Integer(10)));
		spinVitesseMax.setBounds(163, 138, 72, 20);
		panCircuit.add(spinVitesseMax);
	
		spinNbreTours = new JSpinner();
		spinNbreTours.setModel(new SpinnerNumberModel(new Integer(3), new Integer(1), null, new Integer(1)));
		spinNbreTours.setBounds(164, 168, 72, 20);
		panCircuit.add(spinNbreTours);
				
	/** ComboBox **/
		boxCircuit = new JComboBox<String>();
		boxCircuit.setModel(new DefaultComboBoxModel<String>(new String[] {"Choisir un circuit", "Nouveau circuit"}));
		boxCircuit.setBounds(147, 10, 162, 20);
		boxCircuit.addActionListener(new GestionMenus());
		panCircuit.add(boxCircuit);
		
	/** Separator **/
		sepHautCircuit = new JSeparator();
		sepHautCircuit.setBounds(0, 39, 429, 5);
		panCircuit.add(sepHautCircuit);
		
		sepBasCircuit = new JSeparator();
		sepBasCircuit.setBounds(0, 284, 424, 16);
		panCircuit.add(sepBasCircuit);
		
	/** Button **/
		btnSupprimerCircuit = new JButton("Supprimer");
		btnSupprimerCircuit.setBounds(321, 7, 98, 26);
		btnSupprimerCircuit.addActionListener(new GestionBoutons());
		panCircuit.add(btnSupprimerCircuit);
				
		btnMAJCircuit = new JButton("Mettre \u00E0 jour");
		btnMAJCircuit.setBounds(304, 300, 108, 26);
		btnMAJCircuit.addActionListener(new GestionBoutons());
		panCircuit.add(btnMAJCircuit);
		
		btnReinitialiserCircuit = new JButton("R\u00E9initialiser");
		btnReinitialiserCircuit.setBounds(12, 300, 105, 26);
		btnReinitialiserCircuit.addActionListener(new GestionBoutons());
		panCircuit.add(btnReinitialiserCircuit);
		
		
/** Panneau Ecurie **/
	/** TextBox **/
		txtNomEcurie = new JTextField();
		txtNomEcurie.setColumns(10);
		txtNomEcurie.setBounds(136, 69, 140, 20);
		panEcurie.add(txtNomEcurie);
		
	/** Label **/
		lblNomEcurie = new JLabel("Nom de l'\u00E9curie :");
		lblNomEcurie.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomEcurie.setBounds(23, 71, 103, 16);
		panEcurie.add(lblNomEcurie);
		
		lblStatusNomEcurie = new JLabel("! Entrez un nom");
		lblStatusNomEcurie.setFont(new Font("Dialog", Font.ITALIC, 12));
		lblStatusNomEcurie.setBounds(297, 70, 122, 16);
		panEcurie.add(lblStatusNomEcurie);
		
		lblVoitTherm = new JLabel("Voiture thermique :");
		lblVoitTherm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVoitTherm.setBounds(10, 104, 116, 17);
		panEcurie.add(lblVoitTherm);
		
		lblVoitElec = new JLabel("Voiture \u00E9lectrique :");
		lblVoitElec.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVoitElec.setBounds(10, 136, 116, 17);
		panEcurie.add(lblVoitElec);
		
		lblVoitHybr = new JLabel("Voiture hybride :");
		lblVoitHybr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVoitHybr.setBounds(10, 168, 116, 17);
		panEcurie.add(lblVoitHybr);
		
		lblEcurie = new JLabel("Ecurie :");
		lblEcurie.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEcurie.setBounds(16, 17, 123, 14);
		panEcurie.add(lblEcurie);
		
	/** ComboBox **/
		boxVoitTherm = new JComboBox<String>();
		boxVoitTherm.setModel(new DefaultComboBoxModel<String>(new String[] {"Choisir une voiture"}));
		boxVoitTherm.setBounds(134, 100, 188, 25);
		panEcurie.add(boxVoitTherm);
		
		boxVoitElec = new JComboBox<String>();
		boxVoitElec.setModel(new DefaultComboBoxModel<String>(new String[] {"Choisir une voiture"}));
		boxVoitElec.setBounds(134, 132, 188, 25);
		panEcurie.add(boxVoitElec);
		
		boxVoitHybr = new JComboBox<String>();
		boxVoitHybr.setModel(new DefaultComboBoxModel<String>(new String[] {"Choisir une voiture"}));
		boxVoitHybr.setBounds(134, 164, 188, 25);
		panEcurie.add(boxVoitHybr);
		
		boxEcurie = new JComboBox<String>();
		boxEcurie.setModel(new DefaultComboBoxModel<String>(new String[] {"Choisir une \u00E9curie", "Nouvelle \u00E9curie"}));
		boxEcurie.setBounds(147, 14, 162, 20);
		boxEcurie.addActionListener(new GestionMenus());
		panEcurie.add(boxEcurie);
		
		
	/** Separator **/
		sepBasEcurie = new JSeparator();
		sepBasEcurie.setBounds(0, 278, 434, 10);
		panEcurie.add(sepBasEcurie);
		
		sepHautEcurie = new JSeparator();
		sepHautEcurie.setBounds(0, 43, 429, 5);
		panEcurie.add(sepHautEcurie);
		
	/** Button **/
		btnSupprimerEcurie = new JButton("Supprimer");
		btnSupprimerEcurie.setBounds(321, 11, 98, 26);
		btnSupprimerEcurie.addActionListener(new GestionBoutons());
		panEcurie.add(btnSupprimerEcurie);
	
		btnReinitialiserEcurie = new JButton("R\u00E9initialiser");
		btnReinitialiserEcurie.setBounds(12, 300, 103, 26);
		btnReinitialiserEcurie.addActionListener(new GestionBoutons());
		panEcurie.add(btnReinitialiserEcurie);
		
		btnMAJEcurie = new JButton("Mettre \u00E0 jour");
		btnMAJEcurie.setBounds(297, 300, 115, 26);
		btnMAJEcurie.addActionListener(new GestionBoutons());
		panEcurie.add(btnMAJEcurie);
		

/*** Panneau Voiture **/
	/** TextBox **/
		txtNomVoiture = new JTextField();
		txtNomVoiture.setColumns(10);
		txtNomVoiture.setBounds(152, 56, 135, 20);
		panVoiture.add(txtNomVoiture);
		
	/** Label **/
		lblVoiture = new JLabel("Voiture :");
		lblVoiture.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVoiture.setBounds(11, 14, 123, 14);
		panVoiture.add(lblVoiture);
		
		lblNomVoiture = new JLabel("Nom de la voiture :");
		lblNomVoiture.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomVoiture.setBounds(0, 61, 142, 14);
		panVoiture.add(lblNomVoiture);
				
		lblStatusNomVoiture = new JLabel("! Entrez un nom");
		lblStatusNomVoiture.setFont(new Font("Dialog", Font.ITALIC, 12));
		lblStatusNomVoiture.setBounds(296, 58, 128, 16);
		panVoiture.add(lblStatusNomVoiture);
		
		lblVMax = new JLabel("Vitesse maximale :");
		lblVMax.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVMax.setBounds(0, 86, 142, 16);
		panVoiture.add(lblVMax);
		
		lblTempsArret = new JLabel("Temps d'arr\u00EAt au stand :");
		lblTempsArret.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTempsArret.setBounds(0, 113, 142, 16);
		panVoiture.add(lblTempsArret);

		lblAutonomie = new JLabel("Autonomie :");
		lblAutonomie.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAutonomie.setBounds(0, 141, 142, 16);
		panVoiture.add(lblAutonomie);

		lblConso = new JLabel("Consommation :");
		lblConso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConso.setBounds(0, 169, 142, 16);
		panVoiture.add(lblConso);
		
		lblType = new JLabel("Type :");
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblType.setBounds(0, 197, 142, 16);
		panVoiture.add(lblType);
		
	/** Spinner **/
		spinVMax = new JSpinner();
		spinVMax.setModel(new SpinnerNumberModel(new Integer(100), new Integer(0), null, new Integer(10)));
		spinVMax.setBounds(152, 82, 57, 20);
		panVoiture.add(spinVMax);
		
		spinTempsArret = new JSpinner();
		spinTempsArret.setModel(new SpinnerNumberModel(new Integer(10), new Integer(1), null, new Integer(1)));
		spinTempsArret.setBounds(152, 109, 57, 20);
		panVoiture.add(spinTempsArret);
				
		spinAutonomie = new JSpinner();
		spinAutonomie.setModel(new SpinnerNumberModel(new Integer(100), new Integer(1), null, new Integer(10)));
		spinAutonomie.setBounds(152, 137, 57, 20);
		panVoiture.add(spinAutonomie);
	
		spinConso = new JSpinner();
		spinConso.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinConso.setBounds(152, 165, 57, 20);
		panVoiture.add(spinConso);
		
	/** RadioButton **/
		radioVoitTherm = new JRadioButton("Thermique");
		radioVoitTherm.setMnemonic('1');
		radioVoitTherm.setBounds(152, 192, 118, 24);
		panVoiture.add(radioVoitTherm);
		
		radioVoitElec = new JRadioButton("Electrique");
		radioVoitElec.setMnemonic('2');
		radioVoitElec.setBounds(152, 220, 118, 24);
		panVoiture.add(radioVoitElec);
		
		radioVoitHybr = new JRadioButton("Hybride");
		radioVoitHybr.setMnemonic('3');
		radioVoitHybr.setBounds(152, 248, 118, 24);
		panVoiture.add(radioVoitHybr);
		
		ButtonGroup groupType = new ButtonGroup();
		groupType.add(radioVoitTherm);
		groupType.add(radioVoitElec);
		groupType.add(radioVoitHybr);
		
	/** ComboBox **/
		boxVoiture = new JComboBox<String>();
		boxVoiture.setModel(new DefaultComboBoxModel<String>(new String[] {"Choisir une voiture", "Nouvelle voiture"}));
		boxVoiture.setBounds(142, 11, 162, 20);
		boxVoiture.addActionListener(new GestionMenus());
		panVoiture.add(boxVoiture);
		
	/** Separator **/
		sepHautVoiture = new JSeparator();
		sepHautVoiture.setBounds(-5, 40, 429, 5);
		panVoiture.add(sepHautVoiture);
		
		sepBasVoiture = new JSeparator();
		sepBasVoiture.setBounds(0, 279, 424, 16);
		panVoiture.add(sepBasVoiture);
		
	/** Button **/
		btnReinitialiserVoiture = new JButton("R\u00E9initialiser");
		btnReinitialiserVoiture.setBounds(11, 300, 107, 26);
		btnReinitialiserVoiture.addActionListener(new GestionBoutons());
		panVoiture.add(btnReinitialiserVoiture);
		
	    btnSupprimerVoiture = new JButton("Supprimer");
		btnSupprimerVoiture.setBounds(316, 8, 98, 26);
		btnSupprimerVoiture.addActionListener(new GestionBoutons());
		panVoiture.add(btnSupprimerVoiture);
		
		btnMAJVoiture = new JButton("Mettre \u00E0 jour");
		btnMAJVoiture.setBounds(296, 300, 116, 26);
		btnMAJVoiture.addActionListener(new GestionBoutons());
		panVoiture.add(btnMAJVoiture);
		
		chargerSaisons();
		chargerCircuits();
		chargerEcuries();
		chargerVoitures();
	}
	
	public void chargerCircuits()
	{
		File rep = new File("Circuits");
		File[] listeFichiers = rep.listFiles();
		String[] listeCircuits = new String[listeFichiers.length];
		
		for (int i = 0; i < listeFichiers.length; i++)
		{
			String tmp = listeFichiers[i].toString().replace("Circuits\\", "").replace(".cir", "");
			listeCircuits[i] = tmp;
			boxCircuit.addItem(tmp);
		}
		lstCircuitsDispo.setListData(listeCircuits);
	}
	
	public void chargerSaisons()
	{
		File rep = new File("Saisons");
		File[] listeFichiers = rep.listFiles();
		
		for (int i = 0; i < listeFichiers.length; i++)
		{
			boxSaison.addItem(listeFichiers[i].toString().replace("Saisons\\", "").replace(".sai", ""));
		}
	}
	
	public void chargerVoitures()
	{
		File rep = new File("Voitures");
		File[] listeFichiers = rep.listFiles();
		
		for (int i = 0; i < listeFichiers.length; i++)
		{
			String tmp = listeFichiers[i].toString().replace("Voitures\\", "");
			if (tmp.endsWith(".vth"))
			{
				tmp = tmp.replace(".vth", "");
				boxVoitTherm.addItem(tmp);
			}
			else if (tmp.endsWith(".vel"))
			{
				tmp = tmp.replace(".vel", "");
				boxVoitElec.addItem(tmp);
			}
			else if (tmp.endsWith(".vhy"))
			{
				tmp = tmp.replace(".vhy", "");
				boxVoitHybr.addItem(tmp);
			}
			boxVoiture.addItem(tmp);
		}
	}
	
	public void chargerEcuries()
	{
		File rep = new File("Ecuries");
		File[] listeFichiers = rep.listFiles();
		
		for (int i = 0; i < listeFichiers.length; i++)
		{
			boxEcurie.addItem(listeFichiers[i].toString().replace("Ecuries\\", "").replace(".ecu", ""));
		}
	}
	
	class GestionSpinner implements ChangeListener
	{
		@Override
		public void stateChanged(ChangeEvent e) {
			if (e.getSource() == spinLongueurCircuit)
			{
				spinPositionStands.setModel(new SpinnerNumberModel(new Integer((int) spinPositionStands.getValue()), new Integer(1), new Integer((int) spinLongueurCircuit.getValue()), new Integer(10)));
			}
		}
	}
	
	class GestionMenus implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == boxSaison)
			{
				if (boxSaison.getSelectedIndex() == 0 || boxSaison.getSelectedIndex() == 1)
				{
					txtNomSaison.setText("");
					lstCircuitsSelec.setListData(new String[0]);
				}
				else
				{
					int nbrCircuits;
					String[] listeCircuits = null;
					try{
						InputStream ips=new FileInputStream("Saisons\\"+boxSaison.getSelectedItem()+".sai"); 
						InputStreamReader ipsr=new InputStreamReader(ips);
						BufferedReader br=new BufferedReader(ipsr);
						
						txtNomSaison.setText(br.readLine());
						nbrCircuits = Integer.parseInt(br.readLine());
						listeCircuits = new String[nbrCircuits];
						for (int i = 0; i < nbrCircuits; i++)
						{
							listeCircuits[i] = br.readLine();
						}
						lstCircuitsSelec.setListData(listeCircuits);
						
						br.close(); 
					}		
					catch (Exception exc){
						System.out.println(exc.toString());
					}
				}
			}
			else if (e.getSource() == boxCircuit)
			{
				if (boxCircuit.getSelectedIndex() == 0 || boxCircuit.getSelectedIndex() == 1)
				{
					txtNomCircuit.setText("");
					spinLongueurCircuit.setValue(new Integer(1000));
					spinPositionStands.setValue(new Integer(10));
					spinVitesseMax.setValue(new Integer(300));
					spinNbreTours.setValue(new Integer(3));
				}
				else
				{

					try{
						InputStream ips=new FileInputStream("Circuits\\"+boxCircuit.getSelectedItem()+".cir"); 
						InputStreamReader ipsr=new InputStreamReader(ips);
						BufferedReader br=new BufferedReader(ipsr);
						
						txtNomCircuit.setText(br.readLine());
						spinLongueurCircuit.setValue(Integer.parseInt(br.readLine()));
						spinPositionStands.setValue(Integer.parseInt(br.readLine()));
						spinVitesseMax.setValue(Integer.parseInt(br.readLine()));
						spinNbreTours.setValue(Integer.parseInt(br.readLine()));
						
						br.close();
					}		
					catch (Exception exc){
						System.out.println(exc.toString());
					}
				}
			}
			else if (e.getSource() == boxEcurie)
			{
				if (boxEcurie.getSelectedIndex() == 0 || boxEcurie.getSelectedIndex() == 1)
				{
					txtNomEcurie.setText("");
					boxVoitTherm.setSelectedIndex(0);
					boxVoitElec.setSelectedIndex(0);
					boxVoitHybr.setSelectedIndex(0);
				}
				else
				{

					try{
						InputStream ips=new FileInputStream("Ecuries\\"+boxEcurie.getSelectedItem()+".ecu"); 
						InputStreamReader ipsr=new InputStreamReader(ips);
						BufferedReader br=new BufferedReader(ipsr);
						
						txtNomEcurie.setText(br.readLine());
						boxVoitTherm.setSelectedItem(br.readLine());
						boxVoitElec.setSelectedItem(br.readLine());
						boxVoitHybr.setSelectedItem(br.readLine());
						br.close();
					}		
					catch (Exception exc){
						System.out.println(exc.toString());
					}
				}			
			}
			else if (e.getSource() == boxVoiture)
			{
				radioVoitTherm.setSelected(false);
				radioVoitElec.setSelected(false);
				radioVoitHybr.setSelected(false);
				if (boxVoiture.getSelectedIndex() == 0 || boxVoiture.getSelectedIndex() == 1)
				{
					txtNomVoiture.setText("");
					spinVMax.setValue(new Integer(1000));
					spinTempsArret.setValue(new Integer(10));
					spinAutonomie.setValue(new Integer(300));
					spinConso.setValue(new Integer(3));
				}
				else
				{
					try{
						File rep = new File("Voitures");
						File[] listeFichiers = rep.listFiles();
						File fichier = null;
						for (int i = 0; i < listeFichiers.length; i++)
						{
							if (listeFichiers[i].toString().contains((CharSequence) boxVoiture.getSelectedItem()))
							{
								fichier = listeFichiers[i];
							}
						}
						InputStream ips=new FileInputStream(fichier); 
						InputStreamReader ipsr=new InputStreamReader(ips);
						BufferedReader br=new BufferedReader(ipsr);
						
						txtNomVoiture.setText(br.readLine());
						spinVMax.setValue(Integer.parseInt(br.readLine()));
						spinTempsArret.setValue(Integer.parseInt(br.readLine()));
						spinAutonomie.setValue(Integer.parseInt(br.readLine()));
						spinConso.setValue(Integer.parseInt(br.readLine()));
						switch(Integer.parseInt(br.readLine()))
						{
							case 1:
								radioVoitTherm.setSelected(true);
								System.out.println("Voiture thermique");
								break;
							case 2:
								radioVoitElec.setSelected(true);
								System.out.println("Voiture électrique");
								break;
							case 3:
								radioVoitHybr.setSelected(true);
								System.out.println("Voiture hybride");
								break;
							default:
								break;
						}
						br.close();
					}		
					catch (Exception exc){
						System.out.println(exc.toString());
					}
				}			
			}
		}
	}
	
	public void supprimerSaison()
	{
		if (boxSaison.getSelectedIndex() != 0 && boxSaison.getSelectedIndex() != 1)
		{
			String fichier = "Saisons\\" + boxSaison.getSelectedItem() + ".sai";
			File f = new File(fichier);
			if (f.exists())
			{
				f.delete();
			}
			boxSaison.removeItemAt(boxSaison.getSelectedIndex());
		}
	}
	
	public void enregistrerSaison()
	{
		int index = boxSaison.getSelectedIndex();
		File fichier = new File("Saisons\\" + boxSaison.getSelectedItem() + ".sai");

		if (fichier.exists() && boxSaison.getSelectedItem() != txtNomSaison.getText())
		{
			fichier.renameTo(new File("Saisons\\" + txtNomSaison.getText() + ".sai"));
		}
	
		try {
			FileWriter fw = new FileWriter ("Saisons\\" + txtNomSaison.getText() + ".sai");
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter fichierSortie = new PrintWriter (bw);
				fichierSortie.println(txtNomSaison.getText());
				fichierSortie.println(lstCircuitsSelec.getModel().getSize());
				for (int i = 0; i < lstCircuitsSelec.getModel().getSize(); i++)
				{
					fichierSortie.println(lstCircuitsSelec.getModel().getElementAt(i)); 
				}
			fichierSortie.close();
		}
		catch (Exception exc){
			System.out.println(exc.toString());
		}
		
		boxSaison.addItem(txtNomSaison.getText());
		if (boxSaison.getSelectedIndex() != 0 && boxSaison.getSelectedIndex() != 1)
		{
			boxSaison.removeItemAt(index);
		}
	}
	
	public void supprimerCircuit()
	{
		if (boxCircuit.getSelectedIndex() != 0 && boxCircuit.getSelectedIndex() != 1)
		{
			String fichier = "Circuits\\" + boxCircuit.getSelectedItem() + ".cir";
			File f = new File(fichier);
			if (f.exists())
			{
				f.delete();
			}
			boxCircuit.removeItemAt(boxCircuit.getSelectedIndex());
		}
	}
	
	public void enregistrerCircuit()
	{
		int index = boxCircuit.getSelectedIndex();
		File fichier = new File("Circuits\\" + boxCircuit.getSelectedItem() + ".cir");
		
		if (fichier.exists() && boxCircuit.getSelectedItem() != txtNomCircuit.getText())
		{
			fichier.renameTo(new File("Circuits\\" + txtNomCircuit.getText() + ".cir"));
		}
	
		try {
			FileWriter fw = new FileWriter ("Circuits\\" + txtNomCircuit.getText() + ".cir");
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter fichierSortie = new PrintWriter (bw);
				fichierSortie.println(txtNomCircuit.getText());
				fichierSortie.println(spinLongueurCircuit.getValue().toString()+'\n'+spinPositionStands.getValue().toString()+'\n'+spinVMax.getValue().toString()+'\n'+spinNbreTours.getValue().toString());
			fichierSortie.close();
		}
		catch (Exception exc){
			System.out.println(exc.toString());
		}
		
		boxCircuit.addItem(txtNomCircuit.getText());
		if (boxCircuit.getSelectedIndex() != 0 && boxCircuit.getSelectedIndex() != 1)
		{
			boxCircuit.removeItemAt(index);
		}
	}
	
	public void supprimerEcurie()
	{
		if (boxEcurie.getSelectedIndex() != 0 && boxEcurie.getSelectedIndex() != 1)
		{
			String fichier = "Ecuries\\" + boxEcurie.getSelectedItem() + ".ecu";
			File f = new File(fichier);
			if (f.exists())
			{
				f.delete();
			}
			boxEcurie.removeItemAt(boxEcurie.getSelectedIndex());
		}
	}
	
	public void enregistrerEcurie()
	{
		int index = boxEcurie.getSelectedIndex();
		File fichier = new File("Ecuries\\" + boxEcurie.getSelectedItem() + ".ecu");
		
		if (fichier.exists() && boxEcurie.getSelectedItem() != txtNomEcurie.getText())
		{
			fichier.renameTo(new File("Ecuries\\" + txtNomEcurie.getText() + ".ecu"));
		}
	
		try {
			FileWriter fw = new FileWriter ("Ecuries\\" + txtNomEcurie.getText() + ".ecu");
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter fichierSortie = new PrintWriter (bw);
				fichierSortie.println(txtNomEcurie.getText());
				fichierSortie.println(boxVoitTherm.getSelectedItem().toString()+'\n'+boxVoitElec.getSelectedItem().toString()+'\n'+boxVoitHybr.getSelectedItem().toString());
			fichierSortie.close();
		}
		catch (Exception exc){
			System.out.println(exc.toString());
		}
		
		boxEcurie.addItem(txtNomEcurie.getText());
		if (boxEcurie.getSelectedIndex() != 0 && boxEcurie.getSelectedIndex() != 1)
		{
			boxEcurie.removeItemAt(index);
		}
	}
	
	public void supprimerVoiture()
	{
		if (boxVoiture.getSelectedIndex() != 0 && boxVoiture.getSelectedIndex() != 1)
		{
			String fichier = "Voitures\\" + boxVoiture.getSelectedItem();
			if (radioVoitTherm.isSelected())
			{
				fichier += ".vth";
			}
			else if (radioVoitElec.isSelected())
			{
				fichier += ".vel";
			}
			else if (radioVoitHybr.isSelected())
			{
				fichier += ".vhy";
			}
			File f = new File(fichier);
			if (f.exists())
			{
				f.delete();
			}
			boxVoiture.removeItemAt(boxVoiture.getSelectedIndex());
		}
	}
	
	public void enregistrerVoiture()
	{
		int index = boxVoiture.getSelectedIndex();
		String nomFichier = "Voitures\\" + boxVoiture.getSelectedItem();
		String extension = "";
		File fichier = null;
		if (radioVoitTherm.isSelected())
		{
			extension = ".vth";
		}
		else if (radioVoitElec.isSelected())
		{
			extension = ".vel";
		}
		else if (radioVoitHybr.isSelected())
		{
			extension = ".vhy";
		}
		
		fichier = new File(nomFichier+extension);
		
		if (fichier.exists() && boxVoiture.getSelectedItem() != txtNomVoiture.getText())
		{
			fichier.renameTo(new File("Voitures\\" + txtNomVoiture.getText() + extension));
		}
		
		try {
			FileWriter fw = new FileWriter ("Voitures\\" + txtNomVoiture.getText() + extension);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter fichierSortie = new PrintWriter (bw);
				fichierSortie.println(txtNomVoiture.getText());
				fichierSortie.println(spinVMax.getValue().toString());
				fichierSortie.println(spinTempsArret.getValue().toString());
				fichierSortie.println(spinAutonomie.getValue().toString());
				fichierSortie.println(spinConso.getValue().toString()); 
				if (radioVoitTherm.isSelected())
				{
					fichierSortie.println("1");
				}
				else if (radioVoitElec.isSelected())
				{
					fichierSortie.println("2");
				}
				else if (radioVoitHybr.isSelected())
				{
					fichierSortie.println("3");
				}
			fichierSortie.close();
		}
		catch (Exception exc){
			System.out.println(exc.toString());
		}
		
		boxVoiture.addItem(txtNomVoiture.getText());
		if (boxVoiture.getSelectedIndex() != 0 && boxVoiture.getSelectedIndex() != 1)
		{
			boxVoiture.removeItemAt(index);
		}
	}
	
	public void rafraichirListeCircuitsDispo()
	{
		File rep = new File("Circuits");
		File[] listeFichiers = rep.listFiles();
		String[] listeCircuits = new String[listeFichiers.length];
		
		for (int i = 0; i < listeFichiers.length; i++)
		{
			listeCircuits[i] = listeFichiers[i].toString().replace("Circuits\\", "").replace(".cir", "");
		}
		lstCircuitsDispo.setListData(listeCircuits);
	}
	
	
	class GestionBoutons implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnReinitialiserSaison)
			{
				txtNomSaison.setText("");
				lstCircuitsSelec.setListData(new String[0]);
			}
			else if (e.getSource() == btnReinitialiserCircuit)
			{
				txtNomCircuit.setText("");
				spinNbreTours.setValue(new Integer(3));
				spinLongueurCircuit.setValue(new Integer(1000));
				spinVitesseMax.setValue(new Integer(100));
				spinPositionStands.setValue(new Integer(1));
			}
			else if (e.getSource() == btnReinitialiserEcurie)
			{
				txtNomEcurie.setText("");
				boxVoitTherm.setSelectedIndex(0);
				boxVoitElec.setSelectedIndex(0);
				boxVoitHybr.setSelectedIndex(0);
			}
			else if (e.getSource() == btnReinitialiserVoiture)
			{
				txtNomVoiture.setText("");
				spinVMax.setValue(new Integer(100));
				spinTempsArret.setValue(new Integer(10));
				spinAutonomie.setValue(new Integer(100));
				spinConso.setValue(new Integer(1));
				radioVoitTherm.setSelected(false);
				radioVoitElec.setSelected(false);
				radioVoitHybr.setSelected(false);
			}
			else if (e.getSource() == btnSupprimerSaison)
			{
				supprimerSaison();
				boxSaison.setSelectedIndex(0);
			}
			else if (e.getSource() == btnMAJSaison)
			{
				enregistrerSaison();
				boxSaison.setSelectedIndex(0);
			}
			else if (e.getSource() == btnAjouterCircuit)
			{
				DefaultListModel<String> listModel = new DefaultListModel<String>();
				for (int i = 0; i < lstCircuitsSelec.getModel().getSize(); i++)
				{
					listModel.addElement(lstCircuitsSelec.getModel().getElementAt(i));
				}
				listModel.addElement(lstCircuitsDispo.getSelectedValue());
				lstCircuitsSelec.setModel(listModel);
			}
			else if (e.getSource() == btnEnleverCircuit)
			{
				DefaultListModel<String> listModel = new DefaultListModel<String>();
				for (int i = 0; i < lstCircuitsSelec.getModel().getSize(); i++)
				{
					if (i != lstCircuitsSelec.getSelectedIndex())
					{
						listModel.addElement(lstCircuitsSelec.getModel().getElementAt(i));
					}
				}
				lstCircuitsSelec.setModel(listModel);
			}
			else if (e.getSource() == btnMAJCircuit)
			{
				enregistrerCircuit();
				rafraichirListeCircuitsDispo();
				boxCircuit.setSelectedIndex(0);
			}
			else if (e.getSource() == btnSupprimerCircuit)
			{
				supprimerCircuit();
				rafraichirListeCircuitsDispo();
				boxCircuit.setSelectedIndex(0);
			}
			else if (e.getSource() == btnMAJEcurie)
			{
				enregistrerEcurie();
				boxEcurie.setSelectedIndex(0);
			}
			else if (e.getSource() == btnSupprimerEcurie)
			{
				supprimerEcurie();
				boxEcurie.setSelectedIndex(0);
			}
			else if (e.getSource() == btnMAJVoiture)
			{
				enregistrerVoiture();
				boxVoiture.setSelectedIndex(0);
			}
			else if (e.getSource() == btnSupprimerVoiture)
			{
				supprimerVoiture();
				boxVoiture.setSelectedIndex(0);
			}
		}
	}
}
