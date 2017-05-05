package fr.minemodding.core;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import fr.minemodding.data.Profile;

public class LoadingProfile {
	public static ArrayList<Profile> LesProfils;
	
	public static void loadingProfile(){
		JSONObject b = null;
		JSONParser parser = new JSONParser();
		LesProfils = new ArrayList<Profile>();
		try{
			File file = new File(System.getenv("APPDATA") + "\\.minecraft\\launcher_profiles.json");
			if(!file.exists()){
				File dir = new File(System.getenv("APPDATA") + "\\.minecraft");
				dir.mkdirs();
				file.createNewFile();
			}
			Object obj = parser.parse(new FileReader( System.getenv("APPDATA") + "\\.minecraft\\launcher_profiles.json"));
			JSONObject a = (JSONObject) obj;
			b = (JSONObject) a.get("profiles");
			String[] c1 = b.toJSONString().split("}");
			int nb = c1.length;
			for (int i = 0 ; i < nb ; i++){
				String[] c2 = c1[i].split("\"");
				JSONObject profil = (JSONObject) b.get(c2[1]);
				LesProfils.add(new Profile((String) c2[1],(String) profil.get("gameDir"),(String) profil.get("lastVersionId"),(String) profil.get("javaDir"),(String) profil.get("javaArgs")));
			}
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
}
