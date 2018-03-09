/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import include.Docente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Hawk
 */
public class ModeloDocente extends Conexion{
    
    
    public ArrayList<Docente> getDocente() {
        ArrayList<Docente> docente = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String sql = "Call selectDocente()";
            pst = getConnection().prepareCall(sql);
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
    
    public boolean modificarDocente(Docente d) {
        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "call modificarDocente(?,?,?,?,?,?,?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, d.getRut_docente());
            pst.setString(2, d.getNombre_docente());
            pst.setString(3, d.getApellido_docente());
            pst.setString(4, d.getSexo());
            pst.setString(5, d.getDireccion_docente());
            pst.setString(6, d.getTelefono_docente());
            pst.setString(7, d.getEmail_docente());
            pst.setString(8, d.getTitulo_docente());
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
