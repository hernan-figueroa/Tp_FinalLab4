<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Cliente"%>
<%@page import="entidades.Login"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Admin"%>
	<%@page import="negocioImpl.AdminNegocioImpl"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clientes</title>
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<title>Modificar Usuario</title>

<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" type="text/css" href="Styles.css">
<script src="js/jquery-3.4.1.js"></script>
<script src="js/popper.min.js"></script>
<script src="bootstrap-4.3.1/js/bootstrap.min.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.js"></script>

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
	if (request.getAttribute("clientes") == null)
		response.sendRedirect("servletCliente?ListarClientes=true");
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
	<div class="">
		<!-- TABLA -->
		<table id="TablaClientes" class="table-responsive table-bordered"
			style="display: inline-table; background-color: white; overflow: scroll">
			<thead>
				<tr class="table table-bordered" style="text-align: center">
					<th>ID de Cliente</th>
					<th>DNI</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Estado</th>
					<th>Modificar</th>
				</tr>
			</thead>

			<%
				if (request.getAttribute("clientes") != null) {
					ArrayList<Cliente> listaCliente = (ArrayList<Cliente>) request.getAttribute("clientes");
					if (listaCliente != null)
						for (Cliente cliente : listaCliente) {
			%>
			<tr class="table-bordered "
				style="color: black !important; background-color: white; font-size: 0.9rem; text-align: center">
				<td><label><%=cliente.getId()%></label></td>
				<td><label><%=cliente.getDni()%></label></td>
				<td><label><%=cliente.getNombre()%></label></td>
				<td><label><%=cliente.getApellido()%></label></td>
				<td><%!String Estado = "";%> <%
 	if (cliente.isEstado())
 					Estado = "true";
 				else
 					Estado = "false";
 %> <label> <%=Estado%></label></td>
				<td><a
					href="servletModificarUsuario?txtFiltro=<%=cliente.getId()%>">Modificar</a>
					<a
					href="servletBajaCliente?txtDNIClienteListar=<%=cliente.getId()%>">Alta/Baja
						Logica</a></td>
			</tr>
			<%
				}
				}
			%>
		</table>

	</div>
	<jsp:include page="Footer.html"></jsp:include>
	<!-- TABLA -->
	<script>
		$(document)
				.ready(
						function() {
							$('#TablaClientes')
									.DataTable(
											{

												"language" : {
													"processing" : "Procesando...",
													"lengthMenu" : "Mostrar _MENU_ registros",
													"zeroRecords" : "No se encontraron resultados",
													"info" : "",
													"emptyTable" : "Ningún dato disponible en esta tabla",
													"infoEmpty" : "Mostrando registros del 0 al 0 de un total de 0 registros",
													"infoFiltered" : "(filtrado de un total de _MAX_ registros)",
													"search" : "Buscar:",
													"infoThousands" : ",",
													"loadingRecords" : "Cargando...",
													"paginate" : {
														"first" : "Primero",
														"last" : "Último",
														"next" : "  Siguiente",
														"previous" : "Anterior  "
													},
												}

											});
						});
	</script>
</body>
</html>