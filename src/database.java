import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import data.gameversion;
import data.mod;
import window.loading_window;


public class database {
	
	public Statement database(){
		
		Statement state;
		state = null;
		
		try {
			Connection conn;
			
			String adress;
			String user;
			String password;
			
			Class.forName("org.postgresql.Driver");
			adress = "jdbc:postgresql://localhost:5432/test";
			user = "postgres";
			password = "azerty";
		
			conn = DriverManager.getConnection(adress, user, password);
			state = conn.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (state);
	}
	
	public List<gameversion> read(loading_window b)	{
		
		Statement state;
		List<gameversion> Lgameversion;
		String sql;
		ResultSet res;
		
		Lgameversion = new ArrayList<gameversion>();
		
		try {
			
			sql = "select * "
				+ "from gameversion"
				+ " inner join mod"
				+ " on gameversion_id = mod_uneVersion"
				+ " order by gameversion_label asc, mod_label";
		
			b.JL_loading.setText("Chargement des mods...");
			b.JPB_loading.setValue(0);
			state = database();
			res = state.executeQuery(sql);
			int nbmax = res.getFetchSize();
			b.JPB_loading.setMaximum(nbmax);
			res.next();
			while(!res.wasNull())	{
				
				b.JL_loading.setText("Chargement de " + res.getString("gameversion_label"));
				gameversion gameversion = new gameversion(res.getInt("gameversion_id"), res.getString("gameversion_label"));
				Lgameversion.add(gameversion);
				int old_gameversion = res.getInt("gameversion_id");
				
				do{
					
					b.JL_loading.setText("Chargement de " + res.getString("mod_label"));
					mod mod = new mod (res.getInt("mod_id"), res.getString("mod_label"), gameversion);
					gameversion.addlesMods(mod);
					b.JPB_loading.setValue(b.JPB_loading.getValue() + 1);
					
				}while(res.next() && res.getInt("gameversion_id") == old_gameversion);
			}
			state.close();
			state = null;
			res.close();
			res = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		b.JL_loading.setText("Terminé");
		b.JPB_loading.setValue(100);
		
		return Lgameversion;
	}
}
