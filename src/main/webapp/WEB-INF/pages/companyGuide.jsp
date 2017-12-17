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
<h1>Справочник бюджетируемых компаний</h1>

<form class="sigh-in-form" method="post">

    <div class="form-group">
        <label for="kodItem">Kod</label>
        <input title="Код" type="text" class="form-input-item" id="kodItem" name="kodItem" placeholder="">
    </div>

    <div class="form-group">
        <label for="item">Company name</label>
        <input title="Код" type="text" class="form-input-item" id="item" name="item" placeholder="">
    </div>

    <input type="submit" class="btn btn-primary" value="Add" formaction="/addCompanyGuideItem"/>

</form>


<table class="table">
    <tr class="table-head">
        <td>Kod</td>
        <td>Item</td>
    </tr>

    <form class="" method="post">

    <c:forEach var="list" items="${list}">
        <tr class="table-light">

            <td>${list.kodCompany}</td>

            <td>${list.nameCompany}</td>

            <td>
                    <input type="submit" value="del" formaction="/yearGuide/del/${list.idCompany}"/>
            </td>

            <%--<td>--%>
                    <%--<input type="submit" value="up" formaction="/currencyGuide/update/${list.id}:${list.year}"/>--%>
            <%--</td>--%>
        </tr>
    </c:forEach>
    </form>

</table>

</body>
</html>