package fr.minemodding.core;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import fr.minemodding.data.ModVersion;
import fr.minemodding.data.Profile;
import fr.minemodding.window.Window_Alert;

public class ThreadDownloadProfile extends Thread{
	Profile unProfile;
	File unFile;
	Window_Alert boiteDialogue;
	int modFailed;
	
	public ThreadDownloadProfile(Profile unProfile, File unFile, Window_Alert boiteDialogue){
		this.unProfile = unProfile;
		this.unFile = unFile;
		this.boiteDialogue = boiteDialogue;
	}
	public void run(){
		modFailed = 0;
		int nb = unProfile.getMods().size();
		int i = 0;
		
		for (ModVersion unModVersion : unProfile.getMods()){
			i++;
				((Window_Alert) boiteDialogue).setTexte_JL_texte("Téléchargement de " + i + " sur " + nb + ".");
			try {
				URL unUrl = new URL("http://127.0.0.1/" + unProfile.getUneGameVersion().getLabel() + "/" + unModVersion.getUnMod().getLabel().replaceAll(" ", "_") + "/" + unProfile.getUneGameVersion().getLabel() + "_" + unModVersion.getUnMod().getLabel().replaceAll(" ", "_") + "_" + unModVersion.getLabel() + ".jar");
				System.out.println(unUrl);
				DownloadProfile.download(unUrl, unFile);
			} catch (IOException e) {
				e.printStackTrace();
				modFailed++;
			}
		}
		if (modFailed > 0){
			boiteDialogue.setTexte_JL_texte(modFailed + " mods n'ont pas pu être téléchargé sur " + nb + ".");
		}
		else{
			boiteDialogue.setTexte_JL_texte("Téléchargement terminé");
		}
		boiteDialogue.setJB_annuleVisible(false);
		boiteDialogue.setJB_accepteVisible(true);
	}
}
