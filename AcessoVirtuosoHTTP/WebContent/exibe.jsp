<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.hp.hpl.jena.query.QuerySolution" %>
<%@ page import="com.hp.hpl.jena.query.ResultSet" %>
<%@ page import="com.hp.hpl.jena.rdf.model.RDFNode" %>

<HTML>
    <HEAD>
        <TITLE>Busca Web Semântica</TITLE>
    </HEAD>

    <BODY>
        <H1>Resultado da busca no banco de dados Virtuoso</H1>

        <TABLE BORDER="1">
            <TR>
                <TH>Sujeito</TH>
                <TH>Predicado</TH>
                <TH>Objeto</TH>
            </TR>
            <% 
            ResultSet results = ${param.Results};
            while (results.hasNext()) { 
            QuerySolution rs = results.nextSolution(); 
            %>
            <TR>
                <TD> <%=RDFNode s = rs.get("s") %></td>
                <TD> <%=RDFNode s = rs.get("p") %></TD>
                <TD> <%=RDFNode s = rs.get("o") %></TD>
            </TR>
            <% } %>
        </TABLE>
    </BODY>
</HTML>