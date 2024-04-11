package com.saucelabs.businesslogic
import com.saucelabs.helper.HelperTestObject

import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class ExemploVueTreeSelect {

	@When("selecciono la comuna")
	public void selecciono_la_comuna() {

		HelperTestObject.seleccionarVueTreeSelect("VI", "Cachapoal", "Rancagua");
	}

	@Then("la comuna es seleccionada")
	public void la_comuna_es_seleccionada() {
		// Write code here that turns the phrase above into concrete actions

	}
}