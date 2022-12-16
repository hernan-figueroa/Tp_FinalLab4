<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.*"%>
<%@page import="java.util.ArrayList"%>
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
<body >
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

		<b><h1>Información de cuenta seleccionada</h1></b>
		<%
			Cuenta cuenta = (Cuenta) request.getAttribute("Cuenta");
			String tipoCuenta = request.getAttribute("tipoCuenta").toString();
		%>
		<input type="hidden" id="CBU" value=<%=cuenta.getCbu()%>>
		<div class="card p-4">
			<div>
				Numero de cuenta: <b><%=cuenta.getNumeroCuenta()%></b>
			</div>
			<div>
				Tipo de cuenta: <b><%=tipoCuenta%></b>
			</div>
			<div>
				CBU: <b><%=cuenta.getCbu()%></b>
			</div>
			<div>
				Saldo: <b>$<%=cuenta.getSaldo()%></b>
			</div>
			
		<br>

<%
			ArrayList<Movimiento> listaMovimientos = null;
			if(request.getAttribute("listamov")!=null)
			{
				listaMovimientos = (ArrayList<Movimiento>) request.getAttribute("listamov");
			}
			
			
			%>
			<div>
    			<table id="x" border=1 class="table mt-3" table-striped>  
    			<thead>
    			<tr>
    			 <th><b>FECHA OPERACION</b></th> 
    			<th><b>CONCEPTO</b></th> 
    			<th><b>IMPORTE</b></th> 
    			<th><b>TIPO MOVIMIENTO</b></th>
    			</tr>
    		    </thead>
    			
    		<tbody>
    		<%
    		if(listaMovimientos != null)
    		for(Movimiento mov : listaMovimientos) 
    		{
    		
    		%>
    		<tr>
    		<td><%=mov.getFecha() %></div></td> 
   			<td><%=mov.getDetalle() %></div></td>
  			<td><%=mov.getImporte() %></div></td>
    		<td><%=mov.getTipoMovimiento().getDescripcion() %></div></td> 
    		
		</tr>
		<%  } %>
		</tbody>
		</table></div>



		<form action="ServletRealizarTransferencia" method="get">
			<div>
				<input class="btn btn-secondary mt-4" type="submit"
					name="btnIrRealizarTransferencia" value="Realizar transferencia">
				<input type="hidden" name="CBUOrigen" value=<%=cuenta.getCbu()%>>
				<input type="hidden" name="SaldoDisponible"
					value=<%=cuenta.getSaldo()%>>
			</div>
		</form>
		<form action="ServletSolicitarPrestamo" method="get">
			<div>
				<br> <input class="btn btn-secondary" type="submit"
					name="btnSolicitarPrestamo" value="Solicitar prestamo"> <input
					type="hidden" name="CBUPrestamo" value=<%=cuenta.getCbu()%>>
				<input type="hidden" name="NumeroDeCuentaPrestamo"
					value=<%=cuenta.getNumeroCuenta()%>> <input type="hidden"
					name="IDClientePrestamo" value=<%=cuenta.getId_cliente()%>>

			</div>
			</form>
			
			<form action="ServletPagarPrestamo" method="get">
			<div>
				<br> <input class="btn btn-secondary" type="submit"
					name="btnPagarPrestamo" value="Pagar prestamo"> <input
					type="hidden" name="CBUPrestamo" value=<%=cuenta.getCbu()%>>
					
				<input type="hidden" name="NumeroDeCuentaPrestamo"
					value=<%=cuenta.getNumeroCuenta()%>> <input type="hidden"
					name="IDClientePrestamo" value=<%=cuenta.getId_cliente()%>>

			</div>
		</form>

		<br>



		<jsp:include page="Footer.html"></jsp:include>
	</div>

	<script src="//cdn.datatables.net/1.13.1/css/jquery.dataTables.min.css"></script>
	<script src="//cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
	<script>
		$(document)
				.ready(
						function() {
							$('#x')
									.DataTable(
											{

												"language" : {
													"processing" : "Procesando...",
													"lengthMenu" : "",
													"zeroRecords" : "No se encontraron resultados",
													"emptyTable" : "Ningún dato disponible en esta tabla",
													"infoEmpty" : "Mostrando registros del 0 al 0 de un total de 0 registros",
													"infoFiltered" : "(filtrado de un total de MAX registros)",
													"search" : "Buscar: ",
													"info" : "",
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