package com.saucelabs.stepdefinition

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.saucelabs.businesslogic.BLAsistencia
import com.saucelabs.businesslogic.BLBoletasDePago
import com.saucelabs.businesslogic.BLNavegacion
import com.saucelabs.helper.HelperTestObject

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import internal.GlobalVariable
import io.cucumber.datatable.DataTable

class EmpleadosPestanaAsistencia {

	@Given("el usuario registra una ausencia a un empleado {string}")
	def el_usuario_registra_una_ausencia_a_un_empleado(String URL_Empleado) {

		String url = GlobalVariable.Url ;
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
		HelperTestObject.determinaNotificacionConProgressBarPresente();
		WebUI.navigateToUrl( GlobalVariable.Url + URL_Empleado);
	}

	@When("el usuario hace click en la pestaña asistencia y en opcion ausencias")
	def el_usuario_hace_click_en_la_pestaña_asistencia_y_en_opcion_ausencias() {

		WebUI.waitForPageLoad(20);
		HelperTestObject.determinaNotificacionConProgressBarPresente();
		BLAsistencia.clicEnAsistenciaOpcionAusencias();
	}

	@When("el usuario hace click en Registrar Ausencia y luego en opcion inasistencia")
	def el_usuario_hace_click_en_Registrar_Ausencia_y_luego_en_opcion_inasistencia() {
		try {

			WebUI.waitForPageLoad(20);
			HelperTestObject.determinaNotificacionConProgressBarPresente();
			WebUI.refresh();
			WebUI.waitForPageLoad(40);
			WebUI.takeScreenshot();
			BLAsistencia.clicEnRegistrarAusenciaOpcionInasistencia();
		}
		catch(Exception e) {
			WebUI.waitForPageLoad(20);
			WebUI.takeScreenshot();
			KeywordUtil.logInfo(e.getMessage());
			System.out.print("Arroja Exception: " + e.message);
			WebUI.refresh();
			assert false
		}
	}

	@When("el usuario selecciona tipo de asistencia e ingresa datos requeridos {string} {string} {string} {string} {string}")

	def el_usuario_selecciona_tipo_de_asistencia_e_ingresa_datos_requeridos(String Tipo_Asistencia, String Fecha_Inicio, String Duracion, String Justificacion, String Fecha_Aplicacion) {

		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
		try {
			BLAsistencia.completarModalAgregarAusencia(Tipo_Asistencia, Fecha_Inicio, Duracion, Justificacion, Fecha_Aplicacion)
		}
		catch (Exception e) {
			WebUI.waitForPageLoad(20);
			WebUI.takeScreenshot();
			System.out.print("Arroja Exception: " + e.message);
			KeywordUtil.logInfo(e.getMessage());
			WebUI.refresh();
			assert false
		}
	}

	@When("el usuario selecciona los checkboxs respectivos")

	def el_usuario_selecciona_los_checkboxs_respectivos(DataTable dataTable) {
		//Seleccionar los checkbox al editar
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (row in data) {

			//Seteamos el elemento correcto
			String campo = row.Campo;
			TestObject testObject;
			switch(campo){

				case "activar_suplencia":
					testObject = HelperTestObject.getTestObjectWithXpath("//input[contains(@name,'check')]");
					break
				case "media_jornada":
					testObject = HelperTestObject.getTestObjectWithXpath("//input[@id='licence_media_jornada']");
					break
			}

			//Llamamos Helper con el elemento y accion a realizar
			String accion = row.Accion;
			HelperTestObject.selectDeselectCheckBox(accion,testObject);

		}
	}

	@When("el usuario hace click en Agregar")
	def el_usuario_hace_click_en_Agregar() {

		try {

			BLAsistencia.clicEnAgregar();
			TestObject obj = HelperTestObject.retornaObjetoMensajeExito();
			assert WebUI.verifyElementVisible(obj);

		}catch (Exception e) {

			System.out.print("Arroja Exception: " + e.getMessage());
			KeywordUtil.logInfo("Arroja Exception: " + e.getMessage());
			WebUI.waitForPageLoad(20);
			WebUI.takeScreenshot();
			WebUI.refresh();
			assert false
		}


	}

