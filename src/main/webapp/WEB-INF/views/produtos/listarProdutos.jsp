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
	<link rel="stylesheet" type="text/css" href="/css/estilo.css">
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div class="container">
		<h2 class="text-primary text-center">LISTA DE PRODUTOS</h2>
		<a href="/produtos/novo" class="btn btn-primary">Novo Produto</a>


		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>PRODUTO</th>
					<th>UNIDADE</th>
					<th></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="produto" items="${listagem_produtos}">
					<tr>
						<td>${produto.id}</td>
						<td>${produto.nome}</td>
						<td>${produto.unidade.sigla.toUpperCase()}</td>
						
						<td>
							<a class="btn btn-warning btn-sm" href="/produtos/alterar">Editar</a>
							<a class="btn btn-danger btn-sm" href="/produtos/remover/${produto.id}">Excluir</a>
						</td>
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