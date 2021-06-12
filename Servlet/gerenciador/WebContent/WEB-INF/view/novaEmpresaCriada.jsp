<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Empresas Criadas</title>
	</head>
	
	<body>
		<c:if test="${not empty empresas}">
			Empresa ${empresas} criada com sucesso!
		</c:if>
		
		<c:if test="${empty empresas}">
			Nenhuma empresas cadastrada!
		</c:if>
	</body>
</html>