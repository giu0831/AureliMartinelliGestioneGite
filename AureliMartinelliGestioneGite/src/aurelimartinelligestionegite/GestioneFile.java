/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aurelimartinelligestionegite;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author aureli.giulia
 */
public class GestioneFile {
    
    /**
     * Metodo che carica i dati dai file
     */
    public void caricaDaFile(){
        leggiStudenti();
        leggiGite();
    }
    
    /**
     * Metodo che salva i dati sui file
     */
    public void salvaSuFile(){
        scriviGite();
        scriviStudenti();
    }
    
    /**
     * Metodo che svuota i file
     */
    public void svuota() {
        svuotaGite();
        svuotaStudenti();
    }
    
    /**
     * Metodo che svuota il file delle gite
     */
    public void svuotaGite(){
        try {
            RandomAccessFile file = new RandomAccessFile("elenco_gite.dat", "rw");
            file.setLength(0); // svuota il file
            file.close();
            System.out.println("File svuotato con successo");
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato");
        } catch (IOException e) {
            System.out.println("Errore durante la modifica del file");
        }
    }
    
    /**
     * Metodo che svuota il file degli studenti
     */
    public void svuotaStudenti(){
        try {
            RandomAccessFile file = new RandomAccessFile("elenco_studenti.dat", "rw");
            file.setLength(0); // svuota il file
            file.close();
            System.out.println("File svuotato con successo");
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato");
        } catch (IOException e) {
            System.out.println("Errore durante la modifica del file");
        }
    }
    
    /**
     * Metodo che salva i dati delle gite nel file
     */
    public void scriviGite(){
        try {
            RandomAccessFile file = new RandomAccessFile("elenco_gite.dat", "rw");
            file.setLength(0); // svuota il file
            for(Gita g : GestioneGite.getListaGite()){
            file.writeChars(aggiustaLunghezza(g.getLocalita(), 17));
            file.writeChars(aggiustaLunghezza(g.getData(), 12));
            file.writeInt(g.getId());
            }
            
            file.close();

            System.out.println("Gita aggiunta al file");

        } catch (FileNotFoundException ex) {
            System.out.println("File non trovato");
        } catch (IOException e) {
            System.out.println("Problema in lettura-scrittura file");
        }
    }
    
    /**
     * Metodo che salva i dati degli studenti nel file
     */
    public void scriviStudenti(){
        try {
            RandomAccessFile file = new RandomAccessFile("elenco_studenti.dat", "rw");
            file.setLength(0); // svuota il file
            for(Studente s : GestioneStudenti.getListaStudenti()){
            file.writeChars(aggiustaLunghezza(s.getNome(), 10));
            file.writeChars(aggiustaLunghezza(s.getCognome(), 10));
            file.writeChars(aggiustaLunghezza(s.getClasse(), 2));
            file.writeInt(s.getMatricola());
            }
            
            file.close();

            System.out.println("Studente aggiunto al file");

        } catch (FileNotFoundException ex) {
            System.out.println("File non trovato");
        } catch (IOException e) {
            System.out.println("Problema in lettura-scrittura file");
        }
    }
    
    /**
     * Metodo che carica i dati delle gite dal file
     */
    public void leggiGite(){
        try {
            RandomAccessFile file = new RandomAccessFile("elenco_gite.dat", "r");
            //calcolo la dimensione del file per capire quanti record ci sono. 

            int nRecord = (int) (file.length() / 62);
            if (nRecord > 0) {
                int recordAttuale = 0;
                GestioneGite.inizializza();
                while (recordAttuale < nRecord) {
                    file.seek(recordAttuale * 62);
                    //leggo il nome ricordando che è di 34 caratteri
                    String luogoLetto = "";
                    for (int i = 0; i < 17; i++) {
                        luogoLetto += file.readChar();
                    }
                    //leggo il nome ricordando che è di 24 caratteri
                    String dataLetta = "";
                    for (int i = 0; i < 12; i++) {
                        dataLetta += file.readChar();
                    }
                    int idLetto = file.readInt();
                    GestioneGite.getListaGite().add(new Gita(luogoLetto.replace("*", ""), dataLetta.replace("*", ""), idLetto));
                    recordAttuale++;
                }
            }
            file.close();

        } catch (FileNotFoundException ex) {
            System.out.println("File non trovato");
        } catch (IOException e) {
            System.out.println("Problema in lettura-scrittura file");
        }
    }
    
