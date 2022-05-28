<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>INSERISCI I VALORI DEL TELEVISORE</h2>
	<form action="ExecuteInsertTelevisoreServlet" method="post">
		
		<label for="marcaInputId">MARCA: </label>
		<input type="text" name="marcaInput" id="marcaInputId"><br>
		<label for="modelloInputId">MODELLO: </label>
		<input type="text" name="modelloInput" id="modelloInputId"><br>
		<label for="prezzoInputId">PREZZO: </label>
		<input type="number" name="prezzoInput" id="prezzoInputId" min="1"><br>
		<label for="numeroPolliciInputId">NUMERO POLLICI: </label>
		<input type="number" name="numeroPolliciInput" id="numeroPolliciInputId" min="1"><br>
		<label for="codiceInputId">CODICE: </label>
		<input type="text" name="codiceInput" id="codiceInputId"><br>
		<input type="submit" value="Inserisci Televisore">
		
		
	</form>
</body>
</html>