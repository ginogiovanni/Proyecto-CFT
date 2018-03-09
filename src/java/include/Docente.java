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
public class Docente {
    
    private String rut_docente;
    private String nombre_docente;
    private String apellido_docente;
    private String sexo;
    private String direccion_docente;
    private String telefono_docente;
    private String email_docente;
    private String titulo_docente;

    public Docente() {
    }

    public Docente(String rut_docente, String nombre_docente, String apellido_docente, String sexo, String direccion_docente, String telefono_docente, String email_docente, String titulo_docente) {
        this.rut_docente = rut_docente;
        this.nombre_docente = nombre_docente;
        this.apellido_docente = apellido_docente;
        this.sexo = sexo;
        this.direccion_docente = direccion_docente;
        this.telefono_docente = telefono_docente;
        this.email_docente = email_docente;
        this.titulo_docente = titulo_docente;
    }

    
    /**
     * @return the rut_docente
     */
    public String getRut_docente() {
        return rut_docente;
    }

    /**
     * @param rut_docente the rut_docente to set
     */
    public void setRut_docente(String rut_docente) {
        this.rut_docente = rut_docente;
    }

    /**
     * @return the nombre_docente
     */
    public String getNombre_docente() {
        return nombre_docente;
    }

    /**
     * @param nombre_docente the nombre_docente to set
     */
    public void setNombre_docente(String nombre_docente) {
        this.nombre_docente = nombre_docente;
    }

    /**
     * @return the apellido_docente
     */
    public String getApellido_docente() {
        return apellido_docente;
    }

    /**
     * @param apellido_docente the apellido_docente to set
     */
    public void setApellido_docente(String apellido_docente) {
        this.apellido_docente = apellido_docente;
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
     * @return the direccion_docente
     */
    public String getDireccion_docente() {
        return direccion_docente;
    }

    /**
     * @param direccion_docente the direccion_docente to set
     */
    public void setDireccion_docente(String direccion_docente) {
        this.direccion_docente = direccion_docente;
    }

    /**
     * @return the telefono_docente
     */
    public String getTelefono_docente() {
        return telefono_docente;
    }

    /**
     * @param telefono_docente the telefono_docente to set
     */
    public void setTelefono_docente(String telefono_docente) {
        this.telefono_docente = telefono_docente;
    }

    /**
     * @return the email_docente
     */
    public String getEmail_docente() {
        return email_docente;
    }

    /**
     * @param email_docente the email_docente to set
     */
    public void setEmail_docente(String email_docente) {
        this.email_docente = email_docente;
    }

    /**
     * @return the titulo_docente
     */
    public String getTitulo_docente() {
        return titulo_docente;
    }

    /**
     * @param titulo_docente the titulo_docente to set
     */
    public void setTitulo_docente(String titulo_docente) {
        this.titulo_docente = titulo_docente;
    }
    
    
}
