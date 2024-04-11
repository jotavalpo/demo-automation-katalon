package com.saucelabs.stepdefinition
import org.openqa.selenium.WebDriver

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.saucelabs.businesslogic.BLExportadores
import com.saucelabs.helper.HelperModels
import com.saucelabs.helper.HelperSeleniumJSandActions
import com.saucelabs.helper.HelperTestObject

import core.buk.helper.*
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When


class ExportadoresPersonalizados {

	WebDriver driver;


	@Given("el usuario ingresa a exportadores")
	def el_usuario_ingresa_a_exportadores() {
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
		// Navegar en url del exportador personalizado
		BLExportadores.irAExportadores();

	}


	@When("el usuario hace click en plantilla vacaciones")
	def el_usuario_hace_click_en_plantilla_vacaciones() {
		// Click en plantilla "Vacaciones"
		BLExportadores.clicEnPlantillaVacaciones();
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();

	}


	@When("el usuario hace click opcion Registro de Vacaciones")
	def el_usuario_hace_click_opcion_Registro_de_Vacaciones() {
		// Click en opción "Registro de Vacaciones" de plantilla "Vacaciones"
		BLExportadores.clicEnOpcionRegistroDeVacaciones();
		WebUI.waitForPageLoad(20);

	}


	@When("el usuario agrega parametros {string}")
	public void el_usuario_agrega_parametros(String Archivo_Con_Parametros) {
		// "Se agregan los parametros especificados en el archivo"
		try {

			WebUI.waitForPageLoad(20);
			WebUI.takeScreenshot();
			HelperSeleniumJSandActions.dragAndDropHelp(HelperModels.csvDragAndDrop(Archivo_Con_Parametros));
			WebUI.waitForPageLoad(20);

		}
		catch (Exception e) {

			WebUI.waitForPageLoad(20);
			WebUI.takeScreenshot();
			System.out.println("excepcion recibida: " + e.message);
			KeywordUtil.logInfo(e.getMessage());
			WebUI.refresh();
			assert false;

		}


	}


	@When("el usuario Guarda y luego Descarga el reporte")
	def el_usuario_Guarda_y_luego_Descarga_el_reporte() {
		// Hacer click en botón "Guardar y luego "Descargar" para abrir modal"

		BLExportadores.clicEnBotonGuardar();
		BLExportadores.clicEnBotonDescargar();
		WebUI.waitForPageLoad(20);

	}


	@When("el usuario selecciona rango de fechas {string} {string}")
	def el_usuario_selecciona_rango_de_fechas(String Fecha_Desde, String Fecha_Hasta) {
		// Dentro de modal desplegado seleccionar fechas desde y hasta
		BLExportadores.seleccionarRangoFechasParaDescargaReporte(Fecha_Desde, Fecha_Hasta);
		WebUI.waitForPageLoad(20);

	}


	@When("el usuario selecciona rango de fechas modals {string} {string}")
	def el_usuario_selecciona_rango_de_fechas_modals(String Fecha_Desde, String Fecha_Hasta) {
		// Dentro de modal desplegado seleccionar fechas desde y hasta con otro identificador
		BLExportadores.seleccionarRangoFechasParaDescargaReporteModals(Fecha_Desde, Fecha_Hasta);
		WebUI.waitForPageLoad(20);

	}


	@When("el usuario selecciona rango de fechas mes {string}")
	def el_usuario_selecciona_rango_de_fechas_mes(String Mes) {
		// Dentro de modal desplegado seleccionar fechas Mes
		BLExportadores.seleccionarRangoFechasParaDescargaReportesMes(Mes);
		WebUI.waitForPageLoad(20);

	}


	@When("el usuario selecciona rango de fechas solicitudes {string} {string}")
	def el_usuario_selecciona_rango_de_fechas_solicitudes(String Fecha_Desde, String Fecha_Hasta) {
		// Dentro de modal desplegado seleccionar fechas desde y hasta en reporte solicitudes
		BLExportadores.seleccionarRangoFechasParaDescargaReporteSolicitudes(Fecha_Desde, Fecha_Hasta);
		WebUI.waitForPageLoad(20);

	}


	@When("el usuario hace click en boton Descargar")
	def el_usuario_hace_click_en_boton_Descargar() {
		// Hacer click en botón "Descargar" de la modal
		BLExportadores.clicNuevamenteEnBotonDescargar();
		WebUI.waitForPageLoad(20);

	}


	@When("el usuario hace click en boton Descargar desde tabla de reportes")
	def el_usuario_hace_click_en_boton_Descargar_desde_tabla_de_reportes() {
		// Hacer click en botón "Descargar" que se muestra en la tabla de reportes
		BLExportadores.clicEnBotonDescargar();
		WebUI.waitForPageLoad(20);

	}


