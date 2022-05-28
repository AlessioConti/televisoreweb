<%@page import="it.prova.televisoreweb.model.Televisore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% Televisore result = (Televisore) request.getAttribute("televisoreDaInviareAPaginaDettaglio"); %>
	<p>Marca: <%= result.getMarca() %></p>
	<p>Modello: <%= result.getModello() %></p>
	<p>Prezzo: <%= result.getPrezzo() %></p>
	<p>Numero Pollici: <%= result.getNumeroPollici() %></p>
	<p>Codice: <%= result.getCodice() %></p>
	
	<a href="searchForm.jsp">Torna alla Home</a>
</body>
</html>