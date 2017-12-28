<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/profitAndLoss.css">
</head>
<body>
<a href="/">Back</a>
<h1>Справочник статей отчета оприбыли и убытках</h1>

<header class="header">

    <form class="sigh-in-form" method="post">

        <div class="form-group-plItems">
            <label for="ParentName">Группа:</label>
            <input type="text" autocomplete="off" name="fItemName" class="form-input-item" id="ParentName"
                   placeholder="" list="pname">
            <datalist id="pname">
                <select>
                    <option>none</option>
                    <c:forEach var="item" items="${list}">
                        <option value="${item.nameItem}">${item.nameItem}</option>
                    </c:forEach>
                </select>
            </datalist>
        </div>

        <div class="form-group-plItems">
            <label for="kodItem">Kod</label>
            <input type="text" class="form-input-id" id="kodItem" name="kodItem">
        </div>

        <div class="form-group-plItems">
            <label for="item">Item</label>
            <input type="text" class="form-input-item" id="item" name="item" placeholder="">
        </div>

        <div class="form-group-plItems">
            <label for="type">Item type</label>
            <input type="text" class="form-input-item" id="type" name="type" placeholder="">
        </div>

        <div class="form-group-plItems">
            <label class="form-check-label" for="level"> Down level </label>
            <input type="checkbox" class="form-check-input" id="level" name="level">
        </div>

        <input type="submit" class="btnSaveItem" value="Add" formaction="/addProfitAndLossItem"/>

        <%--<input type="submit" class="btn btn-primary" value="Delete" formaction="/delCashFlowItem"/>--%>

    </form>


    <table class="table">
        <tr class="table-head">
            <td>Kod</td>
            <td>Item</td>
            <td>Type</td>
            <td>Level (Down)</td>
        </tr>


        <form class="" method="post">

            <c:forEach var="item" items="${list}">
                <tr class="table-light">
                    <form method="post">
                        <td><input type="text" class="form-invput-item" name="fkodn" value="${item.fasadKodItem}"></td>
                        <td><input type="text" class="form-input-item" name="itemn" value="${item.nameItem}"></td>
                        <td><input type="text" class="form-input-item" name="typen" value="${item.typeItem}"></td>
                        <td><input type="text" class="form-input-item" name="leveln" value="${item.levelItem}"></td>
                        <td>
                            <input class="btnUpItem" type="submit" value="up"
                                   formaction="/profitAndLoss/up/${item.idPl}"/>
                        </td>
                    </form>

                    <form method="post">
                        <td>
                            <input class="btnDelItem" type="submit" value="del"
                                   formaction="/profitAndLoss/del/${item.idPl}"/>
                        </td>
                    </form>

                </tr>
            </c:forEach>
        </form>

    </table>
</header>
</body>
</html>