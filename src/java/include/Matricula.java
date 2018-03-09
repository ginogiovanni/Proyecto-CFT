/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package include;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Hawk
 */
public class Matricula {
    
    /*Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        this.fecha_matricula = sdf.format(d);*/
    
    private int id_matricula;
    private String rut_alumno_fk;
    private String semestre;
    private double monto;
    private String modalidad;
    private String fecha_matricula;
    private String desc_carrera;
    private String desc_institucion;
    private String desc_ciclo;

    public Matricula() {
    }

    public Matricula(String semestre, double monto, String modalidad) {
        this.semestre = semestre;
        this.monto = monto;
        this.modalidad = modalidad;
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        this.fecha_matricula = sdf.format(d);
    }
    
    

    public Matricula(int id_matricula, String semestre, double monto) {
        this.id_matricula = id_matricula;
        this.semestre = semestre;
        this.monto = monto;
    }

    
    public Matricula(int id_matricula, String rut_alumno_fk, String semestre, String modalidad, double monto, String fecha_matricula, String desc_carrera, String desc_institucion, String desc_ciclo) {
        this.id_matricula = id_matricula;
        this.rut_alumno_fk = rut_alumno_fk;
        this.semestre = semestre;
        this.modalidad = modalidad;
        this.monto = monto;
        this.fecha_matricula = fecha_matricula;
        this.desc_carrera = desc_carrera;
        this.desc_institucion = desc_institucion;
        this.desc_ciclo = desc_ciclo;
    }

    public Matricula(String semestre, double monto) {
        this.semestre = semestre;
        this.monto = monto;
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        this.fecha_matricula = sdf.format(d);
    }
    
    

    public Matricula(int id_matricula, String rut_alumno_fk, String semestre, double monto, String fecha_matricula, String desc_carrera, String desc_institucion) {
        this.id_matricula = id_matricula;
        this.rut_alumno_fk = rut_alumno_fk;
        this.semestre = semestre;
        this.monto = monto;
        this.fecha_matricula = fecha_matricula;
        this.desc_carrera = desc_carrera;
        this.desc_institucion = desc_institucion;
    }
    
    public Matricula(String rut_alumno_fk, String semestre, double monto, String fecha_matricula, String desc_carrera, String desc_institucion) {
        this.rut_alumno_fk = rut_alumno_fk;
        this.semestre = semestre;
        this.monto = monto;
        this.fecha_matricula = fecha_matricula;
        this.desc_carrera = desc_carrera;
        this.desc_institucion = desc_institucion;
    }
    
    public Matricula(int id_matricula, String rut_alumno_fk, String semestre, double monto, String desc_carrera, String desc_institucion) {
        this.id_matricula = id_matricula;
        this.rut_alumno_fk = rut_alumno_fk;
        this.semestre = semestre;
        this.monto = monto;
        this.desc_carrera = desc_carrera;
        this.desc_institucion = desc_institucion;
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        this.fecha_matricula = sdf.format(d);
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getDesc_ciclo() {
        return desc_ciclo;
    }

    public void setDesc_ciclo(String desc_ciclo) {
        this.desc_ciclo = desc_ciclo;
    }

    
    
    
    /**
     * @return the id_matricula
     */
    public int getId_matricula() {
        return id_matricula;
    }

    /**
     * @param id_matricula the id_matricula to set
     */
    public void setId_matricula(int id_matricula) {
        this.id_matricula = id_matricula;
    }

    /**
     * @return the rut_alumno_fk
     */
    public String getRut_alumno_fk() {
        return rut_alumno_fk;
    }

    /**
     * @param rut_alumno_fk the rut_alumno_fk to set
     */
    public void setRut_alumno_fk(String rut_alumno_fk) {
        this.rut_alumno_fk = rut_alumno_fk;
    }   

    /**
     * @return the semestre
     */
    public String getSemestre() {
        return semestre;
    }

    /**
     * @param semestre the semestre to set
     */
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    /**
     * @return the monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * @return the fecha_matricula
     */
    public String getFecha_matricula() {
        return fecha_matricula;
    }

    /**
     * @param fecha_matricula the fecha_matricula to set
     */
    public void setFecha_matricula(String fecha_matricula) {
        this.fecha_matricula = fecha_matricula;
    }

    

    /**
     * @return the desc_carrera
     */
    public String getDesc_carrera() {
        return desc_carrera;
    }

    /**
     * @param desc_carrera the desc_carrera to set
     */
    public void setDesc_carrera(String desc_carrera) {
        this.desc_carrera = desc_carrera;
    }

    /**
     * @return the desc_institucion
     */
    public String getDesc_institucion() {
        return desc_institucion;
    }

    /**
     * @param desc_institucion the desc_institucion to set
     */
    public void setDesc_institucion(String desc_institucion) {
        this.desc_institucion = desc_institucion;
    }
    
    
   
    
}
