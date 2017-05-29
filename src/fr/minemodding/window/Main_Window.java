package fr.minemodding.window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;


import fr.minemodding.core.FileProfile;

public class Main_Window extends JFrame {
	
	private static final long serialVersionUID = 05022017;
	
	public JTabbedPane jtp;
	public ModsProfilPanel modsProfilPanel;
	public AccueilPanel accueilPanel;
	public ModsPackPanel modsPackPanel;
		
	public Main_Window() {
		
		jtp = new JTabbedPane();
		accueilPanel = new AccueilPanel();
		modsProfilPanel = new ModsProfilPanel();
//		modsPackPanel = new ModsPackPanel();
		
		
	    jtp.addTab("Accueil", accueilPanel);
	    jtp.addTab("Mods et Profil", modsProfilPanel);
//	    jtp.addTab("ModsPack", modsPackPanel);
	    
		this.setVisible(true);
		this.setTitle("MineModding");
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				FileProfile.lesProfils.clear();
				for (int i = 0; i < ModsProfilPanel.JCBprofile.getItemCount() ; i++){
					FileProfile.lesProfils.add(ModsProfilPanel.JCBprofile.getItemAt(i));
				}
				FileProfile.createFileProfile();
				System.exit(0);
			}
		});
		this.add(jtp);
	}
}

