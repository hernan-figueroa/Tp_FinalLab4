<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Usuario</title>

  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"  rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
  <link rel="stylesheet" type="text/css" href="Styles.css">
  <script src="js/jquery-3.4.1.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="bootstrap-4.3.1/js/bootstrap.min.js"></script>


<header class="row">
<a href="Login.jsp" class="bi bi-bank" style="font-size: 6em;margin: 0.1% 0 0 10%; color:black" > </a>
<a href="Login.jsp" type=button style="margin: 3% 0 0 0; color:black"><h1>ONLY BANK</h1></a>

<div class="col-8">
<div class="row">
<a href="servletLogin?btnRegistrarUsuario=RegistrarUsuario" method="get" class="Campos" style="margin: 7% 0 0 50%;color:black;"><h5>Registrar Usuario</h5></a>
<a href="servletLogin?btnRegistrarUsuario=RegistrarUsuario" class="bi bi-person-plus-fill" style="font-size:2em; margin: 7% 0 0 0.5%; color:black"></a>
<a href="servletLogin?btnSalir=CerrarSesion" class="Campos" style=";margin: 7% 0 0 1%;color:black"><h5>Informe</h5></a>
<a href="" class="bi bi-graph-up" style="font-size:2em; margin: 7% 0 0 0.5%;color:black"/></a>
<a href="servletLogin?btnSalir=CerrarSesion" class="Campos" style=";margin: 7% 0 0 1%;color:black"><h5>Salir</h5></a>
<a href="servletLogin?btnSalir=CerrarSesion" class="bi bi-box-arrow-right"style="font-size:2em; margin: 7% 0 0 0.5%;color:black"/></a>
</div>
</div>
</header>
</head>



<body style="background:#EBF5FB">
<form action="servletModificarUsuario" method="post" >
<div id="BuscarUsuario" style="">
<label >Usuario a modificar:</label>
<input  type="text" style="margin:10px 0 0 0; border-radius: 0.1rem;"> 
<input class="btn btn-secondary" type="submit" name=btnListarUsuario value="Aceptar" style="height:40px; margin:0 0 10px 0">

<div id="divFiltro" class="form-control" style="display:none;justify-content:space-between; width:70%;position:absolute; margin:0 0 15% 15%">
<label>Nombre </label>
<label>Apellido</label>
<label>Mail</label>
<label>DNI</label>
<label>Usuario</label>
</div>
</div>
</form>


<form action="servletModificarUsuario" method="post">
<div style=" width:70%; height:100%; margin-left:10px">
<h1>EDITAR USUARIO</h1>
<div class="row">
<div class="col-4 p-2">
<label class="">DNI:</label>
</div>
<div class="col-4">
<input type="text" class="form-control" placeholder="DNI">
</div>
</div>


<div class="row">
<div class="col-4 p-2">
<label class="">CUIL:</label>
</div>
<div class="col-4">
<input type="text" class="form-control" placeholder="CUIL">
</div>
</div>


<div class="row">
<div class="col-4 p-2">
<label class="">CUIL:</label>
</div>
<div class="col-4">
<input type="text" class="form-control" placeholder="NOMBRE">
</div>
</div>


<div class="row">
<div class="col-4 p-2">
<label class="">APELLIDO:</label>
</div>
<div class="col-4">
<input type="text" class="form-control" placeholder="APELLIDO">
</div>
</div>


<div class="row">
<div class="col-4 p-2">
<label class="">SEXO:</label>
</div>
<div class="col-4">
<input type="text" class="form-control" placeholder="SEXO">
</div>
</div>


<div class="row">
<div class="col-4 p-2">
<label class="">FECHA NACIMIENTO:</label>
</div>
<div class="col-4 ">
<input type="text" class="form-control" placeholder="FECHA NACIMIENTO">
</div>
</div>


<div class="row">
<div class="col-4 p-2">
<label class="">DIRECCION:</label>
</div>
<div class="col-4">
<input type="text" class="form-control" placeholder="DIRECCION">
</div>
</div>


<div class="row">
<div class="col-4 p-2">
<label class="">LOCALIDAD:</label>
</div>
<div class="col-4">
<input type="text" class="form-control" placeholder="LOCALIDAD">
</div>
</div>


<div class="row">
<div class="col-4 p-2">
<label class="">PROVINCIA:</label>
</div>
<div class="col-4">
<input type="text" class="form-control" placeholder="PROVINCIA">
</div>
</div>


<div class="row">
<div class="col-4 p-2">
<label class="">MAIL:</label>
</div>
<div class="col-4">
<input type="text" class="form-control" placeholder="MAIL">
</div>
</div>


<div class="row">
<div class="col-4 p-2">
<label class="">NOMBRE DE USUARIO:</label>
</div>
<div class="col-4">
<input type="text" class="form-control" placeholder="NOMBRE DE USUARIO">
</div>
</div>


<div class="row">
<div class="col-4 p-2">
<label class="">CONTRASEÑA:</label>
</div>
<div class="col-4">
<input type="text" class="form-control" placeholder="CONTRASEÑA">
</div>
</div>

<div class="row">
		<div class="col-12">
		<div style="text-align:center">
		<input class="btn btn-success"  type="submit" id="btnIngresar" name="Modificar" value="Modificar" style="margin: 50px 0 30px 0">
		</div>
		</div>

		
		
</div>
 </form>
</body>
</html>