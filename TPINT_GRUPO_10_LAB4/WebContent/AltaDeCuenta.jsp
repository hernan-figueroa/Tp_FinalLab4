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
		<h1>Generar Alta de cuenta</h1>
		<form class="form col-6">
			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Numero de cuenta:</label> <input
					class="form-control" type=text>
			</div>
			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Tipo de cuenta:</label>
				<select
					class="form-select">
					<option selected>Seleccione tipo</option>
					<option value="1">Uno</option>
					<option value="2">Dos</option>
					<option value="3">Tres</option>
				</select>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Monto asignado:</label> <input
					class="form-control" type="text">
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Id Cliente:</label> <input class="form-control"
					type=text>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Fecha de alta:</label> <input
					class="form-control" type="date">
			</div>

			<div class="d-flex justify-content-between p-1">
				<button class="btn btn-secondary" type="reset">Limpiar
					campos</button>
				<button class="btn btn-secondary" type="submit">Aceptar</button>
			</div>


		</form>
	</div>
</body>
</html>