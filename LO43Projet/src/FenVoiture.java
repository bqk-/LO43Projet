import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class FenVoiture extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNomVoiture;
	private JLabel lblNomVoiture;
	private JLabel lblAutonomie;
	private JLabel lblConso;
	private JLabel lblVMax;
	private JLabel lblTempsArret;
	private JLabel lblType;
	private JLabel lblStatus;
	private JButton btnValider;
	private JButton btnAnnuler;
	private JSpinner spinAutonomie;
	private JSpinner spinConso;
	private JSpinner spinVMax;
	private JSpinner spinTempsArret;
	private JRadioButton radioTherm;
	private JRadioButton radioElec;
	private JRadioButton radioHybr;
	
	public FenVoiture() {
		setSize(460,320);
		setTitle("Cr\u00E9ation/Edition d'une voiture");
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		lblNomVoiture = new JLabel("Nom de la voiture :");
		lblNomVoiture.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomVoiture.setBounds(10, 14, 142, 14);
		getContentPane().add(lblNomVoiture);
		
		txtNomVoiture = new JTextField();
		txtNomVoiture.setColumns(10);
		txtNomVoiture.setBounds(162, 9, 135, 20);
		getContentPane().add(txtNomVoiture);
		
		lblVMax = new JLabel("Vitesse maximale :");
		lblVMax.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVMax.setBounds(10, 39, 142, 16);
		getContentPane().add(lblVMax);
		
		spinVMax = new JSpinner();
		spinVMax.setBounds(162, 35, 57, 20);
		getContentPane().add(spinVMax);
		
		lblTempsArret = new JLabel("Temps d'arr\u00EAt au stand :");
		lblTempsArret.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTempsArret.setBounds(10, 66, 142, 16);
		getContentPane().add(lblTempsArret);
		
		spinTempsArret = new JSpinner();
		spinTempsArret.setBounds(162, 62, 57, 20);
		getContentPane().add(spinTempsArret);
		
		lblAutonomie = new JLabel("Autonomie :");
		lblAutonomie.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAutonomie.setBounds(10, 94, 142, 16);
		getContentPane().add(lblAutonomie);
		
		spinAutonomie = new JSpinner();
		spinAutonomie.setBounds(162, 90, 57, 20);
		getContentPane().add(spinAutonomie);
		
		lblConso = new JLabel("Consommation :");
		lblConso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConso.setBounds(10, 122, 142, 16);
		getContentPane().add(lblConso);
		
		spinConso = new JSpinner();
		spinConso.setBounds(162, 118, 57, 20);
		getContentPane().add(spinConso);
		
		lblType = new JLabel("Type :");
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblType.setBounds(10, 150, 142, 16);
		getContentPane().add(lblType);
		
		radioTherm = new JRadioButton("Thermique");
		radioTherm.setMnemonic('1');
		radioTherm.setBounds(162, 145, 118, 24);
		getContentPane().add(radioTherm);
		
		radioElec = new JRadioButton("Electrique");
		radioElec.setMnemonic('2');
		radioElec.setBounds(162, 173, 118, 24);
		getContentPane().add(radioElec);
		
		radioHybr = new JRadioButton("Hybride");
		radioHybr.setMnemonic('3');
		radioHybr.setBounds(162, 201, 118, 24);
		getContentPane().add(radioHybr);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(228, 255, 98, 26);
		btnAnnuler.addActionListener(new GestionBoutons());
		getContentPane().add(btnAnnuler);
		
		btnValider = new JButton("Valider");
		btnValider.setBounds(336, 255, 98, 26);
		btnValider.addActionListener(new GestionBoutons());
		getContentPane().add(btnValider);
		
		lblStatus = new JLabel("! Entrez un nom");
		lblStatus.setFont(new Font("Dialog", Font.ITALIC, 12));
		lblStatus.setBounds(306, 11, 128, 16);
		getContentPane().add(lblStatus);
		
		setVisible(true);
	}
	
	class GestionBoutons implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnValider)
			{
				setVisible(false);
			}
			else if (e.getSource() == btnAnnuler)
			{
				setVisible(false);
			}
		}
	}
}
