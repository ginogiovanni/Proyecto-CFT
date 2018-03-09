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
public class Alumno {
    
    private String rut_alumno;
    private String nombre_alumno;
    private String apellido_alumno;
    private String sexo;
    private String direccion_alumno;
    private String telefono_alumno;
    private String email_alumno;

    public Alumno() {
    }

    public Alumno(String rut_alumno, String nombre_alumno, String apellido_alumno, String sexo, String direccion_alumno, String telefono_alumno, String email_alumno) {
        this.rut_alumno = rut_alumno;
        this.nombre_alumno = nombre_alumno;
        this.apellido_alumno = apellido_alumno;
        this.sexo = sexo;
        this.direccion_alumno = direccion_alumno;
        this.telefono_alumno = telefono_alumno;
        this.email_alumno = email_alumno;
    }
    
    /**
     * @return the rut_alumno
     */
    public String getRut_alumno() {
        return rut_alumno;
    }

    /**
     * @param rut_alumno the rut_alumno to set
     */
    public void setRut_alumno(String rut_alumno) {
        this.rut_alumno = rut_alumno;
    }

    /**
     * @return the nombre_alumno
     */
    public String getNombre_alumno() {
        return nombre_alumno;
    }

    /**
     * @param nombre_alumno the nombre_alumno to set
     */
    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    /**
     * @return the apellido_alumno
     */
    public String getApellido_alumno() {
        return apellido_alumno;
    }

    /**
     * @param apellido_alumno the apellido_alumno to set
     */
    public void setApellido_alumno(String apellido_alumno) {
        this.apellido_alumno = apellido_alumno;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the direccion_alumno
     */
    public String getDireccion_alumno() {
        return direccion_alumno;
    }

    /**
     * @param direccion_alumno the direccion_alumno to set
     */
    public void setDireccion_alumno(String direccion_alumno) {
        this.direccion_alumno = direccion_alumno;
    }

    /**
     * @return the telefono_alumno
     */
    public String getTelefono_alumno() {
        return telefono_alumno;
    }

    /**
     * @param telefono_alumno the telefono_alumno to set
     */
    public void setTelefono_alumno(String telefono_alumno) {
        this.telefono_alumno = telefono_alumno;
    }

    /**
     * @return the email_alumno
     */
    public String getEmail_alumno() {
        return email_alumno;
    }

    /**
     * @param email_alumno the email_alumno to set
     */
    public void setEmail_alumno(String email_alumno) {
        this.email_alumno = email_alumno;
    }
    
    
}
