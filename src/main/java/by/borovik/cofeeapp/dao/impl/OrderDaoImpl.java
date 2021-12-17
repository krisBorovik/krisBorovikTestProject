package by.borovik.cofeeapp.dao.impl;

import by.borovik.cofeeapp.dao.OrderDao;
import by.borovik.cofeeapp.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private static  OrderDaoImpl orderDao;
    public static Configuration configuration = new Configuration().configure();
    SessionFactory sessions = configuration.buildSessionFactory();


    public static OrderDaoImpl getInstance() {
        if (orderDao == null) {
            orderDao = new OrderDaoImpl();
        }
        return orderDao;
    }


    public boolean addData(Order order){
        try(Session session = sessions.openSession();){
            Transaction tx = session.beginTransaction();
            session.save(order);
            tx.commit();
        }
        return isOrderExist(order.getId());
    }

    public boolean isOrderExist(String id){
        boolean answer = false;
        try(Session session = sessions.openSession();){
            Query query = session.createQuery("from Order where id = :paramName");
            query.setParameter("paramName", id);
            List list = query.list();
            answer = !list.isEmpty();
        }
        return answer;
    }

    @Override
    public List<Order> getOrdersList() {
        System.out.println("$$$$$$ inside dao");
        List answer = null;
        try(Session session = sessions.openSession();){
            Query query = session.createQuery("from Order");
            answer = query.list();
        }
        return (List<Order>)answer;
    }

    @Override
    public Boolean deleteOrder(String id) {
        boolean answer = false;
        try(Session session = sessions.openSession();){
            Transaction tx = session.beginTransaction();
            answer = session.createQuery("delete Order where id = :param").setString("param", id).executeUpdate() == 0;
            tx.commit();
        }
        return !isOrderExist(id);

    }

    @Override
    public Order getOrderByID(String id) {
        Order answer = null;
        try(Session session = sessions.openSession();){
            Query query = session.createQuery("from Order where id = :paramName");
            query.setParameter("paramName", id);
            List list = query.list();
            answer = (Order) list.get(0);
        }
        return answer;
    }

}
