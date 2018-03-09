/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import include.UsuariosPersonal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Hawk
 */
public class ModeloUsuariosDocente extends Conexion{
    
    public ArrayList<UsuariosPersonal> getUsuariosPersonal() {

        ArrayList<UsuariosPersonal> usuariosP = new ArrayList<>();
         PreparedStatement pst = null;
         ResultSet rs = null;

        try {
            String sql = "Call selectUsuariosDocente()";
            pst = getConnection().prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                usuariosP.add(new UsuariosPersonal(rs.getInt("id_usuario"),
                        rs.getString("nombre_usuario"),
                        rs.getString("password"),
                        rs.getString("tipo_usuario"),
                        rs.getString("rut_docente_fk")));
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

        return usuariosP;
    }
    
     public boolean crearUsuario(UsuariosPersonal up) {
        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "call insertUsuariosDocente(?,?,?,?);";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, up.getNombre_usuario());
            pst.setString(2, up.getPassword());
            pst.setString(3, up.getTipo_usuario());
            pst.setString(4, up.getRut_usuario_fk());
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
     
     public boolean borrarUsuarioAlumno(int id){
        boolean flag = false;
        PreparedStatement pst = null;
        
        try {
            String sql = "call eliminarUsuarioDocente(?)";
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
