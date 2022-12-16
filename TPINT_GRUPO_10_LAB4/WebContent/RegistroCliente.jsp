<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Login"%>
<%@page import="entidades.Admin"%>
	<%@page import="negocioImpl.AdminNegocioImpl"%>
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
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</head>
<body onload="ddl()">

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


	<% 
	AdminNegocioImpl adminNeg = new AdminNegocioImpl();
    Admin admin = new Admin();
	admin = adminNeg.buscarSuperAdmin(log.getUsuario());
 	  if(admin.isSuperAdmin()){%>
 	  
    <nav class="navbar navbar-expand-lg bg-light"> <jsp:include
		page="NavBarSupAdmin.html"></jsp:include> <input type="hidden"
		id="usuario" value=<%=log.getUsuario()%>>
	<div class="col-4 text-end">
		<%=log.getUsuario()%>
		<a class="nav-link" href="servletCerrarSesion?CerrarSesion=true">
			Cerrar Sesion</a>
			</div>
			</nav>

    <%} else {
	 %>
	<nav class="navbar navbar-expand-lg bg-light"> <jsp:include
		page="NavBarAdmin.html"></jsp:include> <input type="hidden"
		id="usuario" value=<%=log.getUsuario()%>>
	<div class="col-4 text-end">
		<%=log.getUsuario()%>
		<a class="nav-link" href="servletCerrarSesion?CerrarSesion=true">
			Cerrar Sesion</a>
	</div>
	</nav>
	<% } %>


	<div class="container">
		<h1>Registrar Cliente</h1>
		<form class="form col-6" action="ServletRegistrarCliente"
			method="post">
			<div class="d-flex justify-content-between p-1">
				<label class="col-6">DNI:</label> <input class="form-control"
					name="dni" type=number required>
			</div>
			<div class="d-flex justify-content-between p-1">
				<label class="col-6">CUIL:</label> <input class="form-control"
					name="cuil" type=number required>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Nombre:</label> <input class="form-control"
					name="nombre" type=text required>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Apellido:</label> <input class="form-control"
					name="apellido" type=text required>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Sexo:</label>
				<div class="col-6">
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="sexo"
							id="inlineRadio1" value="Masculino" checked> <label
							class="form-check-label" for="inlineRadio1">Masculino</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="sexo"
							id="inlineRadio2" value="Femenino"> <label
							class="form-check-label" for="inlineRadio2">Femenino</label>
					</div>
				</div>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Nacionalidad:</label>
				<div id="nacionalidades" class="col-6" required></div>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Fecha de nacimiento:</label> <input
					class="form-control" type="date" name="fechaNacimiento" required>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Provincia:</label>
				<div id="provincias" class="col-6" required></div>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Localidad:</label>
				<div id="localidades" class="col-6" required></div>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Mail:</label> <input class="form-control"
					type="email" name="mail" required>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Direccion:</label> <input class="form-control"
					type="text" name="direccion" required>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Ingrese nombre de Usuario:</label> <input
					class="form-control" type="text" name="usuario" required>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Ingrese contraseña:</label> <input
					class="form-control" type="password" name="password" required>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Ingrese contraseña nuevamente:</label><input
					class="form-control" type="password" required>
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


	<script>
		function ddl() {
			function buscarLocalidades() {
				$.ajax({
					url : "servletListarLocalidades",
					success : function(result) {
						$("#localidades").html(result);
					}
				});
			}
			function buscarProvincias() {
				$.ajax({
					url : "ServletListarProvincias",
					success : function(result) {
						$("#provincias").html(result);
					}
				});
			}

			function buscarNacionalides() {
				$.ajax({
					url : "ServletListarNacionalidad",
					success : function(result) {
						$("#nacionalidades").html(result);
					}
				});
			}
			buscarProvincias();
			buscarLocalidades();
			buscarNacionalides();
		}
	</script>
	<jsp:include page="Footer.html"></jsp:include>
</body>
</html>