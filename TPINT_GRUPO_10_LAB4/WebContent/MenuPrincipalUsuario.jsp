<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Login"%>
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
<style type="text/css">
.card {
	position: relative;
	border: 2px solid #c3c6ce;
	transition: 0.5s ease-out;
	overflow: visible;
}

.card-button {
	transform: translate(-50%, 125%);
	width: 60%;
	border-radius: 1rem;
	border: none;
	background-color: #008bf8;
	color: #fff;
	font-size: 1.1rem;
	padding: .5rem 1rem;
	position: absolute;
	left: 50%;
	bottom: 0;
	opacity: 0;
	transition: 0.3s ease-out;
}

/*Hover*/
.card:hover {
	border-color: #008bf8;
	box-shadow: 0 4px 18px 0 rgba(0, 0, 0, 0.25);
}

.card:hover .card-button {
	transform: translate(-50%, 50%);
	opacity: 1;
}
</style>


</head>
<body onload="listarCuentas()">
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

		<div class="container">
			<nav class="navbar navbar-expand-lg bg-light "> <jsp:include
				page="NavBarCliente.html"></jsp:include> <input type="hidden"
				id="usuario" value=<%=log.getUsuario()%>>
			<div class="col-4 text-end">
				<%=log.getUsuario()%>
				<a class="nav-link" href="servletCerrarSesion?CerrarSesion=true">
					Cerrar Sesion</a>
			</div>
			</nav>
			<h1>
				<b>Menu principal</b>
			</h1>
			<form id="cuentaSeleccionada" action="ServletCuentaSeleccionada"
				method="post">
				<div class="my-5" id="cuentas"></div>

				<div>
			</form>


		</div>

		<br>

		<jsp:include page="Footer.html"></jsp:include>
		<script>
			function listarCuentas() {
				$.ajax({
					url : "ServletListarCuentas",
					data : {usuario: $('#usuario').val()},
					success : function(result) {
						$("#cuentas").html(result);
					}
				});
			}
		</script>
	</div>
</body>
</html>