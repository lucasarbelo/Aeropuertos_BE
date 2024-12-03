package TADs;

public class Tupla<Q> {
    private final Q dato;
    private final int contador;

    public Q getDato() {
        return dato;
    }

    public int getContador() {
        return contador;
    }

    public Tupla(Q dato, int contador) {
        this.dato = dato;
        this.contador = contador;
    }
}
