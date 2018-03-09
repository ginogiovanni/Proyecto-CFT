<%-- 
    Document   : mantAsignatura
    Created on : 19-11-2017, 22:23:00
    Author     : Hawk
--%>

<%@page import="controlador.AsignaturaController"%>
<%@page import="controlador.AlumnoController"%>
<%@page import="controlador.CicloController"%>
<%@page import="controlador.MantAsignaturaController"%>
<% CicloController c = new CicloController();%>
<% AsignaturaController a = new AsignaturaController();%>
<jsp:include page="../header.jsp"/>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="${pageContext.request.contextPath}/index.jsp">Panel</a>
    </li>
    <li class="breadcrumb-item active">Mantenedor de asignaturas</li>
</ol>
<div id="accordion" role="tablist" aria-multiselectable="true">
    <div class="card">
        <div class="card-header" role="tab" id="headingOne">
            <h5 class="mb-0">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseMantAsignatura" aria-expanded="true" aria-controls="collapseOne">
                    <i class="fa fa-plus" aria-hidden="true"></i> Crear nuevo
                </a>
            </h5>
        </div>

        <div id="collapseMantAsignatura" class="collapse" role="tabpanel" aria-labelledby="headingOne">
            <div class="card-body">
                <form method="POST" id="frm-mantAsignatura" action="${pageContext.request.contextPath}/CrearMantAsignatura">
                    <div class="form-group">
                        <label for="rutDocente">Rut Docente</label>
                        <input type="text" class="form-control" id="rutDocente" name="rutDocente" placeholder="Ej: 11.111.111-1">
                    </div>
                    <div class="form-group">
                        <label for="ciclo">Ciclo</label>
                        <select class="form-control" id="ciclo" name="ciclo">
                            <%= c.getCicloSelect()%>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="asignatura">Asignatura</label>
                        <select class="form-control" id="asignatura" name="asignatura">
                            <%= a.getAsignaturaSelect() %>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="rutAlumno">Rut Alumno</label>
                        <input type="text" class="form-control" id="rutAlumno" name="rutAlumno" placeholder="Ej: 11.111.111-1">
                    </div>
                    <input type="submit" value="Enviar" class="btn btn-primary" id="btn-registro">
                </form>
            </div>
        </div>
    </div>
</div><br>
<div class="row">
    <div class="col-12">
        <% MantAsignaturaController mac = new MantAsignaturaController();%>
        <%= mac.getMantAsignaturaVistaData()%>
    </div>
</div>        
      
<jsp:include page="../footer.jsp"/>