<%--
  Created by IntelliJ IDEA.
  User: Masha
  Date: 27.09.2019
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="style.css"/>
</head>
<body>
<div class="container">
    <jsp:include page = "header.jsp" flush = "true"/>

<div class ="content">
    <jsp:include page = "menu.jsp" flush = "true"/>
    <div class="page">
    <p>${message}</p>
</div>

</div>

</body>
</html>
