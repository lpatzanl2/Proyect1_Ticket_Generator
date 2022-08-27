package Ticket_Request;
import Enumerations.Uso_Tallas;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import java.util.ArrayList;
import java.util.Objects;

/**
 * Clase enumerations
 */
enum Eventos {TICKET_CREADO, ASIGNADO_MESA_DE_AYUDA, ASIGNADO_MESA_DE_SOPORTE,ASIGNADO_MESA_DE_DESARROLLADOR, ESCALAR, SOLUCION}

public class Bitacora{

    /**
     * Array que almacenara los eventos en bitacora
     * tipo OBJECT poque lleva mas de un tipo de objeto
     */

    ArrayList<Object> array2 = new ArrayList<Object>();

    /**
     * Clase tipo fecha hora
     */
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    /**
     * Metodo para creacion de ticket con objeto enum
     */
    public void bitacoraCreacion2(){
        array2.add(Eventos.TICKET_CREADO + " " + dtf.format(LocalDateTime.now()));
    }
    /**
     * Metodo para asignacion de ticket con objeto enum
     */
    public void bitacoraAsignacionSoporte(){array2.add(Eventos.ASIGNADO_MESA_DE_SOPORTE + " " + dtf.format(LocalDateTime.now()) );}

    /**
     * Metodo para imprimir el Array
     */
    public void dameBITACORA(){
        for(Object e: array2){
            System.out.println(e);
        };
    }




}
