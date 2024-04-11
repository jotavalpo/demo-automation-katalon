package com.saucelabs.businesslogic;

import internal.GlobalVariable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.kms.katalon.core.testobject.TestObject;
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords;
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword;
import com.saucelabs.helper.HelperTestObject;

import com.saucelabs.helper.*;

public class BLNavegacion {
	WebDriver driver;

	public static void irAURL() {

		System.out.println("Abriendo navegador....");
		WebUiBuiltInKeywords.openBrowser(GlobalVariable.Url.toString());
		System.out.println("Navegando Url");
		WebUiBuiltInKeywords.navigateToUrl(GlobalVariable.Url.toString());
		System.out.println("Navegando Url: " + GlobalVariable.Url.toString());

		System.out.println("Maximizando....");
		WebUiBuiltInKeywords.setViewPortSize(1366, 768);
		//WebUiBuiltInKeywords.maximizeWindow();

	}

	public static void clickMenu(String menu) {
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//span[contains(text(), '" + menu + "')]"));
	}

	
	/**
	 * Navega en el nuevo menú
	 * @param modulo es la seccion que esta mas a la izquierda, la que tiene solamente el icono, el texto que se pasa al parametro es el texto del tooltip
	 * @param menu es la opcion principal que se seleccionara del menu
	 * @param opcion es un parametro opcional, que se usa cuando es una opcion anidada dentro de un elemento del menu
	 * 
	 **/
	public static void clickOpcionNuevoMenu(String modulo, String menu, String... opcion) {
		TestObject moduloMenu = HelperTestObject.getTestObjectWithXpath("//a[@data-title='" + modulo + "']");
		WebUiBuiltInKeywords.click(moduloMenu);
		TestObject itemMenu = HelperTestObject.getTestObjectWithXpath("//span[contains(text(), '" + menu + "')]");
		WebUiBuiltInKeywords.click(itemMenu);
		if (opcion.length > 0) {
			TestObject itemOpcion = HelperTestObject.getTestObjectWithXpath("//span[contains(text(), '" + opcion[0] + "')]");
			WebUiBuiltInKeywords.click(itemOpcion);
		}

	}

	public static void clickOpcionMenu(String menu, String opcion) {
		if (WebUiBuiltInKeywords.waitForElementVisible(HelperTestObject
				.getTestObjectWithXpath("//span[contains(text(), '" + menu + "')]//following::span[contains(text(),'"
						+ opcion + "') and @class ='text-truncate sidebar_text']"),
				10)) {
			WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath(
					"//span[contains(text(), '" + menu + "')]//following::span[contains(text(),'" + opcion
							+ "') and @class ='text-truncate sidebar_text']"));
		} else {
			clickMenu(menu);
			WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath(
					"//span[contains(text(), '" + menu + "')]//following::span[contains(text(),'" + opcion
							+ "') and @class ='text-truncate sidebar_text']"));
		}
	}

	public static void clickOpcionSubMenu(String menu, String subMenu, String opcion) {
		clickOpcionMenu(menu, subMenu);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//span[contains(text(), '" + menu
				+ "']//following::span[contains(text(),'" + subMenu + "')]//following::span[contains(text(),'" + opcion
				+ "') and @class ='text-truncate sidebar_text']"));
	}
	public static void menuAdministracion(String seccion) {
		WebUiBuiltInKeywords.takeScreenshot();
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject
				.getTestObjectWithXpath("//span[@class=' material-icons  notranslate '][contains(.,'settings')]"), 15);
		WebUiBuiltInKeywords.click(HelperTestObject
				.getTestObjectWithXpath("//span[@class=' material-icons  notranslate '][contains(.,'settings')]"));
		WebUiBuiltInKeywords.takeScreenshot();
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//div[@data-title='" + seccion + "']"), 40);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//div[@data-title='" + seccion +"']"));
	}	

}
