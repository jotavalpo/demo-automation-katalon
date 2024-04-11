package com.saucelabs.businesslogic;
import com.kms.katalon.core.model.FailureHandling;
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords;
import com.saucelabs.helper.HelperTestObject;

public class BLAsistencia {
	
	public static void clicEnAsistenciaOpcionAusencias() {
		
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//li[contains(@class,'nav')]/a[contains(text(),'Asistencia')]"),15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//li[contains(@class,'nav')]/a[contains(text(),'Asistencia')]"));
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[contains(.,'Ausencias')]"),15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[contains(.,'Ausencias')]"));
	}
	
	public static void clicEnRegistrarAusenciaOpcionInasistencia() throws Exception {
		
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//button[contains(.,'Registrar Ausencia')]"),15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//button[contains(.,'Registrar Ausencia')]"));
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[text()='Inasistencia']"),15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[text()='Inasistencia']"));
	}
	
	public static void clicEnRegistrarAusenciaOpcionLicencia() {
		
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//button[contains(.,'Registrar Ausencia')]"),15);
		HelperTestObject.determinaNotificacionConProgressBarPresente();
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//button[contains(.,'Registrar Ausencia')]"));
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[@data-modal='true'][contains(.,'Licencia')]"),15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[@data-modal='true'][contains(.,'Licencia')]"));
	}
	
	public static void clicEnRegistrarAusenciaOpcionPermiso() {
		
		
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//button[contains(.,'Registrar Ausencia')]"),20);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//button[contains(.,'Registrar Ausencia')]"));	
		WebUiBuiltInKeywords.waitForPageLoad(20);	
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("(//a[@data-modal='true'][contains(.,'Permiso')])[1]"),20);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(//a[@data-modal='true'][contains(.,'Permiso')])[1]"));
	}
	
	public static void completarModalAgregarAusencia(String Tipo_Asistencia, String Fecha_Inicio, String Duracion, String Justificacion, String Fecha_Aplicacion) throws Exception{
		
		WebUiBuiltInKeywords.selectOptionByLabel(HelperTestObject.getTestObjectWithXpath("//select[@id='licence_licence_type_id']"), Tipo_Asistencia, false);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_start_date']"), Fecha_Inicio);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//label[@for='licence_dias_tomados']"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[contains(@id,'licence_dias_tomados')]"), Duracion);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//textarea[contains(@id,'justificacion')]"), Justificacion);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[contains(.,'Opciones Avanzadas')]"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_application_start_date']"), Fecha_Aplicacion);
	}
	
	public static void clicEnAgregar() throws Exception{
		
		  WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//input[@type='submit']"), 60);
		  WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[@type='submit']"));
		  while (procesandoAgregarRegistroAusencia()) {
		  
			  System.out.print("Mostrando Procesando..................");
		  
		  }
		//	WebUiBuiltInKeywords.waitForElementNotPresent(HelperTestObject.getTestObjectWithXpath("//input[@type='submit']"), 120);
		
		
	
		
		
	}
	
	public static void validarRegistroIngresado() {
		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("//section//div[contains(@class,'alert alert-success alert-dismissible')]"), 120);
		WebUiBuiltInKeywords.takeScreenshot();
	//	WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//button[@data-dismiss='alert']"));
	}
		
	public static void eliminarAusenciaCreada() {
		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("(//a[@href='#'][contains(.,'Asistencia')])[2]"), 15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(//a[@href='#'][contains(.,'Asistencia')])[2]"));
		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("//a[contains(.,'Ausencias')]"), 60);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[contains(.,'Ausencias')]"));
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[@data-original-title='Eliminar']"), 60);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[@data-original-title='Eliminar']"));
		WebUiBuiltInKeywords.waitForAlert(60);
		WebUiBuiltInKeywords.acceptAlert();
		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("//section//div[contains(@class,'alert alert-success alert-dismissible')]"), 120);


	}
	
	public static void completarModalAgregarLicencia(String Tipo_Asistencia, String Fecha_Inicio, String Duracion, String Tipo_Licencia, String Dias_Aporte,
			String Formato_Licencia, String Fecha_Aplicacion, String Numero_Licencia, String RUT_Profesional, String Nombre_Profesional, String Justificacion) throws Exception {
		
		WebUiBuiltInKeywords.selectOptionByLabel(HelperTestObject.getTestObjectWithXpath("//select[@id='licence_licence_type_id']"), Tipo_Asistencia, false);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_start_date']"), Fecha_Inicio);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//label[@for='licence_dias_tomados']"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[contains(@id,'licence_dias_tomados')]"), Duracion);
		WebUiBuiltInKeywords.selectOptionByLabel(HelperTestObject.getTestObjectWithXpath("//select[@id='licence_tipo_licencia']"), Tipo_Licencia, false);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_dias_aporte']"), Dias_Aporte);
		WebUiBuiltInKeywords.selectOptionByLabel(HelperTestObject.getTestObjectWithXpath("//select[@id='licence_formato_licencia']"), Formato_Licencia, false);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[contains(.,'Opciones Avanzadas')]"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_application_start_date']"), Fecha_Aplicacion);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[contains(@id,'licencia')]"), Numero_Licencia);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_rut_profesional']"), RUT_Profesional);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_nombre_profesional']"), Nombre_Profesional);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//textarea[contains(@id,'justificacion')]"), Justificacion);
	}
	
	public static void completarAtributosPersonalizados(String obsRRHH, String fechaRecepcion, String tipoInternoLicencia){
		
		WebUiBuiltInKeywords.waitForElementVisible(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_custom_attrs[Observaciones RRHH]']"), 30);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_custom_attrs[Observaciones RRHH]']"), obsRRHH);
		WebUiBuiltInKeywords.waitForElementVisible(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_custom_attrs[Fecha recepción]']"), 30);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_custom_attrs[Fecha recepción]']"), fechaRecepcion);
		WebUiBuiltInKeywords.waitForElementVisible(HelperTestObject.getTestObjectWithXpath("//select[@id='licence_custom_attrs[Tipo interno licencia]']"), 30);
		WebUiBuiltInKeywords.selectOptionByLabel(HelperTestObject.getTestObjectWithXpath("//select[@id='licence_custom_attrs[Tipo interno licencia]']"), tipoInternoLicencia, false);
	}
	
	public static void completarModalAgregarLicenciaCo(String Tipo_Asistencia, String Fecha_Inicio, String Duracion, String Tipo_Licencia, String Formato_Licencia, String Fecha_Aplicacion, String Justificacion) throws Exception {
		
		WebUiBuiltInKeywords.selectOptionByLabel(HelperTestObject.getTestObjectWithXpath("//select[@id='licence_licence_type_id']"), Tipo_Asistencia, false);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_start_date']"), Fecha_Inicio);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//label[@for='licence_dias_tomados']"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[contains(@id,'licence_dias_tomados')]"), Duracion);
		WebUiBuiltInKeywords.selectOptionByLabel(HelperTestObject.getTestObjectWithXpath("//select[@id='licence_tipo_licencia']"), Tipo_Licencia, false);
		WebUiBuiltInKeywords.selectOptionByLabel(HelperTestObject.getTestObjectWithXpath("//select[@id='licence_formato_licencia']"), Formato_Licencia, false);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[contains(.,'Opciones Avanzadas')]"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_application_start_date']"), Fecha_Aplicacion);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//textarea[contains(@id,'justificacion')]"), Justificacion);
	}
	
	public static void eliminarLicenciaCreada() {
		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("(//a[@href='#'][contains(.,'Asistencia')])[2]"), 15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(//a[@href='#'][contains(.,'Asistencia')])[2]"));
		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("//a[contains(.,'Ausencias')]"), 15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[contains(.,'Ausencias')]"));
		WebUiBuiltInKeywords.takeScreenshot();
		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("//a[@data-original-title='Eliminar']"), 15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[@data-original-title='Eliminar']"));
		WebUiBuiltInKeywords.waitForAlert(15);
		WebUiBuiltInKeywords.acceptAlert();
		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("//section//div[contains(@class,'alert alert-success alert-dismissible')]"), 120);
		WebUiBuiltInKeywords.takeScreenshot();
	//	WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//button[@data-dismiss='alert']")); por flaky test 

	}
	
	public static void completarModalAgregarPermiso(String Tipo_Asistencia, String Fecha_Inicio, String Duracion, String Justificacion, String Fecha_Aplicacion) throws Exception {
		
		WebUiBuiltInKeywords.selectOptionByLabel(HelperTestObject.getTestObjectWithXpath("//select[@id='licence_licence_type_id']"), Tipo_Asistencia, false);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_start_date']"), Fecha_Inicio);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//label[@for='licence_dias_tomados']"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[contains(@id,'licence_dias_tomados')]"), Duracion);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//textarea[contains(@id,'justificacion')]"), Justificacion);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[contains(.,'Opciones Avanzadas')]"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_application_start_date']"), Fecha_Aplicacion);
	}
	
	public static void completarModalAgregarPermisoPorHora(String Tipo_Asistencia, String Fecha_Inicio, String Hora_Inicio, String Hora_Termino, String Justificacion, String Fecha_Aplicacion) throws Exception {
		
		WebUiBuiltInKeywords.selectOptionByLabel(HelperTestObject.getTestObjectWithXpath("//select[@id='licence_licence_type_id']"), Tipo_Asistencia, false);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_start_date']"), Fecha_Inicio);
		WebUiBuiltInKeywords.doubleClick(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_start_time']"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_start_time']"), Hora_Inicio);
		WebUiBuiltInKeywords.doubleClick(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_end_time']"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_end_time']"), Hora_Termino);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//textarea[contains(@id,'justificacion')]"), Justificacion);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[contains(.,'Opciones Avanzadas')]"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_application_start_date']"), Fecha_Aplicacion);
	}
	
	public static void completarModalAgregarIncapacidad(String Tipo_Asistencia, String Fecha_Inicio, String Duracion, String Tipo_Incapacidad, String Justificacion, String Fecha_Aplicacion) throws Exception {
		
		WebUiBuiltInKeywords.selectOptionByLabel(HelperTestObject.getTestObjectWithXpath("//select[@id='licence_licence_type_id']"), Tipo_Asistencia, false);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_start_date']"), Fecha_Inicio);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//label[@for='licence_dias_tomados']"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[contains(@id,'licence_dias_tomados')]"), Duracion);
		WebUiBuiltInKeywords.selectOptionByLabel(HelperTestObject.getTestObjectWithXpath("//select[@id='licence_tipo_incapacidad_colombia']"), Tipo_Incapacidad, false);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//textarea[contains(@id,'justificacion')]"), Justificacion);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[contains(.,'Opciones Avanzadas')]"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_application_start_date']"), Fecha_Aplicacion);
	}

	public static void eliminarIncapacidadCreada() {
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(//a[@href='#'][contains(.,'Asistencia')])[2]"));
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[contains(.,'Ausencias')]"));
		WebUiBuiltInKeywords.waitForElementVisible(HelperTestObject.getTestObjectWithXpath("//a[@data-original-title='Eliminar']"),20);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[@data-original-title='Eliminar']"));
		WebUiBuiltInKeywords.waitForAlert(60);
		WebUiBuiltInKeywords.acceptAlert();
		WebUiBuiltInKeywords.waitForElementVisible(HelperTestObject.getTestObjectWithXpath("//div[contains(@class,'alert alert-success alert-dismissible')]"), 120);
		assert WebUiBuiltInKeywords.verifyTextPresent("Incapacidad borrado", false);
	}

	public static void eliminarPermisoCreado() {
		
		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("(//a[@href='#'][contains(.,'Asistencia')])[2]"), 15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(//a[@href='#'][contains(.,'Asistencia')])[2]"));
		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("//a[contains(.,'Ausencias')]"), 15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[contains(.,'Ausencias')]"));
		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("//a[@data-original-title='Eliminar']"), 15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[@data-original-title='Eliminar']"));
		WebUiBuiltInKeywords.waitForAlert(15);
		WebUiBuiltInKeywords.acceptAlert();
		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("//section//div[contains(@class,'alert alert-success alert-dismissible')]"), 120);
	//	WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//button[@data-dismiss='alert']"));
	}
	
	public static void compararRol(String rol) {
		if (rol.compareTo("RRHH")==0) {
			HelperTestObject.cierraPopUpsMesesAbiertos();
	    }
	}
	
	public static void irPestanaAsistenciaDeFicha1() {
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//div//div//ul//li//a[@href='#'][contains(.,'Asistencia')]"),15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//div//div//ul//li//a[@href='#'][contains(.,'Asistencia')]"));
	}
	
	public static void irPestanaAsistenciaDeFicha2() {
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("(//a[@href='#'][contains(.,'Asistencia')])[2]"),15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(//a[@href='#'][contains(.,'Asistencia')])[2]"));
	}
	
	public static void clickEnOpcionDiasDeFicha() {
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[@href='#asistencia'][contains(.,'Ausencias')]"),15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[@href='#asistencia'][contains(.,'Ausencias')]"));
		WebUiBuiltInKeywords.waitForElementNotVisible(HelperTestObject.getTestObjectWithXpath("//a[@href='#asistencia'][contains(.,'Ausencias')]"),30);
	}
	
	public static void clickEnBotonSolicitarPermiso() {
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[contains(.,'Solicitar Permiso')]"),15);
		HelperTestObject.determinaNotificacionConProgressBarPresente();
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[contains(.,'Solicitar Permiso')]"));
	}
	
	public static void clickEnBotonSolicitar() {
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//input[@type='submit']"),15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[@type='submit']"));
	}
	
	public static void validarAccionRealizada() {

		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("//div[contains(@class,'alert alert-success alert-dismissible')]"), 120);
	}
	
	public static void aprobarPermiso() {		

		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//i[@class=' fas fa-check ']"),45);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//i[@class=' fas fa-check ']"));
		
	}
	
	public static void rechazarPermiso() {
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//td//a//i[@class=' fas fa-times ']"),15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//td//a//i[@class=' fas fa-times ']"));
		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("//textarea[@id='licence_rejection_comment']"),15);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//textarea[@id='licence_rejection_comment']"), "Permiso debe ser sin goce");
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//div//div//input[contains(@class,'btn btn-primary')]"),15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//div//div//input[contains(@class,'btn btn-primary')]"));

	}
	
	public static void completarModalSolicitudPermiso(String Tipo_Asistencia, String Fecha_Inicio, String Duracion, String Justificacion) throws Exception{
		
		WebUiBuiltInKeywords.selectOptionByLabel(HelperTestObject.getTestObjectWithXpath("//select[@id='licence_licence_type_id']"), Tipo_Asistencia, false);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_start_date']"), Fecha_Inicio);
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_dias_tomados']"),15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_dias_tomados']"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_dias_tomados']"), Duracion);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//textarea[@id='licence_justificacion']"), Justificacion);
	}
	
	public static void CrearHoraExtra(String Tipo_Hora_Extra, String Nro_Hora, String Comentario, String Fecha) {
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[@data-association-insertion-node='#sobretiempos_list'][contains(.,'Agregar Horas Extras')]"),15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[@data-association-insertion-node='#sobretiempos_list'][contains(.,'Agregar Horas Extras')]"));
		WebUiBuiltInKeywords.selectOptionByLabel(HelperTestObject.getTestObjectWithXpath("//select[@class='form-control select required'][contains(@id,'id')]"), Tipo_Hora_Extra, false);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[@class='form-control numeric decimal required'][contains(@id,'horas')]"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@class='form-control numeric decimal required'][contains(@id,'horas')]"), Nro_Hora);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[contains(.,'Opciones Avanzadas')]"));
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[@class='form-control string optional'][contains(@id,'description')]"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@class='form-control string optional'][contains(@id,'description')]"), Comentario);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[@class='form-control date optional'][contains(@id,'date')]"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@class='form-control date optional'][contains(@id,'date')]"), Fecha);
		WebUiBuiltInKeywords.waitForElementVisible(HelperTestObject.getTestObjectWithXpath("//span[@class='btn-label'][contains(.,'Guardar')]"), 40);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//span[@class='btn-label'][contains(.,'Guardar')]"));
		}
	
	public static void EliminarHoraExtra() {
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[@title='Detalle Horas Extras'][contains(.,'Registrar Horas Extras')]"),15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[@title='Detalle Horas Extras'][contains(.,'Registrar Horas Extras')]"));
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//span[@class=' material-icons  notranslate '][contains(.,'delete')]"));
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//span[@class='btn-label'][contains(.,'Guardar')]"));
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//h2[contains(text(),'(Horas Extras)')]/ancestor::div[@class='box box-inner mb-4']//div[@class='box-body py-4 ']//td[text()='No hay elementos para mostrar']"),15);	
		assert WebUiBuiltInKeywords.verifyTextPresent("No hay elementos para mostrar", false);
		}
	
	public static void CrearRecargo(String Tipo_Recargo, String Nro_Hora, String Comentario, String Fecha) {
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[contains(.,'Agregar Recargos')]"));
		WebUiBuiltInKeywords.selectOptionByLabel(HelperTestObject.getTestObjectWithXpath("//select[@class='form-control select required'][contains(@id,'id')]"), Tipo_Recargo, false);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[@class='form-control numeric decimal required'][contains(@id,'horas')]"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@class='form-control numeric decimal required'][contains(@id,'horas')]"), Nro_Hora);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[contains(.,'Opciones Avanzadas')]"));
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[@class='form-control string optional'][contains(@id,'description')]"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@class='form-control string optional'][contains(@id,'description')]"), Comentario);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[@class='form-control date optional'][contains(@id,'date')]"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@class='form-control date optional'][contains(@id,'date')]"), Fecha);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//span[@class='btn-label'][contains(.,'Guardar')]"));
		}
	
	public static void EliminarRecargo() {
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//span[contains(.,'delete')]"));
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//span[@class='btn-label'][contains(.,'Guardar')]"));
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(//a[@href='#'][contains(.,'Asistencia')])[2]"));
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[@href='#horas_extras'][contains(.,'Horas Extra y Recargos')]"));
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//h2[contains(text(),'Recargos')]/ancestor::div[@class='box box-inner   mb-4']//div[@class='box-body py-4 ']//td[text()='No hay elementos para mostrar']"),15);		
		assert WebUiBuiltInKeywords.verifyTextPresent("No hay elementos para mostrar", false);
		}
	
	public static void completarModalAgregarLicencia_PE(String Tipo_Asistencia, String Fecha_Inicio, String Duracion, String Tipo_Licencia,
			String Formato_Licencia, String Fecha_Aplicacion, String Justificacion) {
		
		WebUiBuiltInKeywords.selectOptionByLabel(HelperTestObject.getTestObjectWithXpath("//select[@id='licence_licence_type_id']"), Tipo_Asistencia, false);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_start_date']"), Fecha_Inicio);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//label[@for='licence_dias_tomados']"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[contains(@id,'licence_dias_tomados')]"), Duracion);
		WebUiBuiltInKeywords.selectOptionByLabel(HelperTestObject.getTestObjectWithXpath("//select[@id='licence_tipo_licencia']"), Tipo_Licencia, false);
		WebUiBuiltInKeywords.selectOptionByLabel(HelperTestObject.getTestObjectWithXpath("//select[@id='licence_formato_licencia']"), Formato_Licencia, false);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[contains(.,'Opciones Avanzadas')]"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='licence_application_start_date']"), Fecha_Aplicacion);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//textarea[contains(@id,'justificacion')]"), Justificacion);
	}
	
	public static void SeleccionarHoraExtra() {
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[@href='#horas_extras'][contains(.,'Horas Extra y Recargos')]"),40);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[@href='#horas_extras'][contains(.,'Horas Extra y Recargos')]"));
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[@title='Detalle Horas Extras'][contains(.,'Registrar Horas Extras')]"),40);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[@title='Detalle Horas Extras'][contains(.,'Registrar Horas Extras')]"));
	}
	
	public static void SeleccionarRecargo() {
		
	
		
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[@href='#horas_extras'][contains(.,'Horas Extra y Recargos')]"), 40);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[@href='#horas_extras'][contains(.,'Horas Extra y Recargos')]"));
		
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[@title='Detalle Recargos'][contains(.,'Registrar Recargos')]"), 40);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[@title='Detalle Recargos'][contains(.,'Registrar Recargos')]"));
		
	}
	
	
	public static boolean procesandoAgregarRegistroAusencia() {
		
	    
		System.out.println("comenzando metodo.....");
		if (WebUiBuiltInKeywords.waitForElementVisible(HelperTestObject.getTestObjectWithXpath("//input[@value='Procesando...']"), 10, FailureHandling.OPTIONAL) == true) {
			
			System.out.println("Procesando encontrado.....");
			return true;			
		}
		else {
			
			System.out.println("Procesando No encontrado.....");
			return false;
			
		}		
	}
}