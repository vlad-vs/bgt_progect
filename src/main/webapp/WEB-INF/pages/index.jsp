<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="container">
    <a href="/users">Users guide</a>
    <br>
    <a href="/cashFlow">Cash flow guide</a>
    <br>
    <a href="/balance">Balance guide</a>
    <br>
    <a href="/profitAndLoss">Profit and loss guide</a>
    <br>
    <a href="/currency">Currency guide</a>
    <br>
    <a href="/year">Year guide</a>
    <br>
    <a href="/bgt">Bgt Guide</a>
    <br>
    <a href="/company">Company Guide</a>
    <br>
    <a href="/standartBgt">Standart bgt</a>
    <br>
    <a href="/units">UNITS</a>
    <br>
    <a href="/operationToPlAndCfReport">UNITS</a>




</div>
<br>
<br>
<br>
<br>
<br>

<%--<h1>Form</h1>--%>

<%--<table>--%>
    <%--<form:form action="/cfItem" method="post" commandName="cfItem">--%>
    <%--<tr>  <td>Country Name:</td> <td><form:input path="cashFlowItem"/> </td> </tr>--%>
    <%--<tr> <td> PM Name :</td> <td><form:input path="kodCashFlowItem"/> </td> </tr>--%>
    <%--<tr> <td colspan=2>   <form:button type="submit"/></td>--%>
        <%--</form:form>--%>
<%--</table>--%>

<%--${cfItem}--%>

</body>
</html>