
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samir pellegrini
 */
public class ProduciDato extends Thread {
    Semaforo pieno;   //risorsa mancante
    Semaforo vuoto;   //risorsa assegnata 
    int tanti=5; //numero di elementi da produre
    public ProduciDato(Semaforo pieno,Semaforo vuoto)
    {
        this.pieno=pieno;
        this.vuoto=vuoto;
    }
    public void run()
    {
        for(int i=0;i<tanti;i++)         {
            try // per tutti i dati da produrre
            {
                vuoto.P(); // semaforo rosso,in attesa di risorsa
                ProdConsSem.buffer=i;  //produce un numero
                System.out.println("scrittore:dato scritto " + i);
                pieno.V();//semaforo verde,risorsa assegnata
                Thread.sleep(1000); //blocca il proddutore per permettere al consumatore di leggere il dato
            } catch (InterruptedException ex) {
                Logger.getLogger(ProduciDato.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("scrittore:termina scrittura dati");
    }
}
