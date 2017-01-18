import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;

public class main_window extends JFrame {
	
	public main_window() {
		
		JFrame fenetre;
		JTabbedPane jtp;
		
		jtp = new JTabbedPane();
	    jtp.addTab("Accueil", new AccueilPanel());
	    jtp.addTab("Mods et Profil", new ModsProfilPanel());
	    jtp.addTab("ModsPack", new ModsPackPanel());
	    
	    fenetre = new JFrame();
		fenetre.setVisible(true);
		fenetre.setTitle("MineModding");
		fenetre.setSize(1200, 700);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.add(jtp);
	}

}
class AccueilPanel extends JPanel {

  public AccueilPanel() {

    
  }
}

class ModsProfilPanel extends JPanel {

  public ModsProfilPanel() {
	  JList<String> Lmods;
	  DefaultListModel<String> dlmMods;
	  JScrollPane JSPmods;
	  JScrollPane a;
	  JList<String> Lmodsselected;
	  
	  dlmMods = new DefaultListModel<String>();
	  
	  Lmods = new JList<String>(dlmMods);
	  Lmods.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	  Lmods.setLayoutOrientation(JList.VERTICAL);
	  Lmods.setVisibleRowCount(-1);
	  //dlmMods.addElement("aa");
	  
	  JSPmods = new JScrollPane(Lmods);
	  JSPmods.setBounds(0, 0, 150, 300);
	  
	  Lmodsselected = new JList<String>(dlmMods);
	  Lmodsselected.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	  Lmodsselected.setLayoutOrientation(JList.VERTICAL);
	  Lmodsselected.setVisibleRowCount(-1);
	  
	  a = new JScrollPane(Lmodsselected);
	  a.setBounds(150, 0, 150, 300);
	  
	  this.setLayout(null);
	  this.add(a);
	  this.add(JSPmods);
  }
}

class ModsPackPanel extends JPanel {

  public ModsPackPanel() {

    
  }
  
}
