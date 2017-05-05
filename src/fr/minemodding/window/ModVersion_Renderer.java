package fr.minemodding.window;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import fr.minemodding.data.ModVersion;

	public class ModVersion_Renderer implements ListCellRenderer<Object> {
			  
//			  private final Dimension preferredSize = new Dimension(0, 20);
			 
			  public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				
				  DefaultListCellRenderer defaultRenderer;
				  JLabel renderer;
				  
				  defaultRenderer = new DefaultListCellRenderer();
				  renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			    
				  if (value instanceof ModVersion) {
			      
					  renderer.setText(((ModVersion)value).getLabel());
				  }
//			    renderer.setPreferredSize(preferredSize);
			    return renderer;
			  }
			}

	
	