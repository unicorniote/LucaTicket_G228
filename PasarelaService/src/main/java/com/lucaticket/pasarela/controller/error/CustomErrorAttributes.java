package com.lucaticket.pasarela.controller.error;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import com.lucaticket.pasarela.utils.FechaUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

	public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
		log.info("------ getErrorAttributes(): " + options);
		Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
		log.info("------ getErrorAttributes(): " + options);

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
