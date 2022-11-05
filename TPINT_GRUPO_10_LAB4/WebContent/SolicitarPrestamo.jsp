<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Solicitar prestamo</title>
</head>
<body>
<h1> Solicitar prestamo</h1><br>
<label style="position:absolute; left: 50px;">Importe solicitado</label> <input style="position:absolute; left: 250px; width:175px" type="number">
<br><br>
<label style="position:absolute; left: 50px;">Cantidad de cuotas</label>
	<select style="position:absolute; left: 250px; width:175px">
		<option>6</option>
		<option>12</option>
		<option>18</option>
		<option>24</option>
		<option>30</option>
		<option>36</option>
	</select>
<br><br>
<label style="position:absolute; left: 50px;">Cuenta a ser depositado:</label><br><br>
<label style="position:absolute; left: 50px;"> Tipo de cuenta:</label>
	<select style="position:absolute; left: 250px; width:175px">
		<option>Caja de ahorro</option>
		<option>Cuenta corriente</option>		
	</select>
<br><br>
<label style="position:absolute; left: 50px;">CBU:</label><input style="position:absolute; left: 250px; width:175px" type="number">
<br><br>

<input style="position:absolute; left: 125px; width:175px" type="submit" value="Solicitar prestamo" name="btnSolicitarPrestamo">
<br><br>
<label style="position:absolute; left: 50px;">(Aclaracion: el banco pronto autorizara o rechazara su prestamo)</label>
<br><br>
<input style="position:absolute; left: 125px; width:175px" type="submit" value="Volver al inicio" name="btnVolverInicio">
</body>
</html>