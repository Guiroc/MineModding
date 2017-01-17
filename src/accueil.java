import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JWindow;
import javax.swing.ListSelectionModel;

public class accueil {
	
	public static void main(String[] args) {
		JFrame fenetre;
		JTabbedPane jtp;
		JWindow JW_loading;
		JProgressBar JPB_loading;
		JLabel JL_loading;
		
		// TODO Auto-generated method stub
		
		JW_loading = new JWindow();
		JW_loading.setSize(500, 300);
		JW_loading.setLocationRelativeTo(null);
		
		JPanel j = new JPanel();
		j.setBackground(Color.BLUE);
		JW_loading.getContentPane().add(j);
		
		JL_loading = new JLabel();
		JL_loading.setSize(450, 50);
		
		JPB_loading = new JProgressBar();
		JPB_loading.setMaximum(100);
		JPB_loading.setMinimum(0);
		JPB_loading.setValue(50);
		JPB_loading.setStringPainted(true);
		JPB_loading.setBounds(50, 200, 250, 50);
		JPB_loading.contains(50, 50);
		
		//JW_loading.getContentPane().add(JL_loading);
		//JW_loading.getContentPane().add(JPB_loading);
		//j.setLayout(mgr);
		j.add(JL_loading);
		j.add(JPB_loading);
		
		
		JW_loading.setVisible(true);
		
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JW_loading.dispose();
		
		fenetre = new JFrame();
		fenetre.setVisible(true);
		fenetre.setTitle("MineModding");
		fenetre.setSize(1200, 700);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	  JList<String> Lmods;
	  DefaultListModel<String> dlmMods;
	  
	  dlmMods = new DefaultListModel<String>();
	  Lmods = new JList<String>(dlmMods);
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
