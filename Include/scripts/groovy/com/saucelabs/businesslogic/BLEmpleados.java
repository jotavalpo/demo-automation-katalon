package com.saucelabs.businesslogic;
import org.openqa.selenium.Keys;

import com.kms.katalon.core.testobject.TestObject;
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords;
import com.saucelabs.helper.HelperTestObject;


public class BLEmpleados {

	public static void selecionarEmpleadoVigente(String identificador) {



		//	WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("(//i[contains(@class,' fas fa-angle-left ')])[3]"), 15);
		//	WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(//i[contains(@class,' fas fa-angle-left ')])[3]"));
		//	WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//span[@data-overflow-tooltip='Vigentes']"), 15);
		//	WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//span[@data-overflow-tooltip='Vigentes']"));
		WebUiBuiltInKeywords.takeScreenshot();
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//input[contains(@data-filter,'ci')]"),40 );
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[contains(@data-filter,'ci')]"), identificador);
		WebUiBuiltInKeywords.takeScreenshot();
	}

	public static void seleccionarPrimerResultadoDeBusqueda() {

		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("(//a[contains(@title,'Detalle')])[1]"),20);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(//a[contains(@title,'Detalle')])[1]"));
		WebUiBuiltInKeywords.takeScreenshot();
	}


	//Datos personales
	public static void seleccionarComuna() {

		//	WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(//input[@type='text'])[8]"));
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[@class='vue-treeselect__input']"));

		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(.//*[normalize-space(text()) and normalize-space(.)=concat('VI: del Libertador Gral. Bernardo O', \"'\", 'Higgins')])[1]/following::label[1]"));
		//WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(.//*[normalize-space(text()) and normalize-space(.)=concat('VI: del Libertador Gral. Bernardo O', \"'\", 'Higgins')])[1]"));
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(.//*[normalize-space(text()) and normalize-space(.)='Talca'])[1]/following::label[1]"));
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(.//*[normalize-space(text()) and normalize-space(.)='Cauquenes'])[1]/following::label[1]"));

		System.out.println("comuna Seleccionada.............");
		WebUiBuiltInKeywords.delay(5);

	}
	public static void crearEmpleadoDatosPersonales(String rolPrivado, String rut, String nombre, String apellido, String segundoApellido, String paísDeNacimiento, String sexo, String estadoCivil, String fechaDeNacimiento, String ingresoCompañía, String teléfonoOficina, String teléfonoParticular, String emailCorporativo, String emailPersonal, String region, String localidad, String comuna, String dirección, String formaDePago, String banco, String tipoDeCuenta, String númeroDeCuenta, String códigoDeFicha, String ingresoCompanía) {

		//Pendiente rol privado, cómo se define? crear booleano
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='person_first_name']"), nombre);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='person_last_name']"), apellido);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='person_rut']"), rut);
		WebUiBuiltInKeywords.selectOptionByLabel(HelperTestObject.getTestObjectWithXpath("//select[@id='person_sexo']"), sexo, true);
		WebUiBuiltInKeywords.selectOptionByLabel(HelperTestObject.getTestObjectWithXpath("//select[@id='person_estado_civil']"), estadoCivil, true);
		TestObject testObject = HelperTestObject.getTestObjectWithXpath("//input[@id='person_date_of_birth']");
		HelperTestObject.ingresaCalendario(testObject,fechaDeNacimiento);
		//HelperTestObject.seleccionarVueTreeSelect(region, localidad, comuna);
		seleccionarComuna();

