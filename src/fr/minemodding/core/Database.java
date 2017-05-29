package fr.minemodding.core;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import fr.minemodding.data.GameVersion;
import fr.minemodding.window.Window_Alert;


public class Database {
	
	private static Statement database(){
		
		Statement state;
		state = null;
		Connection conn;
		String adress;
		String user;
		String password;
		
		try {
			
			Class.forName("org.postgresql.Driver");
			adress = "jdbc:postgresql://localhost:5432/test";
			user = "software";
			password = "azerty";
		
			conn = DriverManager.getConnection(adress, user, password);
			state = conn.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (state);
	}
	
	 public static ResultSet read(){
		
		Statement state;
		String sql;
		ResultSet res1;
		Window_Alert Alert; 
		
		res1 = null;
		new ArrayList<GameVersion>();
		
		try {
			
			sql = "select * "
				+ "from SoftwareCheckUpdates";
		
			state = database();
			state.executeQuery(sql);
			res1 = state.getResultSet();
			
		} catch (Exception e) {
			e.printStackTrace();
			Alert = new Window_Alert();
			Alert.error_DataBase();	
		}
		return res1;
	}
}
