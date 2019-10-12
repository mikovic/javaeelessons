<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <c:url value="/" var="homeUrl"/>
    <c:url value="/catalog" var="catalogUrl"/>
    <c:url value="/new" var="todoNewUrl"/>
    <a class="navbar-brand" href="${homeUrl}">ToDo</a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">

                <a class="nav-link" href="${homeUrl}">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${catalogUrl}">Catalog</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${todoNewUrl}">Add Todo</a>
            </li>
        </ul>
    </div>
</nav>

