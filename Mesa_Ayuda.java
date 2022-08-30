package Ticket_Request;
import ProjectTicket.Ticket;

import java.util.LinkedList;
import java.util.Queue;

public class Mesa_Ayuda extends Cola_Servicio {


    /**
     *
     * @param posicion
     */
    @Override
    public void extraccion(int posicion) {

    }

    /**
     * Cola
     */
    Queue<Object> queueMesaAyuda = new LinkedList<>();

    public void rellenarMesaAyuda(Tickets tickets){
        queueMesaAyuda.add(tickets);
    }
    public String showMequeueMesaAyuda() {
        return " " + queueMesaAyuda;
    }
}