	@Then("el registro se exporta correctamente")
	def el_registro_se_exporta_correctamente() {
		// Validar texto de la modal de exportación exitosa

		WebUI.waitForPageLoad(20);

		try {
			BLExportadores.registroExportado();
			while (HelperTestObject.notificacionConProgressBarPresente()) {

				HelperTestObject.determinaNotificacionConProgressBarPresente();
				WebUI.waitForPageLoad(20);

			}

			BLExportadores.borrarReporte();
			WebUI.waitForPageLoad(20);
			WebUI.takeScreenshot();

		}catch (Exception e) {

			System.out.print("Arroja Exception: " + e.message);
			WebUI.waitForPageLoad(20);
			WebUI.takeScreenshot();
			WebUI.refresh();
			assert false

		}
	}


	@Then("el registro se exporta correctamente sin mensaje")
	def el_registro_se_exporta_correctamente_sin_mensaje() {
		// Validar texto de la modal de exportación exitosa

		try {
			BLExportadores.registroExportadoSinMensaje();
			while (HelperTestObject.notificacionConProgressBarPresente()) {

				HelperTestObject.determinaNotificacionConProgressBarPresente();
				WebUI.waitForPageLoad(20);

			}
			BLExportadores.borrarReporte();
			WebUI.waitForPageLoad(20);
			WebUI.takeScreenshot();

		}catch (Exception e) {

			System.out.print("Arroja Exception: " + e.message);
			WebUI.waitForPageLoad(20);
			WebUI.takeScreenshot();
			WebUI.refresh();
			assert false

		}
	}


	@When("el usuario hace click en plantilla nomina")
	def el_usuario_hace_click_en_plantilla_nomina() {
		// Click en plantilla "Nomina"

		BLExportadores.clicEnPlantillaNomina();
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();

	}


	@When("el usuario hace click en plantilla ausencia")
	def el_usuario_hace_click_en_plantilla_ausencia() {
		// Click en plantilla "Ausencia"
		BLExportadores.clicEnPlantillaAusencia();
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
	}


	@When("el usuario hace click en plantilla liquidaciones")
	def el_usuario_hace_click_en_plantilla_liquidaciones() {
		// Click en plantilla "Liquidaciones"
		BLExportadores.clicEnPlantillaLiquidaciones();
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
	}


	@When("el usuario hace click en plantilla asignacion items")
	def el_usuario_hace_click_en_plantilla_asignacion_items() {
		// Click en plantilla "Asignacion items"
		BLExportadores.clicEnPlantillaAsignacionItems();
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
	}


	@When("el usuario hace click en plantilla predefinidos")
	def el_usuario_hace_click_en_plantilla_predefinidos() {
		// Click en plantilla "Predefinidos"
		BLExportadores.clicEnPlantillaPredefinidos();
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
	}


	@When("el usuario hace click opcion Leyes sociales")
	def el_usuario_hace_click_opcion_Leyes_sociales() {
		// Click en opción "Leyes sociales" de plantilla "Predefinidos"
		BLExportadores.clicEnOpcionLeyesPredefinidos();
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
	}


	@When("el usuario hace click en plantilla estructuras")
	def el_usuario_hace_click_en_plantilla_estructuras() {
		// Click en plantilla "Estructuras"
		BLExportadores.clicEnPlantillaEstructuras();
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
	}


	@When("el usuario hace click opcion Areas")
	def el_usuario_hace_click_opcion_Areas() {
		// Click en opción "Areas" de plantilla "Estructuras"
		BLExportadores.clicEnOpcionAreas();
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
	}


	@When("el usuario hace click en plantilla firma documentos")
	def el_usuario_hace_click_en_plantilla_firma_documentos() {
		// Click en plantilla "Firma Documentos"
		BLExportadores.clicEnPlantillaFirmaDocumentos();
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();

	}

	@When("el usuario hace click en plantilla solicitudes")
	def el_usuario_hace_click_en_plantilla_solicitudes() {
		// Click en plantilla "Solictudes"
		BLExportadores.clicEnPlantillaSolicitudes();
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
	}


	@When("el usuario hace click opcion Procesos busqueda")
	def el_usuario_hace_click_opcion_Procesos_busqueda() {
		// Click en opción "Procesos de busqueda" de plantilla "Solicitudes"
		BLExportadores.clicEnOpcionProcesosBusqueda();
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
	}


	@When("el usuario hace click en plantilla reliquidaciones")
	def el_usuario_hace_click_en_plantilla_reliquidaciones() {
		// Click en plantilla "Reliquidaciones"
		BLExportadores.clicEnPlantillaReliquidaciones();
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
	}


	@When("el usuario hace click en plantilla grupo familiar")
	def el_usuario_hace_click_en_plantilla_grupo_familiar() {
		// Click en plantilla "Grupo familiar"
		BLExportadores.clicEnPlantillaGrupoFamiliar();
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
	}


	@When("el usuario hace click en plantilla APV individual")
	def el_usuario_hace_click_en_plantilla_APV_individual() {
		// Click en plantilla "APV individual"
		BLExportadores.clicEnPlantillaAPVIndividual();
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
	}
}