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
public class Usuario {
    private int id_usuario;
    private String nombreUsuario;
    private String pass;
    private String tipoUsuario;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String pass, String tipoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.pass = pass;
        this.tipoUsuario = tipoUsuario;
    }
    
    public Usuario(int id_usuario, String nombreUsuario, String pass, String tipoUsuario) {
        this.id_usuario = id_usuario;
        this.nombreUsuario = nombreUsuario;
        this.pass = pass;
        this.tipoUsuario = tipoUsuario;
    }
    
    public Usuario(String nombreUsuario, String pass){
        this.nombreUsuario = nombreUsuario;
        this.pass = pass;
    }
    
    public Usuario(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the tipoUsuario
     */
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * @param tipoUsuario the tipoUsuario to set
     */
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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
}