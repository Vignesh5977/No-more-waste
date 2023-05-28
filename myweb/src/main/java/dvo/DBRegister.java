package dvo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Bean.register_check;
import server.dbconnetion;


public class DBRegister {
	Connection c;
	public DBRegister() throws ClassNotFoundException, SQLException{
		c=dbconnetion.getdbc();
	}
	PreparedStatement p=null;
	public void insert(register_check r) throws SQLException{
		p=c.prepareStatement("insert into register(username,email,password) values(?,?,?)");
		p.setString(1, r.getUsname());
		p.setString(2, r.getEmail());
		p.setString(3, r.getPassw());
		p.executeUpdate();
	}
	public void finalize() throws SQLException{
		p.close();
		c.close();
	}
}
