package com.minakov.listener;

import com.minakov.persist.ToDo;
import com.minakov.persist.ToDoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

@WebListener
public class ContextListener implements ServletContextListener {

    public static final String DB_CONNECTION = "dbConnection";
    public static final String TODO_REPO = "toDoRepo";

    private static final Logger logger = LoggerFactory.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("Initializing application");

        ServletContext sc = sce.getServletContext();
        String jdbcConnectionString = sc.getInitParameter("jdbcConnectionString");
        String username = sc.getInitParameter("username");
        String password = sc.getInitParameter("password");

        try {
            Connection conn = DriverManager.getConnection(jdbcConnectionString, username, password);
            sc.setAttribute(DB_CONNECTION, conn);

            ToDoRepository toDoRepository = new ToDoRepository(conn);
            sc.setAttribute(TODO_REPO, toDoRepository);

            if (toDoRepository.findAll().isEmpty()) {
                toDoRepository.insert(new ToDo(-1L, "First", LocalDate.now()));
                toDoRepository.insert(new ToDo(-1L, "Second", LocalDate.now().plusDays(1)));
                toDoRepository.insert(new ToDo(-1L, "Third", LocalDate.now().plusDays(2)));
                toDoRepository.insert(new ToDo(-1L, "Forth", LocalDate.now().plusDays(4)));
            }
        } catch (SQLException ex) {
            logger.error("", ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
