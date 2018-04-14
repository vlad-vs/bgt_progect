<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/index.css">
</head>
<body>

<header class="header">
    <h1>Budgeting of the company "Hello world"</h1>
</header>

<div class="wrapper">

    <div class="guides">
        <ul>
            <li class="wrapButtonGuide"><a class="buttonGuide" href="/users">Users</a></li>
            <li class="wrapButtonGuide"><a class="buttonGuide" href="/year">Years</a></li>
            <li class="wrapButtonGuide"><a class="buttonGuide" href="/currency">Currency</a></li>
            <li class="wrapButtonGuide"><a class="buttonGuide" href="/units">Units</a></li>
            <li class="wrapButtonGuide"><a class="buttonGuide" href="/bgt">Bgt</a></li>
            <li class="wrapButtonGuide"><a class="buttonGuide" href="/cashFlow">Cash flow items</a></li>
            <li class="wrapButtonGuide"><a class="buttonGuide" href="/balance">Balance guide</a></li>
            <li class="wrapButtonGuide"><a class="buttonGuide" href="/profitAndLoss">Profit and loss</a></li>
            <li class="wrapButtonGuide"><a class="buttonGuide" href="/operationToPlAndCf">Operation</a></li>
        </ul>
    </div>
</div>
<br>
<a href="/standartBgt">Standart bgt</a>


</body>
</html>