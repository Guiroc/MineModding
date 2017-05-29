package fr.minemodding.window;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
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
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import fr.minemodding.core.LoadingDatabase;
import fr.minemodding.core.DownloadProfile;
import fr.minemodding.core.FileProfile;
import fr.minemodding.data.GameVersion;
import fr.minemodding.data.Mod;
import fr.minemodding.data.ModVersion;
import fr.minemodding.data.Profile;

public class ModsProfilPanel extends JPanel {
	
	private static final long serialVersionUID = 05022017;
	
	static JComboBox<GameVersion> JCBgameversion;
	static GameVersion laselection;
	static DefaultListModel<Mod> DLMmods;
	static DefaultListModel<ModVersion> DLMmodsselected;
	static DefaultListModel<ModVersion> DLMmodsVersions;
	public static JComboBox<Profile> JCBprofile;
	
	JLabel JLgameversion;
	JLabel JLmods;
	JLabel JLmodsselected;  
	JScrollPane JSPmods;
	JScrollPane JSPmodsselected;
	JList<Mod> Lmods;
	JList<ModVersion> Lmodsselected;
	JButton JBselect_mod;
	JButton JBdeselect_mod;
	Window_Alert ww;
	JList<ModVersion> LmodsVersions;
	JButton JBnewProfile;
	JButton JBeditProfile;
//	-------------------------------------------------------------------------------------------------------------------------
	public ModsProfilPanel() {
		
		this.setLayout(null);
		
//		jpanel profil---------------------------------------------
		Border border1 =BorderFactory.createTitledBorder("Profil");
		JPanel profil = new JPanel();
		profil.setBorder(border1);
		profil.setBounds(0, 0, 700, 50);
		this.add(profil);
		
		JCBprofile = new JComboBox<Profile>();
		JCBprofile.setPreferredSize(new Dimension(300, 20));
		JCBprofile.setRenderer(new Profile_Renderer());
		JCBprofile.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.DESELECTED){
					ajoutGameVersionProfile();
					updateJListJCombobox();
				}
			}
			
		});
		
		JBnewProfile = new JButton("Nouveau");
		JBnewProfile.setPreferredSize(new Dimension(100, 20));
		JBnewProfile.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				new Window_Profile("");
			}
			
		});
		
		JBeditProfile = new JButton("Modifier");
		JBeditProfile.setPreferredSize(new Dimension(100, 20));
		JBeditProfile.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				new Window_Profile(((Profile) JCBprofile.getSelectedItem()).getName());
			}
			
		});
		
		profil.add(JBnewProfile);
		profil.add(JCBprofile);
		profil.add(JBeditProfile);
		
//		jpanel profilVersion---------------------------------------------
		
//		jpanel version--------------------------------------------------
		border1 =BorderFactory.createTitledBorder("Version du jeux");
		JPanel JPversion = new JPanel();
		JPversion.setBorder(border1);
		JPversion.setBounds(700, 0, 400, 50);
		this.add(JPversion);
		
		JCBgameversion = new JComboBox<GameVersion>();
		JCBgameversion.setPreferredSize(new Dimension(200, 20));
		JCBgameversion.setRenderer(new GameVersion_Renderer());
		JCBgameversion.addItemListener (new ItemListener () {
		
			public void itemStateChanged(ItemEvent arg0) {
						   
				if(arg0.getStateChange() == ItemEvent.DESELECTED){
					if(laselection != JCBgameversion.getSelectedItem()){
						if (!((DefaultListModel<ModVersion>) DLMmodsselected).isEmpty()){
//							ww = new Window_Alert();
//							ww.gameVersion_Changed();
							new Window_Alert().gameVersion_Changed();
							
						}
						else{
							List<Mod> listmod;
							DLMmods.removeAllElements();
							((DefaultListModel<ModVersion>) DLMmodsselected).removeAllElements();
							laselection = (GameVersion) JCBgameversion.getSelectedItem();
							int i = 0;
							while (i < FileProfile.lesProfils.size() && JCBprofile.getSelectedItem() != FileProfile.lesProfils.get(i)){
								i++;
							}
							FileProfile.lesProfils.get(i).setUneGameVersion(laselection);
							listmod = laselection.getLesMods();
							for (Mod unmod: listmod){
								DLMmods.addElement(unmod);
							}
						}
					}
				}
			}
		});
		
		
		JPversion.add(JCBgameversion);
		addLGameVersion();
		
