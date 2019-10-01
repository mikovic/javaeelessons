package ru.mikovic.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ErrorHandler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer statusCode = (Integer)
                req.getAttribute("javax.servlet.error.status_code");
        req.setAttribute("message", statusCode);
        getServletContext().getRequestDispatcher("/error-page.jsp").forward(req,
                resp);
    }
}
