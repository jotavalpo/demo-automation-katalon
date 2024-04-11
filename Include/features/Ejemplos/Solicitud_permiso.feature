@SolicitudPermiso
Feature: Solicitud de permiso


Como usuario Normal, quiero solicitar y recibir la prea-aprobación, aprobación/rechazo de un permiso en el módulo de Asistencia

  @SolicitarPermisoEmpleado @smoke_test @smoke_test_aprobar_solicitud @regresion
  Scenario Outline: [HCM-C694] - Solicitar_Permiso_Por_Día
    Given el usuario "Solicitante" inicia la sesion con su correo "pruebaqa8buk@gmail.com" y contrasena "9sPNSAFomE+DRoy4hYuOUg=="
    When el usuario va a la pestaña Asistencia de su ficha '<URL_Empleado>'
    And el usuario hace click en la opcion ausencias
    And el usuario hace click en Solicitar Permiso
    And el usuario ingresa los datos requeridos '<Tipo_Asistencia>' '<Fecha_Inicio>' '<Duracion>' '<Justificacion>'
    And el usuario hace click en Solicitar 
    And el permiso se solicita correctamente
    Then el usuario cierra la sesion
    
    Examples: 
      | URL_Empleado  | Tipo_Asistencia | Fecha_Inicio | Duracion | Justificacion            | 
      | employees/506 | Permiso         | 03-08-2023   | 4        | prueba qa de permiso uno |
      
  @PreAprobarPermisoSupervisor @smoke_test @regresion @smoke_test_aprobar_solicitud
  Scenario Outline: [HCM-C3454] - PreAprobar_Permiso_Ficha_Empleado
    Given el usuario "Supervisor" inicia la sesion con su correo "pruebaqa5buk@gmail.com" y contrasena "T2253IJBPKPXYj0IboezUQ=="
    When el usuario va a la pestaña Asistencia de la ficha '<URL_Empleado>'
    And el usuario hace click en la opcion ausencias
		And el usuario hace click en Pre Aprobar Permiso
		And el permiso se pre aprueba correctamente
    Then el usuario cierra la sesion
    
    Examples: 
      | URL_Empleado  | 
      | employees/506 | 
      
  @AprobarPermisoRRHH @smoke_test @regresion @smoke_test_aprobar_solicitud
  Scenario Outline: [HCM-C3455] - Aprobar_Permiso_Ficha_Empleado
    Given el usuario "RRHH" inicia la sesion con su correo "pruebaqa6buk@gmail.com" y contrasena "snfQkHMXBKpwAPz55bXnSw=="
    When el usuario va a la pestaña Asistencia de la ficha '<URL_Empleado>'
    And el usuario hace click en la opcion ausencias
    And el usuario hace click en Aprobar Permiso
    And el permiso se aprueba correctamente
    Then el usuario cierra la sesion
    
    Examples: 
      | URL_Empleado  | 
      | employees/506 | 
      
  @SolicitarPermisoEmpleado @smoke_test @regresion @smoke_test_rechazar_solicitud
  Scenario Outline: [HCM-C694] - Solicitar_Permiso_Por_Día
    Given el usuario "Solicitante" inicia la sesion con su correo "pruebaqa8buk@gmail.com" y contrasena "9sPNSAFomE+DRoy4hYuOUg=="
    When el usuario va a la pestaña Asistencia de su ficha '<URL_Empleado>'
    And el usuario hace click en la opcion ausencias
    And el usuario hace click en Solicitar Permiso
    And el usuario ingresa los datos requeridos '<Tipo_Asistencia>' '<Fecha_Inicio>' '<Duracion>' '<Justificacion>'
    And el usuario hace click en Solicitar 
    And el permiso se solicita correctamente
    Then el usuario cierra la sesion
    
    Examples: 
      | URL_Empleado  | Tipo_Asistencia | Fecha_Inicio | Duracion | Justificacion            | 
      | employees/506 | Permiso         | 16-08-2023   | 2        | prueba qa de permiso dos | 
      
  @PreAprobarPermisoSupervisor @smoke_test @regresion @smoke_test_rechazar_solicitud
  Scenario Outline: [HCM-C3454] - PreAprobar_Permiso_Ficha_Empleado
    Given el usuario "Supervisor" inicia la sesion con su correo "pruebaqa5buk@gmail.com" y contrasena "T2253IJBPKPXYj0IboezUQ=="
    When el usuario va a la pestaña Asistencia de la ficha '<URL_Empleado>'
    And el usuario hace click en la opcion ausencias
		And el usuario hace click en Pre Aprobar Permiso
		And el permiso se pre aprueba correctamente
    Then el usuario cierra la sesion
    
    Examples: 
      | URL_Empleado  | 
      | employees/506 | 
  
  @RechazarPermisoRRHH  @regresion @smoke_test @smoke_test_rechazar_solicitud 
  Scenario Outline: [HCM-C3456] - Rechazar_Permiso_Ficha_Empleado
    Given el usuario "RRHH" inicia la sesion con su correo "pruebaqa6buk@gmail.com" y contrasena "snfQkHMXBKpwAPz55bXnSw=="
    When el usuario va a la pestaña Asistencia de la ficha '<URL_Empleado>'
    And el usuario hace click en la opcion ausencias
    And el usuario hace click en Rechazar Permiso
    And el permiso se rechaza correctamente
    Then el usuario cierra la sesion
    
    Examples: 
      | URL_Empleado  | 
      | employees/506 | 