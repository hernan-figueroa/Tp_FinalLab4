<%@page import="java.util.ArrayList"%>
<%@page import="entidades.*"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

</head>

<body>

	<%
		Login log = new Login();
		if (session.getAttribute("NombreUsuario") != null) {
			log = (Login) session.getAttribute("NombreUsuario");
			System.out.println(session.getAttribute("NombreUsuario"));
			if (!log.getAdmin())
				response.sendRedirect("MenuPrincipalUsuario.jsp");
		} else
			response.sendRedirect("Login.jsp");
	%>


	<nav class="navbar navbar-expand-lg bg-light"> <jsp:include
		page="NavBarSupAdmin.html"></jsp:include> <input type="hidden"
		id="usuario" value=<%=log.getUsuario()%>>
	<div class="col-4 text-end">
		<%=log.getUsuario()%>
		<a class="nav-link" href="servletCerrarSesion?CerrarSesion=true">
			Cerrar Sesion</a>
	</div>
	</nav>

	<div class="container">

		<h1>Registrar Administrador</h1>

		<form class="form col-6" action="ServletSuperAdmin" method="post">

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Ingrese nombre de Usuario:</label> <input
					class="form-control" type="text" name="usuario" required>
			</div>
			
			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Mail:</label> <input class="form-control"
					type="email" name="mail" required>
			</div>
			
			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Ingrese contraseña:</label> <input
					class="form-control" type="password" name="password" required>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Ingrese contraseña nuevamente:</label><input
					class="form-control" name="password2" type="password" required>
			</div>

			<div class="d-flex justify-content-between p-1">
				<button class="btn btn-secondary" type="reset" name="btnlimpiar">Limpiar
					campos</button>
				<button class="btn btn-secondary" type="submit" name="btnAceptar">Aceptar</button>
			</div>
			<%
				String mensaje = "";
				if (request.getAttribute("Mensaje") != null) {
					mensaje = request.getAttribute("Mensaje").toString();
				}
			%>
			<div>
				<label><%=mensaje%></label>
			</div>

		</form>


	</div>

	<jsp:include page="Footer.html"></jsp:include>

	<script>
		
	</script>


</body>
</html>