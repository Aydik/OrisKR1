<%@ page import="ru.itis.inf301.oriskr1.model.Order" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Управление заказами</title>
    <meta charset="utf-8"/>
</head>
<body>
<div class="content">
    <div class="centerblock">
        <h1>Заказ</h1>
        <table border="1">
            <tr>
                <td>Номер заказа</td>
                <td>Столик</td>
                <td>Состав заказа</td>
                <td>Официант</td>
            </tr>

            <tr>
                <%
                    Order order = (Order) request.getAttribute("order");
                %>
                <td><%=order.getId()%></td>
                <td><%=order.getTableNumber()%></td>
                <td><%=order.getDish_list()%></td>
                <td><%=order.getWaiter()%></td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>