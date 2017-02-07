package fr.minemodding.window;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class GameVersion_Changed extends JWindow{
	
	private static final long serialVersionUID = 05022017;
	
	public JPanel JP_default;
	public JLabel JL_texte;
	public JButton JB_annule;
	public JButton JB_accepte;
	public JButton JB_maj;
		
	public GameVersion_Changed(){
		
		JL_texte = new JLabel();
		JL_texte.setBounds(5, 5, 490, 270);
		JL_texte.setText("La liste des mods selectionner sera effacer. Voulez-vous continuer ?");
		
		JB_annule = new JButton();
		JB_annule.setBounds(5, 275, 140, 20);
		JB_annule.setText("Annuler");
		
		JB_maj = new JButton();
		JB_maj.setBounds(150, 275, 200, 20);
		JB_maj.setText("Mettre à jour");
		
		JB_accepte = new JButton();
		JB_accepte.setBounds(355, 275, 140, 20);
		JB_accepte.setText("Continuer");
		
		JP_default = new JPanel(null);
		JP_default.add(JL_texte);
		JP_default.add(JB_annule);
		JP_default.add(JB_accepte);
		JP_default.add(JB_maj);
		
		this.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		this.getContentPane().add(JP_default);
		this.setVisible(true);
	}
}
