/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import include.Personal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Hawk
 */
public class ModeloPersonal extends Conexion {

    public ArrayList<Personal> getPersonal() {
        ArrayList<Personal> personal = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String sql = "Call selectPersonal()";
            pst = getConnection().prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                personal.add(new Personal(rs.getString("rut_personal"),
                        rs.getString("nombre_personal"), rs.getString("apellidos_personal"),
                        rs.getString("sexo"), rs.getString("direccion_personal"),
                        rs.getString("telefono_personal"), rs.getString("email_personal")));
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

        return personal;
    }
    
    public boolean crearPersonal(Personal p) {
        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "call crearPersonal(?,?,?,?,?,?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, p.getRut_personal());
            pst.setString(2, p.getNombre_personal());
            pst.setString(3, p.getApellidos_personal());
            pst.setString(4, p.getSexo());
            pst.setString(5, p.getDireccion_personal());
            pst.setString(6, p.getTelefono_personal());
            pst.setString(7, p.getEmail_personal());
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
    
    public boolean borrarPersonal(String rut){
        boolean flag = false;
        PreparedStatement pst = null;
        
        try {
            String sql = "call eliminarPersonal(?)";
            pst = getConnection().prepareCall(sql);
            pst.setString(1, rut);
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

    public boolean modificarPersonal(Personal p) {
        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "call modificarPersonal(?,?,?,?,?,?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, p.getRut_personal());
            pst.setString(2, p.getNombre_personal());
            pst.setString(3, p.getApellidos_personal());
            pst.setString(4, p.getSexo());
            pst.setString(5, p.getDireccion_personal());
            pst.setString(6, p.getTelefono_personal());
            pst.setString(7, p.getEmail_personal());
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
