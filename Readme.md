Productor y Consumidor
---
Este programa en Java implementa el problema clásico del productor-consumidor, donde una clase Store actúa como recurso compartido entre dos
clases de hilos: Productor y Consumidor.

La clase Store representa un almacén de un restaurante,
que es un recurso compartido entre los hilos Producer y Consumer. El objetivo es que los productores  añadan verduras al almacén,
mientras que los consumidores las eliminen.

Estructura del Proyecto
---
Store: La clase que sirve como recurso compartido. Contiene un ArrayList que representa el almacén de verduras y
métodos sincronizados para añadir y eliminar verduras.

Productor: Hilo que añade verduras al almacén de la clase Store.

Consumidor:Hilo que elimina verduras del almacén de la clase Store.

Main: La clase principal que inicializa y ejecuta la simulación del productor-consumidor.