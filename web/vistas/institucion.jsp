<%-- 
    Document   : institucion
    Created on : 15-11-2017, 0:01:23
    Author     : Hawk
--%>


<%@page import="controlador.InstitucionController"%>
<jsp:include page="../header.jsp"/>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="${pageContext.request.contextPath}/index.jsp">Panel</a>
    </li>
    <li class="breadcrumb-item active">Administrar Instituciones</li>
</ol>
<div id="accordion" role="tablist" aria-multiselectable="true">
    <div class="card">
        <div class="card-header" role="tab" id="headingOne">
            <h5 class="mb-0">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseInstitucion" aria-expanded="true" aria-controls="collapseOne">
                    <i class="fa fa-plus" aria-hidden="true"></i> Crear nueva institución
                </a>
            </h5>
        </div>

        <div id="collapseInstitucion" class="collapse" role="tabpanel" aria-labelledby="headingOne">
            <div class="card-body">
                <form method="POST" id="frm-institucion" action="${pageContext.request.contextPath}/CrearInstitucion">
                    <div class="form-group">
                        <label for="institucion">Nombre Institucion</label>
                        <input type="text" class="form-control" id="institucion" name="institucion" placeholder="Ej: Kinesiologia">
                    </div>
                    <input type="submit" value="Enviar" class="btn btn-primary" id="btn-registro">
                </form>
            </div>
        </div>
    </div>
</div><br>
<div class="row">
    <div class="col-12">
        <% InstitucionController ic = new InstitucionController();%>
        <%= ic.getInstitucionVistaData() %>
    </div>
</div>        
<div id="accordion" role="tablist" aria-multiselectable="true">
    <div class="card">
        <div class="card-header" role="tab" id="headingOne">
            <h5 class="mb-0">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseModificarInstitucion" aria-expanded="true" aria-controls="collapseOne">
                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i> Modificar Institucion
                </a>
            </h5>
        </div>
        <div id="collapseModificarInstitucion" class="collapse" role="tabpanel" aria-labelledby="headingOne">
            <div class="card-body">
                <form method="POST" id="frm-modificarInstitucion" action="${pageContext.request.contextPath}/ModificarInstitucion">
                    <div class="form-group">
                        <label for="idM">ID</label>
                        <input type="text" class="form-control" id="idM" name="idM"  readonly="true">
                    </div>
                    <div class="form-group">
                        <label for="institucionM">Nombre Institución</label>
                        <input type="text" class="form-control" id="institucionM" name="institucionM" >
                    </div>
                    <input type="submit" value="Modificar" class="btn btn-primary" id="btn-modificarInstitucion-submit">
                </form>
            </div>
        </div>
    </div>
</div><br>        
<jsp:include page="../footer.jsp"/>