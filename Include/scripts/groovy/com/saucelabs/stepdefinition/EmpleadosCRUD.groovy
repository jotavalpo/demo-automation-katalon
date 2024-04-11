package com.saucelabs.stepdefinition
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.saucelabs.helper.HelperModels
import com.saucelabs.helper.HelperTestObject

import com.saucelabs.businesslogic.BLEmpleados;
import com.saucelabs.model.*;
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import internal.GlobalVariable
import io.cucumber.datatable.DataTable


class EmpleadosCRUD {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("quiero crear empleados")
	public void quiero_crear_empleados() {


		// Write code here that turns the phrase above into concrete actions
		HelperTestObject.scrollWaitClickToTestObjectByXpath("//span[@class='text-truncate sidebar_text '][contains(.,'Empleados')]")

		HelperTestObject.scrollWaitClickToTestObjectByXpath("//span[@class='text-truncate sidebar_text'][contains(.,'Crear Empleado')]")
		WebUI.waitForElementVisible(HelperTestObject.getTestObjectWithXpath("//h2[contains(text(),'Nuevo Empleado')]"), 5)

		assert WebUI.verifyElementText(HelperTestObject.getTestObjectWithXpath("//h2[contains(text(),'Nuevo Empleado')]"), "Nuevo Empleado")

		/*
		 WebUI.waitForPageLoad(2)
		 HelperTestObject.scrollWaitClickToTestObjectByXpath('Crear_empleado/Page_Buk  Home  buk/Botón OK')
		 HelperTestObject.scrollWaitClickToTestObjectByXpath('módulo_empleados/Empleados')
		 HelperTestObject.scrollWaitClickToTestObjectByXpath('módulo_empleados/Crear empleados')
		 */
	}
	//Sólo considera datos obligatorios
	@When("ingreso la información de los empleados en los formularios")
	public void ingreso_la_información_de_los_empleados_en_los_formularios() {
		Empleado empleado = HelperModels.csvWithModels("Include/Data/SauceDemo/NuevoEmpleado.csv" ).get(0);
		//Datos personales
		//String rut="98971783-9", nombre='nombreempleado', apellido='pruebasap', fechaDeNacimiento='01-07-1991'
		BLEmpleados.crearEmpleadoDatosPersonales("Sí", empleado.getRut(), empleado.getNombre(), empleado.getApellido(), "SegundoApellido", empleado.getPaisNacimiento(), empleado.getSexo(), empleado.getEstadoCivil(), empleado.getFechaNacimiento(), "01-01-1990", "567894327", "123456789", "correo@pruebas.cl", "correo@pruebas2.cl", empleado.getRegion(), empleado.getLocalidad(), empleado.getComuna(), empleado.getDireccion(), empleado.getFormaDePago(), empleado.getBanco(), empleado.getTipoCuenta(), empleado.getNumeroDeCuenta(), "F1", "01/01/2022")
		BLEmpleados.presionarBotonCrearEmpleado();

		DatosPrevisionales prevision = HelperModels.datosProvisionales("Include/Data/SauceDemo/DatoPrevisionales.csv" ).get(0);
		//Datos previsionales
		//String régimenPrevisional="afp", fondoDeCotización='modelo', instDeSalud='fonasa', afc='afc_normal'
		BLEmpleados.crearEmpleadoAgregarDatosPrevisionales(prevision.getRegimenPrevisionales(), prevision.getFondoDeCotización(), prevision.getInstDeSalud(), "fun", "planIsapreUf", prevision.getAfc())

		DatosTrabajo trabajo = HelperModels.datostrabajo("Include/Data/SauceDemo/DatosTrabajo.csv").get(0);
		//Datos trabajo
		//String empresa="Demo SpA", tipoDeContrato='Indefinido', periodicidadDeJornada='mensual', horarioSemanal="45", tipoDeJornada="Ordinaria ART 22", area='Producto - Producto - Producto', cargo="Product Owner (product_owner)", supervisor="paola", sindicato="Ninguno", sueldoBase="2000000", moneda='peso'
		BLEmpleados.crearEmpleadoCrearDatosTrabajo(trabajo.getEmpresa(),trabajo.getTipoDeContrato(), trabajo.getPeriodicidadDeJornada(), trabajo.getHorarioSemanal(), trabajo.getTipoDeJornada(), trabajo.getArea(), trabajo.getCargo(), trabajo.getSupervisor(), trabajo.getSindicato(), trabajo.getSueldoBase(), trabajo.getMoneda())
		//BLEmpleados.presionarBotonFinalizar();


		//AGREGAR VACACIONES falta atomizar el método porque funcionalidad no está terminada

		//WebUI.click(HelperTestObject.getTestObjectWithXpath("//*[@id='select2-vacation_configs_vacation_config_definitions_attributes_0_vacation_type-container']"))
		//WebUI.click(HelperTestObject.getTestObjectWithXpath("//*[@id='vacation-config-fields']/div/div/div[2]/div/div/div/div"))
		//WebUI.click(HelperTestObject.getTestObjectWithXpath("//*[@id='vacation_configs_vacation_config_definitions_attributes_0_vacation_start_date']"))
	}

