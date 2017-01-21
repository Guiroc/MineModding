package window;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import data.mod;

	public class mod_renderer implements ListCellRenderer<Object> {
			  protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
//			  private final Dimension preferredSize = new Dimension(0, 20);
			 
			  public Component getListCellRendererComponent(JList<?> list, Object value, int index,
			      boolean isSelected, boolean cellHasFocus) {
			    JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index,
			        isSelected, cellHasFocus);
			    if (value instanceof mod) {
			      renderer.setText(((mod)value).getLabel());
			    }
//			    renderer.setPreferredSize(preferredSize);
			    return renderer;
			  }
			}
