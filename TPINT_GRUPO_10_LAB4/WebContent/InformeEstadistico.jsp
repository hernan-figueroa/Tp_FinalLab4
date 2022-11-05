<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Informe estadistico</h1>
		<form class="form col-6">
			<h2 class="mt-5">Intereses generados</h2>
			<div class="row align-items-end  ">
				<div class="col-auto">
					<label class="col">Desde:</label> <input class="form-control"
						type="date"> <label class="col">
				</div>
				<div class="col-auto">
					<label class="col">Hasta:</label> <input class="form-control"
						type="date">
				</div>
				<div class="col-auto">
					<button class="btn btn-secondary align-items-bottom " type="submit">Aceptar</button>
				</div>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">ID usuario</th>
						<th scope="col">Monto prestado</th>
						<th scope="col">Interes</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>1</td>
						<td>30000</td>
						<td>15000</td>
					</tr>
					<tr>
						<th scope="row">2</th>
						<td>2</td>
						<td>60000</td>
						<td>30000</td>
					</tr>
					<tr>
						<th scope="row">3</th>
						<td>3</td>
						<td>8000</td>
						<td>5000</td>
					</tr>
				</tbody>
			</table>


			<div class="row">
				<div class="col-3">
					<label class="col h6">Total prestado:</label> <input
						class="form-control" value="98000" type="text">
				</div>
				<div class="col-3">
					<label class="col h6">Total intereses:</label> <input
						class="form-control" value="50000" type="text">
				</div>
				<div class="col-3">
					<label class="col h6">Tasa:</label> <input class="form-control"
						value="50%" type="text" readonly>
				</div>
			</div>

		</form>
	</div>
</body>
</html>