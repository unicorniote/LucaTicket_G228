package com.grupo2.lucaticket.usuario.repository;

import com.grupo2.lucaticket.usuario.model.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class UsuarioRepositoryITests {

    private static String nombre = "Nombre1", apellido = "Apellido1", email = "Email1", pass = "PassMuyComplicada";
    private LocalDate date = LocalDate.now();

    // GIVEN
    @Mock
    UsuarioRepositoryI repo;

    @Test
    void repoDeberiaNoSerNull() {
       // WHEN

       // THEN
        assertThat(repo).isNotNull();
    }

    @Test
    void saveCorrectUsuario() {
        // WHEN
        Usuario user = new Usuario(0, nombre, apellido, email, pass, date);
        Usuario newUser = repo.save(user);

        // THEN
        assertThat(user).isEqualTo(newUser);
    }

}
