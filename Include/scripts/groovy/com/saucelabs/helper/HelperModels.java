package com.saucelabs.helper;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

import com.saucelabs.model.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import java.util.Arrays;


public class HelperModels {
	
	
    public static List<Empleado> csvWithModels(String fileName) throws IOException {
   
        List<Empleado> beans = new CsvToBeanBuilder<Empleado>(new FileReader(fileName))
                .withType(Empleado.class)
                .build()
                .parse();

        beans.forEach(System.out::println);
        return beans; 
       
    } 
    public static  List<DragAndDrop>  csvDragAndDrop(String fileName) throws IOException {


        List<DragAndDrop> beans = new CsvToBeanBuilder<DragAndDrop>(new FileReader(fileName))
                .withType(DragAndDrop.class)
                .build()
                .parse();

        beans.forEach(System.out::println);
        return beans;   
        
       
    }
    
    public static List<DatosPrevisionales> datosProvisionales(String fileName) throws IOException {
    	   
        List<DatosPrevisionales> beans = new CsvToBeanBuilder<DatosPrevisionales>(new FileReader(fileName))
                .withType(DatosPrevisionales.class)
                .build()
                .parse();

        beans.forEach(System.out::println);
        return beans; 
       
    }
    
    public static List<DatosTrabajo> datostrabajo(String fileName) throws IOException {
 	   
        List<DatosTrabajo> beans = new CsvToBeanBuilder<DatosTrabajo>(new FileReader(fileName))
                .withType(DatosTrabajo.class)
                .build()
                .parse();

        beans.forEach(System.out::println);
        return beans; 
       
    }
    public static List<DatosFiltrosAvanzados> leerDatosDesdeCSV(String fileName) throws IOException, CsvException {
        List<DatosFiltrosAvanzados> beans = new CsvToBeanBuilder<DatosFiltrosAvanzados>(new FileReader(fileName))
                .withType(DatosFiltrosAvanzados.class)
                .build()
                .parse();

        beans.forEach(System.out::println);
        return beans; 
    }
    
    
    public static List<ItemHaberesBase> leerDatosItemsHaberesNuevoDesdeCSV(String fileName) throws IOException, CsvException {
        
    	List<ItemHaberesBase> beans = new CsvToBeanBuilder<ItemHaberesBase>(new FileReader(fileName))
                .withType(ItemHaberesBase.class)
                .build()
                .parse();

        beans.forEach(System.out::println);
        return beans; 
    
    }
    
    public static void csvWithNOTModels (String fileName) throws IOException, CsvException {
    	
    	  List<String[]> r;
          try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
              r = reader.readAll();
              
             
          }
        
          int listIndex = 0;
          for (String[] arrays : r) {
              System.out.println("\nString[" + listIndex++ + "] : " + Arrays.toString(arrays));

              int index = 0;
              for (String array : arrays) {
                  System.out.println(index++ + " : " + array);
              }

          }
      }	
    
  
}
 
    
    

