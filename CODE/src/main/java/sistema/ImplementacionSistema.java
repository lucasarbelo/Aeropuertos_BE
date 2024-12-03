package sistema;

import TADs.ABB;
import TADs.Grafo;
import TADs.Tupla;
import TADs.TuplaB;
import dominio.Aerolinea;
import dominio.Conexion;
import dominio.Pasajero;
import dominio.Vuelo;
import interfaz.*;

public class ImplementacionSistema implements Sistema {

    private ABB<Aerolinea> aerolineas;
    private Grafo aeropuertos;

    private ABB<Pasajero> pasajeros;
    private ABB<Pasajero> platinos;
    private ABB<Pasajero> frecuentes;
    private ABB<Pasajero> standards;

    private int MaxAeropuertos;
    private int MaxAerolineas;
    private int cantidadAerolineas = 0;

    @Override
        public Retorno inicializarSistema(int maxAeropuertos, int maxAerolineas) {
        if (maxAeropuertos <= 5) {
            return new Retorno(Retorno.Resultado.ERROR_1, null, null);
        } else if (maxAerolineas <= 3) {
            return new Retorno(Retorno.Resultado.ERROR_2, null, null);
        } else {
            MaxAeropuertos = maxAeropuertos;
            MaxAerolineas = maxAerolineas;
            aeropuertos = new Grafo(maxAeropuertos);

            aerolineas = new ABB<>();
            pasajeros = new ABB<>();

            platinos = new ABB<>();
            frecuentes = new ABB<>();
            standards = new ABB<>();
            //
            return new Retorno(Retorno.Resultado.OK, null, null);
        }
    }

    @Override
    public Retorno registrarPasajero(String cedula, String nombre, String telefono, Categoria categoria) {
        Pasajero nuevoPasajero = new Pasajero(nombre, telefono, cedula, categoria);
        if (cedula == null || cedula.isEmpty() || nombre == null || nombre.isEmpty()  || telefono == null || telefono.isEmpty() || categoria == null) {
            return new Retorno(Retorno.Resultado.ERROR_1, null, null);
        } else if (!nuevoPasajero.cedulaValida()) {
            return new Retorno(Retorno.Resultado.ERROR_2, null, null);
        } else if (pasajeros.pertenece(nuevoPasajero)){
            return new Retorno(Retorno.Resultado.ERROR_3, null, null);
        } else{
            pasajeros.insertar(nuevoPasajero);
            if (categoria.getTexto().equals("Platino")){
                platinos.insertar(nuevoPasajero);
            } else if (categoria.getTexto().equals("Frecuente")) {
                frecuentes.insertar(nuevoPasajero);
            } else if (categoria.getTexto().equals("Estándar")) {
                standards.insertar(nuevoPasajero);
            }
            return new Retorno(Retorno.Resultado.OK, null, null);
        }
    }

    @Override
    public Retorno buscarPasajero(String cedula) {
        Pasajero nuevoPasajero = new Pasajero(null, null, cedula, null);
        if (cedula == null || cedula.isEmpty()) {
            return new Retorno(Retorno.Resultado.ERROR_1, null, null);
        } else if (!nuevoPasajero.cedulaValida()) {
            return new Retorno(Retorno.Resultado.ERROR_2, null, null);
        } else if (!pasajeros.pertenece(nuevoPasajero)){
            return new Retorno(Retorno.Resultado.ERROR_3, null, null);
        } else{
            Tupla<Pasajero> recorrido = pasajeros.contarRecorridoAlBuscar(nuevoPasajero);
            return new Retorno(Retorno.Resultado.OK, recorrido.getContador(), recorrido.getDato().toString());
        }
    }

    @Override
    public Retorno listarPasajerosAscendente() {

        String listaAsc = pasajeros.listarAscendentes();
        if (listaAsc != null && listaAsc.length() > 0) {
            listaAsc = listaAsc.substring(0, listaAsc.length() - 1);
        }
        return new Retorno(Retorno.Resultado.OK, null, listaAsc);
    }

    @Override
    public Retorno listarPasajerosPorCategoria(Categoria categoria) {
        String listaAsc = null;
        if (categoria != null) {

            if (categoria.getTexto().equals("Platino")) {
                listaAsc = platinos.listarAscendentes();
            } else if (categoria.getTexto().equals("Frecuente")) {
                listaAsc = frecuentes.listarAscendentes();
            } else if (categoria.getTexto().equals("Estándar")) {
                listaAsc = standards.listarAscendentes();
            }
            if (listaAsc != null && listaAsc.length() > 0) {
                listaAsc = listaAsc.substring(0, listaAsc.length() - 1);
            }
            return new Retorno(Retorno.Resultado.OK, null, listaAsc);
        }

        return new Retorno(Retorno.Resultado.ERROR_1, null, null);
    }

