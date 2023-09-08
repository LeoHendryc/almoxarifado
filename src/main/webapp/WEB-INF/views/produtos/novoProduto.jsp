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
	
	
	<form action="/produtos/novo" method="post"> 
			<div class="conteudo-form">

				<label class="form-label">Nome Produto:</label>
				<input type="text" name="nome" class="form-control" maxlength="30" />
				
				<label class="form-label">Unidade:</label>
				<input type="text" name="unidade" class="form-control" maxlength="30" />
			</div>
			
			<div class="text-center mt-3">
				<button type="submit" class="btn btn-primary">Incluir</button>
				<a href="/produtos/lista" class="btn btn-secondary">Voltar para a lista</a>	
			</div>

		</form>
	 

</body>
</html>