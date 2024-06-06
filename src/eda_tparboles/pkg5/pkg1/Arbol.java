package eda_tparboles.pkg5.pkg1;

public class Arbol {

    private Nodo raiz;

    public Arbol() {
    }

    // para poder llamar recursivamente sin que me llore el netbeans
    void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo raiz, int valor) {
        //caso 1 el arbol esta vacio y retornamos un nodo con el valor 
        //para poder asignarlo 

        if (raiz == null) {
            //me encantaria asignarlo aca pero crashea
            raiz = new Nodo(valor);
            return raiz;
        } //caso 2 no esta vacio y hay que bajar por una de las ramas
        else if (valor < raiz.valor) {
            //se llama el metodo hasta encontrar una hoja disponible
            raiz.izquierda = insertarRecursivo(raiz.izquierda, valor);
        } else if (valor > raiz.valor) {
            raiz.derecha = insertarRecursivo(raiz.derecha, valor);
        }

        // devolvemos el nodo
        return raiz;
    }

    public void preorden(Nodo raiz) {
        if (raiz != null) {
            System.out.println("valor a guardar" + raiz.getValor());
            preorden(raiz.getIzquierda());
            preorden(raiz.getDerecha());
        }

    }

    public void inorden(Nodo raiz) {
        if (raiz != null) {
            inorden(raiz.getIzquierda());
            System.out.println("valor a guardar" + raiz.getValor());
            inorden(raiz.getDerecha());
        }
    }

    public void posorden(Nodo raiz) {
        if (raiz != null) {
            posorden(raiz.getDerecha());
            posorden(raiz.getIzquierda());
            System.out.println("valor a guardar" + raiz.getValor());
        }

    }

    public boolean busqueda(Nodo raiz, int valor) {
        boolean encontrado = false;
        if (raiz.getValor() == valor) {
            encontrado = true;

        } else if (valor > raiz.getValor() && encontrado != true) {
            busqueda(raiz.getDerecha(), valor);
        } else if (valor < raiz.getValor() && encontrado == false) {
            busqueda(raiz.getIzquierda(), valor);
        }
        return encontrado;
    }

    public void busquedavoid(Nodo raiz, int valor) {
        boolean encontrado = false;
        if (raiz.getValor() == valor) {
            encontrado = true;

        } else if (valor > raiz.getValor() && encontrado != true) {
            busquedavoid(raiz.getDerecha(), valor);
        } else if (valor < raiz.getValor() && encontrado == false) {
            busquedavoid(raiz.getIzquierda(), valor);
        }

        System.out.println("encontrado?" + encontrado);
    }

    public Nodo buscar(Nodo raiz, int valor) {
        //si el valor esta en la raiz retornamos
        if (raiz == null || raiz.valor == valor) {
            //punto de corte
            return raiz;
        }

        // es mas grande buscamos por la derecha
        if (raiz.valor < valor) {
            //punto de corte
            return buscar(raiz.getDerecha(), valor);
        }
        //es mas chico vamos por la izquierda
        return buscar(raiz.getIzquierda(), valor);
    }

    //-------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    //---------------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------------------
    public class Nodo {

        private Integer valor;
        private Nodo derecha;
        private Nodo izquierda;

        public Nodo(Integer valor) {
            this.valor = valor;
            this.derecha = null;
            this.izquierda = null;
        }

        public Integer getValor() {
            return valor;
        }

        public void setValor(Integer valor) {
            this.valor = valor;
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
