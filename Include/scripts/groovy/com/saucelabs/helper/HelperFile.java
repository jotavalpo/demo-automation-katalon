package com.saucelabs.helper;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords;

import internal.GlobalVariable;

public class HelperFile {

	/**
	 * Esta funcion busca si un archivo existe en una carpeta, luego lo borra TODO:
	 * Se debe actualizar para descargar y usar los archivos descargados dentro de
	 * la carpeta del proyecto, asi no usaremos path distintos
	 * 
	 * 
	 * @param downloadPath es la ruta de descargas de cada uno de nosotros
	 * @param fileName     es el archivo que se busca en la carpeta
	 * @return devuelve un verdadero si el archivo es encontrado
	 */
	public static Boolean isFileDownloaded(String downloadPath, String fileName) {

		System.out.println("downloadPath -> " + downloadPath);

		File dir = new File(downloadPath);

		boolean archivoExiste =  false, finBucle = false, archivoDescargandose = false;
		File[] dirContents = null;
		while (!finBucle) {			
			if ( dir.listFiles() != null) {
				finBucle = true;
			}
		}
		
		finBucle = false;
		String downloaderFile = "";
		int position = 0;
		while (!finBucle) {

			dirContents = dir.listFiles();		
			for (int i = 0; i <= dirContents.length -1; i++) {			 
				archivoDescargandose = true;
				if (dirContents[i].getName().toString().equals(fileName)){		
					downloaderFile = dirContents[i].getName().toString();
					finBucle = true;
					position = i;
					System.out.println("Archivo encontrado: " + dirContents[i].getName().toString());

					i = dirContents.length -1;
					archivoDescargandose = false;
				
				} else if (!dirContents[0].getName().toString().equals(fileName)) {
					System.out.println("Archivo no encontrado: " + dirContents[i].getName().toString());
					archivoDescargandose = true;
				}
			}

			if (!archivoDescargandose) {

				finBucle =  true; 	
				System.out.println("Archivo encontrado y salimos del bucle");
			}			
  }

		if (downloaderFile.equals(fileName)) {

			// File has been found, it can now be deleted:

			System.out.println("Archivo si existe: " + dirContents[position].getName().toString());
			dirContents[position].delete();
			archivoExiste = true;

		} else {

			System.out.println("Archivo no  existe en " + downloadPath);
			archivoExiste = false;

		}

		return archivoExiste;

	}

	public static Path getRutaLocal() {
		Path userHome = Paths.get(System.getProperty("user.home"));
		return userHome;
	}

	public static Path getRutaDownloads(Path userHome) {
		Path downloads = userHome.resolve("Downloads");
		return downloads;
	}

	public static String getArchivo(String nombreArchivoEntrada) {
		String nombreArchivoSalida = "";
		switch (GlobalVariable.Pais.toString()) {
		case "Chile":
			nombreArchivoSalida = "Include/Data/Chile/" + nombreArchivoEntrada;
			break;
		case "Colombia":
			nombreArchivoSalida = "Include/Data/Colombia/" + nombreArchivoEntrada;
			break;
		case "Mexico":
			nombreArchivoSalida = "Include/Data/Mexico/" + nombreArchivoEntrada;
			break;
		case "Peru":
			nombreArchivoSalida = "Include/Data/Peru/" + nombreArchivoEntrada;
			break;
		case "Performance_M":
			nombreArchivoSalida = "Include/Data/Performance/" + nombreArchivoEntrada;
			break;
		}
		return nombreArchivoSalida;
	}

	public static void uploadfile(String nombreArchivoEntrada) {
		String nombreArchivoSalida = HelperFile.getArchivo(nombreArchivoEntrada);
		File rutaArchivo = new File(nombreArchivoSalida);
		WebUiBuiltInKeywords.uploadFile(HelperTestObject.getTestObjectWithXpath("//input[@type='file']"),
				rutaArchivo.getAbsolutePath());
	}

	public static Path getRutaRelativaDownloads() {

		String Ruta = getRutaDownloads(getRutaLocal()).toString();
		System.out.println("Ruta Relativa: " + Ruta);
		return getRutaDownloads(getRutaLocal());

	}

	public static void clearDirectory(Path path) {
		
		File dir = new File(path.toString());		
		File[] dirContents;  
		
		if (dir.listFiles() == null) {			
			System.out.println("No se encontraron archivos a eliminar en directorio: " + dir.getAbsolutePath());
		}
		 
		if (dir.listFiles() != null) {		
			dirContents = dir.listFiles();
			for (int i = 0; i < dirContents.length; i++) {
				System.out.println("Archivo a eliminar: " + dirContents[i].toString());
				dirContents[i].delete();
			}
			
		}
		
	}
}