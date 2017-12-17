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
<form class="sigh-in-form" method="post">
<table class="table">
    <tr class="table-head">
        <td>ID</td>
        <td>User name</td>
        <td>User family</td>
        <td>Password</td>
    </tr>
    <c:forEach var="list" items="${list}">
        <tr class="table-light">
            <td><input type="text" class="form-input-id" id="itemId" name="itemId" aria-describedby="emailHelp" value="${list.id}"></td>
            <td><input type="text" class="form-input-item" id="UserName" name="UserName" value="${list.name}" placeholder=""></td>
            <td><input type="text" class="form-input-item" id="UserSecondName" name="UserSecondName" value="${list.secondName}" placeholder=""></td>
            <td><input type="password" class="form-input-item" id="UserPassword" name="UserPassword" value="${list.password}" placeholder="****"></td>
        </tr>
    </c:forEach>
</table>

    <div class="form-group">
        <label class="form-check-label">
            <input type="checkbox" class="form-check-input">
            Down level
        </label>
    </div>

        <input type="submit" class="btn btn-primary" value="Add/Refresh" formaction="/addRefreshUser"/>

        <input type="submit" class="btn btn-primary" value="Delete" formaction="/delUser"/>

</form>

</body>
</html>