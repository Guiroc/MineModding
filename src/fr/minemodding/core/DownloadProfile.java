package fr.minemodding.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JDialog;

import fr.minemodding.data.ModVersion;
import fr.minemodding.data.Profile;
import fr.minemodding.window.ModsProfilPanel;
import fr.minemodding.window.Window_Alert;

public class DownloadProfile {

	public static void downloadProfile(){
		Profile unProfile = (Profile) ModsProfilPanel.JCBprofile.getSelectedItem();
		File unFile = new File(System.getenv("APPDATA"), "/.minemodding/profile/" + unProfile.getName() + "/mods");
		if (!unFile.exists()){
			unFile.mkdirs();
		}
		Window_Alert boiteDialogue = new Window_Alert();
		boiteDialogue.download();
		ThreadDownloadProfile t = new ThreadDownloadProfile(unProfile, unFile, boiteDialogue);
		t.start();
//		boiteDialogue.dispose();
	}
	
	public static void download(URL url, File unFile) throws IOException {
		HttpURLConnection uc;
		InputStream in;
		String FileName;
		FileOutputStream WritenFile;
		byte[] buffer;
		int l;
		
		uc = (HttpURLConnection) url.openConnection();
		int FileLenght = uc.getContentLength();
		if (FileLenght == -1) {
			throw new IOException("Fichier non valide.");
		}
		in = uc.getInputStream();
		FileName = url.getFile();
		FileName = FileName.substring(FileName.lastIndexOf('/') + 1);
		WritenFile = new FileOutputStream(unFile + "/" + FileName);
		buffer = new byte[1024];
		l = in.read(buffer);
		while(l>0)
		{
		WritenFile.write(buffer, 0, l);
		l = in.read(buffer);
		}
		in.close();
		WritenFile.flush();
		WritenFile.close();
	}
}
