package com.saucelabs.helper;
import internal.GlobalVariable;

import com.kms.katalon.core.testobject.TestObject;
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords;

public class HelperActiveAdmin {
	
	
	private static void GoToActiveAdmin () {
		
		WebUiBuiltInKeywords.navigateToUrl(GlobalVariable.Url.toString() + "active_admin");

	}
	
	
	public static void NavegarHacia(String menu, String opcion) {
		
		
		GoToActiveAdmin();
		WebUiBuiltInKeywords.waitForPageLoad(10);
		TestObject itemMenu = HelperTestObject.getTestObjectWithXpath("//a[text()='"+menu+"']");
		WebUiBuiltInKeywords.click(itemMenu);
		TestObject itemOpcion = HelperTestObject.getTestObjectWithXpath("//a[text()='"+ opcion +"']");
		WebUiBuiltInKeywords.click(itemOpcion);
	
		
	} 
	
	public static void EliminarTimbrados() {
		
		TestObject checkBoxSelectAll = HelperTestObject.getTestObjectWithXpath("//input[@id='collection_selection_toggle_all']");
		WebUiBuiltInKeywords.click(checkBoxSelectAll);
		TestObject selectActions = HelperTestObject.getTestObjectWithXpath("//a[text()='Acciones en masa']");
		WebUiBuiltInKeywords.click(selectActions);
		TestObject actionDelete = HelperTestObject.getTestObjectWithXpath("//a[text()='Borrar seleccionados']");
		WebUiBuiltInKeywords.click(actionDelete);
		TestObject confirmModal = HelperTestObject.getTestObjectWithXpath("//button[text()='OK']");
		WebUiBuiltInKeywords.click(confirmModal);

		

		

		

		
	}
	
	
	
	
	

}