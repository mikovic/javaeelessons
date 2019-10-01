package ru.mikovic.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet  extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(CartServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New GET request");
        String nessage = "Ваша корзина";
        req.setAttribute("message", nessage);
        getServletContext().getRequestDispatcher("/default.jsp").forward(req,
                resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New POST request");


    }


}

