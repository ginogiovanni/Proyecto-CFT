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
public class DetallePago {
    
    private int id_pago;
    private String fecha_pago;
    private String rut_docente_fk;
    private int id_contrato_fk;
    private double sueldo_liquido;

    public DetallePago() {
    }

    public DetallePago(int id_pago, int id_contrato_fk, double sueldo_liquido) {
        this.id_pago = id_pago;
        this.id_contrato_fk = id_contrato_fk;
        this.sueldo_liquido = sueldo_liquido;
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        this.fecha_pago = sdf.format(d);
    }

    
    public DetallePago(int id_pago, String fecha_pago, int id_contrato_fk, double sueldo_liquido) {
        this.id_pago = id_pago;
        this.fecha_pago = fecha_pago;
        this.id_contrato_fk = id_contrato_fk;
        this.sueldo_liquido = sueldo_liquido;
    }

    public DetallePago(int id_pago, String fecha_pago, String rut_docente_fk, double sueldo_liquido) {
        this.id_pago = id_pago;
        this.fecha_pago = fecha_pago;
        this.rut_docente_fk = rut_docente_fk;
        this.sueldo_liquido = sueldo_liquido;
    }

    public String getRut_docente_fk() {
        return rut_docente_fk;
    }

    public void setRut_docente_fk(String rut_docente_fk) {
        this.rut_docente_fk = rut_docente_fk;
    }
    
    
    /**
     * @return the id_pago
     */
    public int getId_pago() {
        return id_pago;
    }

    /**
     * @param id_pago the id_pago to set
     */
    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    /**
     * @return the fecha_pago
     */
    public String getFecha_pago() {
        return fecha_pago;
    }

    /**
     * @param fecha_pago the fecha_pago to set
     */
    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    /**
     * @return the id_contrato_fk
     */
    public int getId_contrato_fk() {
        return id_contrato_fk;
    }

    /**
     * @param id_contrato_fk the id_contrato_fk to set
     */
    public void setId_contrato_fk(int id_contrato_fk) {
        this.id_contrato_fk = id_contrato_fk;
    }

    /**
     * @return the sueldo_liquido
     */
    public double getSueldo_liquido() {
        return sueldo_liquido;
    }

    /**
     * @param sueldo_liquido the sueldo_liquido to set
     */
    public void setSueldo_liquido(double sueldo_liquido) {
        this.sueldo_liquido = sueldo_liquido;
    }
    
    
}
