package eda_tparboles.pkg5.pkg1;

import java.util.ArrayList;

public class Arboltorneo {

    public Nodo raiz;

    public Arboltorneo() {
    }

    public void insertar(Arquero arquero) {
        raiz = insertarRecursivo(raiz, arquero);

    }

    private Nodo insertarRecursivo(Nodo raiz, Arquero arquero) {
        if (raiz == null) {
            raiz = new Nodo(arquero);
            return raiz;

        } else if (raiz.getArquero().getPuntuacion() > arquero.getPuntuacion()) {
            raiz.izquierda = insertarRecursivo(raiz.izquierda, arquero);

        } else if (raiz.getArquero().getPuntuacion() < arquero.getPuntuacion()) {
            raiz.derecha = insertarRecursivo(raiz.derecha, arquero);

        }

        return raiz;
    }

    private void inordenrecursivo(Nodo raiz, ArrayList<Arquero> arqueros) {
        if (raiz != null) {
            //dependiendo de que rama llamamos primero nos devuelve asc o desc
            inordenrecursivo(raiz.getDerecha(), arqueros);
            arqueros.add(raiz.getArquero());
            inordenrecursivo(raiz.getIzquierda(), arqueros);
        }

    }

    public ArrayList<Arquero> inorden(Nodo raiz) {
        ArrayList<Arquero> arqueros = new ArrayList<>();
        inordenrecursivo(raiz, arqueros);
        return arqueros;
    }

    //para copiar el arbol
    public ArrayList<Arquero> postorden(Nodo raiz) {
        ArrayList<Arquero> arqueros = new ArrayList<>();
        postordenRecursivo(raiz, arqueros);
        return arqueros;
    }

    private void postordenRecursivo(Nodo raiz, ArrayList<Arquero> arqueros) {
        if (raiz != null) {
            postordenRecursivo(raiz.getIzquierda(), arqueros);
            postordenRecursivo(raiz.getDerecha(), arqueros);
            arqueros.add(raiz.getArquero());
        }

    }

    public Nodo eliminarRecursivo(Nodo raiz, Arquero arquero) {
        if (raiz == null) {
            return null;
        }

        if (arquero.getPuntuacion() < raiz.getArquero().getPuntuacion()) {
            raiz.setIzquierda(eliminarRecursivo(raiz.getIzquierda(), arquero));
        } else if (arquero.getPuntuacion() > raiz.getArquero().getPuntuacion()) {
            raiz.setDerecha(eliminarRecursivo(raiz.getDerecha(), arquero));
        } else {
            // Nodo con solo un hijo o sin hijos
            if (raiz.getIzquierda() == null) {
                return raiz.getDerecha();
            } else if (raiz.getDerecha() == null) {
                return raiz.getIzquierda();
            }

            // Nodo con dos hijos: Obtener el valor mínimo del subárbol derecho
            Nodo minNodo = obtenerMinimoNodo(raiz.getDerecha());
            raiz.setArquero(minNodo.getArquero());

            // Eliminar el nodo que tiene el valor mínimo en el subárbol derecho
            raiz.setDerecha(eliminarRecursivo(raiz.getDerecha(), minNodo.getArquero()));
        }

        return raiz;
    }

// Obtener el nodo con el valor mínimo
    private Nodo obtenerMinimoNodo(Nodo raiz) {
        while (raiz.getIzquierda() != null) {
            raiz = raiz.getIzquierda();
        }
        return raiz;
    }

    //---------------------------------------------------------------------------
    //---------------------------------------------------------------------------
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    public class Nodo {

        private Arquero arquero;
        private Nodo derecha;
        private Nodo izquierda;

        public Nodo(Arquero arquero) {
            this.arquero = arquero;
            this.derecha = null;
            this.izquierda = null;
        }

        public Arquero getArquero() {
            return arquero;
        }

        public void setArquero(Arquero arquero) {
            this.arquero = arquero;
        }

        public Nodo getDerecha() {
            return derecha;
        }

        public void setDerecha(Nodo derecha) {
            this.derecha = derecha;
        }

        public Nodo getIzquierda() {
            return izquierda;
        }

        public void setIzquierda(Nodo izquierda) {
            this.izquierda = izquierda;
        }

    }
}
