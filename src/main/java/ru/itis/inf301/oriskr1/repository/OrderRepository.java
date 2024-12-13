package ru.itis.inf301.oriskr1.repository;
import ru.itis.inf301.oriskr1.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private final DBConnection db = DBConnection.getInstance();

    public Order findById(Long id) {
        try (Connection connection = db.getConnection()) {
            Order order = new Order();
            PreparedStatement statement = connection.prepareStatement(
                    "select * from orders where id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                order = new Order(
                        resultSet.getLong("id"),
                        resultSet.getString("dish_list"),
                        resultSet.getInt("table_number"),
                        resultSet.getString("waiter")
                );
            }

            resultSet.close();
            statement.close();
            return order;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();

        try (Connection connection = db.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "select * from orders ");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                Order order = new Order(
                        resultSet.getLong("id"),
                        resultSet.getString("dish_list"),
                        resultSet.getInt("table_number"),
                        resultSet.getString("waiter")
                );
                orders.add(order);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }
}