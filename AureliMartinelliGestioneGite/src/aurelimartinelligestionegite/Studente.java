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
    
    
}
