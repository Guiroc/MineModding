package fr.minemodding.window;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import fr.minemodding.data.GameVersion;
import fr.minemodding.data.Profile;

public class Main_Window extends JFrame {
	
	private static final long serialVersionUID = 05022017;
	
	public JTabbedPane jtp;
	public ModsProfilPanel profil;
		
	public Main_Window(List<GameVersion> a, List<Profile> b) {
		
		
		
		jtp = new JTabbedPane();
		profil = new ModsProfilPanel(a, b);
		
	    jtp.addTab("Accueil", new AccueilPanel());
	    jtp.addTab("Mods et Profil", profil);
	    jtp.addTab("ModsPack", new ModsPackPanel());
	    
		this.setVisible(true);
		this.setTitle("MineModding");
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.add(jtp);
	}
}
class AccueilPanel extends JPanel {

	private static final long serialVersionUID = 05022017;

public AccueilPanel() {

    
  }
}

class ModsPackPanel extends JPanel {

	private static final long serialVersionUID = 05022017;

public ModsPackPanel() {

    
  }
  
}
