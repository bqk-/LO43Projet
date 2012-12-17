import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class FenSaison extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNomSaison;
	private JButton btnValider;
	private JButton btnAnnuler;
	private JButton btnSupprimer;
	private JLabel lblNomSaison;
	private JLabel lblStatus;
	
	public FenSaison() {
		setVisible(true);
		setSize(400,130);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Cr\u00E9ation/Edition d'une saison");
		getContentPane().setLayout(null);
		
		lblNomSaison = new JLabel("Nom de la saison :");
		lblNomSaison.setBounds(10, 13, 103, 16);
		getContentPane().add(lblNomSaison);
		
		txtNomSaison = new JTextField();
		txtNomSaison.setColumns(10);
		txtNomSaison.setBounds(119, 11, 140, 20);
		getContentPane().add(txtNomSaison);
		
		lblStatus = new JLabel("! Entrez un nom");
		lblStatus.setFont(new Font("Dialog", Font.ITALIC, 12));
		lblStatus.setBounds(269, 13, 115, 16);
		getContentPane().add(lblStatus);
		
		btnValider = new JButton("Valider");
		btnValider.setBounds(278, 62, 98, 26);
		btnValider.addActionListener(new GestionBoutons());
		getContentPane().add(btnValider);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(170, 62, 98, 26);
		btnAnnuler.addActionListener(new GestionBoutons());
		getContentPane().add(btnAnnuler);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(10, 62, 98, 26);
		btnSupprimer.addActionListener(new GestionBoutons());
		getContentPane().add(btnSupprimer);
		
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
			else if (e.getSource() == btnAnnuler)
			{
				setVisible(false);
			}
			else if (e.getSource() == btnSupprimer)
			{
				setVisible(false);
			}
		}
	}
}
