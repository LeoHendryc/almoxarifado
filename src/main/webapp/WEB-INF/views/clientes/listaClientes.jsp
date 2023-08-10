<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="estilo.css">
<title>Lista de Clientes</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.margem-botao {
	margin-top: 10px;
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!-- Acesso a biblioteca de tags -->
	<div class="container">
		<h2 class="text-primary text-center">Lista de Clientes</h2>

		<div class="margem-botao">
			<a href="/clientes/novo" class="btn btn-primary">Novo Cliente</a>
		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>CPF</th>
					<th>NOME</th>
					<th>EMAIL</th>
					<th>TELEFONE</th>
					<th></th>
					

				</tr>
			</thead>
			<tbody>

				<c:forEach var="cliente" items="${listagem_clientes}">
					<tr>
						<td>${cliente.cpf}</td>
						<td>${cliente.nome}</td>
						<td>${cliente.email}</td>
						<td>${cliente.telefone}</td>
						<td>
							<a class="btn btn-warning btn-sm" href="/clientes/alterar/${cliente.cpf}"> Alterar </a>
							<a class="btn btn-danger btn-sm" href="/clientes/remover/${cliente.cpf}">Remover</a>
							<a class="btn btn-info btn-sm" href="/pedidos/lista/${cliente.cpf}">Ver Pedidos</a>
						
						</td>
											
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>

</body>
</html>