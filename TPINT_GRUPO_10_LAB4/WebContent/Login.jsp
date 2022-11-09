<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
 <%@page import="entidades.Usuario"%>
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
<a href="Login.jsp" class="bi bi-bank" style="font-size: 6em;margin: 0.3% 0 0 40%; color:black" > </a>
<a href="Login.jsp" type=button style="margin: 1% 0 0 0; color:black"><h1 style="font-size: 400%">ONLY BANK</h1></a>
</header>
</head>

</head>





<body style="background:#EBF5FB">
  <div class="Center" >

      <form action="servletLogin" method="get" class="Form">
        
         <h1 class="form-text text-muted" style="text-align:center" >INICIAR SESION</h1>
        
        

        <div class="row">
		<div class="col-12">
		<input  type="number" class="form-control" name="txtDNI" placeholder="Numero de documento" style="margin: 50px 0 0 0" required>
		</div>
		</div>
		
		
		
        <div class="row">
		<div class="col-12">
		<input  type="text" class="form-control" name="txtUsuario" placeholder="Nombre de Usuario" style="margin: 50px 0 0 0" required>
		</div>
		</div>
        
        
        <div class="row">
		<div class="col-12">
		<input type="password" class="form-control" name="txtClave" placeholder="Clave" style="margin: 50px 0 10px 0" required>
		</div>
		</div>
        
        <div class="row">
        <div class="col-12">
        <%!String LabelMensaje=""; %>
        <label name="lblMensaje" Text="Esto es un texto" value="Usuario Incorrecto" runat="server" style="color:red"><%=LabelMensaje %></label>
        </div>
        </div>
          
        <div class="row">
		<div class="col-12">
		<a href="RecuperarClave" class="Campos" >Olvide mi contraseña o usuario</a>
		</div>
		</div>
        
        
        <div class="row">
		<div class="col-12">
		<div style="text-align:center">
		<input  type="submit" class="btn btn-primary" name="btnIngresar" value="Ingresar" style="margin: 50px 0 30px 0">
		</div>
		</div>
		</div>  
      
      </form>
    </div>
  
</body>

<% 
	String Mensaje = "";
	if(request.getAttribute("Mensaje")!=null)
	{
		Mensaje = request.getAttribute("Mensaje").toString();
		if(Mensaje.equals("OK")) {
			LabelMensaje="";
			response.sendRedirect("Login.jsp");
		}
		else 
			{
			LabelMensaje=request.getAttribute("Mensaje").toString();
			response.sendRedirect("Login.jsp");
			}
	}
	if(session.getAttribute("NombreUsuario")!=null)
	{
		
	}
		%>


</html>