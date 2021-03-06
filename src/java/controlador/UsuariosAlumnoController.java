/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import include.UsuariosPersonal;
import java.util.ArrayList;
import modelo.ModeloUsuariosAlumno;

/**
 *
 * @author Hawk
 */
public class UsuariosAlumnoController {
    
    public boolean crear(UsuariosPersonal u) {
        ModeloUsuariosAlumno mi = new ModeloUsuariosAlumno();
        return mi.crearUsuarioAlumno(u);
    }
    
    public boolean eliminarUsuarioAlumno(int id) {
        ModeloUsuariosAlumno mi = new ModeloUsuariosAlumno();
        return mi.borrarUsuarioAlumno(id);
    }
    public String getPersonalVistaData() {
        String htmlcode = "";
        ModeloUsuariosAlumno mp = new ModeloUsuariosAlumno();
        ArrayList<UsuariosPersonal> personal = mp.getUsuariosPersonal();
        htmlcode += "<div class=\"card mb-3\">\n"
                + "        <div class=\"card-header\">\n"
                + "          <i class=\"fa fa-table\"></i> Listado de usuarios</div>\n"
                + "        <div class=\"card-body\">\n"
                + "          <div class=\"table-responsive\">\n"
                + "            <table class=\"display table table-bordered\" id=\"listadoPersonal\" width=\"100%\" cellspacing=\"0\">"
                + "             <thead>"
                + "            <tr>\n"
                + "                <th>ID</th>\n"
                + "                <th>Nombre Usuario</th>\n"
                + "                <th>Passoword</th>\n"
                + "                <th>Tipo Usuario</th>\n"
                + "                <th>Rut Alumno</th>\n"
                + "                <th>Acción</th>\n"
                + "            </tr>\n"
                + "</thead>"
                + "<tbody>";
        for (UsuariosPersonal p : personal) {
            htmlcode += "<tr>\n"
                    + "                <td id='id'>" + p.getId_usuario() + "</td>\n"
                    + "                <td id='usuario'>" + p.getNombre_usuario() + "</td>\n"
                    + "                <td id='password'>" + p.getPassword() + "</td>\n"
                    + "                <td id='tipo'>" + p.getTipo_usuario() + "</td>\n"
                    + "                <td id='rut'>" + p.getRut_usuario_fk() + "</td>\n"
                    + "                <td><button type=\"button\" id='btn-eliminarUsuarioAlumno' class=\"btn btn-danger btn-sm eliminarUsuarioAlumno\">Eliminar</button> <button type=\"button\" id='btn-modificarUsuarioPersonal' class=\"btn btn-primary btn-sm modificarUsuarioPersonal\">\n"
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
