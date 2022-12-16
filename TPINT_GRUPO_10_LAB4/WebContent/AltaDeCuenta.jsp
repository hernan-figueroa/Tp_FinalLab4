<%@page import="java.util.ArrayList"%>
<%@page import="entidades.*"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="entidades.Admin"%>
	<%@page import="negocioImpl.AdminNegocioImpl"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>



</head>

<body onload="buscarTipoUsuarios()">




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

		<h1>Generar Alta de cuenta</h1>
		<form class="form col-6 " id="altaCuenta" action="ServletAltaCuenta"
			method="post">

			<div class="d-flex justify-content-between p-1">
				<label class="col-6 ">Tipo de cuenta:</label>
				<div id="resultado" class="col-6" required></div>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Id Cliente:</label> <input class="form-control"
					type=number name="idCliente" required>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Monto asignado:</label> <input
					class="form-control" type="number" name="saldo" readonly
					value="10000">
			</div>

			<div class="d-flex justify-content-between p-1">
				<%!SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");%>
				<%!Date Fecha = new Date();%>
				<input type="hidden" class="form-control" name="txtFecha"
					value="<%=format.format(Fecha)%>" required>
			</div>

			<div class="d-flex justify-content-between p-1">
				<a href="AltaDeCuenta.jsp" class="btn btn-secondary"> Reiniciar
					Carga</a> <input class="btn btn-secondary" type="submit"
					name="btnAceptar" value="aceptar">
			</div>

		</form>

		<%
			if (request.getAttribute("Cuenta") != null) {
				Cuenta cuenta = (Cuenta) request.getAttribute("Cuenta");
		%>
		<div class="col-6 border border-success border-5 mt-5 ">

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Tipo de cuenta:</label> <input
					class="form-control" type="text"
					value=<%=cuenta.getTipoCuenta().getDescripcion()%> readonly>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Id Cliente:</label> <input class="form-control"
					type="text" value=<%=cuenta.getId_cliente()%> readonly>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Monto asignado:</label> <input
					class="form-control" type="number" step="any"
					value=<%=cuenta.getSaldo()%> readonly>
			</div>

			<div class="d-flex justify-content-between p-1">

				<label class="col-6">Fecha de alta:</label> <input
					class="form-control" value=<%=cuenta.getFechaCreacion()%> readonly
					id="hoy">
			</div>
			<div class="d-flex justify-content-between p-1">
				<label class="col-6">CBU:</label> <input class="form-control"
					type="number" value=<%=cuenta.getCbu()%> readonly>
			</div>

			<div class="d-flex justify-content-between p-1">
				<label class="col-6">Numero de cuenta:</label> <input
					class="form-control" type="number"
					value=<%=cuenta.getNumeroCuenta()%>>
			</div>
		</div>
		<%
			}
		%>
		<%
		String mensaje="";
			if(request.getAttribute("Mensaje")!=null){
				 mensaje= request.getAttribute("Mensaje").toString();
			}
			
		%>
		<div>
			<label><%=mensaje%></label>
		</div>
		
	</div>

	<jsp:include page="Footer.html"></jsp:include>

	<script>
		function buscarTipoUsuarios() {
			$.ajax({
				url : "ServletListarTipoCuentas",
				success : function(result) {
					$("#resultado").html(result);
				}
			});
		}
	</script>


</body>
</html>