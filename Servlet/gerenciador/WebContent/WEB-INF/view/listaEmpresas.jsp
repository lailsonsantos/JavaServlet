<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.gerenciador.modelo.Empresa" %>
<%@ page import="java.util.List, br.com.gerenciador.modelo.Usuario" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/entrada?acao=" var="scripletMostraEmpresa"/>
<c:url value="/entrada?acao=" var="scripletRemoveEmpresa"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		<c:import url="logout.jsp" />
	
		<p/>Usuario logado: ${usuarioLogado.login}
		<p/>Lista de empresas:
	
		<ul>
			<c:forEach items="${empresas}" var="empresa">
				<li>${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/> 
					<a href="${scripletMostraEmpresa}MostraEmpresa&id=${empresa.id}">editar</a>
					<a href="${scripletRemoveEmpresa}RemoveEmpresa&id=${empresa.id}">remover</a>
				</li>
			</c:forEach>
		</ul>
	</body>
</html>