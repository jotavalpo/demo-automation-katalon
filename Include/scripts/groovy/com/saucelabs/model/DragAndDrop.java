package com.saucelabs.model;
import com.opencsv.bean.CsvBindByName;
public class DragAndDrop {
	
	@CsvBindByName(column = "id")
    private String idSelector;
    @CsvBindByName(column = "selector")
    private String selector;
    @CsvBindByName(column = "parametro")
    private String parametro;
	public String getIdSelector() {
		return idSelector;
	}
	public void setIdSelector(String idSelector) {
		this.idSelector = idSelector;
	}
	public String getParametro() {
		return parametro;
	}
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	public String getSelector() {
		return selector;
	}
	public void setSelector(String selector) {
		this.selector = selector;
	}
	@Override
	public String toString() {
		return "DragAndDrop [idSelector=" + idSelector + ", selector=" + selector + ", parametro=" + parametro +  "]";
	}
	
}