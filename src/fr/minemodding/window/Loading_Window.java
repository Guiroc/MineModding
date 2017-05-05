package fr.minemodding.window;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import fr.minemodding.data.Profile;

public class Loading_Window extends JWindow{

	private static final long serialVersionUID = 05022017;
		
	public JProgressBar JPB_loading;
	public JLabel JL_loading;
	public JLabel JL_titre;
	public JPanel j;
	public List<Profile> Lprofile;
	
	public Loading_Window(){
			
		Font F_titre;
		
		F_titre = new Font(null, Font.PLAIN, 40);
		
		JL_titre = new JLabel();
		JL_titre.setBounds(5, 5, 490, 245);
		JL_titre.setHorizontalAlignment(SwingConstants.CENTER);
		JL_titre.setText("MineModding");
		JL_titre.setFont(F_titre);
		
		JL_loading = new JLabel();
		JL_loading.setBounds(5, 250, 490, 20);
		JL_loading.setHorizontalAlignment(SwingConstants.CENTER);
		JL_loading.setText("Chargement...");
		
		
		JPB_loading = new JProgressBar();
		JPB_loading.setMaximum(100);
		JPB_loading.setMinimum(0);
		JPB_loading.setValue(0);
		JPB_loading.setStringPainted(true);
		JPB_loading.setBounds(5, 275, 490, 20);
		JPB_loading.contains(50, 50);
		
		j = new JPanel(null);
		j.add(JL_loading);
		j.add(JPB_loading);
		j.add(JL_titre);
		
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		this.getContentPane().add(j);
		this.setVisible(true);
		
	}
	
public void setTextJL_loading(String texte){
	this.JL_loading.setText(texte);
}

public void setValueJPB_loading(int nombre){
	this.JPB_loading.setValue(nombre);
}
public void setMaximumJPB_loading(int nombre){
	this.JPB_loading.setMaximum(nombre);
}
public int getValueJPB_loading(){
	return this.JPB_loading.getValue();
}
//	----------------------------------------------------------------------------------------------------
}
