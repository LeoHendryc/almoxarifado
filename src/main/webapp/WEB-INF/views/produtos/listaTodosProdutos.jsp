<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Produtos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/estilo.css">

</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	
	
	<div class="container">

	<h2 class="text-primary text-center mt-3">Listar todos os produtos com a Unidade</h2>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>PRODUTO</th>
				<th>UNIDADE</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="prod" items="${todos_produtos}">
			<tr>
				<td>${prod.idProduto}</td>
				<td>${prod.nome}</td>
				<td>${prod.siglaUnidade}</td>
			</tr>
				
			</c:forEach>
			
		</tbody>
		
		</table>
		
	</div>
	
	<div class="text-center">
		<a href="/" class="btn btn-warning">Voltar</a>
		<a href="/api/produtos/" target="_blank" class="btn btn-info">API Produtos</a>
	</div>
	
</body>
</html>