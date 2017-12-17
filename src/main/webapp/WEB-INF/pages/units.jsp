<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>Справочник подразделений</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/unitPage.css">
</head>
<body>


<header>
    <a href="/">Меню</a>

    <h1>Справочник подразделений компании</h1>
</header>


<form class="sigh-in-form" method="post">

    <div class="form-group-units">
        <label for="ParentName">Группа:</label>
        <input type="text" autocomplete="off" name="ParentName"  class="form-input-item" id="ParentName" placeholder="" list="pname">
        <datalist id="pname">
            <select>
                <option>none</option>
                <c:forEach var="unitName" items="${unitNames}">
                    <option value="${unitName.name}">${unitName.name}</option>
                </c:forEach>
            </select>
        </datalist>
    </div>

    <div class="form-group-units">
        <label for="UnitKod">Код подразделения:</label>
        <input type="text" class="form-input-item" id="UnitKod" name="UnitKod" placeholder="">
    </div>

    <div class="form-group-units">
        <label for="UnitName">Подразделение:</label>
        <input type="text" class="form-input-item" id="UnitName" name="UnitName" placeholder="">
    </div>


    <input type="submit" class="btnSaveItem" value="Save" formaction="/addUnit"/>
    <%--<input type="submit" class="btn btn-primary" value="Delete" formaction="/delUser"/>--%>
</form>

<table class="table">
    <tr class="table-head">
        <td>Код</td>
        <td>Подразделение</td>
    </tr>
    <c:forEach var="list" items="${list}">
        <tr class="table-light">
            <form method="post">
                <td><input type="text" name="fKod" value="${list.fKod}"></td>
                <td><input type="text" name="Name" value="${list.name}"></td>
                <td><input class="btnUpItem" type="submit" value="up" formaction="/unit/up/${list.id}"></td>
            </form>

            <form method="post">
                <td>
                    <input class="btnDelItem" type="submit" value="del" formaction="/unit/del/${list.id}">
                </td>
            </form>
        </tr>
    </c:forEach>
</table>


</body>
</html>
