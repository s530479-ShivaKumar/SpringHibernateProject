package TestDBConnection;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// setup connection variables
		String user = "springstudent";
		String pass = "springstudent";
	
		String jdbcurl = "jdbc:mysql://localhost/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			PrintWriter out = response.getWriter();
			out.println("connectiong to database: " + jdbcurl);
			
			Class.forName(driver);
			
			Connection myconn = DriverManager.getConnection(jdbcurl, user, pass); 
			
			out.println("successful");
			
			myconn.close();
			
		}
		catch (Exception exe) {
			exe.printStackTrace();
			throw new ServletException(exe);
		}
	}

}
