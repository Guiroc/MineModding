import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class database {
	
	public Statement database(){
		
		Statement state;
		state = null;
		
		try {
			Connection conn;
			
			String adress;
			String user;
			String password;
			
			adress = "";
			user = "";
			password = "";
		
			conn = DriverManager.getConnection(adress, user, password);
			state = conn.createStatement();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (state);
	}
}
