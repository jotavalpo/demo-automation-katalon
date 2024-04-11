package com.saucelabs.helper;

import org.openqa.selenium.Keys;
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords;


import internal.GlobalVariable;


import com.kms.katalon.core.model.FailureHandling;
import com.kms.katalon.core.testobject.ConditionType;
import com.kms.katalon.core.testobject.TestObject;
import com.kms.katalon.core.util.KeywordUtil;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import com.kms.katalon.core.webui.common.WebUiCommonHelper;


import com.kms.katalon.core.webui.driver.DriverFactory;
/**
 * @author Francisco Nuñez
 *
 */
/**
 * @author Francisco Nuñez
 *
 */
public class HelperTestObject {

	static String baseUrl = "";

	// retorna un testObject con xpath como localizador - FHNI
	// xpath, localizador de elemento
	//no se puede esperar por elemento debido a que podrían ser muchas tipos de esperas
	public static TestObject getTestObjectWithXpath(String xpath) {
		TestObject testObject = new TestObject().addProperty("xpath", ConditionType.EQUALS, xpath);
		highlightObject(testObject);
			
		/*try {
			WebUiBuiltInKeywords.findWebElement(testObject);
		} catch (Exception e1) {
			try {
				WebUiBuiltInKeywords.waitForElementPresent(testObject, 3);

			} catch (Exception e2) {
				System.out.println("Element '" + testObject + "' not present - Exception: ".concat(e2.getMessage()));
				WebUiBuiltInKeywords.takeFullPageScreenshot();
				throw (e2);

			}
		} 
		*/

		return testObject;

	}
	
	public static TestObject getTestObjectWithCSS(String css) {
		    TestObject testObject = new TestObject();
		    testObject.addProperty("css", ConditionType.EQUALS, css);
		    highlightObject(testObject);	
		    return testObject;
		  }

	/**
	 * @author diegomartinez
	 * @param xpath - Xpath que tienen TODOS los elementos que se buscaran
	 * @return - Retorna un listado de elementos (WebElement) para ser utilizados
	 * @throws Exception - Bota la ejecucion si no encuentra elementos, se debe utilizar con try catch para capturar el error y continuar la ejecución
	 */
	public static List<WebElement> getAllTestObjectsWithXpath(String xpath) throws Exception {
		WebDriver driver = DriverFactory.getWebDriver();
		List<WebElement> listofelements = driver.findElements(By.xpath(xpath));
		return listofelements;

	}
	
	public static WebElement getWebElement(String xpath) throws Exception {
		WebDriver driver = DriverFactory.getWebDriver();
		WebElement webElement = driver.findElement(By.xpath(xpath));
		return webElement;

	}

	// Selecciona o deselecciona un chekbox - FHNI
	// accion: selecciona / deselecciona
	// testObject: Objeto que clickeara
	public static void selectDeselectCheckBox(String accion, TestObject testObject) {

		
		WebUiBuiltInKeywords.waitForElementVisible(testObject, 30);
		try {

			WebUiBuiltInKeywords.scrollToElement(testObject, 5);
			if (accion.compareTo("Select") == 0 && WebUiBuiltInKeywords.verifyElementNotChecked(testObject, 30)) {

				if (WebUiBuiltInKeywords.verifyElementNotChecked(testObject, 10)) {

				}

				WebUiBuiltInKeywords.click(testObject);

			} else if (accion.compareTo("Unselect") == 0 && WebUiBuiltInKeywords.verifyElementChecked(testObject, 30)) {

				WebUiBuiltInKeywords.click(testObject);
			}

		} catch (Exception e) {
			System.out.println("El elemento ya tenía el estado de la acción a realizar:" + testObject.getXpaths());
		}
	}

	/*
	 * FHNI // Ingresa una cadena en un elemento calendario
	 */
	public static void ingresaCalendario(TestObject testObject, String fecha) {

		WebUiBuiltInKeywords.scrollToElement(testObject, 5);
		WebUiBuiltInKeywords.setText(testObject, fecha);
		WebUiBuiltInKeywords.sendKeys(testObject, Keys.chord(Keys.ENTER));

	}

	public static void determinaYCierraNotificacionPresente() {

		boolean flag = false;

		if (GlobalVariable.Pais.toString() == "Mexico") {
			flag = true;

		}

		while (!flag) {
			if (WebUiBuiltInKeywords.waitForElementClickable(
					getTestObjectWithXpath("//div[2][@class='noty_close_button']"), 1,
					FailureHandling.OPTIONAL) == true) {

				WebUiBuiltInKeywords.scrollToElement(getTestObjectWithXpath("//div[2][@class='noty_close_button']"), 1,
						FailureHandling.OPTIONAL);
				WebUiBuiltInKeywords.click(getTestObjectWithXpath("//div[2][@class='noty_close_button']"),FailureHandling.OPTIONAL);
				System.out.println("Cerrando notiicación......");

			} else {
				flag = true;
				System.out.println("Ya no quedan Notificaciones......");
			}
		}
	}
	/**
	 * Encuentra los toast que aparecen en la parte superior derecha de la pantalla, y los cierra
	 */

