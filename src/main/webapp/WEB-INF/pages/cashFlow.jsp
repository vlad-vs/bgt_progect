<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>CF_Guide</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/cashFlow.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<header class="header">

    <a href="/">Back</a>
    <h1>Cash flow items guide</h1>

</header>

<br>

<form action="/addCashFlowItem" method="post">
    <div class="form-group-cfItems">
        <label for="ParentName">Group:</label>
        <input type="text" autocomplete="off" name="fItemName" class="form-input-item" id="ParentName" placeholder=""
               list="pname">
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
        <label for="kodItem">Kod:</label>
        <input type="text" class="form-input-id" id="kodItem" name="kodItem">
    </div>

    <div class="form-group-cfItems">
        <label for="item">Item name:</label>
        <input type="text" class="form-input-item" id="item" name="item" placeholder="">
    </div>

    <div class="form-group-cfItems">
        <label class="form-check-label" for="level">Level:</label>
        <input type="checkbox" class="form-check-input" id="level" name="level">
    </div>

    <input type="submit" class="btnSaveItem" value="Save"/>

    <%--<input type="submit" class="btn btn-primary" value="Delete" formaction="/delCashFlowItem/"/>--%>
</form>

<%--<table class="table">--%>
    <%--<tr class="table-head">--%>
        <%--<td>Код</td>--%>
        <%--<td>Статья</td>--%>
        <%--<td>Нижний уровень</td>--%>
    <%--</tr>--%>
    <%--<c:forEach var="list" items="${list}">--%>
        <%--<tr class="table-light">--%>
            <%--<form method="post">--%>
                <%--<td><input type="text" class="form-input-table" name="fKod"--%>
                           <%--value="${list.fasadKodCashFlowItem}"/></td>--%>
                <%--<td><input type="text" class="form-input-table" name="name"--%>
                           <%--value="${list.cashFlowItem}"/></td>--%>
                <%--<td><input type="text" class="form-check-table" name="level"--%>
                           <%--value="${list.cashFlowItemLevel}"/></td>--%>
                <%--<td>--%>
                    <%--<input class="btnUpItem" type="submit" value="up" formaction="/cashFlow/up/${list.idCf}"/>--%>
                <%--</td>--%>
            <%--</form>--%>

            <%--<form method="post">--%>
                <%--<td>--%>
                    <%--<input class="btnDelItem" type="submit" value="del" formaction="/cashFlow/del/${list.idCf}/"/>--%>
                <%--</td>--%>
            <%--</form>--%>

        <%--</tr>--%>
    <%--</c:forEach>--%>
<%--</table>--%>

<script>

    render();

    function render() {
        let namesColumn = {
            idCf: false,
            cashFlowItem: 'Item name',
            fasadKodCashFlowItem: 'Kod',
            kodCashFlowItem: false,
            cashFlowItemLevel: false
        };

        let j = ${jsonString};

        renderTable(j, namesColumn);
    }


    function renderTable(jsonObj, tableNames) {
        let tableHeader = renderTableHeader(jsonObj, tableNames);
        let tableBody = renderTableBody(jsonObj, tableNames);
        document.body.innerHTML += '<table>' + tableHeader + tableBody + '</table>';
    }

    function renderTableBody(jsonObj, tableNames) {
        let tableBody = '';
        let rowsCount = jsonObj.length;
        for (let i = 0; i < rowsCount; i++) {
            let id = jsonObj[i]['idCf'];
            tableBody += '<tr>' + renderColum(jsonObj[i], tableNames) + '<td>' + '<input class="upButton"  id="' + id + '" type="submit" value="update"></td>' + '</form>' + '<form method="post">' + '<td><input class="delButton" id = "' + id + '" type = "submit" value = "delete">' + '</td>' + '</form>' + '</tr>';
        }
        return tableBody;
    }

    //todo сделать рекурсивно
    function renderColum(Obj, tableNames) {
        let tableBodyRow = '';

        for (let keyObj in Obj) {
            let val = Obj[keyObj];
            for (let key in tableNames) {
                if (keyObj === key && tableNames[key] !== false) {
                    if (typeof val === 'object') {
                        val = addListOption(val);
                        tableBodyRow += '<td>' + val + '</td>';
                        break
                    } else {
                        tableBodyRow += '<td><input class="tableInput" type="text" value="' + val + '"></td>';
                        break
                    }
                }
            }
        }
        return tableBodyRow;
    }

    function renderTableHeader(jsonObj, tableNames, tableHeader) {
        tableHeader = '';
        if (jsonObj) {
            for (let keyObj in jsonObj[0]) {
                for (let key in tableNames) {
                    if (keyObj === key && tableNames[key] !== false) {
                        tableHeader += '<td class="tableHeader">' + tableNames[key] + '</td>';
                        break
                    }
                }
            }
        }
        return tableHeader;
    }

    function addListOption(Obj) {
        let strList = '';
        for (let key in Obj) {
            strList += '<option value="">' + key + '</option>';
        }
        strList = '<select>' + strLists + '</select>';
        return strList;
    }


</script>

<script>
    $('.delButton').on('click', function (event) {
        let elem = event.target;
        let row = elem.parentNode.parentNode;
        let id = $(event.target).attr("id");
        if (id){
            $.post('/cashFlow/del/' + id, function (data) {
            });
            row.parentElement.removeChild(row);
        }
    });
</script>


</body>
</html>