<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pago prestamo</title>
</head>
<body>
<h1> Pago prestamo</h1><br>
<label style="position:absolute; left: 50px;">Cuota a pagar</label>
	<select style="position:absolute; left: 250px; width:175px">
		<option></option>
		<option></option>
		<option></option>
		<option></option>
		<option></option>
		<option></option>
	</select>
<br><br>
<label style="position:absolute; left: 50px;">Cuenta a utilizar:</label>
	<select style="position:absolute; left: 250px; width:175px">
		<option></option>
		<option></option>		
	</select>
<br><br>
<label style="position:absolute; left: 50px;">Importe a pagar:</label> <label style="position:absolute; left: 250px; width:175px"> importe </label>
<br><br>
<label style="position:absolute; left: 50px;">Fecha de pago</label>
<input style="position:absolute; left: 250px; width:175px" type="date">
<br>
<br>
<input style="position:absolute; left: 50px; width:175px" type="submit" value="Aceptar" name="btnAceptar">

<input style="position:absolute; left: 250px; width:175px" type="submit" value="Volver al inicio" name="btnVolverInicio">
</body>
</html>