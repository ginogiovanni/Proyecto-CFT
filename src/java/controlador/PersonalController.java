/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.ModeloPersonal;
import include.Personal;

/**
 *
 * @author Hawk
 */
public class PersonalController {
    
    public boolean crear(Personal p) {
        ModeloPersonal mp = new ModeloPersonal();
        return mp.crearPersonal(p);
    }
    
    public boolean eliminarPersonal(String rut) {
        ModeloPersonal mp = new ModeloPersonal();
        return mp.borrarPersonal(rut);
    }
    
    public boolean modificarPersonal(Personal p) {
        ModeloPersonal mp = new ModeloPersonal();
        return mp.modificarPersonal(p);
    }

    public String getPersonalVistaData() {
        String htmlcode = "";
        ModeloPersonal mp = new ModeloPersonal();
        ArrayList<Personal> personal = mp.getPersonal();
        htmlcode += "<div class=\"card mb-3\">\n"
                + "        <div class=\"card-header\">\n"
                + "          <i class=\"fa fa-table\"></i> Listado del personal</div>\n"
                + "        <div class=\"card-body\">\n"
                + "          <div class=\"table-responsive\">\n"
                + "            <table class=\"display table table-bordered\" id=\"listadoPersonal\" width=\"100%\" cellspacing=\"0\">"
                + "             <thead>"
                + "            <tr>\n"
                + "                <th>Rut</th>\n"
                + "                <th>Nombre</th>\n"
                + "                <th>Apellidos</th>\n"
                + "                <th>Sexo</th>\n"
                + "                <th>Dirección</th>\n"
                + "                <th>Telefono</th>\n"
                + "                <th>Email</th>\n"
                + "                <th>Acción</th>\n"
                + "            </tr>\n"
                + "</thead>"
                + "<tbody>";
        for (Personal p : personal) {
            htmlcode += "<tr>\n"
                    + "                <td id='rut'>" + p.getRut_personal() + "</td>\n"
                    + "                <td id='nombre'>" + p.getNombre_personal() + "</td>\n"
                    + "                <td id='apellido'>" + p.getApellidos_personal() + "</td>\n"
                    + "                <td id='sexo'>" + p.getSexo() + "</td>\n"
                    + "                <td id='direccion'>" + p.getDireccion_personal() + "</td>\n"
                    + "                <td id='telefono'>" + p.getTelefono_personal() + "</td>\n"
                    + "                <td id='email'>" + p.getEmail_personal() + "</td>\n"
                    + "                <td><button type=\"button\" id='btn-eliminarPersonal' class=\"btn btn-danger btn-sm eliminarPersonal\">Eliminar</button> <button type=\"button\" id='btn-modificarPersonal' class=\"btn btn-primary btn-sm modificarPersonal\">\n"
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
    
    public String getRutPersonal() {
        String htmlcode = "";
        ModeloPersonal mci = new ModeloPersonal();
        ArrayList<Personal> personal = mci.getPersonal();
        for (Personal ci : personal) {
            htmlcode += "<option value=" + ci.getRut_personal() + ">" + ci.getRut_personal() + "</option>\n";
        }

        return htmlcode;
    }
    
}
