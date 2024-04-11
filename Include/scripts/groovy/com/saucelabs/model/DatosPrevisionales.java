package com.saucelabs.model;

import com.opencsv.bean.CsvBindByName;

public class DatosPrevisionales {

	@CsvBindByName(column = "regimenPrevisionales")
 	private String regimenPrevisionales;
	
	@CsvBindByName(column = "fondoDeCotización")
 	private String fondoDeCotización;
	
	@CsvBindByName(column = "instDeSalud")
 	private String instDeSalud;
	
	@CsvBindByName(column = "afc")
 	private String afc;
	
	public String getRegimenPrevisionales() {
		return regimenPrevisionales;
	}

	public void setRegimenPrevisionales(String regimenPrevisionales) {
		this.regimenPrevisionales = regimenPrevisionales;
	}

	public String getFondoDeCotización() {
		return fondoDeCotización;
	}

	public void setFondoDeCotización(String fondoDeCotización) {
		this.fondoDeCotización = fondoDeCotización;
	}

	public String getInstDeSalud() {
		return instDeSalud;
	}

	public void setInstDeSalud(String instDeSalud) {
		this.instDeSalud = instDeSalud;
	}

	public String getAfc() {
		return afc;
	}

	public void setAfc(String afc) {
		this.afc = afc;
	}

	@Override
	public String toString() {
		return "datosPrevisionales [regimenPrevisionales=" + regimenPrevisionales + ", fondoDeCotización="
				+ fondoDeCotización + ", instDeSalud=" + instDeSalud + ", afc=" + afc + "]";
	}
	
	
	
}