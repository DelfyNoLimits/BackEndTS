Feature: Registrar usuario comprador

  Como cliente,
  Quiero poder registrarme en la aplicación como usuario comprador
  Para poder acceder a los servicios de compra de productos exclusivos.

  Scenario: Registro exitoso
    Given que el cliente abre la aplicación por primera vez
    And selecciona la opción de registro
    When completa el formulario con sus datos personales
    And selecciona la opción registrar cuenta
    Then se muestra un mensaje informando que su cuenta ha sido registrada exitosamente.

  Scenario: Registro fallido
    Given que el cliente abre la aplicación por primera vez
    And selecciona la opción de registro
    When llena el formulario con sus datos inválidos o incompletos
    And selecciona la opción registrar cuenta
    Then se muestra un mensaje informando que su cuenta no se ha podido registrar por el error correspondiente.
