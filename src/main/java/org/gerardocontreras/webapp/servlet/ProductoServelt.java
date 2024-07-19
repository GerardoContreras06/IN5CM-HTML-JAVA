package org.gerardocontreras.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/producto-servlet/")
@MultipartConfig
public class ProductoServelt extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        
        ArrayList<String> producto = new ArrayList<>();
        
        String nombreProducto = req.getParameter("nombreProducto");
        String descripcionProducto = req.getParameter("descripcionProducto");
        String marcaProducto = req.getParameter("marcaProducto");
        double precioProducto = Double.parseDouble(req.getParameter("precioProducto"));
        
        producto.add(nombreProducto);
        producto.add(descripcionProducto);
        producto.add(marcaProducto);
        producto.add(Double.toString(precioProducto));
        
        req.setAttribute("producto", producto);
        getServletContext().getRequestDispatcher("/formulario-productos/formulario-productos.jsp").forward(req, resp);
    }
    
}
