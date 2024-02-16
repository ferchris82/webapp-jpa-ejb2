package org.chrisferdev.apiservlet.webapp.headers.services;


import org.chrisferdev.apiservlet.webapp.headers.models.entities.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> login(String username, String password);
}