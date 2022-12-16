<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Login"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<title>Pago prestamo</title>
</head>
<body>
<div class="container">
<%
	Login log = new Login();
	if (session.getAttribute("NombreUsuario") != null) {
				log = (Login) session.getAttribute("NombreUsuario");
				System.out.println(session.getAttribute("NombreUsuario"));
				if (log.getAdmin())
					response.sendRedirect("InformeEstadistico.jsp");
			} else
				response.sendRedirect("Login.jsp");
	 %>
	 		
	
	<nav class="navbar navbar-expand-lg bg-light"> <jsp:include
			page="NavBarCliente.html"></jsp:include> <input type="hidden"
			id="usuario" value=<%=log.getUsuario()%>>
		<div class="col-4 text-end">
			<%=log.getUsuario()%>
			<a class="nav-link" href="servletCerrarSesion?CerrarSesion=true">
				Cerrar Sesion</a>
		</div>
		</nav>
	<h1>Pago prestamo</h1>
	<br>
	<label >Cuota a pagar</label>
	<select >
		<option></option>
		<option></option>
		<option></option>
		<option></option>
		<option></option>
		<option></option>
	</select>
	<br>
	<br>
	<label >Cuenta a
		utilizar:</label>
	<select >
		<option></option>
		<option></option>
	</select>
	<br>
	<br>
	<label ">Importe a pagar:</label>
	<label >
		importe </label>
	<br>
	<br>
	<label >Fecha de pago</label>
	<input 
		type="date">
	<br>
	<br>
	<input 
		type="submit" value="Aceptar" name="btnAceptar">

	<input 
		type="submit" value="Volver al inicio" name="btnVolverInicio">
	<jsp:include page="Footer.html"></jsp:include>
	</div>
</body>
</html>