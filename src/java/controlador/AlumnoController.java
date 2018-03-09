/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import include.Alumno;
import java.util.ArrayList;
import modelo.ModeloAlumno;

/**
 *
 * @author Hawk
 */
public class AlumnoController {
    
    public boolean modificarAlumno(Alumno a) {
        ModeloAlumno ma = new ModeloAlumno();
        return ma.modificarAlumno(a);
    }
    
    public String getAlumnoVistaData() {
        String htmlcode = "";
        ModeloAlumno ma = new ModeloAlumno();
        ArrayList<Alumno> alumno = ma.getAlumno();
        htmlcode += "<div class=\"card mb-3\">\n"
                + "        <div class=\"card-header\">\n"
                + "          <i class=\"fa fa-table\"></i> Listado del alumnos</div>\n"
                + "        <div class=\"card-body\">\n"
                + "          <div class=\"table-responsive\">\n"
                + "            <table class=\"display table table-bordered\" id=\"listadoAlumno\" width=\"100%\" cellspacing=\"0\">"
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
        for (Alumno a : alumno) {
            htmlcode += "<tr>\n"
                    + "                <td id='rut'>" + a.getRut_alumno() + "</td>\n"
                    + "                <td id='nombre'>" + a.getNombre_alumno() + "</td>\n"
                    + "                <td id='apellido'>" + a.getApellido_alumno() + "</td>\n"
                    + "                <td id='sexo'>" + a.getSexo() + "</td>\n"
                    + "                <td id='direccion'>" + a.getDireccion_alumno() + "</td>\n"
                    + "                <td id='telefono'>" + a.getTelefono_alumno() + "</td>\n"
                    + "                <td id='email'>" + a.getEmail_alumno() + "</td>\n"
                    + "                <td><button type=\"button\" id='btn-modificarAlumno' class=\"btn btn-primary btn-sm modificarAlumno\">\n"
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
    
    public String getAlumnoSelect() {
        String htmlcode = "";
        ModeloAlumno ma = new ModeloAlumno();
        ArrayList<Alumno> alumno = ma.getAlumno();
        for (Alumno a : alumno) {
            htmlcode += "<option value=" + a.getRut_alumno() + ">" + a.getRut_alumno() + "</option>\n";
        }

        return htmlcode;
    }
}
