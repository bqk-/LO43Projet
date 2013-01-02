import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JList;

public class FenAssistant2 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblSaison;
	private JLabel lblCircuits;
	private JButton btnValider;
	private JComboBox<String> boxSaison;
	private JList<String> lstCircuitsSelec;
	private JSeparator sepHaut;
	private JSeparator sepBas;
	private JButton btnEditer;
	
	public FenAssistant2() {
		setVisible(true);
		setResizable(false);
		setSize(223,325);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Assistant (2/2)");
		getContentPane().setLayout(null);
	
	/** Label **/
		lblSaison = new JLabel("Choix de la saison :");
		lblSaison.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSaison.setBounds(8, 0, 143, 36);
		getContentPane().add(lblSaison);
		
		lblCircuits = new JLabel("Choix des circuits :");
		lblCircuits.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCircuits.setBounds(8, 69, 143, 25);
		getContentPane().add(lblCircuits);
	
	/** List **/
	    lstCircuitsSelec = new JList<String>();
		lstCircuitsSelec.setBounds(18, 105, 188, 133);
		getContentPane().add(lstCircuitsSelec);
		
	/** ComboBox **/
		boxSaison = new JComboBox<String>();
		boxSaison.setModel(new DefaultComboBoxModel<String>(new String[] {"Choisir une saison"}));
		boxSaison.setBounds(18, 33, 188, 25);
		boxSaison.addActionListener(new GestionMenus());
		getContentPane().add(boxSaison);
	
	/** Separator **/
		sepBas = new JSeparator();
		sepBas.setBounds(-4, 249, 436, 10);
		getContentPane().add(sepBas);
		
		sepHaut = new JSeparator();
		sepHaut.setBounds(-2, 66, 434, 20);
		getContentPane().add(sepHaut);
		
	/** Button **/
		btnValider = new JButton("Valider");
		btnValider.setBounds(108, 260, 98, 26);
		btnValider.addActionListener(new GestionBoutons());
		getContentPane().add(btnValider);
		
		btnEditer = new JButton("Editer...");
		btnEditer.setBounds(5, 260, 98, 26);
		btnEditer.addActionListener(new GestionBoutons());
		getContentPane().add(btnEditer);
		
		chargerSaisons();
		setVisible(true);
	}
	
	public void chargerSaisons()
	{
		File rep = new File("Saisons");
		File[] listeFichiers = rep.listFiles();
		
		for (int i = 0; i < listeFichiers.length; i++)
		{
			boxSaison.addItem(listeFichiers[i].toString().replace("Saisons\\", "").replace(".sai", ""));
		}
	}
	
	class GestionMenus implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == boxSaison)
			{
				if (boxSaison.getSelectedIndex() != 0)
				{
					int nbrCircuits;
					String[] listeCircuits = null;
					try{
						InputStream ips=new FileInputStream("Saisons\\"+boxSaison.getSelectedItem()+".sai"); 
						InputStreamReader ipsr=new InputStreamReader(ips);
						BufferedReader br=new BufferedReader(ipsr);
						
						br.readLine();
						nbrCircuits = Integer.parseInt(br.readLine());
						listeCircuits = new String[nbrCircuits];
						for (int i = 0; i < nbrCircuits; i++)
						{
							listeCircuits[i] = br.readLine();
						}
						lstCircuitsSelec.setListData(listeCircuits);
						
						br.close();
					}
					catch (Exception exc){
						System.out.println(exc.toString());
					}
				}
				else
				{
					lstCircuitsSelec.setListData(new String[1]);
				}
			}
		}
	}
	
	class GestionBoutons implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnValider)
			{
				if (boxSaison.getSelectedIndex() == 0)
				{
					JOptionPane.showMessageDialog(null, "Veuillez sélectionner une saison !", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					setVisible(false);
					dispose();
					new FenSimulation();
				}
			}
			else if (e.getSource() == btnEditer)
			{
				setVisible(false);
				dispose();
				new FenEdition("Assistant 2");
			}
		}
	}
}
