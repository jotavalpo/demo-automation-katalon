package com.saucelabs.businesslogic;

import com.saucelabs.helper.*;
import org.openqa.selenium.Keys;

import com.kms.katalon.core.model.FailureHandling;
import com.kms.katalon.core.testobject.TestObject;
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords;
import com.saucelabs.helper.HelperTestObject;

public class BLVacaciones {

	public static void seleccionarTipoVacacionesAEditar(String Tipo_Vacaciones) {

		//Esto deberia encontrar el icono editar de cualquier vacacion, no solo las que estan listadas

		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//td[contains(text(), '" + Tipo_Vacaciones + "')]/../td/div/a[@data-modal-title='Editar Tipos de Vacaciones']"),20);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//td[contains(text(), '" + Tipo_Vacaciones + "')]/../td/div/a[@data-modal-title='Editar Tipos de Vacaciones']"));

	}
	public static void seleccionarTipoVacacionesAVer(String Tipo_Vacaciones) {
		//Esto deberia encontrar el icono editar de cualquier vacacion, no solo las que estan listadas

		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("(//td[contains(text(), '" + Tipo_Vacaciones + "')]/..//i)[1]"),20);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(//td[contains(text(), '" + Tipo_Vacaciones + "')]/..//i)[1]"));

		//				if (Tipo_Vacaciones.compareTo("Legales") == 0) {
		//					WebUiBuiltInKeywords.click(
		//							HelperTestObject.getTestObjectWithXpath("(//i[contains(@class,' fas fa-pencil-alt icon')])[2]"));
		//
		//				} else if (Tipo_Vacaciones.compareTo("Días Adicionales") == 0) {
		//					WebUiBuiltInKeywords.click(
		//							HelperTestObject.getTestObjectWithXpath("(//i[contains(@class,' fas fa-pencil-alt icon)'])[1]"));
		//
		//				} else if (Tipo_Vacaciones.compareTo("Progresivas") == 0) {
		//					WebUiBuiltInKeywords.click(
		//							HelperTestObject.getTestObjectWithXpath("(//i[contains(@class,' fas fa-pencil-alt icon')])[3]"));
		//
		//				}
	}

	public static void seleccionarTipoVacacionesAEliminar(String Tipo_Vacaciones) {
		// Esto deberia encontrar el icono editar de cualquier vacacion, no solo las que
		// estan listadas

		TestObject iconDelete = HelperTestObject
				.getTestObjectWithXpath("(//td[contains(text(), '" + Tipo_Vacaciones + "')]/..//i)[3]");


		WebUiBuiltInKeywords.waitForElementVisible(iconDelete, 2,FailureHandling.CONTINUE_ON_FAILURE);
		WebUiBuiltInKeywords.scrollToElement(iconDelete, 2, FailureHandling.CONTINUE_ON_FAILURE);
		WebUiBuiltInKeywords.click(iconDelete);

	}

