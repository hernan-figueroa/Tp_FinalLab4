<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Cliente"%>
<%@page import="entidades.Nacionalidad"%>
<%@page import="entidades.Provincia"%>
<%@page import="entidades.Localidad"%>
<%@page import="entidades.Login"%>
<%@page import="negocio.ClienteNegocio"%>
<%@page import="negocioImpl.ClienteNegocioImpl"%>
<%@page import="entidades.TipoUsuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<title>Modificar Usuario</title>

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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">

</head>


<body onload="ddl()">
	
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
			Cliente cliente = new Cliente();

			if (request.getAttribute("cliente") != null) {

				cliente = (Cliente) request.getAttribute("cliente");
				idUs = cliente.getId().toString();
				dni = cliente.getDni().toString();
				cuil = cliente.getCuil().toString();
				nombre = cliente.getNombre().toString();
				apellido = cliente.getApellido().toString();
				sexo = cliente.getSexo().toString();
				direccion = cliente.getDireccion();
				mail = cliente.getMail();
				fechaNac = cliente.getFechaNac();
				System.out.println(fechaNac);
				nombreUsuario = cliente.getUsuario();
				contraseña = cliente.getContrasenia();
				//response.sendRedirect("ModificarUsuario.jsp");
			}

			if (request.getAttribute("Actualizo") != null) {
				System.out.println(request.getAttribute("Actualizo"));
				if ((boolean) request.getAttribute("Actualizo")) {
					idUs = "";
					dni = "";
					cuil = "";
					nombre = "";
					apellido = "";
					sexo = "";
					direccion = "";
					mail = "";
					nombreUsuario = "";
					contraseña = "";
					// 					OpcionProv = "------Seleccionar------";
					// 					valueProv = -1;
					// 					OpcionLoc = "------Seleccionar------";
					// 					valueLoc = -1;
					// 					OpcionNac = "------Seleccionar------";
					// 					valueNac = -1;
		%>
		<script>
			Swal.fire({
				icon : 'success',
				title : 'Usuario Modificado',
				showConfirmButton : false,
				timer : 1500,
			}).then(function() {
				window.location.href = "Clientes.jsp";
			});
		</script>
		<%
			} else {
		%>
		<script>
			Swal.fire({
				icon : 'error',
				title : 'Oops...',
				text : 'Something went wrong!'
			})
		</script>
		<%
			}
			}
		%>


		<nav class="navbar navbar-expand-lg bg-light"> <jsp:include
			page="NavBarAdmin.html"></jsp:include> <label
			style="margin: 0px 10px 0 60%;"><%=log.getUsuario()%></label> <a
			class="nav-link" href="servletCerrarSesion?CerrarSesion=true">Cerrar
			Sesion</a> </nav>

