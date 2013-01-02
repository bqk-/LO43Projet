import javax.swing.*;
import java.awt.Font;

public class FenSimulation extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JTextField nomEcurie;
	private JTextField nomSaison;
	private JTextField nomCircuit;
	private JTextField v1;
	private JTextField v2;
	private JTextField v3;
	public FenSimulation() {
		setResizable(false);
		setSize(440,350);
		setLocationRelativeTo(null);
		setTitle("Simulation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(303, 0, 12, 322);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(303, 57, 131, 2);
		getContentPane().add(separator_1);
		
		JLabel lblEcurie = new JLabel("Ecurie");
		lblEcurie.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEcurie.setBounds(314, 4, 89, 19);
		getContentPane().add(lblEcurie);
		
		nomEcurie = new JTextField();
		nomEcurie.setEditable(false);
		nomEcurie.setBounds(324, 23, 89, 23);
		getContentPane().add(nomEcurie);
		nomEcurie.setColumns(10);
		
		JLabel Saison = new JLabel("Saison");
		Saison.setFont(new Font("Tahoma", Font.BOLD, 15));
		Saison.setBounds(314, 70, 89, 19);
		getContentPane().add(Saison);
		
		nomSaison = new JTextField();
		nomSaison.setEditable(false);
		nomSaison.setColumns(10);
		nomSaison.setBounds(325, 93, 89, 23);
		getContentPane().add(nomSaison);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(303, 127, 131, 2);
		getContentPane().add(separator_2);
		
		JLabel Circuit = new JLabel("Circuit");
		Circuit.setFont(new Font("Tahoma", Font.BOLD, 15));
		Circuit.setBounds(314, 137, 89, 19);
		getContentPane().add(Circuit);
		
		nomCircuit = new JTextField();
		nomCircuit.setEditable(false);
		nomCircuit.setColumns(10);
		nomCircuit.setBounds(325, 160, 89, 23);
		getContentPane().add(nomCircuit);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(303, 194, 131, 2);
		getContentPane().add(separator_3);
		
		JLabel lblVoitures = new JLabel("Voitures");
		lblVoitures.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVoitures.setBounds(313, 207, 89, 19);
		getContentPane().add(lblVoitures);
		
		v1 = new JTextField();
		v1.setEditable(false);
		v1.setColumns(10);
		v1.setBounds(324, 230, 89, 23);
		getContentPane().add(v1);
		
		v2 = new JTextField();
		v2.setEditable(false);
		v2.setColumns(10);
		v2.setBounds(324, 261, 89, 23);
		getContentPane().add(v2);
		
		v3 = new JTextField();
		v3.setEditable(false);
		v3.setColumns(10);
		v3.setBounds(324, 290, 89, 23);
		getContentPane().add(v3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(0, 137, 299, 2);
		getContentPane().add(separator_4);
		
		JLabel lblVoiture = new JLabel("Voiture 1");
		lblVoiture.setBounds(10, 177, 115, 28);
		getContentPane().add(lblVoiture);
		
		JLabel label_3 = new JLabel("Voiture 1");
		label_3.setBounds(10, 207, 115, 28);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Voiture 1");
		label_4.setBounds(10, 236, 115, 28);
		getContentPane().add(label_4);
		
		JLabel lblTemps = new JLabel("Temps");
		lblTemps.setBounds(105, 150, 109, 23);
		getContentPane().add(lblTemps);
		
		JLabel lblTempsTotal = new JLabel("Temps total :");
		lblTempsTotal.setBounds(20, 261, 109, 23);
		getContentPane().add(lblTempsTotal);
		
		JButton btnCircuitSuivant = new JButton("Circuit suivant");
		btnCircuitSuivant.setBounds(149, 287, 144, 28);
		getContentPane().add(btnCircuitSuivant);
		
		JLabel lblTour = new JLabel("Tour");
		lblTour.setBounds(227, 150, 66, 19);
		getContentPane().add(lblTour);
		
		setVisible(true);
	}


}
