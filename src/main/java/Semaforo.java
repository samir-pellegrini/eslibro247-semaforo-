
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
public class Semaforo {
    int val; //valore
       public Semaforo(int val) //costruttore
       {
           this.val=val;
       }
       
       synchronized public void P()
       {
           while(val == 0){  //se la risorsa non c'è,il thread aspetta, semaforo rosso 
               try {
                   wait();
               } catch (InterruptedException ex) {
                   Logger.getLogger(Semaforo.class.getName()).log(Level.SEVERE, null, ex);
               }
               val--;
           }
       }
       synchronized public void V()
       {
           val++; //assegna la risorsa,semaforo verde
           notify();//sveglia i thread in wait
       }
}
