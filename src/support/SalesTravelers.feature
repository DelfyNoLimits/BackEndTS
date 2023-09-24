Feature: Ver ofertas de viajeros

  Como usuario comprador,
  Quiero poder visualizar las diferentes ofertas que hacen los viajeros a mi solicitud
  Para seleccionar la mejor oferta.

  Scenario: El usuario visualiza la lista de ofertas de viajeros
    Given que el usuario comprador se encuentra en la sección de ver pedidos realizados
    When selecciona la opción de ver detalles para un pedido
    Then se muestra la página con los detalles del pedido y la lista de ofertas realizadas por viajeros.
