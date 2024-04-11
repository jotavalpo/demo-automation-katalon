package com.saucelabs.stepdefinition
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.saucelabs.businesslogic.BLImportadores
import com.saucelabs.businesslogic.BLVacaciones

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import internal.GlobalVariable

class Importadores {

	@Given("el usuario importa un saldo de vacaciones")
	def el_usuario_importa_un_saldo_de_vacaciones_inicial() {
		// Navegar en url del sitio hasta llegar a los importadores
		WebUI.takeScreenshot();
		BLImportadores.irAImportadores();
	}

	@When("el usuario hace click Saldo Vacaciones Importador")
	def el_usuario_hace_click_Saldo_Vacaciones_Importador() {
		// Dentro de Importador, hacer click en pestana Asistencia y luego en el importador especifico
		WebUI.takeScreenshot();
		BLImportadores.seleccionarImportador("Administrativo", "Saldo Vacaciones");
	}

	@When("el usuario selecciona los datos requeridos {string} {string}")
	def el_usuario_selecciona_los_datos_requeridos(String Tipo_Carga, String Tipo_Vacaciones) {
		// Modificar los datos solicitados en la modal dependiendo del tipo de vacaciones seleccionadas
		WebUI.takeScreenshot();
		BLImportadores.seleccionarCamposImportadorSaldoVacaciones(Tipo_Carga, Tipo_Vacaciones);
	}

	@When("el usuario hace click en Seleccionar Archivo y carga Excel {string}")
	def el_usuario_hace_click_en_Seleccionar_Archivo_y_carga_Excel (String nombreArchivoEntrada) {
		// Seleccionar el archivo a importar
		try {

			BLImportadores.importarSaldoVacaciones(nombreArchivoEntrada);
		}
		catch (Exception e) {

			WebUI.takeScreenshot();
			System.out.println("excepcion recibida: " + e.message);
			WebUI.refresh();
			assert false;
		}
	}

	@When("selecciona importador {string} {string}")
	public void selecciona_importador(String tab, String importador) {
		// Write code here that turns the phrase above into concrete actions

		WebUI.waitForPageLoad(20);
		BLImportadores.seleccionarImportador(tab, importador)
	}

	@Then("los registros se importan correctamente {string}")
	def los_registros_se_importan_correctamente(String URL_Empleado) {
		// Verificar importacion exitosa
		String url = GlobalVariable.Url ;
		WebUI.navigateToUrl(GlobalVariable.Url + URL_Empleado);
		BLImportadores.verificarImportacionExitosa();
		BLVacaciones.borrarSaldoVacacionCreado();
	}
}