    /**
     * Metodo che carica i dati degli studenti dal file
     */
    public void leggiStudenti(){
        try {
            RandomAccessFile file = new RandomAccessFile("elenco_studenti.dat", "r");
            int nRecord = (int) (file.length() / 48);
            if (nRecord > 0) {
                int recordAttuale = 0;
                GestioneStudenti.inizializza();
                while (recordAttuale < nRecord) {
                    file.seek(recordAttuale * 48);
                    //leggo il nome ricordando che è di 34 caratteri
                    String nomeLetto = "";
                    for (int i = 0; i < 10; i++) {
                        nomeLetto += file.readChar();
                    }
                    //leggo il nome ricordando che è di 24 caratteri
                    String cognomeLetto = "";
                    for (int i = 0; i < 10; i++) {
                        cognomeLetto += file.readChar();
                    }
                    //leggo il nome ricordando che è di 24 caratteri
                    String classeLetta = "";
                    for (int i = 0; i < 2; i++) {
                        classeLetta += file.readChar();
                    }
                    int matricolaLetta = file.readInt();
                    GestioneStudenti.getListaStudenti().add(new Studente(nomeLetto.replace("*", ""), cognomeLetto.replace("*", ""), classeLetta.replace("*", ""), matricolaLetta));
                    recordAttuale++;
                }
            }
            file.close();

        } catch (FileNotFoundException ex) {
            System.out.println("File non trovato");
        } catch (IOException e) {
            System.out.println("Problema in lettura-scrittura file");
        }
    }
    
    /**
     * Metodo che conta quanti record sono presenti nel file studenti
     * @return numero di record nel file studenti
     */
    public int contaRecordStudenti(){
        int nRecord = 0;
        try{
            RandomAccessFile file = new RandomAccessFile("elenco_studenti.dat", "r");
            nRecord = (int) (file.length() / 48);
        } catch (FileNotFoundException ex) {
            System.out.println("File non trovato");
        } catch (IOException e) {
            System.out.println("Problema in lettura-scrittura file");
        }
        return nRecord;
    }
    
    /**
     * Metodo che conta quanti record sono presenti nel file delle gite
     * @return record presenti nel file delle gite
     */
    public int contaRecordGite(){
        int nRecord = 0;
        try{
            RandomAccessFile file = new RandomAccessFile("elenco_gite.dat", "r");
            nRecord = (int) (file.length() / 62);
        } catch (FileNotFoundException ex) {
            System.out.println("File non trovato");
        } catch (IOException e) {
            System.out.println("Problema in lettura-scrittura file");
        }
        return nRecord;
    }
    
    /**
     * Metodo che aggiusta la lunghezza di una stringa in modo da farla rientrare nella dimensione corretta
     * @param s stringa
     * @param dimensione dimensione da rispettare
     * @return stringa modificata con la lunghezza corretta
     */
    private String aggiustaLunghezza(String s, int dimensione) {
        String aggiustata=s;
        //se la stringa e' piu' piccola si aggiunge *
        if (s.length() < dimensione) {
            for (int i = 0; i < (dimensione - s.length()); i++) {
                aggiustata += "*";
            }
            return aggiustata;
         //se la stringa e' piu' grande si taglia
        } else if (s.length() > dimensione) { 
            aggiustata = s.substring(0, dimensione);
            return aggiustata;
        }
        return s;
    }
}
