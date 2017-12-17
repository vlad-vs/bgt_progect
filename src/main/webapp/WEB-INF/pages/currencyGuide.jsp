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
        <label for="shortItem">Short name</label>
        <input type="text" class="form-input-item" id="shortItem" name="shortItem" placeholder="">
    </div>

    <div class="form-group">
        <label for="fullItem">Full name</label>
        <input type="text" class="form-input-item" id="fullItem" name="fullItem" placeholder="">
    </div>


    <input type="submit" class="btn btn-primary" value="Add" formaction="/addCurrencyGuideItem"/>

</form>


<table class="table">
    <tr class="table-head">
        <td>Item</td>
        <td>Full item name</td>
    </tr>


    <form class="" method="post">

    <c:forEach var="list" items="${list}">
        <tr class="table-light">

            <td>${list.shortCurrencyName}</td>
            <td>${list.currencyName}</td>

            <td>
                    <input type="submit" value="del" formaction="/currencyGuide/del/${list.idCurrency}"/>
            </td>

            <td>
                    <input type="submit" value="up" formaction="/currencyGuide/update/${list.idCurrency}:${list.shortCurrencyName}:${list.shortCurrencyName}"/>
            </td>
        </tr>
    </c:forEach>
    </form>

</table>

</body>
</html>