/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aurelimartinelligestionegite;

import java.util.ArrayList;

/**
 *
 * @author utente
 */
public class GestioneStudenti {
    public static ArrayList<Studente> listaStudenti = new ArrayList<>();

    /**
     * Metodo get
     * @return lista di studenti
     */
    public static ArrayList<Studente> getListaStudenti() {
        return listaStudenti;
    }
    
    /**
     * Metodo che inizializza la lista
     */
    public static void inizializza(){
        listaStudenti = new ArrayList<>();
    }
    
    /**
     * Metodo che cerca tutti gli studenti iscritti ad una gita
     * @param g gita
     * @return arraylist di studenti che partecipano alla gita g
     */
    public static ArrayList<Studente> cercaStudentiPerGita(Gita g){
        ArrayList<Studente> studenti = new ArrayList<>();
        for(Studente s : listaStudenti){
            if(controlloIscrizioneStudente(s, g.getId())) studenti.add(s);
        }
        return studenti;
    }
    
    /**
     * Metodo che controlla se uno studente e' iscritto ad una gita
     * @param s studente
     * @param id id della gita
     * @return true se lo studente e' iscritto, false se lo studente non e' iscritto
     */
    private static boolean controlloIscrizioneStudente(Studente s, int id){
        for(int idGite : s.getIdGita()){
            if(id == idGite)return true;
        }
        return false;
    }
}
