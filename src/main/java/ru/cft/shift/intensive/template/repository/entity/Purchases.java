package ru.cft.shift.intensive.template.repository.entity;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("purchases")
public class Purchases {
    @PrimaryKey()
    PurchasesPrimaryKeyClass keyClass;
    @Column
    String destination;
    @Column("condition")
    String state;
    @Column
    Integer weight;
    @Column("shop_name")
    String shop;
    @Column("user_id")
    String user;
    @Column("product_name")
    String productName;
    @Column
    Integer quantity;
    @Column
    String address;
    @Column
    Float price;
    @Column
    String description;
    
    public Purchases() {
    }

    public Purchases(PurchasesPrimaryKeyClass keyClass, String destination, String state, Integer weight, String shop,
            String user, String productName, Integer quantity, String address, Float price, String description) {
        this.keyClass = keyClass;
        this.destination = destination;
        this.state = state;
        this.weight = weight;
        this.shop = shop;
        this.user = user;
        this.productName = productName;
        this.quantity = quantity;
        this.address = address;
        this.price = price;
        this.description = description;
    }

    public PurchasesPrimaryKeyClass getKeyClass() {
        return keyClass;
    }

    public void setKeyClass(PurchasesPrimaryKeyClass keyClass) {
        this.keyClass = keyClass;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    

}