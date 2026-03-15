/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aurelimartinelligestionegite;

import java.util.ArrayList;

/**
 * Classe studente
 * @author aureli.giulia
 */
public class Studente {
    private String nome;
    private String cognome;
    private String classe;
    private int matricola;
    private ArrayList<Integer> idGita;

    /**
     * Metodo costruttore
     * @param nome nome dello studente
     * @param cognome cognome dello studente
     * @param classe classe dello studente
     * @param matricola matricola dello studente
     */
    public Studente(String nome, String cognome, String classe, int matricola) {
        this.nome = nome;
        this.cognome = cognome;
        this.classe = classe;
        this.matricola = matricola;
        idGita = new ArrayList<>();
    }

    /**
     * Metodo get
     * @return nome dello studente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo get
     * @return cognome dello studente
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Metodo get
     * @return classe dello studente
     */
    public String getClasse() {
        return classe;
    }

    /**
     * Metodo get
     * @return matricola dello studente
     */
    public int getMatricola() {
        return matricola;
    }

    /**
     * Metodo get
     * @return lista di id delle gite a cui lo studente e' iscritto
     */
    public ArrayList<Integer> getIdGita() {
        return idGita;
    }

    /**
     * Metodo che iscrive lo studente ad una gita
     * @param g gita
     * @return true se e' stato iscritto, false se non e' stato iscritto
     */
    public boolean iscrivi(Gita g){
        if(controlloIdGita(g.getId()))return false;
        idGita.add(g.getId());
        return true;
    }
    
    /**
     * Metodo che controlla se lo studente e' gia' iscritto ad una gita
     * @param idGita id della gita
     * @return true se e' gia' iscritto, false se non e' gia' iscritto
     */
    public boolean controlloIdGita(int idGita){
        for(int id : this.idGita){
            if(idGita == id)return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
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
        final Studente other = (Studente) obj;
        return this.matricola == other.matricola;
    }

    @Override
    public String toString() {
        return  nome + " " + cognome + " " + classe + ", matricola:" + matricola;
    }
    
    
}
