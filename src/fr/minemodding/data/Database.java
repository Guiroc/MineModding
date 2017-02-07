package fr.minemodding.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class Database {
	
	private Statement database(){
		
		Statement state;
		state = null;
		Connection conn;
		String adress;
		String user;
		String password;
		
		try {
			
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
	
	 public ResultSet read(){
		
		Statement state;
		String sql;
		ResultSet res1;
		
		res1 = null;
		new ArrayList<GameVersion>();
		
		try {
			
			sql = "select * "
				+ "from gameversion"
				+ " inner join mod"
				+ " on gameversion_id = mod_uneVersion"
				+ " order by gameversion_label asc, mod_label";
		
			state = database();
			state.executeQuery(sql);
			res1 = state.getResultSet();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res1;
	}
}
