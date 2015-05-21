<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id=Input action="InputServlet" method="post">
		<h3>Formulário para inserção de dados no Virtuoso</h3>
		<p>Coloque apenas letras, exemplo: aa, bb, cc</p><br/>
		<label for="sujeito">Sujeito:</label>
		<input type="text" id="sujeito" name="sujeito" value="aa" /> <br/> 
		<label for="predicado">Predicado:</label>
		<input type="text" id="predicado" name="predicado" value="bb" /> <br/> 
		<label for="objeto">Objeto:</label>
		<input type="text" id="objeto" name="objeto" value="cc" /> <br/>  
		<input type="submit" title="Entrar no Sistema" value="Enviar" /> <br/>
		</form>
</body>
</html>