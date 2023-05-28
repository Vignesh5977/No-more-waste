package server;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
import Bean.food;
import dvo.datastore;


public class fooddonate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   /* public fooddonate() {
        super();
        // TODO Auto-generated constructor stub
    }*/
    
  /* public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doGet(request, response);
	}
	*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Name=request.getParameter("name");
		String Quantity=request.getParameter("quantity");
		String Email=request.getParameter("email");
		String Phno=request.getParameter("phoneno");
		String Address =request.getParameter("address");
		food f=new food(Name,Quantity,Email,Phno, Address);
		f.setName(Name);
		f.setQuanlity(Quantity);
		f.setEmail(Email);
		f.setPhno(Phno);
		f.setAddress(Address);
		List<food> userList;
		try {
			userList = fooddata();
			
			request.setAttribute("userList", userList);
			
		       
	        request.getRequestDispatcher("profile.jsp").forward(request, response);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        
        
		try {
			datastore ds=new datastore();
			//List<food> foodd=ds.fooddata();
			ds.insert(f);
			response.sendRedirect("index2.html");
		/*	Iterator it=foodd.iterator();
			while(it.hasNext()) {
			
			System.out.print(it.next()+" ");
			}*/
			/*request.setAttribute("foodd", foodd);
			RequestDispatcher dispatcher=request.getRequestDispatcher("profile.jsp");
			dispatcher.forward(request, response);*/
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	Connection c;
    public fooddonate() throws ClassNotFoundException, SQLException {
    	c=dbconnetion.getdbc();
    }
	PreparedStatement s1=null;
    public List<food> fooddata() throws SQLException{
    	List<food> userList=new ArrayList<>();
    	try {
    	s1=c.prepareStatement("select * from foodlist");
    	ResultSet rs=s1.executeQuery();
    	while(rs.next()) {
    		String name=rs.getString("Name");
    		String quan=rs.getString("Quantity");
    		String email=rs.getString("Email");
    		String phno=rs.getString("Phno");
    		String address=rs.getString("Address");
    		 food user =new food(name,quan,email,phno,address);
    		userList.add(user);
  
    	}
    	rs.close();
    	s1.close();
    	c.close();
    	}catch(SQLException e){
			e.printStackTrace();
		}
		return userList;
    	
    }
   

}
