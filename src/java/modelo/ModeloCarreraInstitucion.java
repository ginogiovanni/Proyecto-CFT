/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Hawk
 */
public class ModeloCarreraInstitucion extends Conexion{
    
//    public ArrayList<CarreraInstitucion> getCarreraInstitucion() {
//        
//        ArrayList<CarreraInstitucion> carreraInstitucion = new ArrayList<>();
//        PreparedStatement pst = null;
//        ResultSet rs = null;
//
//        try {
//            String sql = "Call selectCarrerasInstitucion()";
//            pst = getConnection().prepareCall(sql);
//            rs = pst.executeQuery();
//            while (rs.next()) {
//                carreraInstitucion.add(new CarreraInstitucion(rs.getInt("id_carreraInstitucion"),
//                        rs.getString("Carreras")));
//            }
//        } catch (Exception e) {
//        } finally {
//            try {
//                if (getConnection() != null) {
//                    getConnection().close();
//                }
//                if (pst != null) {
//                    pst.close();
//                }
//            } catch (Exception e) {
//            }
//        }
//
//        return carreraInstitucion;
//    }
}
