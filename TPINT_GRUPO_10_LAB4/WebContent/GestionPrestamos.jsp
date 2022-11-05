<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<h1>GESTION DE PRESTAMOS</h1>

<div class="container">
<div class="row">
<div class="col">
      </div>
   </div>
   <p class="font-weight-bold">CUOTAS A RECIBIR: </p><select name="TiposCuotas">
           <option>Selecciona una Cuota</option>
           <option>1</option>
           <option>3</option>
           <option>6</option>
           <option>12</option>
</select>
<br><br>

<p class="font-weight-bold">NUMERO DE CUENTA: <input type="text" name="txtNumeroCuenta">
<br><br>

<p class="font-weight-bold">TIPO DE CUENTA: <select name="TipoCuenta" >
                <option>Selecciona un Tipo de Cuenta</option>
</select>

<br><br>
<p class="font-weight-bold">MONTO: <input type="text" name="txtMonto">
<br><br>
<p class="font-weight-bold">FECHA: <input type="date" "name=fecha"> <br><br>
<input type="submit" name="btnAceptar" value="Aceptar">  <input type="submit" name="btnVolverInicio" value="VolverAInicio">  
</div>

</body>
</html>