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
public class GestioneGite {
    private static ArrayList<Gita> listaGite = new ArrayList<>();

    /**
     * Metodo get
     * @return arraylist di gite
     */
    public static ArrayList<Gita> getListaGite() {
        return listaGite;
    }
    
    /**
     * Metodo che inizializza l'arraylist di gite
     */
    public static void inizializza(){
        listaGite = new ArrayList<>();
    }
    
    /**
     * Metodo che cerca tutte le gite a cui partecipa uno studente
     * @param s studente
     * @return arraylist di gite a cui lo studente s partecipa
     */
    public static ArrayList<Gita> cercaGitePerStudente(Studente s){
        ArrayList<Gita> gite = new ArrayList<>();
        for(int id : s.getIdGita()){
            Gita g = cercaGitaPerId(id);
            if(g != null) gite.add(g);
        }
        return gite;
    }
    
    /**
     * Metodo che cerca le gite in  base all'id
     * @param id id
     * @return gita con l'id corrispondente
     */
    private static Gita cercaGitaPerId(int id){
        for(Gita g : GestioneGite.getListaGite()){
            if(id == g.getId())return g;
        }
        return null;
    }
}
