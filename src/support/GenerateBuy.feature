Feature: Generar la solicitud de compra

  Como usuario comprador,
  Quiero poder generar la solicitud de compra de los productos agregados en el carrito
  Para contactar con un comprador dispuesto a traer mis productos tecnológicos.

  Scenario: La solicitud se procesa correctamente
    Given que el usuario comprador se encuentra en la sección del carrito de compra
    When selecciona la opción de generar solicitud de compra
    Then se muestra el mensaje indicando que su solicitud se procesó y está a la espera de que un viajero la acepte.
