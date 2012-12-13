import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Interface extends JFrame {
	private JButton bouton1 = new JButton("Créer écurie");
	private JButton bouton2 = new JButton("Créer circuit");
	private JButton bouton3 = new JButton("Créer voiture");
	private JButton bouton4 = new JButton("Courir saison");
	private JButton bouton5 = new JButton("Courir circuit");
	
  public Interface(){
    this.setTitle("Projet LO43 - Sujet 2");
    this.setSize(800, 600);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
    this.setVisible(true);
    this.setResizable(false);
    Panneau p1 = new Panneau();
    p1.setLayout(new BoxLayout(p1, BoxLayout.LINE_AXIS));
    p1.add(bouton1);
    Panneau p2 = new Panneau();
    p2.setLayout(new BoxLayout(p2, BoxLayout.LINE_AXIS));
    p2.add(bouton2);
    Panneau p3 = new Panneau();
    p3.setLayout(new BoxLayout(p3, BoxLayout.LINE_AXIS));
    p3.add(bouton3);
    Panneau p4 = new Panneau();
    p4.setLayout(new BoxLayout(p4, BoxLayout.LINE_AXIS));
    p4.add(bouton4);
    Panneau p5 = new Panneau();
    p5.setLayout(new BoxLayout(p5, BoxLayout.LINE_AXIS));
    p5.add(bouton5);
    Panneau global = new Panneau();
    global.setLayout(new BoxLayout(global, BoxLayout.PAGE_AXIS));

    global.add(p1);
    global.add(p2);
    global.add(p3);
    global.add(p4);
    global.add(p5);

    this.getContentPane().add(global);               
    this.setVisible(true);
  }
 
}

