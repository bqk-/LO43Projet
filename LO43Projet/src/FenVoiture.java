import javax.swing.*;
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
	private JSpinner spinAutonomie;
	private JSpinner spinConso;
	private JSpinner spinVMax;
	private JSpinner spinTempsArret;
	private JRadioButton radioTherm;
	private JRadioButton radioElec;
	private JRadioButton radioHybr;
	private JButton btnValider;
	private JButton btnAnnuler;
	
	public FenVoiture() {
		setSize(460,320);
		setTitle("Cr\u00E9ation d'une voiture");
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
	/** TextBox **/
		txtNomVoiture = new JTextField();
		txtNomVoiture.setColumns(10);
		txtNomVoiture.setBounds(162, 9, 135, 20);
		getContentPane().add(txtNomVoiture);
	
	/** Label **/
		lblNomVoiture = new JLabel("Nom de la voiture :");
		lblNomVoiture.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomVoiture.setBounds(10, 14, 142, 14);
		getContentPane().add(lblNomVoiture);
		
		lblVMax = new JLabel("Vitesse maximale :");
		lblVMax.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVMax.setBounds(10, 39, 142, 16);
		getContentPane().add(lblVMax);
	
		lblTempsArret = new JLabel("Temps d'arr\u00EAt au stand :");
		lblTempsArret.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTempsArret.setBounds(10, 66, 142, 16);
		getContentPane().add(lblTempsArret);
		
		lblAutonomie = new JLabel("Autonomie :");
		lblAutonomie.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAutonomie.setBounds(10, 94, 142, 16);
		getContentPane().add(lblAutonomie);

		lblConso = new JLabel("Consommation :");
		lblConso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConso.setBounds(10, 122, 142, 16);
		getContentPane().add(lblConso);
		
		lblType = new JLabel("Type :");
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblType.setBounds(10, 150, 142, 16);
		getContentPane().add(lblType);
		
		lblStatus = new JLabel("! Entrez un nom");
		lblStatus.setBounds(306, 11, 128, 16);
		getContentPane().add(lblStatus);
		
	/** Spinner **/
		spinVMax = new JSpinner();
		spinVMax.setBounds(162, 35, 57, 20);
		getContentPane().add(spinVMax);
		
		spinTempsArret = new JSpinner();
		spinTempsArret.setBounds(162, 62, 57, 20);
		getContentPane().add(spinTempsArret);
		
		spinAutonomie = new JSpinner();
		spinAutonomie.setBounds(162, 90, 57, 20);
		getContentPane().add(spinAutonomie);
		
		spinConso = new JSpinner();
		spinConso.setBounds(162, 118, 57, 20);
		getContentPane().add(spinConso);
	
	/** RadioButton **/
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
		
		ButtonGroup groupType = new ButtonGroup();
		groupType.add(radioTherm);
		groupType.add(radioElec);
		groupType.add(radioHybr);
		
	/** Button **/
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(228, 255, 98, 26);
		btnAnnuler.addActionListener(new GestionBoutons());
		getContentPane().add(btnAnnuler);
		
		btnValider = new JButton("Valider");
		btnValider.setBounds(336, 255, 98, 26);
		btnValider.addActionListener(new GestionBoutons());
		getContentPane().add(btnValider);
		
		setVisible(true);
	}
	public FenVoiture(String voiture, String ext) {
		Voiture v=new Voiture(voiture,ext);
		setSize(460,320);
		setTitle("Edition d'une voiture");
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
	/** TextBox **/
		txtNomVoiture = new JTextField();
		txtNomVoiture.setColumns(10);
		txtNomVoiture.setBounds(162, 9, 135, 20);
		txtNomVoiture.setText(v.getNom());
		txtNomVoiture.setEditable(false);
		getContentPane().add(txtNomVoiture);
	
	/** Label **/
		lblNomVoiture = new JLabel("Nom de la voiture :");
		lblNomVoiture.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomVoiture.setBounds(10, 14, 142, 14);
		getContentPane().add(lblNomVoiture);
		
		lblVMax = new JLabel("Vitesse maximale :");
		lblVMax.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVMax.setBounds(10, 39, 142, 16);
		getContentPane().add(lblVMax);
	
		lblTempsArret = new JLabel("Temps d'arr\u00EAt au stand :");
		lblTempsArret.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTempsArret.setBounds(10, 66, 142, 16);
		getContentPane().add(lblTempsArret);
		
		lblAutonomie = new JLabel("Autonomie :");
		lblAutonomie.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAutonomie.setBounds(10, 94, 142, 16);
		getContentPane().add(lblAutonomie);

		lblConso = new JLabel("Consommation :");
		lblConso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConso.setBounds(10, 122, 142, 16);
		getContentPane().add(lblConso);
		
		lblType = new JLabel("Type :");
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblType.setBounds(10, 150, 142, 16);
		getContentPane().add(lblType);
		
		
	/** Spinner **/
		spinVMax = new JSpinner();
		spinVMax.setBounds(162, 35, 57, 20);
		spinVMax.setModel(new SpinnerNumberModel(v.getVMax(), null, null, new Float(1)));
		getContentPane().add(spinVMax);
		
		spinTempsArret = new JSpinner();
		spinTempsArret.setBounds(162, 62, 57, 20);
		spinTempsArret.setModel(new SpinnerNumberModel(v.getTempsSec(), null, null, new Float(1)));
		getContentPane().add(spinTempsArret);
		
		spinAutonomie = new JSpinner();
		spinAutonomie.setBounds(162, 90, 57, 20);
		spinAutonomie.setModel(new SpinnerNumberModel(v.getAutonomie(), null, null, new Float(1)));
		getContentPane().add(spinAutonomie);
		
		spinConso = new JSpinner();
		spinConso.setBounds(162, 118, 57, 20);
		spinConso.setModel(new SpinnerNumberModel(v.getConso(), null, null, new Float(1)));
		getContentPane().add(spinConso);
	
	/** RadioButton **/
		radioTherm = new JRadioButton("Thermique");
		radioTherm.setMnemonic('1');
		radioTherm.setBounds(162, 145, 118, 24);
		if(ext.equals("vth"))
			radioTherm.setSelected(true);
		radioTherm.setEnabled(false);
		getContentPane().add(radioTherm);
		
		
		radioElec = new JRadioButton("Electrique");
		radioElec.setMnemonic('2');
		radioElec.setBounds(162, 173, 118, 24);
		if(ext.equals("vel"))
			radioElec.setSelected(true);
		radioElec.setEnabled(false);
		getContentPane().add(radioElec);
		
		radioHybr = new JRadioButton("Hybride");
		radioHybr.setMnemonic('3');
		radioHybr.setBounds(162, 201, 118, 24);
		if(ext.equals("vhy"))
			radioHybr.setSelected(true);
		radioHybr.setEnabled(false);
		getContentPane().add(radioHybr);
		
		ButtonGroup groupType = new ButtonGroup();
		groupType.add(radioTherm);
		groupType.add(radioElec);
		groupType.add(radioHybr);
		
	/** Button **/
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(228, 255, 98, 26);
		btnAnnuler.addActionListener(new GestionBoutons());
		getContentPane().add(btnAnnuler);
		
		btnValider = new JButton("Valider");
		btnValider.setBounds(336, 255, 98, 26);
		btnValider.addActionListener(new GestionBoutons());
		getContentPane().add(btnValider);
		
		setVisible(true);
	}
	
	class GestionBoutons implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnValider)
			{
				setVisible(false);
				String ext=new String();
				if(radioTherm.isSelected())
					ext="vth";
				if(radioElec.isSelected())
					ext="vel";
				if(radioHybr.isSelected())
					ext="vhy";
				if(txtNomVoiture.isEditable())
				{
					Voiture v=new Voiture(txtNomVoiture.getText(),
								0,
								Float.parseFloat(spinAutonomie.getValue().toString()),
								Float.parseFloat(spinVMax.getValue().toString()),
								Float.parseFloat(spinConso.getValue().toString()),
								0,
								new Temps(Float.parseFloat(spinTempsArret.getValue().toString())),
								Float.parseFloat(spinTempsArret.getValue().toString()),
								0,
								0);
					v.enregistrerVoitureF(ext);
				}
				else
				{
					Voiture v=new Voiture(txtNomVoiture.getText(),ext); //On charge la voiture
					//On la modifie
					v.setVMax(Float.parseFloat(spinVMax.getValue().toString()));
					v.setAutonomie(Float.parseFloat(spinAutonomie.getValue().toString()));
					v.setTempsSec(Float.parseFloat(spinTempsArret.getValue().toString()));
					v.setConso(Float.parseFloat(spinConso.getValue().toString()));
					v.enregistrerVoitureF(ext); //On sauvegarde
				}
			}
			else if (e.getSource() == btnAnnuler)
			{
				setVisible(false);
			}
		}
	}
}
