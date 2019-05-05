import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public static final String USERNAME="root";
	public static final String PASSWORD="";
	public static final String M_CONN_STRING="jdbc:mysql://localhost/explorecalifornia";

public static Connection getConnection() throws SQLException {
		
		
			 return DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);
		
		}
		

}
