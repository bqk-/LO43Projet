import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.SwingConstants;

public class FenAssistant2 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblSaison;
	private JLabel lblCircuits;
	private JLabel lblCircuitsDispo;
	private JLabel lblCircuitsSelec;
	private JButton btnValider;
	private JButton btnAjouter;
	private JButton btnSupprimer;
	private JButton btnNouvSaison;
	private JButton btnEditerSaison;
	private JButton btnNouvCircuit;
	private JButton btnEditerCircuit;
	private JComboBox<Saison> boxSaison;
	private JList<Circuit> lstCircuitsDispo;
	private JList<Circuit> lstCircuitsSelec;
	private JSeparator sepHaut;
	private JSeparator sepBas;
	private JSeparator sepMilieu;
	
	public FenAssistant2() {
		setVisible(true);
		setResizable(false);
		setSize(440,385);
		setLocationRelativeTo(null);
		setTitle("Assistant de cr\u00E9ation (2/2)");
		getContentPane().setLayout(null);
	
	/** Label **/
		lblSaison = new JLabel("Choix de la saison :");
		lblSaison.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSaison.setBounds(8, 0, 143, 36);
		getContentPane().add(lblSaison);
		
		lblCircuits = new JLabel("Choix des circuits :");
		lblCircuits.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCircuits.setBounds(8, 69, 143, 25);
		getContentPane().add(lblCircuits);
		
		lblCircuitsDispo = new JLabel("Circuits disponibles :");
		lblCircuitsDispo.setBounds(18, 118, 133, 17);
		getContentPane().add(lblCircuitsDispo);
		
		lstCircuitsDispo = new JList<Circuit>();
		lstCircuitsDispo.setBounds(18, 137, 188, 133);
		getContentPane().add(lstCircuitsDispo);
		
	    lstCircuitsSelec = new JList<Circuit>();
		lstCircuitsSelec.setBounds(234, 138, 188, 133);
		getContentPane().add(lstCircuitsSelec);
		
		lblCircuitsSelec = new JLabel("Circuits s\u00E9lectionn\u00E9s :");
		lblCircuitsSelec.setBounds(234, 119, 133, 17);
		getContentPane().add(lblCircuitsSelec);
		
	/** ComboBox **/
		boxSaison = new JComboBox<Saison>();
		boxSaison.setBounds(18, 33, 188, 25);
		getContentPane().add(boxSaison);
	
	/** Separator **/
		sepBas = new JSeparator();
		sepBas.setBounds(-2, 311, 436, 10);
		getContentPane().add(sepBas);
		
		sepMilieu = new JSeparator();
		sepMilieu.setOrientation(SwingConstants.VERTICAL);
		sepMilieu.setBounds(215, 119, 8, 192);
		getContentPane().add(sepMilieu);
		
		sepHaut = new JSeparator();
		sepHaut.setBounds(-2, 66, 434, 20);
		getContentPane().add(sepHaut);
	
	/** Button **/
		btnAjouter = new JButton("=>");
		btnAjouter.setBounds(108, 279, 98, 26);
		btnAjouter.addActionListener(new GestionBoutons());
		getContentPane().add(btnAjouter);
		
		btnSupprimer = new JButton("<=");
		btnSupprimer.setBounds(232, 279, 98, 26);
		btnSupprimer.addActionListener(new GestionBoutons());
		getContentPane().add(btnSupprimer);
		
		btnNouvCircuit = new JButton("Nouveau...");
		btnNouvCircuit.setBounds(202, 80, 98, 26);
		btnNouvCircuit.addActionListener(new GestionBoutons());
		getContentPane().add(btnNouvCircuit);
		
		btnEditerCircuit = new JButton("Editer");
		btnEditerCircuit.setBounds(324, 80, 98, 26);
		btnEditerCircuit.addActionListener(new GestionBoutons());
		getContentPane().add(btnEditerCircuit);
		
		btnValider = new JButton("Valider");
		btnValider.setBounds(324, 321, 98, 26);
		btnValider.addActionListener(new GestionBoutons());
		getContentPane().add(btnValider);
		
		btnNouvSaison = new JButton("Nouvelle...");
		btnNouvSaison.setBounds(216, 32, 98, 26);
		btnNouvSaison.addActionListener(new GestionBoutons());
		getContentPane().add(btnNouvSaison);
		
		btnEditerSaison = new JButton("Editer");
		btnEditerSaison.setBounds(324, 32, 98, 26);
		btnEditerSaison.addActionListener(new GestionBoutons());
		getContentPane().add(btnEditerSaison);
		
		
		setVisible(true);
	}
	
	class GestionBoutons implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnValider)
			{
				setVisible(false);
				dispose();
			}
			else if (e.getSource() == btnNouvSaison)
			{
				new FenSaison();
			}
			else if (e.getSource() == btnEditerSaison)
			{
				new FenSaison();
			}
			else if (e.getSource() == btnNouvCircuit)
			{

			}
			else if (e.getSource() == btnEditerCircuit)
			{

			}
			else if (e.getSource() == btnAjouter)
			{

			}
			else if (e.getSource() == btnSupprimer)
			{

			}
		}
	}
}
