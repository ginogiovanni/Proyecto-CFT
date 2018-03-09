<%-- 
    Document   : matriculas
    Created on : 06-11-2017, 23:48:29
    Author     : Hawk
--%>
<%@page import="controlador.CicloController"%>
<%@page import="controlador.CarreraController"%>
<%@page import="controlador.InstitucionController"%>
<%@page import="controlador.MatriculaController"%>
<jsp:include page="../header.jsp"/>
<% CarreraController c = new CarreraController();%>
<% InstitucionController i = new InstitucionController();%>
<% CicloController ci = new CicloController(); %>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="${pageContext.request.contextPath}/index.jsp">Panel</a>
    </li>
    <li class="breadcrumb-item active">Matrículas</li>
</ol>
<div id="accordion" role="tablist" aria-multiselectable="true">
    <div class="card">
        <div class="card-header" role="tab" id="headingOne">
            <h5 class="mb-0">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseMatricula" aria-expanded="true" aria-controls="collapseOne">
                    <i class="fa fa-plus" aria-hidden="true"></i> Crear Matrícula
                </a>
            </h5>
        </div>

        <div id="collapseMatricula" class="collapse" role="tabpanel" aria-labelledby="headingOne">
            <div class="card-body">
                <form method="POST" id="frm-matricula" action="${pageContext.request.contextPath}/CrearMatricula">
                    <div class="form-group">
                        <label for="rut">Rut Alumno</label>
                        <input type="text" class="form-control" id="rut" name="rut" placeholder="Ej: 11.111.111-1">
                    </div>
                    <div class="form-group">
                        <label for="nombre">Nombre Alumno</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ej: José">
                    </div>
                    <div class="form-group">
                        <label for="apellidos">Apellidos Alumno</label>
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
                        <label for="carrera">Carrera</label>
                        <select class="form-control" id="carrera" name="carrera">
                           <%= c.getCarreraSelect() %>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="ciclo">Ciclo</label>
                        <select class="form-control" id="ciclo" name="ciclo">                           
                           
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="institucion">Institución</label>
                        <select class="form-control" id="institucion" name="institucion">
                           <%= i.getInstitucionSelect()%>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="semestre">Semestre</label>
                        <input type="text" class="form-control" id="semestre" name="semestre" placeholder="Ej: Primer Semestre">
                    </div>
                    <div class="form-group">
                        <label for="modalidad">Modalidad</label>
                        <select class="form-control" id="modalidad" name="modalidad">
                            <option value="Diurno">Diurno</option>
                            <option value="Vespertino">Vespertino</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="monto">Monto</label>
                        <input type="text" class="form-control" id="monto" name="monto" placeholder="Ej: 90.000">
                    </div>
                    <input type="submit" value="Enviar" class="btn btn-primary" id="btn-registroMatricula">
                </form>
            </div>
        </div>
    </div>
</div><br>    


<div class="row">
    <div class="col-12">
        <% MatriculaController mc = new MatriculaController();%>
        <%= mc.getMatriculaVistaData()%>
    </div>
</div>

<div id="accordion" role="tablist" aria-multiselectable="true">
    <div class="card">
        <div class="card-header" role="tab" id="headingOne">
            <h5 class="mb-0">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseModificarMatricula" aria-expanded="true" aria-controls="collapseOne">
                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i> Modificar Matrícula
                </a>
            </h5>
        </div>
        <div id="collapseModificarMatricula" class="collapse" role="tabpanel" aria-labelledby="headingOne">
            <div class="card-body">
                <form method="POST" id="frm-modificarMatricula" action="${pageContext.request.contextPath}/ModificarMatricula">
                    <div class="form-group">
                        <label for="idM">ID</label>
                        <input type="text" class="form-control" id="idM" name="idM" placeholder="Ej: 11.111.111-1" readonly="true">
                    </div>
                    <div class="form-group">
                        <label for="rut">Rut</label>
                        <input type="text" class="form-control" id="rutM" name="rutM" placeholder="Ej: 11.111.111-1" readonly="true">
                    </div>
                    <div class="form-group">
                        <label for="semestreM">Semestre</label>
                        <input type="text" class="form-control" id="semestreM" name="semestreM" placeholder="Ej: Primer Semestre">
                    </div>                
                    <div class="form-group">
                        <label for="monto">Monto</label>
                        <input type="text" class="form-control" id="montoM" name="montoM" placeholder="Ej: 90.000">
                    </div>
                    <input type="submit" value="Modificar" class="btn btn-primary" id="btn-modificarMatricula-submit">
                </form>
            </div>
        </div>
    </div>
</div><br>


<jsp:include page="../footer.jsp"/>