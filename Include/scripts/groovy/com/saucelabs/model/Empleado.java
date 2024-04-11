package com.saucelabs.model;

import com.opencsv.bean.CsvBindByName;

public class Empleado {
	

	 	@CsvBindByName(column = "nombre")
	 	private String nombre;

		@CsvBindByName(column = "apellido")
	    private String apellido;

	    @CsvBindByName(column = "fechaNacimiento")
	    private String fechaNacimiento;
	    
	    @CsvBindByName(column = "rut")
	    private String rut;
	    
	    @CsvBindByName(column = "estadoCivil")
	    private String estadoCivil;
	    
	    @CsvBindByName(column = "ingresoCompania")
	    private String ingresoCompania;
	    
	    @CsvBindByName(column = "paisNacimiento")
	    private String paisNacimiento;
	    
	    @CsvBindByName(column = "sexo")
	    private String sexo;
	    
	    @CsvBindByName(column = "direccion")
	    private String direccion;
	    
	    @CsvBindByName(column = "formaDePago")
	    private String formaDePago;
	    
	    @CsvBindByName(column = "banco")
	    private String banco;
	    
	    @CsvBindByName(column = "tipoCuenta")
	    private String tipoCuenta;
	    
	    @CsvBindByName(column = "numeroDeCuenta")
	    private String numeroDeCuenta;
	    
	    @CsvBindByName(column = "region")
	    private String region;
	    
	    @CsvBindByName(column = "localidad")
	    private String localidad;
	    
	    @CsvBindByName(column = "comuna")
	    private String comuna;
	    
	        
	    
	    public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public String getFormaDePago() {
			return formaDePago;
		}

		public void setFormaDePago(String formaDePago) {
			this.formaDePago = formaDePago;
		}

		public String getBanco() {
			return banco;
		}

		public void setBanco(String banco) {
			this.banco = banco;
		}

		public String getTipoCuenta() {
			return tipoCuenta;
		}

		public void setTipoCuenta(String tipoCuenta) {
			this.tipoCuenta = tipoCuenta;
		}

		public String getNumeroDeCuenta() {
			return numeroDeCuenta;
		}

		public void setNumeroDeCuenta(String numeroDeCuenta) {
			this.numeroDeCuenta = numeroDeCuenta;
		}
	    
	    public String getPaisNacimiento() {
			return paisNacimiento;
		}

		public void setPaisNacimiento(String paisNacimiento) {
			this.paisNacimiento = paisNacimiento;
		}

		public String getSexo() {
			return sexo;
		}

		public void setSexo(String sexo) {
			this.sexo = sexo;
		}
	    
	    public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getFechaNacimiento() {
			return fechaNacimiento;
		}

		public void setFechaNacimiento(String fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
		}

		public String getRut() {
			return rut;
		}

		public void setRut(String rut) {
			this.rut = rut;
		}

		public String getEstadoCivil() {
			return estadoCivil;
		}

		public void setEstadoCivil(String estadoCivil) {
			this.estadoCivil = estadoCivil;
		}

		public String getIngresoCompania() {
			return ingresoCompania;
		}

		public void setIngresoCompania(String ingresoCompania) {
			this.ingresoCompania = ingresoCompania;
		}

		public String getRegion() {
			return region;
		}

		public void setRegion(String region) {
			this.region = region;
		}

		public String getLocalidad() {
			return localidad;
		}

		public void setLocalidad(String localidad) {
			this.localidad = localidad;
		}

		public String getComuna() {
			return comuna;
		}

		public void setComuna(String comuna) {
			this.comuna = comuna;
		}

		@Override
		public String toString() {
			return "Empleado [nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento
					+ ", rut=" + rut + ", estadoCivil=" + estadoCivil + ", ingresoCompania=" + ingresoCompania
					+ ", paisNacimiento=" + paisNacimiento + ", sexo=" + sexo + ", direccion=" + direccion
					+ ", formaDePago=" + formaDePago + ", banco=" + banco + ", tipoCuenta=" + tipoCuenta
					+ ", numeroDeCuenta=" + numeroDeCuenta + ", region=" + region + ", localidad=" + localidad
					+ ", comuna=" + comuna + "]";
		}
						    
}