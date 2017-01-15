import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import donnee.mod;

public class accueil {
	
	public static void main(String[] args) {
		JFrame fenetre;
		JTabbedPane jtp;
		
		// TODO Auto-generated method stub
		fenetre = new JFrame();
		fenetre.setVisible(true);
		fenetre.setTitle("MineModding");
		fenetre.setSize(1200, 700);
		fenetre.setLocationRelativeTo(null);
		jtp = new JTabbedPane();
		fenetre.add(jtp);
		
		
	    jtp.addTab("Accueil", new AccueilPanel());
	    jtp.addTab("Mods et Profil", new ModsProfilPanel());
	    jtp.addTab("ModsPack", new ModsPackPanel());
	}

}
class AccueilPanel extends JPanel {

  public AccueilPanel() {

    
  }
}

class ModsProfilPanel extends JPanel {

  public ModsProfilPanel() {
	  JList Lmods;
	  DefaultListModel dlmMods;
	  
	  dlmMods = new DefaultListModel();
	  Lmods = new JList(dlmMods);
	  Lmods.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	  Lmods.setLayoutOrientation(JList.VERTICAL);
	  Lmods.setVisibleRowCount(-1);
	  dlmMods.addElement("aa");
	  dlmMods.addElement("aa");
	  dlmMods.addElement("aa");
	  dlmMods.addElement("aa");
	  dlmMods.addElement("aa");
	  dlmMods.addElement("aa");
	  dlmMods.addElement("aa");
	  dlmMods.addElement("aa");
	  dlmMods.addElement("aa");
	  JScrollPane JSPmods = new JScrollPane(Lmods);
	  JSPmods.setPreferredSize(new Dimension(150, 200));
	  add(JSPmods);
	  JScrollPane a = new JScrollPane(Lmods);
	  a.setPreferredSize(new Dimension(150,200));
	  add(a);
	  dlmMods.addElement("ab");
	  dlmMods.addElement("bb");
	  dlmMods.addElement("cc");
	  
  }
}

class ModsPackPanel extends JPanel {

  public ModsPackPanel() {

    
  }
}
