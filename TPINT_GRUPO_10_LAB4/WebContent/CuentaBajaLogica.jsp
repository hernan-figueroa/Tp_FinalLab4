<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="entidades.Cuenta"%>
<%@page import="entidades.Cliente"%>
<%@page import="entidades.*"%>
<%@page import="negocioImpl.AdminNegocioImpl"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Baja lógica cuenta</title>

<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" type="text/css" href="Styles.css">
<script src="js/jquery-3.4.1.js"></script>
<script src="js/popper.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">

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

		<form action="servletBajaCuenta" method="get">

			<div id="BuscarUsuario" style="">
				<h1>Ingrese ID cliente y Numero de cuenta a eliminar:</h1> <br>
				<label>ID cliente:</label> <input type="text"
					name="txtIDClienteCuenta" required
					style="margin: 10px 0 0 0; border-radius: 0.1rem;"> <br>
				<label>N° Cuenta:</label> <input type="text" name="txtNumeroCuenta" required
					style="margin: 10px 0 0 0; border-radius: 0.1rem;"> <br>
				<input class="btn btn-secondary" type="submit"
					name="btnListarCuenta" value="Aceptar"
					style="height: 40px; margin: 0 0 10px 0">
			</div>
		</form>

		<form action="servletBajaCuenta" method="get">
			<div >

				<h1>Datos de la cuenta</h1>
				<br>
				<%
					Cuenta cu = new Cuenta();
					Cliente cli = new Cliente();
					String descrip = null;
					if (request.getAttribute("CuentaListada") != null) {
						cu = (Cuenta) request.getAttribute("CuentaListada");
					}
					if (request.getAttribute("ClienteListado") != null) {
						cli = (Cliente) request.getAttribute("ClienteListado");
					}
				%>

				<div class="row">
					<div class="col-4 p-2">
						<label class="">ID Cliente:</label>
					</div>
					<div class="col-4">
						<label class=""
							style="background-color: lightblue; width: 250px; border-radius: 10px; text-align: center;"><%=cu.getId_cliente()%></label>

						<input type="hidden" value="<%=cu.getId_cliente()%>"
							name="IDEliminarCuenta">
					</div>
				</div>

				<div class="row">
					<div class="col-4 p-2">
						<label class="">Nombre:</label>
					</div>
					<div class="col-4">
						<label class=""
							style="background-color: lightblue; width: 250px; border-radius: 10px; text-align: center;"><%=cli.getNombre()%></label>
					</div>
				</div>

				<div class="row">
					<div class="col-4 p-2">
						<label class="">Apellido:</label>
					</div>
					<div class="col-4">
						<label class=""
							style="background-color: lightblue; width: 250px; border-radius: 10px; text-align: center;"><%=cli.getApellido()%></label>
					</div>
				</div>

				<div class="row">
					<div class="col-4 p-2">
						<label class="">Número de cuenta</label>
					</div>
					<div class="col-4">
						<label class=""
							style="background-color: lightblue; width: 250px; border-radius: 10px; text-align: center;"><%=cu.getNumeroCuenta()%></label>
						<input type="hidden" value="<%=cu.getNumeroCuenta()%>"
							name="NumCuentaEliminar">
					</div>
				</div>

				<div class="row">
					<div class="col-4 p-2">
						<label class="">Tipo de cuenta:</label>
					</div>
					<div class="col-4">
						<label class=""
							style="background-color: lightblue; width: 250px; border-radius: 10px; text-align: center;"><%=cu.getTipoCuenta()%></label>
					</div>
				</div>

				<div class="row">
					<div class="col-4 p-2">
						<label class="">CBU:</label>
					</div>
					<div class="col-4">
						<label class=""
							style="background-color: lightblue; width: 250px; border-radius: 10px; text-align: center;"><%=cu.getCbu()%></label>
					</div>
				</div>

<% if(cli.getId()!=null){%>
				<div class="row">
					<div class="col-6">
						<div style="text-align: center">
							<input class="btn btn-success" type="submit"
								id="btnConfirmarBajaCuenta" name="confirmarBajaCuenta"
								value="Eliminar" style="margin: 50px 0 30px 0">
						</div>
					</div>
				</div>
<% }%>
				<%
					String mensaje = "";
					if (request.getAttribute("CuentaBorrada") != null) {
						boolean estado = (boolean) request.getAttribute("CuentaBorrada");

						if (estado == false) {
							mensaje = "No se pudo eliminar la cuenta";
						} else {
							mensaje = "Cuenta eliminada";
						}
					}
				%>

				<div class="row">
					<div class="col-4 p-2">
						<label class=""><%=mensaje%></label>
					</div>

				</div>
		</form>
		
	</div>
	<jsp:include page="Footer.html"></jsp:include>
</body>
</html>