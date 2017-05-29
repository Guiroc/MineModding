package fr.minemodding.main;
import java.io.File;
import java.io.IOException;

import fr.minemodding.core.LoadingDatabase;
import fr.minemodding.core.FileProfile;
import fr.minemodding.window.Loading_Window;
import fr.minemodding.window.Main_Window;

public class Main {

	public static void main(String[] args) throws IOException {
//		try {
//			URL u = new URL("http://files.minecraftforge.net/maven/net/minecraftforge/forge/1.11.2-13.20.0.2294/forge-1.11.2-13.20.0.2294-installer.jar");
//			File.download(u);
//			JOptionPane.showMessageDialog(null, "Téléchargement terminé.");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		File dirContent = new File(System.getenv("APPDATA"), ".minemodding");
		if(!dirContent.exists()){
			dirContent.mkdirs();
		}
		Loading_Window a = new Loading_Window();
		LoadingDatabase.loadingDatabase(a);
		FileProfile.loadingProfile();
		a.dispose();
		new Main_Window();
	}

}
