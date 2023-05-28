package server;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.login_check;
import dvo.DBLogin;




public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public login() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String pw=request.getParameter("password");
		login_check l=new login_check();
		l.setEmail(email);
		l.setPassword(pw);
		try {
			DBLogin d=new DBLogin();
			if(d.select(l)){
				response.sendRedirect("index2.html");
			}
			else{
				response.sendRedirect("signin.html");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
