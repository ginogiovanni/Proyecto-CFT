/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import include.Alumno;
import include.Usuario;
import java.util.ArrayList;
import modelo.ModeloAlumno;
import modelo.ModeloVistaAlumno;

/**
 *
 * @author Hawk
 */
public class AlumnoVistaController {

    public String getAlumnoVistaData(Usuario u) {
        String htmlcode = "";
        ModeloVistaAlumno mv = new ModeloVistaAlumno();
        ModeloAlumno ma = new ModeloAlumno();
        ArrayList<Alumno> alumno = mv.getAlumno(u);
        htmlcode += "          <h1>Bienvenido</h1>\n"
                + "          <div class=\"row\">\n"
                + "            <div class=\"col-sm-6\" >\n"
                + "              <div class=\"card\">\n"
                + "                <div class=\"card-header\">\n"
                + "                  Datos Personales\n"
                + "                </div>\n"
                + "                  <div class=\"card-body\">\n"
                + "                    <h4 class=\"card-title\"></h4>\n";
        for (Alumno a : alumno) {
            htmlcode += "<p class=\"card-text\">Rut: " + a.getRut_alumno() + "</p>\n"
                    + "                    <p class=\"card-text\">Nombre: " + a.getNombre_alumno() + "</p>\n"
                    + "                    <p class=\"card-text\">Apellidos:" + a.getApellido_alumno() + " </p>\n"
                    + "                    <p class=\"card-text\">Genero: " + a.getSexo() + "</p>\n"
                    + "                    <p class=\"card-text\">Direccion: " + a.getDireccion_alumno() + "</p>\n"
                    + "                    <p class=\"card-text\">Telefono: " + a.getTelefono_alumno() + "</p>\n"
                    + "                    <p class=\"card-text\">Email:" + a.getEmail_alumno() + " </p>\n";
        }

        htmlcode += " </div>\n" +
"                </div>\n" +
"            </div>\n" +
"            <div class=\"col-sm-6\">\n" +
"              <div class=\"card\">\n" +
"                <div class=\"card-header\">\n" +
"                  Horario\n" +
"                </div>\n" +
"                <div class=\"card-body\">\n" +
"                  <h4 class=\"card-title\"></h4>\n" +
"                  <p class=\"card-text\">Horario...</p>\n" +
"                </div>\n" +
"              </div>\n" +
"            </div>\n" +
"          </div>";

        return htmlcode;
    }
}
