package dominio;

import java.util.Objects;

public class Vuelo implements Comparable<Vuelo> {

    private String codigoVuelo;
    private String codigoAerolinea;
    private double combustible;
    private double minutos;
    private double costoDolares;


    @Override
    public int hashCode() {
        return Objects.hash(codigoVuelo);
    }

    public Vuelo(String codigoVuelo, String codigoAerolinea, double combustible, double minutos, double costoDolares) {
        this.codigoVuelo = codigoVuelo;
        this.codigoAerolinea = codigoAerolinea;
        this.combustible = combustible;
        this.minutos = minutos;
        this.costoDolares = costoDolares;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public String getCodigoAerolinea() {
        return codigoAerolinea;
    }

    public void setCodigoAerolinea(String codigoAerolinea) {
        this.codigoAerolinea = codigoAerolinea;
    }

    public double getCombustible() {
        return combustible;
    }

    public void setCombustible(double combustible) {
        this.combustible = combustible;
    }

    public double getMinutos() {
        return minutos;
    }

    public void setMinutos(double minutos) {
        this.minutos = minutos;
    }

    public double getCostoDolares() {
        return costoDolares;
    }

    public void setCostoDolares(double costoDolares) {
        this.costoDolares = costoDolares;
    }

    @Override
    public int compareTo(Vuelo o) {
        return this.codigoVuelo.compareTo(o.codigoVuelo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vuelo vuelo = (Vuelo) o;
        return Objects.equals(codigoVuelo, vuelo.codigoVuelo);
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                ", codigoVuelo='" + codigoVuelo + '\'' +
                ", codigoAerolinea='" + codigoAerolinea + '\'' +
                ", combustible=" + combustible +
                ", minutos=" + minutos +
                ", costoDolares=" + costoDolares +
                '}';
    }
}
