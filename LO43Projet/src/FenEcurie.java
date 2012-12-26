import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenEcurie extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNomEcurie;
	private JButton btnValider;
	private JButton btnAnnuler;
	private JLabel lblStatus;
	
	public FenEcurie() {
		setResizable(false);
		setSize(410,135);
		setTitle("Cr\u00E9ation d'une \u00E9curie");
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNomEcurie = new JLabel("Nom de l'\u00E9curie :");
		lblNomEcurie.setBounds(12, 12, 103, 16);
		getContentPane().add(lblNomEcurie);
		
		txtNomEcurie = new JTextField();
		lblNomEcurie.setLabelFor(txtNomEcurie);
		txtNomEcurie.setBounds(113, 10, 140, 20);
		getContentPane().add(txtNomEcurie);
		txtNomEcurie.setColumns(10);
		
		lblStatus = new JLabel("! Entrez un nom");
		lblStatus.setFont(new Font("Dialog", Font.ITALIC, 12));
		lblStatus.setBounds(271, 12, 122, 16);
		getContentPane().add(lblStatus);
		
		btnValider = new JButton("Valider");
		btnValider.setBounds(280, 60, 98, 26);
		btnValider.addActionListener(new GestionBoutons());
		getContentPane().add(btnValider);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(170, 60, 98, 26);
		btnAnnuler.addActionListener(new GestionBoutons());
		getContentPane().add(btnAnnuler);
		
		setVisible(true);
	}
	public FenEcurie(String nomEcu) {
		setResizable(false);
		setSize(410,135);
		setTitle("Edition d'une \u00E9curie");
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNomEcurie = new JLabel("Renommer l\'écurie "+nomEcu+" :");
		lblNomEcurie.setBounds(12, 12, 103, 16);
		getContentPane().add(lblNomEcurie);
		
		txtNomEcurie = new JTextField(nomEcu);
		lblNomEcurie.setLabelFor(txtNomEcurie);
		txtNomEcurie.setBounds(113, 10, 140, 20);
		getContentPane().add(txtNomEcurie);
		txtNomEcurie.setColumns(10);
		
		lblStatus = new JLabel(nomEcu);
		lblStatus.setVisible(false);
		lblStatus.setFont(new Font("Dialog", Font.ITALIC, 12));
		lblStatus.setBounds(271, 12, 122, 16);
		getContentPane().add(lblStatus);
		
		btnValider = new JButton("Valider");
		btnValider.setBounds(280, 60, 98, 26);
		btnValider.addActionListener(new GestionBoutons());
		getContentPane().add(btnValider);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(170, 60, 98, 26);
		btnAnnuler.addActionListener(new GestionBoutons());
		getContentPane().add(btnAnnuler);
		
		setVisible(true);
	}
	
	class GestionBoutons implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnValider)
			{
				setVisible(false);
				if(lblStatus.getText().equals("! Entrez un nom")) //Nouvelle ecurie crée
				{
					Ecurie temp=new Ecurie();
					temp.setNom(txtNomEcurie.getText());
					temp.enregistrerEcurieF();
				}
				else //Ancienne qu'on a modifiée, on sauvegarde dans le fichier
				{
					Ecurie temp=new Ecurie(lblStatus.getText());
					temp.deleteFile(); //Suppression du vieux fichier
					temp.setNom(txtNomEcurie.getText()); //Filtre inclut dans le setter
					temp.enregistrerEcurieF();	//Création du nouveau
				}
			}
			else if (e.getSource() == btnAnnuler)
			{
				setVisible(false);
			}
		}
	}
}
