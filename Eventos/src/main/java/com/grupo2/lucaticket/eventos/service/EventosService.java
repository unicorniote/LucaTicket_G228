package com.grupo2.lucaticket.eventos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo2.lucaticket.eventos.model.Evento;
import com.grupo2.lucaticket.eventos.repository.EventosRepositoryI;

/**
 * @Project LucaTicket
 * 
 * @Classname EventosService
 * 
 * @author Grupo 2 - Lamia
 *
 * @date 06/10/2022
 * 
 * @since 1.0
 *
 */

@Service
public class EventosService implements EventosServiceI {

	@Autowired
	private EventosRepositoryI repo;

	/**
	 * Descripción del método: Método que guarda los Eventos
	 * 
	 * @param evento
	 * 
	 * @return repositorio eventos
	 * 
	 * @author Lamia
	 * 
	 * @version 1.0
	 */

	@Override
	public Evento save(Evento evento) {
		return repo.save(evento);

	}

	/**
	 * Método findAll(): Lista todos los eventos existentes
	 *
	 * @return repo.finAll()
	 * @author Grupo 2 - Tamara Alvarez
	 * @version 1.0
	 */

	@Override
	public List<Evento> findAll() {
		return repo.findAll();
	}

	/**
	 * Método deleteById(): Eliminar por Id
	 * 
	 * @param id del usuario de tipo String
	 * 
	 * @author Grupo 2 - Lamia
	 * 
	 * @version 1.0
	 */

	@Override
	public void deleteById(String id) {
		repo.deleteById(id);
	}

	/**
	 * Método findAllByGenero(String genero): Mostrador listado de eventos según el
	 * género
	 * 
	 * @return List<Eventos>
	 * @param String genero
	 * 
	 * @author Grupo 2 - Carlos Jesús
	 * 
	 * @version 1.0
	 */

	public List<Evento> findAllByGenero(String genero) {

		return repo.findAllByGenero(genero);
	}

	/**
	 * Método findByNombre(): Busca un evento por su nombre.
	 * 
	 * @return repo.findeByNombre()
	 * 
	 * @author Grupo 2 - Tamara Alvarez
	 * 
	 * @version 1.0
	 */
	public List<Evento> findByNombre(String nombre) {
		return repo.findByNombre(nombre);
	}

	/**
	 * Método findById(): Busca un evento por id.
	 * 
	 * @return repo.findeByNombre()
	 * 
	 * @author Grupo 2 - Tamara Alvarez
	 * 
	 * @version 1.0
	 */
	@Override
	public Optional<Evento> findById(String id) {
		return repo.findById(id);
	}

	/**
	 * Método findByNombre(): Busca un evento por su nombre.
	 * 
	 * @return repo.findeByNombre()
	 * 
	 * @author Grupo 2 - Tamara Alvarez
	 * 
	 * @version 1.0
	 */
	@Override
	public List<Evento> findAllByCiudad(String ciudad) {
		return repo.findAllByCiudad(ciudad);
	}

	/**
	 * Método Update: Modificar un evento
	 * 
	 * @param evento
	 * 
	 * @author Grupo 2 - Lamia
	 * 
	 * @version 1.0
	 */
	@Override
	public Evento update(Evento evento) {
		return repo.save(evento);

	}

}
