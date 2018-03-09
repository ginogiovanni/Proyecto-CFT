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
public class UsuariosPersonal {
    
    private int id_usuario;
    private String nombre_usuario;
    private String password;
    private String tipo_usuario;
    private String rut_usuario_fk;

    public UsuariosPersonal() {
    }

    public UsuariosPersonal(int id_usuario, String nombre_usuario, String password, String tipo_usuario, String rut_usuario_fk) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        this.tipo_usuario = tipo_usuario;
        this.rut_usuario_fk = rut_usuario_fk;
    }

    public UsuariosPersonal(int id_usuario, String nombre_usuario, String password, String tipo_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        this.tipo_usuario = tipo_usuario;
    }

    
    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the nombre_usuario
     */
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    /**
     * @param nombre_usuario the nombre_usuario to set
     */
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the tipo_usuario
     */
    public String getTipo_usuario() {
        return tipo_usuario;
    }

    /**
     * @param tipo_usuario the tipo_usuario to set
     */
    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    /**
     * @return the rut_usuario_fk
     */
    public String getRut_usuario_fk() {
        return rut_usuario_fk;
    }

    /**
     * @param rut_usuario_fk the rut_usuario_fk to set
     */
    public void setRut_usuario_fk(String rut_usuario_fk) {
        this.rut_usuario_fk = rut_usuario_fk;
    }
    
    
}
