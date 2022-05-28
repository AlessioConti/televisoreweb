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
	<% Televisore input = (Televisore) request.getAttribute("televisorePerPaginaUpdate"); %>
	<form action="ExecuteUpdateTelevisoreServlet" method="post">
		<label for="marcaInputId">MARCA: </label>
		<input type="text" name="marcaInput" id="marcaInputId" value="<%=input.getMarca() %>"><br>
		<label for="modelloInputId">MODELLO: </label>
		<input type="text" name="modelloInput" id="modelloInputId" value="<%=input.getModello() %>"><br>
		<label for="prezzoInputId">PREZZO: </label>
		<input type="number" name="prezzoInput" id="prezzoInputId" value="<%=input.getPrezzo() %>" min="1"><br>
		<label for="numeroPolliciInputId">NUMERO DI POLLICI: </label>
		<input type="number" name="numeroPolliciInput" id="numeroPolliciInputId" value="<%=input.getNumeroPollici()%>" min="1"><br>
		<label for="codiceInputId">CODICE: </label>
		<input type="text" name="codiceInputId" id="codiceInputId" value="<%=input.getCodice() %>"><br>
		
		<input type="hidden" name="idTelevisore" value="<%=input.getId() %>">
		<input type="submit" value="Conferma Modifiche">
			
	</form>
</body>
</html>