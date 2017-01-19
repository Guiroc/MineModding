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
	
	public  DefaultListModel read()	{
		
		Statement state;
		DefaultListModel dlmMods;
		String sql;
		ResultSet res;
		
		dlmMods = new DefaultListModel();
		sql = "select * from gameversion";
		
		try {
			JL_loading.
			state = database();
			res = state.executeQuery(sql);
			
				
			while(res.next())	{
				
				gameversion gameversion = new gameversion(res.getInt("gameversion_id"), res.getString("gameversion_label"));
				dlmMods.addElement(gameversion.getLabel());
//				int old_gameversion = res.getInt("gameversion_id");
//				do{
//					
//				}while(res.next() && res.getInt("gameversion_id") != old_gameversion);
			}
			state.close();
			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dlmMods;
	}
}
