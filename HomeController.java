package com.nt.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.Dao.CRUDDao;
import com.nt.Dao.CRUDDaoImpl;
import com.nt.Pojo.Emp;

public class HomeController extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		RequestDispatcher rd;
		String op = request.getParameter("op");
		CRUDDao dao = new CRUDDaoImpl();  
		//ResultSet rs;
		
		int flag=0;
		
		if(op.equals("add"))
		{
			int eid = Integer.parseInt(request.getParameter("eid"));
			String ename = request.getParameter("ename");
			Emp e = new Emp();
			e.setId(eid);
			e.setName(ename);
			flag = dao.create(e);
			
			if(op.equals("add"))
			{
				if(flag==1)
					out.println("Record created successfully !");
				else
					out.println("Record not created !");	
			}
			out.print("<a href='empAdd?op=empRead'>Home</a>");
		}
		else if(op.equals("update"))
		{
			int eid = Integer.parseInt(request.getParameter("eid").trim());
			String ename = request.getParameter("ename").trim();
			Emp e = new Emp();
			e.setId(eid);
			e.setName(ename);
			flag = dao.update(e);
			
			if(flag!=0)
				out.println("Record updated successfully !");
			else
				out.println("Record not updated !");	
			
			out.print("<a href='empAdd?op=empRead'>Home</a>");
		}
		else if(op.equals("delete"))
		{
			int eid = Integer.parseInt(request.getParameter("eid").trim());
			Emp e = new Emp();
			e.setId(eid);
			flag = dao.delete(e);
			
			if(flag!=0)
				out.println("Record deleted successfully !");
			else
				out.println("Record not deleted !");	
			
			
			out.print("<a href='empAdd?op=empRead'>Home</a>");
		}
		else if(op.equals("empRead"))
		{
			ResultSet rs = dao.read();
			request.setAttribute("rs",rs);
			rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
		else
		{
			out.print("invalid option ...");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request,response);
	}

}
