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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/cashFlow.css">
</head>

<body>

<header class="header">
    <a href="/">Back</a>

    <h1>Справочник статей баланса</h1>
</header>


<form action="/addBalance" method="post">

    <div class="form-group-cfItems">
        <label for="ParentName">Группа:</label>
        <input type="text" autocomplete="off" name="fItemName" class="form-input-item" id="ParentName" placeholder=""
               list="pname">
        <datalist id="pname">
            <select>
                <option>none</option>
                <c:forEach var="unitName" items="${list}">
                    <option value="${unitName.balanceItem}">${unitName.balanceItem}</option>
                </c:forEach>
            </select>
        </datalist>
    </div>

    <div class="form-group-cfItems">
        <label for="kodItem">Код:</label>
        <input type="text" class="form-input-id" id="kodItem" name="kodItem">
    </div>

    <div class="form-group-cfItems">
        <label for="item">Сатья:</label>
        <input type="text" class="form-input-item" id="item" name="item" placeholder="">
    </div>

    <input type="submit" class="btnSaveItem" value="Save"/>

    <%--<input type="submit" class="btn btn-primary" value="Delete" formaction="/delCashFlowItem/"/>--%>

</form>

<table class="table">
    <tr class="table-head">
        <td>Код</td>
        <td>Статья</td>
    </tr>
    <c:forEach var="list" items="${list}">
        <tr class="table-light">
            <form method="post">
                <td><input type="text" class="form-input-table" name="fKod" value="${list.fasadKodBlItem}"/></td>
                <td><input type="text" class="form-input-table" name="name" value="${list.balanceItem}"/></td>
                <td>
                    <input class="btnUpItem" type="submit" value="up" formaction="/balance/up/${list.idBl}"/>
                </td>
            </form>

            <form method="post">
                <td>
                    <input class="btnDelItem" type="submit" value="del" formaction="/balance/del/${list.idBl}/"/>
                </td>
            </form>

        </tr>
    </c:forEach>
</table>

</body>
</html>