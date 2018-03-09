/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import include.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Hawk
 */
public class ModeloUsuario extends Conexion{
    public boolean autenticar(Usuario u){
        boolean flag = false;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "call autenticar(?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, u.getNombreUsuario());
            pst.setString(2, u.getPass());
            rs = pst.executeQuery();
            if (rs.absolute(1)) {
                flag = true;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }finally{
            try {
                if (getConnection() != null) getConnection().close();
                if (pst != null) pst.close();
                if (rs != null) rs.close();
            } catch (Exception e) {
            }
        }
        
        return flag;
    }
}
