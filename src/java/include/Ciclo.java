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
public class Ciclo {
    
    private String cod_ciclo;
    private String desc_ciclo;
    private int anio_ciclo;
    private int id_carrera_fk;

    public Ciclo() {
    }

    public Ciclo(String cod_ciclo, String desc_ciclo, int anio_ciclo, int id_carrera_fk) {
        this.cod_ciclo = cod_ciclo;
        this.desc_ciclo = desc_ciclo;
        this.anio_ciclo = anio_ciclo;
        this.id_carrera_fk = id_carrera_fk;
    }

    public Ciclo(String cod_ciclo, String desc_ciclo) {
        this.cod_ciclo = cod_ciclo;
        this.desc_ciclo = desc_ciclo;
    }

    public Ciclo(String cod_ciclo) {
        this.cod_ciclo = cod_ciclo;
    }

    public Ciclo(String cod_ciclo, String desc_ciclo, int anio_ciclo) {
        this.cod_ciclo = cod_ciclo;
        this.desc_ciclo = desc_ciclo;
        this.anio_ciclo = anio_ciclo;
    }
    
    
    
    

    /**
     * @return the cod_ciclo
     */
    public String getCod_ciclo() {
        return cod_ciclo;
    }

    /**
     * @param cod_ciclo the cod_ciclo to set
     */
    public void setCod_ciclo(String cod_ciclo) {
        this.cod_ciclo = cod_ciclo;
    }

    /**
     * @return the desc_ciclo
     */
    public String getDesc_ciclo() {
        return desc_ciclo;
    }

    /**
     * @param desc_ciclo the desc_ciclo to set
     */
    public void setDesc_ciclo(String desc_ciclo) {
        this.desc_ciclo = desc_ciclo;
    }

    /**
     * @return the anio_ciclo
     */
    public int getAnio_ciclo() {
        return anio_ciclo;
    }

    /**
     * @param anio_ciclo the anio_ciclo to set
     */
    public void setAnio_ciclo(int anio_ciclo) {
        this.anio_ciclo = anio_ciclo;
    }

    /**
     * @return the id_carrera_fk
     */
    public int getId_carrera_fk() {
        return id_carrera_fk;
    }

    /**
     * @param id_carrera_fk the id_carrera_fk to set
     */
    public void setId_carrera_fk(int id_carrera_fk) {
        this.id_carrera_fk = id_carrera_fk;
    }
    
}