	@When("la ausencia se crea correctamente sin borrar registro")

	def la_ausencia_se_crea_correctamente_sin_borrar_registro() {
		BLAsistencia.validarRegistroIngresado();
	}

	@Then("se limpia el registro")
	def se_limpia_el_registro() {
		BLAsistencia.eliminarAusenciaCreada();
		WebUI.takeScreenshot();
	}

	@Then("la ausencia se crea correctamente")

	def la_ausencia_se_crea_correctamente() {
		BLAsistencia.validarRegistroIngresado();
		BLAsistencia.eliminarAusenciaCreada();
	}

	@Given("el usuario registra una licencia a un empleado {string}")

	def el_usuario_registra_una_licencia_a_un_empleado(String URL_Empleado) {
		String url = GlobalVariable.Url ;
		WebUI.navigateToUrl( GlobalVariable.Url + URL_Empleado);
	}

	@When("el usuario hace click en Registrar Ausencia y luego en opcion licencia")

	def el_usuario_hace_click_en_Registrar_Ausencia_y_luego_en_opcion_licencia() {

		while (HelperTestObject.notificacionConProgressBarPresente()) {
			HelperTestObject.determinaNotificacionConProgressBarPresente();
		}

		BLAsistencia.clicEnRegistrarAusenciaOpcionLicencia();

	}

	@When("el usuario selecciona tipo de asistencia e ingresa datos requeridos {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")

	def el_usuario_selecciona_tipo_de_asistencia_e_ingresa_datos_requeridos (String Tipo_Asistencia, String Fecha_Inicio, String Duracion, String Tipo_Licencia,
			String Dias_Aporte, String Formato_Licencia, String Fecha_Aplicacion, String Numero_Licencia, String RUT_Profesional, String Nombre_Profesional, String Justificacion) {
		WebUI.takeScreenshot();
		BLAsistencia.completarModalAgregarLicencia(Tipo_Asistencia, Fecha_Inicio, Duracion, Tipo_Licencia, Dias_Aporte, Formato_Licencia, Fecha_Aplicacion,
				Numero_Licencia, RUT_Profesional, Nombre_Profesional, Justificacion)
		WebUI.takeScreenshot();
	}

	@When("el usuario selecciona e ingresa los atributos personalizados de licencia {string} {string} {string}")

	def el_usuario_selecciona_e_ingresa_los_atributos_personalizados_de_licencia(String obsRRHH, String fechaRecepcion,
			String tipoInternoLicencia) {
		WebUI.takeScreenshot();
		BLAsistencia.completarAtributosPersonalizados(obsRRHH, fechaRecepcion, tipoInternoLicencia)
		WebUI.takeScreenshot();
	}

	@Then("la licencia se crea correctamente")

	def la_licencia_se_crea_correctamente() {
		BLAsistencia.validarRegistroIngresado();
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
		BLAsistencia.eliminarLicenciaCreada();
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
	}

	@Given("el usuario registra un permiso a un empleado {string}")

	def el_usuario_registra_un_permiso_a_un_empleado(String URL_Empleado) {
		String url = GlobalVariable.Url ;
		WebUI.navigateToUrl( GlobalVariable.Url + URL_Empleado);
	}

	@When("el usuario hace click en Registrar Ausencia y luego en opcion permiso")

	def el_usuario_hace_click_en_Registrar_Ausencia_y_luego_en_opcion_permiso() {
		HelperTestObject.determinaNotificacionConProgressBarPresente();
		BLAsistencia.clicEnRegistrarAusenciaOpcionPermiso();
	}

	@When("el usuario selecciona tipo de asistencia e ingresa datos requeridos del permiso {string} {string} {string} {string} {string}")

	def el_usuario_selecciona_tipo_de_asistencia_e_ingresa_datos_requeridos_del_permiso (String Tipo_Asistencia, String Fecha_Inicio, String Duracion, String Justificacion, String Fecha_Aplicacion) {
		try {
			WebUI.waitForPageLoad(20);
			BLAsistencia.completarModalAgregarPermiso(Tipo_Asistencia, Fecha_Inicio, Duracion, Justificacion, Fecha_Aplicacion)
			WebUI.waitForPageLoad(20);
			WebUI.takeScreenshot();
		}catch (Exception e){
			System.out.print("Arroja Exception: " + e.message);
			WebUI.waitForPageLoad(20);
			WebUI.takeScreenshot();
			WebUI.refresh();
			assert false
		}

	}

