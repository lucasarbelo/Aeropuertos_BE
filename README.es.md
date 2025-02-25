﻿# Proyecto Aeropuerto
[![Dynamic JSON Badge](https://img.shields.io/badge/Lang-En-blue)](https://github.com/lucasarbelo/Aeropuertos_BE/blob/main/README.md)

##  Clases
Para este proyecto, se utilizaron clases de java para generar los objetos de aeropuertos, conexiones, pasajeros y vuelos.

![clases1](https://github.com/lucasarbelo/Aeropuertos_BE/blob/main/images/clases1.png)
![clases2](https://github.com/lucasarbelo/Aeropuertos_BE/blob/main/images/clases2.png)
![clases3](https://github.com/lucasarbelo/Aeropuertos_BE/blob/main/images/clases3.png)

## Organización
Para la parte de la organización de los mismos, se generan los distintos TADS, en este caso utilicé Arboles binarios de búsqueda para organizar tanto las aerolíneas, como los pasajeros, mientras que, para los aeropuertos utilicé un grafo, ya que era necesario conectarlos de una manera libre, ya que una conexión puede ser entre cualquier aeropuerto.

![tadsabb1](https://github.com/lucasarbelo/Aeropuertos_BE/blob/main/images/tadsabb1.jpeg)
![tadsabb2](https://github.com/lucasarbelo/Aeropuertos_BE/blob/main/images/tadsabb2.jpeg)
![tadsgrafo](https://github.com/lucasarbelo/Aeropuertos_BE/blob/main/images/tadsgrafo.jpeg)

## Funciones
Se pedía realizar funciones para cada caso, creación de los aeropuertos, creación de los pasajeros (distinguiéndolos de sus clases, ya sea estándar, frecuente, o platino), aerolíneas, conexiones, para luego poder realizar las búsquedas recursivas pertinentes.

## Vuelos
Para la parte de las conexiones y los vuelos, el vuelo quedaría disponible (se hace un chequeo previo) en caso de que haya una conexión entre los aeropuertos de salida y de destino, caso contrario el vuelo se cancela. Por lo tanto previo a generar el vuelo, se debe de crear la conexión.

## Ordenamiento

 - Por como está pensado, al crear cada objeto llamando a la función, ésta automáticamente ordena el mismo en donde corresponda, ya que se crea en su clase el compare to. 
   
 - Se utilizaron métodos de ordenamiento in-order, pos-order, búsqueda BFS y el algoritmo dikjstra, tanto para el ordenamiento de los nodos como para listar los mismos.
 

![bfsabb](https://github.com/lucasarbelo/Aeropuertos_BE/blob/main/images/bfsabb.jpeg)
 
![dikjstragrafo](https://github.com/lucasarbelo/Aeropuertos_BE/blob/main/images/dikjstragrafo.jpeg)
![dikjstragrafo2](https://github.com/lucasarbelo/Aeropuertos_BE/blob/main/images/dikjstragrafo2.jpeg)
   
## Finalidad
Todo este proyecto pertenece a el obligatorio de AED2 de ORT, del año 2024. (Analista T.I.)
