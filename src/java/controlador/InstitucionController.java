/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelo.ModeloInstitucion;
import include.Institucion;
import java.util.ArrayList;
/**
 *
 * @author Hawk
 */
public class InstitucionController {
    
    public boolean crear(Institucion i) {
        ModeloInstitucion mi = new ModeloInstitucion();
        return mi.crearInstitucion(i);
    }

    public boolean modificarInstitucion(Institucion i) {
        ModeloInstitucion mi = new ModeloInstitucion();
        return mi.modificarInstitucion(i);
    }
    
    public boolean eliminarInstitucion(int id) {
        ModeloInstitucion mi = new ModeloInstitucion();
        return mi.borrarInstitucion(id);
    }
    
    public String getInstitucionVistaData() {
        String htmlcode = "";
        ModeloInstitucion mi = new ModeloInstitucion();
        ArrayList<Institucion> institucion = mi.getInstitucion();
        htmlcode += "<div class=\"card mb-3\">\n"
                + "        <div class=\"card-header\">\n"
                + "          <i class=\"fa fa-table\"></i> Listado del instituciones</div>\n"
                + "        <div class=\"card-body\">\n"
                + "          <div class=\"table-responsive\">\n"
                + "            <table class=\"display table table-bordered\" id=\"listadoInstitucion\" width=\"100%\" cellspacing=\"0\">"
                + "             <thead>"
                + "            <tr>\n"
                + "                <th>ID</th>\n"
                + "                <th>Institución</th>\n"
                + "                <th>Acción</th>\n"
                + "            </tr>\n"
                + "</thead>"
                + "<tbody>";
        for (Institucion i : institucion) {
            htmlcode += "<tr>\n"
                    + "                <td id='id'>" + i.getId_institucion() + "</td>\n"
                    + "                <td id='institucion'>" + i.getDesc_institucion() + "</td>\n"
                    + "                <td><button type=\"button\" id='btn-eliminarInstitucion' class=\"btn btn-danger btn-sm eliminarInstitucion\">Eliminar</button> <button type=\"button\" id='btn-modificarInstitucion' class=\"btn btn-primary btn-sm modificarInstitucion\">\n"
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
    
    public String getInstitucionSelect() {
        String htmlcode = "";
        ModeloInstitucion mi = new ModeloInstitucion();
        ArrayList<Institucion> institucion = mi.getInstitucion();
        for (Institucion i : institucion) {
            htmlcode += "<option value=" + i.getId_institucion() + ">" + i.getDesc_institucion() + "</option>\n";
        }

        return htmlcode;
    }
}
