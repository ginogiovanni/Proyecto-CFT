/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import include.Asignatura;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Hawk
 */
public class ModeloAsignatura extends Conexion {

    public ArrayList<Asignatura> getAsignatura() {

        ArrayList<Asignatura> asignatura = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String sql = "Call selectAsignatura()";
            pst = getConnection().prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                asignatura.add(new Asignatura(rs.getInt("id_asignatura"),
                        rs.getString("desc_asignatura")));
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

        return asignatura;
    }

    public boolean crearAsignatura(Asignatura a) {
        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "call crearAsignatura(?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, a.getDesc_asignatura());
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

    public boolean modificarAsignatura(Asignatura a) {
        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "call modificarAsignatura(?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setInt(1, a.getId_asignatura());
            pst.setString(2, a.getDesc_asignatura());
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
}
