import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Window.Type;

public class fenCreerVoiture extends JFrame {
	public fenCreerVoiture(int type) {
		setType(Type.POPUP);
	    setSize(320, 320);
		setResizable(false);
		setAlwaysOnTop(true);
	    setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Cr\u00E9er une nouvelle voiture...");
		getContentPane().setLayout(null);
		
		JLabel lblNomDeLa = new JLabel("Nom de la voiture :");
		lblNomDeLa.setBounds(10, 11, 112, 14);
		getContentPane().add(lblNomDeLa);
		
		textField = new JTextField();
		textField.setBounds(140, 8, 135, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblVitesseMaximale = new JLabel("Vitesse maximale :");
		lblVitesseMaximale.setBounds(10, 36, 112, 16);
		getContentPane().add(lblVitesseMaximale);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 500, 30));
		spinner.setBounds(140, 34, 57, 20);
		getContentPane().add(spinner);
		
		JLabel lblTempsDarrtAu = new JLabel("Temps d'arr\u00EAt au stand :");
		lblTempsDarrtAu.setBounds(10, 63, 127, 16);
		getContentPane().add(lblTempsDarrtAu);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(0)));
		spinner_1.setBounds(140, 61, 57, 20);
		getContentPane().add(spinner_1);
		
		JLabel lblAutonomie = new JLabel("Autonomie :");
		lblAutonomie.setBounds(10, 91, 127, 16);
		getContentPane().add(lblAutonomie);
		
		JLabel lblConsommation = new JLabel("Consommation :");
		lblConsommation.setBounds(10, 119, 127, 16);
		getContentPane().add(lblConsommation);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_2.setBounds(140, 89, 57, 20);
		getContentPane().add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(1, 1, 100, 10));
		spinner_3.setBounds(140, 117, 57, 20);
		getContentPane().add(spinner_3);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(10, 244, 98, 26);
		getContentPane().add(btnAnnuler);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setBounds(10, 147, 55, 16);
		getContentPane().add(lblType);
		
		JRadioButton rdbtnThermique = new JRadioButton("Thermique");
		rdbtnThermique.setMnemonic('1');
		rdbtnThermique.setBounds(140, 143, 118, 24);
		JRadioButton rdbtnElectrique = new JRadioButton("Electrique");
		rdbtnElectrique.setMnemonic('2');
		rdbtnElectrique.setBounds(140, 171, 118, 24);		
		JRadioButton rdbtnHybride = new JRadioButton("Hybride");
		rdbtnHybride.setMnemonic('3');
		rdbtnHybride.setBounds(140, 199, 118, 24);
		 rdbtnThermique.setEnabled(false);
		 rdbtnElectrique.setEnabled(false);
		 rdbtnHybride.setEnabled(false);
		 
		 switch(type)
		 {
		 case 0:
			 rdbtnThermique.setEnabled(true);
			 rdbtnElectrique.setEnabled(true);
			 rdbtnHybride.setEnabled(true);
			 break;
		 case 1:
			 rdbtnThermique.setSelected(true);
			 break;
		 case 2:
			 rdbtnElectrique.setSelected(true);
			 break;
		 case 3:
			 rdbtnHybride.setSelected(true);
			 break;
		 }
		
		getContentPane().add(rdbtnThermique);
		getContentPane().add(rdbtnElectrique);
		getContentPane().add(rdbtnHybride);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(194, 244, 98, 26);
		getContentPane().add(btnValider);
		
		setVisible(true);
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
}
