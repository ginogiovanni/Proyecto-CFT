/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.ModeloMatricula;
import include.Matricula;
import include.Alumno;
import include.Carrera;
import include.Ciclo;
import include.Institucion;
import java.text.DecimalFormat;
import modelo.ModeloAlumno;

/**
 *
 * @author Hawk
 */
public class MatriculaController {
    
    DecimalFormat df = new DecimalFormat("'$ '###,###");
    
    public boolean crear(Matricula m, Alumno a, Institucion i, Carrera c, Ciclo ci) {
        ModeloAlumno ma = new ModeloAlumno();
        ModeloMatricula mm = new ModeloMatricula();
        return mm.crearMatricula(m, a, i, c, ci);
    }
    
    public boolean modificarPersonal(Matricula m) {
        ModeloMatricula mm = new ModeloMatricula();
        return mm.modificarMatricula(m);
    }
    
    public String getMatriculaVistaData() {
        String htmlcode = "";
        ModeloMatricula mm = new ModeloMatricula();
        ArrayList<Matricula> matricula = mm.getMatricula();
        htmlcode += "<div class=\"card mb-3\">\n"
                + "        <div class=\"card-header\">\n"
                + "          <i class=\"fa fa-table\"></i> Listado del matrículas</div>\n"
                + "        <div class=\"card-body\">\n"
                + "          <div class=\"table-responsive\">\n"
                + "            <table class=\"display table table-bordered\" id=\"listadoMatricula\" width=\"100%\" cellspacing=\"0\">"
                + "             <thead>"
                + "            <tr>\n"
                + "                <th>ID</th>\n"
                + "                <th>Rut Alumno</th>\n"
                + "                <th>Carrera</th>\n"
                + "                <th>Institucion</th>\n"
                + "                <th>Semestre</th>\n"
                + "                <th>Modalidad</th>\n"
                + "                <th>Monto</th>\n"
                + "                <th>Fecha Matricula</th>\n"
                + "                <th>Ciclo</th>\n"
                + "                <th>Acción</th>\n"
                + "            </tr>\n"
                + "</thead>"
                + "<tbody>";
        for (Matricula m : matricula) {
            htmlcode += "<tr>\n"
                    + "                <td id='id'>" + m.getId_matricula()+ "</td>\n"
                    + "                <td id='rut'>" + m.getRut_alumno_fk() + "</td>\n"
                    + "                <td id='carrera'>" + m.getDesc_carrera() + "</td>\n"
                    + "                <td id='institucion'>" + m.getDesc_institucion()+ "</td>\n"
                    + "                <td id='semestre'>" + m.getSemestre() + "</td>\n"
                    + "                <td id='modalidad'>" + m.getModalidad() + "</td>\n"
                    + "                <td id='monto'>" + df.format(m.getMonto()) + "</td>\n"
                    + "                <td id='fecha_matricula'>" + m.getFecha_matricula() + "</td>\n"
                    + "                <td id='ciclo'>" + m.getDesc_ciclo() + "</td>\n"
                    + "                <td><button type=\"button\" id='btn-modificarMatricula' class=\"btn btn-primary btn-sm modificarMatricula\">\n"
                    + "  Modificar\n"
                    + "</button></td>\n"
                    + "            </tr>\n";
        }

        htmlcode += "</tbody>"
                + "</table>"
                + "</div>\n"
                + "</div>\n"
                + "<div class=\"card-footer small text-muted\">Updated yesterday at 11:59 PM</div>\n"
                + "</div>";

        return htmlcode;
    }
}
