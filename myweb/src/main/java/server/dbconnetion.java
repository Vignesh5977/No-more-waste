package server;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnetion{
	 public static Connection getdbc() throws SQLException, ClassNotFoundException {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection c = DriverManager.getConnection("jdbc:oracle:thin:@Icu621:1521:XE","vignesh","vignesh59");
		return c;
	 }
}


