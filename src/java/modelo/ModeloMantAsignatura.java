/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import include.MantAsignaturas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Hawk
 */
public class ModeloMantAsignatura extends Conexion {
    
    public ArrayList<MantAsignaturas> getMantAsignaturas() {
        
        ArrayList<MantAsignaturas> mantAsignaturas = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String sql = "Call selectMantAsignatura()";
            pst = getConnection().prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                mantAsignaturas.add(new MantAsignaturas(rs.getInt("id_mantAsignatura"),
                        rs.getString("desc_asignatura"),
                        rs.getString("rut_docente"),
                        rs.getString("desc_ciclo"),
                        rs.getString("rut_alumno")));
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

        return mantAsignaturas;
    }
    
    public boolean crearMantAsignatura(MantAsignaturas m) {
        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "call crearMantAsignatura(?,?,?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setInt(1, m.getId_asignatura_fk());
            pst.setString(2, m.getRut_docente_fk());
            pst.setString(3, m.getRut_alumno_fk());
            pst.setString(4, m.getCod_ciclo_fk());
            if (pst.executeUpdate() == 1) {
                flag = true;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
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
        return flag;
    }
    
    public boolean borrarMantAsignatura(int id){
        boolean flag = false;
        PreparedStatement pst = null;
        
        try {
            String sql = "call eliminarMantAsignatura(?)";
            pst = getConnection().prepareCall(sql);
            pst.setInt(1, id);
            if (pst.executeUpdate() == 1) {
                flag = true;
            }
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }finally{
            try {
                if (getConnection() != null) getConnection().close();
                if (pst != null) pst.close();
            } catch (Exception e) {
            }
        }
        return flag;
    }
}