	public static void determinaNotificacionConProgressBarPresente() {
		
		try {
			List<WebElement> closeButtonProcessWithProgressBar = getAllTestObjectsWithXpath("//div[@class='noty_close_button']");
			for (WebElement notification : closeButtonProcessWithProgressBar) {
				if (notification.isDisplayed()) {					
					try {
						notification.click();
					} catch (Exception e) {
						
					}
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void determinaNotificacionNuevaFuncionalidadPresente() {

		TestObject closeButtonNewAdvert = getTestObjectWithXpath("//*[@class='beamerClose']");

		if (WebUiBuiltInKeywords.verifyElementPresent(closeButtonNewAdvert, 5, FailureHandling.OPTIONAL)) {

			cerrarNotificacionNuevaFuncionalidad();

		} else {

		}

	}

	public static void cerrarNotificacionConProgressBar() {
		TestObject closeButtonProcessWithProgressBar = getTestObjectWithXpath("//div[@class='noty_close_button']");
		WebUiBuiltInKeywords.click(closeButtonProcessWithProgressBar);

	}

	public static void cerrarNotificacionNuevaFuncionalidad() {
		TestObject closeButtonProcessWithProgressBar = getTestObjectWithXpath("//*[@class='beamerClose']");
		WebUiBuiltInKeywords.click(closeButtonProcessWithProgressBar);

	}
	
	public static boolean notificacionConProgressBarPresente() {

		if (WebUiBuiltInKeywords.waitForElementVisible(getTestObjectWithXpath("//div[2][@class='noty_close_button']"),10,FailureHandling.OPTIONAL)) {

				return true;

		} 
		else{
			
			return false;			
			
		}		
	}

	/****
	 * FHNI //Solventa problema de notificación esquina superior derecho verde
	 * //Debemos repensar un metodo que consulte si existen notificaciones en
	 * pantalla y cerrarlas
	 **/
	public static void cierraNotificacinInformativaVerde() {

		// si el elemento esta presente vamos al elemento y clickeamos elementos y
		// esperamos a que desaparezca - FHNI

		if (WebUiBuiltInKeywords.waitForElementClickable(getTestObjectWithXpath("//div[2][@class='noty_close_button']"),
				20) == true) {

			WebUiBuiltInKeywords.scrollToElement(getTestObjectWithXpath("//div[2][@class='noty_close_button']"), 20);
			WebUiBuiltInKeywords.click(getTestObjectWithXpath("//div[2][@class='noty_close_button']"));
		}

		WebUiBuiltInKeywords.waitForElementNotVisible(getTestObjectWithXpath("//div[2][@class='noty_close_button']"),
				10);
	}

	public static void cierraNotificacinInformativaAzul() {

		// si el elemento esta presente vamos al elemento y clickeamos elementos y
		// esperamos a que desaparezca - FHNI

		if (WebUiBuiltInKeywords.waitForElementClickable(
				getTestObjectWithXpath("//div[@id='noty_layout__topRight']/div/div[@class='noty_close_button']"),
				20) == true) {

			WebUiBuiltInKeywords.scrollToElement(
					getTestObjectWithXpath("//div[@id='noty_layout__topRight']/div/div[@class='noty_close_button']"),
					20);
			WebUiBuiltInKeywords.click(
					getTestObjectWithXpath("//div[@id='noty_layout__topRight']/div/div[@class='noty_close_button']"));
		}

	}

	public static void scrollWaitClickToTestObjectByXpath(String xpath) {
		
		System.out.println("scrollWaitClickToTestObjectByXpath Elemento: " + xpath);
		WebUiBuiltInKeywords.scrollToElement(HelperTestObject.getTestObjectWithXpath(xpath), 30);
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath(xpath), 30);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath(xpath));

	}

	public static void setUrl(String url) {
		baseUrl = url;
	}

	public static String getUrl() {
		return baseUrl;
	}

	public static void highlightObject(TestObject objectto) {

		WebDriver driver = DriverFactory.getWebDriver();
		try {
			WebElement element = WebUiCommonHelper.findWebElement(objectto, 20);
			for (int i = 0; i < 5; i++) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');",
						element);
			}
		} catch (Exception e) {
			KeywordUtil.logInfo(e.getMessage());
		}
	}

	public static TestObject returnTextTytleModalByTextTitle(String text){
		
		WebUiBuiltInKeywords.takeScreenshot();
		String xpath = "//h2[text()='" + text + "']";
		TestObject modal = null;
		if (WebUiBuiltInKeywords.waitForElementVisible(HelperTestObject.getTestObjectWithXpath(xpath), 60,FailureHandling.CONTINUE_ON_FAILURE )) {			
			return HelperTestObject.getTestObjectWithXpath(xpath);		
		}else {	
		
			System.out.println("No se encontro modal con texto: " + text);
			return modal;
		}
		

	}

