<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
					response.sendRedirect("Login.jsp");
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
		<h1>Pagar prestamo</h1>
		<br>

		<form method="get" action="ServletPagarPrestamo">

			<%
ArrayList<Prestamo> listarPrestamos = null;
if(request.getAttribute("listaPrestamo")!=null){
	listarPrestamos = (ArrayList<Prestamo>)request.getAttribute("listaPrestamo");
}
%>
<h3>Seleccione prestamo a pagar</h4>
<select>
<%
if(listarPrestamos != null){

for (Prestamo prestamo : listarPrestamos){ int cuota = prestamo.getCuotapaga()+1;%>
  
<option> Cuota: <%=cuota%> - $<%=prestamo.getCuotaMensual()%> </option>
<input type="hidden" name="IDPrestamo" value=<%= prestamo.getIdPrestamo() %>>

<input type="hidden" name="IDCliente" value=<%= prestamo.getIdCliente() %>>
<input type="hidden" name="CBUPrestamo" value=<%= prestamo.getCbu() %>>
<input type="hidden" name="Importe" value=<%= prestamo.getCuotaMensual() %>>

<%}} %> 
</select>
<br>
<br>
<input type="submit" name="btnPagarCuota" Value="Pagar Cuota">


			<%
				boolean estadoPago = false;

				if (request.getAttribute("estadoPago") != null) {
					estadoPago= (boolean) request.getAttribute("estadoPago");
				}

				if (estadoPago == true) {
			%>
			<script>
				Swal.fire({
					icon : 'success',
					title : 'Cuota pagada con exito',
					showConfirmButton : false,
					timer : 1500,
				}).then(function() {
					window.location.href = "MenuPrincipalUsuario.jsp";
				});
			</script>
			<%
				}
			%>

		</form>


	</div>
</body>
</html>