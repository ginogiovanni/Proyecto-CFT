/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import include.Alumno;
import include.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Hawk
 */
public class ModeloVistaAlumno extends Conexion{
    
    public ArrayList<Alumno> getAlumno(Usuario u) {
        
        ArrayList<Alumno> alumno = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String sql = "Call selectAlumnosVista(?)";
            pst = getConnection().prepareCall(sql);
            pst.setString(1, u.getNombreUsuario());
            rs = pst.executeQuery();
            while (rs.next()) {
                alumno.add(new Alumno(rs.getString("rut_alumno"),
                        rs.getString("nombre_alumno"), rs.getString("apellidos_alumno"),
                        rs.getString("sexo"), rs.getString("direccion_alumno"),
                        rs.getString("telefono_alumno"), rs.getString("email_alumno")));
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

        return alumno;
    }
}
