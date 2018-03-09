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
public class Contrato {
    
    private int id_contrato;
    private String rut_docente_fk;
    private String fecha_contrato;
    private int duracion_contrato;
    private String salud;
    private double sueldo_bruto;

    public Contrato() {
    }

    public Contrato(int id_contrato, String rut_docente_fk, int duracion_contrato, String salud, double sueldo_bruto) {
        this.id_contrato = id_contrato;
        this.rut_docente_fk = rut_docente_fk;
        this.duracion_contrato = duracion_contrato;
        this.salud = salud;
        this.sueldo_bruto = sueldo_bruto;
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        this.fecha_contrato = sdf.format(d);
    }    

    public Contrato(int id_contrato, String rut_docente_fk, String fecha_contrato, String salud, int duracion_contrato, double sueldo_bruto) {
        this.id_contrato = id_contrato;
        this.rut_docente_fk = rut_docente_fk;
        this.fecha_contrato = fecha_contrato;
        this.salud = salud;
        this.duracion_contrato = duracion_contrato;
        this.sueldo_bruto = sueldo_bruto;
    }

    public String getSalud() {
        return salud;
    }

    public void setSalud(String salud) {
        this.salud = salud;
    }
    
    
    /**
     * @return the id_contrato
     */
    public int getId_contrato() {
        return id_contrato;
    }

    /**
     * @param id_contrato the id_contrato to set
     */
    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    /**
     * @return the rut_docente_fk
     */
    public String getRut_docente_fk() {
        return rut_docente_fk;
    }

    /**
     * @param rut_docente_fk the rut_docente_fk to set
     */
    public void setRut_docente_fk(String rut_docente_fk) {
        this.rut_docente_fk = rut_docente_fk;
    }

    /**
     * @return the fecha_contrato
     */
    public String getFecha_contrato() {
        return fecha_contrato;
    }

    /**
     * @param fecha_contrato the fecha_contrato to set
     */
    public void setFecha_contrato(String fecha_contrato) {
        this.fecha_contrato = fecha_contrato;
    }

    /**
     * @return the duracion_contrato
     */
    public int getDuracion_contrato() {
        return duracion_contrato;
    }

    /**
     * @param duracion_contrato the duracion_contrato to set
     */
    public void setDuracion_contrato(int duracion_contrato) {
        this.duracion_contrato = duracion_contrato;
    }

    /**
     * @return the sueldo_bruto
     */
    public double getSueldo_bruto() {
        return sueldo_bruto;
    }

    /**
     * @param sueldo_bruto the sueldo_bruto to set
     */
    public void setSueldo_bruto(double sueldo_bruto) {
        this.sueldo_bruto = sueldo_bruto;
    }
    
    
}
