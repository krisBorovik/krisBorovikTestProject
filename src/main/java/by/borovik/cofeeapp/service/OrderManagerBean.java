package by.borovik.cofeeapp.service;

import by.borovik.cofeeapp.entity.Order;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;
public class OrderManagerBean {
    @PersistenceContext
    private EntityManager orderManager;


    public OrderManagerBean() {
        EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
        this.orderManager = sessionFactory.createEntityManager();
    }

    public List<Order> loadAllCustomers() {
        orderManager.getTransaction().begin();
        return this.orderManager.createQuery("SELECT o FROM Order as o", Order.class).getResultList();

    }



    public void delete(Order order) {
        if (orderManager.contains(order)) {
            orderManager.remove(order);
        } else {
            Order managedCustomer = orderManager.find(Order.class, order.getId());
            if (managedCustomer != null) {
                orderManager.remove(managedCustomer);
            }
        }
    }

    public void addNewOrder(Order order) {
      /*   SessionFactory factory;
         ServiceRegistry serviceRegistry;
        Configuration config = new Configuration();
        config.configure();
        config.addAnnotatedClass(Order.class);
        config.addResource("Student.hbm.xml");
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factory = config.buildSessionFactory(serviceRegistry);*/
        Order newOrder = new Order();
        newOrder.setDate(order.getDate());
        newOrder.setCoffeeType(order.getCoffeeType());
        newOrder.setNumber(order.getNumber());
        newOrder.setDeliveryType(order.getDeliveryType());
        newOrder.setId(UUID.randomUUID().toString().substring(0, 8));
        orderManager.getTransaction().begin();
        this.orderManager.persist(newOrder);
        orderManager.getTransaction().commit();
        orderManager.close();
    }

    public void update(List<Order> orders) {
        orders.forEach(orderManager::merge);
    }

}



