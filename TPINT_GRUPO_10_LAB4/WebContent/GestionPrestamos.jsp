<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Prestamo"%>
<%@page import="entidades.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="negocioImpl.AdminNegocioImpl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" type="text/css" href="Styles.css">
<script src="js/jquery-3.4.1.js"></script>
<script src="js/popper.min.js"></script>
<script src="bootstrap-4.3.1/js/bootstrap.min.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.js"></script>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
	

<script src="sweetalert2.all.min.js"></script>
<script src="sweetalert2.min.js"></script>

<link rel="stylesheet" href="sweetalert2.min.css">	
	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	<h1>GESTION DE PRESTAMOS</h1>

	<form method="post" action="ServletGestionarPrestamo">


<div >
<%
ArrayList<Prestamo> listarPrestamos = null;
if(request.getAttribute("listarPrestamos")!=null){
	listarPrestamos = (ArrayList<Prestamo>)request.getAttribute("listarPrestamos");
}

if(request.getParameter("btnMostrarTodos")!=null) %>
<table id="TG" border="1" class="table mt-3" table-striped">
		<thead>
		<tr>
			<td><b>ID CLIENTE</b></td>
			<td><b>ID PRESTAMO</b></td>
			<td><b>IMPORTE SOLICITADO</b></td>
			<td><b>IMPORTE A PAGAR</b></td>
			<td><b>CUOTAS</b></td>
			<td><b>CBU</b></td>
			<td><b>Aceptar/Rechazar</b></td>
		</tr>
		</thead>
		<%
		int num = 1;
		if(request.getAttribute("listarPrestamos")!=null){
			for(Prestamo prestamo : listarPrestamos){
		%>
		<tr>
			<td><%=prestamo.getIdCliente() %></td>
			<td><%=prestamo.getIdPrestamo() %></td>
			<td><%=prestamo.getMontoPrestado()%></td>
			<td><%=prestamo.getMontoAdeudado()%></td>
			<td><%=prestamo.getCantCuotas()%></td>
			<td><%=prestamo.getCbu() %></td>
			<td><input type="submit" name="btnAprobar<%=+num %>" value="Aprobar" /> <input type="submit" name="btnDesaprobar<%=+num %>" value="Desaprobar"/> 
			<input type="hidden" name="btnSacarCbu<%=+num %>" value=<%=prestamo.getCbu()%>><input type="hidden" name="btnSacarMonto<%=+num %>" value=<%=prestamo.getMontoPrestado()%>>
			<input type="hidden" name="btnId<%=+num %>" value=<%=prestamo.getIdPrestamo()%>>
			</td>
		</tr>
		<% num++;}
		}
		%>
	</table>
</div>
<div>
<input type="submit" name="btnMostrarPrestamos" value="Mostrar Prestamos" style="position: absolute; left: 470px; width: 175px">
</div>


		<%
				boolean estadoAceptar = false;

				if (request.getAttribute("estadoAceptar") != null) {
					estadoAceptar = (boolean) request.getAttribute("estadoAceptar");
				}

				if (estadoAceptar == true) {
			%>
			<script>
				Swal.fire({
					icon : 'success',
					title : 'Prestamo aceptado con exito',
					showConfirmButton : false,
					timer : 1500,
				}).then(function() {
					window.location.href = "GestionPrestamos.jsp";
				});
			</script>
			<%
				}
			%>
			
			<%
				boolean estadoDesaprobar = false;

				if (request.getAttribute("estadoDesaprobar") != null) {
					estadoDesaprobar = (boolean) request.getAttribute("estadoDesaprobar");
				}

				if (estadoDesaprobar == true) {
			%>
			<script>
				Swal.fire({
					icon : 'success',
					title : 'Prestamo desaprobado con exito',
					showConfirmButton : false,
					timer : 1500,
				}).then(function() {
					window.location.href = "GestionPrestamos.jsp";
				});
			</script>
			<%
				}
			%>


<%
int i = 0;
if(listarPrestamos!=null){

i = listarPrestamos.size(); }%>
<input type="hidden" name="btnTamaño" value=<%=i%>>

</div>
</form>

	<jsp:include page="Footer.html"></jsp:include>
	
		<script>
		$(document)
				.ready(
						function() {
							$('#TG')
									.DataTable(
											{

												"language" : {
													"processing" : "Procesando...",
													"lengthMenu" : "Mostrar _MENU_ registros",
													"zeroRecords" : "No se encontraron resultados",
													"emptyTable" : "Ningún dato disponible en esta tabla",
													"infoEmpty" : "Mostrando registros del 0 al 0 de un total de 0 registros",
													"infoFiltered" : "(filtrado de un total de _MAX_ registros)",
													"search" : "Buscar:",
													"infoThousands" : ",",
													"loadingRecords" : "Cargando...",
													"paginate" : {
														"first" : "Primero",
														"last" : "Último",
														"next" : "Siguiente",
														"previous" : "Anterior"
													},
												}

											});
						});
	</script>
	


</body>
</html>