/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import include.Docente;
import java.util.ArrayList;
import modelo.ModeloDocente;

/**
 *
 * @author Hawk
 */
public class DocenteController {
    
     public boolean modificarPersonal(Docente d) {
        ModeloDocente md = new ModeloDocente();
        return md.modificarDocente(d);
    }
    
    public String getDocenteVistaData() {
        String htmlcode = "";
        ModeloDocente md = new ModeloDocente();
        ArrayList<Docente> docente = md.getDocente();
        htmlcode += "<div class=\"card mb-3\">\n"
                + "        <div class=\"card-header\">\n"
                + "          <i class=\"fa fa-table\"></i> Listado de docentes</div>\n"
                + "        <div class=\"card-body\">\n"
                + "          <div class=\"table-responsive\">\n"
                + "            <table class=\"display table table-bordered\" id=\"listadoDocente\" width=\"100%\" cellspacing=\"0\">"
                + "             <thead>"
                + "            <tr>\n"
                + "                <th>Rut</th>\n"
                + "                <th>Nombre</th>\n"
                + "                <th>Apellidos</th>\n"
                + "                <th>Sexo</th>\n"
                + "                <th>Dirección</th>\n"
                + "                <th>Telefono</th>\n"
                + "                <th>Email</th>\n"
                + "                <th>Titulo</th>\n"
                + "                <th>Acción</th>\n"
                + "            </tr>\n"
                + "</thead>"
                + "<tbody>";
        for (Docente d : docente) {
            htmlcode += "<tr>\n"
                    + "                <td id='rut'>" + d.getRut_docente() + "</td>\n"
                    + "                <td id='nombre'>" + d.getNombre_docente() + "</td>\n"
                    + "                <td id='apellido'>" + d.getApellido_docente() + "</td>\n"
                    + "                <td id='sexo'>" + d.getSexo() + "</td>\n"
                    + "                <td id='direccion'>" + d.getDireccion_docente() + "</td>\n"
                    + "                <td id='telefono'>" + d.getTelefono_docente() + "</td>\n"
                    + "                <td id='email'>" + d.getEmail_docente() + "</td>\n"
                    + "                <td id='titulo'>" + d.getTitulo_docente() + "</td>\n"
                    + "                <td><button type=\"button\" id='btn-modificarDocente' class=\"btn btn-primary btn-sm modificarDocente\">\n"
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
        ModeloDocente ma = new ModeloDocente();
        ArrayList<Docente> docente = ma.getDocente();
        for (Docente a : docente) {
            htmlcode += "<option value=" + a.getRut_docente() + ">" + a.getRut_docente() + "</option>\n";
        }

        return htmlcode;
    }
}
