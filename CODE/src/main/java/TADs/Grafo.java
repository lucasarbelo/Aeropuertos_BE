package TADs;

import dominio.Aeropuerto;
import dominio.Conexion;
import dominio.Vuelo;

public class Grafo {
    private Aeropuerto[] aeropuertos;
    private Conexion[][] conexiones;
    private final int maxAeropuertos;
    int cantidad = 0;

    public int getCantidad() {
        return cantidad;
    }
    public Grafo(int maxAeropuertos) {
        this.maxAeropuertos = maxAeropuertos;
        aeropuertos = new Aeropuerto[maxAeropuertos];
        conexiones = new Conexion[maxAeropuertos][maxAeropuertos];
    }

    public void agregarAeropuerto(String codigoAeropuerto, String nombreAeropuerto) {
        if (cantidad < maxAeropuertos) {
            int posLibre = obtenerPosLibre();
            aeropuertos[posLibre] = new Aeropuerto(codigoAeropuerto, nombreAeropuerto);
            cantidad++;
        }
    }

    public void agregarConexion(String codigoVOrigen, String codigoVDestino, double kilometros) {
        int posVInicial = obtenerPos(codigoVOrigen);
        int posVFinal = obtenerPos(codigoVDestino);

        conexiones[posVInicial][posVFinal] = new Conexion(codigoVOrigen,codigoVDestino,kilometros);
    }

    public Conexion obtenerConexion(String codigoVOrigen, String codigoVDestino) {
        int posVInicial = obtenerPos(codigoVOrigen);
        int posVFinal = obtenerPos(codigoVDestino);

        return conexiones[posVInicial][posVFinal];
    }

    public boolean existeAeropuerto(String codigoAeropuerto) {
        int posABuscar = obtenerPos(codigoAeropuerto);
        return posABuscar >= 0;
    }


    public String bfs(String codigoAeropuerto, int cantidad) {

        ABB<Aeropuerto> ABBaero = new ABB<>();
        int posV = obtenerPos(codigoAeropuerto);
        boolean[] visitados = new boolean[maxAeropuertos];
        Cola<Integer> cola = new Cola<>();
        cola.encolar(posV);
        visitados[posV] = true;
        int nivel = 0;
        while (!cola.esVacia() && nivel <= cantidad) {
            int largoCola = cola.getLargo();
            for (int j = 0; j < largoCola; j++) {
                int pos = cola.desencolar();
                ABBaero.insertar(aeropuertos[pos]);
                for (int i = 0; i < conexiones.length; i++) {
                    if (conexiones[pos][i] != null && !visitados[i]) {
                        cola.encolar(i);
                        visitados[i] = true;
                    }
                }
            }
            nivel++;
        }

        return ABBaero.listarAscendentes();
    }


    private int obtenerSiguenteAeropuertoNoVisitadoDeMenorCosto(int[] costos, boolean[] visitados) {
        int posMin = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < maxAeropuertos; i++) {
            if (!visitados[i] && costos[i] < min) {
                min = costos[i];
                posMin = i;
            }
        }
        return posMin;
    }


    private int obtenerPos(String codigoAeropuerto) {
        for (int i = 0; i < aeropuertos.length; i++) {
            if (aeropuertos[i] != null && aeropuertos[i].getCodigo().equals(codigoAeropuerto)) {
                return i;
            }
        }
        return -1;
    }

    private int obtenerPosLibre() {
        for (int i = 0; i < aeropuertos.length; i++) {
            if (aeropuertos[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public TuplaB dijkstra(String codigoVOrigen, String codigoVDestino, boolean esPorKms) {
        int posVOrigen = obtenerPos(codigoVOrigen);
        int posVDestino = obtenerPos(codigoVDestino);
        boolean[] visitados = new boolean[maxAeropuertos];
        int[] costos = new int[maxAeropuertos];
        int[] vengo = new int[maxAeropuertos];
        int distanciaNueva;
        for (int i = 0; i < maxAeropuertos; i++) {
            costos[i] = Integer.MAX_VALUE;
            vengo[i] = -1;
            visitados[i] = false;
        }

        costos[posVOrigen] = 0;

        for (int v = 0; v < cantidad; v++) {
            int pos = obtenerSiguenteAeropuertoNoVisitadoDeMenorCosto(costos, visitados);

            if (pos != -1) {
                visitados[pos] = true;

                for (int i = 0; i < conexiones.length; i++) {
                    if (conexiones[pos][i] != null && !visitados[i]) {

                        if (esPorKms) {
                            distanciaNueva = costos[pos] + (int) conexiones[pos][i].getKilometros();
                        }else {
                            distanciaNueva = costos[pos] + conexiones[pos][i].getVueloMasCorto();
                        }
                        if (distanciaNueva < costos[i]) {
                            costos[i] = distanciaNueva;
                            vengo[i] = pos;
                        }
                    }
                }
            }
        }
        String camino = "";
        int posActual = posVDestino;
        while (posActual != posVOrigen && posActual != -1) {
            camino = aeropuertos[posActual].toString() + "|" + camino;
            posActual = vengo[posActual];
        }

        if (posActual == posVOrigen) {
            camino = aeropuertos[posVOrigen].toString() + "|" + camino;
        } else {
            return new TuplaB("No hay camino",-1);
        }

        return new TuplaB(camino,costos[posVDestino]);
    }
}
