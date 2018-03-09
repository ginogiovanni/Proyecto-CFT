<%-- 
    Document   : carreras
    Created on : 14-11-2017, 0:11:55
    Author     : Hawk
--%>

<%@page import="controlador.CarreraController"%>
<jsp:include page="../header.jsp"/>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="${pageContext.request.contextPath}/index.jsp">Panel</a>
    </li>
    <li class="breadcrumb-item active">Administrar Carreras</li>
</ol>
<div id="accordion" role="tablist" aria-multiselectable="true">
    <div class="card">
        <div class="card-header" role="tab" id="headingOne">
            <h5 class="mb-0">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseCarrera" aria-expanded="true" aria-controls="collapseOne">
                    <i class="fa fa-plus" aria-hidden="true"></i> Crear nueva Carrera
                </a>
            </h5>
        </div>

        <div id="collapseCarrera" class="collapse" role="tabpanel" aria-labelledby="headingOne">
            <div class="card-body">
                <form method="POST" id="frm-carrera" action="${pageContext.request.contextPath}/CrearCarrera">
                    <div class="form-group">
                        <label for="carrera">Nombre Carrera</label>
                        <input type="text" class="form-control" id="carrera" name="carrera" placeholder="Ej: Kinesiologia">
                    </div>
                    <input type="submit" value="Enviar" class="btn btn-primary" id="btn-registro">
                </form>
            </div>
        </div>
    </div>
</div><br>
<div class="row">
    <div class="col-12">
        <% CarreraController cc = new CarreraController();%>
        <%= cc.getCarreraVistaData() %>
    </div>
</div>        
<div id="accordion" role="tablist" aria-multiselectable="true">
    <div class="card">
        <div class="card-header" role="tab" id="headingOne">
            <h5 class="mb-0">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseModificarCarrera" aria-expanded="true" aria-controls="collapseOne">
                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i> Modificar personal
                </a>
            </h5>
        </div>
        <div id="collapseModificarCarrera" class="collapse" role="tabpanel" aria-labelledby="headingOne">
            <div class="card-body">
                <form method="POST" id="frm-modificarCarrera" action="${pageContext.request.contextPath}/ModificarCarrera">
                    <div class="form-group">
                        <label for="idM">ID</label>
                        <input type="text" class="form-control" id="idM" name="idM"  readonly="true">
                    </div>
                    <div class="form-group">
                        <label for="carreraM">Nombre Carrera</label>
                        <input type="text" class="form-control" id="carreraM" name="carreraM" >
                    </div>
                    <input type="submit" value="Modificar" class="btn btn-primary" id="btn-modificarCarrera-submit">
                </form>
            </div>
        </div>
    </div>
</div><br>        
<jsp:include page="../footer.jsp"/>

