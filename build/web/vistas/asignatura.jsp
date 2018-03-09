<%-- 
    Document   : asignatura
    Created on : 18-11-2017, 16:42:11
    Author     : Hawk
--%>

<%@page import="controlador.AsignaturaController"%>
<jsp:include page="../header.jsp"/>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="${pageContext.request.contextPath}/index.jsp">Panel</a>
    </li>
    <li class="breadcrumb-item active">Administrar Asignaturas</li>
</ol>
<div id="accordion" role="tablist" aria-multiselectable="true">
    <div class="card">
        <div class="card-header" role="tab" id="headingOne">
            <h5 class="mb-0">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseAsignatura" aria-expanded="true" aria-controls="collapseOne">
                    <i class="fa fa-plus" aria-hidden="true"></i> Crear nueva asignatura
                </a>
            </h5>
        </div>

        <div id="collapseAsignatura" class="collapse" role="tabpanel" aria-labelledby="headingOne">
            <div class="card-body">
                <form method="POST" id="frm-asignatura" action="${pageContext.request.contextPath}/CrearAsignatura">
                    <div class="form-group">
                        <label for="asignatura">Nombre Asignatura</label>
                        <input type="text" class="form-control" id="asignatura" name="asignatura" placeholder="Ej: Matematicas">
                    </div>
                    <input type="submit" value="Enviar" class="btn btn-primary" id="btn-registro">
                </form>
            </div>
        </div>
    </div>
</div><br>

<div class="row">
    <div class="col-12">
        <% AsignaturaController ac = new AsignaturaController();%>
        <%= ac.getAsignaturaVistaData() %>
    </div>
</div>  
<div id="accordion" role="tablist" aria-multiselectable="true">
    <div class="card">
        <div class="card-header" role="tab" id="headingOne">
            <h5 class="mb-0">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseModificarAsignatura" aria-expanded="true" aria-controls="collapseOne">
                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i> Modificar asignatura
                </a>
            </h5>
        </div>
        <div id="collapseModificarAsignatura" class="collapse" role="tabpanel" aria-labelledby="headingOne">
            <div class="card-body">
                <form method="POST" id="frm-modificarAsignatura" action="${pageContext.request.contextPath}/ModificarAsignatura">
                    <div class="form-group">
                        <label for="idM">ID</label>
                        <input type="text" class="form-control" id="idM" name="idM"  readonly="true">
                    </div>
                    <div class="form-group">
                        <label for="asignaturaM">Nombre asignatura</label>
                        <input type="text" class="form-control" id="asignaturaM" name="asignaturaM" >
                    </div>
                    <input type="submit" value="Modificar" class="btn btn-primary" id="btn-modificarAsignatura-submit">
                </form>
            </div>
        </div>
    </div>
</div><br>       
    
<jsp:include page="../footer.jsp"/>