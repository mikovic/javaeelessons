package com.minakov.persist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
@ApplicationScoped
@Named
public class CategoryRepository {

    private static final Logger logger = LoggerFactory.getLogger(CategoryRepository.class);
    @Inject
    private ServletContext sc;
    Connection conn;


    @PostConstruct
    public void init() throws SQLException {
        String jdbcConnectionString = sc.getInitParameter("jdbcConnectionString");
        String username = sc.getInitParameter("username");
        String password = sc.getInitParameter("password");

        try {
            this.conn = DriverManager.getConnection(jdbcConnectionString, username, password);

        } catch (SQLException ex) {
            logger.error("", ex);
        }


    }

    public Catalog getCatalog() throws SQLException {
        Catalog catalog = new Catalog();
        Category category = null;
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select cat.id, cat.category from catalog cat" );

            while (rs.next()) {
                category= new Category(rs.getInt(1), rs.getString(2));

                catalog.addCategory(category);
            }
        }
        return catalog;
    }


}
