<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="entidades.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Realizar transferencia</title>



<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" type="text/css" href="Styles.css">
<script src="js/jquery-3.4.1.js"></script>
<script src="js/popper.min.js"></script>
<script src="bootstrap-4.3.1/js/bootstrap.min.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">

<script src="sweetalert2.all.min.js"></script>
<script src="sweetalert2.min.js"></script>

<link rel="stylesheet" href="sweetalert2.min.css">

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

		<h1>
			<b>Realizar transferencia</b>
		</h1>
		<br>
		<form action="ServletRealizarTransferencia" method="get">

			<%
				String cbuOrigen = "";
				double monto = 0;
				String cbuDestino = "";
				if (request.getAttribute("CBUOrigen") != null) {
					cbuOrigen = (String) request.getAttribute("CBUOrigen");
				}
				if (request.getAttribute("CBUDestino") != null) {
					cbuDestino = (String) request.getAttribute("CBUDestino");
				}
				if (request.getAttribute("Monto") != null) {
					monto = (double) request.getAttribute("Monto");
				}
			%>


			<div>
				CBU Origen: <label style="position: absolute; left: 48%;"><%=cbuOrigen%></label>
				<input type="hidden" name="inputCBUO" value="<%=cbuOrigen%>">
			</div>
			<br>
			<div>
				CBU Destino: <label style="position: absolute; left: 48%;"><%=cbuDestino%></label>
				<input type="hidden" name="inputCBUD" value="<%=cbuDestino%>">
			</div>
			<br>
			<div>
				Monto: <label style="position: absolute; left: 48%;"><%=monto%></label>
				<input type="hidden" name="inputMonto" value="<%=monto%>">
			</div>
			<br>

			<%
				boolean estadoTransferencia = false;

				if (request.getAttribute("Estado") != null) {
					estadoTransferencia = (boolean) request.getAttribute("Estado");
				}

				if (estadoTransferencia == true) {
			%>
			<script>
				Swal.fire({
					icon : 'success',
					title : 'Transferencia realizada con exito',
					showConfirmButton : false,
					timer : 1500,
				}).then(function() {
					window.location.href = "MenuPrincipalUsuario.jsp";
				});
			</script>
			<%
				}
			%>


			<div>
				<input class="btn btn-secondary" type="submit"
					name="btnVolverAlMenu" value="Volver al menu"> <input
					class="btn btn-secondary" type="submit"
					name="btnConfirmarTransferencia" value="Confirmar">
			</div>
		</form>
	</div>

</body>
</html>