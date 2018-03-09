/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import include.Contrato;
import include.Docente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Hawk
 */
public class ModeloContrato extends Conexion{
    
    public ArrayList<Contrato> getContrato() {
        
        ArrayList<Contrato> contrato = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String sql = "Call selectContrato()";
            pst = getConnection().prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                contrato.add(new Contrato(rs.getInt("id_contrato"),
                        rs.getString("rut_docente_fk"),
                        rs.getString("fecha_contrato"),
                        rs.getString("salud"),
                        rs.getInt("duracion_contrato"),
                        rs.getDouble("sueldo_bruto")));
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

        return contrato;
    }
    
    public boolean crearContrato(Contrato c, Docente d) {
        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "call crearContrato(?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, d.getRut_docente());
            pst.setString(2, d.getNombre_docente());
            pst.setString(3, d.getApellido_docente());
            pst.setString(4, d.getSexo());
            pst.setString(5, d.getDireccion_docente());
            pst.setString(6, d.getTelefono_docente());
            pst.setString(7, d.getEmail_docente());
            pst.setString(8, d.getTitulo_docente());
            pst.setString(9, c.getFecha_contrato());
            pst.setInt(10, c.getDuracion_contrato());
            pst.setString(11, c.getSalud());
            pst.setString(12, Double.toString(c.getSueldo_bruto()));
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
    
    public boolean modificarContrato(Contrato c) {
        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "call modificarContrato(?,?,?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, c.getRut_docente_fk());
            pst.setInt(2, c.getDuracion_contrato());
            pst.setString(3, c.getSalud());
            pst.setDouble(4, c.getSueldo_bruto());
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
