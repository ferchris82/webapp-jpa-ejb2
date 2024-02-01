package org.chrisferdev.apiservlet.webapp.headers.listeners;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class AplicacionListener implements ServletContextListener,
        ServletRequestListener, HttpSessionListener {

    private ServletContext servletContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("inicializando la aplicación!");
        servletContext = sce.getServletContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        servletContext.log("destruyendo la aplicación!");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        servletContext.log("inicializando el request!");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        servletContext.log("destruyendo el request!");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        servletContext.log("inicializando la sesión http");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        servletContext.log("destruyendo la sesión http");
    }
}
