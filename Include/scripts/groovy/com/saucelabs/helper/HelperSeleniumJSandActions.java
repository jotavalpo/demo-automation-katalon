package com.saucelabs.helper;

import com.kms.katalon.core.testobject.TestObject;
import com.kms.katalon.core.util.KeywordUtil;
import com.kms.katalon.core.webui.common.WebUiCommonHelper;
import com.kms.katalon.core.webui.driver.DriverFactory;

import com.saucelabs.model.*;
import java.util.List;
import java.util.Arrays;
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperSeleniumJSandActions {
	
	
	/**
	 * Descripción: permite seleccionar campos para exportador pasados en una lista 
	 * @param beans
	 * @throws Exception
	 */
	public static void dragAndDropHelp(List<DragAndDrop> beans) throws Exception{
		for (int i = 0; i < beans.size(); i++) {
			JSscript(beans.get(i).getSelector().toString(), beans.get(i).getIdSelector().toString(),
					beans.get(i).getParametro().toString());
		}
	}

	public static boolean JSscript(String selector, String id, String parametro) {
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath(parametro), 90);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath(parametro));
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath(parametro), 90);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath(parametro));
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithCSS(selector), 90);
		JavascriptExecutor JavascriptExecutor = JSExecutor();
		JavascriptExecutor.executeScript(
				"document.querySelector(\"#new_report_custom_report_template > div.layout-report.well > ul\").appendChild(document.querySelector('"
				+ selector + "').cloneNode(true))");
		JavascriptExecutor.executeScript("var parent,child");
		JavascriptExecutor.executeScript(
				"parent = document.querySelector('#new_report_custom_report_template > div.layout-report.well > ul > li:nth-child("
				+ id + ")')");
		JavascriptExecutor.executeScript("child =  parent.querySelectorAll(':scope input')");
		JavascriptExecutor.executeScript("child[2].setAttribute('value'," + id + ")");
		return true;
	}

	public static JavascriptExecutor JSExecutor() {
		WebDriver driver = DriverFactory.getWebDriver();
		JavascriptExecutor JavascriptExecutor = ((JavascriptExecutor) driver);
		return JavascriptExecutor;
	}

	
	
	/**
	 * Description: damos click mediante JS a un testobject dado como parámetro  
	 * @param testObject 
	 */
	public static void executeJSClick(TestObject testObject) {
		
		try {
			
			WebElement element = WebUiCommonHelper.findWebElement(testObject,20);
			WebUiBuiltInKeywords.executeJavaScript("arguments[0].click()", Arrays.asList(element));
			
		}
		catch(Exception e) {
			WebUiBuiltInKeywords.waitForPageLoad(20);
			WebUiBuiltInKeywords.takeScreenshot();
			KeywordUtil.logInfo(e.getMessage());
			System.out.println("excepcion recibida: " + e.getMessage());
			WebUiBuiltInKeywords.refresh();
			assert false;
		}
		
	}
}