<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Produto</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="/css/estilo.css">
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<h2 class="text-primary text-center mt-3">Cadastro de Produto</h2>
	
	
	<form action="/produto/novo" method="post"> 

			<div class="conteudo-form">
				<label class="form-label">Nome:</label>
				<input type="text" name="nome" class="form-control" maxlength="30" />
				
				<label class="form-label">Tipo id:</label>
				<input type="text" name="tipoIdd" class="form-control" maxlength="30" />

				<label class="form-label">tipo_id:</label>
				<input type="text" name="tipo_id" class="form-control" maxlength="30" />
				
			</div>
			
			<div class="text-center mt-3">
				<button type="submit" class="btn btn-primary">Incluir</button>
				<a href="/produto/lista" class="btn btn-secondary">Voltar para a lista</a>	
			</div>

		</form>
	 

</body>
</html>