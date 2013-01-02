import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;


public class FenDessin extends JDialog {
	private static final long serialVersionUID = 1L;
	private JSpinner spinNbrePoints;
	private JLabel lblNbrePoints;
	private PanelDessin panZoneDessin;
	private JLabel lblZoneDessin;
	private JButton btnValider;
	private JButton btnDessiner;
	private JLabel lblNbrePointsRestants;
	private JLabel lblPointsRestants;
	private int m_nbPoints = 0;
	private int[] m_x;
	private int[] m_y;
	private String m_nomCircuit;
	
	public FenDessin(String nomCircuit) {
		setTitle("Dessiner un circuit");
		setSize(437, 437);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		
		m_nomCircuit = nomCircuit;
		
		getContentPane().setLayout(null);
		
		spinNbrePoints = new JSpinner();
		spinNbrePoints.setModel(new SpinnerNumberModel(new Integer(3), new Integer(3), null, new Integer(1)));
		spinNbrePoints.setBounds(234, 13, 48, 20);
		getContentPane().add(spinNbrePoints);
		
		lblNbrePoints = new JLabel("Nombre de points :");
		lblNbrePoints.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNbrePoints.setBounds(114, 14, 114, 16);
		getContentPane().add(lblNbrePoints);
		
		panZoneDessin = new PanelDessin();
		panZoneDessin.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panZoneDessin.setBounds(0, 54, 421, 258);
		getContentPane().add(panZoneDessin);
		
		lblZoneDessin = new JLabel("Zone de dessin :");
		lblZoneDessin.setBounds(10, 27, 92, 26);
		getContentPane().add(lblZoneDessin);
		
		btnValider = new JButton("Valider");
		btnValider.setBounds(322, 363, 89, 23);
		btnValider.setEnabled(false);
		btnValider.addActionListener(new GestionBoutons());
		getContentPane().add(btnValider);
		
		btnDessiner = new JButton("Dessiner");
		btnDessiner.setBounds(299, 12, 89, 23);
		btnDessiner.addActionListener(new GestionBoutons());
		getContentPane().add(btnDessiner);
		
		lblNbrePointsRestants = new JLabel("Nombre de points restants :");
		lblNbrePointsRestants.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNbrePointsRestants.setBounds(7, 370, 160, 16);
		getContentPane().add(lblNbrePointsRestants);
		
		lblPointsRestants = new JLabel("");
		lblPointsRestants.setBounds(179, 370, 32, 16);
		getContentPane().add(lblPointsRestants);
		
		setVisible(true);
	}
	
	public void enregistrerCircuit(String nomCircuit)
	{
		File fichier = new File("Circuits\\" + nomCircuit + ".tra");
		
		if (!fichier.exists())
		{			
			try{				
				FileWriter fw = new FileWriter (fichier);
				BufferedWriter bw = new BufferedWriter (fw);
				PrintWriter fichierSortie = new PrintWriter (bw);

				fichierSortie.println(m_nbPoints);
				for (int i = 0; i < m_nbPoints; i++)
				{				
					fichierSortie.println(m_x[i]);
					fichierSortie.println(m_y[i]);
				}

				bw.close();
			}
			catch (Exception exc){
				System.out.println(exc.toString());
			}
		}
	}
	
	class GestionBoutons implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnDessiner)
			{
				spinNbrePoints.setEnabled(false);
				btnDessiner.setEnabled(false);
				btnValider.setEnabled(true);
				lblPointsRestants.setText(spinNbrePoints.getValue().toString());
			}
			else if (e.getSource() == btnValider)
			{
				if (!lblPointsRestants.getText().equals("0"))
				{
					JOptionPane.showMessageDialog(null, "Il reste des points à ajouter !", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					enregistrerCircuit(m_nomCircuit);
					setVisible(false);
					dispose();
				}
			}
		}
	}
	
	
	class PanelDessin extends JPanel {
		private static final long serialVersionUID = 1L;
		private int m_compteur = 0;
		
	    public PanelDessin() {
	        super();
	        setOpaque(false); // we don't paint all our bits
	        setLayout(null);
	        setBorder(BorderFactory.createLineBorder(Color.black));
	        addMouseListener(new GestionClics());
	        
	    }
	
	    protected void paintComponent(final Graphics g) {
	        super.paintComponent(g);
	        if (m_compteur > 1)
	        {
	        	g.drawPolygon(m_x, m_y, m_compteur);
	        }
	    }
	    
	    class GestionClics implements MouseListener
	    {
	    	private int ptsRestants = 0;
			public void mousePressed(MouseEvent e)
			{
				if (spinNbrePoints.isEnabled() == true)
				{
					JOptionPane.showMessageDialog(null, "Veuillez cliquer sur le bouton dessiner !", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					if (m_nbPoints == 0)
					{
						m_nbPoints = (int) spinNbrePoints.getValue();
						ptsRestants = m_nbPoints;
						m_x = new int[m_nbPoints];
						m_y = new int[m_nbPoints];
					}
					
					
					if (ptsRestants > 0)
					{
						m_x[m_compteur] = e.getX();
						m_y[m_compteur] = e.getY();
						ptsRestants--;
						m_compteur++;
					}
					
					repaint();
					lblPointsRestants.setText(String.valueOf(ptsRestants));
				}
			}
	
			@Override
			public void mouseEntered(MouseEvent e) {
			}
	
			@Override
			public void mouseExited(MouseEvent e) {				
			}
	
			@Override
			public void mouseClicked(MouseEvent e) {
			}
	
			@Override
			public void mouseReleased(MouseEvent e) {
			}    	
	    }
	}
}