//		jpanel version--------------------------------------------------
		
//		jpanel parametre------------------------------------------------
//		border1 = BorderFactory.createTitledBorder("Paramètre");
//		JPanel parametre = new JPanel();
//		parametre.setLayout(null);
//		parametre.setBorder(border1);
//		parametre.setBounds(0, 75, 200, 150);
//		this.add(parametre);
//		
//		JTextField JTFgamedir = new JTextField();
//		JTFgamedir.setBounds(10, 15, 100, 20);
//		parametre.add(JTFgamedir);
//		
//		JTextField JTFjavadirs = new JTextField();
//		JTFjavadirs.setBounds(10, 40, 100, 20);
//		parametre.add(JTFjavadirs);
//		
//		JTextField JTFjavaargs = new JTextField();
//		JTFjavaargs.setBounds(10, 65, 100, 20);
//		parametre.add(JTFjavaargs);
//		jpanel parametre------------------------------------------------
		
//		jpanel modding-------------------------------------------------
		border1 = BorderFactory.createTitledBorder("Modding");
		JPanel modding = new JPanel();
		modding.setLayout(null);
		modding.setBorder(border1);
		modding.setBounds(205, 50, 600, 400);
		this.add(modding);
		
		JLmods = new JLabel();
		JLmods.setBounds(10, 15, 300, 20);
		JLmods.setHorizontalAlignment(SwingConstants.CENTER);
		JLmods.setText("Mods disponible");
		modding.add(JLmods);
		  
		JLmodsselected = new JLabel();
		JLmodsselected.setBounds(390, 15, 150, 20);
		JLmodsselected.setHorizontalAlignment(SwingConstants.CENTER);
		JLmodsselected.setText("Mods selectionnés");
		modding.add(JLmodsselected);
		
		DLMmods = new DefaultListModel<Mod>();
		Lmods = new JList<Mod>(DLMmods);
		Lmods.setCellRenderer(new Mod_Renderer());
		Lmods.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Lmods.setLayoutOrientation(JList.VERTICAL);
		Lmods.setVisibleRowCount(-1);
		Lmods.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {		
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {	
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				DLMmodsVersions.removeAllElements();
				Mod selection = Lmods.getSelectedValue();
				if (selection != null){
					for(ModVersion unModVersion : selection.getLesModVersion()){
						DLMmodsVersions.addElement(unModVersion);
					}
				}
			}
			
		});
		
		JSPmods = new JScrollPane(Lmods);
		JSPmods.setBounds(10, 40, 150, 300);
		modding.add(JSPmods);
		
		JBselect_mod = new JButton();
		JBselect_mod.setBounds(325, 185, 50, 20);
		JBselect_mod.setText(">>");
		JBselect_mod.addMouseListener(new MouseListener(){
		
			public void mouseClicked(MouseEvent arg0) {
			}
			
			public void mouseEntered(MouseEvent arg0) {
			}
			
			public void mouseExited(MouseEvent arg0) {
			}
			
			public void mousePressed(MouseEvent arg0) {
			}
			
			public void mouseReleased(MouseEvent arg0) {
				List<ModVersion> selection;
				Integer nbmax2;
				Integer i2;
				
				selection = LmodsVersions.getSelectedValuesList();
				if (selection != null){
					for (ModVersion uneselection: selection){
						i2 = 0;
						int i = 0;
						while(i < DLMmodsselected.getSize() && DLMmodsselected.getElementAt(i).getUnMod() != uneselection.getUnMod()){
							i++;
						}
						if (i < DLMmodsselected.getSize()){
							uneselection.getUnMod().addUnModVersion(((DefaultListModel<ModVersion>) DLMmodsselected).get(i));
							((DefaultListModel<ModVersion>) DLMmodsselected).remove(i);
						}
						
						nbmax2 = DLMmodsselected.getSize();
						while(!((DefaultListModel<ModVersion>) DLMmodsselected).isEmpty() && nbmax2 > i2 && uneselection.getLabel().compareTo(((DefaultListModel<ModVersion>) DLMmodsselected).get(i2).getLabel()) > 0){
							i2++;
						}
						((DefaultListModel<ModVersion>) DLMmodsselected).add(i2, uneselection);
						uneselection.getUnMod().getLesModVersion().remove(uneselection);
						
						DLMmodsVersions.removeAllElements();
						Mod selection1 = Lmods.getSelectedValue();
						if (selection1 != null){
							for(ModVersion unModVersion : selection1.getLesModVersion()){
								DLMmodsVersions.addElement(unModVersion);
							}
						
						}
					}
				}
				updateProfile();
				System.out.println(DLMmodsselected.getSize());
			}	  
		});
		modding.add(JBselect_mod);
		
		JBdeselect_mod = new JButton();
		JBdeselect_mod.setBounds(325, 155, 50, 20);
		JBdeselect_mod.setText("<<");
		JBdeselect_mod.addMouseListener(new MouseListener(){
			
			public void mouseClicked(MouseEvent e) {
			}
			
			public void mouseEntered(MouseEvent e) {
			}
			
			public void mouseExited(MouseEvent e) {
			}
			
			public void mousePressed(MouseEvent e) {
			}
			
			public void mouseReleased(MouseEvent e) {
				List<ModVersion> selection;
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
						if (!DLMmods.contains(selection.get(i).getUnMod())){
							DLMmods.add(i2, selection.get(i).getUnMod());
						}
						DLMmods.get(DLMmods.indexOf(selection.get(i).getUnMod())).getLesModVersion().add(selection.get(i));
						DLMmodsVersions.removeAllElements();
						Mod selection1 = Lmods.getSelectedValue();
						if (selection1 != null){
							for(ModVersion unModVersion : selection1.getLesModVersion()){
								DLMmodsVersions.addElement(unModVersion);
							}
						}
						Profile unProfile = (Profile) JCBprofile.getSelectedItem();
						unProfile.getMods().remove(selection.get(i));
						((DefaultListModel<ModVersion>) DLMmodsselected).removeElement(selection.get(i));
					}
				}
//				updateProfile();
			}
		});
		modding.add(JBdeselect_mod);
			  
		DLMmodsselected = new DefaultListModel<ModVersion>();
		Lmodsselected = new JList<ModVersion>(DLMmodsselected);
		Lmodsselected.setCellRenderer(new ModVersionselected());
		Lmodsselected.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		Lmodsselected.setLayoutOrientation(JList.VERTICAL);
		Lmodsselected.setVisibleRowCount(-1);
			  
		JSPmodsselected = new JScrollPane(Lmodsselected);
		JSPmodsselected.setBounds(390, 40, 150, 300);
		modding.add(JSPmodsselected);
		
		DLMmodsVersions = new DefaultListModel<ModVersion>();
		LmodsVersions = new JList<ModVersion>(DLMmodsVersions);
		LmodsVersions.setCellRenderer(new ModVersion_Renderer());
		LmodsVersions.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		LmodsVersions.setLayoutOrientation(JList.VERTICAL);
		LmodsVersions.setVisibleRowCount(-1);
		
		JScrollPane JSPmodsVersions = new JScrollPane(LmodsVersions);
		JSPmodsVersions.setBounds(165, 40, 150, 300);
		modding.add(JSPmodsVersions);
		
		JButton JBtelecharger = new JButton("Télécharger");
		JBtelecharger.setBounds(365, 350, 200, 20);
		JBtelecharger.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				DownloadProfile.downloadProfile();
			}
			
		});
		modding.add(JBtelecharger);
		
