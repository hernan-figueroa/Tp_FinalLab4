<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
<h1><b>Realizar transferencia</b></h1>
<br>
<div>
	<label>Ingrese el CBU, Alias o Numero de cuenta bancaria</label>
</div>
<br>
<div>
	<label>CBU/CVU:</label>
	<input type="number"/>
</div>
<br>
<div>
	<label>Alias:</label>
	<input type="text" name="txtAlias"/>
</div>
<br>
<div>
	<label>Cuenta bancaria:</label>
	<select>
		<option>Seleccione tipo de cuenta:</option>
		<option>Caja de ahorro</option>
		<option>Cuenta corriente</option>
	</select>
</div>
<br>
<div>
	<label>Ingrese el numero de cuenta:</label>
	<input type="number"/>
</div>
<br>
<div>
	<input class="btn btn-secondary" type="submit" name="btnVolverAlMenu" value="Volver al menu"> 
	<input class="btn btn-secondary" type="submit" name="btnSiguiente" value="Siguiente"> 
</div>
</body>
</html>