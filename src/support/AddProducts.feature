Feature: Agregar productos al carrito

  Como usuario comprador,
  Quiero poder agregar los productos seleccionados al carrito de compra
  Para poder realizar la solicitud posteriormente.

  Scenario: Agregar productos exitosamente
    Given que el usuario comprador está visualizando los detalles de un producto
    When selecciona la opción de agregar al carrito
    Then el producto se agrega a la lista del carrito de compra del usuario comprador.
