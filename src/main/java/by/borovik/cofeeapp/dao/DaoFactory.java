package by.borovik.cofeeapp.dao;

import by.borovik.cofeeapp.dao.impl.OrderDaoImpl;

public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();
    private final OrderDao orderDao = OrderDaoImpl.getInstance();

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return instance;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }
}
