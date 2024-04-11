package com.saucelabs.model;

import com.opencsv.bean.CsvBindByName;

public class DatosFiltrosAvanzados {
    
    /**
     * Clase que representa los datos de filtros avanzados.
     */
    
    @CsvBindByName(column = "atributo")
    private String atributo;
    
    @CsvBindByName(column = "condicion")
    private String condicion;
    
    @CsvBindByName(column = "parametro")
    private String parametro;

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    @Override
    public String toString() {
        return "DatosFiltrosAvanzados [atributo=" + atributo + ", condicion=" + condicion + ", parametro=" + parametro + "]";
    }
    
}
