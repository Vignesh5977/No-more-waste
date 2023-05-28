package server;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.register_check;
import dvo.DBRegister;


public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname=request.getParameter("name");
		String emailid=request.getParameter("email");
		String pw=request.getParameter("password");
		register_check r= new register_check();
		r.setUsname(uname);
		r.setEmail(emailid);
		r.setPassw(pw);
		try {
			DBRegister dsr=new DBRegister();
			dsr.insert(r);
			response.sendRedirect("signin.html");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