    @Override
    public Retorno registrarAerolinea(String codigo, String nombre) {
        Aerolinea nuevaAerolinea = new Aerolinea(codigo,nombre);
        if (MaxAerolineas <= cantidadAerolineas) {
            return new Retorno(Retorno.Resultado.ERROR_1, null, null);
        } else if (nombre == null || nombre.isEmpty()  || codigo == null || codigo.isEmpty()) {
            return new Retorno(Retorno.Resultado.ERROR_2, null, null);
        } else if (aerolineas.pertenece(nuevaAerolinea)){
            return new Retorno(Retorno.Resultado.ERROR_3, null, null);
        } else{
            aerolineas.insertar(nuevaAerolinea);
            cantidadAerolineas++;
            return new Retorno(Retorno.Resultado.OK, null, null);
        }
    }

    @Override
    public Retorno listarAerolineasDescendente() {
        String listaAero = aerolineas.listarDescendentes();
        if (listaAero != null && listaAero.length() > 0) {
            listaAero = listaAero.substring(0, listaAero.length() - 1);
        }
        return new Retorno(Retorno.Resultado.OK, null, listaAero);
    }

    @Override
    public Retorno registrarAeropuerto(String codigo, String nombre) {

        if (MaxAeropuertos <= aeropuertos.getCantidad()) {
            return new Retorno(Retorno.Resultado.ERROR_1, null, null);
        } else if (nombre == null || nombre.isEmpty()  || codigo == null || codigo.isEmpty()) {
            return new Retorno(Retorno.Resultado.ERROR_2, null, null);
        } else if (aeropuertos.existeAeropuerto(codigo)){
            return new Retorno(Retorno.Resultado.ERROR_3, null, null);
        } else{
            aeropuertos.agregarAeropuerto(codigo,nombre); //hay que cambiar a OBJETO mepá
            return new Retorno(Retorno.Resultado.OK, null, null);
        }
    }

    @Override
    public Retorno registrarConexion(String codigoAeropuertoOrigen, String codigoAeropuertoDestino, double kilometros) {
        if (kilometros <= 0) {
            return new Retorno(Retorno.Resultado.ERROR_1, null, null);
        } else if (codigoAeropuertoOrigen == null || codigoAeropuertoOrigen.isEmpty()  || codigoAeropuertoDestino == null || codigoAeropuertoDestino.isEmpty()) {
            return new Retorno(Retorno.Resultado.ERROR_2, null, null);
        } else if (!aeropuertos.existeAeropuerto(codigoAeropuertoOrigen)){
            return new Retorno(Retorno.Resultado.ERROR_3, null, null);
        } else if (!aeropuertos.existeAeropuerto(codigoAeropuertoDestino)){
            return new Retorno(Retorno.Resultado.ERROR_4, null, null);
        }else if (aeropuertos.obtenerConexion(codigoAeropuertoOrigen,codigoAeropuertoDestino) != null){
            return new Retorno(Retorno.Resultado.ERROR_5, null, null);
        }else{
            aeropuertos.agregarConexion(codigoAeropuertoOrigen,codigoAeropuertoDestino,kilometros);
            return new Retorno(Retorno.Resultado.OK, null, null);
        }
    }

