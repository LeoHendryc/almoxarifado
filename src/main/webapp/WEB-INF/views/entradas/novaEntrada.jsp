<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Entrada</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/estilo.css">
</head>
<body>
	<h2 class="text-primary text-center mt-3">Cadastro de Entrada</h2>

	<div class="conteudo-form">
		<form action="/entrada/novo" method="post">
			
			<label class="form-label">Data</label>
			<input type="Date" name="dataEntrada" class="form-control" maxlength="30" />
			
			<label class="form-label">Nome do Produto</label>
			<input type="text" name="produto" class="form-control" maxlength="30" />
			
			<label class="form-label">Quantidade</label>
			<input type="text" name="quantidade" class="form-control" maxlength="30" />
				
			

			<div class="text-center mt-3">
				<button type="submit" class="btn btn-primary">Incluir</button>
				<a href="/entrada/lista" class="btn btn-secondary">Voltar para a lista</a>
			</div>

		</form>
	</div>
</body>
</html>