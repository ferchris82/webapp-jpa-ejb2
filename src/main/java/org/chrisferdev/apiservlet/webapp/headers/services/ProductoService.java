package org.chrisferdev.apiservlet.webapp.headers.services;

import jakarta.ejb.Local;
import org.chrisferdev.apiservlet.webapp.headers.models.entities.Categoria;
import org.chrisferdev.apiservlet.webapp.headers.models.entities.Producto;

import java.util.List;
import java.util.Optional;

@Local
public interface ProductoService {
    List<Producto> listar();

    Optional<Producto> porId(Long id);

    void guardar(Producto producto);

    void eliminar(Long id);

    List<Categoria> listarCategoria();

    Optional<Categoria> porIdCategoria(Long id);
}
