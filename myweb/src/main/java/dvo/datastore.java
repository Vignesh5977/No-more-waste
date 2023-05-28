package dvo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.food;
import server.dbconnetion;


//import org.apache.catalina.User;


public class datastore {
	Connection c;
    public datastore() throws ClassNotFoundException, SQLException {
    	c=dbconnetion.getdbc();
    }
    PreparedStatement s=null;
    public void insert(food f) throws SQLException {
    	s=c.prepareStatement("insert into foodlist(Name,Quantity,Email,Phno,Address) values(?,?,?,?,?)");
		s.setString(1,f.getName() );
		s.setString(2, f.getQuanlity());
		s.setString(3, f.getEmail());
		s.setString(4, f.getPhno());
		s.setString(5,f.getAddress());
		 s.executeUpdate();
		 s.close();
		 c.close();
	}
    
    

}
