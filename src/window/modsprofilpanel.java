package window;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import data.gameversion;
import data.mod;

public class modsprofilpanel extends JPanel {
	 JList<mod> Lmods;
	 DefaultListModel<mod> dlmMods;
	 JScrollPane JSPmods;
	 JScrollPane JSPmodsselected;
	 JList<mod> Lmodsselected;
	 JComboBox<gameversion> JCBgameversion;
	 JButton JBselect_mod;
	 JButton JBdeselect_mod;
	  
  public modsprofilpanel(List<gameversion> b) {
	  
	  JCBgameversion = new JComboBox<gameversion>();
	  JCBgameversion.setBounds(0, 0, 100, 20);
	  JCBgameversion.setRenderer(new gameversion_renderer());
	  JCBgameversion.addItemListener (new ItemListener () {

		  public void itemStateChanged(ItemEvent arg0) {
				dlmMods.removeAllElements();
				gameversion sali = (gameversion) JCBgameversion.getSelectedItem();
				int nb = sali.getLesMods().size();
				List<mod> listmod = sali.getLesMods();
				for (int i = 0 ; i < nb ; i++){
					dlmMods.addElement(listmod.get(i));
				}
			}
		});
	  
	  
	  dlmMods = new DefaultListModel<mod>();
	  Lmods = new JList<mod>(dlmMods);
	  Lmods.setCellRenderer(new mod_renderer());
	  Lmods.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	  Lmods.setLayoutOrientation(JList.VERTICAL);
	  Lmods.setVisibleRowCount(-1);
	  
	  JSPmods = new JScrollPane(Lmods);
	  JSPmods.setBounds(105, 0, 150, 300);
	  
	  JBselect_mod = new JButton();
	  JBselect_mod.setBounds(260, 50, 50, 20);
	  JBselect_mod.setText(">>");
	  
	  JBdeselect_mod = new JButton();
	  JBdeselect_mod.setBounds(260, 100, 50, 20);
	  JBdeselect_mod.setText("<<");
	  
	  Lmodsselected = new JList<mod>();
	  Lmodsselected.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	  Lmodsselected.setLayoutOrientation(JList.VERTICAL);
	  Lmodsselected.setVisibleRowCount(-1);
	  
	  JSPmodsselected = new JScrollPane(Lmodsselected);
	  JSPmodsselected.setBounds(315, 0, 150, 300);
	  
	  this.addLgameversion(b);
	  this.setLayout(null);
	  this.add(JSPmodsselected);
	  this.add(JSPmods);
	  this.add(JCBgameversion);
	  this.add(JBselect_mod);
	  this.add(JBdeselect_mod);
  }
  
  public void addLgameversion(List<gameversion> a){
	  int nbmax = a.size();
	  
	  for (int i = 0 ; i < nbmax ; i++){
	  JCBgameversion.addItem(a.get(i));
	  }
  }
}
