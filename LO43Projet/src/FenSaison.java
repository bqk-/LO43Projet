import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JButton;

public class FenSaison extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNomSaison;
	private JLabel lblNomSaison;
	private JLabel lblStatus;
	private JButton btnValider;
	private JButton btnAnnuler;
	private JButton btnSupprimer;

	
	public FenSaison() {
		setVisible(true);
		setSize(400,130);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Cr\u00E9ation d'une saison");
		getContentPane().setLayout(null);
	
	/** TextBox **/
		txtNomSaison = new JTextField();
		txtNomSaison.setColumns(10);
		txtNomSaison.setBounds(119, 11, 140, 20);
		getContentPane().add(txtNomSaison);
		
	/** Label **/
		lblNomSaison = new JLabel("Nom de la saison :");
		lblNomSaison.setBounds(10, 13, 103, 16);
		getContentPane().add(lblNomSaison);
		
		lblStatus = new JLabel("! Entrez un nom");
		lblStatus.setFont(new Font("Dialog", Font.ITALIC, 12));
		lblStatus.setBounds(269, 13, 115, 16);
		getContentPane().add(lblStatus);

	/** Button **/
		btnValider = new JButton("Valider");
		btnValider.setBounds(278, 62, 98, 26);
		btnValider.addActionListener(new GestionBoutons());
		getContentPane().add(btnValider);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(170, 62, 98, 26);
		btnAnnuler.addActionListener(new GestionBoutons());
		getContentPane().add(btnAnnuler);
			
		setVisible(true);
	}
	public FenSaison(String filename) {
		Saison s=new Saison(filename);
		setVisible(true);
		setSize(400,130);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Edition d'une saison");
		getContentPane().setLayout(null);
	
	/** TextBox **/
		txtNomSaison = new JTextField();
		txtNomSaison.setColumns(10);
		txtNomSaison.setBounds(119, 11, 140, 20);
		txtNomSaison.setText(s.getNom());
		getContentPane().add(txtNomSaison);
		
	/** Label **/
		lblNomSaison = new JLabel("Nom de la saison :");
		lblNomSaison.setBounds(10, 13, 103, 16);
		getContentPane().add(lblNomSaison);
		
		lblStatus = new JLabel(s.getNom());
		lblStatus.setFont(new Font("Dialog", Font.ITALIC, 12));
		lblStatus.setBounds(269, 13, 115, 16);
		lblStatus.setVisible(false);
		getContentPane().add(lblStatus);

	/** Button **/
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
				if(lblStatus.getText().equals("! Entrez un nom")) //Nouvelle ecurie crée
				{
					Saison temp=new Saison();
					temp.setNom(txtNomSaison.getText());
					temp.enregistrerSaisonF();
				}
				else //Ancienne qu'on a modifiée, on sauvegarde dans le fichier
				{
					//suppression vieux fichier
					String fichier="Saisons/"+lblStatus.getText()+".sai";
					try {
						File f = new File(fichier);
						if (f.exists())
						{
							f.delete();
						}
					}
					catch (Exception g){
						System.out.println(g.toString());
					}
					Saison temp=new Saison(lblStatus.getText());
					temp.setNom(txtNomSaison.getText()); //Filtre inclut dans le setter
					temp.enregistrerSaisonF();	//Création du nouveau
				}
				dispose();
			}
			else if (e.getSource() == btnAnnuler)
			{
				setVisible(false);
			}
			else if (e.getSource() == btnSupprimer)
			{
				String fichier="Saisons/"+lblStatus.getText()+".sai";
				try {
					File f = new File(fichier);
					if (f.exists())
					{
						f.delete();
					}
				}
				catch (Exception g){
					System.out.println(g.toString());
				}
				setVisible(false);
			}
		}
	}
}
