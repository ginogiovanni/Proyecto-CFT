/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import include.Docente;
import include.Usuario;
import java.util.ArrayList;
import modelo.ModeloDocente;
import modelo.ModeloVistaDocente;

/**
 *
 * @author Hawk
 */
public class DocenteVistaController {
    
    public String getAlumnoVistaData(Usuario u) {
        String htmlcode = "";
        ModeloVistaDocente mv = new ModeloVistaDocente();
        ModeloDocente ma = new ModeloDocente();
        ArrayList<Docente> docente = mv.getDocente(u);
        htmlcode += "          <h1>Bienvenido</h1>\n"
                + "          <div class=\"row\">\n"
                + "            <div class=\"col-sm-6\" >\n"
                + "              <div class=\"card\">\n"
                + "                <div class=\"card-header\">\n"
                + "                  Datos Personales\n"
                + "                </div>\n"
                + "                  <div class=\"card-body\">\n"
                + "                    <h4 class=\"card-title\"></h4>\n";
        for (Docente d : docente) {
            htmlcode += "<p class=\"card-text\">Rut: " + d.getRut_docente() + "</p>\n"
                    + "                    <p class=\"card-text\">Nombre: " + d.getNombre_docente() + "</p>\n"
                    + "                    <p class=\"card-text\">Apellidos: " + d.getApellido_docente() + " </p>\n"
                    + "                    <p class=\"card-text\">Genero: " + d.getSexo() + "</p>\n"
                    + "                    <p class=\"card-text\">Direccion: " + d.getDireccion_docente() + "</p>\n"
                    + "                    <p class=\"card-text\">Telefono: " + d.getTelefono_docente() + "</p>\n"
                    + "                    <p class=\"card-text\">Email: " + d.getEmail_docente() + " </p>\n"
                    + "                    <p class=\"card-text\">Titulo: " + d.getTitulo_docente() + "</p>\n";
        }

        htmlcode += " </div>\n" +
"                </div>\n" +
"            </div>\n" +
"            <div class=\"col-sm-6\">\n" +
"              <div class=\"card\">\n" +
"                <div class=\"card-header\">\n" +
"                  Pagos\n" +
"                </div>\n" +
"                <div class=\"card-body\">\n" +
"                  <h4 class=\"card-title\"></h4>\n" +
"                  <p class=\"card-text\">Pagos...</p>\n" +
"                </div>\n" +
"              </div>\n" +
"            </div>\n" +
"          </div>";

        return htmlcode;
    }
}
