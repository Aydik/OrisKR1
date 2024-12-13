<%@ page import="ru.itis.inf301.oriskr1.model.Order" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Управление заказами</title>
    <meta charset="utf-8"/>

    <style type="text/css">
        .header {
            display: flex;
            justify-content: center;
        }

        .content {
            width: 100%;
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
        }

        .leftblock {
            flex-grow: 1;
        }

        .centerblock {
            flex-grow: 8;
        }

        .rigthblock {
            flex-grow: 1;
        }
    </style>
</head>
<body>
<div class="header">
    <h1>Управление заказами</h1>
</div>
<div class="content">
    <div class="leftblock"></div>
    <div class="centerblock">
        <h2>Список заказов</h2>
        <table border="1">
            <thead>
            <tr>
                <th>Номер заказа</th>
                <th>Столик</th>
            </tr>
            </thead>
            <tbody>
            
            <%
                List<Order> orders = (List<Order>) request.getAttribute("orders");
                for (var order: orders) {

            %>
            <tr>
                <td><a href="/order?id=<%=order.getId()%>"><%=order.getId()%></a></td>
                <td><%=order.getTableNumber()%></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
    <div class="rigthblock"></div>
</div>
</body>
</html>