//		jpanel modding-------------------------------------------------
		
//		traitement-----------------------------------------------------
		for (Profile unprofile: FileProfile.lesProfils){
			JCBprofile.addItem(unprofile);
		}
		int i = 0;
		System.out.println(((Profile)JCBprofile.getSelectedItem()).getUneGameVersion());
		while(i < JCBgameversion.getItemCount() && JCBgameversion.getItemAt(i).getId() != ((Profile) JCBprofile.getSelectedItem()).getUneGameVersion().getId()){
			i++;
		}
//		System.out.println(i);
		if(i < JCBgameversion.getItemCount()){
			JCBgameversion.setSelectedIndex(i);
		}
		ajoutGameVersionProfile();
		updateJListJCombobox();
	}
//	-------------------------------------------------------------------------------------------------------------------------
	public static void ajoutGameVersionProfile(){
		if(((Profile)JCBprofile.getSelectedItem()).getUneGameVersion() == null){
			((Profile)JCBprofile.getSelectedItem()).setUneGameVersion((GameVersion) JCBgameversion.getSelectedItem());
		}
		else{
			JCBgameversion.setSelectedItem(((Profile)JCBprofile.getSelectedItem()).getUneGameVersion());
		}
		try{
			ModsProfilPanel.addLmods();
		}catch(Exception e){
			
		}
	}
	public static void addLGameVersion(){
			
		if(JCBgameversion.getItemCount() > 0){
			JCBgameversion.removeAll();
		}
		
		for (GameVersion unegameversion: LoadingDatabase.lesGameVersion){
			JCBgameversion.addItem(unegameversion);
		}
	}
	public static void addLmods(){
		ArrayList<Mod> listmod;
		
		laselection = (GameVersion) JCBgameversion.getSelectedItem();
		listmod = (ArrayList<Mod>) laselection.getLesMods();
		  
		for (Mod unmod: listmod){
			DLMmods.addElement(unmod);
		}
	}
	
	public DefaultListModel<Mod> getDLMmods(){
		return DLMmods;
	}
	
	public void updateProfile(){
		Profile unProfile = (Profile) JCBprofile.getSelectedItem();
		unProfile.getMods().clear();
		for(int i = 0; i < Lmodsselected.getModel().getSize(); i++){
			unProfile.getMods().add(Lmodsselected.getModel().getElementAt(i));
		}

	}
	
	public static void updateJListJCombobox(){
		int i = 0;
		((DefaultListModel<ModVersion>) DLMmodsVersions).removeAllElements();
		
		while(i < ModsProfilPanel.JCBgameversion.getItemCount() && !ModsProfilPanel.JCBgameversion.getItemAt(i).equals(((Profile)JCBprofile.getSelectedItem()).getUneGameVersion())){
			i++;
		}
		
		if(i < ModsProfilPanel.JCBgameversion.getItemCount()){
			ModsProfilPanel.JCBgameversion.setSelectedIndex(i);
			ArrayList<Mod> listmod;
			DLMmods.removeAllElements();
			
			for (i = 0 ; i < DLMmodsselected.size(); i++){
				int i2 = 0;
				
				while(LoadingDatabase.lesGameVersion.get(i2).getId() != DLMmodsselected.get(i).getUnMod().getUneVersion().getId()){
					i2++;
				}
				GameVersion uneGameVersion = LoadingDatabase.lesGameVersion.get(i2);
				int i3 = 0;
				
				while(uneGameVersion.getLesMods().get(i3).getId() != DLMmodsselected.get(i).getUnMod().getId()){
					i3++;
				}
				uneGameVersion.getLesMods().get(i3).addUnModVersion(DLMmodsselected.get(i));
			}
			((DefaultListModel<ModVersion>) DLMmodsselected).removeAllElements();
			i = 0;
			
			while(LoadingDatabase.lesGameVersion.get(i).getId() != ((GameVersion) JCBgameversion.getSelectedItem()).getId()){
				i++;
			}
			laselection = LoadingDatabase.lesGameVersion.get(i);
			listmod = (ArrayList<Mod>) laselection.getLesMods();
			
			for (Mod unmod: listmod){
				DLMmods.addElement(unmod);
			}
			
			Profile unProfile = (Profile) JCBprofile.getSelectedItem();		
			
			for(ModVersion unModVersion : unProfile.getMods()){
				i = 0;
				
				while(i < DLMmods.size() && !DLMmods.getElementAt(i).getId().equals(unModVersion.getUnMod().getId())){
					i++;
				}
				if(i < DLMmods.size()){
					Mod unMod = DLMmods.getElementAt(i);
					i = 0;
					
					while(i < unMod.getLesModVersion().size() && !unMod.getLesModVersion().get(i).equals(unModVersion)){
						i++;
					}
					
					if(i < unMod.getLesModVersion().size()){
						unMod.getLesModVersion().remove(i);
					}
				}
				DLMmodsselected.addElement(unModVersion);
			}	
		}
		
	}
}