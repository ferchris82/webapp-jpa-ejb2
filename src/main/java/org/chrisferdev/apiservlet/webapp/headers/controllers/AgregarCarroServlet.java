package org.chrisferdev.apiservlet.webapp.headers.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.chrisferdev.apiservlet.webapp.headers.configs.ProductoServicePrincipal;
import org.chrisferdev.apiservlet.webapp.headers.models.Carro;
import org.chrisferdev.apiservlet.webapp.headers.models.ItemCarro;
import org.chrisferdev.apiservlet.webapp.headers.models.Producto;
import org.chrisferdev.apiservlet.webapp.headers.services.ProductoService;
import org.chrisferdev.apiservlet.webapp.headers.services.ProductoServiceImpl;
import org.chrisferdev.apiservlet.webapp.headers.services.ProductoServiceJdbcImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/carro/agregar")
public class AgregarCarroServlet extends HttpServlet {

    @Inject
    @ProductoServicePrincipal
    private ProductoService service;

    @Inject
    private Carro carro;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Optional<Producto> producto = service.porId(id);
        if (producto.isPresent()) {
            ItemCarro item = new ItemCarro(1, producto.get());
//            HttpSession session = req.getSession();
//            Carro carro = (Carro) session.getAttribute("carro");
            carro.addItemCarro(item);
        }
        resp.sendRedirect(req.getContextPath() + "/carro/ver");
    }
}
