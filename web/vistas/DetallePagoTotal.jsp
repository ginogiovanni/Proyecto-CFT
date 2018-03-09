<%-- 
    Document   : DetallePagoTotal
    Created on : 20-11-2017, 0:29:59
    Author     : Hawk
--%>

<%@page import="controlador.ContratoController"%>
<%@page import="controlador.DetallePagoControllador"%>
<% ContratoController cc = new ContratoController();%>
<jsp:include page="../header.jsp"/>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="${pageContext.request.contextPath}/index.jsp">Panel</a>
    </li>
    <li class="breadcrumb-item active">Administrar Pagos</li>
</ol>
<div id="accordion" role="tablist" aria-multiselectable="true">
    <div class="card">
        <div class="card-header" role="tab" id="headingOne">
            <h5 class="mb-0">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseDetallePago" aria-expanded="true" aria-controls="collapseOne">
                    <i class="fa fa-plus" aria-hidden="true"></i> Generar Pago
                </a>
            </h5>
        </div>

        <div id="collapseDetallePago" class="collapse" role="tabpanel" aria-labelledby="headingOne">
            <div class="card-body">
                <form method="POST" id="frm-detallePago" action="${pageContext.request.contextPath}/GenerarPago">
                    <div class="form-group">
                        <label for="id">Rut Docente</label>
                        <select class="form-control" id="id" name="id">
                           <%= cc.getContratoSelect() %>
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
        <% DetallePagoControllador dp = new DetallePagoControllador();%>
        <%= dp.getDetallePagoVistaData() %>
    </div>
</div>  
    
    
<jsp:include page="../footer.jsp"/>