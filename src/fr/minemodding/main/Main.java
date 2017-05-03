package fr.minemodding.main;
import java.io.IOException;
import java.net.URL;

import javax.swing.JOptionPane;

import fr.minemodding.core.File;
import fr.minemodding.window.Loading_Window;

public class Main {

	public static void main(String[] args) {
		try {
			URL u = new URL("http://files.minecraftforge.net/maven/net/minecraftforge/forge/1.11.2-13.20.0.2294/forge-1.11.2-13.20.0.2294-installer.jar");
			File.download(u);
			JOptionPane.showMessageDialog(null, "Téléchargement terminé.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Loading_Window();		
	}

}
