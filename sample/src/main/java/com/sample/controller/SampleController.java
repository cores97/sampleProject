package com.sample.controller;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.dto.StringResponse;

@RestController 
public class SampleController {
	

		JSONObject obj = new JSONObject();
		
		/**
		 * Método que se utiliza cuando se entre en el servidor con la ruta '/defaultHello', el método de trasferencia es GET y 
		 * en la ausencia de parámetros hay un mensaje por defecto.
		 * 
		 * @param mensaje
		 * @return 'Default Hello Word' o parámetro por GET
		 */
		@SuppressWarnings("unchecked")
		@RequestMapping(value = "/defaultHello", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
		public JSONObject defaultHello(@RequestParam(name = "message", required=false, defaultValue="Default Hello World!") StringResponse mensaje) {
			
			String msgFalse = "False Message";
			
			if(mensaje.getEcho().equals(msgFalse)) {
				mensaje.setEcho("Default Hello World!");
			}
			//La respuesta se carga en un objeto JSON
			obj.put("echo", mensaje.getEcho());
			return obj;
		}
		
		/**
		 * Método que se utiliza cuando se entre en el servidor con la ruta '/customHello', el método de trasferencia es POST y 
		 * en la ausencia de parámetros dará error ya que el parametro en obligatorio.
		 * 
		 * @param mensaje
		 * @return 'Custom ' mas mensaje
		 */
		@SuppressWarnings("unchecked")
		@RequestMapping(value = "/customHello", method = { RequestMethod.GET, RequestMethod.POST }, headers = "Accept=application/json")
		public JSONObject customHello(@RequestParam(name = "message", required=true) StringResponse mensaje) {
			
			StringResponse customResponse;
			
			customResponse = new StringResponse("Custom "+ mensaje.getEcho());
			
			//La respuesta se carga en un objeto JSON
			obj.put("echo", customResponse.getEcho());
			return obj;
			
		}

}
