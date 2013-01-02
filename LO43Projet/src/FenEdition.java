import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;

public class FenEdition extends JFrame {
	private static final long serialVersionUID = 1L;

/** Panneaux **/
	private JTabbedPane panOnglets;
	private JPanel panSaison;
	private JPanel panCircuit;
	private JPanel panEcurie;
	private JPanel panVoiture;
	private JPanel panVoitHybr;
	private JPanel panRetour;
	
/** Panneau Saison **/
	private JTextField txtNomSaison;
	private JLabel lblNomSaison;
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
	private JButton btnDessinerCircuit;
	
/** Panneau Ecurie **/
	private JTextField txtNomEcurie;
	private JLabel lblNomEcurie;
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
	private JComboBox<String> boxVoiture;
	private JSeparator sepHautVoiture;
	private JSeparator sepBasVoiture;
	private JButton btnReinitialiserVoiture;
	private JButton btnSupprimerVoiture;
	private JButton btnMAJVoiture;
	private JTextField txtNomVoitHybr;

/** Panneau Voiture hybride **/
	private JLabel lblVoitureHybride;
	private JLabel lblNomVoitHybr;
	private JLabel lblVMaxHybr;
	private JLabel lblArretStandHybr;
	private JLabel lblAutonomieHybr;
	private JLabel lblConsoHybr;
	private JLabel lblMoteur;
	private JLabel lblThermique;
	private JLabel lblElectrique;
	private JComboBox<String> boxVoitureHybr;
	private JSpinner spinVMaxTherm;
	private JSpinner spinTempsArretTherm;
	private JSpinner spinAutonomieTherm;
	private JSpinner spinConsoTherm;
	private JSpinner spinVMaxElec;
	private JSpinner spinTempsArretElec;
	private JSpinner spinAutonomieElec;
	private JSpinner spinConsoElec;
	private JSeparator sepHaut;
	private JSeparator sepBas;
	private JSeparator sepMilieu;
	private JSeparator sepColonnes;
	private JButton btnSupprimerVoitHybr;
	private JButton btnReinitialiserVoitHybr;
	private JButton btnMAJVoitHybr;
	
/** Panneau retour **/
	private JButton btnMenuPrincipal;
	private JButton btnAssistant1;
	private JButton btnAssistant2;


