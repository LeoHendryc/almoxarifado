<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmação de exclusão</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/estilo.css">
</head>
<body>
	<div class="container">
		<h2>Deseja realmente, remover este produto</h2>

		<div class="alert alert-danger">
			<div>Produto: ${produto.nome}</div>
		</div>

		<form action="/produtos/remover" method="post">

			<div class="mb-3">
				<input type="hidden" name="id" value="${produto.id} }" />
				<div>
					<a class="btn btn-warning" href="/produtos/lista">Não, retornar
						para produtos</a>
					<button type="submit" class="btn btn-danger">Sim, Remover</button>
				</div>
			</div>
		</form>

	</div>

</body>
</html>