package window;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class loading_window extends JWindow{
		public JProgressBar JPB_loading;
		public JLabel JL_loading;
		JLabel JL_titre;
		JPanel j;
		Font F_titre;
	
		public loading_window(){		
		
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
		JPB_loading.setValue(50);
		JPB_loading.setStringPainted(true);
		JPB_loading.setBounds(5, 275, 490, 20);
		JPB_loading.contains(50, 50);
		
		j = new JPanel(null);
		//j.setLayout(null);
		j.add(JL_loading);
		j.add(JPB_loading);
		j.add(JL_titre);
		
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		this.getContentPane().add(j);
		this.setVisible(true);
		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		this.dispose();
//		main_window a = new main_window();
		}
}
