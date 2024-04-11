package com.saucelabs.stepdefinition

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.saucelabs.businesslogic.BLLogin
import com.saucelabs.businesslogic.BLNavegacion
import com.saucelabs.helper.HelperTestObject

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import io.cucumber.datatable.DataTable



class Login {

	//  Ejemplo login pasando la url, user y password

	//	@Given("el usuario realiza login con usuario administrador en url {string}")
	//	public void el_usuario_realiza_login_con_usuario_administrador_en_url (String url) {
	//		// Write code here that turns the phrase above into concrete actions
	//
	//		HelperTestObject.setUrl(url);
	//		WebUI.openBrowser(url);
	//		WebUI.maximizeWindow();
	//		WebUI.navigateToUrl(url + '/users/sign_in');
	//	}

	//	Ejemplo login usuario usando datatable

	//	@Given("el usuario ingresa credenciales validas")
	//	public void el_usuario_ingresa_credenciales_validas (DataTable dataTable) {
	//
	//		List<Map<String, String>> credential = dataTable.asMaps(String.class, String.class);
	//		WebUI.setText(HelperTestObject.getTestObjectWithXpath('//input[@id="user_email"]'), credential[0].user);
	//		WebUI.click(HelperTestObject.getTestObjectWithXpath('//input[@value="Siguiente"]'));
	//
	//		WebUI.setText(HelperTestObject.getTestObjectWithXpath('//input[@id="identifierId"]'), credential[0].user);
	//		WebUI.click(HelperTestObject.getTestObjectWithXpath('//span[text()="Siguiente"]'));
	//
	//		WebUI.setEncryptedText(HelperTestObject.getTestObjectWithXpath('//input[@type="password"]'),credential[0].pass);
	//		WebUI.click(HelperTestObject.getTestObjectWithXpath('//button[@type="button"]//span[text()="Siguiente"]'));
	//
	//	}

	// Validación de mensaje emergente

	//	@When("la cantidad de meses abiertos es {string} a 1")
	//	public void la_cantidad_de_meses_abiertos_es(String cantidad) {
	//
	//		if (cantidad.equals("mayor")) {
	//
	//			WebUI.waitForElementClickable(HelperTestObject.getTestObjectWithXpath('//button[text()="OK"]'), 5)
	//			WebUI.click(HelperTestObject.getTestObjectWithXpath('//button[text()="OK"]'))
	//		}
	//	}


	//Login usando navegacion en url e ingresando datos de manera manual

	@Given("el usuario inicia la sesion con su correo {string} y contrasena {string}")
	public void el_usuario_inicia_la_sesion_con_su_correo_y_contrasena(String username, String password){
		//print(username);
		BLNavegacion.irAURL();
		BLLogin.logInAplicativo(username,password);
	}

	//Validacion de login exitoso

	@When("el usuario ingresa al aplicativo de forma correcta {string}")
	public void el_usuario_ingresa_al_aplicativo_de_forma_correcta(String name) {
		BLLogin.verifcarTexto(name);
	}

	//Cierre de sesión
	@Then("el usuario cierra la sesion")
	public void el_usuario_cierra_la_sesion( ) {

		BLLogin.logOut();
	}
}