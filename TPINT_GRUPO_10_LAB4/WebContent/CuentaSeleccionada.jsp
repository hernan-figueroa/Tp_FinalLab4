<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
<b><h1>Información de cuenta seleccionada</h1></b>
<div>
	<label>Tipo de cuenta seleccionada:</label>
	<label>(caja de ahorro, cuenta corriente)</label>
</div>
<br>
<div>
	<label>Saldo de la cuenta:</label>
	<label>(saldo)</label>
</div>
<br>
<div>
	<label>Historial de movimientos:</label>
	<br>
	<table border="1" class="table table-striped">
		<tr>
			<td><b>FECHA OPERACIÓN</b></td>
			<td><b>CONCEPTO</b></td>
			<td><b>IMPORTE</b></td>
			<td><b>FECHA VALOR</b></td>
			<td><b>SALDO</b></td>
		</tr>

		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
</div>
<br>
<div>
	<input class="btn btn-secondary" type="submit" name="btnVolverAlInicio" value="Menu principal"> 
</div>
</body>
</html>