	public static void cierraPopUpsMesesAbiertos() {

		if (GlobalVariable.MultiplesMesesAbiertos.equals("Si")) {

			WebUiBuiltInKeywords
					.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//button[text()='OK']"), 40);
			WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//button[text()='OK']"),FailureHandling.OPTIONAL);
		}

	}

	public static void esperarPorElementoNoEsteVisible(String xpath) {
        
		
		WebUiBuiltInKeywords.waitForElementNotVisible(HelperTestObject.getTestObjectWithXpath(xpath), 120);

	}

	
	
	public static void navegarPorTab(String nombreOpcion) {
		
		  WebUiBuiltInKeywords.click(getTestObjectWithXpath("//a[contains(text(),'"+nombreOpcion+"')]"));
	 }

	
	public static void seleccionarVueTreeSelect(String opcion, String opcion2, String opcion3) {	    
	
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[@class='vue-treeselect__input']"));	   
	    
	    WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//*[contains(text(),'" + opcion + "')]"));
	    WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//*[contains(text(),'" + opcion2 + "')]"));
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//*[contains(text(),'" + opcion3 + "')]"));
	    	
	}
	
	public static void seleccionarVueTreeSelect(String opcion, String opcion2) {	    
		
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[@class='vue-treeselect__input']"));	   
	    
	    WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//*[contains(text(),'" + opcion + "')]"));
	    WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//*[contains(text(),'" + opcion2 + "')]"));
	  
	    	
	}
	
	public static void seleccionarVueTreeSelect(String opcion) {	    
		
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[@class='vue-treeselect__input']"));	   
	    
	    WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//*[contains(text(),'" + opcion + "')]"));
	  
	    	
	}
	
	
	public static TestObject retornaObjetoMensajeExito() {
		
		WebUiBuiltInKeywords.waitForElementVisible(getTestObjectWithXpath("//div[contains(@class,'alert-success')]"), 180);	
		TestObject object = getTestObjectWithXpath("//div[contains(@class,'alert-success')]");
		return	object;
		
	}
	
		public static TestObject retornaObjetoMensajeExitoImportador() {
		
		
			WebUiBuiltInKeywords.waitForElementVisible(getTestObjectWithXpath("//div[contains(@class,'job-status__step')]"), 180);	
			TestObject object = getTestObjectWithXpath("//div[contains(@class,'job-status__step')]");
			return	object;
			 
	}
	
	public static void seleccionaPeriodoAplicacion(String periodoNuevo) {
		
		 
		WebUiBuiltInKeywords.waitForElementClickable(getTestObjectWithXpath("//a/span[contains(@class,'hidden-sm hidden-xs')]"), 20);	
		WebUiBuiltInKeywords.click(getTestObjectWithXpath("//a/span[contains(@class,'hidden-sm hidden-xs')]"));	
		WebUiBuiltInKeywords.waitForElementVisible(getTestObjectWithXpath("//a[text()='" +  periodoNuevo + "']"), 20);	
	    WebUiBuiltInKeywords.click(getTestObjectWithXpath("//a[text()='" +  periodoNuevo + "']"));
	    WebUiBuiltInKeywords.waitForElementVisible(getTestObjectWithXpath("//a/span[text()='" +  periodoNuevo + "']"),5);

	}
	

	public static String obtienePeridoAbiertoActual() {
		
		
		WebUiBuiltInKeywords.waitForElementVisible(getTestObjectWithXpath("//a/span[contains(@class,'hidden-sm hidden-xs')]"), 20);			
		String periodo = WebUiBuiltInKeywords.getText(HelperTestObject.getTestObjectWithXpath("//a/span[contains(@class,'hidden-sm hidden-xs')]")) ;
		return periodo;
		
		
	}
	
	public static void questionBuk(String accion) {
		
		WebUiBuiltInKeywords.waitForElementVisible(getTestObjectWithXpath("//button[text()='" +  accion + "']"), 60);			
		WebUiBuiltInKeywords.click(getTestObjectWithXpath("//button[text()='" +  accion + "']"));		
		WebUiBuiltInKeywords.waitForElementNotPresent(getTestObjectWithXpath("//button[text()='" +  accion + "']"), 60);		
	}
	
	
	public static WebElement retornaSeccion(String xpath) throws Exception{		
		
		return getWebElement(xpath);
		
	}
	
	/**
	 * Click Pestaña Documento de pago para todos los paises 
	 */
	public static void clickDocumentoPago(){
		WebUiBuiltInKeywords.takeScreenshot();
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[@href='#liquidaciones']"), 15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[@href='#liquidaciones']"));
	}	
	
	
	
	/**
	 * Cierra el documento de pago para todos los paises
	 */
	public static void cerrarDocumentoPago() {
		
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//span[@class='material-icons'][contains(.,'close')]"));
		
	}
	
//	public static void cerrarSesion() {
//
//		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//i[@class='fa fa-caret-down']"), 15);
//		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//i[@class='fa fa-caret-down']"));
//		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[@href='/users/sign_out'][contains(.,'Sign Out')]"), 15);
//		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[@href='/users/sign_out'][contains(.,'Sign Out')]]"));
//	}
	
}

