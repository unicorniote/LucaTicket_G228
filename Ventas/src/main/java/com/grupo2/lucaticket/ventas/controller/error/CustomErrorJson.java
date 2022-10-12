package com.grupo2.lucaticket.ventas.controller.error;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;


@Data
public class CustomErrorJson {
	private String timestamp;
	private int status;
	private String error;
	private String trace;
	private List<String> message;
	private String path;
	private String jdk;
	private String ruta;
	
	public CustomErrorJson() {
		super();
		this.timestamp = "";
		this.status = 0;
		this.error = "";
		this.trace = "";
		this.message = new ArrayList<>();
		this.ruta= "";
		this.jdk = "ND";
	}

	public CustomErrorJson(int status, String error, String trace, List<String> message, String path,
			String jdk) {
		super();
	
		this.status = status;
		this.error = error;
		this.trace = trace;
		this.message = message;
		this.ruta = ruta;
		this.jdk = jdk;
	}

	public void setMensaje(List<String> mensajes) {
		// TODO Auto-generated method stub
		
	}

	
}
