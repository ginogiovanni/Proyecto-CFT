/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import include.Asignatura;
import java.util.ArrayList;
import modelo.ModeloAsignatura;

/**
 *
 * @author Hawk
 */
public class AsignaturaController {

    public boolean crear(Asignatura a) {
        ModeloAsignatura ma = new ModeloAsignatura();
        return ma.crearAsignatura(a);
    }

    public boolean modificarAsignatura(Asignatura a) {
        ModeloAsignatura ma = new ModeloAsignatura();
        return ma.modificarAsignatura(a);
    }

    public String getAsignaturaVistaData() {
        String htmlcode = "";
        ModeloAsignatura ma = new ModeloAsignatura();
        ArrayList<Asignatura> asignatura = ma.getAsignatura();
        htmlcode += "<div class=\"card mb-3\">\n"
                + "        <div class=\"card-header\">\n"
                + "          <i class=\"fa fa-table\"></i> Listado del asignaturas</div>\n"
                + "        <div class=\"card-body\">\n"
                + "          <div class=\"table-responsive\">\n"
                + "            <table class=\"display table table-bordered\" id=\"listadoAsignatura\" width=\"100%\" cellspacing=\"0\">"
                + "             <thead>"
                + "            <tr>\n"
                + "                <th>ID</th>\n"
                + "                <th>Asignatura</th>\n"
                + "                <th>Acción</th>\n"
                + "            </tr>\n"
                + "</thead>"
                + "<tbody>";
        for (Asignatura a : asignatura) {
            htmlcode += "<tr>\n"
                    + "                <td id='id'>" + a.getId_asignatura() + "</td>\n"
                    + "                <td id='asignatura'>" + a.getDesc_asignatura() + "</td>\n"
                    + "                <td><button type=\"button\" id='btn-modificarAsignatura' class=\"btn btn-primary btn-sm modificarAsignatura\">\n"
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

    public String getAsignaturaSelect() {
        String htmlcode = "";
        ModeloAsignatura ma = new ModeloAsignatura();
        ArrayList<Asignatura> asignatura = ma.getAsignatura();
        for (Asignatura a : asignatura) {
            htmlcode += "<option value=" + a.getId_asignatura() + ">" + a.getDesc_asignatura() + "</option>\n";
        }
        
        return htmlcode;
    }
}
