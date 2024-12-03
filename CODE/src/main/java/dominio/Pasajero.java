package dominio;

import interfaz.Categoria;

import java.util.Objects;

public class Pasajero implements Comparable<Pasajero> {
    private String nombre;
    private String telefono;
    private String cedula;
    private Categoria categoria;

    public Pasajero(String nombre, String telefono, String cedula, Categoria categoria) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.cedula = cedula;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Categoria getCategoria() {
        return categoria;
    }
    public boolean cedulaValida() {

        String reg8 = "^[1-9]\\d?\\.\\d{3}\\.\\d{3}-\\d{1}$";
        String reg7 = "[1-9]\\d{2}\\.\\d{3}-\\d{1}";
        return cedula.matches(reg8) || cedula.matches(reg7);
    }

    @Override
    public int compareTo(Pasajero o) {
        return o.cedula.compareTo(this.cedula);
    }

    @Override
    public String toString() {
        return cedula + ";" + nombre + ";" + telefono + ";" + categoria.getTexto();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pasajero pasajero = (Pasajero) o;
        return Objects.equals(cedula, pasajero.cedula);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cedula);
    }
}
