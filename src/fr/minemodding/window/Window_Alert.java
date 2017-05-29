package fr.minemodding.window;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.minemodding.core.DownloadProfile;
import fr.minemodding.data.GameVersion;
import fr.minemodding.data.Mod;
import fr.minemodding.data.ModVersion;

public class Window_Alert extends JDialog{
	
	private static final long serialVersionUID = 05022017;
	
	JPanel JP_default;
	JLabel JL_texte;
	JButton JB_annule;
	JButton JB_accepte;
	JButton JB_maj;
	
	public Window_Alert(){
		this.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setAlwaysOnTop(true);
	}
	public void gameVersion_Changed(){
		
		JL_texte = new JLabel();
		JL_texte.setBounds(5, 5, 490, 270);
		JL_texte.setText("La liste des mods selectionner sera effacer. Voulez-vous continuer ?");
		
		JB_annule = new JButton();
		JB_annule.setBounds(5, 275, 140, 20);
		JB_annule.setText("Annuler");
		JB_annule.addMouseListener(new MouseListener(){
			
			public void mouseClicked(MouseEvent e) {
				ModsProfilPanel.JCBgameversion.setSelectedItem(ModsProfilPanel.laselection);
				setModal(false);
				dispose();
			}
		
			public void mouseEntered(MouseEvent e) {
			}
		
			public void mouseExited(MouseEvent e) {
			}
		
			public void mousePressed(MouseEvent e) {
			}
		
			public void mouseReleased(MouseEvent e) {
			}
		});
		
//		JB_maj = new JButton();
//		JB_maj.setBounds(150, 275, 200, 20);
//		JB_maj.setText("Mettre à jour");
		
		JB_accepte = new JButton();
		JB_accepte.setBounds(355, 275, 140, 20);
		JB_accepte.setText("Continuer");
		JB_accepte.addMouseListener(new MouseListener(){
			
			public void mouseClicked(MouseEvent arg0) {
				
				List<Mod> listmod;
				ModsProfilPanel.DLMmods.removeAllElements();
				((DefaultListModel<ModVersion>) ModsProfilPanel.DLMmodsselected).removeAllElements();
				ModsProfilPanel.laselection = (GameVersion) ModsProfilPanel.JCBgameversion.getSelectedItem();
				listmod = ModsProfilPanel.laselection.getLesMods();
				for (Mod unmod: listmod){
					ModsProfilPanel.DLMmods.addElement(unmod);
				}
				
				dispose();
			}
			
			public void mouseEntered(MouseEvent e) {
			}
			
			public void mouseExited(MouseEvent e) {
			}
			
			public void mousePressed(MouseEvent e) {
			}
			
			public void mouseReleased(MouseEvent e) {
			}
		});
		
		JP_default = new JPanel(null);
		JP_default.add(JL_texte);
		JP_default.add(JB_annule);
		JP_default.add(JB_accepte);
//		JP_default.add(JB_maj);
		
		this.setModal(true);
		this.getContentPane().add(JP_default);
		this.setVisible(true);
	}
	
	public void error_DataBase(){
		
		JL_texte = new JLabel();
		JL_texte.setBounds(5, 5, 490, 270);
		JL_texte.setText("Erreur, nous n'avons pas pu trouver la base de donnée.");
		
		JB_annule = new JButton();
		JB_annule.setBounds(5, 275, 140, 20);
		JB_annule.setText("Quitter");
		JB_annule.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JB_accepte = new JButton();
		JB_accepte.setBounds(355, 275, 140, 20);
		JB_accepte.setText("Continuer");
		JB_accepte.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JP_default = new JPanel(null);
		JP_default.add(JL_texte);
		JP_default.add(JB_annule);
		JP_default.add(JB_accepte);
		
		this.setModal(true);
		this.getContentPane().add(JP_default);
		this.setVisible(true);
	}
	
	public void download(){
		
		JL_texte = new JLabel();
		JL_texte.setBounds(5, 5, 490, 270);
		JL_texte.setText("test");
		
		JB_annule = new JButton();
		JB_annule.setBounds(5, 275, 140, 20);
		JB_annule.setText("Annuler");
		JB_annule.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JB_accepte = new JButton();
		JB_accepte.setBounds(355, 275, 140, 20);
		JB_accepte.setText("OK");
		JB_accepte.setVisible(false);
		JB_accepte.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				dispose();
				
			}
			
		});
		
		JP_default = new JPanel(null);
		JP_default.add(JB_annule);
		JP_default.add(JL_texte);
		JP_default.add(JB_accepte);
		
		this.getContentPane().add(JP_default);
		this.setVisible(true);
	}
	
	public void setTexte_JL_texte(String texte){
		this.JL_texte.setText(texte);
	}
	
	public void setJB_accepteVisible(boolean bool){
		JB_accepte.setVisible(bool);
	}
	
	public void setJB_annuleVisible(boolean bool){
		JB_annule.setVisible(bool);
	}
}
