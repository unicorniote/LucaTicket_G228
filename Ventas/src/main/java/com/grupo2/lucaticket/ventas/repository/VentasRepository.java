package com.grupo2.lucaticket.ventas.repository;

import com.grupo2.lucaticket.ventas.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz para la ejecuccion de consultas de la BBDD sobre la tabla de ventas
 *
 * @author Grupo 2 - Alonso
 * @version 1.0 : 11/10/2022
 */
public interface VentasRepository extends JpaRepository<Venta, Integer> {
}
