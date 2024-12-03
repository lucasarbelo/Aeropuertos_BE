package dominio;

import TADs.Lista;

import java.util.List;

public class Conexion {
    private final String codigoAeropuertoOrigen;
    private final String codigoAeropuertoDestino;
    private double kilometros;
    private int vueloMasCorto;
    private Lista<Vuelo> vuelos;

    public Lista<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVueloMasCorto(int vueloMasCorto) {
        this.vueloMasCorto = vueloMasCorto;
    }
    public int getVueloMasCorto() {
        return vueloMasCorto;
    }

    public Conexion(String codigoAeropuertoOrigen, String codigoAeropuertoDestino, double kilometros) {
        this.codigoAeropuertoOrigen = codigoAeropuertoOrigen;
        this.codigoAeropuertoDestino = codigoAeropuertoDestino;
        this.kilometros = kilometros;
        this.vuelos = new Lista<Vuelo>();
        this.vueloMasCorto = Integer.MAX_VALUE -10;
        // es el caso borde, limitado por el lenguaje,
        // al poner solo MAX VALUE se rompen los tests, posiblemente por la comparacion en dijkstra
    }

    public double getKilometros() { return kilometros; }

    @Override
    public String toString() {
        return "{" + "}";
    }
}
