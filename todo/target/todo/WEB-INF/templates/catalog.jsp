<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<%@ include file="head.jsp"%>

<body>

<%@ include file="header.jsp"%>

<div class="container">

        <div class="row">
        <c:forEach var="todo" items="${requestScope.todos}">
            <%-- for (ToDo toDo : (List<ToDo>) request.getAttribute("todos")) { --%>
        <div class="col-md-4">

            <div class="card">
                <img src="..." class="card-img-top" alt="${todo.description}">
                <div class="card-body">
                    <h5 class="card-title"><c:out value="${todo.id}"/></h5>
                    <p><c:out value="${todo.description}"/></p>
                    <c:url value="/show" var="todoShowUrl">
                        <c:param name="id" value="${todo.id}"/>
                    </c:url>
                    <p><a class="btn btn-secondary" href="${todoShowUrl}" role="button">View details &raquo;</a></p>
                </div>
            </div>

        </div>
        </c:forEach>


        </div>
    </div>


<%@ include file="footer-scripts.jsp" %>

</html>