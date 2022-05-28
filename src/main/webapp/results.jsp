<%@page import="it.prova.televisoreweb.model.Televisore"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	table, th, td {
	  border: 1px solid black;
	}
	
	th, td {
	  padding: 10px;
	}
	.center {
		margin-left: auto;
		margin-right: auto;
	}
</style>
</head>
<body>
	<table class="center">
		<thead>
			<tr>
				<th>Marca</th>
				<th>Modello</th>
				<th>Azione</th>
			</tr>
		</thead>
		
		<% List<Televisore> listaDaServlet = (List<Televisore>)request.getAttribute("listTelevisoriAttributeName");
							for(Televisore televisoreItem : listaDaServlet){
				%>
				<tr>
					<td><%=televisoreItem.getMarca() %></td>
					<td><%=televisoreItem.getModello() %></td>
					<td>
						<a href="ExecuteShowTelevisoreServlet?idDaInviareComeParametro=<%=televisoreItem.getId() %>">Dettaglio</a>
						<a href="PrepareUpdateTelevisoreServlet?idDaInviareComeParametro=<%=televisoreItem.getId() %>">Modifica</a>
						<a href="PrepareDeleteTelevisoreServlet?idDaInviareComeParametro=<%=televisoreItem.getId() %>">Elimina</a>
					</td>
				</tr>
		<%	}%>
	
	</table>
	
	<form action="PrepareInsertTelevisoreServlet">
	<input type="submit" value="Aggiungi un nuovo Televisore">
	</form>
	
</body>
</html>