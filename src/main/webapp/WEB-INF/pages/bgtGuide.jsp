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
<h1>Справочник бюджетов</h1>

<form class="sigh-in-form" method="post">

    <div class="form-group">
        <label for="kodItemBgt">Kod</label>
        <input type="text" class="form-input-item" id="kodItemBgt" name="kodItemBgt" placeholder="">
    </div>

    <div class="form-group">
        <label for="bgtName">Name</label>
        <input type="text" class="form-input-item" id="bgtName" name="bgtName" placeholder="">
    </div>

    <input type="submit" class="btn btn-primary" value="Add" formaction="/addBgtGuideItem"/>

</form>


<table class="table">
    <tr class="table-head">
        <td>Kod</td>
        <td>Name</td>
    </tr>

    <form class="" method="post">

    <c:forEach var="list" items="${list}">
        <tr class="table-light">

            <td>${list.kodBgt}</td>

            <td>${list.bgtName}</td>

            <td>
                    <input type="submit" value="del" formaction="/yearGuide/del/${list.idBgt}"/>
            </td>

            <td>
                    <input type="submit" value="up" formaction="/currencyGuide/update/${list.idBgt}:${list.kodBgt}:${list.bgtName}"/>
            </td>
        </tr>
    </c:forEach>
    </form>

</table>

</body>
</html>