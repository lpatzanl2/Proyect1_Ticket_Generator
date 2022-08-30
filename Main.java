/**
 * @author Luis Patzan
 * Este sera nuestro main donde mandaremos los valores a los atributos del ticket
 */

package Ticket_Request;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner pudin = new  Scanner(System.in);


        /**
         * Atributos del main
         */

        String nit_usuario_creador_del_ticket = "";
        String issue_description, comoLoResolvio;
        String nit_Trabajador = "";
        int roll= 0, opcroll= 0, b1 = 0, b22 = 0, b3 = 0;
        int pudoSolucionarlo1, pudoSolucionarlo2, pudoSolucionarlo3;

        /**
         * Metodo abstract que tenemos que mencionar en todas las clases que hagan uso de la clase abstracta
         */
        Cola_Servicio colaSERVI = new Cola_Servicio() {
            @Override
            public void extraccion(int posicion) {
            }
        }; //Objeto pa tener acceso a esa clase


        /**
         * Objetos que nos daran acceso  alas clases
         */
        Mesa_Ayuda c = new Mesa_Ayuda();
        Bitacora b = new Bitacora(); //Objeto pa tener acceso a esa clase

        int opcINICIAL = 0;
        int opc = 0, cycle =0, cycle2 = 0;
        int auxiliar = 0, contador = 0;

        while(cycle2 == 0){

            System.out.println("Bienvenido!\nComo desea ingresar:\n1) Usuario \n2)Empleado \n3)Salir");
            opcINICIAL = pudin.nextInt();


            switch (opcINICIAL){
                case 1:
                    cycle = 0; //Para entrar de nuevo en el ciclo
                    while(cycle == 0) {
                        System.out.println("\n**************************\n1) Crear un ticket\n2) Mostrar Todos Los Tickets\n3)Mostrar Bitacora\n4) Regresar\n\n");
                        opc = pudin.nextInt();

                        switch (opc) {
                            case 1:
                                /**
                                 * Ingreso de datos
                                 */
                                System.out.println("presione enter para continuar: ");
                                pudin.nextLine();
                                System.out.print("Usted esta creando un ticket de reporte, ingrese su NIT: ");
                                nit_usuario_creador_del_ticket = pudin.nextLine();


                                while (nit_usuario_creador_del_ticket.length() > 6){ //Validamos el tamaño del ticket
                                    System.out.print("Nit puede contener unicamente 6 caracteres, Ingreselo nuevamente: ");
                                    nit_usuario_creador_del_ticket = pudin.nextLine();
                                }

                                System.out.print("Ingrese una breve descripcion del problema encontrado: ");
                                issue_description = pudin.nextLine();
                                /**
                                 * Creamos el objeto Ticket
                                 *
                                 */
                                Tickets a1 = new Tickets(nit_usuario_creador_del_ticket, issue_description);
                                colaSERVI.ticketitos.add(a1); //Asigno Ticket al array de ColaServicio
                                c.rellenarMesaAyuda(a1);
                                b.bitacoraCreacion2(); //Bitacora Creacion



                                break;
                            case 2:
                                /**
                                 * Lectura del array
                                 */
                                colaSERVI.dameeeee(); //Mostramos los valores en el Array


                                break;
                            case 3:

                                b.dameBITACORA(); //Mostramos bitacora

                                break;
                            case 4:
                                cycle = 1;
                                break;
                        }
                    } //end 2ndo while
                break; //Break Case 1
                case 2:
                    b1 = 0;
                    while (b1 == 0){
                        pudin.nextLine();
                        System.out.println("\n\nEscoja su roll:\n1)Mesa De Apoyo\n2)Soporte Tecnico\n3)Desarrollador\n4)Regresar");
                        roll = pudin.nextInt();

                        System.out.println("\n***** Bienvenido ****** \nIngrese su NIT");
                        nit_Trabajador = pudin.next();
                        b.setNitRecibido(nit_Trabajador);

                        switch (roll){
                            case 1:
                                b22 = 0;
                                while (b22 == 0){
                                    System.out.println("\n\n1)Nnumero de tickets en cola\n2)Asignar un ticket\n3)Regresar");
                                    opcroll = pudin.nextInt();

                                    switch(opcroll){

                                        case 1:
                                            System.out.println("\n\nTenemos " + c.queueMesaAyuda.size() + " tickets en cola");
                                            System.out.println("*************");
                                            System.out.println(c.showMequeueMesaAyuda());
                                        break;
                                        case 2:
                                            b.bitacoraAsignacionSoporte(); //Bitacora Asignacion
                                            System.out.println("\n\nSe le ha asignado el siguiente ticket:\n" + c.queueMesaAyuda.element());
                                            System.out.println("\nPudo Solucionarlo?\n1)Si\n2)No");
                                            pudoSolucionarlo1=pudin.nextInt();


                                            if(pudoSolucionarlo1==1){
                                                c.queueMesaAyuda.remove();
                                                b.bitacoraSolucionado();
                                                colaSERVI.ticketitos.get(contador).setState("Resuelto");
                                                contador++;
                                                pudin.nextLine();
                                                System.out.println("Favor dejar constancia de como lo resolvio");
                                                comoLoResolvio = pudin.nextLine();
                                            }
                                            if (pudoSolucionarlo1==2){
                                                System.out.println("El ticket sera escalado a la siguiente cola, SOPOTE TECNICO");
                                                b.bitacoraEslacadoMesaSoporte();
                                                colaSERVI.ticketitos.get(contador).setState("Escalado Mesa Soporte");
                                                contador++;
                                                c.queueMesaAyuda.remove();
                                            }

                                        break;
                                        case 3:
                                            b22 = 2;
                                        break;
                                } //fin while b22
                                }
                            break;
                            case 4:
                                b1 = 1;
                            break;
                        }

                    }//Fin while b1


                    break;
                case 3:
                    cycle2 = 1;
                break;
            } //Fin switch general

        } //Fin while



    }

}

