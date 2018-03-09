/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import include.Docente;
import include.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Hawk
 */
public class ModeloVistaDocente extends Conexion{
    
    public ArrayList<Docente> getDocente(Usuario u) {
        ArrayList<Docente> docente = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String sql = "Call selectDocentesVista(?)";
            pst = getConnection().prepareCall(sql);
            pst.setString(1, u.getNombreUsuario());
            rs = pst.executeQuery();
            while (rs.next()) {
                docente.add(new Docente(rs.getString("rut_docente"),
                        rs.getString("nombre_docente"), rs.getString("apellido_docente"),
                        rs.getString("sexo"), rs.getString("direccion_docente"),
                        rs.getString("telefono_docente"), rs.getString("email_docente"),
                        rs.getString("titulo_docente")));
            }
        } catch (Exception e) {
        } finally {
            try {
                if (getConnection() != null) {
                    getConnection().close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
            }
        }

        return docente;
    }
}
