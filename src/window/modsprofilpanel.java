package window;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class modsprofilpanel extends JPanel {
	public JList<String> Lmods;
	public DefaultListModel<String> dlmMods;
	public JScrollPane JSPmods;
	public JScrollPane a;
	public JList<String> Lmodsselected;
	  
  public modsprofilpanel(DefaultListModel b) {
	  
	  
	  dlmMods = b;
	  Lmods = new JList<String>(dlmMods);
	  Lmods.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	  Lmods.setLayoutOrientation(JList.VERTICAL);
	  Lmods.setVisibleRowCount(-1);
	  //dlmMods.addElement("aa");
	  
	  JSPmods = new JScrollPane(Lmods);
	  JSPmods.setBounds(0, 0, 150, 300);
	  
	  Lmodsselected = new JList<String>();
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
