<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produtos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div class="container">
		<h2 class="text-primary text-center">LISTA DE PRODUTOS</h2>
		<a href="/produto/novo" class="btn btn-primary">Nova Entrada</a>


		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>PRODUTO</th>
					<th>TIPO ID</th>
					<th></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="produto" items="${listagem_produtos}">
					<tr>
						<td>${produto.id}</td>
						<td>${produto.nome}</td>
						<td>${produto.tipoId}</td>
						

					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
	
</body>
</html>