<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="entidades.Login"%>
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
		<h1>Informe estadistico</h1>
		<div class="form col-6" >
			<h2 class="mt-5">Intereses generados</h2>
			<div class="row align-items-end  ">
				<div class="col-auto">
					<label class="col">Desde:</label> <input class="form-control"
						type="date" id="desde" name="desde" required>
				</div>
				<div class="col-auto">
					<label class="col">Hasta:</label> <input class="form-control"
						type="date" id="hasta" name="hasta" required>
				</div>
				<div class="col-auto">
					<button class="btn btn-secondary align-items-bottom " onclick="listarPrestamos()">Filtrar</button>
				</div>
			</div>
<!-- 			aca se dibuja la tabla completa con los intereses totales etc. -->
				<div id="prestamos">
					
				</div>

		</div>
	</div>
	<jsp:include page="Footer.html" ></jsp:include>
	<%-- <%
if(session.getAttribute("NombreUsuario")!=null)
{
	Login log= new Login();
	log= (Login)session.getAttribute("NombreUsuario");
	System.out.println(session.getAttribute("NombreUsuario"));
	if(!log.getAdmin())
		response.sendRedirect("Login.jsp");
}else response.sendRedirect("Login.jsp");

%>--%>
	
	<script>
		function listarPrestamos() {
			$.ajax({
				url : "ServletInformeEstadistico",
				data : {
					desde : $('#desde').val(),
					hasta : $('#hasta').val()
				},
				success : function(result) {
					$("#prestamos").html(result);
				}
			});
		}
	</script>
</body>
</html>