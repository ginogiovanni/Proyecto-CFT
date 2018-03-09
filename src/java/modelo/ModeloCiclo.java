/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import include.Ciclo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Hawk
 */
public class ModeloCiclo extends Conexion{
    
    public ArrayList<Ciclo> getCiclo() {
        
        ArrayList<Ciclo> ciclo = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String sql = "Call selectCiclo()";
            pst = getConnection().prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                ciclo.add(new Ciclo(rs.getString("cod_ciclo"),
                        rs.getString("desc_ciclo")));
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

        return ciclo;
    }
    
    public ArrayList<Ciclo> getCicloAll() {
        
        ArrayList<Ciclo> ciclo = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String sql = "Call selectCiclo()";
            pst = getConnection().prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                ciclo.add(new Ciclo(rs.getString("cod_ciclo"),
                        rs.getString("desc_ciclo"),
                        rs.getInt("anio_ciclo"),
                        rs.getInt("id_carrera_fk")));
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

        return ciclo;
    }
    
    public boolean crearCiclo(Ciclo c) {
        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "call crearCiclo(?,?,?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, c.getCod_ciclo());
            pst.setString(2, c.getDesc_ciclo());
            pst.setInt(3, c.getAnio_ciclo());
            pst.setInt(4, c.getId_carrera_fk());
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
   
    public boolean modificarCiclo(Ciclo c) {
        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "call modificarCiclo(?,?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, c.getCod_ciclo());
            pst.setString(2, c.getDesc_ciclo());
            pst.setInt(3, c.getAnio_ciclo());
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
