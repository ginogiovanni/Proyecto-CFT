<%-- 
    Document   : adminPersonal
    Created on : 27-10-2017, 1:36:17
    Author     : Hawk
--%>

<%@page import="controlador.PersonalController"%>
<jsp:include page="../header.jsp"/>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="${pageContext.request.contextPath}/index.jsp">Panel</a>
    </li>
    <li class="breadcrumb-item active">Administrar Personal</li>
</ol>
<div id="accordion" role="tablist" aria-multiselectable="true">
    <div class="card">
        <div class="card-header" role="tab" id="headingOne">
            <h5 class="mb-0">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                    <i class="fa fa-plus" aria-hidden="true"></i> Crear nuevo personal
                </a>
            </h5>
        </div>

        <div id="collapseOne" class="collapse" role="tabpanel" aria-labelledby="headingOne">
            <div class="card-body">
                <form method="POST" id="frm-personal" action="${pageContext.request.contextPath}/CrearPersonal">
                    <div class="form-group">
                        <label for="rut">Rut</label>
                        <input type="text" class="form-control" id="rut" name="rut" placeholder="Ej: 11.111.111-1">
                    </div>
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ej: José">
                    </div>
                    <div class="form-group">
                        <label for="apellidos">Apellidos</label>
                        <input type="text" class="form-control" id="apellidos" name="apellidos" placeholder="Ej: Perez Ponce">
                    </div>
                    <div class="form-group">
                        <label for="sexo">Género</label>
                        <select class="form-control" id="sexo" name="sexo">
                            <option value="Masculino">Masculino</option>
                            <option value="Femenino">Femenino</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="direccion">Dirección</label>
                        <input type="text" class="form-control" id="direccion" name="direccion" placeholder="Ej: Las Camelias 1122">
                    </div>
                    <div class="form-group">
                        <label for="telefono">Teléfono</label>
                        <input type="text" class="form-control" id="telefono" name="telefono" placeholder="Ej: 226418756">
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="Ej: jperez@email.com">
                    </div>
                    <input type="submit" value="Enviar" class="btn btn-primary" id="btn-registro">
                </form>
            </div>
        </div>
    </div>
</div><br>
<div class="row">
    <div class="col-12">
        <% PersonalController cp = new PersonalController();%>
        <%= cp.getPersonalVistaData()%>
    </div>
</div>
<div id="accordion" role="tablist" aria-multiselectable="true">
    <div class="card">
        <div class="card-header" role="tab" id="headingOne">
            <h5 class="mb-0">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseModificar" aria-expanded="true" aria-controls="collapseOne">
                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i> Modificar personal
                </a>
            </h5>
        </div>
        <div id="collapseModificar" class="collapse" role="tabpanel" aria-labelledby="headingOne">
            <div class="card-body">
                <form method="POST" id="frm-modificarPersonal" action="${pageContext.request.contextPath}/ModificarPersonal">
                    <div class="form-group">
                        <label for="rut">Rut</label>
                        <input type="text" class="form-control" id="rutM" name="rutM" placeholder="Ej: 11.111.111-1" readonly="true">
                    </div>
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" id="nombreM" name="nombreM" placeholder="Ej: José">
                    </div>
                    <div class="form-group">
                        <label for="apellidos">Apellidos</label>
                        <input type="text" class="form-control" id="apellidosM" name="apellidosM" placeholder="Ej: Perez Ponce">
                    </div>
                    <div class="form-group">
                        <label for="sexo">Género</label>
                        <select class="form-control" id="sexoM" name="sexoM">
                            <option value="Masculino">Masculino</option>
                            <option value="Femenino">Femenino</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="direccion">Dirección</label>
                        <input type="text" class="form-control" id="direccionM" name="direccionM" placeholder="Ej: Las Camelias 1122">
                    </div>
                    <div class="form-group">
                        <label for="telefono">Teléfono</label>
                        <input type="text" class="form-control" id="telefonoM" name="telefonoM" placeholder="Ej: 226418756">
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="emailM" name="emailM" placeholder="Ej: jperez@email.com">
                    </div>
                    <input type="submit" value="Modificar" class="btn btn-primary" id="btn-modificarPersonal-submit">
                </form>
            </div>
        </div>
    </div>
</div><br>
<jsp:include page="../footer.jsp"/>