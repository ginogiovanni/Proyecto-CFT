/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.ModeloCiclo;
import include.Ciclo;
import java.util.ArrayList;

/**
 *
 * @author Hawk
 */
public class CicloController {
    
    
    public boolean crear(Ciclo c) {
        ModeloCiclo mc = new ModeloCiclo();
        return mc.crearCiclo(c);
    }
    
    public boolean modificarCiclo(Ciclo c) {
        ModeloCiclo mc = new ModeloCiclo();
        return mc.modificarCiclo(c);
    }
    
    public String getCicloSelect() {
        String htmlcode = "";
        ModeloCiclo mci = new ModeloCiclo();
        ArrayList<Ciclo> ciclo = mci.getCiclo();
        for (Ciclo ci : ciclo) {
            htmlcode += "<option value=" + ci.getCod_ciclo() + ">" + ci.getDesc_ciclo() + "</option>\n";
        }

        return htmlcode;
    }
    
     public String getCicloVistaData() {
        String htmlcode = "";
        ModeloCiclo mc = new ModeloCiclo();
        ArrayList<Ciclo> ciclo = mc.getCicloAll();
        htmlcode += "<div class=\"card mb-3\">\n"
                + "        <div class=\"card-header\">\n"
                + "          <i class=\"fa fa-table\"></i> Listado de ciclos</div>\n"
                + "        <div class=\"card-body\">\n"
                + "          <div class=\"table-responsive\">\n"
                + "            <table class=\"display table table-bordered\" id=\"listadoCiclo\" width=\"100%\" cellspacing=\"0\">"
                + "             <thead>"
                + "            <tr>\n"
                + "                <th>Cod Ciclo</th>\n"
                + "                <th>Descripción</th>\n"
                + "                <th>Año</th>\n"
                + "                <th>ID Carrera</th>\n"
                + "                <th>Acción</th>\n"
                + "            </tr>\n"
                + "</thead>"
                + "<tbody>";
        for (Ciclo c : ciclo) {
            htmlcode += "<tr>\n"
                    + "                <td id='cod'>" + c.getCod_ciclo() + "</td>\n"
                    + "                <td id='desc_ciclo'>" + c.getDesc_ciclo() + "</td>\n"
                    + "                <td id='anio'>" + c.getAnio_ciclo() + "</td>\n"
                    + "                <td id='id_carrera_fk'>" + c.getId_carrera_fk() + "</td>\n"
                    + "                <td> <button type=\"button\" id='btn-modificarCiclo' class=\"btn btn-primary btn-sm modificarCiclo\">\n"
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
