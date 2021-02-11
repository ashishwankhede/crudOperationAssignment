package com.nt.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.Dao.CRUDDao;
import com.nt.Dao.CRUDDaoImpl;

//@WebServlet("/home")
public class LoginController extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		RequestDispatcher rd=null;
		CRUDDao dao = new CRUDDaoImpl();  
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("ashish") && password.equals("ashish"))
		{
			ResultSet rs = dao.read();
			request.setAttribute("rs",rs);
			rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
		else
		{
			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request,response);
	}

}
