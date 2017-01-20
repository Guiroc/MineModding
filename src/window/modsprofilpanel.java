package window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class modsprofilpanel extends JPanel {
	 JList<String> Lmods;
	 DefaultListModel<String> dlmMods;
	 JScrollPane JSPmods;
	 JScrollPane a;
	 JList<String> Lmodsselected;
	 JComboBox JCBgameversion;
	  
  public modsprofilpanel(List b) {
	  
	  JCBgameversion = new JComboBox();
	  JCBgameversion.setBounds(0, 0, 100, 20);
	  
	  JCBgameversion.addItemListener (new ItemListener () {

			public void itemStateChanged(ItemEvent arg0) {
//				print(JCBgameversion.getSelectedItem());
				
			}
		});
	  
	  
	  dlmMods = new DefaultListModel();
	  Lmods = new JList<String>(dlmMods);
	  Lmods.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	  Lmods.setLayoutOrientation(JList.VERTICAL);
	  Lmods.setVisibleRowCount(-1);
	  //dlmMods.addElement("aa");
	  
	  JSPmods = new JScrollPane(Lmods);
	  JSPmods.setBounds(100, 0, 150, 300);
	  
	  Lmodsselected = new JList<String>();
	  Lmodsselected.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	  Lmodsselected.setLayoutOrientation(JList.VERTICAL);
	  Lmodsselected.setVisibleRowCount(-1);
	  
	  a = new JScrollPane(Lmodsselected);
	  a.setBounds(250, 0, 150, 300);
	  
	  this.addLgameversion(b);
	  this.setLayout(null);
	  this.add(a);
	  this.add(JSPmods);
	  this.add(JCBgameversion);
  }
  
  public void addLgameversion(List a){
	  int nbmax = a.size();
	  
	  for (int i = 0 ; i < nbmax ; i++){
	  JCBgameversion.addItem(a.get(i));
	  }
  }
}
