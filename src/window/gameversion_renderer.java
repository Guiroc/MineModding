package window;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import data.gameversion;

public class gameversion_renderer implements ListCellRenderer<Object> {
		  protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
		  private final static Dimension preferredSize = new Dimension(0, 20);
		 
		  public Component getListCellRendererComponent(JList<?> list, Object value, int index,
		      boolean isSelected, boolean cellHasFocus) {
		    JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index,
		        isSelected, cellHasFocus);
		    if (value instanceof gameversion) {
		      renderer.setText(((gameversion)value).getLabel());
		    }
		    renderer.setPreferredSize(preferredSize);
		    return renderer;
		  }
		}
