package fr.minemodding.window;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import fr.minemodding.data.Profile;


public class Profile_Renderer implements ListCellRenderer<Object>{
	 public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		  
			DefaultListCellRenderer defaultRenderer;
			JLabel renderer;
			  
			defaultRenderer = new DefaultListCellRenderer();
		    renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		    
		    if (value instanceof Profile) {
		      renderer.setText(((Profile)value).getName());
		    }
		    return renderer;
		  }
}
