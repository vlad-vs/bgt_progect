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
<h1>Справочник статей отчета оприбыли и убытках</h1>

<form class="sigh-in-form" method="post">

    <div class="form-group">
        <label for="item">Year</label>
        <input pattern="[0-9]{4}" title="Год цифрами" type="text" class="form-input-item" id="item" name="item" placeholder="">
    </div>

    <input type="submit" class="btn btn-primary" value="Add" formaction="/addYearItem"/>

</form>


<table class="table">
    <tr class="table-head">
        <td>Item</td>
    </tr>

    <form class="" method="post">

    <c:forEach var="list" items="${list}">
        <tr class="table-light">

            <td>${list.year}</td>

            <td>
                    <input type="submit" value="del" formaction="/year/del/${list.idYear}"/>
            </td>

            <td>
                    <input type="submit" value="up" formaction="/currencyGuide/update/${list.idYear}:${list.year}"/>
            </td>
        </tr>
    </c:forEach>
    </form>

</table>

</body>
</html>