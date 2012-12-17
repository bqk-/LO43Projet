import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenAssistant1 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblEcurie;
	private JLabel lblVoitures;
	private JLabel lblVoitTherm;
	private JLabel lblVoitElec;
	private JLabel lblVoitHybr;
	private JComboBox<Ecurie> boxEcurie;
	private JComboBox<Voiture> boxVoitTherm;
	private JComboBox<Voiture> boxVoitElec;
	private JComboBox<Voiture_hybride> boxVoitHybr;
	private JButton btnNouvEcurie;
	private JButton btnEditerEcurie;
	private JButton btnNouvVoitTherm;
	private JButton btnEditerVoitTherm;
	private JButton btnNouvVoitElec;
	private JButton btnEditerVoitElec;
	private JButton btnNouvVoitHybr;
	private JButton btnEditerVoitHybr;
	private JButton btnValider;
	private JSeparator sepHaut;
	private JSeparator sepBas;	
	
	public FenAssistant1() {
		setVisible(true);
		setResizable(false);
		setSize(440,350);
		setLocationRelativeTo(null);
		setTitle("Assistant de cr\u00E9ation (1/2)");
		getContentPane().setLayout(null);
		
		lblEcurie = new JLabel("Choix de l'\u00E9curie :");
		lblEcurie.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEcurie.setBounds(10, 0, 143, 36);
		getContentPane().add(lblEcurie);
		
		boxEcurie = new JComboBox<Ecurie>();
		lblEcurie.setLabelFor(boxEcurie);
		boxEcurie.setBounds(20, 33, 188, 25);
		getContentPane().add(boxEcurie);
		
		btnNouvEcurie = new JButton("Nouvelle...");
		btnNouvEcurie.setBounds(218, 32, 98, 26);
		btnNouvEcurie.addActionListener(new GestionBoutons());
		getContentPane().add(btnNouvEcurie);
		
		btnEditerEcurie = new JButton("Editer");
		btnEditerEcurie.setBounds(326, 32, 98, 26);
		btnEditerEcurie.addActionListener(new GestionBoutons());
		getContentPane().add(btnEditerEcurie);
		
		sepHaut = new JSeparator();
		sepHaut.setBounds(0, 66, 434, 20);
		getContentPane().add(sepHaut);
		
		lblVoitures = new JLabel("Choix des voitures :");
		lblVoitures.setFont(new Font("Dialog", Font.BOLD, 14));
		lblVoitures.setBounds(10, 69, 143, 25);
		getContentPane().add(lblVoitures);
		
		boxVoitTherm = new JComboBox<Voiture>();
		boxVoitTherm.setBounds(20, 117, 188, 25);
		getContentPane().add(boxVoitTherm);
		
		btnNouvVoitTherm = new JButton("Nouvelle...");
		btnNouvVoitTherm.setBounds(218, 116, 98, 26);
		btnNouvVoitTherm.addActionListener(new GestionBoutons());
		getContentPane().add(btnNouvVoitTherm);
		
		btnEditerVoitTherm = new JButton("Editer");
		btnEditerVoitTherm.setBounds(326, 116, 98, 26);
		btnEditerVoitTherm.addActionListener(new GestionBoutons());
		getContentPane().add(btnEditerVoitTherm);
		
		lblVoitTherm = new JLabel("Voiture thermique :");
		lblVoitTherm.setBounds(20, 97, 108, 17);
		getContentPane().add(lblVoitTherm);
		
		lblVoitElec = new JLabel("Voiture \u00E9lectrique :");
		lblVoitElec.setBounds(20, 153, 108, 17);
		getContentPane().add(lblVoitElec);
		
		boxVoitElec = new JComboBox<Voiture>();
		boxVoitElec.setBounds(20, 173, 188, 25);
		getContentPane().add(boxVoitElec);
		
		btnNouvVoitElec = new JButton("Nouvelle...");
		btnNouvVoitElec.setBounds(218, 172, 98, 26);
		btnNouvVoitElec.addActionListener(new GestionBoutons());
		getContentPane().add(btnNouvVoitElec);
		
		btnEditerVoitElec = new JButton("Editer");
		btnEditerVoitElec.setBounds(326, 172, 98, 26);
		btnEditerVoitElec.addActionListener(new GestionBoutons());
		getContentPane().add(btnEditerVoitElec);
		
		lblVoitHybr = new JLabel("Voiture hybride :");
		lblVoitHybr.setBounds(20, 209, 108, 17);
		getContentPane().add(lblVoitHybr);
		
		boxVoitHybr = new JComboBox<Voiture_hybride>();
		boxVoitHybr.setBounds(20, 229, 188, 25);
		getContentPane().add(boxVoitHybr);
		
		btnNouvVoitHybr = new JButton("Nouvelle...");
		btnNouvVoitHybr.setBounds(218, 228, 98, 26);
		btnNouvVoitHybr.addActionListener(new GestionBoutons());
		getContentPane().add(btnNouvVoitHybr);
		
		btnEditerVoitHybr = new JButton("Editer");
		btnEditerVoitHybr.setBounds(326, 228, 98, 26);
		btnEditerVoitHybr.addActionListener(new GestionBoutons());
		getContentPane().add(btnEditerVoitHybr);
		
		btnValider = new JButton("Valider");
		btnValider.setBounds(325, 287, 98, 26);
		btnValider.addActionListener(new GestionBoutons());
		getContentPane().add(btnValider);
		
		sepBas = new JSeparator();
		sepBas.setBounds(0, 275, 434, 10);
		getContentPane().add(sepBas);
		
		
		setVisible(true);
	}
	
	class GestionBoutons implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnValider)
			{
				setVisible(false);
				dispose();
	            new FenAssistant2();
			}
			else if (e.getSource() == btnNouvEcurie)
			{
				new FenEcurie();
			}
			else if (e.getSource() == btnEditerEcurie)
			{
				new FenEcurie();
			}
			else if (e.getSource() == btnNouvVoitTherm)
			{
				new FenVoiture();
			}
			else if (e.getSource() == btnNouvVoitElec)
			{
				new FenVoiture();
			}
			else if (e.getSource() == btnNouvVoitHybr)
			{
				new FenVoiture();
			}
			else if (e.getSource() == btnEditerVoitTherm)
			{
				new FenVoiture();
			}
			else if (e.getSource() == btnEditerVoitElec)
			{
				new FenVoiture();
			}
			else if (e.getSource() == btnEditerVoitHybr)
			{
				new FenVoiture();
			}
		}
	}
}