	@When("el usuario selecciona tipo de asistencia e ingresa datos requeridos del permiso por hora {string} {string} {string} {string} {string} {string}")

	def el_usuario_selecciona_tipo_de_asistencia_e_ingresa_datos_requeridos_del_permiso_por_hora(String Tipo_Asistencia, String Fecha_Inicio,
			String Hora_Inicio, String Hora_Termino, String Justificacion, String Fecha_Aplicacion) {
		try {
			WebUI.waitForPageLoad(20);
			BLAsistencia.completarModalAgregarPermisoPorHora(Tipo_Asistencia, Fecha_Inicio, Hora_Inicio, Hora_Termino, Justificacion, Fecha_Aplicacion)
			WebUI.waitForPageLoad(20);
			WebUI.takeScreenshot();
		}catch (Exception e){
			System.out.print("Arroja Exception: " + e.message);
			WebUI.waitForPageLoad(20);
			WebUI.takeScreenshot();
			WebUI.refresh();
			assert false
		}

	}

	@Then("el permiso se crea correctamente")

	def el_permiso_se_crea_correctamente() {
		WebUI.takeScreenshot();
		BLAsistencia.validarRegistroIngresado();
		WebUI.takeScreenshot();
		BLAsistencia.eliminarPermisoCreado();
	}

	@When("el usuario va a la pestaña Asistencia de su ficha {string}")

	def el_usuario_va_a_la_pestaña_Asistencia_de_su_ficha(String URL_Empleado) {
		String url = GlobalVariable.Url ;
		WebUI.navigateToUrl( GlobalVariable.Url + URL_Empleado);
		WebUI.takeScreenshot();
		BLAsistencia.irPestanaAsistenciaDeFicha1();
		HelperTestObject.determinaNotificacionConProgressBarPresente();
	}

	@When("el usuario va a la pestaña Asistencia de la ficha {string}")

	def el_usuario_va_a_la_pestaña_Asistencia_de_la_ficha(String URL_Empleado) {
		String url = GlobalVariable.Url ;
		WebUI.navigateToUrl( GlobalVariable.Url + URL_Empleado);
		WebUI.waitForPageLoad(10);
		WebUI.takeScreenshot();
		BLAsistencia.irPestanaAsistenciaDeFicha2();
		HelperTestObject.determinaNotificacionConProgressBarPresente();
	}

	@When("el usuario hace click en la opcion ausencias")

	def el_usuario_hace_click_en_la_opcion_ausencias() {
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
		BLAsistencia.clickEnOpcionDiasDeFicha();
	}

	@When("el usuario hace click en Solicitar Permiso")

	def el_usuario_hace_click_en_Solicitar_Permiso() {
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
		HelperTestObject.determinaNotificacionConProgressBarPresente();
		BLAsistencia.clickEnBotonSolicitarPermiso();
	}

	@When("el usuario ingresa los datos requeridos {string} {string} {string} {string}")

	def el_usuario_ingresa_los_datos_requeridos(String Tipo_Asistencia, String Fecha_Inicio, String Duracion, String Justificacion) {
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();

		try {
			BLAsistencia.completarModalSolicitudPermiso(Tipo_Asistencia, Fecha_Inicio, Duracion, Justificacion)
		}

		catch (Exception e) {

			System.out.print("Arroja Exception: " + e.message);
			WebUI.waitForPageLoad(20);
			WebUI.takeScreenshot();
			WebUI.refresh();
			assert false

		}

	}

	@When("el usuario hace click en Solicitar")
	def el_usuario_hace_click_en_Solicitar() {
		WebUI.waitForPageLoad(20);
		BLAsistencia.clickEnBotonSolicitar();
	}

	@When("el permiso se solicita correctamente")

