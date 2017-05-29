package fr.minemodding.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import fr.minemodding.data.GameVersion;
import fr.minemodding.data.Mod;
import fr.minemodding.data.ModVersion;
import fr.minemodding.data.Profile;

	public class FileProfile {
	public static ArrayList<Profile> lesProfils;
	
//	public static void loadingProfile(){
//		JSONObject b = null;
//		JSONParser parser = new JSONParser();
//		LesProfils = new ArrayList<Profile>();
//		try{
//			File file = new File(System.getenv("APPDATA") + "\\.minecraft\\launcher_profiles.json");
//			if(!file.exists()){
//				File dir = new File(System.getenv("APPDATA") + "\\.minecraft");
//				dir.mkdirs();
//				file.createNewFile();
//			}
//			Object obj = parser.parse(new FileReader( System.getenv("APPDATA") + "\\.minecraft\\launcher_profiles.json"));
//			JSONObject a = (JSONObject) obj;
//			b = (JSONObject) a.get("profiles");
//			String[] c1 = b.toJSONString().split("}");
//			int nb = c1.length;
//			for (int i = 0 ; i < nb ; i++){
//				String[] c2 = c1[i].split("\"");
//				JSONObject profil = (JSONObject) b.get(c2[1]);
//				LesProfils.add(new Profile((String) c2[1],(String) profil.get("gameDir"),(String) profil.get("lastVersionId"),(String) profil.get("javaDir"),(String) profil.get("javaArgs")));
//			}
//		}catch(Exception e){
//			System.out.println(e);
//		}
//		
//	}
	public static void loadingProfile(){
		lesProfils = new ArrayList<Profile>();
		File file = new File(System.getenv("APPDATA"), ".minemodding\\profiles.json");
		
		if(!file.exists()){
			try {
				file.createNewFile();
				Profile unProfile = new Profile("Default");
				FileProfile.lesProfils.add(unProfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			JSONParser parser = new JSONParser();
			JSONArray listProfile;
			JSONObject obj;
			JSONArray listMod;
			JSONObject obj1;
			Profile unProfile;
			int i1;
			int i2;
			Mod unMod;
			GameVersion unGameVersion;
			ArrayList<ModVersion> desModVersion;
			FileReader content;
			
			try {
				content = new FileReader(System.getenv("APPDATA") + "\\.minemodding\\profiles.json");
				listProfile = (JSONArray) parser.parse(content);
				content.close();
				
				for(int i = 0; i < listProfile.size(); i++){
					
					obj = (JSONObject) listProfile.get(i);
					if (obj.get("uneGameVersion") != null){
						i1 = 0;
						while (i1 < LoadingDatabase.lesGameVersion.size() && LoadingDatabase.lesGameVersion.get(i1).getId() != Integer.parseInt(obj.get("uneGameVersion").toString())){
							i1++;
						}
						unGameVersion = LoadingDatabase.lesGameVersion.get(i1);
						
						desModVersion = new ArrayList<ModVersion>();
						listMod = (JSONArray) obj.get("mods");
						
						for(i1 = 0 ; i1 < listMod.size(); i1++){
							obj1 = (JSONObject) listMod.get(i1);
							i2 = 0;
								
							while (i2 < unGameVersion.getLesMods().size() && unGameVersion.getLesMods().get(i2).getId() != Integer.parseInt(obj1.get("mod").toString())){
								i2++;
							}
//							System.out.println(unGameVersion.getLesMods().get(i2).getId());
//							System.out.print(Integer.parseInt(obj1.get("mod").toString()));
							unMod = unGameVersion.getLesMods().get(i2);
							i2 = 0;
							
							while (i2 < unMod.getLesModVersion().size() && unMod.getLesModVersion().get(i2).getId() != Integer.parseInt(obj1.get("modVersion").toString())){
								i2++;
							}
							desModVersion.add(unMod.getLesModVersion().get(i2));
						}
						System.out.println(desModVersion);
						System.out.println(unGameVersion);
						unProfile = new Profile(obj.get("name").toString(), unGameVersion, desModVersion);
					}
					else{
						unProfile = new Profile(obj.get("name").toString());
					}
					lesProfils.add(unProfile);
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void createFileProfile(){
		File file = new File(System.getenv("APPDATA"), ".minemodding\\profiles.json");
		
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray a = new JSONArray();
		
		for(Profile unProfile : lesProfils){
			JSONObject obj = new JSONObject();
			obj.put("name", unProfile.getName());
			if(unProfile.getUneGameVersion() != null){
				obj.put("uneGameVersion", unProfile.getUneGameVersion().getId());
			}
			else{
				obj.put("uneGameVersion", null);
			}
			JSONArray array = new JSONArray();
			
			for (ModVersion unModVersion : unProfile.getMods()){
				JSONObject obj2 = new JSONObject();
				obj2.put("mod", unModVersion.getUnMod().getId());
				obj2.put("modVersion", unModVersion.getId());
				array.add(obj2);
			}
			obj.put("mods", array);
			a.add(obj);
		}
		
		try {
			FileWriter file1 = new FileWriter(System.getenv("APPDATA") + "\\.minemodding\\profiles.json");
			file1.write(a.toJSONString());
			file1.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
