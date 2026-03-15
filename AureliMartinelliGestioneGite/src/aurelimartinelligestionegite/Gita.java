/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aurelimartinelligestionegite;

import java.util.Objects;

/**
 * Classe gita
 * @author aureli.giulia
 */
public class Gita {
    private String localita;
    private String data;
    private int id;

    /**
     * Metodo costrutore
     * @param localita luogo della gita
     * @param data data della gita
     * @param id id della gita
     */
    public Gita(String localita, String data, int id) {
        this.localita = localita;
        this.data = data;
        this.id = id;
    }

    /**
     * Metodo get
     * @return luogo della gita
     */
    public String getLocalita() {
        return localita;
    }

    /**
     * Metodo get
     * @return data della gita
     */
    public String getData() {
        return data;
    }

    /**
     * Metodo get
     * @return id della gita
     */
    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Gita other = (Gita) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.localita, other.localita)) {
            return false;
        }
        return Objects.equals(this.data, other.data);
    }

    @Override
    public String toString() {
        return localita + " " + data + ", id:" + id;
    }
    
    
    
}
