<%-- 
    Document   : AlumnosVista
    Created on : 23-11-2017, 2:47:02
    Author     : Hawk
--%>

<%@page import="include.Usuario"%>
<%@page import="controlador.AlumnoVistaController"%>
<%@page import="controlador.InstitucionController"%>
<jsp:include page="../header.jsp"/>
<% HttpSession sesion = request.getSession(true);
    Object nombreUsuario = sesion.getAttribute("nombreUsuario") == null ? null : sesion.getAttribute("nombreUsuario");
    Usuario u = new Usuario(nombreUsuario.toString()); %>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="${pageContext.request.contextPath}/index.jsp">Panel</a>
    </li>
    <li class="breadcrumb-item active">Alumno</li>
</ol>

<div class="row">
    <div class="col-12">
        <% AlumnoVistaController ic = new AlumnoVistaController();%>
        <%= ic.getAlumnoVistaData(u) %>
    </div>
</div>        
      
<jsp:include page="../footer.jsp"/>