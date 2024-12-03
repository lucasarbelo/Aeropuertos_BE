package TADs;

public class TuplaB {
    private final String camino;
    private final int valor;

    public int getValor() { return valor; }
    public String getCamino() {
        return camino;
    }


    public TuplaB(String escalas, int valor) {
        this.camino = escalas;
        this.valor = valor;
    }
}