	public FenEdition(String fenetreOrigine) {
		setTitle("Mode Edition");
		setSize(435, 395);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		getContentPane().setLayout(null);
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
		
		panVoitHybr = new JPanel();
		panVoitHybr.setLayout(null);
		
		panRetour = new JPanel();
		panRetour.setLayout(null);
	
		panOnglets.addTab("Saison", null, panSaison, null);
		panOnglets.addTab("Circuit", null, panCircuit, null);
		panOnglets.addTab("Ecurie", null, panEcurie, null);
		panOnglets.addTab("Voiture", null, panVoiture, null);
		panOnglets.addTab("Voiture hybride", null, panVoitHybr, null);
		panOnglets.addTab("Retour", null, panRetour, null);
		
/** Panneau Saison **/
	/** TextBox **/
		txtNomSaison = new JTextField();
		txtNomSaison.addKeyListener(new FiltreTexte());
		txtNomSaison.setColumns(10);
		txtNomSaison.setBounds(147, 56, 140, 20);
		panSaison.add(txtNomSaison);
		
	/** Label **/
		lblNomSaison = new JLabel("Nom de la saison :");
		lblNomSaison.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomSaison.setBounds(36, 58, 103, 16);
		panSaison.add(lblNomSaison);
		
		lblSaison = new JLabel("Saison :");
		lblSaison.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSaison.setBounds(16, 13, 123, 14);
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
		boxSaison.setBounds(147, 10, 162, 20);		
		panSaison.add(boxSaison);
		
	/** Separator **/
		sepHautSaison = new JSeparator();
		sepHautSaison.setBounds(0, 40, 429, 5);
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
		btnSupprimerSaison.setBounds(321, 7, 98, 26);
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
		btnReinitialiserSaison.setBounds(12, 300, 105, 26);
		btnReinitialiserSaison.addActionListener(new GestionBoutons());
		panSaison.add(btnReinitialiserSaison);
	
/** Panneau Circuit **/
	/** TextBox **/
		txtNomCircuit = new JTextField();
		txtNomCircuit.addKeyListener(new FiltreTexte());
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
		
		btnDessinerCircuit = new JButton("Dessiner le circuit");
		btnDessinerCircuit.setBounds(133, 219, 170, 26);
		btnDessinerCircuit.addActionListener(new GestionBoutons());
		panCircuit.add(btnDessinerCircuit);
		
		
/** Panneau Ecurie **/
	/** TextBox **/
		txtNomEcurie = new JTextField();
		txtNomEcurie.addKeyListener(new FiltreTexte());
		txtNomEcurie.setColumns(10);
		txtNomEcurie.setBounds(136, 69, 140, 20);
		panEcurie.add(txtNomEcurie);
		
	/** Label **/
		lblNomEcurie = new JLabel("Nom de l'\u00E9curie :");
		lblNomEcurie.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomEcurie.setBounds(23, 71, 103, 16);
		panEcurie.add(lblNomEcurie);
		
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
		lblEcurie.setBounds(16, 13, 123, 14);
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
		boxEcurie.setBounds(147, 10, 162, 20);
		boxEcurie.addActionListener(new GestionMenus());
		panEcurie.add(boxEcurie);
		
		
	/** Separator **/
		sepBasEcurie = new JSeparator();
		sepBasEcurie.setBounds(0, 278, 434, 10);
		panEcurie.add(sepBasEcurie);
		
		sepHautEcurie = new JSeparator();
		sepHautEcurie.setBounds(0, 39, 429, 5);
		panEcurie.add(sepHautEcurie);
		
	/** Button **/
		btnSupprimerEcurie = new JButton("Supprimer");
		btnSupprimerEcurie.setBounds(321, 7, 98, 26);
		btnSupprimerEcurie.addActionListener(new GestionBoutons());
		panEcurie.add(btnSupprimerEcurie);
	
		btnReinitialiserEcurie = new JButton("R\u00E9initialiser");
		btnReinitialiserEcurie.setBounds(12, 300, 105, 26);
		btnReinitialiserEcurie.addActionListener(new GestionBoutons());
		panEcurie.add(btnReinitialiserEcurie);
		
		btnMAJEcurie = new JButton("Mettre \u00E0 jour");
		btnMAJEcurie.setBounds(297, 300, 115, 26);
		btnMAJEcurie.addActionListener(new GestionBoutons());
		panEcurie.add(btnMAJEcurie);
		

/*** Panneau Voiture **/
	/** TextBox **/
		txtNomVoiture = new JTextField();
		txtNomVoiture.addKeyListener(new FiltreTexte());
		txtNomVoiture.setColumns(10);
		txtNomVoiture.setBounds(152, 56, 135, 20);
		panVoiture.add(txtNomVoiture);
		
	/** Label **/
		lblVoiture = new JLabel("Voiture :");
		lblVoiture.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVoiture.setBounds(16, 13, 123, 14);
		panVoiture.add(lblVoiture);
		
		lblNomVoiture = new JLabel("Nom de la voiture :");
		lblNomVoiture.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomVoiture.setBounds(0, 61, 142, 14);
		panVoiture.add(lblNomVoiture);
		
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
		
		ButtonGroup groupType = new ButtonGroup();
		groupType.add(radioVoitTherm);
		groupType.add(radioVoitElec);
		
	/** ComboBox **/
		boxVoiture = new JComboBox<String>();
		boxVoiture.setModel(new DefaultComboBoxModel<String>(new String[] {"Choisir une voiture", "Nouvelle voiture"}));
		boxVoiture.setBounds(147, 10, 162, 20);
		boxVoiture.addActionListener(new GestionMenus());
		panVoiture.add(boxVoiture);
		
	/** Separator **/
		sepHautVoiture = new JSeparator();
		sepHautVoiture.setBounds(0, 39, 429, 5);
		panVoiture.add(sepHautVoiture);
		
		sepBasVoiture = new JSeparator();
		sepBasVoiture.setBounds(0, 279, 424, 16);
		panVoiture.add(sepBasVoiture);
		
	/** Button **/
		btnReinitialiserVoiture = new JButton("R\u00E9initialiser");
		btnReinitialiserVoiture.setBounds(12, 300, 105, 26);
		btnReinitialiserVoiture.addActionListener(new GestionBoutons());
		panVoiture.add(btnReinitialiserVoiture);
		
	    btnSupprimerVoiture = new JButton("Supprimer");
		btnSupprimerVoiture.setBounds(321, 7, 98, 26);
		btnSupprimerVoiture.addActionListener(new GestionBoutons());
		panVoiture.add(btnSupprimerVoiture);
		
		btnMAJVoiture = new JButton("Mettre \u00E0 jour");
		btnMAJVoiture.setBounds(296, 300, 116, 26);
		btnMAJVoiture.addActionListener(new GestionBoutons());
		panVoiture.add(btnMAJVoiture);
	
/** Panneau Voiture Hybride **/
	/** TextBox **/
		txtNomVoitHybr = new JTextField();
		txtNomVoitHybr.setColumns(10);
		txtNomVoitHybr.setBounds(206, 57, 135, 20);
		txtNomVoitHybr.addKeyListener(new FiltreTexte());
		panVoitHybr.add(txtNomVoitHybr);
		
	/** Label **/
		lblVoitureHybride = new JLabel("Voiture hybride :");
		lblVoitureHybride.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVoitureHybride.setBounds(16, 13, 123, 14);
		panVoitHybr.add(lblVoitureHybride);
		
		lblNomVoitHybr = new JLabel("Nom de la voiture hybride :");
		lblNomVoitHybr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomVoitHybr.setBounds(0, 60, 195, 14);
		panVoitHybr.add(lblNomVoitHybr);
		
		lblVMaxHybr = new JLabel("Vitesse maximale :");
		lblVMaxHybr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVMaxHybr.setBounds(0, 118, 142, 16);
		panVoitHybr.add(lblVMaxHybr);
		
		lblArretStandHybr = new JLabel("Temps d'arr\u00EAt au stand :");
		lblArretStandHybr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblArretStandHybr.setBounds(0, 145, 142, 16);
		panVoitHybr.add(lblArretStandHybr);
		
		lblAutonomieHybr = new JLabel("Autonomie :");
		lblAutonomieHybr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAutonomieHybr.setBounds(0, 173, 142, 16);
		panVoitHybr.add(lblAutonomieHybr);
		
		lblConsoHybr = new JLabel("Consommation :");
		lblConsoHybr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConsoHybr.setBounds(0, 201, 142, 16);
		panVoitHybr.add(lblConsoHybr);
		
		lblMoteur = new JLabel("Moteur");
		lblMoteur.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMoteur.setBounds(85, 93, 54, 14);
		panVoitHybr.add(lblMoteur);
		
		lblThermique = new JLabel("Thermique");
		lblThermique.setHorizontalAlignment(SwingConstants.CENTER);
		lblThermique.setBounds(151, 93, 80, 14);
		panVoitHybr.add(lblThermique);
		
		lblElectrique = new JLabel("Electrique");
		lblElectrique.setHorizontalAlignment(SwingConstants.CENTER);
		lblElectrique.setBounds(249, 93, 57, 14);
		panVoitHybr.add(lblElectrique);
		
	/** ComboBox **/
		boxVoitureHybr = new JComboBox<String>();
		boxVoitureHybr.setModel(new DefaultComboBoxModel<String>(new String[] {"Choisir une voiture", "Nouvelle voiture hybride"}));
		boxVoitureHybr.setBounds(147, 10, 162, 20);
		boxVoitureHybr.addActionListener(new GestionMenus());
		panVoitHybr.add(boxVoitureHybr);
		
	/** Spinner **/
		spinVMaxTherm = new JSpinner();
		spinVMaxTherm.setBounds(161, 114, 57, 20);
		spinVMaxTherm.setModel(new SpinnerNumberModel(new Integer(100), new Integer(0), null, new Integer(10)));
		panVoitHybr.add(spinVMaxTherm);
		
		spinTempsArretTherm = new JSpinner();
		spinTempsArretTherm.setBounds(161, 141, 57, 20);
		spinTempsArretTherm.setModel(new SpinnerNumberModel(new Integer(10), new Integer(1), null, new Integer(1)));
		panVoitHybr.add(spinTempsArretTherm);
		
		spinAutonomieTherm = new JSpinner();
		spinAutonomieTherm.setBounds(161, 169, 57, 20);
		spinAutonomieTherm.setModel(new SpinnerNumberModel(new Integer(100), new Integer(1), null, new Integer(10)));
		panVoitHybr.add(spinAutonomieTherm);
		
		spinConsoTherm = new JSpinner();
		spinConsoTherm.setBounds(161, 197, 57, 20);
		spinConsoTherm.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		panVoitHybr.add(spinConsoTherm);
		
		spinVMaxElec = new JSpinner();
		spinVMaxElec.setBounds(249, 114, 57, 20);
		spinVMaxElec.setModel(new SpinnerNumberModel(new Integer(100), new Integer(0), null, new Integer(10)));
		panVoitHybr.add(spinVMaxElec);
		
		spinTempsArretElec = new JSpinner();
		spinTempsArretElec.setBounds(249, 141, 57, 20);
		spinTempsArretElec.setModel(new SpinnerNumberModel(new Integer(10), new Integer(1), null, new Integer(1)));
		panVoitHybr.add(spinTempsArretElec);
		
		spinAutonomieElec = new JSpinner();
		spinAutonomieElec.setBounds(249, 169, 57, 20);
		spinAutonomieElec.setModel(new SpinnerNumberModel(new Integer(100), new Integer(1), null, new Integer(10)));
		panVoitHybr.add(spinAutonomieElec);
		
		spinConsoElec = new JSpinner();
		spinConsoElec.setBounds(249, 197, 57, 20);
		spinConsoElec.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		panVoitHybr.add(spinConsoElec);
		
	/** Separator **/
		sepHaut = new JSeparator();
		sepHaut.setBounds(0, 39, 429, 5);
		panVoitHybr.add(sepHaut);
		
		sepBas = new JSeparator();
		sepBas.setBounds(0, 281, 424, 16);
		panVoitHybr.add(sepBas);
		
		sepMilieu = new JSeparator();
		sepMilieu.setBounds(19, 108, 296, 5);
		panVoitHybr.add(sepMilieu);
		
		sepColonnes = new JSeparator();
		sepColonnes.setOrientation(SwingConstants.VERTICAL);
		sepColonnes.setBounds(236, 86, 5, 147);
		panVoitHybr.add(sepColonnes);
		
	/** Button **/
		btnSupprimerVoitHybr = new JButton("Supprimer");
		btnSupprimerVoitHybr.setBounds(321, 7, 98, 26);
		btnSupprimerVoitHybr.addActionListener(new GestionBoutons());
		panVoitHybr.add(btnSupprimerVoitHybr);
		
		btnReinitialiserVoitHybr = new JButton("R\u00E9initialiser");
		btnReinitialiserVoitHybr.setBounds(12, 302, 105, 26);
		btnReinitialiserVoitHybr.addActionListener(new GestionBoutons());
		panVoitHybr.add(btnReinitialiserVoitHybr);
		
		btnMAJVoitHybr = new JButton("Mettre \u00E0 jour");
		btnMAJVoitHybr.setBounds(296, 302, 116, 26);
		btnMAJVoitHybr.addActionListener(new GestionBoutons());
		panVoitHybr.add(btnMAJVoitHybr);
		
/** Panneau Retour **/
		btnMenuPrincipal = new JButton("Menu principal");
		btnMenuPrincipal.setBounds(142, 103, 130, 26);
		btnMenuPrincipal.setEnabled(fenetreOrigine.equals("Menu principal"));
		btnMenuPrincipal.addActionListener(new GestionBoutons());
		panRetour.add(btnMenuPrincipal);
		
		btnAssistant1 = new JButton("Assistant 1");
		btnAssistant1.setBounds(142, 141, 130, 26);
		btnAssistant1.setEnabled(fenetreOrigine.equals("Assistant 1"));
		btnAssistant1.addActionListener(new GestionBoutons());
		panRetour.add(btnAssistant1);
		
		btnAssistant2 = new JButton("Assistant 2");
		btnAssistant2.setBounds(142, 179, 130, 26);
		btnAssistant2.setEnabled(fenetreOrigine.equals("Assistant 2"));
		btnAssistant2.addActionListener(new GestionBoutons());
		panRetour.add(btnAssistant2);
		
		setEnabledSaison(false);
		setEnabledCircuit(false);
		setEnabledEcurie(false);
		setEnabledVoiture(false);
		setEnabledVoitureHybride(false);
		chargerSaisons();
		chargerCircuits();
		chargerEcuries();
		chargerVoitures();
		setVisible(true);
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
			if (tmp.endsWith(".voi"))
			{
				tmp = tmp.replace(".voi", "");
				boxVoiture.addItem(tmp);
				
				try{
					InputStream ips=new FileInputStream(listeFichiers[i].toString()); 
					InputStreamReader ipsr=new InputStreamReader(ips);
					BufferedReader br=new BufferedReader(ipsr);
					
					for (int j = 0; j < 5; j++)
					{
						br.readLine();
					}
					
					if (Integer.parseInt(br.readLine()) == 1)
					{
						boxVoitTherm.addItem(tmp);
					}
					else
					{
						boxVoitElec.addItem(tmp);
					}
					
					br.close(); 
				}
				catch (Exception exc){
					System.out.println(exc.toString());
				}	
			}
			else if (tmp.endsWith(".vhy"))
			{
				tmp = tmp.replace(".vhy", "");
				boxVoitureHybr.addItem(tmp);
				boxVoitHybr.addItem(tmp);
			}
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
	
	public void setEnabledSaison(boolean b)
	{
		txtNomSaison.setEnabled(b);
		btnMAJSaison.setEnabled(b);
		btnReinitialiserSaison.setEnabled(b);
		btnAjouterCircuit.setEnabled(b);
		btnEnleverCircuit.setEnabled(b);
		btnSupprimerSaison.setEnabled(b);
		lstCircuitsDispo.setEnabled(b);
		lstCircuitsSelec.setEnabled(b);

	}
	
	public void setEnabledCircuit(boolean b)
	{
		txtNomCircuit.setEnabled(b);
		btnMAJCircuit.setEnabled(b);
		btnReinitialiserCircuit.setEnabled(b);
		btnSupprimerCircuit.setEnabled(b);
		btnDessinerCircuit.setEnabled(b);
		spinLongueurCircuit.setEnabled(b);
		spinNbreTours.setEnabled(b);
		spinVitesseMax.setEnabled(b);
		spinPositionStands.setEnabled(b);
		
	}
	
	public void setEnabledEcurie(boolean b)
	{
		txtNomEcurie.setEnabled(b);
		btnMAJEcurie.setEnabled(b);
		btnReinitialiserEcurie.setEnabled(b);
		btnSupprimerEcurie.setEnabled(b);
		boxVoitTherm.setEnabled(b);
		boxVoitElec.setEnabled(b);
		boxVoitHybr.setEnabled(b);
	}
	
	public void setEnabledVoiture(boolean b)
	{
		txtNomVoiture.setEnabled(b);
		btnMAJVoiture.setEnabled(b);
		btnReinitialiserVoiture.setEnabled(b);
		btnSupprimerVoiture.setEnabled(b);
		spinAutonomie.setEnabled(b);
		spinConso.setEnabled(b);
		spinTempsArret.setEnabled(b);
		spinVMax.setEnabled(b);
		radioVoitTherm.setEnabled(b);
		radioVoitElec.setEnabled(b);
	}
	
	public void setEnabledVoitureHybride(boolean b)
	{
		txtNomVoitHybr.setEnabled(b);
		btnMAJVoitHybr.setEnabled(b);
		btnReinitialiserVoitHybr.setEnabled(b);
		btnSupprimerVoitHybr.setEnabled(b);
		spinTempsArretTherm.setEnabled(b);
		spinTempsArretElec.setEnabled(b);
		spinAutonomieTherm.setEnabled(b);
		spinAutonomieElec.setEnabled(b);
		spinConsoTherm.setEnabled(b);
		spinConsoElec.setEnabled(b);
		spinVMaxTherm.setEnabled(b);
		spinVMaxElec.setEnabled(b);
	}
	
	class FiltreTexte implements KeyListener
	{
		public void keyTyped(KeyEvent evt) {
			char c = evt.getKeyChar();
			if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' '))
			{
				evt.consume();
			}
		}