	public static void seleccionarPoliticaVacacionesAEliminar(String Politica_Vacaciones) {
		// Esto deberia encontrar el icono editar de cualquier vacacion, no solo las que
		// estan listadas

		WebUiBuiltInKeywords.click(
				HelperTestObject.getTestObjectWithXpath("//div[@data-overflow-tooltip='" + Politica_Vacaciones + "']"));

		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath(
				"//h3[text()='" + Politica_Vacaciones + "']/..//a[@data-confirm-swal-accept='Eliminar']"));

	}

	public static void seleccionarMetodoAprobacionTipoVacaciones(String Metodo_Aprobacion, String Descripcion,
			String Dias_Sobregiro) {
		if (Metodo_Aprobacion.compareTo("Recursos Humanos") == 0) {
			WebUiBuiltInKeywords.selectOptionByIndex(
					HelperTestObject.getTestObjectWithXpath("//*[@id='vacation_type_approval_method']"), 0);
			WebUiBuiltInKeywords.verifyOptionSelectedByIndex(
					HelperTestObject.getTestObjectWithXpath("//*[@id='vacation_type_approval_method']"), 0, 60);

		} else if (Metodo_Aprobacion.compareTo("Supervisor") == 0) {
			WebUiBuiltInKeywords.selectOptionByIndex(
					HelperTestObject.getTestObjectWithXpath("//*[@id='vacation_type_approval_method']"), 1);
			WebUiBuiltInKeywords.verifyOptionSelectedByIndex(
					HelperTestObject.getTestObjectWithXpath("//*[@id='vacation_type_approval_method']"), 1, 60);

		} else if (Metodo_Aprobacion.compareTo("Supervisor y Recursos Humanos") == 0) {
			WebUiBuiltInKeywords.selectOptionByIndex(
					HelperTestObject.getTestObjectWithXpath("//*[@id='vacation_type_approval_method']"), 2);
			WebUiBuiltInKeywords.verifyOptionSelectedByIndex(
					HelperTestObject.getTestObjectWithXpath("//*[@id='vacation_type_approval_method']"), 2, 60);
		}

		WebUiBuiltInKeywords.setText(
				HelperTestObject.getTestObjectWithXpath("//textarea[@id='vacation_type_description']"), Descripcion);
		WebUiBuiltInKeywords.setText(
				HelperTestObject.getTestObjectWithXpath("//input[@id='vacation_type_dias_sobregiro']"), Dias_Sobregiro);
		WebUiBuiltInKeywords.takeScreenshot();
	}

	public static void eliminarTipoVacacionCreada() {

		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(//i[@class=' fas fa-trash icon'])[4]"));
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//button[contains(.,'Eliminar')]"));

		WebUiBuiltInKeywords.takeScreenshot();
		assert WebUiBuiltInKeywords.verifyTextPresent("Tipo de Vacación eliminado(a)", false);
	}

	public static void seleccionarTipoVacacionesParaPolitica(String Tipo_Vacaciones) {
		if (Tipo_Vacaciones.compareTo("Legales") == 0) {
			WebUiBuiltInKeywords
			.click(HelperTestObject.getTestObjectWithXpath("(//i[@class=' fas fa-search-plus '])[2]"));

		} else if (Tipo_Vacaciones.compareTo("Días Adicionales") == 0) {
			WebUiBuiltInKeywords
			.click(HelperTestObject.getTestObjectWithXpath("(//i[@class=' fas fa-search-plus '])[1]"));

		} else if (Tipo_Vacaciones.compareTo("Progresivas") == 0) {
			WebUiBuiltInKeywords
			.click(HelperTestObject.getTestObjectWithXpath("(//i[@class=' fas fa-search-plus '])[3]"));

		}
	}

	public static void completarDatosCrearPolitica(String Nombre_Politica, String Descripcion_Politica,
			String Años_Antiguedad, String Dias_Vacaciones) {

		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='vacation_definition_name']"),
				Nombre_Politica);
		WebUiBuiltInKeywords.setText(
				HelperTestObject.getTestObjectWithXpath("//textarea[@id='vacation_definition_description']"),
				Descripcion_Politica);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//i[@class=' fas fa-plus ']"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[contains(@id,'age')]"),
				Años_Antiguedad);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[contains(@id,'days')]"),
				Dias_Vacaciones);
		WebUiBuiltInKeywords.takeScreenshot();
	}

	public static void eliminarPoliticaVacacionCreada() {
		WebUiBuiltInKeywords.waitForElementClickable(	HelperTestObject.getTestObjectWithXpath("//div[@class='title '][contains(.,'prueba política')]"),20);
		WebUiBuiltInKeywords.click(	HelperTestObject.getTestObjectWithXpath("//div[@class='title '][contains(.,'prueba política')]"));
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(//span[text()='Eliminar'])[2]"));
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//button[contains(.,'Eliminar')]"));
		WebUiBuiltInKeywords.takeScreenshot();
		WebUiBuiltInKeywords.waitForElementVisible(HelperTestObject.getTestObjectWithXpath("//div[contains(@class,'alert alert-success')]"), 40);
		assert WebUiBuiltInKeywords.verifyTextPresent("Política eliminado(a)", false);
	}

	public static void completarDatosEditarPolitica(String Nombre_Politica, String Descripcion_Politica,
			String Años_Antiguedad, String Dias_Vacaciones) {

		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//input[@id='vacation_definition_name']"),40);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='vacation_definition_name']"),Nombre_Politica);

		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//textarea[@id='vacation_definition_description']"),10);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//textarea[@id='vacation_definition_description']"),Descripcion_Politica);
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//input[contains(@id,'age')]"),10);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[contains(@id,'age')]"),Años_Antiguedad);
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//input[contains(@id,'days')]"),10);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[contains(@id,'days')]"),Dias_Vacaciones);
		WebUiBuiltInKeywords.takeScreenshot();
	}

	public static void agregarPoliticas(String Tipo_Vacacion_Uno, String Politica_Vacacion_Uno, String Tipo_Vacacion_Dos, String Politica_Vacacion_Dos,
			String Fecha_Inicio_Vigencia, String Fecha_Desasignacion) {
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(//b[@role='presentation'])[1]"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@type='search']"), Tipo_Vacacion_Uno);
		WebUiBuiltInKeywords.sendKeys(HelperTestObject.getTestObjectWithXpath("//input[@type='search']"),
				Keys.chord(Keys.ENTER));
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(//b[@role='presentation'])[2]"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@type='search']"), Politica_Vacacion_Uno);
		WebUiBuiltInKeywords.sendKeys(HelperTestObject.getTestObjectWithXpath("//input[@type='search']"),
				Keys.chord(Keys.ENTER));
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//label[text()='Fecha Inicio Vigencia ']/following::input"), 15);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//label[text()='Fecha Inicio Vigencia ']/following::input"), Fecha_Inicio_Vigencia);
				
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//i[@class=' fas fa-plus ']"));
		
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(//b[@role='presentation'])[3]"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@type='search']"), Tipo_Vacacion_Dos);
		WebUiBuiltInKeywords.sendKeys(HelperTestObject.getTestObjectWithXpath("//input[@type='search']"),
				Keys.chord(Keys.ENTER));
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(//b[@role='presentation'])[4]"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@type='search']"), Politica_Vacacion_Dos);
		WebUiBuiltInKeywords.sendKeys(HelperTestObject.getTestObjectWithXpath("//input[@type='search']"),
				Keys.chord(Keys.ENTER));
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("(//label[text()='Fecha Inicio Vigencia '])[2]/following::input"), 15);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("(//label[text()='Fecha Inicio Vigencia '])[2]/following::input"), Fecha_Inicio_Vigencia);
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("(//label[text()='Fecha de Desasignación '])[2]/following::input"), 15);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("(//label[text()='Fecha de Desasignación '])[2]/following::input"), Fecha_Desasignacion);
		
	}

	public static void modificarPoliticas(String Fecha_Inicio_Vigencia, String Fecha_Desasignacion) {
		WebUiBuiltInKeywords.waitForPageLoad(30);
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//label[text()='Fecha Inicio Vigencia ']/following::input"), 15);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//label[text()='Fecha Inicio Vigencia ']/following::input"), Fecha_Inicio_Vigencia);
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//label[text()='Fecha de Desasignación ']/following::input"), 15);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//label[text()='Fecha de Desasignación ']/following::input"), Fecha_Desasignacion);
		
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("(//label[text()='Fecha Inicio Vigencia '])[2]/following::input"), 15);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("(//label[text()='Fecha Inicio Vigencia '])[2]/following::input"), Fecha_Inicio_Vigencia);
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//*[@id=\"vacation_configs_vacation_config_definitions_attributes_1_definition_end_date\"]"), 15);
		WebUiBuiltInKeywords.clearText(HelperTestObject.getTestObjectWithXpath("//*[@id=\"vacation_configs_vacation_config_definitions_attributes_1_definition_end_date\"]"));
	}

	public static void hacerClicEnBotonGuardar() {
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//span[text()='Guardar']"),15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//span[text()='Guardar']"));
	}

	public static void verificarCambiosGuardados() {
		WebUiBuiltInKeywords.waitForPageLoad(30);
		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("//div[contains(@class,'alert alert-success')]"), 10);
		WebUiBuiltInKeywords.scrollToElement(HelperTestObject.getTestObjectWithXpath("//div[contains(@class,'alert alert-success')]"), 2);
	}

	public static void verificarAplicacionPolitica(String saldoLegales, String saldoProgresivas, String saldoDiasAdicionales) {
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//input[contains(@id,'simulate_date')]"),15);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[contains(@id,'simulate_date')]"));

		String mes = WebUiBuiltInKeywords.getText(HelperTestObject.getTestObjectWithXpath("(//table[@class='table-condensed']//th)[3]"));

		switch (mes) {
		case "Enero 2023":
			for (int i = 1; i < 10; i++) {
				WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//th[@class='next']"));
			}

			WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//td[@data-date='1696118400000']"), 15);
			WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//td[@data-date='1696118400000']"));
			break;

		case "Febrero 2023":
			for (int i = 1; i < 9; i++) {
				WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//th[@class='next']"));
			}

			WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//td[@data-date='1696118400000']"), 15);
			WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//td[@data-date='1696118400000']"));
			break;

		case "Marzo 2023":
			for (int i = 1; i < 8; i++) {
				WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//th[@class='next']"));
			}

			WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//td[@data-date='1696118400000']"), 15);
			WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//td[@data-date='1696118400000']"));
			break;

		case "Abril 2023":
			for (int i = 1; i < 7; i++) {
				WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//th[@class='next']"));
			}

			WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//td[@data-date='1696118400000']"), 15);
			WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//td[@data-date='1696118400000']"));
			break;

		case "Mayo 2023":
			for (int i = 1; i < 6; i++) {
				WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//th[@class='next']"));
			}

			WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//td[@data-date='1696118400000']"), 15);
			WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//td[@data-date='1696118400000']"));
			break;

		case "Junio 2023":
			for (int i = 1; i < 5; i++) {
				WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//th[@class='next']"));
			}

			WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//td[@data-date='1696118400000']"), 15);
			WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//td[@data-date='1696118400000']"));
			break;

		case "Julio 2023":
			for (int i = 1; i < 4; i++) {
				WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//th[@class='next']"));
			}

			WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//td[@data-date='1696118400000']"), 15);
			WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//td[@data-date='1696118400000']"));
			break;

		case "Agosto 2023":
			for (int i = 1; i < 3; i++) {
				WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//th[@class='next']"));
			}

			WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//td[@data-date='1696118400000']"), 15);
			WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//td[@data-date='1696118400000']"));
			break;

		case "Septiembre 2023":
			for (int i = 1; i < 2; i++) {
				WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//th[@class='next']"));
			}

			WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//td[@data-date='1696118400000']"), 15);
			WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//td[@data-date='1696118400000']"));
			break;

		case "Octubre 2023":
			WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//td[@data-date='1696118400000']"), 15);
			WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//td[@data-date='1696118400000']"));
			break;

		case "Noviembre 2023":
			for (int i = 1; i < 11; i++) {
				WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//th[@class='next']"));
			}

			WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//td[@data-date='1696118400000']"), 15);
			WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//td[@data-date='1696118400000']"));
			break;

		case "Diciembre 2023":
			for (int i = 1; i < 12; i++) {
				WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//th[@class='next']"));
			}

			WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//td[@data-date='1696118400000']"), 15);
			WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//td[@data-date='1696118400000']"));
			break;

		}

		WebUiBuiltInKeywords.waitForPageLoad(30);

		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("//th[@class='text-right'][contains(.,'Legales')]"), 30);
		String columna1Tabla = WebUiBuiltInKeywords.getText(HelperTestObject.getTestObjectWithXpath("//th[@class='text-right'][contains(.,'Legales')]"));

		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("(//td[contains(@class,'text-right')])[1]"), 30);
		String acumuladasTabla1 = WebUiBuiltInKeywords.getText(HelperTestObject.getTestObjectWithXpath("(//td[contains(@class,'text-right')])[1]"));

		switch (columna1Tabla) {
		case "Legales":
			if (acumuladasTabla1!=saldoLegales) {
				System.out.println("Política con "+acumuladasTabla1+" acumulados correctos");
			}else {
				System.out.println("Política con "+acumuladasTabla1+" acumulados incorrectos");
			}
			break;

		case "Progresivas":
			if (acumuladasTabla1!=saldoProgresivas) {
				System.out.println("Política con "+acumuladasTabla1+" acumulados correctos");
			}else {
				System.out.println("Política con "+acumuladasTabla1+" acumulados incorrectos");
			}
			break;

		case "Días adicionales":
			if (acumuladasTabla1!=saldoDiasAdicionales) {
				System.out.println("Política con "+acumuladasTabla1+" acumulados correctos");
			}else {
				System.out.println("Política con "+acumuladasTabla1+" acumulados incorrectos");
			}
			break;
		}

		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("//th[@class='text-right'][contains(.,'Progresivas')]"), 30);
		String columna2Tabla = WebUiBuiltInKeywords.getText(HelperTestObject.getTestObjectWithXpath("//th[@class='text-right'][contains(.,'Progresivas')]"));

		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("(//td[contains(@class,'text-right')])[2]"), 30);
		String acumuladasTabla2 = WebUiBuiltInKeywords.getText(HelperTestObject.getTestObjectWithXpath("(//td[contains(@class,'text-right')])[2]"));

		switch (columna2Tabla) {
		case "Legales":
			if (acumuladasTabla2!=saldoLegales) {
				System.out.println("Política con "+acumuladasTabla2+" acumulados correctos");
			}else {
				System.out.println("Política con "+acumuladasTabla2+" acumulados incorrectos");
			}
			break;

		case "Progresivas":
			if (acumuladasTabla2!=saldoProgresivas) {
				System.out.println("Política con "+acumuladasTabla2+" acumulados correctos");
			}else {
				System.out.println("Política con "+acumuladasTabla2+" acumulados incorrectos");
			}
			break;

		case "Días adicionales":
			if (acumuladasTabla2!=saldoDiasAdicionales) {
				System.out.println("Política con "+acumuladasTabla2+" acumulados correctos");
			}else {
				System.out.println("Política con "+acumuladasTabla2+" acumulados incorrectos");
			}
			break;
		}

		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("//th[@class='text-right'][contains(.,'Días adicionales')]"), 30);
	    String columna3Tabla = WebUiBuiltInKeywords.getText(HelperTestObject.getTestObjectWithXpath("//th[@class='text-right'][contains(.,'Días adicionales')]"));

		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("(//td[contains(@class,'text-right')])[3]"), 30);
		String acumuladasTabla3 = WebUiBuiltInKeywords.getText(HelperTestObject.getTestObjectWithXpath("(//td[contains(@class,'text-right')])[3]"));

		switch (columna3Tabla) {
		case "Legales":
			if (acumuladasTabla3!=saldoLegales) {
				System.out.println("Política con "+acumuladasTabla3+" acumulados correctos");
			}else {
				System.out.println("Política con "+acumuladasTabla3+" acumulados incorrectos");
			}
			break;

		case "Progresivas":
			if (acumuladasTabla3!=saldoProgresivas) {
				System.out.println("Política con "+acumuladasTabla3+" acumulados correctos");
			}else {
				System.out.println("Política con "+acumuladasTabla3+" acumulados incorrectos");
			}
			break;

		case "Días adicionales":
			if (acumuladasTabla3!=saldoDiasAdicionales) {
				System.out.println("Política con "+acumuladasTabla3+" acumulados correctos");
			}else {
				System.out.println("Política con "+acumuladasTabla3+" acumulados incorrectos");
			}
			break;
		}

	}

		public static void completarModalAgregarVacaciones(String Tipo_Vacaciones, String Fecha_Inicio,
				String Fecha_Termino, String Comentarios) {

			// seleccionar tipo de vacación en select de modal
			WebUiBuiltInKeywords.selectOptionByLabel(
					HelperTestObject.getTestObjectWithXpath("//select[@id='vacacion_vacation_type_id']"), Tipo_Vacaciones,
					true);

			// Completar de acuerdo al tipo de vacaciones seleccionado
			if (Tipo_Vacaciones.compareTo("Legales") == 0) {
				WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='vacacion_start_date']"),
						Fecha_Inicio);
				WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='vacacion_end_date']"),
						Fecha_Termino);
				WebUiBuiltInKeywords.setText(
						HelperTestObject.getTestObjectWithXpath("//textarea[@id='vacacion_comentario']"), Comentarios);
			} else if (Tipo_Vacaciones.compareTo("Días administrativos") == 0) {
				WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='vacacion_start_date']"),
						Fecha_Inicio);
				WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='vacacion_end_date']"),
						Fecha_Termino);
				WebUiBuiltInKeywords.setText(
						HelperTestObject.getTestObjectWithXpath("//textarea[@id='vacacion_comentario']"), Comentarios);
			}
		}

		public static void completarModalAgregarVacacionesCo(String Tipo_Vacaciones, String Fecha_Asignacion,
				String Numero_Dias) {

			WebUiBuiltInKeywords.selectOptionByLabel(
					HelperTestObject.getTestObjectWithXpath("//select[@id='vacacion_percibida_vacation_type_id']"),
					Tipo_Vacaciones, true);
			WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[contains(@id,'fecha')]"),
					Fecha_Asignacion);
			WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[contains(@id,'dias')]"),
					Numero_Dias);
		}

		public static void borrarRegistroVacacionCreado() {
			WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[contains(@data-title,'Eliminar')]"),45);
			WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[contains(@data-title,'Eliminar')]"));
			WebUiBuiltInKeywords.waitForElementVisible(HelperTestObject.getTestObjectWithXpath("//div[contains(@class,'alert alert-success')]"), 40);		
			WebUiBuiltInKeywords.verifyTextPresent("Vacaciones eliminadas", false);

		}

		public static void borrarRegistroVacacionCreadoCo() {
			WebUiBuiltInKeywords
			.click(HelperTestObject.getTestObjectWithXpath("(//i[contains(@class,' fas fa-trash icon')])[2]"));
			WebUiBuiltInKeywords.acceptAlert();
			WebUiBuiltInKeywords.takeScreenshot();
		}

		public static void completarModalAgregarSaldoVacaciones(String Tipo_Vacaciones, String Fecha_Asignacion,
				String Numero_Dias, String Fecha_Vencimiento) {
			// seleccionar tipo de vacación en select de modal
			WebUiBuiltInKeywords.selectOptionByLabel(
					HelperTestObject.getTestObjectWithXpath("//select[@id='vacacion_percibida_vacation_type_id']"),
					Tipo_Vacaciones, true);

			// Completar de acuerdo al tipo de vacaciones seleccionado
			if (Tipo_Vacaciones.compareTo("Legales") == 0) {
				WebUiBuiltInKeywords.setText(
						HelperTestObject.getTestObjectWithXpath("//input[@id='vacacion_percibida_fecha']"),
						Fecha_Asignacion);
				WebUiBuiltInKeywords
				.click(HelperTestObject.getTestObjectWithXpath("//label[@class='control-label decimal required']"));
				WebUiBuiltInKeywords.setText(
						HelperTestObject.getTestObjectWithXpath("//input[@id='vacacion_percibida_numero_dias']"),
						Numero_Dias);
			} else if (Tipo_Vacaciones.compareTo("Días administrativos") == 0) {
				WebUiBuiltInKeywords.setText(
						HelperTestObject.getTestObjectWithXpath("//input[@id='vacacion_percibida_fecha']"),
						Fecha_Asignacion);
				WebUiBuiltInKeywords
				.click(HelperTestObject.getTestObjectWithXpath("//label[@class='control-label decimal required']"));
				WebUiBuiltInKeywords.setText(
						HelperTestObject.getTestObjectWithXpath("//input[@id='vacacion_percibida_numero_dias']"),
						Numero_Dias);
				WebUiBuiltInKeywords.setText(
						HelperTestObject.getTestObjectWithXpath("//input[@id='vacacion_percibida_fecha_expiracion']"),
						Fecha_Vencimiento);
			}
		}

		public static void borrarSaldoVacacionCreado() {

			WebUiBuiltInKeywords.waitForPageLoad(30);
			WebUiBuiltInKeywords.takeScreenshot();
			WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[contains(@data-confirm,'¿Está seguro que quiere eliminar estas vacaciones?')]"),30);
			WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[contains(@data-confirm,'¿Está seguro que quiere eliminar estas vacaciones?')]"));
			WebUiBuiltInKeywords.waitForAlert(45);
			WebUiBuiltInKeywords.acceptAlert();
			WebUiBuiltInKeywords.takeScreenshot();
			WebUiBuiltInKeywords.scrollToElement(HelperTestObject.getTestObjectWithXpath("//a[@href='#vacaciones']"), 2);
		}


		// PERU
		public static void completarModalAgregarVacacionesPE(String Tipo_Vacaciones, String Fecha_Inicio,
				String Fecha_Termino, String Comentarios) {

			// seleccionar tipo de vacación en select de modal
			WebUiBuiltInKeywords.selectOptionByLabel(
					HelperTestObject.getTestObjectWithXpath("//select[@id='vacacion_vacation_type_id']"), Tipo_Vacaciones,
					true);

			// Completar de acuerdo al tipo de vacaciones seleccionado
			if (Tipo_Vacaciones.compareTo("Truncos") == 0) {
				WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='vacacion_start_date']"),
						Fecha_Inicio);
				WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='vacacion_end_date']"),
						Fecha_Termino);
				WebUiBuiltInKeywords.setText(
						HelperTestObject.getTestObjectWithXpath("//textarea[@id='vacacion_comentario']"), Comentarios);
			} else if (Tipo_Vacaciones.compareTo("Días administrativos") == 0) {
				WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='vacacion_start_date']"),
						Fecha_Inicio);
				WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='vacacion_end_date']"),
						Fecha_Termino);
				WebUiBuiltInKeywords.setText(
						HelperTestObject.getTestObjectWithXpath("//textarea[@id='vacacion_comentario']"), Comentarios);
			}
		}

		public static void completarModalAgregarSaldoVacacionesPE(String Tipo_Vacaciones, String Fecha_Asignacion,
				String Numero_Dias) {
			// seleccionar tipo de vacación en select de modal
			WebUiBuiltInKeywords.selectOptionByLabel(
					HelperTestObject.getTestObjectWithXpath("//select[@id='vacacion_percibida_vacation_type_id']"),
					Tipo_Vacaciones, true);

			// Completar de acuerdo al tipo de vacaciones seleccionado
			if (Tipo_Vacaciones.compareTo("Truncos") == 0) {
				WebUiBuiltInKeywords.setText(
						HelperTestObject.getTestObjectWithXpath("//input[contains(@name,'vacacion_percibida[fecha]')]"),
						Fecha_Asignacion);
				WebUiBuiltInKeywords
				.click(HelperTestObject.getTestObjectWithXpath("//label[@class='control-label decimal required']"));
				WebUiBuiltInKeywords.setText(
						HelperTestObject.getTestObjectWithXpath("//input[@id='vacacion_percibida_numero_dias']"),
						Numero_Dias);
			} else if (Tipo_Vacaciones.compareTo("Días administrativos") == 0) {
				WebUiBuiltInKeywords.setText(
						HelperTestObject.getTestObjectWithXpath("//input[@id='vacacion_percibida_fecha']"),
						Fecha_Asignacion);
				WebUiBuiltInKeywords
				.click(HelperTestObject.getTestObjectWithXpath("//label[@class='control-label decimal required']"));
				WebUiBuiltInKeywords.setText(
						HelperTestObject.getTestObjectWithXpath("//input[@id='vacacion_percibida_numero_dias']"),
						Numero_Dias);
			}
		}
}