	@Then("el empleado es creado de forma correcta")
	public void el_empleado_es_creado_de_forma_correcta() {
		// Write code here that turns the phrase above into concrete actions
		TestObject object = (HelperTestObject.getTestObjectWithXpath("//div[contains(@class,'alert alert-success')]"));
		assert WebUI.verifyElementVisible(object);

		WebUI.takeScreenshot();
		BLEmpleados.eliminarEmpleado();



	}

	//Editar empleado

	@Given ("quiero editar la informacion de un empleado {string}")
	def  quiero_editar_la_informacion_de_un_empleado(String URL_emp) {
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
		String url = GlobalVariable.Url ;
		WebUI.navigateToUrl( GlobalVariable.Url + URL_emp);
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
	}

	@When("hago click en icono editar de la ficha")
	def hago_click_en_icono_editar_de_la_ficha() {
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
		BLEmpleados.irAEditarDatosPersonalesEmpleado();
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
	}


	@When("edito informacion personal {string} {string} {string} {string} {string} {string} {string} {string}")
	def edito_informacion_personal(String nombre,  String apellido,  String estado_civil, String tel_oficina, String tel_particular,
			String mail_corporativo, String mail_particular, String direccion) {
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
		BLEmpleados.modificarInformacionPersonalEmpleado(nombre, apellido, estado_civil, tel_oficina, tel_particular, mail_corporativo, mail_particular, direccion)
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();

	}


	@When("actualizo empleado")
	def actualizo_empleado() {
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
		BLEmpleados.clickActualizarDatosPersonalesEmpleado()
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
	}

	@When("edito informacion previsional {string} {string}")
	def edito_informacion_previsional(String isapre, String uf) {
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
		BLEmpleados.EditarDatosPrevisionalesEmpleado(isapre, uf);
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
	}
	@When("hago click en guardar")
	def hago_click_en_guardar() {
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
		BLEmpleados.clickGuardarDatosPrevisionales();
		WebUI.click(HelperTestObject.getTestObjectWithXpath("//div[contains(@class,'alert alert-success')]"));
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();

	}

	@Then("se actualizan los datos:")
	public void se_actualizan_los_datos(DataTable dataTable) {
		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (row in data) {
			String nombre = row.nombre;
			String apellido = row.apellido;
			String estado_civil = row.estado_civil;
			String tel_oficina = row.tel_oficina;
			String tel_particular = row.tel_particular;
			String mail_corporativo =  row.mail_corporativo;
			String mail_particular = row.mail_particular;
			String direccion = row.direccion;
			String prevision = row.prevision;
			String uf = row.uf;
			WebUI.waitForPageLoad(20);
			WebUI.takeScreenshot();
			BLEmpleados.irAEditarDatosPersonalesEmpleado();
			BLEmpleados.modificarInformacionPersonalEmpleado(nombre, apellido, estado_civil, tel_oficina, tel_particular, mail_corporativo, mail_particular, direccion);
			BLEmpleados.clickActualizarDatosPersonalesEmpleado();
			BLEmpleados.EditarDatosPrevisionalesEmpleado(prevision, uf);
			BLEmpleados.clickGuardarDatosPrevisionales();
			WebUI.waitForPageLoad(20);
			WebUI.takeScreenshot();
			TestObject object = (HelperTestObject.getTestObjectWithXpath("//div[contains(@class,'alert alert-success')]"));
			assert WebUI.verifyElementVisible(object);
			WebUI.waitForPageLoad(20);
			WebUI.takeScreenshot();
		}

		WebUI.waitForPageLoad(20);
		WebUI.takeScreenshot();
	}
}