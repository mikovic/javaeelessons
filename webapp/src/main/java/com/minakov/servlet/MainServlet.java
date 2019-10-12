package com.minakov.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MainServlet", urlPatterns = "/main")
public class MainServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(MainServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New GET request");
        resp.setHeader("Conent-Type", "text-html; charset = utf-8");
//        getServletContext().getRequestDispatcher("/header.jsp").include(req,
//                resp);
        String nessage = "Main Page";
        req.setAttribute("message", nessage);
        getServletContext().getRequestDispatcher("/default.jsp").forward(req,
                resp);

//        getServletContext().getRequestDispatcher("/menu.html").include(req,
//                resp);






    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New POST request");


    }


    }


