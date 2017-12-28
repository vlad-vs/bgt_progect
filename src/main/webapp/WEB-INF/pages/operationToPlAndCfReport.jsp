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

    <h1>Справочник статей движения денежных средств</h1>
</header>


<form action="/addOperationToPlAndCfReport" method="post">

    <div class="form-group-cfItems">
        <label for="ParentName">Группа:</label>
        <input type="text" autocomplete="off" name="fItemName" class="form-input-item" id="ParentName" placeholder=""
               list="pname">
        <datalist id="pname">
            <select>
                <option>none</option>
                <c:forEach var="operation" items="${operationList}">
                    <option value="${operation.operationItem}">${operation.operationItem}</option>
                </c:forEach>
            </select>
        </datalist>
    </div>

    <div class="form-group-operation">
        <label for="kodItem">Код:</label>
        <input type="text" class="form-input-id" id="kodItem" name="kodItem">
    </div>

    <div class="form-group-operation">
        <label for="item">Operation:</label>
        <input type="text" class="form-input-item" id="item" name="item" placeholder="">
    </div>

    <div class="form-group-operation">
        <%--<label for="pl">PL:</label>--%>
        <%--<input type="text" name="idPl" class="form-input-item" id="pl" placeholder=""--%>
               <%--list="plList">--%>
        <%--<datalist id="plList">--%>
            <select name="idPl">
                <option>none</option>
                <c:forEach var="plItem" items="${plList}">
                    <option value="${plItem.idPl}">${plItem.nameItem}</option>
                </c:forEach>
            </select>
        <%--</datalist>--%>
    </div>


    <div class="form-group-operation">
        <%--<label for="cf">CF:</label>--%>
        <%--<input type="text" name="idCf" class="form-input-item" id="cf" placeholder=""--%>
               <%--list="cfList">--%>
        <%--<datalist id="cfList">--%>
            <select name="idCf">
                <option>none</option>
                <c:forEach var="cfItem" items="${cfList}">
                    <option value="${cfItem.idCf}">${cfItem.cashFlowItem}</option>
                </c:forEach>
            </select>
        <%--</datalist>--%>
    </div>

    <input type="submit" class="btnSaveItem" value="Save"/>

    <%--<input type="submit" class="btn btn-primary" value="Delete" formaction="/delCashFlowItem/"/>--%>

</form>

<table class="table">
    <tr class="table-head">
        <td>Код</td>
        <td>Статья</td>
        <td>PL</td>
        <td>CF</td>

    </tr>
    <c:forEach var="list" items="${operationList}">
        <tr class="table-light">
            <form method="post">
                <td><input type="text" class="form-input-table" name="fKod" value="${list.fasadKodOperationItem}"/></td>
                <td><input type="text" class="form-input-table" name="name" value="${list.operationItem}"/></td>
                <td><input type="text" class="form-check-table" name="level" value="${list.idPl}"/></td>
                <td><input type="text" class="form-check-table" name="level" value="${list.idCf}"/></td>
                <td>
                    <input class="btnUpItem" type="submit" value="up"
                           formaction="/operationToPlAndCfReport/up/${list.idOperation}"/>
                </td>
            </form>

            <form method="post">
                <td>
                    <input class="btnDelItem" type="submit" value="del"
                           formaction="/operationToPlAndCfReport/del/${list.idOperation}/"/>
                </td>
            </form>

        </tr>
    </c:forEach>
</table>

</body>
</html>