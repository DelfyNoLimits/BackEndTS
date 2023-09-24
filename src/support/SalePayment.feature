Feature: Realizar el pago de la oferta

  Como usuario comprador,
  Quiero realizar el pago de la oferta realizada por el viajero
  Para concretar mi compra y quedar a la espera de la entrega.

  Scenario: Se realiza el pago correctamente
    Given que el usuario comprador está visualizando la oferta detallada de un viajero
    When elige un método de pago registrado
    And selecciona la opción aceptar oferta y comprar
    Then se muestra un mensaje con la confirmación de la compra y una opción para contactar al viajero y ajustar detalles específicos.

  Scenario: El comprador no tiene fondos suficientes
    Given que el usuario comprador está visualizando la oferta detallada de un viajero
    And no tiene fondos suficientes en su método de pago registrado
    When elige un método de pago registrado
    And selecciona la opción aceptar oferta y comprar
    Then se muestra un mensaje indicando que no se pudo realizar el pago por fondos insuficientes y una opción para cambiar el método de pago.