﻿# Airport Project
[![Dynamic JSON Badge](https://img.shields.io/badge/Lang-Es-blue)](https://github.com/lucasarbelo/Aeropuertos_BE/blob/main/README.es.md)
## Classes
For this project, java classes were used to generate the airport, connections, passengers and flights objects.

![clases1](https://github.com/lucasarbelo/Aeropuertos_BE/blob/main/images/clases1.png)
![clases2](https://github.com/lucasarbelo/Aeropuertos_BE/blob/main/images/clases2.png)
![clases3](https://github.com/lucasarbelo/Aeropuertos_BE/blob/main/images/clases3.png)

## Organization
For the organization side, the different TADS are generated, in this case I used binary search trees to organize the airlines and passengers, while for the airports I used a graph, since it was necessary to connect them in a free way, since a connection can be between any airport.

![tadsabb1](https://github.com/lucasarbelo/Aeropuertos_BE/blob/main/images/tadsabb1.jpeg)
![tadsabb2](https://github.com/lucasarbelo/Aeropuertos_BE/blob/main/images/tadsabb2.jpeg)
![tadsgrafo](https://github.com/lucasarbelo/Aeropuertos_BE/blob/main/images/tadsgrafo.jpeg)

## Functions
I was asked to create functions for each case, creation of the airports, creation of the passengers (distinguishing them from their classes, either standard, frequent, or platinum), airlines, connections, in order to then be able to perform the relevant recursive searches.


## Flights
For the section of the connections and flights, the flight would be available (a previous check is made) in case there is a connection between the departure and destination airports, otherwise the flight is cancelled. Therefore, before generating the flight, the connection must be created.

## Sorting

 - As it is thought, when creating each object by calling the function, it automatically orders the object where it corresponds, since the compare to is created in its class. 
   
  - In-order, post-order, bfs search and dikjstra algorithms were used to order the nodes and to list them.
 
![bfsabb](https://github.com/lucasarbelo/Aeropuertos_BE/blob/main/images/bfsabb.jpeg)
 ![dikjstragrafo](https://github.com/lucasarbelo/Aeropuertos_BE/blob/main/images/dikjstragrafo.jpeg)
![dikjstragrafo2](https://github.com/lucasarbelo/Aeropuertos_BE/blob/main/images/dikjstragrafo2.jpeg)
   
## Purpose
This whole project belongs to ORT AED2 project of the year 2024. (IT ANALYST)