		public void keyPressed(KeyEvent arg0) {
		}

		public void keyReleased(KeyEvent arg0) {
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
				if (boxSaison.getSelectedIndex() == 0)
				{
					setEnabledSaison(false);
				}
				else if (boxSaison.getSelectedIndex() == 1)
				{
					setEnabledSaison(true);
					btnSupprimerSaison.setEnabled(false);
					txtNomSaison.setText("");
					lstCircuitsSelec.setListData(new String[0]);
				}
				else
				{
					setEnabledSaison(true);
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
				if (boxCircuit.getSelectedIndex() == 0)
				{
					setEnabledCircuit(false);
				}
				else if (boxCircuit.getSelectedIndex() == 1)
				{
					setEnabledCircuit(true);
					btnSupprimerCircuit.setEnabled(false);
					txtNomCircuit.setText("");
					spinLongueurCircuit.setValue(new Integer(1000));
					spinPositionStands.setValue(new Integer(10));
					spinVitesseMax.setValue(new Integer(300));
					spinNbreTours.setValue(new Integer(3));
				}
				else
				{
					setEnabledCircuit(true);
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
				if (boxEcurie.getSelectedIndex() == 0)
				{
					setEnabledEcurie(false);
				}
				else if(boxEcurie.getSelectedIndex() == 1)
				{
					setEnabledEcurie(true);
					btnSupprimerEcurie.setEnabled(false);
					txtNomEcurie.setText("");
					boxVoitTherm.setSelectedIndex(0);
					boxVoitElec.setSelectedIndex(0);
					boxVoitHybr.setSelectedIndex(0);
				}
				else
				{
					setEnabledEcurie(true);
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
				if (boxVoiture.getSelectedIndex() == 0)
				{
					setEnabledVoiture(false);
				}
				else if(boxVoiture.getSelectedIndex() == 1)
				{
					setEnabledVoiture(true);
					btnSupprimerVoiture.setEnabled(false);
					txtNomVoiture.setText("");
					spinVMax.setValue(new Integer(300));
					spinTempsArret.setValue(new Integer(10));
					spinAutonomie.setValue(new Integer(1000));
					spinConso.setValue(new Integer(3));
				}
				else
				{
					setEnabledVoiture(true);
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
								break;
							case 2:
								radioVoitElec.setSelected(true);
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
			else if (e.getSource() == boxVoitureHybr)
			{
				if (boxVoitureHybr.getSelectedIndex() == 0)
				{
					setEnabledVoitureHybride(false);
				}
				else if(boxVoitureHybr.getSelectedIndex() == 1)
				{
					setEnabledVoitureHybride(true);
					btnSupprimerVoitHybr.setEnabled(false);
					txtNomVoitHybr.setText("");
					spinVMaxTherm.setValue(new Integer(300));
					spinVMaxElec.setValue(new Integer(300));
					spinTempsArretTherm.setValue(new Integer(10));
					spinTempsArretElec.setValue(new Integer(10));
					spinAutonomieTherm.setValue(new Integer(1000));
					spinAutonomieElec.setValue(new Integer(1000));
					spinConsoTherm.setValue(new Integer(3));
					spinConsoElec.setValue(new Integer(3));
				}
				else
				{
					setEnabledVoitureHybride(true);
					
					try{
						File rep = new File("Voitures");
						File[] listeFichiers = rep.listFiles();
						File fichier = null;
						for (int i = 0; i < listeFichiers.length; i++)
						{
							if (listeFichiers[i].toString().contains((CharSequence) boxVoitureHybr.getSelectedItem()))
							{
								fichier = listeFichiers[i];
							}
						}
						InputStream ips=new FileInputStream(fichier); 
						InputStreamReader ipsr=new InputStreamReader(ips);
						BufferedReader br=new BufferedReader(ipsr);
						
						txtNomVoitHybr.setText(br.readLine());
						spinVMaxTherm.setValue(Integer.parseInt(br.readLine()));
						spinTempsArretTherm.setValue(Integer.parseInt(br.readLine()));
						spinAutonomieTherm.setValue(Integer.parseInt(br.readLine()));
						spinConsoTherm.setValue(Integer.parseInt(br.readLine()));
						spinVMaxElec.setValue(Integer.parseInt(br.readLine()));
						spinTempsArretElec.setValue(Integer.parseInt(br.readLine()));
						spinAutonomieElec.setValue(Integer.parseInt(br.readLine()));
						spinConsoElec.setValue(Integer.parseInt(br.readLine()));
						
						br.close();
					}		
					catch (Exception exc){
						System.out.println(exc.toString());
					}
				}
			}
		}
	}
	
	public void supprimerSaison(int index)
	{
		String fichier = "Saisons\\" + boxSaison.getItemAt(index) + ".sai";
		File f = new File(fichier);
		if (f.exists())
		{
			f.delete();
		}
	}
	
	public void enregistrerSaison()
	{
		int index = boxSaison.getSelectedIndex();
		File fichier = new File("Saisons\\" + boxSaison.getSelectedItem() + ".sai");

		if (fichier.exists() && !boxSaison.getSelectedItem().equals(txtNomSaison.getText()))
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
		if (boxSaison.getSelectedIndex() != 1)
		{
			boxSaison.removeItemAt(index);
		}
	}
	
	public void supprimerCircuit(int index)
	{
		String fichier = "Circuits\\" + boxCircuit.getItemAt(index) + ".cir";
		File f = new File(fichier);
		if (f.exists())
		{
			f.delete();
		}
	}
	
	public void enregistrerCircuit()
	{
		int index = boxCircuit.getSelectedIndex();
		File fichier = new File("Circuits\\" + boxCircuit.getSelectedItem() + ".cir");
		
		if (fichier.exists() && !boxCircuit.getSelectedItem().equals(txtNomCircuit.getText()))
		{
			fichier.renameTo(new File("Circuits\\" + txtNomCircuit.getText() + ".cir"));
			
			File rep = new File("Saisons");
			File[] listeSaisons = rep.listFiles();
			
			for (int i = 0; i < listeSaisons.length; i++)
			{
				String s;
				String tmp;
				try{
					FileReader fr = new FileReader (listeSaisons[i]);
					BufferedReader br = new BufferedReader (fr);
					
					s = br.readLine() + "\n";
					tmp = br.readLine();
					s = s + tmp + "\n";
					int nbrCircuits = Integer.parseInt(tmp);
					for (int j = 0; j < nbrCircuits; j++)
					{
						tmp = br.readLine();
						if (boxCircuit.getSelectedItem().equals(tmp))
						{
							s = s + txtNomCircuit.getText() + "\n";
						}
						else
						{
							s = s + tmp + "\n";
						}
					}
					
					br.close();
					
					FileWriter fw = new FileWriter (listeSaisons[i]);
					BufferedWriter bw = new BufferedWriter (fw);
					PrintWriter fichierSortie = new PrintWriter (bw);

					fichierSortie.print(s);
					bw.close();
				}
				catch (Exception exc){
					System.out.println(exc.toString());
				}
			}
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
		if (boxCircuit.getSelectedIndex() != 1)
		{
			boxCircuit.removeItemAt(index);
		}
	}
	
	public void supprimerEcurie(int index)
	{
		String fichier = "Ecuries\\" + boxEcurie.getItemAt(index) + ".ecu";
		File f = new File(fichier);
		if (f.exists())
		{
			f.delete();
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
		if (boxEcurie.getSelectedIndex() != 1)
		{
			boxEcurie.removeItemAt(index);
		}
	}
	
	public void supprimerVoiture(int index)
	{
		String fichier = "Voitures\\" + boxVoiture.getSelectedItem() + ".voi";
		File f = new File(fichier);
		if (f.exists())
		{
			f.delete();
		}
	}
		
	public void enregistrerVoiture()
	{
		File dossier = new File("Voitures");
		File[] listeVoitures = dossier.listFiles();
		File fichierExistant = null;

		for (int i = 0; i < listeVoitures.length; i++)
		{
			if (listeVoitures[i].toString().contains((CharSequence) boxVoiture.getSelectedItem()))
			{
				fichierExistant = listeVoitures[i];
			}
		}
		
		if (fichierExistant != null)
		{
			fichierExistant.renameTo(new File("Voitures\\" + txtNomVoiture.getText() + ".voi"));
		}
		
		try {
			FileWriter fw = new FileWriter ("Voitures\\" + txtNomVoiture.getText() + ".voi");
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
			fichierSortie.close();
		}
		catch (Exception exc){
			System.out.println(exc.toString());
		}
	}
	
	public void supprimerVoitureHybr(int index)
	{
		String fichier = "Voitures\\" + boxVoitureHybr.getSelectedItem() + ".vhy";
		File f = new File(fichier);
		if (f.exists())
		{
			f.delete();
		}
	}
	
	public void enregistrerVoitureHybr()
	{
		File dossier = new File("Voitures");
		File[] listeVoitures = dossier.listFiles();
		File fichierExistant = null;

		for (int i = 0; i < listeVoitures.length; i++)
		{
			if (listeVoitures[i].toString().contains((CharSequence) boxVoitureHybr.getSelectedItem()))
			{
				fichierExistant = listeVoitures[i];
			}
		}
		
		if (fichierExistant != null)
		{
			fichierExistant.renameTo(new File("Voitures\\" + txtNomVoitHybr.getText() + ".vhy"));
		}
		
		try {
			FileWriter fw = new FileWriter ("Voitures\\" + txtNomVoitHybr.getText() + ".vhy");
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter fichierSortie = new PrintWriter (bw);
				fichierSortie.println(txtNomVoitHybr.getText());
				fichierSortie.println(spinVMaxTherm.getValue().toString());
				fichierSortie.println(spinTempsArretTherm.getValue().toString());
				fichierSortie.println(spinAutonomieTherm.getValue().toString());
				fichierSortie.println(spinConsoTherm.getValue().toString()); 
				fichierSortie.println(spinVMaxElec.getValue().toString());
				fichierSortie.println(spinTempsArretElec.getValue().toString());
				fichierSortie.println(spinAutonomieElec.getValue().toString());
				fichierSortie.println(spinConsoElec.getValue().toString()); 
			fichierSortie.close();
		}
		catch (Exception exc){
			System.out.println(exc.toString());
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
	
	public void rafraichirVoituresDispo()
	{
		boxVoitTherm.removeAllItems();
		boxVoitTherm.addItem("Choisir une voiture");
		boxVoitElec.removeAllItems();
		boxVoitElec.addItem("Choisir une voiture");
		boxVoitHybr.removeAllItems();
		boxVoitHybr.addItem("Choisir une voiture");
		boxVoiture.removeAllItems();
		boxVoiture.addItem("Choisir une voiture");
		boxVoiture.addItem("Nouvelle voiture");
		boxVoitureHybr.removeAllItems();
		boxVoitureHybr.addItem("Choisir une voiture");
		boxVoitureHybr.addItem("Nouvelle voiture");
		chargerVoitures();
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
				spinVMax.setValue(new Integer(300));
				spinTempsArret.setValue(new Integer(10));
				spinAutonomie.setValue(new Integer(1000));
				spinConso.setValue(new Integer(3));
				radioVoitTherm.setSelected(false);
				radioVoitElec.setSelected(false);
			}
			else if (e.getSource() == btnReinitialiserVoitHybr)
			{
				txtNomVoitHybr.setText("");
				spinVMaxTherm.setValue(new Integer(300));
				spinVMaxElec.setValue(new Integer(300));
				spinTempsArretTherm.setValue(new Integer(10));
				spinTempsArretElec.setValue(new Integer(10));
				spinAutonomieTherm.setValue(new Integer(1000));
				spinAutonomieElec.setValue(new Integer(1000));
				spinConsoTherm.setValue(new Integer(3));
				spinConsoElec.setValue(new Integer(3));
			}
			else if (e.getSource() == btnSupprimerSaison)
			{
				int index = boxSaison.getSelectedIndex();
				supprimerSaison(index);
				boxSaison.removeItemAt(index);
				boxSaison.setSelectedIndex(0);
			}
			else if (e.getSource() == btnMAJSaison)
			{
				if (txtNomSaison.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Veuillez entrer un nom !", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					File fichier_dest = new File("Saisons\\" + txtNomSaison.getText() + ".sai");
					if (fichier_dest.exists() && !boxSaison.getSelectedItem().equals(txtNomSaison.getText()))
					{
						JOptionPane.showMessageDialog(null, "Ce nom est déjà utilisé !", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						if (lstCircuitsSelec.getModel().getSize() == 0)
						{
							JOptionPane.showMessageDialog(null, "Veuillez sélectionner au moins un circuit !", "Erreur", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							enregistrerSaison();
							boxSaison.setSelectedIndex(0);
						}
					}
				}
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
				if (txtNomCircuit.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Veuillez entrer un nom !", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					File fichier_dest = new File("Circuits\\" + txtNomCircuit.getText() + ".cir");
					if (fichier_dest.exists() && !boxCircuit.getSelectedItem().equals(txtNomCircuit.getText()))
					{
						JOptionPane.showMessageDialog(null, "Ce nom est déjà utilisé !", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						enregistrerCircuit();
						rafraichirListeCircuitsDispo();
						boxCircuit.setSelectedIndex(0);
					}
					
				}
			}
			else if (e.getSource() == btnSupprimerCircuit)
			{
				boolean found = false;
				File rep = new File("Saisons");
				File[] listeFichiers = rep.listFiles();
				int i = 0;
				
				while (i < listeFichiers.length && !found)
				{
					try{
						InputStream ips=new FileInputStream(listeFichiers[i].toString()); 
						InputStreamReader ipsr=new InputStreamReader(ips);
						BufferedReader br=new BufferedReader(ipsr);
						br.readLine();
						int nbrCircuits = Integer.parseInt(br.readLine());
						for (int j = 0; j < nbrCircuits; j++)
						{
							if (boxCircuit.getSelectedItem().equals(br.readLine()))
							{
								found = true;
							}
						}
						
						br.close(); 
					}
					catch (Exception exc){
						System.out.println(exc.toString());
					}
					
					i++;
				}
				
				if (found)
				{
					JOptionPane.showMessageDialog(null, "Impossible de supprimer le circuit !\nCelui-ci est utilisé dans une saison.", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					int index = boxCircuit.getSelectedIndex();
					supprimerCircuit(index);
					rafraichirListeCircuitsDispo();
					boxCircuit.removeItemAt(index);
					boxCircuit.setSelectedIndex(0);
				}
			}
			else if (e.getSource() == btnDessinerCircuit)
			{
				if (txtNomCircuit.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Veuillez entrer un nom !", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					txtNomCircuit.setEnabled(false);
					new FenDessin(txtNomCircuit.getText());
				}
			}
			else if (e.getSource() == btnMAJEcurie)
			{
				if (boxVoitTherm.getSelectedIndex() == 0 || boxVoitElec.getSelectedIndex() == 0 || boxVoitHybr.getSelectedIndex() == 0)
				{
					JOptionPane.showMessageDialog(null, "Veuillez sélectionner 3 voitures !", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					if (txtNomEcurie.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Veuillez entrer un nom !", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						enregistrerEcurie();
						boxEcurie.setSelectedIndex(0);
					}
				}
			}
			else if (e.getSource() == btnSupprimerEcurie)
			{
				int index = boxEcurie.getSelectedIndex();
				supprimerEcurie(index);
				boxEcurie.removeItemAt(index);
				boxEcurie.setSelectedIndex(0);
			}
			else if (e.getSource() == btnMAJVoiture)
			{
				if (txtNomVoiture.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Veuillez entrer un nom !", "Erreur", JOptionPane.ERROR_MESSAGE);			
				}
				else
				{
					if (!radioVoitTherm.isSelected() && !radioVoitElec.isSelected())
					{
						JOptionPane.showMessageDialog(null, "Veuillez choisir le type !", "Erreur", JOptionPane.ERROR_MESSAGE);		
					}
					else
					{
						enregistrerVoiture();
						rafraichirVoituresDispo();
						boxVoiture.setSelectedIndex(0);
					}
				}
			}
			else if (e.getSource() == btnSupprimerVoiture)
			{
				boolean found = false;
				File rep = new File("Ecuries");
				File[] listeFichiers = rep.listFiles();
				int i = 0;
				
				while (i < listeFichiers.length && !found)
				{
					try{
						InputStream ips=new FileInputStream(listeFichiers[i].toString()); 
						InputStreamReader ipsr=new InputStreamReader(ips);
						BufferedReader br=new BufferedReader(ipsr);
						br.readLine();
						for (int j = 0; j < 3; j++)
						{
							if (boxVoiture.getSelectedItem().equals(br.readLine()))
							{
								found = true;
							}
						}
						
						br.close(); 
					}
					catch (Exception exc){
						System.out.println(exc.toString());
					}
					
					i++;
				}
				
				if (found)
				{
					JOptionPane.showMessageDialog(null, "Impossible de supprimer la voiture !\nCelle-ci est utilisée dans une écurie.", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					int index = boxVoiture.getSelectedIndex();
					supprimerVoiture(index);
					boxVoiture.removeItemAt(index);
					rafraichirVoituresDispo();
					boxVoiture.setSelectedIndex(0);
				}
			}
			else if (e.getSource() == btnMAJVoitHybr)
			{
				if (txtNomVoitHybr.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Veuillez entrer un nom !", "Erreur", JOptionPane.ERROR_MESSAGE);			
				}
				else
				{
					enregistrerVoitureHybr();
					rafraichirVoituresDispo();
					boxVoitureHybr.setSelectedIndex(0);
				}
			}
			else if (e.getSource() == btnSupprimerVoitHybr)
			{
				boolean found = false;
				File rep = new File("Ecuries");
				File[] listeFichiers = rep.listFiles();
				int i = 0;
				
				while (i < listeFichiers.length && !found)
				{
					try{
						InputStream ips=new FileInputStream(listeFichiers[i].toString()); 
						InputStreamReader ipsr=new InputStreamReader(ips);
						BufferedReader br=new BufferedReader(ipsr);
						br.readLine();
						for (int j = 0; j < 3; j++)
						{
							if (boxVoitureHybr.getSelectedItem().equals(br.readLine()))
							{
								found = true;
							}
						}
						
						br.close(); 
					}
					catch (Exception exc){
						System.out.println(exc.toString());
					}
					
					i++;
				}
				
				if (found)
				{
					JOptionPane.showMessageDialog(null, "Impossible de supprimer la voiture !\nCelle-ci est utilisée dans une écurie.", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					int index = boxVoitureHybr.getSelectedIndex();
					supprimerVoitureHybr(index);
					boxVoitureHybr.removeItemAt(index);
					rafraichirVoituresDispo();
					boxVoitureHybr.setSelectedIndex(0);
				}
			}
			else if (e.getSource() == btnMenuPrincipal)
			{
				setVisible(false);
				dispose();
				new FenPrincipale();
			}
			else if (e.getSource() == btnAssistant1)
			{
				setVisible(false);
				dispose();
				new FenAssistant1();
			}
			else if (e.getSource() == btnAssistant2)
			{
				setVisible(false);
				dispose();
				new FenAssistant2();
			}
		}
	}
}
