@Perfiles
Feature: Perfiles
	Como usuario superadmin quiero crear un perfil Administrador de manera exitosa
	
#	@creacionPerfilAdministrador @smoke_test
#	Scenario: [PLA-C1215] - Crear perfil de administrador
  #
#		Given queremos crear Perfil de Administrador
#		When seleccionamos pestania Administracion
#		And las secciones de Empleados con Permiso y Nivel_Permiso:
#			
#			#Gestion de Empleados
#			| Permiso								| Nivel_Permiso		| 
#			| empleados							| Modificación	  |
#			| documentos_empleado		| Modificación	  |
#			| jobs									| Modificación	  |
#			| asistencia						| Modificación	  |
#			| suspension						| Modificación	  |
#			| vacation							| Modificación	  |
#			| vacation_approval			| Modificación	  |
#			| workflow							| Modificación	  |
#			| requirement						| Modificación	  |
#			| requirement_approval	| Modificación	  |
#			| bloqueo_persona				| Modificación	  |
#			| amonestaciones				| Modificación	  |
#			| vacation_configuration| Modificación		|
#			#Remuneraciones
#			| admin_items				| Modificación	  |
#			| assign_items			| Asignación		  |
#			| processes					| Modificación	  |
#			| piecework_admin		| Modificación	  |
#			| piecework_worklog	| Modificación		|
#			#Boleta Honorarios
#			| fee_services			| Modificación  |
#			| boletas_honorario	| Modificación  |
#			#Configuración Sistema
#			| historial							| Si  |
#			| roles									| Si  |
#			| structure_areas				| Si  |
#			#| recintos							| Si  |
#			| document_template			| Si  |
#			| custom_attributes			| Si  |
#			| cost_center						| Si  |
#			| cuentas_contables			| Si  |
#			| users_and_profiles		| Si  |
#			| grant_support_access	| Si  |
#			| configuracion_sistema	| Si  |
#		
#		And la Pestaña de Talento con Permiso y Nivel_Permiso:
#		
#			#Desempeño
#			| Permiso			 | Nivel_Permiso |
#			| metas			 	 | Modificación  |
#			| evaluacion	 | Modificación  |
#			| feedback		 | Modificación  |
#			| action_plans | Modificación  |
#			| calibrations | Modificación  |
#			| logbooks	 	 | Modificación  |
#			#Talento
#		#	| courses			 | Modificación  |
#			| seleccion		 | Modificación  |
#			| onboarding	 | Modificación  |
#			
#		And la Pestaña de Capacitaciones con Permiso y Nivel_Permiso:	
#			#Capacitaciones
#			| Permiso			 | Nivel_Permiso |
#			| courses			 | Modificación  |
#					
#		And la Pestaña de Cultura con Permiso y Nivel_Permiso:
#		
#			#Cultura		
#			|	Permiso					| Nivel_Permiso |
#			| encuesta_clima	| Modificación	|
#			| encuesta_libre	| Modificación  |
#			| mural	 					| Modificación  |
#			| recognitions		| Modificación  |
#		
#		And la Pestaña de Información con Permiso y Nivel_Permiso:
#		
#			#Información
#			|	Permiso						| Nivel_Permiso |
#			| importador_masivo	| Si						|
#			| reportes					| Si  					|
#			| exportadores	 		| Si 						|
#	
  #	Then presionamos el boton guardar
  #	And se crea el perfil exitosamente

 @smoketest
 Scenario: Se crea perfil de RRHH
  Given seleccionar el boton Administracion
  When crear perfil "Perfil Automation RRHH"
  And asignamos los permisos para "Administracion":
  
  #Gestion de Empleados
			| Permiso								| Nivel_Permiso		| 
			| empleados							| Modificación	  |
			| documentos_empleado		| Lectura	  			|
			| jobs									| Modificación	  |
			| asistencia						| Modificación	  |
			| suspension						| Modificación	  |
			| vacation							| Modificación	  |
			| vacation_approval			| Modificación	  |
			| workflow							| Modificación	  |
			| requirement						| No	  					|
			| requirement_approval	| No	  					|
			| bloqueo_persona				| Modificación	  |
			| amonestaciones				| Modificación	  |
			| vacation_configuration| Modificación		|
			#Remuneraciones
			| admin_items						| Modificación	  |
			| assign_items					| Solicitar		  	|
			| processes							| Modificación	  |
			| piecework_admin				| Modificación	  |
			| piecework_worklog			| Modificación		|
			#Boleta Honorarios
			| fee_services					| Modificación  |
			| boletas_honorario			| Modificación  |
			#Configuración Sistema
			| historial							| No  |
			| roles									| Si  |
			| structure_areas				| Si  |
			| document_template			| Si  |
			| custom_attributes			| Si  |
			| cost_center						| No  |
			| cuentas_contables			| No  |
			| users_and_profiles		| Si  |
			| grant_support_access	| Si  |
			| configuracion_sistema	| Si  |
		
	And seleccionamos "talento"
	And asignamos los permisos:
		
			#Desempeño
			| Permiso			 | Nivel_Permiso |
			| metas			 	 | No  |
			| evaluacion	 | No  |
			| feedback		 | No  |
			| action_plans | No  |
			| calibrations | No  |
			| logbooks	 	 | No  |
			#Talento
			| seleccion		 | No  |
			| onboarding	 | No	 |
			
	And seleccionamos "capacitaciones"
	And asignamos los permisos:
			
			#Capacitaciones
			| Permiso			 | Nivel_Permiso |
			| courses			 | No |
			
	And seleccionamos "cultura"
	And asignamos los permisos:
			
			#Cultura
			| Permiso			 			| Nivel_Permiso |
			| encuesta_clima    | No |
			| encuesta_libre 	  | No |
			| mural			 				| No |
			| recognitions			| Modificación |
			| benefits			 		| No |
			| benefit_requests  | Moficación |
			
	And seleccionamos "informacion"
	And asignamos los permisos:
			
			#Información
			| Permiso			 				 | Nivel_Permiso |
			| importador_masivo    | Si |
			| reportes 	  				 | No |
			| exportadores 	  		 | No |
	
  Then se creo correctamente el perfil "Perfil Automation RRHH"
  
 @smoketest
 Scenario: Se crea perfil de Talento
  Given seleccionar el boton Administracion
  When crear perfil "Perfil Automation Talento"
  And asignamos los permisos para "Administracion":
  
  #Gestion de Empleados
			| Permiso								| Nivel_Permiso		| 
			| empleados							| Modificación	  |
			| documentos_empleado		| Modificación	  |
			| jobs									| Modificación	  |
			| asistencia						| Modificación	  |
			| suspension						| Modificación	  |
			| vacation							| Modificación	  |
			| vacation_approval			| Modificación	  |
			| workflow							| Modificación	  |
			| requirement						| No	  					|
			| requirement_approval	| No	  					|
			| bloqueo_persona				| Modificación	  |
			| amonestaciones				| Modificación	  |
			| vacation_configuration| No							|
			#Remuneraciones
			| admin_items						| No	|
			| assign_items					| No	|
			| processes							| No	|
			| piecework_admin				| No	|
			| piecework_worklog			| No	|
			#Boleta Honorarios
			| fee_services					| No  |
			| boletas_honorario			| No  |
			#Configuración Sistema
			| historial							| No  |
			| roles									| No  |
			| structure_areas				| No  |
			| document_template			| No  |
			| custom_attributes			| No  |
			| cost_center						| No  |
			| cuentas_contables			| No  |
			| users_and_profiles		| No  |
			| grant_support_access	| No  |
			| configuracion_sistema	| No  |
		
	And seleccionamos "talento"
	And asignamos los permisos:
		
			#Desempeño
			| Permiso			 | Nivel_Permiso |
			| metas			 	 | Modificación  |
			| evaluacion	 | Modificación  |
			| feedback		 | Modificación  |
			| action_plans | Modificación  |
			| calibrations | Modificación  |
			| logbooks	 	 | No  |
			#Talento
			| seleccion		 | No  |
			| onboarding	 | No	 |
			
	And seleccionamos "capacitaciones"
	And asignamos los permisos:
			
			#Capacitaciones
			| Permiso			 | Nivel_Permiso |
			| courses			 | Lectura |
			
	And seleccionamos "cultura"
	And asignamos los permisos:
			
			#Cultura
			| Permiso			 			| Nivel_Permiso |
			| encuesta_clima    | Modificación  |
			| encuesta_libre 	  | Modificación  |
			| mural			 				| Modificación  |
			| recognitions			| No |
			| benefits			 		| Modificación  |
			| benefit_requests  | Modificación	|
			
	And seleccionamos "informacion"
	And asignamos los permisos:
			
			#Información
			| Permiso			 				 | Nivel_Permiso |
			| importador_masivo    | No |
			| reportes 	  				 | No |
			| exportadores 	  		 | No |
	
  Then se creo correctamente el perfil "Perfil Automation Talento"
