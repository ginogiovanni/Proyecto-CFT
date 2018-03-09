/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package include;

/**
 *
 * @author Hawk
 */
public class MantAsignaturas {
    
    private int id_mant_asignaturas;
    private int id_asignatura_fk;
    private String rut_docente_fk;
    private String cod_ciclo_fk;
    private String rut_alumno_fk;
    
    private String asignatura;
    private String docente;
    private String ciclo;
    private String alumno;

    public MantAsignaturas() {
    }

    public MantAsignaturas(int id_mant_asignaturas, int id_asignatura_fk, String rut_docente_fk, String cod_ciclo_fk, String rut_alumno_fk) {
        this.id_mant_asignaturas = id_mant_asignaturas;
        this.id_asignatura_fk = id_asignatura_fk;
        this.rut_docente_fk = rut_docente_fk;
        this.cod_ciclo_fk = cod_ciclo_fk;
        this.rut_alumno_fk = rut_alumno_fk;
    }

    public MantAsignaturas(int id_mant_asignaturas, String asignatura, String docente, String ciclo, String alumno) {
        this.id_mant_asignaturas = id_mant_asignaturas;
        this.asignatura = asignatura;
        this.docente = docente;
        this.ciclo = ciclo;
        this.alumno = alumno;
    }    
    
    /**
     * @return the id_mant_asignaturas
     */
    public int getId_mant_asignaturas() {
        return id_mant_asignaturas;
    }

    /**
     * @param id_mant_asignaturas the id_mant_asignaturas to set
     */
    public void setId_mant_asignaturas(int id_mant_asignaturas) {
        this.id_mant_asignaturas = id_mant_asignaturas;
    }

    /**
     * @return the id_asignatura_fk
     */
    public int getId_asignatura_fk() {
        return id_asignatura_fk;
    }

    /**
     * @param id_asignatura_fk the id_asignatura_fk to set
     */
    public void setId_asignatura_fk(int id_asignatura_fk) {
        this.id_asignatura_fk = id_asignatura_fk;
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
     * @return the cod_ciclo_fk
     */
    public String getCod_ciclo_fk() {
        return cod_ciclo_fk;
    }

    /**
     * @param cod_ciclo_fk the cod_ciclo_fk to set
     */
    public void setCod_ciclo_fk(String cod_ciclo_fk) {
        this.cod_ciclo_fk = cod_ciclo_fk;
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
     * @return the asignatura
     */
    public String getAsignatura() {
        return asignatura;
    }

    /**
     * @param asignatura the asignatura to set
     */
    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    /**
     * @return the docente
     */
    public String getDocente() {
        return docente;
    }

    /**
     * @param docente the docente to set
     */
    public void setDocente(String docente) {
        this.docente = docente;
    }

    /**
     * @return the ciclo
     */
    public String getCiclo() {
        return ciclo;
    }

    /**
     * @param ciclo the ciclo to set
     */
    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    /**
     * @return the alumno
     */
    public String getAlumno() {
        return alumno;
    }

    /**
     * @param alumno the alumno to set
     */
    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }
    
    
    
}
