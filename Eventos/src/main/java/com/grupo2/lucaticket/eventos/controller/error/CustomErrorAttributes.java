package com.grupo2.lucaticket.eventos.controller.error;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import com.grupo2.lucaticket.eventos.utils.FechaUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * Clase que se encarga de interceptar los atributos del error producido y
 * pasarlos al formato deseado.
 * 
 * @author Alvaro
 * @version 13/10/2022
 */
@Slf4j
@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

	/**
	 * Método que se encargar de formatear los atributos de los errores producidos.
	 * 
	 * @param WebRequest            webRequest
	 * @param ErrorAttributeOptions options
	 * @return Map<String, Object>
	 * @author Alvaro
	 * @version 1.0
	 */
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {

		log.info("Formateando errores de la excepción...");
		Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);

		Object timestamp = errorAttributes.get("timestamp");
		if (timestamp == null) {
			errorAttributes.put("timestamp", FechaUtils.formatearFecha(LocalDateTime.now()));
		} else {
			errorAttributes.put("timestamp", FechaUtils.formatearFecha((Date) timestamp));
		}

		errorAttributes.remove("trace");

		return errorAttributes;
	}

}
