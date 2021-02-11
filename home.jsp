<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.ResultSet" %>


<html>
	<body>
		<table border="1">
			
			<th>&nbsp; Emp Id &nbsp;</th>
			<th>&nbsp; Emp Name &nbsp;</th>
		<%
			ResultSet rs = (ResultSet) request.getAttribute("rs");
			
			while(rs.next())
			{ 
		%>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;<%= rs.getInt("eid")%> &nbsp;</td> 
					<td>&nbsp; <%= rs.getString("ename")%> &nbsp;</td>
				</tr>	
		<% 
			}	
		%>	
			
		<a href="empAdd.jsp"><button>Add</button></a>
		<a href="empUpdate.jsp"><button>Update</button></a>
		<a href="empDelete.jsp"><button>Delete</button></a>
							
	</body>
	
</html>