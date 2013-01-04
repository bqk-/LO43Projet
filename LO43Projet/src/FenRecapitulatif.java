import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import java.io.*;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class FenRecapitulatif extends JFrame {
	private JTextField nomSaison;
	private JTextField nomEcurie;
	private JTextArea textArea;
	public FenRecapitulatif(String ecurie, String saison) {
		setResizable(false);
		setSize(440,350);
		setLocationRelativeTo(null);
		setTitle("Récapitulatif");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblSaison = new JLabel("Saison :");
		lblSaison.setBounds(10, 11, 46, 14);
		getContentPane().add(lblSaison);
		
		nomSaison = new JTextField();
		nomSaison.setEditable(false);
		nomSaison.setBounds(66, 8, 86, 20);
		nomSaison.setText(saison);
		getContentPane().add(nomSaison);
		nomSaison.setColumns(10);
		
		JLabel lblEcurie = new JLabel("Ecurie :");
		lblEcurie.setBounds(181, 11, 46, 14);
		getContentPane().add(lblEcurie);
		
		nomEcurie = new JTextField();
		nomEcurie.setEditable(false);
		nomEcurie.setBounds(224, 8, 86, 20);
		nomEcurie.setText(ecurie);
		getContentPane().add(nomEcurie);
		nomEcurie.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 39, 434, 2);
		getContentPane().add(separator);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 51, 414, 232);
		
		String fichier="Donnees/Resultats.txt";
		String chaine="";
		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null)
				chaine+=ligne+"\n";
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		textArea.setText(chaine);
		getContentPane().add(textArea);
		JButton btnRetourAuMenu = new JButton("Retour au menu principal");
		btnRetourAuMenu.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent arg0) {
				setVisible(false);
				dispose();
				new FenPrincipale();
			}
		});
		btnRetourAuMenu.setBounds(10, 288, 414, 23);
		getContentPane().add(btnRetourAuMenu);
		setVisible(true);
	}
}
