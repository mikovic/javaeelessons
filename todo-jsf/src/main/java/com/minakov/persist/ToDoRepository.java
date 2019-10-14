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
public class ToDoRepository {

    private static final Logger logger = LoggerFactory.getLogger(ToDoRepository.class);

    @Inject
    private ServletContext sc;

    private Connection conn;

    @PostConstruct
    public void init() throws SQLException {
        String jdbcConnectionString = sc.getInitParameter("jdbcConnectionString");
        String username = sc.getInitParameter("username");
        String password = sc.getInitParameter("password");

        try {
            this.conn = DriverManager.getConnection(jdbcConnectionString, username, password);
            createTableIfNotExists(conn);
            createTableCatalogIfNotExists(conn);
            fillTableCatalog(conn);

            if (this.findAll().isEmpty()) {
                this.insert(new ToDo(-1L, "First",1, LocalDate.now()));
                this.insert(new ToDo(-1L, "Second", 1, LocalDate.now().plusDays(1)));
                this.insert(new ToDo(-1L, "Third",1, LocalDate.now().plusDays(2)));
            }
        } catch (SQLException ex) {
            logger.error("", ex);
        }


    }

    public void insert(ToDo toDo) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "insert into todos(description, categoryId, targetDate) values (?, ?, ?)")) {
            stmt.setString(1, toDo.getDescription());
            stmt.setInt(2,toDo.getCategoryId());
            stmt.setDate(3, Date.valueOf(toDo.getTargetDate()), Calendar.getInstance());
            stmt.execute();
        }
    }

    public void update(ToDo toDo) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "update todos set description = ?, categoryId = ?, targetDate = ? where id = ?;")) {
            stmt.setString(1, toDo.getDescription());
            stmt.setInt(2,toDo.getCategoryId());
            stmt.setDate(3, Date.valueOf(toDo.getTargetDate()), Calendar.getInstance());
            stmt.setLong(4, toDo.getId());
            stmt.execute();
        }
    }

    public void delete(long id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "delete from todos where id = ?;")) {
            stmt.setLong(1, id);
            stmt.execute();
        }
    }

    public ToDo findById(long id) throws SQLException {
        ToDo toDo = null;
        try (PreparedStatement stmt = conn.prepareStatement(
                "select t.id, t.description, t.categoryId, t.targetDate,cat.category from todos t left join catalog cat on" +
                        " t.id = ? and t.categoryId = cat.id")) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                toDo =new ToDo(rs.getLong(1), rs.getString(2), rs.getInt(3) , rs.getDate(4, Calendar.getInstance()).toLocalDate());
                toDo.setCategory(rs.getString(5));
                return toDo;
            }
        }
        return new ToDo(-1L, "",  0,null);
    }


    public List<ToDo> findAll() throws SQLException {
        List<ToDo> res = new ArrayList<>();
        ToDo toDo = null;
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select t.id, t.description,  t.categoryId, t.targetDate, cat.category from todos t left join catalog cat on "+
                    " t.categoryId = cat.id group by t.id" );

            while (rs.next()) {
                toDo = new ToDo(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getDate(4, Calendar.getInstance()).toLocalDate());
                toDo.setCategory(rs.getString(5));
                res.add(toDo);
            }
        }
        return res;
    }


    private void createTableIfNotExists(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("create table if not exists todos (\n" +
                    "\tid int auto_increment primary key,\n" +
                    "    description varchar(25),\n" +
                    "    categoryId int,\n" +
                    "    targetDate date \n" +
                    ");");
        }
    }

    private void createTableCatalogIfNotExists(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("create table if not exists catalog (\n" +
                    "\tid int,\n" +
                    "    category varchar(25)\n" +

                    ");");
        }
    }
    private void fillTableCatalog(Connection conn) throws SQLException {

        try (PreparedStatement stmt = conn.prepareStatement(
                "insert into catalog(id, category) values (?,?)")) {
            stmt.setInt(1,1 );
            stmt.setString(2,"category1" );
            stmt.execute();
            stmt.setInt(1,2 );
            stmt.setString(2,"category2");
            stmt.execute();
            stmt.setInt(1,2 );
            stmt.setString(2,"category3");
        }

    }

    public void addToBasket(Long id) {

    }
}





