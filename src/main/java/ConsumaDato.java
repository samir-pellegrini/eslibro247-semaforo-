/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samir pellegrini
 */
public class ConsumaDato extends Thread {
    Semaforo pieno;   //risorsa mancante
    Semaforo vuoto;   //risorsa assegnata 
    int dato;
    int s;
    Boolean c=true;
    public ConsumaDato(Semaforo pieno,Semaforo vuoto)
    {
        this.pieno=pieno;
        this.vuoto=vuoto;
    }
    public void run()
    {
        while(c)
        {
            pieno.P(); // consumatore che aspetta il produttore,risorsa non assegnata  
            dato=ProdConsSem.buffer; //consuma dato
            System.out.println("lettore:dato letto " + dato);
            vuoto.V();// semaforo che ora non aspetta più,risorsa assegnata
            if(s>dato)
            {
                s++;
            }
            else{
                c=false;
            }
        }
        
    }
    
}
