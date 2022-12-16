<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="entidades.Cliente"%>
<%@page import="entidades.Login"%>
<%@page import="entidades.Admin"%>
<%@page import="negocioImpl.AdminNegocioImpl"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Baja lógica usuario</title>

<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" type="text/css" href="Styles.css">
<script src="js/jquery-3.4.1.js"></script>
<script src="js/popper.min.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">

</head>

</head>

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


		<%
			Cliente cli = new Cliente();
			if (request.getAttribute("ClienteListado") != null) {
				cli = (Cliente) request.getAttribute("ClienteListado");
			}

			if (cli.isEstado()) {
		%>

		<h1>Baja cliente</h1>
		<%
			} else
		%>
		<h1>Alta cliente</h1>
		<form action="servletBajaCliente" id="formCliente" method="post">

			<div style="width: 70%; height: 100%; margin-left: 10px">
				<br>


				<div class="row">
					<div class="col-4 p-2">
						<label class="">NOMBRE:</label>
					</div>
					<div class="col-4">
						<label class=""
							style="background-color: lightblue; width: 250px; border-radius: 10px; text-align: center;"><%=cli.getNombre()%></label>
					</div>
				</div>

				<div class="row">
					<div class="col-4 p-2">
						<label class="">APELLIDO:</label>
					</div>
					<div class="col-4">
						<label class=""
							style="background-color: lightblue; width: 250px; border-radius: 10px; text-align: center;"><%=cli.getApellido()%></label>
					</div>
				</div>

				<div class="row">
					<div class="col-4 p-2">
						<label class="">ID CLIENTE:</label>
					</div>
					<div class="col-4">
						<label class=""
							style="background-color: lightblue; width: 250px; border-radius: 10px; text-align: center;"><%=cli.getId()%></label>
						<input type="hidden" value="<%=cli.getId()%>" name="IDEliminar">
					</div>
				</div>

				<div class="row">
					<div class="col-4 p-2">
						<label class="">NOMBRE DE USUARIO:</label>
					</div>
					<div class="col-4">
						<label class=""
							style="background-color: lightblue; width: 250px; border-radius: 10px; text-align: center;"><%=cli.getUsuario()%></label>
					</div>
				</div>

				<div class="row">
					<div class="col-4 p-2">
						<label class="">DNI:</label>
					</div>
					<div class="col-4">
						<label class=""
							style="background-color: lightblue; width: 250px; border-radius: 10px; text-align: center;"><%=cli.getDni()%></label>
					</div>
				</div>

				<div class="row">
					<div class="col-4 p-2">
						<label class="">CUIL:</label>
					</div>
					<div class="col-4">
						<label class=""
							style="background-color: lightblue; width: 250px; border-radius: 10px; text-align: center;"><%=cli.getCuil()%></label>
					</div>
				</div>


				<div class="row">
					<div class="col-4 p-2">
						<label class="">MAIL:</label>
					</div>
					<div class="col-4">
						<label class=""
							style="background-color: lightblue; width: 250px; border-radius: 10px; text-align: center;"><%=cli.getMail()%></label>
					</div>
				</div>


				<%
					if (cli.isEstado()) {
				%>
				<div class="row">
					<div class="col-6">
						<div style="text-align: center">
							<input class="btn btn-success" type="submit"
								id="btnConfirmarBaja" name="confirmarBaja" value="Eliminar"
								style="margin: 50px 0 30px 0">
						</div>
					</div>
				</div>
				<%
					} else {
				%>
				<div class="row">
					<div class="col-6">
						<div style="text-align: center">
							<input class="btn btn-success" type="submit"
								id="btnConfirmarAlta" name="confirmarAlta" value="Dar de Alta"
								style="margin: 50px 0 30px 0">
						</div>
					</div>
				</div>


				<%
					}
				%>
			
		</form>
	</div>
	<jsp:include page="Footer.html"></jsp:include>


	<%
		String mensaje = "";
		if (request.getAttribute("ClienteBorrado") != null) {
			boolean estado = (boolean) request.getAttribute("ClienteBorrado");

			if (estado == false) {
	%>
	<script>
		Swal.fire({
			icon : 'error',
			title : 'Oops...',
			text : 'No se pudo eliminar!'
		}).then(function() {
			window.location.href = "Clientes.jsp";
		});
	</script>
	<%
		} else {
	%>
	<script>
		Swal.fire({
			icon : 'success',
			title : 'Usuario Eliminado',
			showConfirmButton : false,
			timer : 1500,
		}).then(function() {
			window.location.href = "Clientes.jsp";
		});
	</script>

	<%
		}
		}

		if (request.getAttribute("ClienteAgregado") != null) {
			boolean estado = (boolean) request.getAttribute("ClienteAgregado");

			if (estado == false) {
	%>
	<script>
		Swal.fire({
			icon : 'error',
			title : 'Oops...',
			text : 'No se pudo dar de alta!'
		}).then(function() {
			window.location.href = "Clientes.jsp";
		});
	</script>
	<%
		} else {
	%>
	<script>
		Swal.fire({
			icon : 'success',
			title : 'Se dio de alta al usuario',
			showConfirmButton : false,
			timer : 1500,
		}).then(function() {
			window.location.href = "Clientes.jsp";
		});
	</script>

	<%
		}
		}
	%>



</body>
</html>