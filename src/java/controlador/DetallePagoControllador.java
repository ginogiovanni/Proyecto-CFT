/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import include.DetallePago;
import java.text.DecimalFormat;
import java.util.ArrayList;
import modelo.ModeloDetallePago;

/**
 *
 * @author Hawk
 */
public class DetallePagoControllador {
    
    
    
    DecimalFormat df = new DecimalFormat("'$ '###,###");
    
    public boolean crear(DetallePago d) {
        ModeloDetallePago mdp = new ModeloDetallePago();
        return mdp.crearDetallePago(d);
    }
    
     public boolean eliminarDetallePago(int id) {
        ModeloDetallePago md = new ModeloDetallePago();
        return md.borrarDetallePago(id) ;
    }

    
    public String getDetallePagoVistaData() {
        String htmlcode = "";
        ModeloDetallePago md = new ModeloDetallePago();
        ArrayList<DetallePago> detallePago = md.getDetalle();
        htmlcode += "<div class=\"card mb-3\">\n"
                + "        <div class=\"card-header\">\n"
                + "          <i class=\"fa fa-table\"></i> Listado de asignaturas</div>\n"
                + "        <div class=\"card-body\">\n"
                + "          <div class=\"table-responsive\">\n"
                + "            <table class=\"display table table-bordered\" id=\"listadoPago\" width=\"100%\" cellspacing=\"0\">"
                + "             <thead>"
                + "            <tr>\n"
                + "                <th>ID</th>\n"
                + "                <th>Rut Docente</th>\n"
                + "                <th>Fecha Pago</th>\n"
                + "                <th>Sueldo Liquido</th>\n"
                + "                <th>Acción</th>\n"
                + "            </tr>\n"
                + "</thead>"
                + "<tbody>";
        for (DetallePago d : detallePago) {
            htmlcode += "<tr>\n"
                    + "                <td id='id'>" + d.getId_pago() + "</td>\n"
                    + "                <td id='rut_docente'>" + d.getRut_docente_fk() + "</td>\n"
                    + "                <td id='fecha'>" + d.getFecha_pago() + "</td>\n"
                    + "                <td id='sueldo'>" + df.format(d.getSueldo_liquido()) + "</td>\n"
                    + "                <td><button type=\"button\" id='btn-eliminarDetallePago' class=\"btn btn-danger btn-sm eliminarDetallePago\">Eliminar</button></td>\n"
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
