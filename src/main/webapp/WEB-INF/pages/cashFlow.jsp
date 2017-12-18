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

<form action="/addCashFlowItem" method="post">

    <div class="form-group-cfItems">
        <label for="ParentName">Группа:</label>
        <input type="text" autocomplete="off" name="fItemName"  class="form-input-item" id="ParentName" placeholder="" list="pname">
        <datalist id="pname">
            <select>
                <option>none</option>
                <c:forEach var="unitName" items="${list}">
                    <option value="${unitName.cashFlowItem}">${unitName.cashFlowItem}</option>
                </c:forEach>
            </select>
        </datalist>
    </div>

    <div class="form-group-cfItems">
        <label for="kodItem">Kod</label>
        <input type="text" class="form-input-id" id="kodItem" name="kodItem">
    </div>

    <div class="form-group-cfItems">
        <label for="item">Item</label>
        <input type="text" class="form-input-item" id="item" name="item" placeholder="">
    </div>

    <div class="form-group-cfItems">
        <label class="form-check-label" for="level"> Down level </label>
        <input type="checkbox" class="form-check-input" id="level" name="level">
    </div>

    <input type="submit" class="btn btn-primary" value="Save"/>

    <%--<input type="submit" class="btn btn-primary" value="Delete" formaction="/delCashFlowItem/"/>--%>

</form>

<table class="table">
    <tr class="table-head">
        <td>Kod</td>
        <td>Item</td>
        <td>Lavel (Down)</td>
    </tr>
    <c:forEach var="list" items="${list}">
        <tr class="table-light">
            <form method="post">
                <td><input type="text" class="form-input-id" name="fKod"
                           value="${list.fasadKodCashFlowItem}"/></td>
                <td><input type="text" class="form-input-item" name="name"
                           value="${list.cashFlowItem}"/></td>
                <td><input type="checkbox" class="form-check-input" name="l"
                           value="${list.cashFlowItemLevel}"/></td>
                <td>
                    <input type="submit" value="up" formaction="/cashFlow/up/${list.idCf}"/>
                </td>
            </form>

            <form method="post">
                <td>
                    <input type="submit" value="del" formaction="/cashFlow/del/${list.idCf}/"/>
                </td>
            </form>

        </tr>
    </c:forEach>
</table>

</body>
</html>