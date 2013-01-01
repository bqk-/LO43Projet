import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FenPrincipale extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnModeSimulation;
	private JButton btnModeEdition;
	private JButton btnQuitter;

	public FenPrincipale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setType(Type.UTILITY);
		setTitle("RaceSimulator");
		setSize(150,150);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		btnModeSimulation = new JButton("Mode simulation");
		btnModeSimulation.addActionListener(new GestionBoutons());
		btnModeSimulation.setBounds(10, 11, 129, 23);
		getContentPane().add(btnModeSimulation);
		
		btnModeEdition = new JButton("Mode \u00E9dition");
		btnModeEdition.addActionListener(new GestionBoutons());
		btnModeEdition.setBounds(10, 45, 129, 23);
		getContentPane().add(btnModeEdition);
		
		btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new GestionBoutons());
		btnQuitter.setBounds(50, 88, 89, 23);
		getContentPane().add(btnQuitter);
		
		setVisible(true);
	}
	
	class GestionBoutons implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnQuitter)
			{
	            System.exit(0); 
			}
			else if (e.getSource() == btnModeSimulation)
			{
				setVisible(false);
				dispose();
				new FenAssistant1();
			}
			else if (e.getSource() == btnModeEdition)
			{
				setVisible(false);
				dispose();
				new FenEdition();
			}
		}
	}
}
