package fr.minemodding.core;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JWindow;

import fr.minemodding.data.Database;
import fr.minemodding.data.GameVersion;
import fr.minemodding.data.Mod;
import fr.minemodding.data.ModVersion;
import fr.minemodding.window.Loading_Window;
import fr.minemodding.window.Main_Window;

public class LoadingDatabase {
		
	public static ArrayList<GameVersion> lesGameVersion;
	
	public static void loadingDatabase(Loading_Window a){
		
		ResultSet res;
		Integer nbmax;
		Database database;
		
		lesGameVersion = new ArrayList<GameVersion>();
		a.setTextJL_loading("Chargement des mods...");
		a.setValueJPB_loading(0);
		try{
			
			database = new Database();
			res = database.read();
			nbmax = res.getFetchSize();
			a.setMaximumJPB_loading(nbmax);
			res.next();
			
			while(!res.wasNull())	{
				a.setTextJL_loading("Chargement de " + res.getString("gameversion_label"));
				GameVersion gameversion = new GameVersion(res.getInt("gameversion_id"), res.getString("gameversion_label"));
				lesGameVersion.add(gameversion);
				int old_gameversion = res.getInt("gameversion_id");
				
				do{
					a.setTextJL_loading("Chargement de " + res.getString("mod_label"));
					Mod mod = new Mod (res.getInt("mod_id"), res.getString("mod_label"), gameversion);
					gameversion.addlesMods(mod);
					int old_mod = res.getInt("mod_id");
					
					do{
						a.setTextJL_loading("Chargement de " + res.getString("modversion_label"));
						ModVersion unModVersion = new ModVersion (res.getInt("modversion_id"), res.getString("modversion_label"), mod);
						mod.addUnModVersion(unModVersion);	
					}while(res.next() && res.getInt("gameversion_id") == old_gameversion && res.getInt("mod_id") == old_mod);
					a.setValueJPB_loading(a.getValueJPB_loading() + 1);	
				}while(!res.wasNull() && res.getInt("gameversion_id") == old_gameversion);
			}
			res.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		a.setTextJL_loading("Terminé");
		a.setValueJPB_loading(100);
	}
}
