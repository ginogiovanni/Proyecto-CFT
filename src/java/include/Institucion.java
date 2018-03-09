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
public class Institucion {
    
    private int id_institucion;
    private String desc_institucion;

    public Institucion() {
    }

    public Institucion(int id_institucion) {
        this.id_institucion = id_institucion;
    }

    public Institucion(int id_institucion, String desc_institucion) {
        this.id_institucion = id_institucion;
        this.desc_institucion = desc_institucion;
    }

    public Institucion(String desc_institucion) {
        this.desc_institucion = desc_institucion;
    }

    
    /**
     * @return the id_institucion
     */
    public int getId_institucion() {
        return id_institucion;
    }

    /**
     * @param id_institucion the id_institucion to set
     */
    public void setId_institucion(int id_institucion) {
        this.id_institucion = id_institucion;
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
