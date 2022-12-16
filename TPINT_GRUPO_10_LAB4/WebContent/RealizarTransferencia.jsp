<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="entidades.Cliente"%>
<%@page import="entidades.Usuario"%>
<%@page import="entidades.Login"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Realizar transferencia</title>


<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
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
				String saldo = "";
				if (request.getAttribute("CBUOrigen") != null) {
					cbuOrigen = (String) request.getAttribute("CBUOrigen");
				}
				if (request.getAttribute("SaldoDisponible") != null) {
					saldo = (String) request.getAttribute("SaldoDisponible");
				}
			%>


			<div>
				CBU Origen: <label style="position: absolute; left: 48%;"
					name="lblCBUO"><%=cbuOrigen%></label> <input type="hidden"
					name="inputCBUO" value="<%=cbuOrigen%>">
			</div>
			<br>
			<div>
				Saldo disponible: <label style="position: absolute; left: 48%;"
					name="lblSaldo"><%=saldo%></label> <input type="hidden"
					name="inputSaldo" value="<%=saldo%>">
			</div>
			<br>

			<div>Ingrese el CBU destino</div>
			<br>
			<div>
				<label>CBU/CVU:</label> <input
					style="position: absolute; left: 48%;" type="number"
					name="txtTransferenciaCBU" required />
			</div>
			<br>
			<div>Ingrese monto a transferir</div>
			<br>
			<div>
				<label>Monto:</label> <input min="1" style="position: absolute; left: 48%;"
					type="number" name="txtTransferenciaMonto" required />
			</div>

			<br>



			<%
				String MensajeCBU = "";
				if (request.getAttribute("CBUInvalido") != null) {
					MensajeCBU = (String) request.getAttribute("CBUInvalido");
				}
				String MontoInvalido = "";
				if (request.getAttribute("MontoInvalido") != null) {
					MensajeCBU = (String) request.getAttribute("MontoInvalido");
				}
			%>

			<div>
				<label><%=MensajeCBU%> </label>
			</div>

			<div>
				<input
					class="btn btn-secondary" type="submit" name="btnTrasnferencia"
					value="Transferir">
			</div>
		</form>
	</div>

</body>
</html>