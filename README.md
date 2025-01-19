# Conversor de Monedas

Este proyecto permite realizar conversiones entre diferentes monedas utilizando la API de ExchangeRate-API. La aplicación utiliza la biblioteca Gson para manejar las respuestas en formato JSON.

---
## Características

1. Se puede realizar la conversión entre las siguientes monedas:
   * ARS: Peso argentino
   * BOB: Boliviano
   * BRL: Real brasileño
   * CLP: Peso chileno
   * COP: Peso colombiano
   * USD: Dólar estadounidense

2. Menú interactivo para seleccionar las opciones de conversión.

3. Manejo de errores en tiempo de ejecución (como conexiones fallidas o entradas no válidas).

4. Uso de HttpURLConnection para realizar solicitudes HTTP.

5. Formateo de resultados con dos decimales para mayor claridad.
   
---

### Requisitos
1. Biblioteca Gson (ya importada en el proyecto).
2. Una clave de API válida de ExchangeRate-API.
   
---

### Uso

1. Ejecuta la aplicación desde tu IDE o terminal:
   java CurrencyConverter

2. Sigue las instrucciones del menú interactivo:
   * Selecciona la moneda de origen.
   * Selecciona la moneda de destino.
   * Ingresa el monto a convertir.
El programa calculará y mostrará el monto convertido.

---

### Ejemplo de Ejecución

```
--- Conversor de Monedas ---
1. Convertir moneda
2. Salir
Elija una opción: 1

--- Seleccione la moneda de origen ---
1. ARS (Peso Argentino)
2. BOB (Boliviano)
3. BRL (Real Brasileño)
4. CLP (Peso Chileno)
5. COP (Peso Colombiano)
6. USD (Dólar Estadounidense)
Elija una opción: 1

--- Seleccione la moneda de destino ---
Elija una opción: 6

Ingrese el monto a convertir: 1000
Resultado: 1000.00 ARS = 3.85 USD
```

---

### Consideraciones

- Tener acceso a Internet al ejecutar la aplicación.

- La aplicación utiliza tasas de cambio en tiempo real proporcionadas por la API: [ExchangeRate-API](https://www.exchangerate-api.com/)

- En caso de errores (como respuestas inválidas de la API), el programa mostrará un mensaje correspondiente.

---

### Mejoras Futuras

* Agregar soporte para más monedas.
* Manejar diferentes APIs para mayor flexibilidad.

--- 

¡Gracias por usar el Conversor de Monedas! Si tienes alguna duda o sugerencia, no dudes en contactarme.
