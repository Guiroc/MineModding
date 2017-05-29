package fr.minemodding.window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.minemodding.data.Profile;

public class Window_Profile extends JDialog{

	private static final long serialVersionUID = 1690632416220096154L;
	
	JLabel JLnom;
	JTextField JTFnom;
	JButton JBenregistrer;
	JButton JBannuler;
	JPanel JPpanel;
	
	public Window_Profile(final String nom){	
		
		JLnom = new JLabel("Nom du profil:");
		JLnom.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
		
		JTFnom = new JTextField(nom);
		JTFnom.setPreferredSize(new Dimension(200, 20));
		
		JBenregistrer = new JButton("Enregistrer");
		JBenregistrer.setPreferredSize(new Dimension(100, 20));
		JBenregistrer.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
				String nom1 = JTFnom.getText();
				if(nom1.equals("")){
					
				}
				else{
					
					if(nom.equals("")){
						Profile unProfile = new Profile(nom1);
						ModsProfilPanel.JCBprofile.addItem(unProfile);
						System.out.println(ModsProfilPanel.JCBprofile.getItemCount());
						System.out.print("test");
					}
					else{
						System.out.print("test2");
						int i = 0;
						while (!ModsProfilPanel.JCBprofile.getItemAt(i).getName().equals(nom)){
							i++;
						}
						ModsProfilPanel.JCBprofile.getItemAt(i).setName(nom1);
						ModsProfilPanel.JCBprofile.isValid();
					}
					dispose();
				}
			}
			
		});
		
		JBannuler = new JButton("Annuler");
		JBannuler.setPreferredSize(new Dimension(100, 20));
		JBannuler.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
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
		
		JPpanel = new JPanel();
		JPpanel.setLayout(new FlowLayout());
		JPpanel.add(JLnom);
		JPpanel.add(JTFnom);
		JPpanel.add(JBannuler);
		JPpanel.add(JBenregistrer);
		
		this.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		this.setSize(300, 100);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setAlwaysOnTop(true);
		this.setContentPane(JPpanel);
		this.setVisible(true);
	}
}
