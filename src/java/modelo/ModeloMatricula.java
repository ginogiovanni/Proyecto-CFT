/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import include.Alumno;
import include.Carrera;
import include.Ciclo;
import include.Institucion;
import include.Matricula;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Hawk
 */
public class ModeloMatricula extends Conexion{
    
    public ArrayList<Matricula> getMatricula() {
        
        ArrayList<Matricula> matricula = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String sql = "Call selectMatriculaAlumno()";
            pst = getConnection().prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                matricula.add(new Matricula(
                        rs.getInt("id_matricula"),
                        rs.getString("rut_alumno"),
                        rs.getString("semestre"),
                        rs.getString("modalidad"),
                        rs.getDouble("monto"),
                        rs.getString("fecha_matricula"),
                        rs.getString("desc_carrera"),
                        rs.getString("desc_institucion"),
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

        return matricula;
    }
    
    
    
    public boolean crearMatricula(Matricula m, Alumno a, Institucion i, Carrera c, Ciclo ci) {
        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "call crearMatriculaAlumno(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, a.getRut_alumno());
            pst.setString(2, a.getNombre_alumno());
            pst.setString(3, a.getApellido_alumno());
            pst.setString(4, a.getSexo());
            pst.setString(5, a.getDireccion_alumno());
            pst.setString(6, a.getTelefono_alumno());
            pst.setString(7, a.getEmail_alumno());
            pst.setInt(8, c.getId_carrera());
            pst.setInt(9, i.getId_institucion());
            pst.setString(10, m.getSemestre());
            pst.setString(11, m.getModalidad());
            pst.setString(12, Double.toString(m.getMonto()));
            pst.setString(13, m.getFecha_matricula());
            pst.setString(14, ci.getCod_ciclo());
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
    
    public boolean modificarMatricula(Matricula m) {
        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "call modificarMatricula(?,?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setInt(1, m.getId_matricula());
            pst.setString(2, m.getSemestre());
            pst.setDouble(3, m.getMonto());
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
