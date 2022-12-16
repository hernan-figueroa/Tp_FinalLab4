<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="entidades.Prestamo"%>
    <%@page import="entidades.Login"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<h1>Estado de prestamo</h1>
<br><br>

<jsp:include page="Footer.html" ></jsp:include>			
</body>
</html>