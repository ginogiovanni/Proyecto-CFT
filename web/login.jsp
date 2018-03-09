<%-- 
    Document   : login.jsp
    Created on : 22-11-2017, 22:23:38
    Author     : Hawk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>SB Admin - Start Bootstrap Template</title>
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
  
</head>

<body class="bg-dark">
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Iniciar Sesión </div>
      <img src="img/logoCFTJMC.png" width="100" style="margin: 0 auto;" alt=""/>
      <div class="card-body">
        <form  method="POST" id="frm-login" action="Autenticar">
          <div class="form-group">
            <label for="usuario">Usuario</label>
            <input class="form-control" id="usuario" name="usuario" type="text" aria-describedby="emailHelp" placeholder="Nombre de usuario">
          </div>
          <div class="form-group">
              <label for="password">Contraseña</label>
            <input class="form-control" id="password" type="password" name="password" placeholder="Contraseña">
          </div>
      <button class="btn btn-lg btn-success btn-block" type="submit" id="btn-registro">Login</button> 
        </form>
          <span id="msg"></span>
      </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
<!-- Core plugin JavaScript-->
<script src="${pageContext.request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>
<!-- Custom scripts for Datatables -->
<script src="${pageContext.request.contextPath}/vendor/datatables/jquery.dataTables.js"></script>
<script src="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.js"></script>

<!-- Custom scripts for all pages-->
<script src="${pageContext.request.contextPath}/js/tablas.js"></script>

<script src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.rut.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/main.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/js/main.js" type="text/javascript"></script>
</body>

</html>
