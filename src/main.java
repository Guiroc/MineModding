import java.util.List;

import javax.swing.DefaultListModel;

import window.loading_window;
import window.main_window;

public class main {

	public static void main(String[] args) {
		
		loading_window b = new loading_window();
		database req = new database();
//		try {
//			Thread.sleep(0);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		List a = req.read(b);
		b.dispose();
		main_window a1 = new main_window(a);
		
	}

}
