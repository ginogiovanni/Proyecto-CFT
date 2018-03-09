<%-- 
    Document   : Contrato
    Created on : 19-11-2017, 16:15:58
    Author     : Hawk
--%>


<%@page import="controlador.ContratoController"%>
<jsp:include page="../header.jsp"/>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="${pageContext.request.contextPath}/index.jsp">Panel</a>
    </li>
    <li class="breadcrumb-item active">Administrar Ciclos</li>
</ol>
<div id="accordion" role="tablist" aria-multiselectable="true">
    <div class="card">
        <div class="card-header" role="tab" id="headingOne">
            <h5 class="mb-0">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseContrato" aria-expanded="true" aria-controls="collapseOne">
                    <i class="fa fa-plus" aria-hidden="true"></i> Crear nuevo contrato
                </a>
            </h5>
        </div>

        <div id="collapseContrato" class="collapse" role="tabpanel" aria-labelledby="headingOne">
            <div class="card-body">
                <form method="POST" id="frm-contrato" action="${pageContext.request.contextPath}/CrearContrato">
                    <div class="form-group">
                        <label for="rut">Rut Docente</label>
                        <input type="text" class="form-control" id="rut" name="rut" placeholder="Ej: 11.111.111-1">
                    </div>
                    <div class="form-group">
                        <label for="nombre">Nombre Docente</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ej: José">
                    </div>
                    <div class="form-group">
                        <label for="apellidos">Apellidos Docente</label>
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
                    <div class="form-group">
                        <label for="titulo">Titulo</label>
                        <input type="text" class="form-control" id="titulo" name="titulo" placeholder="Ej: Contador Auditor">
                    </div>
                    <div class="form-group">
                        <label for="duracion">Duracion Contrato</label>
                        <input type="text" class="form-control" id="duracion" name="duracion" placeholder="Ej: 4">
                    </div>
                    <div class="form-group">
                        <label for="salud">Salud</label>
                        <select class="form-control" id="salud" name="salud">
                            <option value="Fonasa">Fonasa</option>
                            <option value="Isapre">Isapre</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="sueldo">Sueldo Bruto</label>
                        <input type="text" class="form-control" id="sueldo" name="sueldo" placeholder="Ej: 480.000">
                    </div>
                    <input type="submit" value="Enviar" class="btn btn-primary" id="btn-registroContrato">
                </form>
            </div>
        </div>
    </div>
</div><br>

<div class="row">
    <div class="col-12">
        <% ContratoController cc = new ContratoController();%>
        <%= cc.getContratoVistaData()%>
    </div>
</div>   

<div id="accordion" role="tablist" aria-multiselectable="true">
    <div class="card">
        <div class="card-header" role="tab" id="headingOne">
            <h5 class="mb-0">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseModificarContrato" aria-expanded="true" aria-controls="collapseOne">
                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i> Modificar Contrato
                </a>
            </h5>
        </div>
        <div id="collapseModificarContrato" class="collapse" role="tabpanel" aria-labelledby="headingOne">
            <div class="card-body">
                <form method="POST" id="frm-modificarContrato" action="${pageContext.request.contextPath}/ModificarContrato">
                    <div class="form-group">
                        <label for="rutM">Rut Docente</label>
                        <input type="text" class="form-control" id="rutM" name="rutM" readonly="true">
                    </div>
                    <div class="form-group">
                        <label for="duracionM">Duracion Contrato</label>
                        <input type="text" class="form-control" id="duracionM" name="duracionM" placeholder="Ej: 4">
                    </div>
                    <div class="form-group">
                        <label for="saludM">Salud</label>
                        <select class="form-control" id="saludM" name="saludM">
                            <option value="Fonasa">Fonasa</option>
                            <option value="Isapre">Isapre</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="sueldoM">Sueldo Bruto</label>
                        <input type="text" class="form-control" id="sueldoM" name="sueldoM" placeholder="Ej: 480.000">
                    </div>
                    <input type="submit" value="Modificar" class="btn btn-primary" id="btn-modificarContrato-submit">
                </form>
            </div>
        </div>
    </div>
</div><br>  

<jsp:include page="../footer.jsp"/>
