package Ticket_Request;

import java.util.ArrayList;

/**
 * Clase abstracta
 *
 */
abstract class Cola_Servicio {


    /**
     * Array qye almacena los objetos tipo ticket
     */
        ArrayList<Tickets> ticketitos = new ArrayList<Tickets>();

    /**
     * Metodo para mostrar el arraylist
     */
    public void dameeeee(){
        for(Tickets e: ticketitos){
            System.out.print(e.toString());
        };
    }

    /**
     *
     * @param posicion
     */
    public abstract void extraccion (int posicion);


}
