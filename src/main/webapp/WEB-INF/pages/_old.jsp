<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/standartBgt.css">
</head>
<body>
<a href="/">Back</a>

<h1>Standart BGT</h1>

<div class="wrapper element1">

    <h1>
        Наименование бюджета
    </h1>

    <header class="header">

        <div class="form-group">
            <span for="year">Год планирования</span>
            <select class="inVal">
                <option value="Выберите год">Выберите год</option>
                <c:forEach var="year" items="${listYears}">
                    <option value="${year.year}></option>
                </c:forEach>
            </select>

        </div>
			<span>

				<br>
				Наименование ЦФО_0
				<br>
				Наименование ЦФО_1
				<br>
				Наименование ЦФО_2
				<br>
				Ответственный
				<br>
			</span>
    </header>

<body>
    <table>
                <tr>
                    <td class="nameCol" rowspan="2">Комментарий</td>
                    <td class="nameCol" rowspan="2">Операция</td>
                    <td class="nameCol" rowspan="2">Нач/Опл</td>
                    <td class="nameCol" rowspan="2">Вал</td>
                    <td colspan="4">Январь</td>
                    <td colspan="4">Февраль</td>
                    <td colspan="4">Март</td>
                    <td colspan="4">Апрель</td>
                    <td colspan="4">Май</td>
                    <td colspan="4">Июнь</td>
                    <td colspan="4">Июль</td>
                    <td colspan="4">Август</td>
                    <td colspan="4">Сентябрь</td>
                    <td colspan="4">Октябрь</td>
                    <td colspan="4">Ноябрь</td>
                    <td colspan="4">Декабрь</td>
                </tr>

                <tr>
                    <td class="nameColNumbers">Q</td>
                    <td class="nameColNumbers">P</td>
                    <td class="nameColNumbers">USD</td>
                    <td class="nameColNumbers">UAH</td>

                    <td class="nameColNumbers">Q</td>
                    <td class="nameColNumbers">P</td>
                    <td class="nameColNumbers">USD</td>
                    <td class="nameColNumbers">UAH</td>

                    <td class="nameColNumbers">Q</td>
                    <td class="nameColNumbers">P</td>
                    <td class="nameColNumbers">USD</td>
                    <td class="nameColNumbers">UAH</td>

                    <td class="nameColNumbers">Q</td>
                    <td class="nameColNumbers">P</td>
                    <td class="nameColNumbers">USD</td>
                    <td class="nameColNumbers">UAH</td>

                    <td class="nameColNumbers">Q</td>
                    <td class="nameColNumbers">P</td>
                    <td class="nameColNumbers">USD</td>
                    <td class="nameColNumbers">UAH</td>

                    <td class="nameColNumbers">Q</td>
                    <td class="nameColNumbers">P</td>
                    <td class="nameColNumbers">USD</td>
                    <td class="nameColNumbers">UAH</td>

                    <td class="nameColNumbers">Q</td>
                    <td class="nameColNumbers">P</td>
                    <td class="nameColNumbers">USD</td>
                    <td class="nameColNumbers">UAH</td>

                    <td class="nameColNumbers">Q</td>
                    <td class="nameColNumbers">P</td>
                    <td class="nameColNumbers">USD</td>
                    <td class="nameColNumbers">UAH</td>

                    <td class="nameColNumbers">Q</td>
                    <td class="nameColNumbers">P</td>
                    <td class="nameColNumbers">USD</td>
                    <td class="nameColNumbers">UAH</td>

                    <td class="nameColNumbers">Q</td>
                    <td class="nameColNumbers">P</td>
                    <td class="nameColNumbers">USD</td>
                    <td class="nameColNumbers">UAH</td>

                    <td class="nameColNumbers">Q</td>
                    <td class="nameColNumbers">P</td>
                    <td class="nameColNumbers">USD</td>
                    <td class="nameColNumbers">UAH</td>

                    <td class="nameColNumbers">Q</td>
                    <td class="nameColNumbers">P</td>
                    <td class="nameColNumbers">USD</td>
                    <td class="nameColNumbers">UAH</td>


                </tr>

                <tr>
                    <td class="inVal" rowspan="2">Расходы на канцтовары</td>
                    <td class="inVal" rowspan="2">

                        <select class="inVal">
                            <option value="Выберите операцию">Выберите операцию</option>
                            <option value="Покупка канцтоваров">Покупка канцтоваров</option>
                            <option value="Проезд">Проезд</option>
                            <option value="ГСМ">ГСМ</option>
                            <option value="Проживание">Проживание</option>
                        </select>


                        <!-- 					 <form action="select1.php" method="post">
                                               <p><select size="0" multiple name="hero[]">
                                                <option disabled>Выберите операцию</option>
                                                <option value="Покупка канцтоваров">Покупка канцтоваров</option>
                                                <option selected value="Проезд">Проезд</option>
                                                <option value="Шапокляк">ГСМ</option>
                                                <option value="Проживание">Проживание</option>
                                               </select></p>
                                               <p><input type="submit" value="Отправить"></p>
                                            </form> -->
                    </td>

                    <td class="inVal" rowspan="2">

                        <select class="inVal">
                            <option value="Валюта">Валюта</option>
                            <option value="USD">USD</option>
                            <option value="UAH">UAH</option>
                        </select>

                    </td>

                    <td class="inVal">PL</td>

                    <td class="inVal">
                        <input class="inputQ" type="text" name="kol" placeholder=""/>
                    </td>

                    <td class="inVal">
                        <input class="inputP" type="text" name="price" placeholder=""/>
                    </td>

                    <td class="inVal">
                        <input class="inputUSD" type="text" name="usd" placeholder=""/>
                    </td>

                    <td class="inVal">
                        <input class="inputUAH" type="text" name="uah" placeholder=""/>
                    </td>

                    <td class="inVal">К</td>
                    <td class="inVal">С</td>
                    <td class="inVal">USD</td>
                    <td class="inVal">UAH</td>

                    <td class="inVal">К</td>
                    <td class="inVal">С</td>
                    <td class="inVal">USD</td>
                    <td class="inVal">UAH</td>

                    <td class="inVal">К</td>
                    <td class="inVal">С</td>
                    <td class="inVal">USD</td>
                    <td class="inVal">UAH</td>

                    <td class="inVal">К</td>
                    <td class="inVal">С</td>
                    <td class="inVal">USD</td>
                    <td class="inVal">UAH</td>

                    <td class="inVal">К</td>
                    <td class="inVal">С</td>
                    <td class="inVal">USD</td>
                    <td class="inVal">UAH</td>

                    <td class="inVal">К</td>
                    <td class="inVal">С</td>
                    <td class="inVal">USD</td>
                    <td class="inVal">UAH</td>

                    <td class="inVal">К</td>
                    <td class="inVal">С</td>
                    <td class="inVal">USD</td>
                    <td class="inVal">UAH</td>

                    <td class="inVal">К</td>
                    <td class="inVal">С</td>
                    <td class="inVal">USD</td>
                    <td class="inVal">UAH</td>

                    <td class="inVal">К</td>
                    <td class="inVal">С</td>
                    <td class="inVal">USD</td>
                    <td class="inVal">UAH</td>

                    <td class="inVal">К</td>
                    <td class="inVal">С</td>
                    <td class="inVal">USD</td>
                    <td class="inVal">UAH</td>

                    <td class="inVal">К</td>
                    <td class="inVal">С</td>
                    <td class="inVal">USD</td>
                    <td class="inVal">UAH</td>
                </tr>
                <td class="inVal">CF</td>

                <td class="inVal">К</td>
                <td class="inVal">С</td>
                <td class="inVal">USD</td>
                <td class="inVal">UAH</td>

                <td class="inVal">К</td>
                <td class="inVal">С</td>
                <td class="inVal">USD</td>
                <td class="inVal">UAH</td>

                <td class="inVal">К</td>
                <td class="inVal">С</td>
                <td class="inVal">USD</td>
                <td class="inVal">UAH</td>

                <td class="inVal">К</td>
                <td class="inVal">С</td>
                <td class="inVal">USD</td>
                <td class="inVal">UAH</td>

                <td class="inVal">К</td>
                <td class="inVal">С</td>
                <td class="inVal">USD</td>
                <td class="inVal">UAH</td>

                <td class="inVal">К</td>
                <td class="inVal">С</td>
                <td class="inVal">USD</td>
                <td class="inVal">UAH</td>

                <td class="inVal">К</td>
                <td class="inVal">С</td>
                <td class="inVal">USD</td>
                <td class="inVal">UAH</td>

                <td class="inVal">К</td>
                <td class="inVal">С</td>
                <td class="inVal">USD</td>
                <td class="inVal">UAH</td>

                <td class="inVal">К</td>
                <td class="inVal">С</td>
                <td class="inVal">USD</td>
                <td class="inVal">UAH</td>

                <td class="inVal">К</td>
                <td class="inVal">С</td>
                <td class="inVal">USD</td>
                <td class="inVal">UAH</td>

                <td class="inVal">К</td>
                <td class="inVal">С</td>
                <td class="inVal">USD</td>
                <td class="inVal">UAH</td>

                <td class="inVal">К</td>
                <td class="inVal">С</td>
                <td class="inVal">USD</td>
                <td class="inVal">UAH</td>
                </select>
                </table>

        </div>

</body>
</html>