package fr.minemodding.main;
import fr.minemodding.core.LoadingDatabase;
import fr.minemodding.core.LoadingProfile;
import fr.minemodding.window.Loading_Window;
import fr.minemodding.window.Main_Window;

public class Main {

	public static void main(String[] args) {
//		try {
//			URL u = new URL("http://files.minecraftforge.net/maven/net/minecraftforge/forge/1.11.2-13.20.0.2294/forge-1.11.2-13.20.0.2294-installer.jar");
//			File.download(u);
//			JOptionPane.showMessageDialog(null, "Téléchargement terminé.");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Loading_Window a = new Loading_Window();
		LoadingDatabase.loadingDatabase(a);
		LoadingProfile.loadingProfile();
		a.dispose();
		new Main_Window();
	}

}
