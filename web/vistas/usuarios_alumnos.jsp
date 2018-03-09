<%-- 
    Document   : usuarios_alumnos
    Created on : 23-11-2017, 1:27:11
    Author     : Hawk
--%>

<%@page import="controlador.AlumnoController"%>
<%@page import="controlador.UsuariosAlumnoController"%>
<%@page import="controlador.PersonalController"%>
<jsp:include page="../header.jsp"/>
<% AlumnoController pc = new AlumnoController();%>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="${pageContext.request.contextPath}/index.jsp">Panel</a>
    </li>
    <li class="breadcrumb-item active">Administrar Usuarios Alumnos</li>
</ol>
<div id="accordion" role="tablist" aria-multiselectable="true">
    <div class="card">
        <div class="card-header" role="tab" id="headingOne">
            <h5 class="mb-0">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseUsuariosPersonal" aria-expanded="true" aria-controls="collapseOne">
                    <i class="fa fa-plus" aria-hidden="true"></i> Crear nuevo usuario alumno
                </a>
            </h5>
        </div>

        <div id="collapseUsuariosPersonal" class="collapse" role="tabpanel" aria-labelledby="headingOne">
            <div class="card-body">
                <form method="POST" id="frm-usuariosAlumno" action="${pageContext.request.contextPath}/CrearUsuariosPersonal">
                    <div class="form-group">
                        <label for="usuario">Nombre usuario</label>
                        <input type="text" class="form-control" id="usuario" name="usuario" placeholder="Ej: csepulveda">
                    </div>
                    <div class="form-group">
                        <label for="password">Contrase�a</label>
                        <input type="text" class="form-control" id="password" name="password" placeholder="Ej: 12345678">
                    </div>
                    <div class="form-group">
                        <label for="tipo">Tipo de usuario</label>
                        <select class="form-control" id="tipo" name="tipo">
                            <option value="Personal">Personal</option>
                            <option value="Docente">Docente</option>                            
                            <option value="Alumno">Alumno</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="rut">Seleccione Alumno</label>
                        <select class="form-control" id="rut" name="rut">
                           <%= pc.getAlumnoSelect()%>
                        </select>
                    </div>
                    <input type="submit" value="Enviar" class="btn btn-primary" id="btn-registro">
                </form>
            </div>
        </div>
    </div>
</div><br>
<div class="row">
    <div class="col-12">
        <% UsuariosAlumnoController ic = new UsuariosAlumnoController();%>
        <%= ic.getPersonalVistaData() %>
    </div>
</div>        
<div id="accordion" role="tablist" aria-multiselectable="true">
    <div class="card">
        <div class="card-header" role="tab" id="headingOne">
            <h5 class="mb-0">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseModificarUsuario" aria-expanded="true" aria-controls="collapseOne">
                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i> Modificar Usuario Alumno
                </a>
            </h5>
        </div>
        <div id="collapseModificarUsuario" class="collapse" role="tabpanel" aria-labelledby="headingOne">
            <div class="card-body">
                <form method="POST" id="frm-modificarUsuarioAlumno" action="${pageContext.request.contextPath}/ModificarUsuario">
                    <div class="form-group">
                        <label for="idM">ID</label>
                        <input type="text" class="form-control" id="idM" name="idM"  readonly="true">
                    </div>
                    <div class="form-group">
                        <label for="usuarioM">Nombre usuario</label>
                        <input type="text" class="form-control" id="usuarioM" name="usuarioM" placeholder="Ej: csepulveda">
                    </div>
                    <div class="form-group">
                        <label for="passwordM">Contrase�a</label>
                        <input type="text" class="form-control" id="passwordM" name="passwordM" placeholder="Ej: 12345678">
                    </div>
                    <div class="form-group">
                        <label for="tipoM">Tipo de usuario</label>
                        <select class="form-control" id="tipoM" name="tipoM">
                            <option value="Personal">Personal</option>
                            <option value="Docente">Docente</option>                            
                            <option value="Alumno">Alumno</option>
                        </select>
                    </div>
                    <input type="submit" value="Modificar" class="btn btn-primary" id="btn-modificaruUsuario-submit">
                </form>
            </div>
        </div>
    </div>
</div><br>        
<jsp:include page="../footer.jsp"/>