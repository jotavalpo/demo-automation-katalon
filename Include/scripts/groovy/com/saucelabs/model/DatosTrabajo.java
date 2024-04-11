package com.saucelabs.model;

import com.opencsv.bean.CsvBindByName;

public class DatosTrabajo {

	@CsvBindByName(column = "empresa")
 	private String empresa;
	
	@CsvBindByName(column = "tipoDeContrato")
 	private String tipoDeContrato;
	
	@CsvBindByName(column = "periodicidadDeJornada")
 	private String periodicidadDeJornada;
	
	@CsvBindByName(column = "horarioSemanal")
 	private String horarioSemanal;
	
	@CsvBindByName(column = "tipoDeJornada")
 	private String tipoDeJornada;
	
	@CsvBindByName(column = "area")
 	private String area;

	@CsvBindByName(column = "cargo")
 	private String cargo;

	@CsvBindByName(column = "supervisor")
 	private String supervisor;
	
	@CsvBindByName(column = "sindicato")
 	private String sindicato;
	
	@CsvBindByName(column = "sueldoBase")
 	private String sueldoBase;
	
	@CsvBindByName(column = "moneda")
 	private String moneda;

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getTipoDeContrato() {
		return tipoDeContrato;
	}

	public void setTipoDeContrato(String tipoDeContrato) {
		this.tipoDeContrato = tipoDeContrato;
	}

	public String getPeriodicidadDeJornada() {
		return periodicidadDeJornada;
	}

	public void setPeriodicidadDeJornada(String periodicidadDeJornada) {
		this.periodicidadDeJornada = periodicidadDeJornada;
	}

	public String getHorarioSemanal() {
		return horarioSemanal;
	}

	public void setHorarioSemanal(String horarioSemanal) {
		this.horarioSemanal = horarioSemanal;
	}

	public String getTipoDeJornada() {
		return tipoDeJornada;
	}

	public void setTipoDeJornada(String tipoDeJornada) {
		this.tipoDeJornada = tipoDeJornada;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public String getSindicato() {
		return sindicato;
	}

	public void setSindicato(String sindicato) {
		this.sindicato = sindicato;
	}

	public String getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(String sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	@Override
	public String toString() {
		return "DatosTrabajo [empresa=" + empresa + ", tipoDeContrato=" + tipoDeContrato + ", periodicidadDeJornada="
				+ periodicidadDeJornada + ", horarioSemanal=" + horarioSemanal + ", tipoDeJornada=" + tipoDeJornada
				+ ", area=" + area + ", cargo=" + cargo + ", supervisor=" + supervisor + ", sindicato=" + sindicato
				+ ", sueldoBase=" + sueldoBase + ", moneda=" + moneda + "]";
	}

}