package by.borovik.cofeeapp.service;

import by.borovik.cofeeapp.dao.DaoFactory;
import by.borovik.cofeeapp.entity.Order;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Named("OrderBean")
@ManagedBean
@ViewScoped
public class OrderBean implements Serializable {
    private String id;
    private String coffeeType;
    private Integer number;
    private String deliveryType;
    private String date;
    public OrderBean() {
    }

    public OrderBean(String id, String coffeeType, Integer number, String deliveryType, String date) {
        this.id = id;
        this.coffeeType = coffeeType;
        this.number = number;
        this.deliveryType = deliveryType;
        this.date = date;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(String coffeeType) {
        System.out.println("$$$$ print coffee type "+ coffeeType);
        this.coffeeType = coffeeType;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        System.out.println("$$$$ print number "+ number);
        this.number = number;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        System.out.println("$$$$ print deliveryType "+ deliveryType);
        this.deliveryType = deliveryType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String show() {

        return "orderForm";
    }
    @Override
    public String toString() {
        return "OrderBean{" +
                "id='" + id + '\'' +
                ", coffeeType=" + coffeeType +
                ", number=" + number +
                ", deliveryType=" + deliveryType +
                ", date=" + date +
                '}';
    }

    public void setOrder(Order order){
        this.setCoffeeType(order.getCoffeeType());
        this.setDeliveryType(order.getDeliveryType());
        this.setNumber(order.getNumber());
        this.setDate(order.getDate());
        this.setID(order.getId());
    }

    private void setID(String id) {
        this.id =id;
    }

    public String addValidOrder(){
        boolean added = true; //вставить проверку валидаторами
        String outcome = null;
        String uiid = UUID.randomUUID().toString().substring(0, 8);
        if(this.id != null){
            uiid =this.id;
        }
        System.out.println("$$$$ id " + this.id);
        System.out.println("$$$$ id " + this.id);
        boolean answer = DaoFactory.getInstance().getOrderDao().addData(new Order(uiid,
                this.coffeeType, this.number, this.deliveryType, LocalDateTime.now().toString()));
        return outcome;
    }


}


