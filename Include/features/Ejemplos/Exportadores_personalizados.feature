@smoke_test
Feature: Exportadores personalizados
  
  Como usuario Admin, quiero usar las distintas plantillas de los exportadores personalizados

  @ExportarAsignacionItems @smoke_test 
  Scenario Outline: [PLA-C6857] - Exportar_Asignacion_Items
    Given el usuario ingresa a exportadores
    When el usuario hace click en plantilla asignacion items
    And el usuario agrega parametros '<Archivo_Con_Parametros>'
    And el usuario Guarda y luego Descarga el reporte
    And el usuario selecciona rango de fechas modals '<Fecha_Desde>' '<Fecha_Hasta>'
    And el usuario hace click en boton Descargar
    Then el registro se exporta correctamente

    Examples: 
      | Fecha_Desde | Fecha_Hasta | Archivo_Con_Parametros                          |
      | 15-12-2021  | 16-12-2021  | Include/Data/exportador_registro_asignacion_items.csv 		|
      
 
  @ExportarRegistroVacaciones @smoke_test @smoke_test_framework
  Scenario Outline: [PLA-C6857] - Exportar_Registro_de_Vacaciones
    Given el usuario ingresa a exportadores
    When el usuario hace click en plantilla vacaciones
    And el usuario hace click opcion Registro de Vacaciones
    And el usuario agrega parametros '<Archivo_Con_Parametros>'
    And el usuario Guarda y luego Descarga el reporte
    And el usuario selecciona rango de fechas '<Fecha_Desde>' '<Fecha_Hasta>'
    And el usuario hace click en boton Descargar
    Then el registro se exporta correctamente

    Examples: 
      | Fecha_Desde | Fecha_Hasta | Archivo_Con_Parametros                          |
      | 15-12-2021  | 16-12-2021  | Include/Data/exportador_registro_vacaciones.csv |
      

  @ExportarRegistroNomina @smoke_test
  Scenario Outline: [PLA-C6848] - Exportar_Registro_de_Nomina
    Given el usuario ingresa a exportadores
    When el usuario hace click en plantilla nomina
    And el usuario agrega parametros '<Archivo_Con_Parametros>'
    And el usuario Guarda y luego Descarga el reporte
    And el usuario selecciona rango de fechas modals '<Fecha_Desde>' '<Fecha_Hasta>'
    And el usuario hace click en boton Descargar
    Then el registro se exporta correctamente

    Examples: 
      | Fecha_Desde | Fecha_Hasta | Archivo_Con_Parametros                      |
      | 15-12-2022  | 16-12-2022  | Include/Data/exportador_registro_nomina.csv |
      

  @ExportarRegistroAusencia @smoke_test
  Scenario Outline: [PLA-C6856] - Exportar_Registro_de_Ausencia
    Given el usuario ingresa a exportadores
    When el usuario hace click en plantilla ausencia
    And el usuario agrega parametros '<Archivo_Con_Parametros>'
    And el usuario Guarda y luego Descarga el reporte
    And el usuario selecciona rango de fechas modals '<Fecha_Desde>' '<Fecha_Hasta>'
    And el usuario hace click en boton Descargar
    Then el registro se exporta correctamente

    Examples: 
      | Fecha_Desde | Fecha_Hasta | Archivo_Con_Parametros                        |
      | 15-12-2022  | 16-12-2022  | Include/Data/exportador_registro_ausencia.csv |
      

  @ExportarRegistroLiquidaciones @smoke_test
  Scenario Outline: [PLA-C6856] - Exportar_Registro_de_Liquidaciones
    Given el usuario ingresa a exportadores
    When el usuario hace click en plantilla liquidaciones
    And el usuario agrega parametros '<Archivo_Con_Parametros>'
    And el usuario Guarda y luego Descarga el reporte
    And el usuario selecciona rango de fechas modals '<Fecha_Desde>' '<Fecha_Hasta>'
    And el usuario hace click en boton Descargar
    Then el registro se exporta correctamente

    Examples: 
      | Fecha_Desde | Fecha_Hasta | Archivo_Con_Parametros                           |
      | 15-12-2022  | 16-12-2022  | Include/Data/exportador_registro_liquidaciones.csv |


  @ExportarRegistroPredefinidos @smoke_test
  Scenario Outline: [PLA-C6865] - Exportar_Registro_de_Predefinidos
    Given el usuario ingresa a exportadores
    When el usuario hace click en plantilla predefinidos
    And el usuario hace click opcion Leyes sociales
    And el usuario hace click en boton Descargar desde tabla de reportes
    And el usuario selecciona rango de fechas mes '<Mes>'
    And el usuario hace click en boton Descargar
    Then el registro se exporta correctamente

    Examples: 
      | Mes					|
      | 01-02-2022  |
 
 
  @ExportarRegistrosEstructuras @smoke_test
   Scenario: [PLA-C6867] - Exportar_Registro_de_Estructuras
    Given el usuario ingresa a exportadores
    When el usuario hace click en plantilla estructuras
    And el usuario hace click opcion Areas
    And el usuario hace click en boton Descargar desde tabla de reportes
    Then el registro se exporta correctamente
 

 @ExportarFirmaDocumentos @smoke_test
  Scenario Outline: [PLA-C6856] - Exportar_Firma_Documentos
    Given el usuario ingresa a exportadores
    When el usuario hace click en plantilla firma documentos
    And el usuario agrega parametros '<Archivo_Con_Parametros>'
    And el usuario Guarda y luego Descarga el reporte
    And el usuario selecciona rango de fechas '<Fecha_Desde>' '<Fecha_Hasta>'
    And el usuario hace click en boton Descargar
    Then el registro se exporta correctamente

    Examples: 
      | Fecha_Desde | Fecha_Hasta | Archivo_Con_Parametros                     |
      | 18-12-2022  | 19-12-2022  | Include/Data/exportador_registro_firma.csv |

     
 	@ExportarSolicitudes @smoke_test
  Scenario Outline: [PLA-C8134] - Exportar_Solicitudes
    Given el usuario ingresa a exportadores
    When el usuario hace click en plantilla solicitudes
    And el usuario hace click opcion Procesos busqueda
    And el usuario agrega parametros '<Archivo_Con_Parametros>'
    And el usuario Guarda y luego Descarga el reporte
    And el usuario selecciona rango de fechas solicitudes '<Fecha_Desde>' '<Fecha_Hasta>'
    And el usuario hace click en boton Descargar
    Then el registro se exporta correctamente sin mensaje 

    Examples: 
      | Fecha_Desde | Fecha_Hasta | Archivo_Con_Parametros                     			 |	
      | 18-12-2022  | 19-12-2022  | Include/Data/exportador_registro_solicitudes.csv | 
      
      
  @ExportarReliquidaciones @smoke_test
  Scenario Outline: [PLA-C8135] - Exportar_Reliquidaciones
    Given el usuario ingresa a exportadores
    When el usuario hace click en plantilla reliquidaciones
    And el usuario agrega parametros '<Archivo_Con_Parametros>'
    And el usuario Guarda y luego Descarga el reporte
    And el usuario selecciona rango de fechas modals '<Fecha_Desde>' '<Fecha_Hasta>'
    And el usuario hace click en boton Descargar
    Then el registro se exporta correctamente sin mensaje 

    Examples: 
      | Fecha_Desde | Fecha_Hasta | Archivo_Con_Parametros                     			 		 |	
      | 20-01-2023  | 21-01-2023  | Include/Data/exportador_registro_reliquidaciones.csv |  
      
      
  @ExportarGrupoFamiliar @smoke_test
  Scenario Outline: [PLA-C8136] - Exportar_Grupo_Familiar
    Given el usuario ingresa a exportadores
    When el usuario hace click en plantilla grupo familiar
    And el usuario agrega parametros '<Archivo_Con_Parametros>'
    And el usuario Guarda y luego Descarga el reporte
    And el usuario selecciona rango de fechas modals '<Fecha_Desde>' '<Fecha_Hasta>'
    And el usuario hace click en boton Descargar
    Then el registro se exporta correctamente sin mensaje 

    Examples: 
      | Fecha_Desde | Fecha_Hasta | Archivo_Con_Parametros                     			    |	
      | 25-01-2023  | 26-01-2023  | Include/Data/exportador_registro_grupo_familiar.csv |   
      
      
  @ExportarAPVIndividual @smoke_test
  Scenario Outline: [PLA-C8137] - Exportar_Grupo_APV_Individual
    Given el usuario ingresa a exportadores
    When el usuario hace click en plantilla APV individual
    And el usuario agrega parametros '<Archivo_Con_Parametros>'
    And el usuario Guarda y luego Descarga el reporte
    And el usuario selecciona rango de fechas modals '<Fecha_Desde>' '<Fecha_Hasta>'
    And el usuario hace click en boton Descargar
    Then el registro se exporta correctamente sin mensaje 

    Examples: 
      | Fecha_Desde | Fecha_Hasta | Archivo_Con_Parametros                     			    |	
      | 12-12-2022  | 12-12-2022  | Include/Data/exportador_registro_apv_individual.csv |   