<div class="container">
		<div class="row">

			<div class="col-6">
				<h1>DATOS CLIENTE</h1>
				<input type="hidden" id="idCliente" value=<%=cliente.getUsuario()%> />
				<div id="resultado"></div>

			</div>

			<div class="col-6">
				<form action="servletModificarUsuario" method="post">
					<div style="width: 70%; height: 100%; margin-left: 10px">
						<h1>EDITAR CLIENTE</h1>

						<div class="row">
							<div class="col-5 p-2">
								<label class="">IDUsuario:</label>
							</div>
							<div class="col-7">
								<input type="text" class="form-control" readonly
									onmousedown="return false;" name="txtidUs"
									value="<%!String idUs = "";%><%=idUs%>"
									placeholder="ID USUARIO" required>
							</div>
						</div>


						<div class="row">
							<div class="col-5 p-2">
								<label class="">DNI:</label>
							</div>
							<div class="col-7">
								<input type="text" class="form-control" name="txtDni"
									value="<%!String dni = "";%><%=dni%>" placeholder="DNI"
									required>
							</div>
						</div>


						<div class="row">
							<div class="col-5 p-2">
								<label class="">CUIL:</label>
							</div>
							<div class="col-7">
								<input type="number" class="form-control" name="txtCuil"
									value="<%!String cuil = "";%><%=cuil%>" placeholder="CUIL"
									required>
							</div>
						</div>


						<div class="row">
							<div class="col-5 p-2">
								<label class="">Nombre:</label>
							</div>
							<div class="col-7">
								<input type="text" class="form-control" name="txtNombre"
									value="<%!String nombre = "";%><%=nombre%>"
									placeholder="NOMBRE" required>
							</div>
						</div>


						<div class="row">
							<div class="col-5 p-2">
								<label class="">Apellido:</label>
							</div>
							<div class="col-7">
								<input type="text" class="form-control" name="txtApellido"
									value="<%!String apellido = "";%><%=apellido%>"
									placeholder="APELLIDO" required>
							</div>
						</div>


						<div class="row">
							<div class="col-5 p-2">
								<label class="">SEXO:</label>
							</div>
							<div class="col-7">
								<input type="text" class="form-control" name="txtSexo"
									value="<%!String sexo = "";%><%=sexo%>" placeholder="SEXO"
									required>
							</div>
						</div>


						<div class="row">
							<div class="col-5 p-2">
								<label class="">FECHA NACIMIENTO:</label>
							</div>
							<div class="col-7 ">
								<input type="date" class="form-control" name="txtFechaNac"
									value="<%!Date fechaNac = new Date(1, 1, 1);%><%=fechaNac%>"
									placeholder="FECHA NACIMIENTO" required>
							</div>
						</div>


						<div class="row">
							<div class="col-5 p-2">
								<label class="">DIRECCION:</label>
							</div>
							<div class="col-7">
								<input type="text" class="form-control" name="txtDirec"
									value="<%!String direccion = "";%><%=direccion%>"
									placeholder="DIRECCION" required>
							</div>
						</div>


						<div class="row">
							<div class="col-5 p-2">
								<label class="">LOCALIDAD:</label>
							</div>
							<div class="col-7">
								<div id="localidades" required></div>
							</div>
						</div>



						<div class="row">
							<div class="col-5 p-2">
								<label class="">PROVINCIA:</label>
							</div>
							<div class="col-7">
								<div id="provincias" required></div>
							</div>
						</div>



						<div class="row">
							<div class="col-5 p-2">
								<label class="">NACIONALIDAD:</label>
							</div>
							<div class="col-7">
								<div id="nacionalidades" required></div>
							</div>
						</div>



						<div class="row">
							<div class="col-5 p-2">
								<label class="">MAIL:</label>
							</div>
							<div class="col-7">
								<input type="email" class="form-control" name="txtMail"
									value="<%!String mail = "";%><%=mail%>" placeholder="MAIL"
									required>
							</div>
						</div>


						<div class="row">
							<div class="col-5 p-2">
								<label class="">NOMBRE DE USUARIO:</label>
							</div>
							<div class="col-7">
								<input type="text" class="form-control" name="txtUsuario"
									value="<%!String nombreUsuario = "";%><%=nombreUsuario%>"
									placeholder="NOMBRE DE USUARIO" required>
							</div>
						</div>

						<div class="row">
							<div class="col-5 p-2">
								<label class="">CONTRASEÑA:</label>
							</div>
							<div class="col-7">
								<input type="password" class="form-control" name="txtContraseña"
									value="<%!String contraseña = "";%><%=contraseña%>"
									placeholder="CONTRASEÑA" required>
							</div>
						</div>



						<div class="row">
							<div class="col-12">
								<div style="text-align: center">
									<input class="btn btn-success" name=btnActualizar type="submit"
										value="Modificar" style="margin: 50px 0 30px 0" />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-4 p-2"></div>
							<div class="col-4">
								<label><%!String lblMensaje = "";%><%=lblMensaje%></label>
							</div>
						</div>
				</form>
			</div>
		</div>







	</div>
	<jsp:include page="Footer.html"></jsp:include>
	<script>
		function ddl() {
			function buscarLocalidades() {
				$.ajax({
					url : "servletListarLocalidades",
					success : function(result) {
						$("#localidades").html(result);
					}
				});
			}
			function buscarProvincias() {
				$.ajax({
					url : "ServletListarProvincias",
					success : function(result) {
						$("#provincias").html(result);
					}
				});
			}
			function buscarNacionalides() {
				$.ajax({
					url : "ServletListarNacionalidad",
					success : function(result) {
						$("#nacionalidades").html(result);
					}
				});
			}
			function mostrarUsuario() {
				$.ajax({
					url : "ServletPerfilCliente",
					method : 'POST',
					data : {
						usuario : $('#idCliente').val()
					},
					success : function(result) {
						$("#resultado").html(result);
					}
				});
			}
			buscarProvincias();
			buscarLocalidades();
			buscarNacionalides();
			mostrarUsuario();
		}
	</script>


</body>
</html>