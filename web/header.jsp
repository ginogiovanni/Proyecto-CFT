<%-- 
    Document   : header
    Created on : 27-10-2017, 1:21:32
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
        <title>CFT José Miguel Carrera | Panel</title>
        <!-- Bootstrap core CSS-->
        <link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="${pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- Custom Styles for Datatables -->
        <link href="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
        <!-- Custom styles for this template-->
        <link href="${pageContext.request.contextPath}/css/sb-admin.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>


    </head>

    <body class="fixed-nav sticky-footer bg-dark" id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">CFT José Miguel Carrera</a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
                <%
                    HttpSession sesion = request.getSession(true);
                    Object tipoUsuario = sesion.getAttribute("tipoUsuario") == null ? null : sesion.getAttribute("tipoUsuario");
                    Object nombreUsuario = sesion.getAttribute("nombreUsuario") == null ? null : sesion.getAttribute("nombreUsuario");

                    if (tipoUsuario.equals("Personal")) {


                %>
                

                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                        <a class="nav-link" href="${pageContext.request.contextPath}/vistas/matriculas.jsp">
                            <i class="fa fa-file" aria-hidden="true"></i>
                            <span class="nav-link-text">Matrículas</span>
                        </a>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                        <a class="nav-link" href="${pageContext.request.contextPath}/vistas/contrato.jsp">
                            <i class="fa fa-address-card-o" aria-hidden="true"></i>
                            <span class="nav-link-text">Contrato</span>
                        </a>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                        <a class="nav-link" href="${pageContext.request.contextPath}/vistas/mantAsignatura.jsp">
                            <i class="fa fa-sign-language" aria-hidden="true"></i>
                            <span class="nav-link-text">Mantenedor Asignaturas</span>
                        </a>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                        <a class="nav-link" href="${pageContext.request.contextPath}/vistas/DetallePagoTotal.jsp">
                            <i class="fa fa-money" aria-hidden="true"></i>
                            <span class="nav-link-text">Generar Pagos</span>
                        </a>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Components">
                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseComponents" data-parent="#exampleAccordion">
                            <i class="fa fa-bars" aria-hidden="true"></i>
                            <span class="nav-link-text">Administrar</span>
                        </a>
                        <ul class="sidenav-second-level collapse" id="collapseComponents">
                            <li>
                                <a href="${pageContext.request.contextPath}/vistas/adminPersonal.jsp">Personal</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/vistas/adminAlumnos.jsp">Alumnos</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/vistas/carreras.jsp">Carreras</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/vistas/ciclo.jsp">Ciclos</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/vistas/asignatura.jsp">Asignatura</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/vistas/docente.jsp">Docentes</a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Example Pages">
                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseExamplePages" data-parent="#exampleAccordion">
                            <i class="fa fa-users" aria-hidden="true"></i>
                            <span class="nav-link-text">Usuarios</span>
                        </a>
                        <ul class="sidenav-second-level collapse" id="collapseExamplePages">
                            <li>
                                <a href="${pageContext.request.contextPath}/vistas/usuarios_personal.jsp">Usuarios Personal</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/vistas/usuarios_alumnos.jsp">Usuarios Alumnos</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/vistas/usuarios_docentes.jsp">Usuarios Docente</a>
                            </li>                            
                        </ul>
                    </li>
                
                <% }
                    if (tipoUsuario.equals("Alumno")) {
                %>
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                    <a class="nav-link" href="${pageContext.request.contextPath}/vistas/AlumnosVista.jsp">
                        <i class="fa fa-home" aria-hidden="true"></i>
                        <span class="nav-link-text">Inicio</span>
                    </a>
                </li>
                <% } %>
                <% 
                    if (tipoUsuario.equals("Docente")) {
                %>
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                    <a class="nav-link" href="${pageContext.request.contextPath}/vistas/DocentesVista.jsp">
                        <i class="fa fa-home" aria-hidden="true"></i>
                        <span class="nav-link-text">Inicio</span>
                    </a>
                </li>
                <% } %>
                </ul>
                <ul class="navbar-nav sidenav-toggler">
                    <li class="nav-item">
                        <a class="nav-link text-center" id="sidenavToggler">
                            <i class="fa fa-fw fa-angle-left"></i>
                        </a>
                    </li>
                </ul>
                <ul class="navbar-nav ml-auto">

                    <li class="nav-item">
                        <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
                            <i class="fa fa-fw fa-sign-out"></i>Logout</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="content-wrapper">
            <div class="container-fluid">
