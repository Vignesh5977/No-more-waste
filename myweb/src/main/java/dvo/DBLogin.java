package dvo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import Bean.login_check;
import server.dbconnetion;

public class DBLogin {
	Connection c;
	public DBLogin() throws ClassNotFoundException, SQLException{
		c=dbconnetion.getdbc();
}
	PreparedStatement p=null;
	public boolean select(login_check l) throws SQLException{
		boolean status=false;
		try{
			p=c.prepareStatement("select email,password from register where email=? and password=?");
			p.setString(1, l.getEmail());
			p.setString(2, l.getPassword());

			ResultSet rs=p.executeQuery();
			status=rs.next();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return status;
		
	}
	public void finalize() throws SQLException{
		p.close();
		c.close();
	}
}
