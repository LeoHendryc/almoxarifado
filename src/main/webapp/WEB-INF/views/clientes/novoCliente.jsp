<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Clientes</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	background-color: #f1f1f1;
}

.container{
	height: 100vh;
	display: flex;
	flex-direction: column;
	justify-content: center;
}

.margem-botao {
	margin-top: 10px;
	margin-bottom: 10px;
}

.borda {
	margin: auto;
	max-width: 400px;
}
</style>
<link rel="stylesheet" href="estilo.css">
</head>
<body>
	<div class="container borda">
		<h2 class="text-primary text-center">Cadastro de Clientes</h2>
		<form action="/clientes/novo" method="post"> 

			<div class="mb-3">
				<label class="form-label">CPF:</label> <input type="text" name="cpf"
					class="form-control" maxlength="11" />
			</div>

			<div class="mb-3">
				<label class="form-label">Nome:</label> <input type="text"
					name="nome" class="form-control" />
			</div>

			<div class="mb-3">
				<label class="form-label">Email:</label> <input type="text"
					name="email" class="form-control" />
			</div>

			<div class="mb-3">
				<label class="form-label">Telefone:</label> <input type="text"
					name="telefone" class="form-control" />
			</div>
			
			<div class="text-center">
				<button type="submit" class="btn btn-primary">Incluir</button>
				<a href="/clientes/lista" class="btn btn-secondary">Voltar para a lista</a>	
			</div>

		</form>

	</div>

</body>
</html>