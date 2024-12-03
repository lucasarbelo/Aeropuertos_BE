package TADs;

public class ABB<T extends Comparable<T>> {

    private NodoABB<T> raiz;

    public void insertar(T dato) {
        if (raiz == null) {
            raiz = new NodoABB<>(dato);
        } else {
            insertar(dato, raiz);
        }

    }

    private void insertar(T dato, NodoABB<T> nodo) {
        if (nodo.dato.compareTo(dato) < 0) {
            if (nodo.izq == null) {
                nodo.izq = new NodoABB<>(dato);
            } else {
                insertar(dato, nodo.izq);
            }
        } else {
            if (nodo.der == null) {
                nodo.der = new NodoABB<>(dato);
            } else {
                insertar(dato, nodo.der);
            }
        }
    }

    public String listarAscendentes() {
        if (raiz == null) {
            return "";
        }else {
            return listarAscendentes(raiz);
        }
    }

    private String listarAscendentes(NodoABB nodo) {
        if (nodo != null) {
            return listarAscendentes(nodo.izq) + nodo.dato + "|" + listarAscendentes(nodo.der);
        } else {
            return "";
        }
    }

    public String listarDescendentes() {
        if (raiz == null) {
            return "";
        }else {
            return listarDescendentes(raiz);
        }
    }

    private String listarDescendentes(NodoABB nodo) {
        if (nodo != null) {
            return listarDescendentes(nodo.der) + nodo.dato + "|" + listarDescendentes(nodo.izq);
        } else {
            return "";
        }
    }

    public boolean pertenece(T dato) {
        return pertenece(dato, raiz);
    }

    private boolean pertenece(T dato, NodoABB<T> nodo) {
        if (nodo == null) {
            return false;
        } else if (nodo.dato.equals(dato)) {
            return true;
        } else if (nodo.dato.compareTo(dato) < 0) {
            return pertenece(dato, nodo.izq);
        } else {
            return pertenece(dato, nodo.der);
        }
    }

    public T obtenerObjeto(T dato) {
        return obtenerObjeto(dato, raiz);
    }

    private T obtenerObjeto(T dato, NodoABB<T> nodo) {
        if (nodo == null) {
            return null;
        } else if (nodo.dato.equals(dato)) {
            return nodo.dato;
        } else if (nodo.dato.compareTo(dato) < 0) {
            return obtenerObjeto(dato, nodo.izq);
        } else {
            return obtenerObjeto(dato, nodo.der);
        }
    }

    public Tupla<T> contarRecorridoAlBuscar(T dato) {
        return contarRecorridoAlBuscar(dato, raiz, -1);
    }

    private Tupla<T> contarRecorridoAlBuscar(T dato, NodoABB<T> nodo, int contador) {
        if (nodo == null) {
            return new Tupla<>(null, contador);
        } else if (nodo.dato.equals(dato)) {
            return new Tupla<>(nodo.dato, contador +1);
        } else if (nodo.dato.compareTo(dato) < 0) {
            return contarRecorridoAlBuscar(dato, nodo.izq, contador + 1);
        } else {
            return contarRecorridoAlBuscar(dato, nodo.der, contador + 1);
        }
    }

    private class NodoABB<T extends Comparable<T>> {
        private T dato;
        private NodoABB<T> izq;
        private NodoABB<T> der;

        public NodoABB(T dato) {
            this.dato = dato;
        }
    }


}
