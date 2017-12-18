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
        <label for="kodItem">Kod</label>
        <input type="text" class="form-input-id" id="kodItem" name="kodItem">
    </div>

    <div class="form-group">
        <label for="item">Item</label>
        <input type="text" class="form-input-item" id="item" name="item" placeholder="">
    </div>

    <div class="form-group">
        <label for="type">Item type</label>
        <input type="text" class="form-input-item" id="type" name="type" placeholder="">
    </div>

    <div class="form-group">
        <label class="form-check-label" for="level"> Down level </label>
        <input type="checkbox" class="form-check-input" id="level" name="level">
    </div>

    <input type="submit" class="btn btn-primary" value="Add" formaction="/addProfitAndLossItem"/>

    <%--<input type="submit" class="btn btn-primary" value="Delete" formaction="/delCashFlowItem"/>--%>

</form>


<table class="table">
    <tr class="table-head">
        <td>Kod</td>
        <td>Item</td>
        <td>Type</td>
        <td>Level (Down)</td>
        <td>Delete</td>
    </tr>


    <form class="" method="post">

        <c:forEach var="listPlItems" items="${listPlItems}">
            <tr class="table-light">
                <form method="post">
                    <td><input formaction="/profitAndLossGuide/update/${listPlItems.idPl}" type="text"
                               class="form-input-item" id="kodn" name="kodn"
                               value="${listPlItems.kodProfitAndLossItem}"></td>
                    <td><input formaction="/profitAndLossGuide/update/${listPlItems.idPl}" type="text"
                               class="form-input-item" id="itemn" name="itemn" value="${listPlItems.profitAndLossItem}">
                    </td>
                    <td><input formaction="/profitAndLossGuide/update/${listPlItems.idPl}" type="text"
                               class="form-input-item" id="typen" name="typen"
                               value="${listPlItems.profitAndLossItemType}"></td>
                    <td><input formaction="/profitAndLossGuide/update/${listPlItems.idPl}" type="text"
                               class="form-input-item" id="leveln" name="leveln"
                               value="${listPlItems.profitAndLossLevel}"></td>

                        <%--<td>${listPlItems.kodProfitAndLossItem}</td>--%>
                        <%--<td>${listPlItems.profitAndLossItem}</td>--%>
                        <%--<td>${listPlItems.profitAndLossItemType}</td>--%>
                        <%--<td>${listPlItems.profitAndLossLevel}</td>--%>

                    <td>
                            <%--<form method="post">--%>
                        <input type="submit" value="del" formaction="/profitAndLossGuide/del/${listPlItems.idPl}"/>
                            <%--</form>--%>
                    </td>

                    <td>

                        <input type="submit" value="up" formaction="/profitAndLossGuide/update/${listPlItems.idPl}:${listPlItems.profitAndLossItem}:${listPlItems.profitAndLossItemType}:${listPlItems.kodProfitAndLossItem}:${listPlItems.profitAndLossLevel}"/>

                    </td>
                </form>
            </tr>
        </c:forEach>
    </form>

</table>

</body>
</html>