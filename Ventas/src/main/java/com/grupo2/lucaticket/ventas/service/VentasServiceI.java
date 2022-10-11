package com.grupo2.lucaticket.ventas.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo2.lucaticket.ventas.model.Venta;
/**
* @Project LucaTicket
*
* @Classname VentasService
*
* @author Lamia
* 
* @date 11/10/2022
*
* @since 1.0
*
*/

@Transactional
@Service
public interface VentasServiceI {

	public Venta addVenta (Venta venta);
}
/**
* Método para crear una venta
* 
* @return venta
* 
* @author Grupo 2 - Lamia
* 
* @version 1.0
*/