package com.saucelabs.stepdefinition
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.saucelabs.businesslogic.BLCrearPerfil
import com.saucelabs.helper.HelperTestObject

import internal.GlobalVariable
import io.cucumber.datatable.DataTable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class CrearPerfil{
	@Given("seleccionar el boton Administracion")
	def seleccionar_el_boton_administracion() {
		WebUI.waitForPageLoad(20)
		WebUI.takeScreenshot()
		BLCrearPerfil.seleccionar_el_boton_administracion()
		WebUI.waitForPageLoad(20)
		WebUI.takeScreenshot()
	}

	@When("crear perfil {string}")
	def crear_perfil(String nombrePerfil) {
		WebUI.waitForPageLoad(20)
		WebUI.takeScreenshot()
		BLCrearPerfil.crear_perfil(nombrePerfil)
		WebUI.waitForPageLoad(20)
		WebUI.takeScreenshot()
	}

	@When("asignamos los permisos para {string}:")
	public void gestion_de_empleados_con_permiso_y_nivel_de_permiso(String seccion, DataTable dataTable) {
		WebUI.takeScreenshot();
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (row in data) {

			//Seteamos el elemento correcto
			String permiso = row.Permiso;
			String nivelDePermiso = row.Nivel_Permiso;

			//Si permiso es historial, aparece una ventana con una advertencia de permisos
			if (permiso.equals("historial")) {
				WebUI.takeScreenshot();
				BLCrearPerfil.asignamosPermisos(permiso, nivelDePermiso);
				//WebUI.waitForElementClickable(HelperTestObject.getTestObjectWithXpath('//button[@type="button"][contains(.,"OK")]'), 5);
				//WebUI.click(HelperTestObject.getTestObjectWithXpath('//button[@type="button"][contains(.,"OK")]'));
			}
			else {
				WebUI.takeScreenshot();
				BLCrearPerfil.asignamosPermisos(permiso, nivelDePermiso)
			}
		}

	}

	@When("seleccionamos {string}")
	def selecSeccion(String seccion) {
		WebUI.takeScreenshot();
		BLCrearPerfil.seleccionarSeccion(seccion);
	}

	@When("asignamos los permisos:")
	public void asignar_permiso_y_nivel_de_permiso(DataTable dataTableT) {

		List<Map<String, String>> dataT = dataTableT.asMaps(String.class, String.class);
		for (row in dataT) {

			//Seteamos el elemento correcto
			String permiso = row.Permiso;
			String nivelDePermiso = row.Nivel_Permiso;

			BLCrearPerfil.asignamosPermisos(permiso, nivelDePermiso)
		}
	}

	@Then("se creo correctamente el perfil {string}")
	def se_creo_correctamente_el_perfil(String nombrePerfil) {
		WebUI.waitForPageLoad(20)
		WebUI.takeScreenshot()
		BLCrearPerfil.guardar_el_perfil()
		WebUI.waitForPageLoad(20)
		WebUI.takeScreenshot()
		BLCrearPerfil.se_creo_correctamente_el_perfil(nombrePerfil)
		WebUI.waitForPageLoad(20)
		WebUI.takeScreenshot()
	}
}