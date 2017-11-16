<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/cash.css">
</head>
<body>

<h1>Справочник пользователей</h1>

<table class="table">
    <tr class="table-head">
        <td>ID</td>
        <td>User name</td>
        <td>User family</td>
        <td>Password</td>
    </tr>
    <c:forEach var="list" items="${list}">
        <tr class="table-light">
            <td>${list.id}</td>
            <td>${list.name}</td>
            <td>${list.secondName}</td>
            <td>${list.password}</td>
        </tr>
    </c:forEach>
</table>

<form class="sigh-in-form">
    <div class="form-group">
        <label for="itemId">User ID</label>
        <input type="text" class="form-input-id" id="itemId" value="itemId" name="itemId" aria-describedby="emailHelp"
               placeholder="">
    </div>

    <div class="form-group">
        <label for="UserName">User name</label>
        <input type="text" class="form-input-item" id="UserName" value="UserName" name="UserName" placeholder="">
    </div>

    <div class="form-group">
        <label for="UserFamyli">User family</label>
        <input type="text" class="form-input-item" id="UserFamyli" value="UserFamyli" name="UserFamyli" placeholder="">
    </div>

    <div class="form-group">
        <label for="UserPassword">Password</label>
        <input type="password" class="form-input-item" id="UserPassword" value="UserPassword" name="UserPassword" placeholder="****">
    </div>

    <div class="form-group">
        <label class="form-check-label">
            <input type="checkbox" class="form-check-input">
            Down level
        </label>
    </div>

    <form class="button" action="/addUser" method="get">
        <button type="submit" class="btn btn-primary">Add/Refresh</button>
    </form>

    <form class="button" action="/delUser" method="get">
        <button type="submit" class="btn btn-primary">Delete</button>
    </form>
</form>

</body>
</html>