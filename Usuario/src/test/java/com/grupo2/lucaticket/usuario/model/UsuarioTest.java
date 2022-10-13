package com.grupo2.lucaticket.usuario.model;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.grupo2.lucaticket.usuario.model.Usuario;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;




/**
 * @Project LucaTicket
 *
 * @Classname Usuario Test
 *
 * @author Grupo 2 - Carlos Jesúa
 *
 * @date 12/10/2022
 *
 * @since 1.0
 *
 */

@ExtendWith(MockitoExtension.class)
public class UsuarioTest {

    private static Validator validator;

    @Mock
    private Usuario user;

    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void usuarioNoDeberiaSerNull() {
        // WHEN

        // THEN
        assertThat(user).isNotNull();
    }

    @Test
    void longitudNombreLarga() {
        // GIVEN

        // WHEN nombre.longitud es mayor de 100
        user.setNombre(generatorString(101));
        // Pass no puede ser null, si no la validacion dara error
        // Introducimos un pass vacio para que no sea null solo en los test necesarios
        user.setPass("");
        Set<ConstraintViolation<Usuario>> violations = validator.validate(user);

        // THEN hay una violacion de las validaciones
        assertThat(violations.isEmpty()).isFalse();
    }

    @Test
    void longitudApellidoLarga() {
        // GIVEN

        // WHEN apellido.longitud es mayor de 100
        user.setApellido(generatorString(101));
        // Pass no puede ser null, si no la validacion dara error
        // Introducimos un pass vacio para que no sea null solo en los test necesarios
        user.setPass("");
        Set<ConstraintViolation<Usuario>> violations = validator.validate(user);

        // THEN hay una violacion de las validaciones
        assertThat(violations.isEmpty()).isFalse();
    }

    @Test
    void longitudEmailLarga() {
        // GIVEN

        // WHEN email.longitud es mayor de 150
        user.setNombre(generatorString(151));
        // Pass no puede ser null, si no la validacion dara error
        // Introducimos un pass vacio para que no sea null solo en los test necesarios
        user.setPass("");
        Set<ConstraintViolation<Usuario>> violations = validator.validate(user);

        // THEN hay una violacion de las validaciones
        assertThat(violations.isEmpty()).isFalse();
    }

    @Test
    void passEsNull() {
        // WHEN user.pass es null
        user.setPass(null);
        Set<ConstraintViolation<Usuario>> violations = validator.validate(user);

        // THEN hay una violacion de las validaciones
        assertThat(violations.isEmpty()).isFalse();
    }

    @Test
    void passLongitudLarga() {
        // WHEN user.pass.length es mayor de 20
        user.setPass(generatorString(21));
        Set<ConstraintViolation<Usuario>> violations = validator.validate(user);

        // THEN hay una violacion de las validaciones
        assertThat(violations.isEmpty()).isFalse();
    }

    private String generatorString(int length) {
        return "a".repeat(Math.max(0, length));
    }
}