	def el_permiso_se_solicita_correctamente() {
		WebUI.waitForPageLoad(20);
		BLAsistencia.validarAccionRealizada();
	}

	@When("el usuario hace click en Rechazar Permiso")

	def el_usuario_hace_click_en_Rechazar_Permiso() {
		WebUI.waitForPageLoad(20);
		BLAsistencia.rechazarPermiso();
	}

	@When("el permiso se rechaza correctamente")

	def el_permiso_se_rechaza_correctamente() {
		WebUI.waitForPageLoad(20);
		BLAsistencia.validarAccionRealizada();
		BLAsistencia.eliminarPermisoCreado()
	}

	@When("el usuario hace click en Pre Aprobar Permiso")

	def el_usuario_hace_click_en_Pre_Aprobar_Permiso() {
		WebUI.waitForPageLoad(20);
		BLAsistencia.aprobarPermiso();
	}

	@When("el permiso se pre aprueba correctamente")

	def el_permiso_se_pre_aprueba_correctamente() {
		WebUI.waitForPageLoad(20);
		BLAsistencia.validarAccionRealizada();
	}

	@When("el usuario hace click en Aprobar Permiso")

	def el_usuario_hace_click_en_Aprobar_Permiso() {
		WebUI.waitForPageLoad(20);
		BLAsistencia.aprobarPermiso();
	}

	@When("el permiso se aprueba correctamente")

	def el_permiso_se_aprueba_correctamente() {
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
		BLAsistencia.validarAccionRealizada();
		BLAsistencia.eliminarPermisoCreado();
	}

	//adaptación colombia
	@When("el usuario selecciona tipo de asistencia e ingresa datos requeridos col {string} {string} {string} {string} {string} {string} {string}")

	def el_usuario_selecciona_tipo_de_asistencia_e_ingresa_datos_requeridos (String Tipo_Asistencia, String Fecha_Inicio, String Duracion, String Tipo_Licencia, String Formato_Licencia, String Fecha_Aplicacion, String Justificacion) {
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
		try {
			BLAsistencia.completarModalAgregarLicenciaCo(Tipo_Asistencia, Fecha_Inicio, Duracion, Tipo_Licencia, Formato_Licencia, Fecha_Aplicacion, Justificacion)
		}
		catch (Exception e) {

			System.out.print("Arroja Exception: " + e.message);
			WebUI.waitForPageLoad(20);
			WebUI.takeScreenshot();
			WebUI.refresh();
			assert false

		}
	}

	@Given("el usuario registra una incapacidad a un empleado {string}")

	def el_usuario_registra_una_incapacidad_a_un_empleado(String URL_Empleado) {
		String url = GlobalVariable.Url ;
		WebUI.navigateToUrl( GlobalVariable.Url + URL_Empleado);
	}

	@When("el usuario hace click en Nuevo Ausentismo y luego en opcion incapacidad")

	def el_usuario_hace_click_en_Nuevo_Ausentismo_y_luego_en_opcion_incapacidad() {
		WebUI.waitForPageLoad(20);
		WebUI.click(HelperTestObject.getTestObjectWithXpath("//button[contains(.,'Registrar Ausencia')]"))
		WebUI.click(HelperTestObject.getTestObjectWithXpath("//a[contains(.,'Incapacidad')]"))
	}

	@When("el usuario selecciona tipo de asistencia e ingresa datos requeridos del permiso {string} {string} {string} {string} {string} {string}")
	def el_usuario_selecciona_tipo_de_asistencia_e_ingresa_datos_requeridos_del_permiso_co (String Tipo_Asistencia, String Fecha_Inicio, String Duracion,String Tipo_Incapacidad, String Justificacion, String Fecha_Aplicacion) {
		WebUI.waitForPageLoad(20);
		BLAsistencia.completarModalAgregarIncapacidad(Tipo_Asistencia, Fecha_Inicio, Duracion, Tipo_Incapacidad, Justificacion, Fecha_Aplicacion)
	}

	@Then("la incapacidad se crea correctamente")

