<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>Login</title>




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

</head>





<body style="background:#EBF5FB">
  <div class="Center" >

      <form  class="Form"  >
        
         <h1 class="form-text text-muted" style="text-align:center" >INICIAR SESION</h1>
        

        <div class="row">
		<div class="col-12">
		<input  type="text" class="form-control" id="txtDNI" placeholder="Numero de documento" style="margin: 50px 0 0 0">
		</div>
		</div>
		
		
		
        <div class="row">
		<div class="col-12">
		<input  type="text" class="form-control" id="txtUsuario" placeholder="Nombre de Usuario" style="margin: 50px 0 0 0">
		</div>
		</div>
        
        
        <div class="row">
		<div class="col-12">
		<input type="password" class="form-control" id="txtClave" placeholder="Clave" style="margin: 50px 0 50px 0">
		</div>
		</div>
        
        
        <div class="row">
		<div class="col-12">
		<a class="Campos" >Olvide mi contraseña o usuario</a>
		</div>
		</div>
        
        
        <div class="row">
		<div class="col-12">
		<div style="text-align:center">
		<input class="btn btn-primary" type="button" id="btnIngresar" value="Ingresar" style="margin: 50px 0 30px 0">
		</div>
		</div>
		</div>  
      
      </form>
    </div>
  
</body>
</html>