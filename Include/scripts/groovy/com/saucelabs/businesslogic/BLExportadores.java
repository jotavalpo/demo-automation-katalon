package com.saucelabs.businesslogic;



import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords;
import com.saucelabs.helper.HelperSeleniumJSandActions;
import com.saucelabs.helper.HelperTestObject;

public class BLExportadores {
	
	public static void irAExportadores() {
		
		BLNavegacion.clickOpcionMenu("Exportadores", "Personalizados");
	
	}
	
	
	public static void clicEnPlantillaVacaciones() {
		
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//button[@type='button'][contains(.,'Vacaciones')]"),15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//button[@type='button'][contains(.,'Vacaciones')]"));
	
	}
	
	
	public static void clicEnOpcionRegistroDeVacaciones() {
		
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[@href='/report/custom_report_templates/new/vacation']"),15);
		HelperSeleniumJSandActions.executeJSClick(HelperTestObject.getTestObjectWithXpath("//a[@href='/report/custom_report_templates/new/vacation']"));
	
	}
	
	
	public static void clicEnPlantillaNomina() {
		
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[@href='/report/custom_report_templates/new/nomina']"),15);		
		HelperSeleniumJSandActions.executeJSClick(HelperTestObject.getTestObjectWithXpath("//a[@href='/report/custom_report_templates/new/nomina']"));
	
	}
	
	
	public static void clicEnPlantillaAusencia() {
		
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[@href='/report/custom_report_templates/new/attendance']"),15);
		HelperSeleniumJSandActions.executeJSClick(HelperTestObject.getTestObjectWithXpath("//a[@href='/report/custom_report_templates/new/attendance']"));
	
	}
	
	
	public static void clicEnPlantillaLiquidaciones() {
		
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[@href='/report/custom_report_templates/new/linea_liquidacion]"),15);
		HelperSeleniumJSandActions.executeJSClick(HelperTestObject.getTestObjectWithXpath("//a[@href='/report/custom_report_templates/new/linea_liquidacion']"));
	
	}
	
	
	public static void clicEnPlantillaAsignacionItems() {
		
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[@href='/report/custom_report_templates/new/assign']"),15);
		HelperSeleniumJSandActions.executeJSClick(HelperTestObject.getTestObjectWithXpath("//a[@href='/report/custom_report_templates/new/assign']"));
	
	}
	
	
	public static void clicEnPlantillaPredefinidos() {
		
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//button[@type='button'][contains(.,'Predefinidos')]"),15);
		HelperSeleniumJSandActions.executeJSClick(HelperTestObject.getTestObjectWithXpath("//button[@type='button'][contains(.,'Predefinidos')]"));
	
	}
	
	
	public static void clicEnOpcionLeyesPredefinidos() {
		
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[@href='/report/custom_report_templates/leyes_sociales']"),15);
		HelperSeleniumJSandActions.executeJSClick(HelperTestObject.getTestObjectWithXpath("//a[@href='/report/custom_report_templates/leyes_sociales']"));
	
	}
	
	
	public static void clicEnOpcionAreas() {
		
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[@href='/report/custom_report_templates/areas']"),15);
		HelperSeleniumJSandActions.executeJSClick(HelperTestObject.getTestObjectWithXpath("//a[@href='/report/custom_report_templates/areas']"));
	
	}
	
	
	public static void clicEnPlantillaEstructuras() {
		
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//button[@type='button'][contains(.,'Estructuras')]"),15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//button[@type='button'][contains(.,'Estructuras')]"));
	
	}
	
	
	public static void clicEnPlantillaFirmaDocumentos() {
		
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[@href='/report/custom_report_templates/new/employee_file']"),15);
		HelperSeleniumJSandActions.executeJSClick(HelperTestObject.getTestObjectWithXpath("//a[@href='/report/custom_report_templates/new/employee_file']"));
	
	}
	
	
	public static void clicEnPlantillaSolicitudes() {
		
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//button[@type='button'][contains(.,'Solicitudes')]"),15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//button[@type='button'][contains(.,'Solicitudes')]"));
	
	}
	
	
	public static void clicEnOpcionProcesosBusqueda() {
		
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[@href='/report/custom_report_templates/new/workflow_search_process']"),15);
		HelperSeleniumJSandActions.executeJSClick(HelperTestObject.getTestObjectWithXpath("//a[@href='/report/custom_report_templates/new/workflow_search_process']"));
	
	}
	
	
	public static void clicEnPlantillaReliquidaciones() {
		
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[@href='/report/custom_report_templates/new/montos_reliquidacion']"),15);
		HelperSeleniumJSandActions.executeJSClick(HelperTestObject.getTestObjectWithXpath("//a[@href='/report/custom_report_templates/new/montos_reliquidacion']"));
	
	}
	
	
	public static void clicEnPlantillaGrupoFamiliar() {
		
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[@href='/report/custom_report_templates/new/detalle_carga']"),15);
		HelperSeleniumJSandActions.executeJSClick(HelperTestObject.getTestObjectWithXpath("//a[@href='/report/custom_report_templates/new/detalle_carga']"));
	
	}
	
	
	public static void clicEnPlantillaAPVIndividual() {
		
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[@href='/report/custom_report_templates/new/apvi']"),15);
		HelperSeleniumJSandActions.executeJSClick(HelperTestObject.getTestObjectWithXpath("//a[@href='/report/custom_report_templates/new/apvi']"));
	
	}
	
	
	public static void clicEnBotonGuardar() {
		
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//div//button[contains(@data-title,'Guardar')]"),120);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//div//button[contains(@data-title,'Guardar')]"));
		assert WebUiBuiltInKeywords.verifyElementPresent(HelperTestObject.getTestObjectWithXpath("//div[text()=' Reporte guardado con éxito  ']"), 120); 
	
	}
	
	
	public static void clicEnBotonDescargar() {
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//div//a[contains(@data-modal-title,'Descargar Reporte')]"),15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//div//a[contains(@data-modal-title,'Descargar Reporte')]"));
	
	}
	

	public static void seleccionarRangoFechasParaDescargaReporte (String Fecha_Desde, String Fecha_Hasta) {
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='report_custom_report_template_start_date']"), Fecha_Desde);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='report_custom_report_template_end_date']"), Fecha_Hasta);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[@id='report_custom_report_template_start_date']"));
	
	}
	
	
	public static void seleccionarRangoFechasParaDescargaReporteModals(String Fecha_Desde, String Fecha_Hasta) {
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='report_custom_report_template_start_at']"), Fecha_Desde);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='report_custom_report_template_end_at']"), Fecha_Hasta);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[@id='report_custom_report_template_start_at']"));
	
	}
	
	
	public static void seleccionarRangoFechasParaDescargaReportesMes (String Mes) {
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='report_custom_report_template_start_at']"), Mes);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[@id='report_custom_report_template_start_at']"));
	
	}
	
	
	public static void seleccionarRangoFechasParaDescargaReporteSolicitudes (String Fecha_Desde, String Fecha_Hasta) {
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='start_date']"), Fecha_Desde);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='end_date']"), Fecha_Hasta);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[@id='start_date']"));
	
	}
	
	
	public static void clicNuevamenteEnBotonDescargar() {
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//span[@class='btn-label'][contains(.,'Descargar')]"),15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//span[@class='btn-label'][contains(.,'Descargar')]"));
	
	}
	
	
	public static void registroExportado() throws Exception{
		
 
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//div[@class='result-link']"),45);	
		while (HelperTestObject.notificacionConProgressBarPresente()) {
			
			HelperTestObject.determinaNotificacionConProgressBarPresente();
			WebUiBuiltInKeywords.waitForPageLoad(20);
			
		}
		
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//span[@class='material-icons'][contains(.,'close')]"));
		WebUiBuiltInKeywords.waitForElementNotPresent(HelperTestObject.getTestObjectWithXpath("//div[@class='result-link']"),40);
		System.out.println("Terminando la exportación");
	
	}
	
	
	public static void registroExportadoSinMensaje() throws Exception{
		
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//div[@class='result-link']"),45);		
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//span[@class='material-icons'][contains(.,'close')]"));
		WebUiBuiltInKeywords.waitForElementNotPresent(HelperTestObject.getTestObjectWithXpath("//div[@class='result-link']"),40);
		System.out.println("Terminando la exportación");
	
	
	}
	
	
	public static void borrarReporte() throws Exception{
		
		WebUiBuiltInKeywords.waitForElementVisible(HelperTestObject.getTestObjectWithXpath("//div//a[contains(@data-original-title,'Eliminar')]"), 120);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//div//a[contains(@data-original-title,'Eliminar')]"));
		WebUiBuiltInKeywords.waitForPageLoad(20);
		HelperTestObject.questionBuk("Aceptar");
		assert WebUiBuiltInKeywords.verifyElementPresent(HelperTestObject.getTestObjectWithXpath("//div[text()=' Reporte eliminado con éxito  ']"), 120);	
		WebUiBuiltInKeywords.waitForPageLoad(20);
		WebUiBuiltInKeywords.takeScreenshot();
	
	}	

}