    @Override
    public Retorno registrarVuelo(String codigoAeropuertoOrigen, String codigoAeropuertoDestino, String codigoDeVuelo, double combustible, double minutos, double costoEnDolares, String codigoAerolinea) {
        Aerolinea aero = new Aerolinea(codigoAerolinea,"");
        if (combustible <= 0 || minutos <= 0 || costoEnDolares <= 0 ) {
            return new Retorno(Retorno.Resultado.ERROR_1, null, null);
        } else if (codigoAeropuertoOrigen == null || codigoAeropuertoOrigen.isEmpty() || codigoAeropuertoDestino == null || codigoAeropuertoDestino.isEmpty() || codigoDeVuelo == null || codigoDeVuelo.isEmpty() || codigoAerolinea == null || codigoAerolinea.isEmpty()){
            return new Retorno(Retorno.Resultado.ERROR_2, null, null);
        } else if (!aeropuertos.existeAeropuerto(codigoAeropuertoOrigen)){
            return new Retorno(Retorno.Resultado.ERROR_3, null, null);
        } else if (!aeropuertos.existeAeropuerto(codigoAeropuertoDestino)){
            return new Retorno(Retorno.Resultado.ERROR_4, null, null);
        }else if (!aerolineas.pertenece(aero)){
            return new Retorno(Retorno.Resultado.ERROR_5, null, null);
        }else if (aeropuertos.obtenerConexion(codigoAeropuertoOrigen,codigoAeropuertoDestino) == null){
            return new Retorno(Retorno.Resultado.ERROR_6, null, null);
        }else{
            Conexion con = aeropuertos.obtenerConexion(codigoAeropuertoOrigen,codigoAeropuertoDestino);
            Vuelo v = new Vuelo(codigoDeVuelo,codigoAerolinea,combustible,minutos,costoEnDolares);
            if (con.getVuelos().existe(v)){
                return new Retorno(Retorno.Resultado.ERROR_7, null, null);
            }else {
                con.getVuelos().insertar(v);
                if (con.getVueloMasCorto() > minutos){
                    con.setVueloMasCorto((int) minutos);
                }
                return new Retorno(Retorno.Resultado.OK, null, null);
            }
        }
    }

    @Override
    public Retorno listadoAeropuertosCantDeEscalas(String codigoAeropuertoOrigen, int cantidad, String codigoAerolinea) {
        Aerolinea aero = new Aerolinea(codigoAerolinea,"");
        if (cantidad < 0){
            return new Retorno(Retorno.Resultado.ERROR_1, null, null);
        } else if (!aeropuertos.existeAeropuerto(codigoAeropuertoOrigen)){
            return new Retorno(Retorno.Resultado.ERROR_2, null, null);
        }else if (!aerolineas.pertenece(aero)){
            return new Retorno(Retorno.Resultado.ERROR_3, null, null);
        }else {
            String res = aeropuertos.bfs(codigoAeropuertoOrigen,cantidad);
            res = res.substring(0, res.length() - 1);
            return new Retorno(Retorno.Resultado.OK, null, res);
        }
    }
    @Override
    public Retorno viajeCostoMinimoKilometros(String codigoCiudadOrigen, String codigoCiudadDestino) {
        if (codigoCiudadOrigen == null || codigoCiudadOrigen.isEmpty() || codigoCiudadDestino == null || codigoCiudadDestino.isEmpty()){
            return new Retorno(Retorno.Resultado.ERROR_1, null, null);
        }else if (!aeropuertos.existeAeropuerto(codigoCiudadOrigen)){
            return new Retorno(Retorno.Resultado.ERROR_3, null, null);
        }else if (!aeropuertos.existeAeropuerto(codigoCiudadDestino)){
            return new Retorno(Retorno.Resultado.ERROR_4, null, null);
        }else {
            TuplaB res = aeropuertos.dijkstra(codigoCiudadOrigen,codigoCiudadDestino,true);
            if (res.getCamino() == "No hay camino"){
                return new Retorno(Retorno.Resultado.ERROR_2, null, null);
            }else {
                String camino = res.getCamino().substring(0, res.getCamino().length() - 1);
                return new Retorno(Retorno.Resultado.OK, res.getValor(), camino);
            }
        }
    }

    @Override
    public Retorno viajeCostoMinimoEnMinutos(String codigoAeropuertoOrigen, String codigoAeropuertoDestino) {
        if (codigoAeropuertoOrigen == null || codigoAeropuertoOrigen.isEmpty() || codigoAeropuertoDestino == null || codigoAeropuertoDestino.isEmpty()){
            return new Retorno(Retorno.Resultado.ERROR_1, null, null);
        }else if (!aeropuertos.existeAeropuerto(codigoAeropuertoOrigen)){
            return new Retorno(Retorno.Resultado.ERROR_3, null, null);
        }else if (!aeropuertos.existeAeropuerto(codigoAeropuertoDestino)){
            return new Retorno(Retorno.Resultado.ERROR_4, null, null);
        }else {

            TuplaB res = aeropuertos.dijkstra(codigoAeropuertoOrigen,codigoAeropuertoDestino,false);
            if (res.getCamino() == "No hay camino"){
                return new Retorno(Retorno.Resultado.ERROR_2, null, null);
            }else {
                String camino = res.getCamino().substring(0, res.getCamino().length() - 1);
                return new Retorno(Retorno.Resultado.OK, res.getValor(), camino);
            }
        }
    }
}
