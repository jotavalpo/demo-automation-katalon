@Importadores
Feature: Importador saldo de vacaciones
Como usuario Admin, quiero usar los distintos importadores del sitio

  @ImportarSaldoVacaciones @smoke_test
  Scenario Outline: [HCM-'<TestCase_ID>'] - Importar_'<Tipo_Carga>'_vacaciones
    Given el usuario importa un saldo de vacaciones
    When selecciona importador "Administrativo" "Saldo Vacaciones"
    And el usuario selecciona los datos requeridos '<Tipo_Carga>' '<Tipo_Vacaciones>'
    And el usuario hace click en Seleccionar Archivo y carga Excel '<nombreArchivoEntrada>'
    Then los registros se importan correctamente '<URL_Empleado>'
    
    Examples: 
      | Tipo_Carga      | Tipo_Vacaciones  | nombreArchivoEntrada    | URL_Empleado  | TestCase_ID |  
      | Saldo inicial   | Días adicionales | Saldo_de_Vacaciones.xls | employees/500 |  C314       |
      | Saldo adicional | Días adicionales | Saldo_de_Vacaciones.xls | employees/500 |  C315       |

      