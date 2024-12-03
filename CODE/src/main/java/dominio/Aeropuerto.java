package dominio;

import java.util.Objects;

public class Aeropuerto implements Comparable<Aeropuerto> {
    private String codigo;
    private String nombre;

    public Aeropuerto(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aeropuerto aeropuerto = (Aeropuerto) o;
        return Objects.equals(codigo, aeropuerto.codigo);
    }
    @Override
    public String toString() {
        return codigo + ";" + nombre;
    }

    @Override
    public int compareTo(Aeropuerto o) {
        return o.codigo.compareTo(this.codigo);
    }
}

