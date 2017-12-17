<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
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

<h1>Справочник статей движения денежных средств</h1>

<form class="sigh-in-form" method="post">
    <div class="form-group">
        <label for="kodItem">Kod</label>
        <input type="text" class="form-input-id" id="kodItem" name="kodItem">
    </div>

    <div class="form-group">
        <label for="item">Item</label>
        <input type="text" class="form-input-item" id="item" name="item" placeholder="">
    </div>

    <div class="form-group">
        <label class="form-check-label" for="level"> Down level </label>
        <input type="checkbox" class="form-check-input" id="level" name="level">
    </div>

    <input type="submit" class="btn btn-primary" value="Add" formaction="/addCashFlowItem"/>

    <%--<input type="submit" class="btn btn-primary" value="Delete" formaction="/delCashFlowItem/"/>--%>

</form>

<table class="table">
    <tr class="table-head">
        <td>Kod</td>
        <td>Item</td>
        <td>Lavel (Down)</td>
        <td>Delete</td>
    </tr>
    <c:forEach var="list" items="${list}">
        <tr class="table-light">
            <form method="post" commandName="list">
            <td><input type="text" class="form-input-id" id="kodItemNew" name="kodItemNew" value="${list.kodCashFlowItem}"/></td>
            <td><input type="text" class="form-input-item" id="itemNew" name="itemNew" value="${list.cashFlowItem}"/></td>
            <td><input type="checkbox" class="form-check-input" id="levelNew" name="levelNew" value="${list.cashFlowItemLevel}"/></td>
            <td>
                    <input type="submit" value="del" formaction="/cashFlowGuide/del/${list.idCf}"/>
            </td>
            </form>
            <td>
                <form method="post">
                    <input type="submit" value="up" formaction="/cashFlowGuide/up/${list.idCf}/"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>