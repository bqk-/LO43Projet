import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Interface2 extends JFrame {
	private final JLabel lblNomEcurie = new JLabel("Entrez le nom de l'\u00E9curie :");
	private JTextField txtNomEcurie;
	private final JComboBox comboBox = new JComboBox();

  public Interface2(){
    this.setTitle("Projet LO43 - Sujet 2");
    this.setSize(800, 600);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
    this.setVisible(true);
    this.setResizable(false);
    Panneau global = new Panneau();
    global.setBackground(Color.WHITE);
    global.setLayout(null);

    this.getContentPane().add(global);
    
    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    tabbedPane.setBounds(0, 0, 794, 572);
    global.add(tabbedPane);
    
    JPanel panEcurie = new JPanel();
    tabbedPane.addTab("Créer une écurie", null, panEcurie, null);
    panEcurie.setLayout(null);
    lblNomEcurie.setBounds(10, 11, 169, 14);
    
    panEcurie.add(lblNomEcurie);
    
    txtNomEcurie = new JTextField();
    txtNomEcurie.setBounds(191, 8, 140, 20);
    panEcurie.add(txtNomEcurie);
    txtNomEcurie.setColumns(10);
    
    JLabel lblChoixVoitTherm = new JLabel("Choisir la voiture \u00E0 moteur thermique :");
    lblChoixVoitTherm.setBounds(10, 36, 234, 14);
    panEcurie.add(lblChoixVoitTherm);

    comboBox.setBounds(256, 33, 115, 20);
    
    panEcurie.add(comboBox);
    
    JButton btnCreerVoitTherm = new JButton("Cr\u00E9er une voiture");
    btnCreerVoitTherm.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseReleased(MouseEvent arg0) {
    		fenCreerVoiture nouvVoiture = new fenCreerVoiture(1);
    	}
    });
    
    btnCreerVoitTherm.setBounds(394, 33, 134, 20);
    panEcurie.add(btnCreerVoitTherm);
    
    JLabel lblChoixVoitElec = new JLabel("Choisir la voiture \u00E0 moteur \u00E9lectrique :");
    lblChoixVoitElec.setBounds(10, 66, 234, 14);
    panEcurie.add(lblChoixVoitElec);
    
    JComboBox comboBox_1 = new JComboBox();
    comboBox_1.setBounds(256, 63, 115, 20);
    panEcurie.add(comboBox_1);
    
    JButton btnCreerVoitElec = new JButton("Cr\u00E9er une voiture");
    btnCreerVoitElec.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseReleased(MouseEvent e) {
    		fenCreerVoiture nouvVoiture = new fenCreerVoiture(2);
    	}
    });
    btnCreerVoitElec.setBounds(394, 63, 134, 20);
    panEcurie.add(btnCreerVoitElec);
    
    JLabel lblChoixVoitHyb = new JLabel("Choisir la voiture hybride :");
    lblChoixVoitHyb.setBounds(10, 96, 234, 14);
    panEcurie.add(lblChoixVoitHyb);
    
    JComboBox comboBox_2 = new JComboBox();
    comboBox_2.setBounds(256, 93, 115, 20);
    panEcurie.add(comboBox_2);
    
    JButton butCreerVoitHyb = new JButton("Cr\u00E9er une voiture");
    butCreerVoitHyb.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseReleased(MouseEvent e) {
    		fenCreerVoiture nouvVoiture = new fenCreerVoiture(3);
    	}
    });
    butCreerVoitHyb.setBounds(394, 93, 134, 20);
    panEcurie.add(butCreerVoitHyb);
    
    JPanel panel_1 = new JPanel();
    tabbedPane.addTab("Circuit", null, panel_1, null);
    this.setVisible(true);
  }
}

