package Ticket_Request;

/**
 * Clase Tickets
 */

public class Tickets extends Cola_Servicio{
    /**
     * Atributos
     */
    private String nit_usuario_creador_del_ticket;
    private String issue_description;
    private String state = "Created";
    private int correlativo;


    /**
     * Constructor
     * @param nit_usuario_creador_del_ticket
     * @param issue_description
     */
    public Tickets(String nit_usuario_creador_del_ticket, String issue_description) {
        this.nit_usuario_creador_del_ticket = nit_usuario_creador_del_ticket;
        this.issue_description = issue_description;
        this.state = "Creado";
        this.correlativo = next_correlativo;
        next_correlativo++;

    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setNit_usuario_creador_del_ticket(String nit_usuario_creador_del_ticket) {
        this.nit_usuario_creador_del_ticket = nit_usuario_creador_del_ticket;
    }

    public void setIssue_description(String issue_description) {
        this.issue_description = issue_description;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public static void setNext_correlativo(int next_correlativo) {
        Tickets.next_correlativo = next_correlativo;
    }

    /**
     * Variable Static para que no pierda valor o se reinicie
     */
    private static int next_correlativo = 000001;

    /**
     * Imprimimos los datos de ticket
     * @return
     */



    @Override
    public String toString() {
        return "Numero De Ticket: 0000" + correlativo + "\nNit del usuario que esta creando el ticket: " + nit_usuario_creador_del_ticket
                + "\nDescripcion del problema: " + issue_description + "\nEstado del ticket: " + state + "\n\n";
    }

    @Override
    public void extraccion(int posicion) {

    }

}
