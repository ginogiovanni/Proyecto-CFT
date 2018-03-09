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
public class Carrera {
    
    private int id_carrera;
    private String desc_carrera;

    public Carrera() {
    }

    public Carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }
    

    public Carrera(int id_carrera, String desc_carrera) {
        this.id_carrera = id_carrera;
        this.desc_carrera = desc_carrera;
    }

    public Carrera(String desc_carrera) {
        this.desc_carrera = desc_carrera;
    }
    
    
    
    /**
     * @return the id_carrera
     */
    public int getId_carrera() {
        return id_carrera;
    }

    /**
     * @param id_carrera the id_carrera to set
     */
    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
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
    
    
}
