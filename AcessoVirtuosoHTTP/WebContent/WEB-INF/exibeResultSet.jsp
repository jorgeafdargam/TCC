<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="control.ExibeGrafo"%>
<%@ page import="com.hp.hpl.jena.query.ResultSet"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<H1>Selecting Publishers From a Database</H1>
	<% 
           
            ResultSet resultset = new ExibeGrafo.getResults(); ; 
        %>

	<TABLE BORDER="1">
		<TR>
			<TH>sujeito</TH>
			<TH>predicado</TH>
			<TH>objeto</TH>
		</TR>
		<% while(resultset.next()){ %>
		<TR>
			<TD><%= resultset.getString(1) %></td>
			<TD><%= resultset.getString(2) %></TD>
			<TD><%= resultset.getString(3) %></TD>
		</TR>
		<% } %>
	</TABLE>
</body>
</html>