	def la_incapacidad_se_crea_correctamente() {
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot()
		assert WebUI.verifyElementPresent(HelperTestObject.getTestObjectWithXpath("//div[contains(@class,'alert alert-success alert-dismissible')]"), 120)
		BLAsistencia.eliminarIncapacidadCreada();
	}

	//Colombia Hora Extra

	@When("el usuario hace click en la opcion Horas Extras")

	def el_usuario_hace_click_en_la_opcion_horas_extras() {
		WebUI.waitForPageLoad(20);
		BLAsistencia.SeleccionarHoraExtra();
	}

	@When("el usuario hace click en Registrar Horas Extras {string} {string} {string} {string}")

	def el_usuario_hace_click_en_Registrar_Horas_Extras (String Tipo_Hora_Extra, String Nro_Hora, String Comentario, String Fecha) {
		WebUI.waitForPageLoad(20);
		BLAsistencia.CrearHoraExtra(Tipo_Hora_Extra, Nro_Hora, Comentario, Fecha)
	}

	@Then("la hora extra se creo correctamente")

	def la_hora_extra_se_creo_correctamente() {
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
		assert WebUI.verifyTextPresent("Prueba Qa Hora Extra", false);
		BLAsistencia.EliminarHoraExtra()

	}
	//Colombia Recargo

	@When("el usuario hace click en la opcion Recargo")

	def el_usuario_hace_click_en_la_opcion_Recargo() {
		WebUI.waitForPageLoad(20);
		BLAsistencia.SeleccionarRecargo();
	}

	@When("el usuario hace click en Registrar Recargo {string} {string} {string} {string}")

	def el_usuario_hace_click_en_Registrar_Recargo (String Tipo_Recargo, String Nro_Hora, String Comentario, String Fecha) {
		WebUI.waitForPageLoad(20);
		BLAsistencia.CrearRecargo(Tipo_Recargo, Nro_Hora, Comentario, Fecha)
	}

	@Then("el recargo se creo correctamente")

	def el_recargo_se_creo_correctamente() {

		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();

		try {
			//		WebUI.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("(//a[contains(.,'Asistencia')])[2]"),40);
			//		WebUI.click(HelperTestObject.getTestObjectWithXpath("(//a[contains(.,'Asistencia')])[2]"));
			BLAsistencia.irPestanaAsistenciaDeFicha2();
			BLAsistencia.SeleccionarRecargo();
			WebUI.waitForPageLoad(20);
			WebUI.takeScreenshot()
			assert WebUI.verifyTextPresent("Prueba Qa Recargo", false);
			BLAsistencia.EliminarRecargo()
			WebUI.waitForPageLoad(20);
			WebUI.takeScreenshot()

		}	catch (Exception e) {
			WebUI.waitForPageLoad(20);
			WebUI.takeScreenshot()
			System.out.println("Exception generada:" + e.message);
			WebUI.refresh();
			System.out.println("Fallanbdo forzado por excepcion!!!!!!!!!!!!!!!");
			assert false;
		}


	}

	@When("el usuario selecciona tipo de asistencia e ingresa datos requeridos {string} {string} {string} {string} {string} {string} {string}")

	def el_usuario_selecciona_tipo_de_asistencia_e_ingresa_datos_requeridosPE (String Tipo_Asistencia, String Fecha_Inicio, String Duracion, String Tipo_Licencia,
			String Formato_Licencia, String Fecha_Aplicacion, String Justificacion) {

		WebUI.waitForPageLoad(20);
		BLAsistencia.completarModalAgregarLicencia_PE(Tipo_Asistencia, Fecha_Inicio, Duracion, Tipo_Licencia, Formato_Licencia, Fecha_Aplicacion, Justificacion)
	}

	@When("revisar la boleta de pago del {string} {string} {string}")
	def revisar_la_boleta_de_pago(String Mes, String Resultado, String Duracion){
		BLBoletasDePago.clickBoletaPago();
		BLBoletasDePago.SeleccionarBoleta(Mes);
		BLBoletasDePago.identificarInasistencia(Duracion);
		BLBoletasDePago.resultadoEsperado(Resultado);
		BLNavegacion.cerrarBoleta();
		BLAsistencia.clicEnAsistenciaOpcionAusencias();

	}

}