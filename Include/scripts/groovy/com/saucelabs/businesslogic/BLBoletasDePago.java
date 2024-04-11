package com.saucelabs.businesslogic;
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords;
import com.saucelabs.helper.HelperTestObject;

public class BLBoletasDePago {
	
	public static void SeleccionarBoleta(String Mes) {
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[contains(@data-modal-title,'"+ Mes +"')]"), 15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[contains(@data-modal-title,'"+ Mes +"')]"));
	}
	
	//td[contains(.,'1,00 días')]
	
	public static void identificarInasistencia(String Duracion) {
		//WebUiBuiltInKeywords.verifyElementText(HelperTestObject.getTestObjectWithXpath("//div[@class='col-md-3 container'][contains(.,'Inasistencia: 1 días')]"));
		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("//div[@class='col-md-3 container'][contains(.,'Inasistencia: "+Duracion+" días')]"), 120);
	}
	
	public static void identificarLicencia(String Duracion) {
		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("//div[@class='col-md-3 container'][contains(.,'Licencias: "+Duracion+" días')]"), 120);
	}
	
	public static void identificarPermiso(String Duracion) {
		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("//div[@class='col-md-3 container'][contains(.,'Permisos: "+Duracion+" días')]"), 120);
	}
	
	public static void identificarPermisoPorHora(String Duracion) {
		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("//div[@class='col-md-3 container'][contains(.,'Permisos: "+Duracion+"')]"), 120);
	}
	
	public static void identificarAsistencia(String diasTrabajados) {
		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("//div[@class='col-md-3 container'][contains(.,'Días Trabajados: "+diasTrabajados+" días')]"), 120);
	}
	
	public static void resultadoEsperado(String Resultado) {
		WebUiBuiltInKeywords.verifyElementText(HelperTestObject.getTestObjectWithXpath("//td[@class='text-right text-nowrap'][contains(.,'S/ "+Resultado+"')]"), "S/ " + Resultado );
		WebUiBuiltInKeywords.delay(10);
	}
	
	public static void resultadoCtsBaseCalculo(String ctsBaseCalculo, String Campo) {
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(//i[contains(@class,' fas fa-spinner ')])["+Campo+"]"));
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(//span[contains(.,'manage_search')])["+Campo+"]"));
		WebUiBuiltInKeywords.waitForElementVisible(HelperTestObject.getTestObjectWithXpath("//div[@class='text-truncate'][contains(.,'Cts: Base Cálculo')]"), 180);	
		WebUiBuiltInKeywords.verifyElementText(HelperTestObject.getTestObjectWithXpath("//div[@class='item_subtitle pt-1'][contains(.,'S/ "+ctsBaseCalculo+"')]"), "S/ " + ctsBaseCalculo );
		
	}
	
	public static void resultadoCtsGratificacion(String ctsGratificacion) {
		WebUiBuiltInKeywords.waitForElementVisible(HelperTestObject.getTestObjectWithXpath("//strong[contains(.,'CTS: Gratificación')]"), 180);	
		WebUiBuiltInKeywords.verifyElementText(HelperTestObject.getTestObjectWithXpath("//div[@class='item_subtitle pt-1'][contains(.,'S/ "+ctsGratificacion+"')]"), "S/ " + ctsGratificacion );
	}

	public static void resultadoCtsMeses(String ctsMeses) {
		WebUiBuiltInKeywords.waitForElementVisible(HelperTestObject.getTestObjectWithXpath("//strong[contains(.,'CTS: Meses')]"), 180);	
		WebUiBuiltInKeywords.verifyElementText(HelperTestObject.getTestObjectWithXpath("//div[@class='item_subtitle pt-1'][contains(.,'S/ "+ctsMeses+"')]"), "S/ " + ctsMeses );
	}
	
	public static void resultadoCtsAcumuladaMesAnterior(String ctsAcumuladaMesAnterior) {
		WebUiBuiltInKeywords.waitForElementVisible(HelperTestObject.getTestObjectWithXpath("//strong[contains(.,'CTS: Provisión Acumulada Mes Anterior')]"), 180);	
		WebUiBuiltInKeywords.verifyElementText(HelperTestObject.getTestObjectWithXpath("//div[@class='item_subtitle pt-1'][contains(.,'S/ "+ctsAcumuladaMesAnterior+"')]"), "S/ " + ctsAcumuladaMesAnterior );
	}
	
	public static void clickBoletaPago() {
		
		HelperTestObject.clickDocumentoPago();
		
	}
	
	public static void cerrarBoleta() {
		
		HelperTestObject.cerrarDocumentoPago();
	
	}
	
	
}