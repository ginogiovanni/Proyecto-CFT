/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import include.DetallePago;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Hawk
 */
public class ModeloDetallePago extends Conexion{
    
    public ArrayList<DetallePago> getDetalle() {
        
        ArrayList<DetallePago> detallePago = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String sql = "Call selectDetallePago()";
            pst = getConnection().prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                detallePago.add(new DetallePago(rs.getInt("id_pago"),
                        rs.getString("fecha_pago"),
                        rs.getString("rut_docente_fk"),
                        rs.getDouble("sueldo_liquido")));
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

        return detallePago;
    }
    
    public boolean crearDetallePago(DetallePago d) {
        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "call insertDetallePago(?,?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, d.getFecha_pago());
            pst.setInt(2, d.getId_contrato_fk());
            pst.setDouble(3, d.getSueldo_liquido());
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
    
    public boolean borrarDetallePago(int id){
        boolean flag = false;
        PreparedStatement pst = null;
        
        try {
            String sql = "call eliminarDetallePago(?)";
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
