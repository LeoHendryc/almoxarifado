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
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<h2 class="text-primary text-center">Cadastro de Produto</h2>
	
	<form action="/produto/novo" method="post"> 

			<div class="mb-3">
				<label class="form-label">Nome:</label>
				<input type="text" name="nome" class="form-control" maxlength="11" />
			</div>
			
			<div class="text-center">
				<button type="submit" class="btn btn-primary">Incluir</button>
				<a href="/clientes/lista" class="btn btn-secondary">Voltar para a lista</a>	
			</div>

		</form>
	

</body>
</html>