Feature: Ver liquidaciones de un empleado

 @Login
  Scenario Outline: Loguearse a sitio
    Given el usuario inicia la sesion con su correo '<Username>' y contrasena '<Password>'
    When el usuario ingresa al aplicativo de forma correcta '<Name>'
    Then el usuario cierra la sesion

    Examples:
    	| Username      | Password                 | Name      |
    	| standard_user | qcu24s4901FyWDTwXGr6XA== | Swag Labs |