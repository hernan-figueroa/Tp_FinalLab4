<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Login"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>




<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" type="text/css" href="Styles.css">
<script src="js/jquery-3.4.1.js"></script>
<script src="js/popper.min.js"></script>
<script src="bootstrap-4.3.1/js/bootstrap.min.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>


</head>



<!-- LOGIN -->
<%
	if (request.getParameter("OlvidoContrasenia") == null) {
%>

<body style="background: #EBF5FB">


	<div class="Center">

		<form action="servletLogin" method="post" class="Form">

			<h1 class="form-text text-muted" style="text-align: center">INICIAR
				SESION</h1>


			<div class="row">
				<div class="col-12">
					<input type="text" class="form-control" name="txtUsuario"
						placeholder="Nombre de Usuario" style="margin: 50px 0 0 0"
						required>
				</div>
			</div>


			<div class="row">
				<div class="col-12">
					<input type="password" class="form-control" name="txtClave"
						placeholder="Clave" style="margin: 50px 0 10px 0" required>
				</div>
			</div>

			<div class="row">
				<div class="col-12">
					<%!String LabelMensaje = "";%>
					<label name="lblMensaje" Text="Esto es un texto"
						value="Usuario Incorrecto" runat="server" style="color: red"><%=LabelMensaje%></label>
				</div>
			</div>

			<div class="row">
				<div class="col-12">
					<a href="Login.jsp?OlvidoContrasenia=true" class="Campos">Olvide
						mi contraseña o usuario</a>
				</div>
			</div>


			<div class="row">
				<div class="col-12">
					<div style="text-align: center">
						<input type="submit" class="btn btn-primary" name="btnIngresar"
							value="Ingresar" style="margin: 50px 0 30px 0">
					</div>
				</div>
			</div>

		</form>
	</div>
	<jsp:include page="Footer.html"></jsp:include>
</body>
<!-- LOGIN -->

<%
	String Mensaje = "";
		if (request.getAttribute("Mensaje") != null) {
			Mensaje = request.getAttribute("Mensaje").toString();
			if (Mensaje.equals("OK")) {
				LabelMensaje = "";
				response.sendRedirect("Login.jsp");
			} else {
				LabelMensaje = request.getAttribute("Mensaje").toString();
				response.sendRedirect("Login.jsp");
			}
		}
	}

	else {
%>
<!-- RECUPERAR CLAVE -->
<body style="background: #EBF5FB">
	<div class="Center">
		<form action="servletRecuperarConstrania" method="post" class="Form">
			<h1 class="form-text text-muted" style="text-align: center">RECUPERAR
				CONTRASEÑA</h1>
			<%!String Clave = "";%>

			<div class="row">
				<div class="col-12">
					<input type="text" class="form-control" name="txtMail"
						placeholder="Ingrese su Mail" style="margin: 50px 0 0 0" required>
				</div>
			</div>



			<div class="row">
				<div class="col-12">
					<%!String LabelMensajeOlvidoContraseña = "";%>
					<label name="lblMensaje" Text="Esto es un texto"
						value="Usuario Incorrecto" runat="server" style="color: red"><%=LabelMensajeOlvidoContraseña%></label>
				</div>
			</div>


			<div class="row">
				<div class="col-12">
					<a href="Login.jsp" class="Campos">Volver a Iniciar Sesion</a>

				</div>
			</div>


			<div class="row">
				<div class="col-12">
					<div style="text-align: center">
						<input type="submit" class="btn btn-primary"
							name="btnObtenerClave" value="Obtener Clave"
							style="margin: 50px 0 30px 0">
					</div>
				</div>
			</div>

		</form>
	</div>
	<jsp:include page="Footer.html"></jsp:include>
</body>

<!-- RECUPERAR CLAVE -->
<%
	}

	if (request.getAttribute("RecuperarClave") != null) {
		System.out.println("TRAJO USUARIO");
		Login login = new Login();
		login = (Login) request.getAttribute("RecuperarClave");
		Clave = login.getClave();
%>

<script>	
Swal.fire(
		  'SU CONTRASEÑA ES:',
	   	  'USUARIO: '+'<%=login.getUsuario()%>'+ ' - CLAVE: '+'<%=login.getClave()%>')
		.then(function(){ 
							window.location.href = "Login.jsp?OlvidoContrasenia=true";
						   }
						);
						
</script>
<%
	} else {
		if (request.getAttribute("MensajeOlvidoContrasenia") != null) {
			LabelMensajeOlvidoContraseña = (String) request.getAttribute("MensajeOlvidoContrasenia");
			response.sendRedirect("Login.jsp?OlvidoContrasenia=true");
		} else {
			LabelMensajeOlvidoContraseña = "";
		}
	}
%>




</html>