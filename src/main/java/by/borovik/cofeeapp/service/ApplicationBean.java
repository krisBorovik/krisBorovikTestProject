package by.borovik.cofeeapp.service;

import by.borovik.cofeeapp.dao.DaoFactory;
import by.borovik.cofeeapp.dao.OrderDao;
import by.borovik.cofeeapp.entity.Order;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import java.util.List;

@Named("ApplicationBean")
@ManagedBean
@ApplicationScoped
public class ApplicationBean {
    public List<Order> getAllOrders(){
        return DaoFactory.getInstance().getOrderDao().getOrdersList();
    }

    public String deleteOrder(){
        String msg = "Order deleted successfully";
        String orderId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        boolean answer = DaoFactory.getInstance().getOrderDao().deleteOrder(orderId);
        if(!answer){
            msg = "Order havn't been deleted";
        }
        FacesMessage facesMessage = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(msg, facesMessage);
        return "menu";
    }
    public int getNumber(){
            return DaoFactory.getInstance().getOrderDao().getOrdersList().size();
    }

    public  Order  getOrderByID(String id){
        String orderId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        return DaoFactory.getInstance().getOrderDao().getOrderByID(orderId);
    }

    public boolean updateOrder(){
        return false;
    }
}
