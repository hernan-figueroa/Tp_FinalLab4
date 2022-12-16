<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="entidades.Login"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	 		
	
	<nav class="navbar navbar-expand-lg bg-light">
	<jsp:include page="NavBarCliente.html"></jsp:include>
	<label style="margin: 0px 10px 0 60%;"><%=log.getUsuario()%></label>
	<a  class="nav-link"href="servletCerrarSesion?CerrarSesion=true">Cerrar Sesion</a>
	</nav>

<h1>Comprobante</h1><br>
<label style="position:absolute; left: 50px;">MOVIMIENTO:</label> <label style="position:absolute; left: 250px;">lblMovimiento</label> <br><br>
<label style="position:absolute; left: 50px;">CBU:</label> <label style="position:absolute; left: 250px;">lblCBU</label> <br><br>
<label style="position:absolute; left: 50px;">FECHA:</label> <input type="date" name="fecha" style="position:absolute; left: 250px;"> <br><br>
<label style="position:absolute; left: 50px;">IMPORTE:</label> <label style="position:absolute; left: 250px;">lblImporte</label> <br><br>
<label style="position:absolute; left: 50px;">TIPO DE MOVIMIENTO:</label> <label style="position:absolute; left: 250px;">lblTipoDeMovimiento</label> <br><br>

<input style="position:absolute; left: 125px; width:175px" type="submit" value="Volver al inicio" name="btnVolverInicio">
<jsp:include page="Footer.html" ></jsp:include>
</body>
</html>