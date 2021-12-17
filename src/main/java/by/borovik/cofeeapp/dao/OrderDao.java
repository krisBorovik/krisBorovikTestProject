package by.borovik.cofeeapp.dao;

import by.borovik.cofeeapp.entity.Order;

import java.util.List;

public interface OrderDao {
    boolean addData(Order order);

    boolean isOrderExist(String id);

    List<Order> getOrdersList();

    Boolean deleteOrder(String id);

    Order getOrderByID(String id);
}
