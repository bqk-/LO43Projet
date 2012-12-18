import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;

public class FenEdition extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JTabbedPane panOnglets;
	private JPanel panSaison;
	private JPanel panCircuit;
	private JPanel panEcurie;
	private JPanel panVoiture;
	private JTextField txtNomSaison;
	private JLabel lblNomSaison;
	private JLabel lblStatusNomSaison;
	private JLabel lblSaison;
	private JLabel lblCircuitsDispo;
	private JLabel lblCircuitsSelec;
	private JComboBox<Saison> boxSaison;
	private JList<Circuit> lstCircuitsDispo;
	private JList<Circuit> lstCircuitsSelec;
	private JSeparator sepHaut;
	private JSeparator sepMilieu;
	private JSeparator sepBas;
	private JButton btnSupprimerSaison;
	private JButton btnAjouterCircuit;
	private JButton btnEnleverCircuit;
	private JButton btnMAJSaison;
	private JTextField txtNomCircuit;
	private JButton btnMAJCircuit;
	
	public FenEdition() {
		setTitle("Mode Edition");
		setSize(435, 395);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		/** Panel **/
		panOnglets = new JTabbedPane(JTabbedPane.TOP);
		panOnglets.setBounds(0, 0, 429, 367);
		getContentPane().add(panOnglets);
		
		panSaison = new JPanel();
		panOnglets.addTab("Saison", null, panSaison, null);
		panSaison.setLayout(null);
		
		panCircuit = new JPanel();
		panCircuit.setFont(new Font("Dialog", Font.BOLD, 12));
		panOnglets.addTab("Circuit", null, panCircuit, null);
		panCircuit.setLayout(null);
		
		JLabel lblCircuit = new JLabel("Circuit :");
		lblCircuit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCircuit.setBounds(16, 13, 123, 14);
		panCircuit.add(lblCircuit);
		
		JComboBox<Saison> boxCircuit = new JComboBox<Saison>();
		boxCircuit.setBounds(147, 10, 162, 20);
		panCircuit.add(boxCircuit);
		
		JButton btnSupprimerCircuit = new JButton("Supprimer");
		btnSupprimerCircuit.setBounds(321, 7, 98, 26);
		panCircuit.add(btnSupprimerCircuit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 39, 429, 5);
		panCircuit.add(separator);
		
		JLabel lblNomDuCircuit = new JLabel("Nom du circuit :");
		lblNomDuCircuit.setFont(UIManager.getFont("Label.font"));
		lblNomDuCircuit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomDuCircuit.setBounds(43, 56, 115, 16);
		panCircuit.add(lblNomDuCircuit);
		
		txtNomCircuit = new JTextField();
		txtNomCircuit.setColumns(10);
		txtNomCircuit.setBounds(164, 54, 140, 20);
		panCircuit.add(txtNomCircuit);
		
		JLabel lblStatusNomCirc = new JLabel("");
		lblStatusNomCirc.setFont(new Font("Dialog", Font.ITALIC, 12));
		lblStatusNomCirc.setBounds(304, 56, 115, 16);
		panCircuit.add(lblStatusNomCirc);
		
		JLabel lblLongueurCircuit = new JLabel("Longueur (m) :");
		lblLongueurCircuit.setFont(UIManager.getFont("Label.font"));
		lblLongueurCircuit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLongueurCircuit.setBounds(53, 84, 105, 16);
		panCircuit.add(lblLongueurCircuit);
		
		JLabel lblPositionStands = new JLabel("Position des stands (m) :");
		lblPositionStands.setFont(UIManager.getFont("Label.font"));
		lblPositionStands.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPositionStands.setBounds(-2, 112, 160, 16);
		panCircuit.add(lblPositionStands);
		
		JSpinner spinLongueurCircuit = new JSpinner();
		spinLongueurCircuit.setBounds(164, 82, 72, 20);
		panCircuit.add(spinLongueurCircuit);
		
		JSpinner spinPositionStands = new JSpinner();
		spinPositionStands.setBounds(164, 110, 72, 20);
		panCircuit.add(spinPositionStands);
		
		JLabel lblVitesseMax = new JLabel("Vitesse maximale (km/h) :");
		lblVitesseMax.setFont(UIManager.getFont("Label.font"));
		lblVitesseMax.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVitesseMax.setBounds(0, 140, 158, 16);
		panCircuit.add(lblVitesseMax);
		
		JSpinner spinVitesseMax = new JSpinner();
		spinVitesseMax.setBounds(163, 138, 72, 20);
		panCircuit.add(spinVitesseMax);
		
		JLabel lblNbreTours = new JLabel("Nombre de tours :");
		lblNbreTours.setFont(UIManager.getFont("Label.font"));
		lblNbreTours.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNbreTours.setBounds(53, 170, 105, 16);
		panCircuit.add(lblNbreTours);
		
		JSpinner spinNbreTours = new JSpinner();
		spinNbreTours.setFont(new Font("Dialog", Font.PLAIN, 12));
		spinNbreTours.setModel(new SpinnerNumberModel(new Integer(3), new Integer(1), null, new Integer(1)));
		spinNbreTours.setBounds(164, 168, 72, 20);
		panCircuit.add(spinNbreTours);
		
		btnMAJCircuit = new JButton("Mettre \u00E0 jour");
		btnMAJCircuit.setBounds(314, 301, 98, 26);
		panCircuit.add(btnMAJCircuit);
		
		JButton btnReinitialiserCircuit = new JButton("R\u00E9initialiser");
		btnReinitialiserCircuit.setBounds(10, 301, 98, 26);
		panCircuit.add(btnReinitialiserCircuit);
		
		panEcurie = new JPanel();
		panOnglets.addTab("Ecurie", null, panEcurie, null);
		panEcurie.setLayout(null);
		
		panVoiture = new JPanel();
		panOnglets.addTab("Voiture", null, panVoiture, null);
		
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
		sepHaut = new JSeparator();
		sepHaut.setBounds(0, 41, 429, 5);
		panSaison.add(sepHaut);
		
		sepMilieu = new JSeparator();
		sepMilieu.setOrientation(SwingConstants.VERTICAL);
		sepMilieu.setBounds(208, 88, 8, 192);
		panSaison.add(sepMilieu);
		
		sepBas = new JSeparator();
		sepBas.setBounds(0, 279, 424, 16);
		panSaison.add(sepBas);
		
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
		panSaison.add(btnSupprimerSaison);
		
		btnAjouterCircuit = new JButton("=>");
		btnAjouterCircuit.setBounds(105, 248, 98, 26);
		panSaison.add(btnAjouterCircuit);
		
		btnEnleverCircuit = new JButton("<=");
		btnEnleverCircuit.setBounds(225, 248, 98, 26);
		panSaison.add(btnEnleverCircuit);
		
		btnMAJSaison = new JButton("Mettre \u00E0 jour");
		btnMAJSaison.setBounds(321, 301, 98, 26);
		panSaison.add(btnMAJSaison);		
		
		JButton btnReinitialiserSaison = new JButton("R\u00E9initialiser");
		btnReinitialiserSaison.setBounds(10, 303, 98, 26);
		panSaison.add(btnReinitialiserSaison);
	}
	
	class GestionMenus implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == boxSaison)
			{
				
			}
		}
	}
}
