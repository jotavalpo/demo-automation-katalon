package com.saucelabs.model;
import org.openqa.selenium.WebElement;



/**
 * @author fnune
 *
 *
 *
 */
public class ReliquidacionDetalleModel {
	
	 	private WebElement parametros;
	 	private WebElement resumen;
		private WebElement impuestos;
		private WebElement cotizaciones;
		private WebElement aportes;
		
		
		
		public ReliquidacionDetalleModel(WebElement parametros, WebElement resumen, WebElement impuestos,
				WebElement cotizaciones, WebElement aportes) {
			super();
			this.parametros = parametros;
			this.resumen = resumen;
			this.impuestos = impuestos;
			this.cotizaciones = cotizaciones;
			this.aportes = aportes;
		}



		public WebElement getParametros() {
			return parametros;
		}



		public void setParametros(WebElement parametros) {
			this.parametros = parametros;
		}



		public WebElement getResumen() {
			return resumen;
		}



		public void setResumen(WebElement resumen) {
			this.resumen = resumen;
		}



		public WebElement getImpuestos() {
			return impuestos;
		}



		public void setImpuestos(WebElement impuestos) {
			this.impuestos = impuestos;
		}



		public WebElement getCotizaciones() {
			return cotizaciones;
		}



		public void setCotizaciones(WebElement cotizaciones) {
			this.cotizaciones = cotizaciones;
		}



		public WebElement getAportes() {
			return aportes;
		}



		public void setAportes(WebElement aportes) {
			this.aportes = aportes;
		}	
}