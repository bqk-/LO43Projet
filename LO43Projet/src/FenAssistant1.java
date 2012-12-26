import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JComboBox<String> boxEcurie;
	private JComboBox<String> boxVoitTherm;
	private JComboBox<String> boxVoitElec;
	private JComboBox<String> boxVoitHybr;
	private JSeparator sepHaut;
	private JSeparator sepBas;	
	private JButton btnNouvEcurie;
	private JButton btnEditerEcurie;
	private JButton btnNouvVoitTherm;
	private JButton btnEditerVoitTherm;
	private JButton btnNouvVoitElec;
	private JButton btnEditerVoitElec;
	private JButton btnNouvVoitHybr;
	private JButton btnEditerVoitHybr;
	private JButton btnValider;
	
	public FenAssistant1() {
		setVisible(true);
		setResizable(false);
		setSize(440,350);
		setLocationRelativeTo(null);
		setTitle("Assistant de cr\u00E9ation (1/2)");
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
		lblEcurie.setLabelFor(boxEcurie);
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
		sepBas.setBounds(0, 275, 434, 10);
		getContentPane().add(sepBas);
	
	/** Button **/
		btnNouvVoitElec = new JButton("Nouvelle...");
		btnNouvVoitElec.setBounds(218, 172, 98, 26);
		btnNouvVoitElec.addActionListener(new GestionBoutons());
		getContentPane().add(btnNouvVoitElec);
		
		btnEditerVoitElec = new JButton("Editer");
		btnEditerVoitElec.setBounds(326, 172, 98, 26);
		btnEditerVoitElec.addActionListener(new GestionBoutons());
		getContentPane().add(btnEditerVoitElec);
		
		btnNouvEcurie = new JButton("Nouvelle...");
		btnNouvEcurie.setBounds(218, 32, 98, 26);
		btnNouvEcurie.addActionListener(new GestionBoutons());
		getContentPane().add(btnNouvEcurie);
		
		btnEditerEcurie = new JButton("Editer");
		btnEditerEcurie.setBounds(326, 32, 98, 26);
		btnEditerEcurie.addActionListener(new GestionBoutons());
		getContentPane().add(btnEditerEcurie);
		
		btnNouvVoitTherm = new JButton("Nouvelle...");
		btnNouvVoitTherm.setBounds(218, 116, 98, 26);
		btnNouvVoitTherm.addActionListener(new GestionBoutons());
		getContentPane().add(btnNouvVoitTherm);
		
		btnEditerVoitTherm = new JButton("Editer");
		btnEditerVoitTherm.setBounds(326, 116, 98, 26);
		btnEditerVoitTherm.addActionListener(new GestionBoutons());
		getContentPane().add(btnEditerVoitTherm);
		
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
			if (tmp.endsWith(".vth"))
			{
				tmp = tmp.replace(".vth", "");
				boxVoitTherm.addItem(tmp);
			}
			else if (tmp.endsWith(".vel"))
			{
				tmp = tmp.replace(".vel", "");
				boxVoitElec.addItem(tmp);
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
				if(boxEcurie.getSelectedItem().toString().equals("Choisir une \u00E9curie")) //Nouvelle 
					new FenEcurie();
				else
					new FenEcurie(boxEcurie.getSelectedItem().toString());
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
