/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import include.Institucion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Hawk
 */
public class ModeloInstitucion extends Conexion{
    
    public ArrayList<Institucion> getInstitucion() {
        
        ArrayList<Institucion> institucion = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String sql = "Call selectInstitucion()";
            pst = getConnection().prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                institucion.add(new Institucion(rs.getInt("id_institucion"),
                        rs.getString("desc_institucion")));
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

        return institucion;
    }
    
    public boolean crearInstitucion(Institucion i) {
        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "call crearInstitucion(?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, i.getDesc_institucion());
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
    
    public boolean modificarInstitucion(Institucion i) {
        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "call modificarInstitucion(?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setInt(1, i.getId_institucion());
            pst.setString(2, i.getDesc_institucion());
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
    
    public boolean borrarInstitucion(int id){
        boolean flag = false;
        PreparedStatement pst = null;
        
        try {
            String sql = "call eliminarInstitucion(?)";
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
