package ru.itis.inf301.oriskr1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.itis.inf301.oriskr1.service.OrderService;

import java.io.IOException;

@WebServlet("/order")
public class OrderPageServlet extends HttpServlet {

    private final OrderService service = new OrderService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try{
            request.setAttribute("order", service.findById(Long.parseLong(
                    request.getParameter("id"))));
            request.getRequestDispatcher("WEB-INF/template/order.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }


    }

}