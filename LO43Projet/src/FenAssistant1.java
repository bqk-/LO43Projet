import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FenAssistant1 extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblEcurie;
	private JLabel lblVoitures;
	private JLabel lblVoitTherm;
	private JLabel lblVoitElec;
	private JLabel lblVoitHybr;
	private JComboBox<String> boxEcurie;
	private JComboBox<String> boxVoitTherm;
	private JComboBox<String> boxVoitElec;
	private JComboBox<String> boxVoitHybr;
	private JSeparator sepHaut;
	private JSeparator sepBas;	
	private JButton btnValider;
	private JButton btnEditer;
	
	public FenAssistant1() {
		setVisible(true);
		setResizable(false);
		setSize(230,334);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Assistant (1/2)");
		getContentPane().setLayout(null);
	
	/** Label **/
		lblEcurie = new JLabel("Choix de l'\u00E9curie :");
		lblEcurie.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEcurie.setBounds(10, 0, 143, 36);
		getContentPane().add(lblEcurie);
		
		lblVoitures = new JLabel("Choix des voitures :");
		lblVoitures.setFont(new Font("Dialog", Font.BOLD, 14));
		lblVoitures.setBounds(10, 69, 143, 25);
		getContentPane().add(lblVoitures);
		
		lblVoitTherm = new JLabel("Voiture thermique :");
		lblVoitTherm.setBounds(20, 97, 108, 17);
		getContentPane().add(lblVoitTherm);
		
		lblVoitElec = new JLabel("Voiture \u00E9lectrique :");
		lblVoitElec.setBounds(20, 153, 108, 17);
		getContentPane().add(lblVoitElec);
		
		lblVoitHybr = new JLabel("Voiture hybride :");
		lblVoitHybr.setBounds(20, 209, 108, 17);
		getContentPane().add(lblVoitHybr);
		
	/** ComboBox **/
		boxEcurie = new JComboBox<String>();
		boxEcurie.setModel(new DefaultComboBoxModel<String>(new String[] {"Choisir une \u00E9curie"}));
		boxEcurie.addActionListener(new GestionMenus());
		boxEcurie.setBounds(20, 33, 188, 25);
		getContentPane().add(boxEcurie);
		
		boxVoitTherm = new JComboBox<String>();
		boxVoitTherm.setModel(new DefaultComboBoxModel<String>(new String[] {"Choisir une voiture"}));
		boxVoitTherm.setBounds(20, 117, 188, 25);
		getContentPane().add(boxVoitTherm);
		
		boxVoitElec = new JComboBox<String>();
		boxVoitElec.setModel(new DefaultComboBoxModel<String>(new String[] {"Choisir une voiture"}));
		boxVoitElec.setBounds(20, 173, 188, 25);
		getContentPane().add(boxVoitElec);
		
		boxVoitHybr = new JComboBox<String>();
		boxVoitHybr.setModel(new DefaultComboBoxModel<String>(new String[] {"Choisir une voiture"}));
		boxVoitHybr.setBounds(20, 229, 188, 25);
		getContentPane().add(boxVoitHybr);
		
	/** Separator **/	
		sepHaut = new JSeparator();
		sepHaut.setBounds(0, 66, 434, 20);
		getContentPane().add(sepHaut);
		
		sepBas = new JSeparator();
		sepBas.setBounds(0, 265, 434, 10);
		getContentPane().add(sepBas);
		
		btnValider = new JButton("Valider");
		btnValider.setBounds(110, 270, 98, 26);
		btnValider.addActionListener(new GestionBoutons());
		getContentPane().add(btnValider);
		
		btnEditer = new JButton("Editer...");
		btnEditer.setBounds(10, 270, 98, 26);
		btnEditer.addActionListener(new GestionBoutons());
		getContentPane().add(btnEditer);

		chargerVoitures();
		chargerEcuries();
		
		setVisible(true);
	}
	
	public void chargerVoitures()
	{
		File rep = new File("Voitures");
		File[] listeFichiers = rep.listFiles();
		
		for (int i = 0; i < listeFichiers.length; i++)
		{
			String tmp = listeFichiers[i].toString().replace("Voitures\\", "");
			if (tmp.endsWith(".voi"))
			{
				tmp = tmp.replace(".voi", "");
				
				try{
					InputStream ips=new FileInputStream(listeFichiers[i].toString()); 
					InputStreamReader ipsr=new InputStreamReader(ips);
					BufferedReader br=new BufferedReader(ipsr);
					
					for (int j = 0; j < 5; j++)
					{
						br.readLine();
					}
					
					if (Integer.parseInt(br.readLine()) == 1)
					{
						boxVoitTherm.addItem(tmp);
					}
					else
					{
						boxVoitElec.addItem(tmp);
					}
					
					br.close(); 
				}
				catch (Exception exc){
					System.out.println(exc.toString());
				}	
			}
			else if (tmp.endsWith(".vhy"))
			{
				tmp = tmp.replace(".vhy", "");
				boxVoitHybr.addItem(tmp);
			}
		}
	}
		
	public void chargerEcuries()
	{
		File rep = new File("Ecuries");
		File[] listeFichiers = rep.listFiles();
		
		for (int i = 0; i < listeFichiers.length; i++)
		{
			boxEcurie.addItem(listeFichiers[i].toString().replace("Ecuries\\", "").replace(".ecu", ""));
		}
	}
	
	class GestionMenus implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == boxEcurie)
			{
				if (boxEcurie.getSelectedIndex() != 0)
				{
					try{
						InputStream ips=new FileInputStream("Ecuries\\"+boxEcurie.getSelectedItem()+".ecu"); 
						InputStreamReader ipsr=new InputStreamReader(ips);
						BufferedReader br=new BufferedReader(ipsr);
						
						br.readLine();
						boxVoitTherm.setSelectedItem(br.readLine());
						boxVoitElec.setSelectedItem(br.readLine());
						boxVoitHybr.setSelectedItem(br.readLine());
						br.close();
					}		
					catch (Exception exc){
						System.out.println(exc.toString());
					}
				}
				else
				{
					boxVoitTherm.setSelectedIndex(0);
					boxVoitElec.setSelectedIndex(0);
					boxVoitHybr.setSelectedIndex(0);
				}
			}
		}
	}
	
	class GestionBoutons implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnValider)
			{
				if (boxEcurie.getSelectedIndex() == 0)
				{
					JOptionPane.showMessageDialog(null, "Veuillez sélectionner une écurie !", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				else if (boxVoitTherm.getSelectedIndex() == 0)
				{
					JOptionPane.showMessageDialog(null, "Veuillez sélectionner une voiture thermique !", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				else if (boxVoitElec.getSelectedIndex() == 0)
				{
					JOptionPane.showMessageDialog(null, "Veuillez sélectionner une voiture électrique !", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				else if (boxVoitHybr.getSelectedIndex() == 0)
				{
					JOptionPane.showMessageDialog(null, "Veuillez sélectionner une voiture hybride !", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					//Enregistrement des données pour la simulation
					String fichier="Donnees/Simulation.txt";
					try {
						FileWriter fw = new FileWriter (fichier);
						BufferedWriter bw = new BufferedWriter (fw);
						PrintWriter fichierSortie = new PrintWriter (bw);
						// Nom ecurie \n Voiture1 \n Voiture2 \n Voiture3
						fichierSortie.println (boxEcurie.getSelectedItem().toString()+"\n"+boxVoitTherm.getSelectedItem().toString()+"\n"+boxVoitElec.getSelectedItem().toString()+"\n"+boxVoitHybr.getSelectedItem().toString()); 
						fichierSortie.close(); 
					}
					catch (Exception g){
						System.out.println(g.toString());
					}
					setVisible(false);
					dispose();
		            new FenAssistant2();
				}
			}
			else if (e.getSource() == btnEditer)
			{
				setVisible(false);
				dispose();
				new FenEdition("Assistant 1");
			}
		}
	}
}
