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
<h1>Standart BGT</h1>

<div class="form-group">
    <span for="year">Год планирования</span>
    <select title="Выбери год">
        <c:forEach var="year" items="${listYears}">
            <option>${year.year}</option>
        </c:forEach>
    </select>
</div>

<div class="form-group">
    <span for="bgtName">Название бюджета</span>
    <select title="Выбери бюджет">
        <c:forEach var="bgtName" items="${bgtNames}">
            <option>${bgtName.bgtName}</option>
        </c:forEach>
    </select>
</div>




</body>
</html>