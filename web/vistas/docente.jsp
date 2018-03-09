<%-- 
    Document   : docente
    Created on : 18-11-2017, 22:11:56
    Author     : Hawk
--%>

<%@page import="controlador.DocenteController"%>
<jsp:include page="../header.jsp"/>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="${pageContext.request.contextPath}/index.jsp">Panel</a>
    </li>
    <li class="breadcrumb-item active">Administrar Docente</li>
</ol>

<div class="row">
    <div class="col-12">
        <% DocenteController dc = new DocenteController();%>
        <%= dc.getDocenteVistaData() %>
    </div>
</div>
<div id="accordion" role="tablist" aria-multiselectable="true">
    <div class="card">
        <div class="card-header" role="tab" id="headingOne">
            <h5 class="mb-0">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseModificarDocente" aria-expanded="true" aria-controls="collapseOne">
                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i> Modificar docente
                </a>
            </h5>
        </div>
        <div id="collapseModificarDocente" class="collapse" role="tabpanel" aria-labelledby="headingOne">
            <div class="card-body">
                <form method="POST" id="frm-modificarDocente" action="${pageContext.request.contextPath}/ModificarDocente">
                    <div class="form-group">
                        <label for="rutM">Rut</label>
                        <input type="text" class="form-control" id="rutM" name="rutM" placeholder="Ej: 11.111.111-1" readonly="true">
                    </div>
                    <div class="form-group">
                        <label for="nombreM">Nombre</label>
                        <input type="text" class="form-control" id="nombreM" name="nombreM" placeholder="Ej: José">
                    </div>
                    <div class="form-group">
                        <label for="apellidosM">Apellidos</label>
                        <input type="text" class="form-control" id="apellidosM" name="apellidosM" placeholder="Ej: Perez Ponce">
                    </div>
                    <div class="form-group">
                        <label for="sexoM">Género</label>
                        <select class="form-control" id="sexoM" name="sexoM">
                            <option value="Masculino">Masculino</option>
                            <option value="Femenino">Femenino</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="direccionM">Dirección</label>
                        <input type="text" class="form-control" id="direccionM" name="direccionM" placeholder="Ej: Las Camelias 1122">
                    </div>
                    <div class="form-group">
                        <label for="telefonoM">Teléfono</label>
                        <input type="text" class="form-control" id="telefonoM" name="telefonoM" placeholder="Ej: 226418756">
                    </div>
                    <div class="form-group">
                        <label for="emailM">Email</label>
                        <input type="email" class="form-control" id="emailM" name="emailM" placeholder="Ej: jperez@email.com">
                    </div>
                    <div class="form-group">
                        <label for="tituloM">Titulo</label>
                        <input type="text" class="form-control" id="tituloM" name="tituloM" placeholder="Ej: Ingeniero Informatico">
                    </div>
                    <input type="submit" value="Modificar" class="btn btn-primary" id="btn-modificarDocente-submit">
                </form>
            </div>
        </div>
    </div>
</div><br>
<jsp:include page="../footer.jsp"/>