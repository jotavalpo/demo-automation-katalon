package com.saucelabs.model;


import com.opencsv.bean.CsvBindByName;

public class ItemHaberesBase {
	
	@CsvBindByName(column = "descripcion")
    private String descripcion;
	
	@CsvBindByName(column = "esImponible")
	private String esImponible; 
	
	@CsvBindByName(column = "formaCalculo")
	private String formaCalculo; 
	
	@CsvBindByName(column = "montoAsignar")
	private String montoAsignar; 
	
	@CsvBindByName(column = "moneda")
	private String moneda; 
	
	@CsvBindByName(column = "monto")
	private String monto; 
	
	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	@CsvBindByName(column = "tipoRemuneracion")
	private String tipoRemuneracion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEsImponible() {
		return esImponible;
	}

	public void setEsImponible(String esImponible) {
		this.esImponible = esImponible;
	}

	public String getFormaCalculo() {
		return formaCalculo;
	}

	public void setFormaCalculo(String formaCalculo) {
		this.formaCalculo = formaCalculo;
	}

	public String getMontoAsignar() {
		return montoAsignar;
	}

	public void setMontoAsignar(String montoAsignar) {
		this.montoAsignar = montoAsignar;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getTipoRemuneracion() {
		return tipoRemuneracion;
	}

	public void setTipoRemuneracion(String tipoRemuneracion) {
		this.tipoRemuneracion = tipoRemuneracion;
	} 

}