<%-- 
    Document   : ciclo
    Created on : 18-11-2017, 1:48:20
    Author     : Hawk
--%>

<%@page import="controlador.CarreraController"%>
<%@page import="controlador.CicloController"%>
<jsp:include page="../header.jsp"/>
<% CarreraController c = new CarreraController();%>
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
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseCiclo" aria-expanded="true" aria-controls="collapseOne">
                    <i class="fa fa-plus" aria-hidden="true"></i> Crear nueva institución
                </a>
            </h5>
        </div>

        <div id="collapseCiclo" class="collapse" role="tabpanel" aria-labelledby="headingOne">
            <div class="card-body">
                <form method="POST" id="frm-ciclo" action="${pageContext.request.contextPath}/CrearCiclo">
                    <div class="form-group">
                        <label for="cod_ciclo">Codigo Ciclo</label>
                        <input type="text" class="form-control" id="cod_ciclo" name="cod_ciclo" placeholder="Ej: C001">
                    </div>
                    <div class="form-group">
                        <label for="desc_ciclo">Descripcion</label>
                        <input type="text" class="form-control" id="desc_ciclo" name="desc_ciclo" placeholder="Ej: INF0117V">
                    </div>
                    <div class="form-group">
                        <label for="anio">Año del Ciclo</label>
                        <input type="text" class="form-control" id="anio" name="anio" placeholder="Ej: 2017">
                    </div>
                    <div class="form-group">
                        <label for="carrera">Carrera</label>
                        <select class="form-control" id="carrera" name="carrera">
                            <%= c.getCarreraSelect()%>
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
        <% CicloController ci = new CicloController();%>
        <%= ci.getCicloVistaData()%>
    </div>
</div>   

<div id="accordion" role="tablist" aria-multiselectable="true">
    <div class="card">
        <div class="card-header" role="tab" id="headingOne">
            <h5 class="mb-0">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseModificarCiclo" aria-expanded="true" aria-controls="collapseOne">
                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i> Modificar Institucion
                </a>
            </h5>
        </div>
        <div id="collapseModificarCiclo" class="collapse" role="tabpanel" aria-labelledby="headingOne">
            <div class="card-body">
                <form method="POST" id="frm-modificarCiclo" action="${pageContext.request.contextPath}/ModificarCiclo">
                    <div class="form-group">
                        <label for="cod_cicloM">Codigo Ciclo</label>
                        <input type="text" class="form-control" id="cod_cicloM" name="cod_cicloM" placeholder="Ej: C001" readonly="true">
                    </div>
                    <div class="form-group">
                        <label for="desc_cicloM">Descripcion</label>
                        <input type="text" class="form-control" id="desc_cicloM" name="desc_cicloM" placeholder="Ej: INF0117V">
                    </div>
                    <div class="form-group">
                        <label for="anioM">Año del Ciclo</label>
                        <input type="text" class="form-control" id="anioM" name="anioM" placeholder="Ej: 2017">
                    </div>
                    <input type="submit" value="Modificar" class="btn btn-primary" id="btn-modificarCiclo-submit">
                </form>
            </div>
        </div>
    </div>
</div><br>  

<jsp:include page="../footer.jsp"/>