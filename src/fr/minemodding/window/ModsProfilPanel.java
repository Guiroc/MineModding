package fr.minemodding.window;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

import fr.minemodding.data.GameVersion;
import fr.minemodding.data.Mod;
import fr.minemodding.data.Profile;

public class ModsProfilPanel extends JPanel {
	
	private static final long serialVersionUID = 05022017;
	
	JLabel JLgameversion;
	JLabel JLmods;
	JLabel JLmodsselected; 
	DefaultListModel<Mod> DLMmods;
	DefaultListModel<Mod> DLMmodsselected; 
	JScrollPane JSPmods;
	JScrollPane JSPmodsselected; 
	JList<Mod> Lmods;
	JList<Mod> Lmodsselected; 
	JComboBox<GameVersion> JCBgameversion;
	JComboBox<Profile> JCBprofile;
	JButton JBselect_mod;
	JButton JBdeselect_mod; 
	GameVersion laselection;
//	-------------------------------------------------------------------------------------------------------------------------
	public ModsProfilPanel(List<GameVersion> b, List<Profile> c) {
		
		this.setLayout(null);
		
//		jpanel profilVersion---------------------------------------------
		Border border1 =BorderFactory.createTitledBorder("Profil et version");
		JPanel profilVersion = new JPanel();
		profilVersion.setBorder(border1);
		profilVersion.setBounds(0, 0, 120, 70);
		profilVersion.setLayout(null);
		this.add(profilVersion);
		
		JCBgameversion = new JComboBox<GameVersion>();
		JCBgameversion.setBounds(10, 40, 100, 20);
		JCBgameversion.setRenderer(new GameVersion_Renderer());
		JCBgameversion.addItemListener (new ItemListener () {
		
			public void itemStateChanged(ItemEvent arg0) {
						  
				if(arg0.getStateChange() == ItemEvent.DESELECTED){
					if(laselection != JCBgameversion.getSelectedItem()){
						if (!DLMmodsselected.isEmpty()){
							GameVersion_Changed ww = new GameVersion_Changed();
							ww.JB_accepte.addMouseListener(new MouseListener(){
								
								public void mouseClicked(MouseEvent arg0) {
									
									List<Mod> listmod;
									
									DLMmods.removeAllElements();
									DLMmodsselected.removeAllElements();
									laselection = (GameVersion) JCBgameversion.getSelectedItem();
									listmod = laselection.getLesMods();
									for (Mod unmod: listmod){
										DLMmods.addElement(unmod);
									}
									ww.dispose();
								}
								
								public void mouseEntered(MouseEvent e) {
								}
								
								public void mouseExited(MouseEvent e) {
								}
								
								public void mousePressed(MouseEvent e) {
								}
								
								public void mouseReleased(MouseEvent e) {
								}
							});
							ww.JB_annule.addMouseListener(new MouseListener(){
							
								public void mouseClicked(MouseEvent e) {
									JCBgameversion.setSelectedItem(laselection);
									ww.dispose();
								}
							
								public void mouseEntered(MouseEvent e) {
								}
							
								public void mouseExited(MouseEvent e) {
								}
							
								public void mousePressed(MouseEvent e) {
								}
							
								public void mouseReleased(MouseEvent e) {
								}
							});
						}
						else{
							List<Mod> listmod;
							DLMmods.removeAllElements();
							DLMmodsselected.removeAllElements();
							laselection = (GameVersion) JCBgameversion.getSelectedItem();
							listmod = laselection.getLesMods();
							for (Mod unmod: listmod){
								DLMmods.addElement(unmod);
							}
						}
					}
				}
			}
		});
		profilVersion.add(JCBgameversion);
		
		JCBprofile = new JComboBox<Profile>();
		JCBprofile.setBounds(10, 15, 100, 20);
		JCBprofile.setRenderer(new Profile_Renderer());
		for (Profile unprofile: c){
			JCBprofile.addItem(unprofile);
		}
		profilVersion.add(JCBprofile);
//		jpanel profilVersion---------------------------------------------
		
		
//		jpanel parametre------------------------------------------------
		border1 = BorderFactory.createTitledBorder("Paramètre");
		JPanel parametre = new JPanel();
		parametre.setLayout(null);
		parametre.setBorder(border1);
		parametre.setBounds(0, 75, 200, 65);
		this.add(parametre);
//		jpanel parametre------------------------------------------------
		
//		jpanel modding-------------------------------------------------
		border1 = BorderFactory.createTitledBorder("Modding");
		JPanel modding = new JPanel();
		modding.setLayout(null);
		modding.setBorder(border1);
		modding.setBounds(205, 0, 400, 400);
		this.add(modding);
		
		JLmods = new JLabel();
		JLmods.setBounds(110, 5, 150, 20);
		JLmods.setAlignmentX(CENTER_ALIGNMENT);
		JLmods.setText("Mods disponible");
		  
		JLmodsselected = new JLabel();
		JLmodsselected.setBounds(315, 5, 150, 20);
		JLmodsselected.setAlignmentX(CENTER_ALIGNMENT);
		JLmodsselected.setText("Mods selectionnés");
		
		DLMmods = new DefaultListModel<Mod>();
		Lmods = new JList<Mod>(DLMmods);
		Lmods.setCellRenderer(new Mod_Renderer());
		Lmods.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		Lmods.setLayoutOrientation(JList.VERTICAL);
		Lmods.setVisibleRowCount(-1);
		JSPmods = new JScrollPane(Lmods);
		JSPmods.setBounds(110, 30, 150, 300);
		JBselect_mod = new JButton();
		JBselect_mod.setBounds(260, 185, 50, 20);
		JBselect_mod.setText(">>");
		JBselect_mod.addMouseListener(new MouseListener(){
		
			public void mouseClicked(MouseEvent arg0) {
				
				List<Mod> selection;
				Integer nbmax2;
				Integer i2;
				
				selection = Lmods.getSelectedValuesList();
				if (selection != null){
					for (Mod uneselection: selection){
						i2 = 0;
						nbmax2 = DLMmodsselected.size();
						while(!DLMmodsselected.isEmpty() && nbmax2 > i2 && uneselection.getLabel().compareTo(DLMmodsselected.get(i2).getLabel()) > 0){
							i2++;
						}
						DLMmodsselected.add(i2, uneselection);
						DLMmods.removeElement(uneselection);
					}
				}
			}
			
			public void mouseEntered(MouseEvent arg0) {
			}
			
			public void mouseExited(MouseEvent arg0) {
			}
			
			public void mousePressed(MouseEvent arg0) {
			}
			
			public void mouseReleased(MouseEvent arg0) {
			}	  
		});
		JBdeselect_mod = new JButton();
		JBdeselect_mod.setBounds(260, 155, 50, 20);
		JBdeselect_mod.setText("<<");
		JBdeselect_mod.addMouseListener(new MouseListener(){
			
			public void mouseClicked(MouseEvent e) {
				
				List<Mod> selection;
				Integer nbmax;
				Integer nbmax2;
				Integer i2;
				
				selection = Lmodsselected.getSelectedValuesList();
				if (selection != null){
					nbmax = selection.size(); 
					for (int i = 0 ; i < nbmax ; i++){
						i2 = 0;
						nbmax2 = DLMmods.size();
						while(!DLMmods.isEmpty() && nbmax2 > i2 && selection.get(i).getLabel().compareTo(DLMmods.get(i2).getLabel()) > 0){
							i2++;
						}
						DLMmods.add(i2, selection.get(i));
						DLMmodsselected.removeElement(selection.get(i));
					}
				}
			}
			
			public void mouseEntered(MouseEvent e) {
			}
			
			public void mouseExited(MouseEvent e) {
			}
			
			public void mousePressed(MouseEvent e) {
			}
			
			public void mouseReleased(MouseEvent e) {
			}
		});
			  
		DLMmodsselected = new DefaultListModel<Mod>();
		Lmodsselected = new JList<Mod>(DLMmodsselected);
		Lmodsselected.setCellRenderer(new Mod_Renderer());
		Lmodsselected.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		Lmodsselected.setLayoutOrientation(JList.VERTICAL);
		Lmodsselected.setVisibleRowCount(-1);
			  
		JSPmodsselected = new JScrollPane(Lmodsselected);
		JSPmodsselected.setBounds(315, 30, 150, 300);
//		jpanel modding-------------------------------------------------
		
		this.addLGameVersion(b);
		
	}
//	-------------------------------------------------------------------------------------------------------------------------
	public void addLGameVersion(List<GameVersion> desgameversion){
	  
		List<Mod> listmod;
				
		for (GameVersion unegameversion: desgameversion){
			JCBgameversion.addItem(unegameversion);
		}
		laselection = (GameVersion) JCBgameversion.getSelectedItem();
		listmod = laselection.getLesMods();
		  
		for (Mod unmod: listmod){
			DLMmods.addElement(unmod);
		}
	}
}