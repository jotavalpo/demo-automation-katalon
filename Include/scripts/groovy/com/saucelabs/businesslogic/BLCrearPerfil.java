package com.saucelabs.businesslogic;
import internal.GlobalVariable;

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint;
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase;
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData;
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject;
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject;

import java.util.Random;

import com.kms.katalon.core.annotation.Keyword;
import com.kms.katalon.core.checkpoint.Checkpoint;
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords;
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords;
import com.kms.katalon.core.model.FailureHandling;
import com.kms.katalon.core.testcase.TestCase;
import com.kms.katalon.core.testdata.TestData;
import com.kms.katalon.core.testobject.TestObject;
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords;
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords;
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords;
import com.saucelabs.helper.HelperTestObject;

import cucumber.api.java.en.When;

public class BLCrearPerfil {
	public static void seleccionar_el_boton_administracion() {
		System.out.println("Seleccionando Administración...");
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("(//span[@class=' material-icons  notranslate '][contains(.,'settings')])[1]"), 15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(//span[@class=' material-icons  notranslate '][contains(.,'settings')])[1]"));
		
		System.out.println("Seleccionando Usuarios y perfiles...");
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//div[contains(@data-overflow-tooltip,'Usuarios y Perfiles')]"), 15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//div[contains(@data-overflow-tooltip,'Usuarios y Perfiles')]"));
	}
	
	public static void crear_perfil(String nombrePerfil) {
		System.out.println("Seleccionando Perfiles...");
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[contains(.,\"Perfiles\")]"), 15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[contains(.,\"Perfiles\")]"));
		
		System.out.println("Seleccionando Crear Perfil...");
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//span[contains(.,\"Crear perfil\")]"), 15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//span[contains(.,\"Crear perfil\")]"));

		System.out.println("Asignando nombre del perfil...");
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//input[@type='submit']"), 15);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='permission_role_name']"), nombrePerfil);
		System.out.println("Nombre asignado: " + nombrePerfil);
	}
	
	public static void asignamosPermisos(String permiso, String nivelDePermiso) {
		//J.O: Ingreso el permiso y el nivel de Permiso
		int nivel = 0; 
		switch (nivelDePermiso) {
		  case "No": nivel = 0; break; 
			
		  case "Lectura": nivel = 1; break;
			
		  case "Lectura Sensible": nivel = 2; break;
			
		  case "Modificación":
			  if (permiso.equals("vacation_approval") || permiso.equals("bloqueo_persona") || permiso.equals("processes")) {
			  		nivel = 1;
			  		break;
			  		} 
			  else if(permiso.equals("empleados") || permiso.equals("jobs") || permiso.equals("asistencia") || permiso.equals("vacation") || permiso.equals("suspension")) { 
					nivel = 3;
					break;
					}
			  else {
					nivel = 2;
		  			break;
			  		}
		  
		  case "Solicitar": nivel = 2; break;
				  
		  case "Asignación": nivel = 3; break;
			  
		  case "Si": nivel = 1; break;
			
		  default: nivel = 0;
		}
			//Modificación Flaky Test: Print y wait para esperar la busqueda del elemento
			System.out.println("Seleccionando permiso: " + permiso + " y nivel: " + nivel);
			WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//input[@id='permission_role_" + permiso + "_" + nivel + "']"), 15);
			WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[@id='permission_role_" + permiso + "_" + nivel + "']"));
	}
	
	public static void seleccionarSeccion(String seccion) {
		System.out.println("Cambiando sección...");
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[@href='#" + seccion + "-panel']"), 15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[@href='#" + seccion + "-panel']"));
		
	}

	public static void guardar_el_perfil() {
		System.out.println("Guardando perfil...");
		String btmGuardar = "//input[contains(@type,'submit')]";
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath(btmGuardar), 15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath(btmGuardar));
	}
	
	public static void se_creo_correctamente_el_perfil(String nombrePerfil) {
		System.out.println("Validando mensaje de creación...");
		WebUiBuiltInKeywords.waitForElementVisible(HelperTestObject.getTestObjectWithXpath("//div[@class='alert alert-success alert-dismissible']"), 20);
		WebUiBuiltInKeywords.verifyTextPresent("Perfil de Usuario creado exitosamente.", false);
		
		System.out.println("Buscando perfil...");
		WebUiBuiltInKeywords.waitForElementVisible(HelperTestObject.getTestObjectWithXpath("//td[contains(.,'"+nombrePerfil+"')]"), 20);
		WebUiBuiltInKeywords.verifyTextPresent(nombrePerfil, false);
		
		System.out.println("Eliminando perfil...");
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("(//i[contains(@class,' fas fa-trash icon')])[82]"), 15);
		WebUiBuiltInKeywords.doubleClick(HelperTestObject.getTestObjectWithXpath("(//i[contains(@class,' fas fa-trash icon')])[82]"));
		
		System.out.println("Confirmando eliminación del perfil...");
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//button[@type='button'][contains(.,'Sí')]"), 15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//button[@type='button'][contains(.,'Sí')]"));
		
		System.out.println("Validando mensaje de eliminación...");
		WebUiBuiltInKeywords.waitForElementVisible(HelperTestObject.getTestObjectWithXpath("//div[@class='alert alert-success alert-dismissible']"), 20);
		WebUiBuiltInKeywords.verifyTextPresent("Perfil de Usuario eliminado exitosamente.", false);
	}
}