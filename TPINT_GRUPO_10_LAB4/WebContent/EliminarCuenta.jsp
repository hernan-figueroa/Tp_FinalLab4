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
	 		
	
	<nav class="navbar navbar-expand-lg bg-light">
	<jsp:include page="NavBarAdmin.html"></jsp:include>
	<label style="margin: 0px 10px 0 60%;"><%=log.getUsuario()%></label>
	<a  class="nav-link"href="servletCerrarSesion?CerrarSesion=true">Cerrar Sesion</a>
	</nav>
	<jsp:include page="Footer.html"></jsp:include>
</body>
</html>