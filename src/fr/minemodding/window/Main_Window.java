package fr.minemodding.window;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import fr.minemodding.data.GameVersion;
import fr.minemodding.data.Profile;

public class Main_Window extends JFrame {
	
	private static final long serialVersionUID = 05022017;
	
	public JTabbedPane jtp;
	public ModsProfilPanel modsProfilPanel;
	public AccueilPanel accueilPanel;
	public ModsPackPanel modsPackPanel;
		
	public Main_Window(List<GameVersion> a, List<Profile> b) {
		
		
		
		jtp = new JTabbedPane();
		accueilPanel = new AccueilPanel();
		modsProfilPanel = new ModsProfilPanel(a, b);
		modsPackPanel = new ModsPackPanel();
		
		
	    jtp.addTab("Accueil", accueilPanel);
	    jtp.addTab("Mods et Profil", modsProfilPanel);
	    jtp.addTab("ModsPack", modsPackPanel);
	    
		this.setVisible(true);
		this.setTitle("MineModding");
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.add(jtp);
	}
}

