package dvo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Bean.requestt;
import server.dbconnetion;

public class reqstore {
	Connection c;
    public reqstore() throws ClassNotFoundException, SQLException {
    	c=dbconnetion.getdbc();
    }
    PreparedStatement s=null;
    public void insert(requestt r) throws SQLException {
    	s=c.prepareStatement("insert into reqlist(Name,Quantity,Email,Phno,Address) values(?,?,?,?,?)");
		s.setString(1,r.getName() );
		s.setString(2, r.getQuantity());
		s.setString(3, r.getEmail());
		s.setString(4, r.getPhno());
		s.setString(5, r.getAddress());
		 s.executeUpdate();
		 s.close();
		 c.close();
}
}
