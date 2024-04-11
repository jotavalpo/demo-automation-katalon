import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.assertArrayEquals

import org.junit.Before

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.saucelabs.businesslogic.BLLogin
import com.saucelabs.businesslogic.BLNavegacion
import com.saucelabs.helper.HelperFile
import com.saucelabs.helper.HelperTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable
import io.cucumber.datatable.DataTable
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import  java.util.List;
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW


class NewTestListener {
	
	@BeforeTestCase
	def sampleBeforeTestCase(TestCaseContext testCaseContext) {		
		
		BLNavegacion.irAURL();	
		System.out.println(testCaseContext.getTestCaseVariables());
		Map map = testCaseContext.getTestCaseVariables();
		String user = "";
		String pass = "";
		if (map != null ) { 
			 user = map.get("user");
			 pass = map.get("pass");
		}  
		else {
			user = GlobalVariable.UserAdmin.toString();
			pass = GlobalVariable.PassAdmin.toString();
		}
		

	    BLLogin.logInAplicativo(user,pass);
		//HelperTestObject.cierraPopUpsMesesAbiertos();
		//HelperTestObject.determinaNotificacionNuevaFuncionalidadPresente();
		//HelperTestObject.determinaNotificacionConProgressBarPresente();
		System.out.println("Ruta: " + HelperFile.getRutaDownloads(HelperFile.getRutaLocal()).toString());
		if (HelperFile.getRutaDownloads(HelperFile.getRutaLocal()).toString().equals("/home/ubuntu/Downloads") && GlobalVariable.Pais.toString().equals("SauceDemo") ) {
			System.out.println("Limpiamos directorio de descarga en agente linux");
			HelperFile.clearDirectory(HelperFile.getRutaDownloads(HelperFile.getRutaLocal()));
			
		}
		
		CucumberKW.GLUE = ['com.saucelabs.stepdefinition']
		
	}
	
	@AfterTestCase
	def sampleAfterTestCase(TestCaseContext testCaseContext) {		
		
		//HelperTestObject.determinaNotificacionConProgressBarPresente();
		BLLogin.logOut();
		WebUI.closeBrowser();
		
	}
	
	
}