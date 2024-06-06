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
        boolean flag=false;
        ArrayList<Arquero> fases = new ArrayList<>();

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
                case 1: // octavos
                    
                    if (cont >= 8) {
                        System.out.println("Cupos llenos");
                        break;
                    }
                    flag=true;
                    while (cont != 8) {
                        
                        cont++;
                        System.out.print("introduzca el nombre del arquero N°" + cont+": ");
                        String nombre = texto.nextLine();

                        System.out.print("introduzca la puntuacion de "+ nombre +": ");
                        int puntos = enteros.nextInt();

                        Arquero arquero = new Arquero(nombre, puntos);

                        System.out.println("insertando en el torneo");
                        torneo.insertar(arquero);

                        System.out.println("arquero agregado: " + arquero);
                        System.out.println("----------------------------");

                    } 
                    break;

                case 2:
                    System.out.println("---mostrando orden de insercion--- ");

                    for (Arquero arquero1 : torneo.postorden(torneo.getRaiz())) {
                        System.out.println("" + arquero1);
                    }

                    break;
                case 3:
                    System.out.println("---mostrando puntuaciones de mayor a menor---");

                    for (Arquero arquero1 : torneo.inorden(torneo.getRaiz())) {
                        System.out.println("" + arquero1);
                    }

                    break;
                case 4:
                    if (flag) {
                        System.out.println(torneo.inorden(torneo.getRaiz()));
                        System.out.println("----------------------------------");
                        
                        fases = torneo.inorden(torneo.getRaiz());
                        System.out.println(fases.size());
                        for (int i = fases.size()/2 ; i > 0 ; i--) {
                            torneo.eliminarRecursivo(torneo.getRaiz(), fases.get(i));
                        }
                        
                        System.out.println(fases = torneo.inorden(torneo.getRaiz()));
                    }else{
                        System.out.println("Se deben llenar los cupos antes de la proxima instancia");
                    }
                    break;

                case 5:
                    Arquero a1 = new Arquero("jose", 6);
                    Arquero a2 = new Arquero("lose", 2);
                    Arquero a3 = new Arquero("mose", 6);
                    Arquero a4 = new Arquero("nose", -1);
                    Arquero a5 = new Arquero("rose", 35);
                    Arquero a6 = new Arquero("kose", 3);
                    Arquero a7 = new Arquero("dose", 1);
                    torneo.insertar(a1);
                    torneo.insertar(a2);
                    torneo.insertar(a3);
                    torneo.insertar(a4);
                    torneo.insertar(a5);
                    torneo.insertar(a6);
                    torneo.insertar(a7);

                    torneo.raiz = torneo.eliminarRecursivo(torneo.getRaiz(), a6);

                    for (Arquero arquero1 : torneo.inorden(torneo.getRaiz())) {
                        System.out.println("" + arquero1);
                    }

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

}
