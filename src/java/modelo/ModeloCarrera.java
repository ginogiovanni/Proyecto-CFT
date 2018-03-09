/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import include.Carrera;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Hawk
 */
public class ModeloCarrera extends Conexion{
    
    public ArrayList<Carrera> getCarrera() {
        
        ArrayList<Carrera> carrera = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String sql = "Call selectCarrera()";
            pst = getConnection().prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                carrera.add(new Carrera(rs.getInt("id_carrera"),
                        rs.getString("desc_carrera")));
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

        return carrera;
    }
    
    public boolean crearCarrera(Carrera c) {
        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "call crearCarrera(?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, c.getDesc_carrera());
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
    
    public boolean modificarCarrera(Carrera c) {
        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "call modificarCarrera(?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setInt(1, c.getId_carrera());
            pst.setString(2, c.getDesc_carrera());
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
    
    public boolean borrarCarrera(int id){
        boolean flag = false;
        PreparedStatement pst = null;
        
        try {
            String sql = "call eliminarCarrera(?)";
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
