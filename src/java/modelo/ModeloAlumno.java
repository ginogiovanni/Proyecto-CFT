/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import include.Alumno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Hawk
 */
public class ModeloAlumno extends Conexion{
    
    public ArrayList<Alumno> getAlumno() {
        
        ArrayList<Alumno> alumno = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String sql = "Call selectAlumno()";
            pst = getConnection().prepareCall(sql);
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
    
    public boolean modificarAlumno(Alumno a) {
        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "call modificarAlumno(?,?,?,?,?,?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, a.getRut_alumno());
            pst.setString(2, a.getNombre_alumno());
            pst.setString(3, a.getApellido_alumno());
            pst.setString(4, a.getSexo());
            pst.setString(5, a.getDireccion_alumno());
            pst.setString(6, a.getTelefono_alumno());
            pst.setString(7, a.getEmail_alumno());
            if (pst.executeUpdate() == 1) {
                flag = true;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (getConnection() != null) getConnection().close();
                if (pst != null) pst.close();
            } catch (Exception e) {
            }
        }
        return flag;
    }
}
