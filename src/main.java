import javax.swing.DefaultListModel;

import window.loading_window;
import window.main_window;

public class main {

	public static void main(String[] args) {
		
		loading_window b = new loading_window();
		database req = new database();
		DefaultListModel a = req.read();
		b.dispose();
		main_window a1 = new main_window(a);
		
	}

}
