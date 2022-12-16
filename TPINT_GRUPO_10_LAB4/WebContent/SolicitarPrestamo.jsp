<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<%
			Login log = new Login();
			if (session.getAttribute("NombreUsuario") != null) {
				log = (Login) session.getAttribute("NombreUsuario");
				System.out.println(session.getAttribute("NombreUsuario"));
				if (log.getAdmin())
					response.sendRedirect("Login.jsp");
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
		<h1>Solicitar prestamo</h1>
		<br>

		<form method="get" action="ServletSolicitarPrestamo">
			<input type="hidden" value=<%=log.getUsuario()%> name="LoginPrestamo">
			<br> <br> <label>Importe solicitado</label> <input
				type="number" min="1" name="txtImporte" required> <br> <br>
			<label>Cantidad de cuotas</label> <select name="ddlCuotas"
				required>
				<option value="1">1</option>
				<option value="3">3</option>
				<option value="6">6</option>
				<option value="12">12</option>
				<option value="18">18</option>
				<option value="24">24</option>
			</select> <br> <br>


			<%
				Prestamo prest = new Prestamo();

				if (request.getAttribute("PrestamoPrimero") != null) {
					prest = (Prestamo) request.getAttribute("PrestamoPrimero");
				}
			%>
			<input type="hidden" name="NumeroDeCuentaPrestamo1"
				value=<%=prest.getNroCuenta()%>> <input type="hidden"
				name="CBUPrestamo1" value=<%=prest.getCbu()%>> <input
				type="hidden" name="IDClientePrestamo1"
				value=<%=prest.getIdCliente()%>> <input type="hidden"
				name="FechaInicio1" value=<%=prest.getFechaInicio()%>> <input
				class="btn btn-secondary" type="submit" value="Solicitar" name="btnConfirmarSolicitud">
			<br> <br> <label>(Aclaracion: el banco pronto
				autorizara o rechazara su prestamo)</label> <br> <br> 
		</form>


	</div>
</body>
</html>