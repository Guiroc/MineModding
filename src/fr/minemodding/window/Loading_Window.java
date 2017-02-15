package fr.minemodding.window;
import java.awt.Font;
import java.io.FileReader;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import fr.minemodding.data.Database;
import fr.minemodding.data.GameVersion;
import fr.minemodding.data.Mod;
import fr.minemodding.data.Profile;

public class Loading_Window extends JWindow{

	private static final long serialVersionUID = 05022017;
		
	public JProgressBar JPB_loading;
	public JLabel JL_loading;
	public JLabel JL_titre;
	public JPanel j;
	public List<Profile> Lprofile;
	
	public Loading_Window(){
			
		Font F_titre;
		
		F_titre = new Font(null, Font.PLAIN, 40);
		
		JL_titre = new JLabel();
		JL_titre.setBounds(5, 5, 490, 245);
		JL_titre.setHorizontalAlignment(SwingConstants.CENTER);
		JL_titre.setText("MineModding");
		JL_titre.setFont(F_titre);
		
		JL_loading = new JLabel();
		JL_loading.setBounds(5, 250, 490, 20);
		JL_loading.setHorizontalAlignment(SwingConstants.CENTER);
		JL_loading.setText("Chargement...");
		
		
		JPB_loading = new JProgressBar();
		JPB_loading.setMaximum(100);
		JPB_loading.setMinimum(0);
		JPB_loading.setValue(0);
		JPB_loading.setStringPainted(true);
		JPB_loading.setBounds(5, 275, 490, 20);
		JPB_loading.contains(50, 50);
		
		j = new JPanel(null);
		j.add(JL_loading);
		j.add(JPB_loading);
		j.add(JL_titre);
		
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		this.getContentPane().add(j);
		this.setVisible(true);
		
		chargementDatabase();
	}
//	----------------------------------------------------------------------------------------------------
	public void chargementDatabase(){
		
		List<GameVersion> Lgameversion;
		ResultSet res;
		Integer nbmax;
		Database database;
		
		Lgameversion = new ArrayList<GameVersion>();
		JL_loading.setText("Chargement des mods...");
		JPB_loading.setValue(0);
		try{
			
			database = new Database();
			res = database.read();
			nbmax = res.getFetchSize();
			JPB_loading.setMaximum(nbmax);
			res.next();
			while(!res.wasNull())	{
				
				JL_loading.setText("Chargement de " + res.getString("gameversion_label"));
				GameVersion gameversion = new GameVersion(res.getInt("gameversion_id"), res.getString("gameversion_label"));
				Lgameversion.add(gameversion);
				int old_gameversion = res.getInt("gameversion_id");
				
				do{
					
					JL_loading.setText("Chargement de " + res.getString("mod_label"));
					Mod mod = new Mod (res.getInt("mod_id"), res.getString("mod_label"), gameversion);
					gameversion.addlesMods(mod);
					JPB_loading.setValue(JPB_loading.getValue() + 1);
					
				}while(res.next() && res.getInt("gameversion_id") == old_gameversion);
			}
			res.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JL_loading.setText("Terminé");
		JPB_loading.setValue(100);
		this.chargementProfile();
		new Main_Window(Lgameversion, Lprofile);
		this.dispose();
	}
//	----------------------------------------------------------------------------------------------------
	public void chargementProfile(){
		JSONObject b = null;
		JSONParser parser = new JSONParser();
		Lprofile = new ArrayList<Profile>();
		try{
			Object obj = parser.parse(new FileReader( System.getenv("APPDATA") + "\\.minecraft\\launcher_profiles.json"));
			JSONObject a = (JSONObject) obj;
			b = (JSONObject) a.get("profiles");
			String[] c1 = b.toJSONString().split("}");
			int nb = c1.length;
			for (int i = 0 ; i < nb ; i++){
				String[] c2 = c1[i].split("\"");
				JSONObject profil = (JSONObject) b.get(c2[1]);
				Lprofile.add(new Profile((String) c2[1],(String) profil.get("gameDir"),(String) profil.get("lastVersionId"),(String) profil.get("javaDir"),(String) profil.get("javaArgs")));
			}
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
}
