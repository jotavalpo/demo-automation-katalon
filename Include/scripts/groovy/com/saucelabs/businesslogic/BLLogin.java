package com.saucelabs.businesslogic;

import internal.GlobalVariable;

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords;
import com.saucelabs.helper.HelperTestObject;

import com.saucelabs.helper.*;

public class BLLogin {

	public static void logInAplicativo() {

		logInLogic(GlobalVariable.UserAdmin.toString(), GlobalVariable.PassAdmin.toString());
	}

	public static void logInAplicativo(String mail, String password) {

		logInLogic(mail, password);

	}

	public static void logInLogic(String mail, String password) {
		System.out.println("Login....");

		if (mail.contains("@buk"))
			logInBuk(mail, password);
		else
			logInAllMail(mail, password);

	}

	public static void logInBuk(String mail, String password) {
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='user-name']"), mail);
		//WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[@value='Siguiente']"));
		//WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='identifierId']"), mail);
		//WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//span[text()='Siguiente']"));
		WebUiBuiltInKeywords.setEncryptedText(HelperTestObject.getTestObjectWithXpath("//input[@id='password']"),password);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[@value='Login']"));

	}

	public static void logInAllMail(String mail, String password) {
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='user-name']"),	mail);
		//WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//input[@value='Siguiente']"),40);
		//WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[@value='Siguiente']"));
		WebUiBuiltInKeywords.setEncryptedText(HelperTestObject.getTestObjectWithXpath("//input[@id='password']"), password);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[@value='Login']"));

	}

	/**
	 * FHN1 Cierre de sesion
	 */
	public static void verifcarTexto(String name) {

		try {
			assert 	WebUiBuiltInKeywords.verifyElementPresent(HelperTestObject.getTestObjectWithXpath("//div[text()='+name+']"), 15);

		} catch (Exception e) {
			System.out.println("No se pudo encontrar el texto");
		}

	}
	
	public static void logOut() {

		try {
			WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//button[@id='react-burger-menu-btn']"), 15);
			WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//button[@id='react-burger-menu-btn']"));
			WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[contains(.,'Logout')]"), 15);
			WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[contains(.,'Logout')]"));

		} catch (Exception e) {
			System.out.println("No se pudo cerrar la sesión");
		}

	}
	
}