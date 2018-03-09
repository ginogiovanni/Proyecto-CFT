/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import include.MantAsignaturas;
import java.util.ArrayList;
import modelo.ModeloMantAsignatura;

/**
 *
 * @author Hawk
 */
public class MantAsignaturaController {
    
    public boolean crear(MantAsignaturas m) {
        ModeloMantAsignatura mm = new ModeloMantAsignatura();
        return mm.crearMantAsignatura(m);
    }
    
    public boolean eliminarPersonal(int id) {
        ModeloMantAsignatura mm = new ModeloMantAsignatura();
        return mm.borrarMantAsignatura(id);
    }
 
    public String getMantAsignaturaVistaData() {
        String htmlcode = "";
        ModeloMantAsignatura mma = new ModeloMantAsignatura();
        ArrayList<MantAsignaturas> mantAsignatura = mma.getMantAsignaturas();
        htmlcode += "<div class=\"card mb-3\">\n"
                + "        <div class=\"card-header\">\n"
                + "          <i class=\"fa fa-table\"></i> Listado de asignaturas</div>\n"
                + "        <div class=\"card-body\">\n"
                + "          <div class=\"table-responsive\">\n"
                + "            <table class=\"display table table-bordered\" id=\"listadoMantAsignatura\" width=\"100%\" cellspacing=\"0\">"
                + "             <thead>"
                + "            <tr>\n"
                + "                <th>ID</th>\n"
                + "                <th>Asignatura</th>\n"
                + "                <th>Rut Docente</th>\n"
                + "                <th>Ciclo</th>\n"
                + "                <th>Rut Alumno</th>\n"
                + "                <th>Acción</th>\n"
                + "            </tr>\n"
                + "</thead>"
                + "<tbody>";
        for (MantAsignaturas m : mantAsignatura) {
            htmlcode += "<tr>\n"
                    + "                <td id='id'>" + m.getId_mant_asignaturas() + "</td>\n"
                    + "                <td id='asignatura'>" + m.getAsignatura() + "</td>\n"
                    + "                <td id='rut_docente'>" + m.getDocente() + "</td>\n"
                    + "                <td id='ciclo'>" + m.getCiclo() + "</td>\n"
                    + "                <td id='rut_alumno'>" + m.getAlumno() + "</td>\n"
                    + "                <td><button type=\"button\" id='btn-eliminarMantAsignatura' class=\"btn btn-danger btn-sm eliminarMantAsignatura\">Eliminar</button> <button type=\"button\" id='btn-modificarMantAsignatura' class=\"btn btn-primary btn-sm modificarMantAsignatura\">\n"
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
