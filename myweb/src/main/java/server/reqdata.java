package server;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import Bean.requestt;
import dvo.reqstore;

public class reqdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   /* public reqdata() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Name=request.getParameter("name");
		String Quantity=request.getParameter("quantity");
		String Email=request.getParameter("email");
		String Phno=request.getParameter("phoneno");
		String Address =request.getParameter("address");
		requestt r=new requestt(Name,Quantity,Email,Phno, Address);
		r.setName(Name);
		r.setQuantity(Quantity);
		r.setEmail(Email);
		r.setPhno(Phno);
		r.setAddress(Address);
		List<requestt>userListt;
		try {
			userListt = reqdataa();

			request.setAttribute("userListt", userListt);
			
		       
	        request.getRequestDispatcher("request1.jsp").forward(request, response);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
             
			reqstore rs=new reqstore();
			rs.insert(r);
			response.sendRedirect("index2.html");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	Connection c;
    public reqdata() throws ClassNotFoundException, SQLException {
    	c=dbconnetion.getdbc();
    }
	PreparedStatement s1=null;
    public List<requestt> reqdataa() throws SQLException{
    	List<requestt> userListt=new ArrayList<>();
    	try {
    	s1=c.prepareStatement("select * from foodlist");
    	ResultSet rs=s1.executeQuery();
    	while(rs.next()) {
    		String name=rs.getString("Name");
    		String quan=rs.getString("Quantity");
    		String email=rs.getString("Email");
    		String phno=rs.getString("Phno");
    		String address=rs.getString("Address");
    		 requestt user =new requestt(name,quan,email,phno,address);
    		userListt.add(user);
  
    	}
    	rs.close();
    	s1.close();
    	c.close();
    	}catch(SQLException e){
			e.printStackTrace();
		}
		return userListt;
    	
    }

}
