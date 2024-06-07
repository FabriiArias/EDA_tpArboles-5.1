package eda_tparboles.pkg5.pkg1;

import java.util.ArrayList;
import java.util.Scanner;

public class ArbolesBinarios {

    //hay un error con scanner que se salta token si se introduzen enteros en un scanner que tenia previamente strings
    static Scanner texto = new Scanner(System.in);
    static Scanner enteros = new Scanner(System.in);

    public static void main(String[] args) {
        Arboltorneo torneo = new Arboltorneo();

        int elegir, cont = 0;
        boolean flag = false;
        ArrayList<Arquero> fases = new ArrayList<>();

        Arquero a0 = new Arquero("raiz", 0);
        torneo.insertar(a0);

        do {
            System.out.println("");
            System.out.println("|-1 Agregar arquero - octavos");
            System.out.println("|-2 Mostrar puntuaciones(estructura del arbol)");
            System.out.println("|-3 Mostrar puntuaciones mas altas");
            System.out.println("|-4 Ronda final");
            System.out.println("5 eliminar");
            System.out.println("|-0 Salir");
            System.out.println("");

            elegir = enteros.nextInt();

            switch (elegir) {
                case 1:

                    Arquero a1 = new Arquero("a", 1);
                    Arquero a2 = new Arquero("b", 2);
                    Arquero a3 = new Arquero("c", 3);
                    Arquero a4 = new Arquero("d", 4);
                    Arquero a5 = new Arquero("e", 5);
                    Arquero a6 = new Arquero("f", 6);
                    Arquero a7 = new Arquero("g", 7);
                    Arquero a8 = new Arquero("h", 9);

                    torneo.insertar(a1);
                    torneo.insertar(a2);
                    torneo.insertar(a3);
                    torneo.insertar(a4);
                    torneo.insertar(a5);
                    torneo.insertar(a6);
                    torneo.insertar(a7);
                    torneo.insertar(a8);
                    flag = true;

// octavos

                    /* if (cont >= 8) {
                        System.out.println("Cupos llenos");
                        break;
                    }
                    flag = true;
                    while (cont != 8) {

                        cont++;
                        System.out.print("introduzca el nombre del arquero N°" + cont + ": ");
                        String nombre = texto.nextLine();

                        System.out.print("introduzca la puntuacion de " + nombre + ": ");
                        int puntos = enteros.nextInt();

                        Arquero arquero = new Arquero(nombre, puntos);

                        System.out.println("insertando en el torneo");
                        torneo.insertar(arquero);

                        System.out.println("arquero agregado: " + arquero);
                        System.out.println("----------------------------");

                    }*/
                    break;
                case 3:
                    
                    mostrarPuntuacion(fases,torneo);
                    
                    break;
                case 4:
                    if (flag) {
                        fases = torneo.inorden(torneo.getRaiz());

                        int tma = fases.size();

                        for (int i = tma; i > (tma / 2) + 1; i--) {
                            torneo.eliminarRecursivo(torneo.getRaiz(), fases.getLast());

                            fases.removeLast();

                        }

                        torneo.eliminarRecursivo(torneo.getRaiz(), fases.getLast());

                    } else {
                        System.out.println("Se deben llenar los cupos antes de la proxima instancia");
                    }
                    break;

                case 5:

                    break;
                case 0:

                    System.out.println("saliendo...");
                    break;
                default:
                    System.out.println("Por favor introduzca una eleccion valida ");
            }

        } while (elegir
                != 0);

    }

    public static  void mostrarPuntuacion(ArrayList<Arquero> fases, Arboltorneo torneo) {
        System.out.println("---mostrando puntuaciones de mayor a menor---");

        fases = torneo.inorden(torneo.getRaiz());
        fases.removeLast();
        for (Arquero arquero1 : fases) {
            System.out.println("" + arquero1);
        }

    }
}
