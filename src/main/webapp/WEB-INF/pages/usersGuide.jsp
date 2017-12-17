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

<a href="/">Back</a>
<h1>Справочник пользователей</h1>

<form class="sigh-in-form" method="post">

    <div class="form-group">
        <label for="UserName">User name</label>
        <input type="text" class="form-input-item" id="UserName" name="UserName" placeholder="">
    </div>

    <div class="form-group">
        <label for="UserSecondName">User family</label>
        <input type="text" class="form-input-item" id="UserSecondName" name="UserSecondName" placeholder="">
    </div>

    <div class="form-group">
        <label for="UserPassword">Password</label>
        <input type="password" class="form-input-item" id="UserPassword" name="UserPassword" placeholder="****">
    </div>
        <input type="submit" class="btn btn-primary" value="Add/Refresh" formaction="/addRefreshUser"/>
        <%--<input type="submit" class="btn btn-primary" value="Delete" formaction="/delUser"/>--%>
</form>

<table class="table">
    <tr class="table-head">
        <td>User name</td>
        <td>User family</td>
        <td>Password</td>
        <td>Delete</td>
    </tr>
    <c:forEach var="list" items="${list}">
        <tr class="table-light">
            <td>${list.name}</td>
            <td>${list.secondName}</td>
            <td>${list.password}</td>
            <td>
                <form  method="post">
                    <input type="submit" value="del" formaction="/delUser/${list.idUser}">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>