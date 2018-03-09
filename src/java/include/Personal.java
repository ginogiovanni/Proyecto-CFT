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
public class Personal {
    private String rut_personal;
    private String nombre_personal;
    private String apellidos_personal;
    private String sexo;
    private String direccion_personal;
    private String telefono_personal;
    private String email_personal;

    public Personal() {
    }

    public Personal(String rut_personal, String nombre_personal, String apellidos_personal, String sexo, String direccion_personal, String telefono_personal, String email_personal) {
        this.rut_personal = rut_personal;
        this.nombre_personal = nombre_personal;
        this.apellidos_personal = apellidos_personal;
        this.sexo = sexo;
        this.direccion_personal = direccion_personal;
        this.telefono_personal = telefono_personal;
        this.email_personal = email_personal;
    }
    
    /**
     * @return the rut_personal
     */
    public String getRut_personal() {
        return rut_personal;
    }

    /**
     * @param rut_personal the rut_personal to set
     */
    public void setRut_personal(String rut_personal) {
        this.rut_personal = rut_personal;
    }

    /**
     * @return the nombre_personal
     */
    public String getNombre_personal() {
        return nombre_personal;
    }

    /**
     * @param nombre_personal the nombre_personal to set
     */
    public void setNombre_personal(String nombre_personal) {
        this.nombre_personal = nombre_personal;
    }

    /**
     * @return the apellidos_personal
     */
    public String getApellidos_personal() {
        return apellidos_personal;
    }

    /**
     * @param apellidos_personal the apellidos_personal to set
     */
    public void setApellidos_personal(String apellidos_personal) {
        this.apellidos_personal = apellidos_personal;
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
     * @return the direccion_personal
     */
    public String getDireccion_personal() {
        return direccion_personal;
    }

    /**
     * @param direccion_personal the direccion_personal to set
     */
    public void setDireccion_personal(String direccion_personal) {
        this.direccion_personal = direccion_personal;
    }

    /**
     * @return the telefono_personal
     */
    public String getTelefono_personal() {
        return telefono_personal;
    }

    /**
     * @param telefono_personal the telefono_personal to set
     */
    public void setTelefono_personal(String telefono_personal) {
        this.telefono_personal = telefono_personal;
    }

    /**
     * @return the email_personal
     */
    public String getEmail_personal() {
        return email_personal;
    }

    /**
     * @param email_personal the email_personal to set
     */
    public void setEmail_personal(String email_personal) {
        this.email_personal = email_personal;
    }
}
