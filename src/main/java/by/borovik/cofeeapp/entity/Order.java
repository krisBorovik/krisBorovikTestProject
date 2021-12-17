package by.borovik.cofeeapp.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table (name="orders")
public class Order implements Serializable {
 public static final long  SerialVersionUID = 1L;

 @Id
 @Column(unique = true,nullable = false)
 private String id;
    @Column(nullable = false)

 private String coffeeType;
    @Column(nullable = false)

 private Integer number;
    @Column(nullable = false)

 private String deliveryType;
    @Column(nullable = false)

 private String date;

    public Order() {
    }

    public Order(String id, String coffeeType, Integer number, String deliveryType,String date) {
        this.id = id;
        this.coffeeType = coffeeType;
        this.number = number;
        this.deliveryType = deliveryType;
        this.date=date;
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
        this.coffeeType = coffeeType;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDeliveryType() {
        return deliveryType;
    }
;
    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public Integer countPrice(){
        int price=1;
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (getClass()!=o.getClass()) return false;
        Order order = (Order) o;
        if (!Objects.equals(this.id,order.id)) return false;
        return true;
    }

    @Override
    public int hashCode() {
      int hash=3;
      hash= 97 * hash + Objects.hashCode(this.id);
      return hash;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", coffeeType=" + coffeeType +
                ", number=" + number +
                ", deliveryType=" + deliveryType +
                ", date=" + date +
                '}';
    }
}
