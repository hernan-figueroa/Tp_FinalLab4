<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Registrar usuario</h1>
		<form class="form col-6">
			<div class="d-flex justify-content-between p-1">
				<label class="col-6">DNI:</label> <input class="form-control" type=text>
			</div>
			<div class="d-flex justify-content-between p-1">
				<label class="col-6">CUIL:</label> <input class="form-control" type=text>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Nombre:</label> <input class="form-control" type=text>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Apellido:</label> <input class="form-control" type=text>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Sexo:</label>
				<div class="col-6">
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio"
							name="inlineRadioOptions" id="inlineRadio1" value="option1"
							checked> <label class="form-check-label"
							for="inlineRadio1">Masculino</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio"
							name="inlineRadioOptions" id="inlineRadio2" value="option2">
						<label class="form-check-label" for="inlineRadio2">Femenino</label>
					</div>
				</div>
			</div>
			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Tipo de usuario:</label>
				<div class="col-6">
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio"
							name="inlineRadioOptions" id="inlineRadio1" value="option1"
							checked> <label class="form-check-label"
							for="inlineRadio1">Administrador</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio"
							name="inlineRadioOptions" id="inlineRadio2" value="option2">
						<label class="form-check-label" for="inlineRadio2">Cliente</label>
					</div>
				</div>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Nacionalidad:</label>
				<select
					class="form-select">
					<option selected>Seleccione nacionalidad</option>
					<option value="1">Uno</option>
					<option value="2">Dos</option>
					<option value="3">Tres</option>
				</select>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Fecha de nacimiento:</label> <input class="form-control" type="date">
			</div>
			
			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Provincia:</label>
				<select
					class="form-select">
					<option selected>Seleccione provincia</option>
					<option value="1">Uno</option>
					<option value="2">Dos</option>
					<option value="3">Tres</option>
				</select>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Localidad:</label>
				<select
					class="form-select">
					<option selected>Seleccione localidad</option>
					<option value="1">Uno</option>
					<option value="2">Dos</option>
					<option value="3">Tres</option>
				</select>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Mail:</label> <input class="form-control" type="email">
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Ingrese nombre de Usuario:</label> <input class="form-control" type="text">
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Ingrese contraseña:</label> <input class="form-control" type="text">
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Ingrese contraseña nuevamente:</label><input class="form-control" type="text">
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