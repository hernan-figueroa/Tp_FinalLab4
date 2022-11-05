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
<i class="bi bi-bank" style="font-size: 6em;margin: 10px 0 0 10%"> </i>
<h1 style="margin: 3% 0 0 0">ONLY BANK</h1>
<a class="Campos" style="color:black;margin: 4% 0 0 50%"><h5>Registrar Usuario</h5></a>
<i class="bi bi-person-plus-fill" style="font-size:2em; margin: 4% 0 0 0.5%"></i>
<a class="Campos" style="color:black;margin: 4% 0 0 1%"><h5>Salir</h5></a>
<i class="bi bi-box-arrow-right"style="font-size:2em; margin: 4% 0 0 0.5%"/></i>
</header>
</head>



<body style="background:#EBF5FB">
<div id="BuscarUsuario" style="">
<label >Usuario a modificar:</label>
<input  type="text" style="margin:10px 0 0 0; border-radius: 0.1rem;"> 
<input class="btn btn-secondary" type="button" value="Aceptar" style="height:40px; margin:0 0 10px 0">

<div id="divFiltro" class="form-control" style="display:none;justify-content:space-between; width:70%;position:absolute; margin:0 0 15% 15%">
<label>Nombre </label>
<label>Apellido</label>
<label>Mail</label>
<label>DNI</label>
<label>Usuario</label>
</div>
</div>




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
		<input class="btn btn-success" type="button" id="btnIngresar" value="Modificar" style="margin: 50px 0 30px 0">
		</div>
		</div>

		
		
</div>
 </form>
</body>
</html>