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
public class Asignatura {
    
    private int id_asignatura;
    private String desc_asignatura;

    public Asignatura() {
    }

    public Asignatura(int id_asignatura, String desc_asignatura) {
        this.id_asignatura = id_asignatura;
        this.desc_asignatura = desc_asignatura;
    }

    /**
     * @return the id_asignatura
     */
    public int getId_asignatura() {
        return id_asignatura;
    }

    /**
     * @param id_asignatura the id_asignatura to set
     */
    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    /**
     * @return the desc_asignatura
     */
    public String getDesc_asignatura() {
        return desc_asignatura;
    }

    /**
     * @param desc_asignatura the desc_asignatura to set
     */
    public void setDesc_asignatura(String desc_asignatura) {
        this.desc_asignatura = desc_asignatura;
    }
    
}
