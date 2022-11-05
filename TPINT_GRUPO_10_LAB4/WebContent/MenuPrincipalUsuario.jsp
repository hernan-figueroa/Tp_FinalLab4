<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
<h1><b>Menu principal</b></h1>
<br>
<div> 
	<label>Seleccionar cuenta para ver su información:</label>
	<select>
		<option>Seleccione una cuenta:</option>
		<option></option>
		<option></option>
		<option></option>
		<option></option>
		<option></option>
	</select>
	<br>
	<input class="btn btn-secondary" type="submit" name="btnCuentaSeleccionada" value="Ver historial de cuenta" />
</div>
<br>
<div>
	<input class="btn btn-secondary" type="submit" name="btnTransferencia" value="Realizar transferencia">
</div>
<br>
<div>
	<input class="btn btn-secondary" type="submit" name="btnSolicitarPrestamo" value="Solicitar prestamo"> 
</div>
<br>
<div>
	<input class="btn btn-secondary" type="submit" name="btnPagarPrestamo" value="Pagar prestamo"> 
</div>
<br>
<div>
	<label>Ver perfil:</label>
	<a href="VerPerfil.jsp">información personal</a>
</div>
</body>
</html>