/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import include.Carrera;
import java.util.ArrayList;
import modelo.ModeloCarrera;

/**
 *
 * @author Hawk
 */
public class CarreraController {

    public boolean crear(Carrera c) {
        ModeloCarrera mc = new ModeloCarrera();
        return mc.crearCarrera(c);
    }

    public boolean modificarCarrera(Carrera c) {
        ModeloCarrera mc = new ModeloCarrera();
        return mc.modificarCarrera(c);
    }

    public boolean eliminarCarrera(int id) {
        ModeloCarrera mc = new ModeloCarrera();
        return mc.borrarCarrera(id);
    }

    public String getCarreraVistaData() {
        String htmlcode = "";
        ModeloCarrera mc = new ModeloCarrera();
        ArrayList<Carrera> carrera = mc.getCarrera();
        htmlcode += "<div class=\"card mb-3\">\n"
                + "        <div class=\"card-header\">\n"
                + "          <i class=\"fa fa-table\"></i> Listado del carreras</div>\n"
                + "        <div class=\"card-body\">\n"
                + "          <div class=\"table-responsive\">\n"
                + "            <table class=\"display table table-bordered\" id=\"listadoCarrera\" width=\"100%\" cellspacing=\"0\">"
                + "             <thead>"
                + "            <tr>\n"
                + "                <th>ID</th>\n"
                + "                <th>Carrera</th>\n"
                + "                <th>Acción</th>\n"
                + "            </tr>\n"
                + "</thead>"
                + "<tbody>";
        for (Carrera c : carrera) {
            htmlcode += "<tr>\n"
                    + "                <td id='id'>" + c.getId_carrera() + "</td>\n"
                    + "                <td id='carrera'>" + c.getDesc_carrera() + "</td>\n"
                    + "                <td><button type=\"button\" id='btn-eliminarCarrera' class=\"btn btn-danger btn-sm eliminarCarrera\">Eliminar</button> <button type=\"button\" id='btn-modificarCarrera' class=\"btn btn-primary btn-sm modificarCarrera\">\n"
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

    public String getCarreraSelect() {
        String htmlcode = "";
        ModeloCarrera mc = new ModeloCarrera();
        ArrayList<Carrera> carrera = mc.getCarrera();
        for (Carrera c : carrera) {
            htmlcode += "<option value=" + c.getId_carrera() + ">" + c.getDesc_carrera() + "</option>\n";
        }

        return htmlcode;
    }
}
