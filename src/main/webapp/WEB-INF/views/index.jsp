<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>E-Commerce Cap</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="estilo.css">
<style>
	button {
		background-color: #008CBA;
		color: white;
		border: none;
		border-radius: 0.3rem;
		width: 15rem;
		height: 3rem;
		margin-bottom: 0.3rem;
	}
	.listLinks {
		display: flex;
		flex-direction: column;
		
	}
</style>
</head>
<body>
	<!-- <h1>Exemplo Spring Boot</h1> -->

	<div class="container">
		<h1 class="text-center">Cap-Commerce (O E-commerce da Capgemini)</h1>
		<h2 class="text-primary text-center">Get the products you want!</h2>

		<span>Escolha uma opção</span>

		<ul>
			<li><a href="/clientes/novo">Gestão de Clientes</a></li>
			<li><a href="/clientes/lista">Lista de Clientes</a></li>
			<li><a href="/pedidos/novo">Pedidos</a></li>
			<li><a href="/api/clientes/">Api Clientes</a></li>
			<li><a href="/api/clientes/todos/">Api Todos Clientes e Pedidos</a></li>
		</ul>
	<hr>
		<ul class="listLinks">
			<a href="/clientes/novo"><button>Gestão de Clientes</button></a>
			<a href="/clientes/lista"><button>Lista de Clientes</button></a>
			<a href="/pedidos/novo"><button>Pedidos</button></a>
			<a href="/api/clientes/"><button>Api Clientes</button></a>
			<a href="/api/clientes/todos/"><button>Api Todos Clientes e Pedidos</button></a>
		</ul>
			
		
		
			

	</div>
</body>
</html>