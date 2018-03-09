/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import include.Contrato;
import include.Docente;
import java.text.DecimalFormat;
import java.util.ArrayList;
import modelo.ModeloContrato;
import modelo.ModeloDocente;

/**
 *
 * @author Hawk
 */
public class ContratoController {
    
    DecimalFormat df = new DecimalFormat("'$ '###,###");
    
    public boolean crear(Contrato c, Docente d) {
        ModeloContrato mc = new ModeloContrato();
        return mc.crearContrato(c, d);
    }
    
    public boolean modificarContrato(Contrato c) {
        ModeloContrato mc= new ModeloContrato();
        return mc.modificarContrato(c);
    }
    
    public String getContratoVistaData() {
        String htmlcode = "";
        ModeloContrato mc = new ModeloContrato();
        ArrayList<Contrato> contrato = mc.getContrato();
        htmlcode += "<div class=\"card mb-3\">\n"
                + "        <div class=\"card-header\">\n"
                + "          <i class=\"fa fa-table\"></i> Listado de contratos</div>\n"
                + "        <div class=\"card-body\">\n"
                + "          <div class=\"table-responsive\">\n"
                + "            <table class=\"display table table-bordered\" id=\"listadoContrato\" width=\"100%\" cellspacing=\"0\">"
                + "             <thead>"
                + "            <tr>\n"
                + "                <th>ID</th>\n"
                + "                <th>Rut Docente</th>\n"
                + "                <th>Fecha Contrato</th>\n"
                + "                <th>Duración Contrato</th>\n"
                + "                <th>Salud</th>\n"
                + "                <th>Sueldo Bruto</th>\n"
                + "                <th>Acción</th>\n"
                + "            </tr>\n"
                + "</thead>"
                + "<tbody>";
        for (Contrato c : contrato) {
            htmlcode += "<tr>\n"
                    + "                <td id='id'>" + c.getId_contrato() + "</td>\n"
                    + "                <td id='rut'>" + c.getRut_docente_fk() + "</td>\n"
                    + "                <td id='fecha'>" + c.getFecha_contrato() + "</td>\n"
                    + "                <td id='duracion'>" + c.getDuracion_contrato() + "</td>\n"
                    + "                <td id='salud'>" + c.getSalud() + "</td>\n"
                    + "                <td id='sueldo'>" + df.format(c.getSueldo_bruto()) + "</td>\n"
                    + "                <td><button type=\"button\" id='btn-modificarContrato' class=\"btn btn-primary btn-sm modificarContrato\">\n"
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
    
    public String getContratoSelect() {
        String htmlcode = "";
        ModeloContrato mc = new ModeloContrato();
        ArrayList<Contrato> contrato = mc.getContrato();
        for (Contrato c : contrato) {
            htmlcode += "<option value=" + c.getId_contrato() + ">" + c.getRut_docente_fk() + "</option>\n";
        }

        return htmlcode;
    }
}
