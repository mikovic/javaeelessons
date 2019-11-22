package com.minakov.restservice;

import com.minakov.persist.ToDo;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Local
@Path("todo")
public interface ToDoServiceRest {
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    List<ToDo> findAll();
    @POST
    @Path("save")
    void insert(ToDo todo);
    @GET
    @Path("delete")
    public void delete(ToDo todo);
    @GET
    @Path("find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ToDo findById(@PathParam("id") Long id);
    @GET
    @Path("allFromCategory/{categoryId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ToDo> findByCategoryId(@PathParam("categoryId")int categoryId);
    @GET
    @Path("desc/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ToDo> findByName(@PathParam("name")String name);
}