		//WebUiBuiltInKeywords.scrollToElement(HelperTestObject.getTestObjectWithXpath("//input[contains(@class,'vue-treeselect__input')]"), 0);
		//WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//*[@id='person_location_id']/div/div[1]/div[1]/div[2]/input"));
		//WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//*[@id='person_location_id']/div/div[1]/div[1]/div[2]/input"), comuna);
		//WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//*[@id='person_location_id']/div/div[1]/div[1]/div[3]"));
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[contains(@id,'person_direccion')]"), dirección);
		WebUiBuiltInKeywords.scrollToElement(HelperTestObject.getTestObjectWithXpath("//select[@id='payment_detail_payment_method']"), 0);
		WebUiBuiltInKeywords.selectOptionByValue(HelperTestObject.getTestObjectWithXpath("//select[@id='payment_detail_payment_method']"), formaDePago, true);
		WebUiBuiltInKeywords.scrollToElement(HelperTestObject.getTestObjectWithXpath("//select[@id='payment_detail_bank']"), 0);
		WebUiBuiltInKeywords.selectOptionByValue(HelperTestObject.getTestObjectWithXpath("//select[@id='payment_detail_bank']"), banco, true);
		WebUiBuiltInKeywords.scrollToElement(HelperTestObject.getTestObjectWithXpath("//select[@id='payment_detail_account_type']"), 0);
		WebUiBuiltInKeywords.selectOptionByValue(HelperTestObject.getTestObjectWithXpath("//select[@id='payment_detail_account_type']"), tipoDeCuenta, true);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='payment_detail_account_number']"), númeroDeCuenta);
		testObject = HelperTestObject.getTestObjectWithXpath("//input[contains(@id,'employee_ingreso_compania')]");
		HelperTestObject.ingresaCalendario(testObject,"10-10-2021");
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//button[text()='OK']"),10);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//button[text()='OK']"));
		presionarBotonCrearEmpleado();
		System.out.println("datosPersonalesCreados.............");
		WebUiBuiltInKeywords.delay(5);

	}
	public static void presionarBotonCrearEmpleado() {
		WebUiBuiltInKeywords.scrollToElement(HelperTestObject.getTestObjectWithXpath("//button[@name='button']"),3);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//button[@name='button']"));
	}

	//Datos previsionales
	public static void crearEmpleadoAgregarDatosPrevisionales(String régimenPrevisional, String fondoDeCotización, String instDeSalud, String fun, String planIsapreUf, String afc) {
		WebUiBuiltInKeywords.scrollToElement(HelperTestObject.getTestObjectWithXpath("//select[@id='plan_fondo_cotizacion']"),0);
		WebUiBuiltInKeywords.selectOptionByValue(HelperTestObject.getTestObjectWithXpath("//select[@id='plan_fondo_cotizacion']"), fondoDeCotización, true);
		WebUiBuiltInKeywords.scrollToElement(HelperTestObject.getTestObjectWithXpath("//*[@id='plan_health_company']"), 0);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//*[@id='plan_health_company']/option[2]"));
		//Agregar el aceptar la alerta que aparece al momento de ingresar una fecha anterior o posterior al mes en curso
		presionarBotonSiguiente();
		System.out.println("datosPrevisionalesCreados.............");
		WebUiBuiltInKeywords.delay(5);

	}
	public static void presionarBotonSiguiente() {
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//span[contains(.,'Siguiente')]"));
	}

	//Datos trabajo
	public static void crearEmpleadoCrearDatosTrabajo(String empresa, String tipoDeContrato, String periodicidadDeJornada, String horarioSemanal, String tipoDeJornada, String area, String cargo, String supervisor, String sindicato, String sueldoBase, String moneda)	{
		WebUiBuiltInKeywords.scrollToElement(HelperTestObject.getTestObjectWithXpath("//*[@id='job_tipo_contrato']"), 0);
		WebUiBuiltInKeywords.selectOptionByValue(HelperTestObject.getTestObjectWithXpath("//select[@id='job_tipo_contrato']"), tipoDeContrato, true);

		//Campo complejo
		WebUiBuiltInKeywords.scrollToElement(HelperTestObject.getTestObjectWithXpath("//*[@id='job_area_id']/div/div[1]/div[1]/div[1]"), 0);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//*[@id='job_area_id']/div/div[1]/div[2]"));
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(.//*[normalize-space(text()) and normalize-space(.)='Producto - Producto - Producto'])[1]"));
		
		
		//WebUiBuiltInKeywords.scrollToElement(HelperTestObject.getTestObjectWithXpath("//input[@class='vue-treeselect__input']"), 5);
		//WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//input[@class='vue-treeselect__input']"));
		//WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//label[text()[normalize-space()='Producto']]"));
		//WebUiBuiltInKeywords.delay(5);
        //WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(//input[@type='text'])[2]"));
        //WebUiBuiltInKeywords.delay(5);
		//WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//label[text()[normalize-space()='Producto']]"));
		//WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//label[text()[normalize-space()='Producto']]"));
		
		
		
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//*[@id='select2-job_role_id-container']"));
		//WebUiBuiltInKeywords.selectOptionByValue(HelperTestObject.getTestObjectWithXpath("//*[@id='select2-job_role_id-results']"), cargo, true);
		WebUiBuiltInKeywords.delay(2);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//*[@id='select2-job_role_id-results']/li[2]"));
		//FALTA SOLO EL CLIC SOBRE LA OPCION

		//WebUiBuiltInKeywords.scrollToElement(HelperTestObject.getTestObjectWithXpath("//*[@id='select2-job_jefe_id-container']"), 2);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//*[@id='select2-job_jefe_id-container']"));
		//WebUiBuiltInKeywords.delay(2);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//*[@id='supervisor']/div/div/span[2]/span/span[1]/input"), supervisor);
		//WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//*[@id='select2-job_jefe_id-container']"), supervisor);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(//li[contains(@role,'option')])[1]")); //*[@id='job_jefe_id']/option[4]
		Keys.chord(Keys.ENTER);

		//WebUiBuiltInKeywords.selectOptionByValue(HelperTestObject.getTestObjectWithXpath("//select[@id='select2-job_jefe_id-container']"), supervisor, true);

		//WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//*[@id='job_jefe_id']/option[4]"));
		//WebUiBuiltInKeywords.selectOptionByValue(HelperTestObject.getTestObjectWithXpath("//*[@id='select2-job_jefe_id-container']"), supervisor, true);
		//WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//*[@id='job_jefe_id']/option[4]"));


		//FALTA SOLO EL CLIC SOBRE LA OPCION

		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@id='job_wage']"), sueldoBase);

		WebUiBuiltInKeywords.scrollToElement(HelperTestObject.getTestObjectWithXpath("//span[contains(.,'Finalizar')]"), 0);
		presionarBotonFinalizar();
		System.out.println("datosTrabajoCreados.............");
		WebUiBuiltInKeywords.delay(5);
	}

	public static void presionarBotonFinalizar() {
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//span[contains(.,'Finalizar')]"));
	}
	
	public static void eliminarEmpleado() {
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[@data-method='delete']"));
		//WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//div[contains(@class,'swal2-popup swal2-modal')]"),40 );
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//button[@class='swal2-deny swal2-styled']/following-sibling::button[1]"),40 );

		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//button[@class='swal2-deny swal2-styled']/following-sibling::button[1]"));
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//div[contains(@class,'alert alert-success')]"),40 );

		
	}
	
	

	/**
	 * Editar empleado
	 */

	public static void irAEditarDatosPersonalesEmpleado() {

		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//i[contains(@class,'fas fa-pencil-alt')]"),30 );
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//i[contains(@class,'fas fa-pencil-alt')]"));

		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[@data-modal-size='lg']"),30 );
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[@data-modal-size='lg']"));
	}



	public static void modificarInformacionPersonalEmpleado(String nombre,  String apellido, String estado_civil, String tel_oficina, String tel_particular,
			String mail_corporativo, String mail_particular, String direccion) {

		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[contains(@class,'form-control string')]"), nombre);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("(//input[contains(@class,'form-control string')])[2]"), apellido);


		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("(//div[@class='input-group']//select)[3]"));

		WebUiBuiltInKeywords.selectOptionByLabel(HelperTestObject.getTestObjectWithXpath("(//div[@class='input-group']//select)[3]"), estado_civil, false);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@type='tel']"), tel_oficina);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//label[text()='Teléfono Particular']/following::input"), tel_particular);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@type='email']"), mail_corporativo);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//div[@class='mb-2']//input[1]"), mail_particular);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//label[text()='Dirección *']/following::input"), direccion);


	}

	public static void clickActualizarDatosPersonalesEmpleado() {

		WebUiBuiltInKeywords.scrollToElement(HelperTestObject.getTestObjectWithXpath("//span[text()='Actualizar empleado']"), 10);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//span[text()='Actualizar empleado']"));
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//div[contains(@class,'alert alert-success')]"), 10);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//div[contains(@class,'alert alert-success')]"));


	}


	public static void EditarDatosPrevisionalesEmpleado(String prevision, String uf) {

		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//i[contains(@class,'fas fa-pencil-alt')]"),30 );
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//i[contains(@class,'fas fa-pencil-alt')]"));
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//a[@title='Información Previsional']"),30 );
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//a[@title='Información Previsional']"));
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//span[@role='textbox']"));
		WebUiBuiltInKeywords.waitForElementClickable(HelperTestObject.getTestObjectWithXpath("//input[@role='searchbox']"),30);
		WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//input[@role='searchbox']"),prevision);
		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("//input[@role='searchbox']"), 30);
		WebUiBuiltInKeywords.sendKeys(HelperTestObject.getTestObjectWithXpath("//input[@role='searchbox']"), Keys.chord(Keys.ARROW_DOWN));
		WebUiBuiltInKeywords.sendKeys(HelperTestObject.getTestObjectWithXpath("//input[@role='searchbox']"), Keys.chord(Keys.ENTER));

		// Completar el valor del plan en UF de acuerdo a Isapre, si es Fonasa u otro no lo completa

		switch (prevision) {

			case "Banmedica":
				WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//label[text()='Plan Isapre UF *']/following::input"),uf);
				break;

			case "Colmena":
				WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//label[text()='Plan Isapre UF *']/following::input"),uf);
				break;

			case "Consalud":
				WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//label[text()='Plan Isapre UF *']/following::input"),uf);
				break;

			case "Cruz Blanca":
				WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//label[text()='Plan Isapre UF *']/following::input"),uf);
				break;

			case "Nueva Masvida":
				WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//label[text()='Plan Isapre UF *']/following::input"),uf);
				break;

			case "Vida Tres":
				WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//label[text()='Plan Isapre UF *']/following::input"),uf);
				break;

			case "Banco Estado":
				WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//label[text()='Plan Isapre UF *']/following::input"),uf);
				break;

			case "ISALUD Isapre de Codelco":
				WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//label[text()='Plan Isapre UF *']/following::input"),uf);
				break;

			case "Cruz del Norte":
				WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//label[text()='Plan Isapre UF *']/following::input"),uf);
				break;

			case "Esencial":
				WebUiBuiltInKeywords.setText(HelperTestObject.getTestObjectWithXpath("//label[text()='Plan Isapre UF *']/following::input"),uf);
				break;

			default:
				WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("//span[text()='Guardar']"), 30);

		}

	}

	public static void clickGuardarDatosPrevisionales() {


		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//span[text()='Guardar']"));

	}

	public static void validarEdicionDatosPrevisionales() {

		WebUiBuiltInKeywords.waitForElementPresent(HelperTestObject.getTestObjectWithXpath("//div[contains(@class,'alert alert-success')]"), 30);
		WebUiBuiltInKeywords.click(HelperTestObject.getTestObjectWithXpath("//div[contains(@class,'alert alert-success')]"));


	}





}