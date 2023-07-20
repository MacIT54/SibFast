package ru.cft.shift.intensive.template.repository.entity;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("products")
public class Products {
    @PrimaryKey
    String id;
    @Column
    String name;
    @Column("shop_name")
    String shop;
    @Column
    String address;
    @Column
    Float price;
    @Column
    Integer weight;
    @Column
    String description;
    
    public Products() {
    }

    public Products(String id, String name, String shop, String address, Float price, Integer weight,
            String description) {
        this.id = id;
        this.name = name;
        this.shop = shop;
        this.address = address;
        this.price = price;
        this.weight = weight;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
