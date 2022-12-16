<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Solicitar prestamo</title>

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
		<b>Realizar prestamo</b>
	</h1>
	<br>
	<form action="ServletSolicitarPrestamo" method="get">

		<%
			Prestamo prest1 = null;

			if (request.getAttribute("PrestamoSegundo") != null) {
				prest1 = (Prestamo) request.getAttribute("PrestamoSegundo");
			}
		%>
		
		


		<div>
			ID cliente: <label style="position: absolute; left: 48%;"><%=prest1.getIdCliente()%></label>
			<input type="hidden" name="inputIDCliente"
				value="<%=prest1.getIdCliente()%>">
		</div>
		<br>
		<div>
			CBU: <label style="position: absolute; left: 48%;"><%=prest1.getCbu()%></label>
			<input type="hidden" name="inputCBU" value="<%=prest1.getCbu()%>">
		</div>
		<br>
		<div>
			Numero de cuenta: <label style="position: absolute; left: 48%;"><%=prest1.getNroCuenta()%></label>
			<input type="hidden" name="inputNumeroDeCuenta"
				value="<%=prest1.getNroCuenta()%>">
		</div>
		<br>
		<div>
			Cuotas a pagar: <label style="position: absolute; left: 48%;"><%=prest1.getCantCuotas()%></label>
			<input type="hidden" name="inputCuotas"
				value="<%=prest1.getCantCuotas()%>">
		</div>
		<br>
		<div>
			Importe por cuota a pagar: <label
				  style="position: absolute; left: 48%;"><%=prest1.getCuotaMensual()%></label>
			<input type="hidden" name="inputImportePorCuotas"
				value="<%=prest1.getCuotaMensual()%>">
		</div>
		<br>
		<div>
			Importe total a pagar: <label style="position: absolute; left: 48%;"><%=prest1.getMontoAdeudado()%></label>
			<input type="hidden" name="inputMontoAdeudado"
				value="<%=prest1.getMontoAdeudado()%>">
		</div>
		<br>
		<div>
			Importe a recibir: <label style="position: absolute; left: 48%;"><%=prest1.getMontoPrestado()%></label>
			<input type="hidden" name="inputMontoPrestado"
				value="<%=prest1.getMontoPrestado()%>">
		</div>
		<br>
		<div>
			<input type="hidden" name="inputFechaInicio"
				value="<%=prest1.getFechaInicio()%>">

		</div>

		<div>
			<input class="btn btn-secondary" type="submit" name="btnVolverAlMenu"
				value="Volver al menu"> <input class="btn btn-secondary"
				type="submit" name="btnConfirmarPrestamo" value="Confirmar">
		</div>
		

	</form>
	</div>
</body>
</html>