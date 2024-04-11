package com.saucelabs.businesslogic;

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords;
import com.saucelabs.helper.HelperFile;
import com.saucelabs.helper.HelperTestObject;

public class BLImportadores {
	
	public static void irAImportadores() {
		
		WebUiBuiltInKeywords.takeScreenshot();
		WebUiBuiltInKeywords.scrollToPosition(0, 600);
		
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("(//span[contains(.,'Importadores')])[1]"),15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(//span[contains(.,'Importadores')])[1]"));
		WebUiBuiltInKeywords.takeScreenshot();
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("(//span[contains(.,'Importadores')])[2]"),15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(//span[contains(.,'Importadores')])[2]"));
	}		
	
	public static void seleccionarCamposImportadorSaldoVacaciones(String Tipo_Carga, String Tipo_Vacaciones) {
	
		if (Tipo_Carga.compareTo("Saldo inicial") ==0) {
			WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[contains(@id,'inicial')]"));
		}else if (Tipo_Carga.compareTo("Saldo adicional") ==0) {
			WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[contains(@id,'adicional')]"));
		}

		if (Tipo_Vacaciones.compareTo("Vacaciones Progresivas") ==0) {
			WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[contains(@id,'progresivas')]"));
		}else if (Tipo_Vacaciones.compareTo("Días adicionales") ==0) {
			WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[contains(@id,'administrativos')]"));
		}else if (Tipo_Vacaciones.compareTo("Legales") ==0) {
			WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[contains(@id,'legales')]"));

		}
	}
	
	public static void importarSaldoVacaciones(String nombreArchivoEntrada) throws Exception {
		
		WebUiBuiltInKeywords.scrollToElement(HelperTestObject.getTestObjectWithXpath("//input[@type='file']"), 2);
		HelperFile.uploadfile(nombreArchivoEntrada);
		WebUiBuiltInKeywords.takeScreenshot();
		
		
		while (mensajeExitoPresente()) {
			System.out.println("Aun no termina la importación.............");
		}
		WebUiBuiltInKeywords.scrollToElement(HelperTestObject.getTestObjectWithXpath("//div[contains(@class,'progress-bar progress-bar-success')]"), 120);
		assert WebUiBuiltInKeywords.verifyTextPresent("Archivo importado exitosamente", false);
		WebUiBuiltInKeywords.takeScreenshot();
		WebUiBuiltInKeywords.scrollToElement(HelperTestObject.getTestObjectWithXpath("//span[@class='material-icons'][contains(.,'close')]"), 2);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//span[@class='material-icons'][contains(.,'close')]"));
		WebUiBuiltInKeywords.waitForElementNotPresent(HelperTestObject.getTestObjectWithXpath("//span[@class='material-icons'][contains(.,'close')]"), 10);
	}

	public static void verificarImportacionExitosa () {
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[@href='#vacaciones']"));
		WebUiBuiltInKeywords.scrollToElement(HelperTestObject.getTestObjectWithXpath("//td[text()='01-02-2022']"), 2);
		assert WebUiBuiltInKeywords.verifyTextPresent("01-02-2022", false);
		WebUiBuiltInKeywords.takeScreenshot();
	}
	
	//se agrego el día 19-oct-2022
	public static void cargarArchivoImportador (String nombreArchivoEntrada) {
		WebUiBuiltInKeywords.scrollToElement(HelperTestObject.getTestObjectWithXpath("//input[@type='file']"), 2);
		HelperFile.uploadfile(nombreArchivoEntrada);
	}
	
	public static void verificarImportacionExitosaPorImportador () {
	 
	    
		WebUiBuiltInKeywords.waitForElementNotPresent(HelperTestObject.retornaObjetoMensajeExitoImportador(),10);	
		assert WebUiBuiltInKeywords.verifyTextPresent("Archivo importado exitosamente", false);
		WebUiBuiltInKeywords.takeScreenshot();
		WebUiBuiltInKeywords.scrollToElement(HelperTestObject.getTestObjectWithXpath("//span[@class='material-icons'][contains(.,'close')]"), 2);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//span[@class='material-icons'][contains(.,'close')]"));
		WebUiBuiltInKeywords.waitForElementNotPresent(HelperTestObject.getTestObjectWithXpath("//span[@class='material-icons'][contains(.,'close')]"), 10);
		BLNavegacion.clickMenu("Procesos");
	}
	
	/**
	 * @param tab, pestaña correspodiente a la sección a cual corresponde el importador 
	 * @param importador, el nombre del importador
	 * 
	 * Dados los parámetros seleccionamos el importador que corresponda
	 */
	public static void seleccionarImportador(String tab,String importador) {
		HelperTestObject.navegarPorTab(tab);
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("(//div[@class='info-title text-truncate'][contains(.,'" +importador+"')])[1]"), 10);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(//div[@class='info-title text-truncate'][contains(.,'" +importador+"')])[1]"));
	}
	
	public static boolean mensajeExitoPresente() {		
		
		if (WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("(//div[contains(text(),'Archivo importado exitosamente')]"),5)) 
			return true;
		else 
			return false;			
	}	

}