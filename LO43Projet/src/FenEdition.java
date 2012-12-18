import javax.swing.*;


import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JComboBox<Saison> boxSaison;
	private JList<Circuit> lstCircuitsDispo;
	private JList<Circuit> lstCircuitsSelec;
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
	private JComboBox<Circuit> boxCircuit;
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
	private JComboBox<Voiture> boxVoitTherm;
	private JComboBox<Voiture> boxVoitElec;
	private JComboBox<Voiture_hybride> boxVoitHybr;
	private JComboBox<Saison> boxEcurie;
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
	private JComboBox<Saison> boxVoiture;
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
		boxSaison = new JComboBox<Saison>();
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
		lstCircuitsDispo = new JList<Circuit>();
		lstCircuitsDispo.setBounds(15, 106, 188, 133);
		panSaison.add(lstCircuitsDispo);
		
		lstCircuitsSelec = new JList<Circuit>();
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
		btnMAJSaison.setBounds(314, 300, 98, 26);
		btnMAJSaison.addActionListener(new GestionBoutons());
		panSaison.add(btnMAJSaison);		
		
		btnReinitialiserSaison = new JButton("R\u00E9initialiser");
		btnReinitialiserSaison.setBounds(12, 300, 98, 26);
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
		spinLongueurCircuit.setBounds(164, 82, 72, 20);
		panCircuit.add(spinLongueurCircuit);
		
		spinPositionStands = new JSpinner();
		spinPositionStands.setBounds(164, 110, 72, 20);
		panCircuit.add(spinPositionStands);
		
		spinVitesseMax = new JSpinner();
		spinVitesseMax.setBounds(163, 138, 72, 20);
		panCircuit.add(spinVitesseMax);
	
		spinNbreTours = new JSpinner();
		spinNbreTours.setModel(new SpinnerNumberModel(new Integer(3), new Integer(1), null, new Integer(1)));
		spinNbreTours.setBounds(164, 168, 72, 20);
		panCircuit.add(spinNbreTours);
				
	/** ComboBox **/
		boxCircuit = new JComboBox<Circuit>();
		boxCircuit.setBounds(147, 10, 162, 20);
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
		btnMAJCircuit.setBounds(314, 300, 98, 26);
		btnMAJCircuit.addActionListener(new GestionBoutons());
		panCircuit.add(btnMAJCircuit);
		
		btnReinitialiserCircuit = new JButton("R\u00E9initialiser");
		btnReinitialiserCircuit.setBounds(12, 300, 98, 26);
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
		boxVoitTherm = new JComboBox<Voiture>();
		boxVoitTherm.setBounds(134, 100, 188, 25);
		panEcurie.add(boxVoitTherm);
		
		boxVoitElec = new JComboBox<Voiture>();
		boxVoitElec.setBounds(134, 132, 188, 25);
		panEcurie.add(boxVoitElec);
		
		boxVoitHybr = new JComboBox<Voiture_hybride>();
		boxVoitHybr.setBounds(134, 164, 188, 25);
		panEcurie.add(boxVoitHybr);
		
		boxEcurie = new JComboBox<Saison>();
		boxEcurie.setBounds(147, 14, 162, 20);
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
		btnReinitialiserEcurie.setBounds(12, 300, 98, 26);
		btnReinitialiserEcurie.addActionListener(new GestionBoutons());
		panEcurie.add(btnReinitialiserEcurie);
		
		btnMAJEcurie = new JButton("Mettre \u00E0 jour");
		btnMAJEcurie.setBounds(314, 300, 98, 26);
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
		spinVMax.setBounds(152, 82, 57, 20);
		panVoiture.add(spinVMax);
		
		spinTempsArret = new JSpinner();
		spinTempsArret.setBounds(152, 109, 57, 20);
		panVoiture.add(spinTempsArret);
				
		spinAutonomie = new JSpinner();
		spinAutonomie.setBounds(152, 137, 57, 20);
		panVoiture.add(spinAutonomie);
	
		spinConso = new JSpinner();
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
		boxVoiture = new JComboBox<Saison>();
		boxVoiture.setBounds(142, 11, 162, 20);
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
		btnReinitialiserVoiture.setBounds(11, 300, 98, 26);
		btnReinitialiserVoiture.addActionListener(new GestionBoutons());
		panVoiture.add(btnReinitialiserVoiture);
		
	    btnSupprimerVoiture = new JButton("Supprimer");
		btnSupprimerVoiture.setBounds(316, 8, 98, 26);
		btnSupprimerVoiture.addActionListener(new GestionBoutons());
		panVoiture.add(btnSupprimerVoiture);
		
		btnMAJVoiture = new JButton("Mettre \u00E0 jour");
		btnMAJVoiture.setBounds(314, 300, 98, 26);
		btnMAJVoiture.addActionListener(new GestionBoutons());
		panVoiture.add(btnMAJVoiture);
		
	}
	
	class GestionMenus implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == boxSaison)
			{
				
			}
		}
	}
	
	class GestionBoutons implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnReinitialiserSaison)
			{
				txtNomSaison.setText("");
			}
			else if (e.getSource() == btnReinitialiserCircuit)
			{
				txtNomCircuit.setText("");
			}
			else if (e.getSource() == btnReinitialiserEcurie)
			{
				txtNomEcurie.setText("");
			}
			else if (e.getSource() == btnReinitialiserVoiture)
			{
				txtNomVoiture.setText("");
			}
		}
	}
}
