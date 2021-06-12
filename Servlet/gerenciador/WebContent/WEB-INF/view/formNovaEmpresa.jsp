<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/entrada" var="scripletCriaNovaEmpresa"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Nova Empresa</title>
	</head>
	
	<body>
		<c:import url="logout.jsp" />
	
		<form action="${scripletCriaNovaEmpresa}" method="post">
			Nome: <input type="text" name="nome" />
			Data abertura: <input type="text" name="dataAbertura" />
			
			<input type="hidden" name="acao" value="NovaEmpresa">
			<input type="submit">
		</form>
	</body>
</html>